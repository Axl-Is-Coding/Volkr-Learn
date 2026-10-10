package io.rong.imlib.cs;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.ICustomServiceListener;
import io.rong.imlib.IHandler;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.ISendMessageCallback;
import io.rong.imlib.MessageTag;
import io.rong.imlib.ModuleManager;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.CSGroupItem;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.CustomServiceMode;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.CSChangeModeMessage;
import io.rong.message.CSChangeModeResponseMessage;
import io.rong.message.CSEvaluateMessage;
import io.rong.message.CSHandShakeMessage;
import io.rong.message.CSHandShakeResponseMessage;
import io.rong.message.CSLeaveMessage;
import io.rong.message.CSPullEvaluateMessage;
import io.rong.message.CSPullLeaveMessage;
import io.rong.message.CSSuspendMessage;
import io.rong.message.CSTerminateMessage;
import io.rong.message.CSUpdateMessage;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.TextMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CustomServiceManager implements ModuleManager.MessageRouter {
    private static final String TAG = "CustomServiceManager";
    private static CustomServiceManager sIns;
    private List<Class<? extends MessageContent>> csMessages;
    private HashMap<String, CustomServiceProfile> customServiceCache;
    private String failureStr;
    private IHandler libStub;
    private boolean mInitialized;
    private Handler mainHandler;
    private OnHumanEvaluateListener onHumanEvaluateListener;
    private RongIMClient.OnReceiveMessageListener onReceiveMessageListener;
    private String quitStr;

    private static class CustomServiceProfile {
        WeakReference<ICustomServiceListener> customServiceListener;
        ArrayList<CSGroupItem> groupList;
        CustomServiceMode mode;
        String name;
        String pid;
        String portrait;
        boolean showResolveStatus;
        String sid;
        long time;
        String uid;
        String welcome;

        CustomServiceProfile(ICustomServiceListener iCustomServiceListener) {
            this.customServiceListener = new WeakReference<>(iCustomServiceListener);
        }
    }

    private enum EvaluateType {
        EVALUATE_ROBOT(0),
        EVALUATE_HUMAN(1);

        int value;

        EvaluateType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public interface OnHumanEvaluateListener {
        void onHumanEvaluate(JSONObject jSONObject);
    }

    private static class SingletonHolder {
        static CustomServiceManager sIns = new CustomServiceManager();

        private SingletonHolder() {
        }
    }

    public static CustomServiceManager getInstance() {
        return SingletonHolder.sIns;
    }

    private void registerMsg(IHandler iHandler) {
        try {
            for (Class<? extends MessageContent> cls : this.csMessages) {
                String strValue = ((MessageTag) cls.getAnnotation(MessageTag.class)).value();
                iHandler.registerMessageType(cls.getName());
                iHandler.registerCmdMsgType(strValue);
            }
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            RLog.e(TAG, "Exception : \n" + stringWriter.toString());
        } catch (IncompatibleClassChangeError unused) {
            RLog.e(TAG, "IncompatibleClassChangeError.");
        }
    }

    public void evaluateCustomService(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "evaluateCustomService kefuId should not be null!");
            return;
        }
        if (this.customServiceCache.containsKey(str)) {
            CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
            CSEvaluateMessage.Builder builder = new CSEvaluateMessage.Builder();
            if (TextUtils.isEmpty(str2)) {
                str2 = customServiceProfile.sid;
            }
            RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, builder.sid(str2).pid(customServiceProfile.pid).uid(customServiceProfile.uid).type(EvaluateType.EVALUATE_ROBOT.getValue()).setSolveStatus((z ? CustomServiceConfig.CSEvaSolveStatus.RESOLVED : CustomServiceConfig.CSEvaSolveStatus.UNRESOLVED).getValue()).build(), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.20
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    RLog.e(CustomServiceManager.TAG, "evaluateCustomService onError " + errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                }
            });
            return;
        }
        RLog.e(TAG, "evaluateCustomService " + str + " is not started yet!");
    }

    public void init(Context context, RongIMClient.OnReceiveMessageListener onReceiveMessageListener, IHandler iHandler) {
        RLog.i(TAG, "init " + this.mInitialized);
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.csMessages.add(CSHandShakeMessage.class);
            this.csMessages.add(CSHandShakeResponseMessage.class);
            this.csMessages.add(CSChangeModeMessage.class);
            this.csMessages.add(CSChangeModeResponseMessage.class);
            this.csMessages.add(CSSuspendMessage.class);
            this.csMessages.add(CSTerminateMessage.class);
            this.csMessages.add(CSEvaluateMessage.class);
            this.csMessages.add(CSUpdateMessage.class);
            this.csMessages.add(CSPullEvaluateMessage.class);
            this.csMessages.add(CSPullLeaveMessage.class);
            this.csMessages.add(CSLeaveMessage.class);
            this.onReceiveMessageListener = onReceiveMessageListener;
            try {
                this.failureStr = context.getResources().getString(context.getResources().getIdentifier("rc_init_failed", "string", context.getPackageName()));
                this.quitStr = context.getResources().getString(context.getResources().getIdentifier("rc_quit_custom_service", "string", context.getPackageName()));
            } catch (Exception e2) {
                RLog.e(TAG, "init ", e2);
            }
            ModuleManager.addMessageRouter(this);
        }
        this.libStub = iHandler;
        registerMsg(iHandler);
    }

    public void leaveMessageToCustomService(String str, Map<String, String> map, final RongIMClient.OperationCallback operationCallback) {
        CSLeaveMessage cSLeaveMessage = new CSLeaveMessage();
        cSLeaveMessage.setDataSet(map);
        RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, cSLeaveMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.23
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.rong.imlib.ModuleManager.MessageRouter
    public boolean onReceived(Message message, int i, boolean z, int i2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        boolean zContains = this.csMessages.contains(message.getContent().getClass());
        if (zContains) {
            if (message.getContent() instanceof CSHandShakeResponseMessage) {
                final CSHandShakeResponseMessage cSHandShakeResponseMessage = (CSHandShakeResponseMessage) message.getContent();
                final int code = cSHandShakeResponseMessage.getCode();
                final String msg = cSHandShakeResponseMessage.getMsg();
                String targetId = message.getTargetId();
                final CustomServiceProfile customServiceProfile = this.customServiceCache.get(targetId);
                if (customServiceProfile != null && customServiceProfile.time != 0 && message.getSentTime() >= customServiceProfile.time) {
                    if (code == 0 && customServiceProfile.customServiceListener.get() != null) {
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onError(code, TextUtils.isEmpty(msg) ? CustomServiceManager.this.failureStr : msg);
                                }
                            }
                        });
                        return true;
                    }
                    customServiceProfile.mode = cSHandShakeResponseMessage.getMode();
                    customServiceProfile.sid = cSHandShakeResponseMessage.getSid();
                    customServiceProfile.uid = cSHandShakeResponseMessage.getUid();
                    customServiceProfile.pid = cSHandShakeResponseMessage.getPid();
                    customServiceProfile.groupList = cSHandShakeResponseMessage.getGroupList();
                    customServiceProfile.showResolveStatus = cSHandShakeResponseMessage.isReportResolveStatus();
                    this.customServiceCache.put(targetId, customServiceProfile);
                    if (customServiceProfile.customServiceListener.get() != null) {
                        final CustomServiceConfig customServiceConfig = new CustomServiceConfig();
                        customServiceConfig.companyName = cSHandShakeResponseMessage.getCompanyName();
                        customServiceConfig.isBlack = cSHandShakeResponseMessage.isBlack();
                        customServiceConfig.msg = cSHandShakeResponseMessage.getMsg();
                        customServiceConfig.companyIcon = cSHandShakeResponseMessage.getCompanyIcon();
                        customServiceConfig.robotSessionNoEva = cSHandShakeResponseMessage.getRobotSessionNoEva() != null && cSHandShakeResponseMessage.getRobotSessionNoEva().equals("1");
                        customServiceConfig.humanEvaluateList = cSHandShakeResponseMessage.getHumanEvaluateList();
                        customServiceConfig.userTipTime = cSHandShakeResponseMessage.getUserTipTime();
                        customServiceConfig.userTipWord = cSHandShakeResponseMessage.getUserTipWord();
                        customServiceConfig.adminTipTime = cSHandShakeResponseMessage.getAdminTipTime();
                        customServiceConfig.adminTipWord = cSHandShakeResponseMessage.getAdminTipWord();
                        customServiceConfig.isDisableLocation = cSHandShakeResponseMessage.isDisableLocation();
                        customServiceConfig.quitSuspendType = CustomServiceConfig.CSQuitSuspendType.valueOf(cSHandShakeResponseMessage.isSuspendWhenQuit());
                        customServiceConfig.evaluateType = cSHandShakeResponseMessage.getEvaType() == 0 ? CustomServiceConfig.CSEvaType.EVA_SEPARATELY : CustomServiceConfig.CSEvaType.EVA_UNIFIED;
                        customServiceConfig.evaEntryPoint = CustomServiceConfig.CSEvaEntryPoint.valueOf(cSHandShakeResponseMessage.getEntryPoint());
                        customServiceConfig.isReportResolveStatus = cSHandShakeResponseMessage.isReportResolveStatus();
                        customServiceConfig.leaveMessageConfigType = cSHandShakeResponseMessage.getLeaveMessageConfigType() == 0 ? CustomServiceConfig.CSLeaveMessageType.NATIVE : CustomServiceConfig.CSLeaveMessageType.WEB;
                        customServiceConfig.uri = cSHandShakeResponseMessage.getLeaveMessageWebUrl();
                        customServiceConfig.leaveMessageNativeInfo = cSHandShakeResponseMessage.getLeaveMessageNativeInfo();
                        if (cSHandShakeResponseMessage.getAnnounceMsgFlag() == 1) {
                            customServiceConfig.announceMsg = cSHandShakeResponseMessage.getAnnounceMsg();
                        } else {
                            customServiceConfig.announceMsg = "";
                        }
                        if (cSHandShakeResponseMessage.getAnnounceClickFlag() == 1) {
                            customServiceConfig.announceClickUrl = cSHandShakeResponseMessage.getAnnounceClickUrl();
                        } else {
                            customServiceConfig.announceClickUrl = "";
                        }
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onSuccess(customServiceConfig);
                                }
                            }
                        });
                    }
                    String robotLogo = cSHandShakeResponseMessage.getRobotLogo();
                    String robotName = cSHandShakeResponseMessage.getRobotName();
                    String robotHelloWord = cSHandShakeResponseMessage.getRobotHelloWord();
                    customServiceProfile.welcome = robotHelloWord;
                    customServiceProfile.name = robotName;
                    customServiceProfile.portrait = robotLogo;
                    if (cSHandShakeResponseMessage.getMode().equals(CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT) || cSHandShakeResponseMessage.getMode().equals(CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST)) {
                        if (!TextUtils.isEmpty(robotHelloWord)) {
                            TextMessage textMessageObtain = TextMessage.obtain(robotHelloWord);
                            if (robotLogo != null) {
                                textMessageObtain.setUserInfo(new UserInfo(targetId, robotName, Uri.parse(robotLogo)));
                            }
                            RongIMClient.getInstance().insertIncomingMessage(Conversation.ConversationType.CUSTOMER_SERVICE, targetId, targetId, null, textMessageObtain, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imlib.cs.CustomServiceManager.3
                                @Override // io.rong.imlib.RongIMClient.ResultCallback
                                public void onError(RongIMClient.ErrorCode errorCode) {
                                    RLog.e(CustomServiceManager.TAG, "insertMessage , error code : " + errorCode.getValue());
                                }

                                @Override // io.rong.imlib.RongIMClient.ResultCallback
                                public void onSuccess(Message message2) {
                                    if (CustomServiceManager.this.onReceiveMessageListener != null) {
                                        CustomServiceManager.this.onReceiveMessageListener.onReceived(message2, 0);
                                    }
                                }
                            });
                        }
                        if (customServiceProfile.customServiceListener.get() != null) {
                            this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    ICustomServiceListener iCustomServiceListener = customServiceProfile.customServiceListener.get();
                                    if (iCustomServiceListener != null) {
                                        iCustomServiceListener.onModeChanged(cSHandShakeResponseMessage.getMode());
                                    }
                                }
                            });
                        }
                    } else if (cSHandShakeResponseMessage.isRequiredChangMode()) {
                        switchToHumanMode(targetId);
                    } else {
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.5
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(cSHandShakeResponseMessage.getMode());
                                }
                            }
                        });
                    }
                    RLog.d(TAG, cSHandShakeResponseMessage.toString());
                }
                return true;
            }
            if (message.getContent() instanceof CSChangeModeResponseMessage) {
                final CSChangeModeResponseMessage cSChangeModeResponseMessage = (CSChangeModeResponseMessage) message.getContent();
                final CustomServiceProfile customServiceProfile2 = this.customServiceCache.get(message.getTargetId());
                if (customServiceProfile2 != null && customServiceProfile2.customServiceListener.get() != null && customServiceProfile2.time != 0 && message.getSentTime() > customServiceProfile2.time && cSChangeModeResponseMessage.getResult() == 1) {
                    int status = cSChangeModeResponseMessage.getStatus();
                    if (status == 1) {
                        customServiceProfile2.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN;
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.6
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile2.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN);
                                }
                            }
                        });
                    } else if (status == 2) {
                        CustomServiceMode customServiceMode = customServiceProfile2.mode;
                        if (customServiceMode != null) {
                            if (customServiceMode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN)) {
                                customServiceProfile2.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE;
                                this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ICustomServiceListener iCustomServiceListener = customServiceProfile2.customServiceListener.get();
                                        if (iCustomServiceListener != null) {
                                            iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE);
                                        }
                                    }
                                });
                            } else if (customServiceProfile2.mode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN_FIRST)) {
                                customServiceProfile2.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST;
                                this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.8
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ICustomServiceListener iCustomServiceListener = customServiceProfile2.customServiceListener.get();
                                        if (iCustomServiceListener != null) {
                                            iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST);
                                        }
                                    }
                                });
                                if (!TextUtils.isEmpty(customServiceProfile2.welcome)) {
                                    TextMessage textMessageObtain2 = TextMessage.obtain(customServiceProfile2.welcome);
                                    if (customServiceProfile2.portrait != null) {
                                        textMessageObtain2.setUserInfo(new UserInfo(message.getTargetId(), customServiceProfile2.name, Uri.parse(customServiceProfile2.portrait)));
                                    }
                                    RongIMClient.getInstance().insertIncomingMessage(Conversation.ConversationType.CUSTOMER_SERVICE, message.getTargetId(), message.getTargetId(), null, textMessageObtain2, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imlib.cs.CustomServiceManager.9
                                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                                        public void onError(RongIMClient.ErrorCode errorCode) {
                                            RLog.e(CustomServiceManager.TAG, "insertMessage , error code : " + errorCode.getValue());
                                        }

                                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                                        public void onSuccess(Message message2) {
                                            if (CustomServiceManager.this.onReceiveMessageListener != null) {
                                                CustomServiceManager.this.onReceiveMessageListener.onReceived(message2, 0);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    } else if (status == 3) {
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.10
                            @Override // java.lang.Runnable
                            public void run() {
                                String errMsg = cSChangeModeResponseMessage.getErrMsg();
                                ICustomServiceListener iCustomServiceListener = customServiceProfile2.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onError(3, errMsg);
                                }
                            }
                        });
                    }
                    if (this.onHumanEvaluateListener != null && !TextUtils.isEmpty(cSChangeModeResponseMessage.getEvaluation())) {
                        try {
                            jSONObject = new JSONObject(cSChangeModeResponseMessage.getEvaluation());
                        } catch (JSONException e2) {
                            e = e2;
                            jSONObject = null;
                        }
                        try {
                            if (jSONObject.has("evaluation") && (jSONArray = jSONObject.optJSONObject("evaluation").getJSONArray("satisfaction")) != null && jSONArray.length() > 0) {
                                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                                if (jSONObjectOptJSONObject.has("isQuestionFlag")) {
                                    customServiceProfile2.showResolveStatus = jSONObjectOptJSONObject.optInt("isQuestionFlag", 0) == 1;
                                }
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            RLog.e(TAG, "onReceive ", e);
                        }
                        this.onHumanEvaluateListener.onHumanEvaluate(jSONObject);
                    }
                }
                return true;
            }
            if (message.getContent() instanceof CSTerminateMessage) {
                CSTerminateMessage cSTerminateMessage = (CSTerminateMessage) message.getContent();
                final CustomServiceProfile customServiceProfile3 = this.customServiceCache.get(message.getTargetId());
                if (customServiceProfile3 != null && customServiceProfile3.customServiceListener.get() != null && cSTerminateMessage.getsid().equals(customServiceProfile3.sid) && customServiceProfile3.time != 0 && message.getSentTime() > customServiceProfile3.time) {
                    if (cSTerminateMessage.getCode() == 0) {
                        final String msg2 = cSTerminateMessage.getMsg();
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.11
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile3.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onQuit(TextUtils.isEmpty(msg2) ? CustomServiceManager.this.quitStr : msg2);
                                }
                            }
                        });
                    } else {
                        customServiceProfile3.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST;
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.12
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile3.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT_FIRST);
                                }
                            }
                        });
                    }
                }
                return true;
            }
            if (message.getContent() instanceof CSUpdateMessage) {
                CSUpdateMessage cSUpdateMessage = (CSUpdateMessage) message.getContent();
                final CustomServiceProfile customServiceProfile4 = this.customServiceCache.get(message.getTargetId());
                if (customServiceProfile4 != null && customServiceProfile4.time != 0 && message.getSentTime() > customServiceProfile4.time) {
                    customServiceProfile4.sid = cSUpdateMessage.getSid();
                    String serviceStatus = cSUpdateMessage.getServiceStatus();
                    byte b2 = -1;
                    switch (serviceStatus.hashCode()) {
                        case 49:
                            if (serviceStatus.equals("1")) {
                                b2 = 0;
                            }
                            break;
                        case 50:
                            if (serviceStatus.equals("2")) {
                                b2 = 1;
                            }
                            break;
                        case 51:
                            if (serviceStatus.equals("3")) {
                                b2 = 2;
                            }
                            break;
                    }
                    if (b2 == 0) {
                        customServiceProfile4.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT;
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.13
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile4.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_ROBOT);
                                }
                            }
                        });
                    } else if (b2 == 1) {
                        customServiceProfile4.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN;
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.14
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile4.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN);
                                }
                            }
                        });
                    } else if (b2 == 2) {
                        customServiceProfile4.mode = CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE;
                        this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.15
                            @Override // java.lang.Runnable
                            public void run() {
                                ICustomServiceListener iCustomServiceListener = customServiceProfile4.customServiceListener.get();
                                if (iCustomServiceListener != null) {
                                    iCustomServiceListener.onModeChanged(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE);
                                }
                            }
                        });
                    }
                }
                return true;
            }
            if (message.getContent() instanceof CSPullEvaluateMessage) {
                final CSPullEvaluateMessage cSPullEvaluateMessage = (CSPullEvaluateMessage) message.getContent();
                final CustomServiceProfile customServiceProfile5 = this.customServiceCache.get(message.getTargetId());
                if (customServiceProfile5 != null && customServiceProfile5.time != 0 && message.getSentTime() > customServiceProfile5.time) {
                    customServiceProfile5.sid = cSPullEvaluateMessage.getMsgId();
                    this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.16
                        @Override // java.lang.Runnable
                        public void run() {
                            ICustomServiceListener iCustomServiceListener = customServiceProfile5.customServiceListener.get();
                            if (iCustomServiceListener != null) {
                                iCustomServiceListener.onPullEvaluation(cSPullEvaluateMessage.getMsgId());
                            }
                        }
                    });
                }
                return true;
            }
            if (message.getContent() instanceof CSPullLeaveMessage) {
                return false;
            }
        }
        return zContains;
    }

    public void sendChangeModelMessage(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "sendChangeModelMessage kefuId should not be null!");
            return;
        }
        if (this.customServiceCache.containsKey(str)) {
            CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
            RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, CSChangeModeMessage.obtain(customServiceProfile.sid, customServiceProfile.uid, customServiceProfile.pid, str2), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.18
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    RongIMClient.getInstance().insertOutgoingMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, null, InformationNotificationMessage.obtain("无人工在线"), null);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                }
            });
        } else {
            RLog.e(TAG, "sendChangeModelMessage " + str + " is not started yet!");
        }
    }

    public void setHumanEvaluateListener(OnHumanEvaluateListener onHumanEvaluateListener) {
        this.onHumanEvaluateListener = onHumanEvaluateListener;
    }

    public void startCustomService(final String str, ICustomServiceListener iCustomServiceListener, CSCustomServiceInfo cSCustomServiceInfo) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startCustomService kefuId should not be null!");
            return;
        }
        HashMap<String, CustomServiceProfile> map = this.customServiceCache;
        if (map != null && map.get(str) != null) {
            this.customServiceCache.remove(str);
        }
        if (cSCustomServiceInfo == null) {
            cSCustomServiceInfo = new CSCustomServiceInfo.Builder().build();
        }
        CSHandShakeMessage cSHandShakeMessage = new CSHandShakeMessage();
        cSHandShakeMessage.setCustomInfo(cSCustomServiceInfo);
        CustomServiceProfile customServiceProfile = new CustomServiceProfile(iCustomServiceListener);
        HashMap<String, CustomServiceProfile> map2 = this.customServiceCache;
        if (map2 != null) {
            map2.put(str, customServiceProfile);
        }
        try {
            Message messageObtain = Message.obtain(str, Conversation.ConversationType.CUSTOMER_SERVICE, cSHandShakeMessage);
            if (this.libStub != null) {
                this.libStub.sendMessage(messageObtain, "", "", new ISendMessageCallback.Stub() { // from class: io.rong.imlib.cs.CustomServiceManager.17
                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onAttached(Message message) throws RemoteException {
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onError(Message message, int i) throws RemoteException {
                        ICustomServiceListener iCustomServiceListener2;
                        CustomServiceProfile customServiceProfile2 = (CustomServiceProfile) CustomServiceManager.this.customServiceCache.get(str);
                        if (customServiceProfile2 == null || (iCustomServiceListener2 = customServiceProfile2.customServiceListener.get()) == null) {
                            return;
                        }
                        iCustomServiceListener2.onError(i, CustomServiceManager.this.failureStr);
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onSuccess(Message message) throws RemoteException {
                        CustomServiceProfile customServiceProfile2 = (CustomServiceProfile) CustomServiceManager.this.customServiceCache.get(str);
                        if (customServiceProfile2 != null) {
                            customServiceProfile2.time = message.getSentTime();
                        }
                    }
                });
            }
        } catch (Exception e2) {
            RLog.e(TAG, "startCustomService ", e2);
        }
    }

    public void stopCustomService(String str) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "stopCustomService kefuId should not be null!");
            return;
        }
        if (this.customServiceCache.containsKey(str)) {
            CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
            RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, CSSuspendMessage.obtain(customServiceProfile.sid, customServiceProfile.uid, customServiceProfile.pid), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.24
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    RLog.e(CustomServiceManager.TAG, "stopCustomService onError " + errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                }
            });
            this.customServiceCache.remove(str);
            return;
        }
        RLog.e(TAG, "stopCustomService " + str + " is not started yet!");
    }

    public void switchToHumanMode(String str) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "switchToHumanMode kefuId should not be null!");
            return;
        }
        if (!this.customServiceCache.containsKey(str)) {
            RLog.e(TAG, "switchToHumanMode " + str + " is not started yet!");
            return;
        }
        final CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
        ArrayList<CSGroupItem> arrayList = customServiceProfile.groupList;
        if (arrayList == null || arrayList.size() <= 0) {
            sendChangeModelMessage(str, null);
        } else {
            this.mainHandler.post(new Runnable() { // from class: io.rong.imlib.cs.CustomServiceManager.19
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<CSGroupItem> arrayList2;
                    ICustomServiceListener iCustomServiceListener = customServiceProfile.customServiceListener.get();
                    if (iCustomServiceListener == null || (arrayList2 = customServiceProfile.groupList) == null || arrayList2.size() <= 0) {
                        return;
                    }
                    iCustomServiceListener.onSelectGroup(customServiceProfile.groupList);
                }
            });
        }
    }

    private CustomServiceManager() {
        this.failureStr = "";
        this.quitStr = "";
        this.csMessages = new ArrayList();
        this.customServiceCache = new HashMap<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mInitialized = false;
    }

    public void evaluateCustomService(String str, int i, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && cSEvaSolveStatus != null) {
            if (!this.customServiceCache.containsKey(str)) {
                RLog.e(TAG, "evaluateCustomService " + str + " is not started yet!");
                return;
            }
            CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
            int value = !customServiceProfile.showResolveStatus ? -1 : cSEvaSolveStatus.getValue();
            CSEvaluateMessage.Builder builder = new CSEvaluateMessage.Builder();
            if (TextUtils.isEmpty(str3)) {
                str3 = customServiceProfile.sid;
            }
            RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, builder.sid(str3).pid(customServiceProfile.pid).uid(customServiceProfile.uid).source(i).setSolveStatus(value).suggest(str2).type(EvaluateType.EVALUATE_HUMAN.getValue()).build(), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.21
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    RLog.e(CustomServiceManager.TAG, "evaluateCustomService onError " + errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                    RLog.d(CustomServiceManager.TAG, "onSuccess.");
                }
            });
            return;
        }
        RLog.e(TAG, "evaluateCustomService kefuId or solveStatus should not be null!");
    }

    public void evaluateCustomService(String str, int i, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str2, String str3, String str4, String str5) {
        EvaluateType evaluateType;
        if (!TextUtils.isEmpty(str) && cSEvaSolveStatus != null) {
            if (!this.customServiceCache.containsKey(str)) {
                RLog.e(TAG, "evaluateCustomService " + str + " is not started yet!");
                return;
            }
            CustomServiceProfile customServiceProfile = this.customServiceCache.get(str);
            CSEvaluateMessage.Builder builder = new CSEvaluateMessage.Builder();
            CustomServiceMode customServiceMode = customServiceProfile.mode;
            if (customServiceMode != CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN && customServiceMode != CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN_FIRST) {
                evaluateType = EvaluateType.EVALUATE_ROBOT;
            } else {
                evaluateType = EvaluateType.EVALUATE_HUMAN;
            }
            int value = !customServiceProfile.showResolveStatus ? -1 : cSEvaSolveStatus.getValue();
            if (TextUtils.isEmpty(str4)) {
                str4 = customServiceProfile.sid;
            }
            RongIMClient.getInstance().sendMessage(Conversation.ConversationType.CUSTOMER_SERVICE, str, builder.sid(str4).pid(customServiceProfile.pid).uid(customServiceProfile.uid).source(i).setSolveStatus(value).tablets(str2).suggest(str3).type(evaluateType.getValue()).extra(str5).build(), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.cs.CustomServiceManager.22
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    RLog.e(CustomServiceManager.TAG, "evaluateCustomService onError " + errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                    RLog.d(CustomServiceManager.TAG, "onSuccess.");
                }
            });
            return;
        }
        RLog.e(TAG, "evaluateCustomService kefuId or solveStatus should not be null!");
    }
}
