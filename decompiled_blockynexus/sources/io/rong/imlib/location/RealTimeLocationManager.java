package io.rong.imlib.location;

import android.content.Context;
import android.content.res.Resources;
import com.tendcloud.tenddata.ab;
import io.rong.common.RLog;
import io.rong.imlib.IHandler;
import io.rong.imlib.MessageTag;
import io.rong.imlib.ModuleManager;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.RealTimeLocation;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.message.RealTimeLocationJoinMessage;
import io.rong.imlib.location.message.RealTimeLocationQuitMessage;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.location.message.RealTimeLocationStatusMessage;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RealTimeLocationManager implements RealTimeLocation.OnRealTimeLocationQuitListener {
    private static final int DEFALUT_MAX_PERTICIPANT = 5;
    private static final String TAG = "RealTimeLocationManager";
    private static final int TIMEOUT_INTERVAL = 30000;
    private Context mContext;
    private boolean mInitialized;
    private HashMap<String, RealTimeInstance> mInsMap;
    private RongIMClient.OnReceiveMessageListener mReceiveMessageListener;
    private List<Class<? extends MessageContent>> mRtMessages;
    private int maxParticipants;
    private String[] supportConversationTypes;

    private static class RealTimeInstance {
        RealTimeLocationObserver observer;
        RealTimeLocation realTimeLocation;

        private RealTimeInstance() {
        }
    }

    private static class SingletonHolder {
        static RealTimeLocationManager sIns = new RealTimeLocationManager();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDeltaTime(long j) {
        return (System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime()) - j;
    }

    public static RealTimeLocationManager getInstance() {
        return SingletonHolder.sIns;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RealTimeLocation getRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        String str2 = conversationType.getName() + str;
        RealTimeInstance realTimeInstance = this.mInsMap.get(str2);
        if (realTimeInstance == null) {
            realTimeInstance = new RealTimeInstance();
            this.mInsMap.put(str2, realTimeInstance);
        }
        if (realTimeInstance.realTimeLocation == null) {
            realTimeInstance.realTimeLocation = new RealTimeLocation(this.mContext, conversationType, str, this.mReceiveMessageListener);
            realTimeInstance.realTimeLocation.addListener(realTimeInstance.observer);
            realTimeInstance.realTimeLocation.setOnRealTimeLocationQuitListener(this);
        }
        return realTimeInstance.realTimeLocation;
    }

    private void registerMessage(IHandler iHandler) {
        try {
            iHandler.registerMessageType(RealTimeLocationStartMessage.class.getName());
            for (Class<? extends MessageContent> cls : this.mRtMessages) {
                String strValue = ((MessageTag) cls.getAnnotation(MessageTag.class)).value();
                iHandler.registerMessageType(cls.getName());
                iHandler.registerCmdMsgType(strValue);
            }
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            RLog.e(TAG, "Exception : \n" + stringWriter.toString());
        }
    }

    public void addListener(Conversation.ConversationType conversationType, String str, RealTimeLocationObserver realTimeLocationObserver) {
        RLog.i(TAG, "addListener");
        String str2 = conversationType.getName() + str;
        RealTimeInstance realTimeInstance = this.mInsMap.get(str2);
        if (realTimeInstance != null) {
            realTimeInstance.observer = realTimeLocationObserver;
        } else {
            realTimeInstance = new RealTimeInstance();
            realTimeInstance.observer = realTimeLocationObserver;
            this.mInsMap.put(str2, realTimeInstance);
        }
        RealTimeLocation realTimeLocation = realTimeInstance.realTimeLocation;
        if (realTimeLocation != null) {
            realTimeLocation.addListener(realTimeLocationObserver);
        }
    }

    public RealTimeLocationConstant.RealTimeLocationStatus getRealTimeLocationCurrentState(Conversation.ConversationType conversationType, String str) {
        RealTimeLocation realTimeLocation;
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        return (realTimeInstance == null || (realTimeLocation = realTimeInstance.realTimeLocation) == null) ? RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE : realTimeLocation.getRealTimeLocationCurrentState();
    }

    public List<String> getRealTimeLocationParticipants(Conversation.ConversationType conversationType, String str) {
        RealTimeLocation realTimeLocation;
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        if (realTimeInstance == null || (realTimeLocation = realTimeInstance.realTimeLocation) == null) {
            return null;
        }
        return realTimeLocation.getParticipants();
    }

    public void init(Context context, RongIMClient.OnReceiveMessageListener onReceiveMessageListener, IHandler iHandler) {
        RLog.i(TAG, "init " + this.mInitialized);
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.mContext = context;
            this.mRtMessages.add(RealTimeLocationStartMessage.class);
            this.mRtMessages.add(RealTimeLocationJoinMessage.class);
            this.mRtMessages.add(RealTimeLocationQuitMessage.class);
            this.mRtMessages.add(RealTimeLocationStatusMessage.class);
            this.mReceiveMessageListener = onReceiveMessageListener;
            ModuleManager.addMessageRouter(new ModuleManager.MessageRouter() { // from class: io.rong.imlib.location.RealTimeLocationManager.1
                @Override // io.rong.imlib.ModuleManager.MessageRouter
                public boolean onReceived(Message message, int i, boolean z, int i2) {
                    boolean zContains = RealTimeLocationManager.this.mRtMessages.contains(message.getContent().getClass());
                    long deltaTime = RealTimeLocationManager.this.getDeltaTime(message.getSentTime());
                    if (zContains && deltaTime < ab.R && i == 0) {
                        MessageContent content = message.getContent();
                        if (content instanceof RealTimeLocationStartMessage) {
                            RealTimeLocation realTimeLocation = RealTimeLocationManager.this.getRealTimeLocation(message.getConversationType(), message.getTargetId());
                            android.os.Message messageObtain = android.os.Message.obtain();
                            messageObtain.what = 3;
                            messageObtain.obj = message.getSenderUserId();
                            realTimeLocation.sendMessage(messageObtain);
                            return false;
                        }
                        if (content instanceof RealTimeLocationJoinMessage) {
                            RealTimeLocation realTimeLocation2 = RealTimeLocationManager.this.getRealTimeLocation(message.getConversationType(), message.getTargetId());
                            android.os.Message messageObtain2 = android.os.Message.obtain();
                            messageObtain2.what = 4;
                            messageObtain2.obj = message.getSenderUserId();
                            realTimeLocation2.sendMessage(messageObtain2);
                        } else if (content instanceof RealTimeLocationQuitMessage) {
                            RealTimeInstance realTimeInstance = (RealTimeInstance) RealTimeLocationManager.this.mInsMap.get(message.getConversationType().getName() + message.getTargetId());
                            if (realTimeInstance != null && realTimeInstance.realTimeLocation != null) {
                                android.os.Message messageObtain3 = android.os.Message.obtain();
                                messageObtain3.what = 5;
                                messageObtain3.obj = message.getSenderUserId();
                                realTimeInstance.realTimeLocation.sendMessage(messageObtain3);
                            }
                        } else if (content instanceof RealTimeLocationStatusMessage) {
                            RealTimeLocation realTimeLocation3 = RealTimeLocationManager.this.getRealTimeLocation(message.getConversationType(), message.getTargetId());
                            android.os.Message messageObtain4 = android.os.Message.obtain();
                            messageObtain4.what = 6;
                            messageObtain4.obj = message;
                            realTimeLocation3.sendMessage(messageObtain4);
                        }
                    }
                    return zContains;
                }
            });
            ModuleManager.addConnectivityStateChangedListener(new ModuleManager.ConnectivityStateChangedListener() { // from class: io.rong.imlib.location.RealTimeLocationManager.2
                @Override // io.rong.imlib.ModuleManager.ConnectivityStateChangedListener
                public void onChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
                    if (connectionStatus == null || !connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT)) {
                        return;
                    }
                    for (RealTimeInstance realTimeInstance : RealTimeLocationManager.this.mInsMap.values()) {
                        RealTimeLocation realTimeLocation = realTimeInstance.realTimeLocation;
                        if (realTimeLocation != null && realTimeLocation.getHandler() != null) {
                            realTimeInstance.realTimeLocation.getHandler().sendEmptyMessage(13);
                        }
                    }
                }
            });
            Resources resources = this.mContext.getResources();
            try {
                this.maxParticipants = resources.getInteger(resources.getIdentifier("rc_max_realtime_location_participants", "integer", this.mContext.getPackageName()));
            } catch (Resources.NotFoundException unused) {
                this.maxParticipants = 5;
            }
            try {
                this.supportConversationTypes = resources.getStringArray(resources.getIdentifier("rc_realtime_support_conversation_types", "array", context.getPackageName()));
            } catch (Exception unused2) {
                RLog.w(TAG, "No conversation type is setup for realtime location.");
            }
        }
        registerMessage(iHandler);
    }

    public int joinRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        RLog.i(TAG, "joinRealTimeLocation " + conversationType.getName() + str);
        if (realTimeInstance == null || realTimeInstance.realTimeLocation == null) {
            RLog.e(TAG, "joinRealTimeLocation No instance!");
            return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_NOT_INIT.getValue();
        }
        List<String> realTimeLocationParticipants = getRealTimeLocationParticipants(conversationType, str);
        if (realTimeLocationParticipants != null && this.maxParticipants <= realTimeLocationParticipants.size()) {
            return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_EXCEED_MAX_PARTICIPANT.getValue();
        }
        realTimeInstance.realTimeLocation.sendMessage(1);
        return !realTimeInstance.realTimeLocation.gpsIsAvailable() ? RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_GPS_DISABLED.getValue() : RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_SUCCESS.getValue();
    }

    @Override // io.rong.imlib.location.RealTimeLocation.OnRealTimeLocationQuitListener
    public void onRealTimeLocationQuit(Conversation.ConversationType conversationType, String str) {
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        if (realTimeInstance != null) {
            realTimeInstance.realTimeLocation.destroy();
            realTimeInstance.realTimeLocation = null;
        }
    }

    public void quitRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        RealTimeLocation realTimeLocation;
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        RLog.i(TAG, "quitRealTimeLocation " + conversationType.getName() + str);
        if (realTimeInstance == null || (realTimeLocation = realTimeInstance.realTimeLocation) == null) {
            return;
        }
        realTimeLocation.sendMessage(2);
        realTimeInstance.observer.onParticipantsQuit(str);
        realTimeInstance.observer.onStatusChange(RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_INCOMING);
    }

    public void removeListener(Conversation.ConversationType conversationType, String str) {
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        if (realTimeInstance != null) {
            realTimeInstance.observer = null;
            RealTimeLocation realTimeLocation = realTimeInstance.realTimeLocation;
            if (realTimeLocation != null) {
                realTimeLocation.deleteListener();
            }
        }
    }

    public int setupRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        RealTimeLocation realTimeLocation;
        RealTimeLocation realTimeLocation2;
        String str2 = conversationType.getName() + str;
        String[] strArr = this.supportConversationTypes;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (conversationType.getName().equals(str3)) {
                    RealTimeInstance realTimeInstance = this.mInsMap.get(str2);
                    if (realTimeInstance == null || (realTimeLocation2 = realTimeInstance.realTimeLocation) == null || realTimeLocation2.getRealTimeLocationCurrentState().equals(RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE)) {
                        return 0;
                    }
                    return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_IS_ON_GOING.getValue();
                }
            }
        } else if (conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            RealTimeInstance realTimeInstance2 = this.mInsMap.get(str2);
            if (realTimeInstance2 == null || (realTimeLocation = realTimeInstance2.realTimeLocation) == null || realTimeLocation.getRealTimeLocationCurrentState().equals(RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE)) {
                return 0;
            }
            return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_IS_ON_GOING.getValue();
        }
        return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_CONVERSATION_NOT_SUPPORT.getValue();
    }

    public int startRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        boolean z;
        String str2 = conversationType.getName() + str;
        RLog.i(TAG, "startRealTimeLocation " + str2);
        if (this.supportConversationTypes != null || !conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            String[] strArr = this.supportConversationTypes;
            if (strArr != null) {
                z = false;
                for (String str3 : strArr) {
                    if (conversationType.getName().equals(str3)) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                return RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_CONVERSATION_NOT_SUPPORT.getValue();
            }
        }
        RealTimeInstance realTimeInstance = this.mInsMap.get(str2);
        if (realTimeInstance == null) {
            realTimeInstance = new RealTimeInstance();
            this.mInsMap.put(str2, realTimeInstance);
        }
        if (realTimeInstance.realTimeLocation == null) {
            realTimeInstance.realTimeLocation = new RealTimeLocation(this.mContext, conversationType, str, this.mReceiveMessageListener);
            realTimeInstance.realTimeLocation.addListener(realTimeInstance.observer);
            realTimeInstance.realTimeLocation.setOnRealTimeLocationQuitListener(this);
        }
        realTimeInstance.realTimeLocation.sendMessage(0);
        return !realTimeInstance.realTimeLocation.gpsIsAvailable() ? RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_GPS_DISABLED.getValue() : RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_SUCCESS.getValue();
    }

    @Deprecated
    public void updateLocation(Conversation.ConversationType conversationType, String str, double d2, double d3) {
        RealTimeLocation realTimeLocation;
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        if (realTimeInstance == null || (realTimeLocation = realTimeInstance.realTimeLocation) == null) {
            RLog.e(TAG, "getRealTimeLocationCurrentState No instance!");
        } else {
            realTimeLocation.updateLocation(d2, d3);
        }
    }

    private RealTimeLocationManager() {
        this.maxParticipants = 5;
        this.supportConversationTypes = null;
        this.mInsMap = new HashMap<>();
        this.mRtMessages = new ArrayList();
        this.mInitialized = false;
    }

    public void updateLocation(Conversation.ConversationType conversationType, String str, double d2, double d3, RealTimeLocationType realTimeLocationType) {
        RealTimeLocation realTimeLocation;
        RealTimeInstance realTimeInstance = this.mInsMap.get(conversationType.getName() + str);
        if (realTimeInstance != null && (realTimeLocation = realTimeInstance.realTimeLocation) != null) {
            realTimeLocation.updateLocationWithType(d2, d3, realTimeLocationType);
        } else {
            RLog.e(TAG, "getRealTimeLocationCurrentState No instance!");
        }
    }
}
