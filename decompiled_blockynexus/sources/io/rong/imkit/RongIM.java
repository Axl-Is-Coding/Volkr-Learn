package io.rong.imkit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.ServerProtocol;
import com.just.agentweb.WebIndicator;
import io.rong.common.RLog;
import io.rong.common.SystemUtils;
import io.rong.eventbus.EventBus;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.FailReason;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imkit.manager.AudioRecordManager;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.manager.SendImageManager;
import io.rong.imkit.manager.SendMediaManager;
import io.rong.imkit.manager.UnReadMessageManager;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.message.CombineMessage;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.notification.MessageNotificationManager;
import io.rong.imkit.plugin.image.AlbumBitmapCacheHelper;
import io.rong.imkit.reference.ReferenceMessageItemProvider;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.KitCommonDefine;
import io.rong.imkit.utils.ImageDownloadManager;
import io.rong.imkit.voiceMessageDownload.HQVoiceMsgDownloadManager;
import io.rong.imkit.widget.provider.CSPullLeaveMsgItemProvider;
import io.rong.imkit.widget.provider.CombineMessageItemProvider;
import io.rong.imkit.widget.provider.DiscussionNotificationMessageItemProvider;
import io.rong.imkit.widget.provider.FileMessageItemProvider;
import io.rong.imkit.widget.provider.GIFMessageItemProvider;
import io.rong.imkit.widget.provider.GroupNotificationMessageItemProvider;
import io.rong.imkit.widget.provider.HQVoiceMessageItemProvider;
import io.rong.imkit.widget.provider.HandshakeMessageItemProvider;
import io.rong.imkit.widget.provider.HistoryDividerMessageProvider;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imkit.widget.provider.ImageMessageItemProvider;
import io.rong.imkit.widget.provider.InfoNotificationMsgItemProvider;
import io.rong.imkit.widget.provider.LocationMessageItemProvider;
import io.rong.imkit.widget.provider.PublicServiceMultiRichContentMessageProvider;
import io.rong.imkit.widget.provider.PublicServiceRichContentMessageProvider;
import io.rong.imkit.widget.provider.RealTimeLocationMessageProvider;
import io.rong.imkit.widget.provider.RecallMessageItemProvider;
import io.rong.imkit.widget.provider.RichContentMessageItemProvider;
import io.rong.imkit.widget.provider.TextMessageItemProvider;
import io.rong.imkit.widget.provider.UnknownMessageItemProvider;
import io.rong.imkit.widget.provider.VoiceMessageItemProvider;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.RongLibConst;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.ConversationStatus;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageConfig;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.RemoteHistoryMsgOption;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.model.UserInfo;
import io.rong.message.GIFMessage;
import io.rong.message.LocationMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.push.RongPushClient;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RongIM {
    public static final int ON_CANCEL_CALLBACK = 102;
    public static final int ON_ERROR_CALLBACK = 103;
    public static final int ON_PROGRESS_CALLBACK = 101;
    public static final int ON_SUCCESS_CALLBACK = 100;
    private static final String TAG = "RongIM";
    private static RongIMClient.ConnectionStatusListener mConnectionStatusListener = new RongIMClient.ConnectionStatusListener() { // from class: io.rong.imkit.RongIM.4
        @Override // io.rong.imlib.RongIMClient.ConnectionStatusListener
        public void onChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
            if (connectionStatus != null) {
                RLog.d(RongIM.TAG, "ConnectionStatusListener onChanged : " + connectionStatus.toString());
                RongIMClient.ConnectionStatusListener connectionStatusListener = RongIM.sConnectionStatusListener;
                if (connectionStatusListener != null) {
                    connectionStatusListener.onChanged(connectionStatus);
                }
                if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
                    SendImageManager.getInstance().reset();
                    SendMediaManager.getInstance().reset();
                }
                if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
                    ResendManager.getInstance().beginResend();
                    if (!RongIM.notificationQuiteHoursConfigured) {
                        RLog.d(RongIM.TAG, "ConnectionStatusListener not get notificationQuietHours, get again");
                        SingletonHolder.sRongIM.getNotificationQuietHours(null);
                    }
                }
                if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SIGN_OUT)) {
                    ResendManager.getInstance().removeAllResendMessage();
                }
                RongContext.getInstance().getEventBus().post(connectionStatus);
            }
        }
    };
    private static MessageInterceptor messageInterceptor;
    private static boolean notificationQuiteHoursConfigured;
    static RongIMClient.ConnectionStatusListener sConnectionStatusListener;
    static RongIMClient.OnReceiveMessageListener sMessageListener;
    private Context mApplicationContext;
    private List<RongIMClient.EncryptedSessionConnectionListener> mEncSessionListeners;
    private Handler mWorkHandler;
    private SamplingRate sampleRate;
    private VoiceMessageType voiceMessageType;

    public interface AsyncInitListener {
        void doAfterInit();

        void doBeforeInit();
    }

    public interface ConversationBehaviorListener {
        boolean onMessageClick(Context context, View view, Message message);

        boolean onMessageLinkClick(Context context, String str);

        boolean onMessageLongClick(Context context, View view, Message message);

        boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo);

        boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo);
    }

    public interface ConversationClickListener {
        boolean onMessageClick(Context context, View view, Message message);

        boolean onMessageLinkClick(Context context, String str, Message message);

        boolean onMessageLongClick(Context context, View view, Message message);

        boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str);

        boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str);
    }

    public interface ConversationListBehaviorListener {
        boolean onConversationClick(Context context, View view, UIConversation uIConversation);

        boolean onConversationLongClick(Context context, View view, UIConversation uIConversation);

        boolean onConversationPortraitClick(Context context, Conversation.ConversationType conversationType, String str);

        boolean onConversationPortraitLongClick(Context context, Conversation.ConversationType conversationType, String str);
    }

    public interface GroupInfoProvider {
        Group getGroupInfo(String str);
    }

    public interface GroupUserInfoProvider {
        GroupUserInfo getGroupUserInfo(String str, String str2);
    }

    public interface IGroupMemberCallback {
        void onGetGroupMembersResult(List<UserInfo> list);
    }

    public interface IGroupMembersProvider {
        void getGroupMembers(String str, IGroupMemberCallback iGroupMemberCallback);
    }

    public interface LocationProvider {

        public interface LocationCallback {
            void onFailure(String str);

            void onSuccess(LocationMessage locationMessage);
        }

        void onStartLocation(Context context, LocationCallback locationCallback);
    }

    public interface MessageInterceptor {
        boolean intercept(Message message);
    }

    public interface OnReceiveUnreadCountChangedListener {
        void onMessageIncreased(int i);
    }

    public interface OnSelectMemberListener {
        void startSelectMember(Context context, Conversation.ConversationType conversationType, String str);
    }

    public interface OnSendMessageListener {
        Message onSend(Message message);

        boolean onSent(Message message, SentMessageErrorCode sentMessageErrorCode);
    }

    public interface PublicServiceBehaviorListener {
        boolean onEnterConversationClick(Context context, PublicServiceProfile publicServiceProfile);

        boolean onFollowClick(Context context, PublicServiceProfile publicServiceProfile);

        boolean onUnFollowClick(Context context, PublicServiceProfile publicServiceProfile);
    }

    public interface PublicServiceProfileProvider {
        PublicServiceProfile getPublicServiceProfile(Conversation.PublicServiceType publicServiceType, String str);
    }

    @Deprecated
    public interface RequestPermissionsListener {
        @Deprecated
        void onPermissionRequest(String[] strArr, int i);
    }

    public enum SamplingRate {
        RC_SAMPLE_RATE_8000(WebIndicator.MAX_UNIFORM_SPEED_DURATION),
        RC_SAMPLE_RATE_16000(16000);

        private int value;

        SamplingRate(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SentMessageErrorCode {
        UNKNOWN(-1, "Unknown error."),
        NOT_IN_DISCUSSION(21406, "not_in_discussion"),
        NOT_IN_GROUP(22406, "not_in_group"),
        FORBIDDEN_IN_GROUP(22408, "forbidden_in_group"),
        NOT_IN_CHATROOM(23406, "not_in_chatroom"),
        REJECTED_BY_BLACKLIST(405, "rejected by blacklist"),
        RC_MSG_BLOCKED_SENSITIVE_WORD(21501, "word is blocked"),
        RC_MSG_REPLACED_SENSITIVE_WORD(21502, "word is replaced"),
        RC_APP_PUBLICSERVICE_UNFOLLOW(29106, "not followed");

        private int code;
        private String msg;

        SentMessageErrorCode(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public static SentMessageErrorCode setValue(int i) {
            for (SentMessageErrorCode sentMessageErrorCode : values()) {
                if (i == sentMessageErrorCode.getValue()) {
                    return sentMessageErrorCode;
                }
            }
            RLog.d("RongIMClient", "SentMessageErrorCode---ErrorCode---code:" + i);
            return UNKNOWN;
        }

        public String getMessage() {
            return this.msg;
        }

        public int getValue() {
            return this.code;
        }
    }

    static class SingletonHolder {
        static RongIM sRongIM = new RongIM();

        SingletonHolder() {
        }
    }

    public interface UserInfoProvider {
        UserInfo getUserInfo(String str);
    }

    public enum VoiceMessageType {
        Ordinary,
        HighQuality
    }

    public static RongIM connect(String str, RongIMClient.ConnectCallback connectCallback) {
        return connect(str, -1, connectCallback);
    }

    private Message filterSendMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent) {
        Message message = new Message();
        message.setConversationType(conversationType);
        message.setTargetId(str);
        message.setContent(messageContent);
        if (RongContext.getInstance() != null) {
            return RongContext.getInstance().getOnSendMessageListener() != null ? RongContext.getInstance().getOnSendMessageListener().onSend(message) : message;
        }
        RLog.e(TAG, "filterSendMessage. RongIM SDK not init, please do after init.");
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void filterSentMessage(io.rong.imlib.model.Message r10, io.rong.imlib.RongIMClient.ErrorCode r11) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.RongIM.filterSentMessage(io.rong.imlib.model.Message, io.rong.imlib.RongIMClient$ErrorCode):void");
    }

    public static RongIM getInstance() {
        return SingletonHolder.sRongIM;
    }

    public static void init(Application application, String str) {
        SingletonHolder.sRongIM.initSDK(application, str, true);
    }

    public static void initAsync(final Context context, final String str, final boolean z, final AsyncInitListener asyncInitListener) {
        SingletonHolder.sRongIM.mWorkHandler.post(new Runnable() { // from class: io.rong.imkit.RongIM.2
            @Override // java.lang.Runnable
            public void run() {
                AsyncInitListener asyncInitListener2 = asyncInitListener;
                if (asyncInitListener2 == null) {
                    SingletonHolder.sRongIM.initSDK(context, str, z);
                    return;
                }
                asyncInitListener2.doBeforeInit();
                SingletonHolder.sRongIM.initSDK(context, str, z);
                asyncInitListener.doAfterInit();
            }
        });
    }

    private void initListener() {
        boolean z;
        RongIMClient.setOnReceiveMessageListener(new RongIMClient.OnReceiveMessageWrapperListener() { // from class: io.rong.imkit.RongIM.5
            @Override // io.rong.imlib.RongIMClient.OnReceiveMessageWrapperListener
            public boolean onReceived(Message message, int i, boolean z2, boolean z3) {
                RongIMClient.OnReceiveMessageListener onReceiveMessageListener = RongIM.sMessageListener;
                boolean zOnReceived = onReceiveMessageListener != null ? onReceiveMessageListener instanceof RongIMClient.OnReceiveMessageWrapperListener ? ((RongIMClient.OnReceiveMessageWrapperListener) onReceiveMessageListener).onReceived(message, i, z2, z3) : onReceiveMessageListener.onReceived(message, i) : false;
                MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag == null || !(messageTag.flag() == 3 || messageTag.flag() == 1)) {
                    if (!zOnReceived) {
                        if (message.getMessageId() > 0) {
                            RongContext.getInstance().getEventBus().post(new Event.OnReceiveMessageEvent(message, i, z2, z3));
                        } else {
                            RongContext.getInstance().getEventBus().post(new Event.MessageLeftEvent(i));
                        }
                    }
                } else {
                    if (RongIM.messageInterceptor != null && RongIM.messageInterceptor.intercept(message)) {
                        return true;
                    }
                    RongContext.getInstance().getEventBus().post(new Event.OnReceiveMessageEvent(message, i, z2, z3));
                    if (message.getContent() != null && message.getContent().getUserInfo() != null) {
                        RongUserInfoManager.getInstance().setUserInfo(message.getContent().getUserInfo());
                    }
                    if (zOnReceived || message.getSenderUserId().equals(RongIM.getInstance().getCurrentUserId())) {
                        return true;
                    }
                    MessageConfig messageConfig = message.getMessageConfig();
                    boolean zIsDisableNotification = messageConfig != null ? messageConfig.isDisableNotification() : false;
                    if (i == 0 && !z2 && !zIsDisableNotification) {
                        MessageNotificationManager.getInstance().notifyIfNeed(RongIM.this.mApplicationContext, message, i);
                        if (!RongIM.notificationQuiteHoursConfigured) {
                            RLog.d(RongIM.TAG, "OnReceiveMessageListener not get notificationQuietHours get again");
                            SingletonHolder.sRongIM.getNotificationQuietHours(null);
                        }
                    }
                }
                RongExtensionManager.getInstance().onReceivedMessage(message);
                return false;
            }
        });
        boolean z2 = false;
        try {
            z = this.mApplicationContext.getResources().getBoolean(R.bool.rc_read_receipt);
        } catch (Resources.NotFoundException e2) {
            RLog.e(TAG, "rc_read_receipt not configure in rc_config.xml");
            e2.printStackTrace();
            z = false;
        }
        if (z) {
            RongIMClient.setReadReceiptListener(new RongIMClient.ReadReceiptListener() { // from class: io.rong.imkit.RongIM.6
                @Override // io.rong.imlib.RongIMClient.ReadReceiptListener
                public void onMessageReceiptRequest(Conversation.ConversationType conversationType, String str, String str2) {
                    RongContext.getInstance().getEventBus().post(new Event.ReadReceiptRequestEvent(conversationType, str, str2));
                }

                @Override // io.rong.imlib.RongIMClient.ReadReceiptListener
                public void onMessageReceiptResponse(Conversation.ConversationType conversationType, String str, String str2, HashMap<String, Long> map) {
                    RongContext.getInstance().getEventBus().post(new Event.ReadReceiptResponseEvent(conversationType, str, str2, map));
                }

                @Override // io.rong.imlib.RongIMClient.ReadReceiptListener
                public void onReadReceiptReceived(Message message) {
                    RongContext.getInstance().getEventBus().post(new Event.ReadReceiptEvent(message));
                }
            });
        }
        try {
            z2 = this.mApplicationContext.getResources().getBoolean(R.bool.rc_enable_sync_read_status);
        } catch (Resources.NotFoundException e3) {
            RLog.e(TAG, "rc_enable_sync_read_status not configure in rc_config.xml");
            e3.printStackTrace();
        }
        if (z2) {
            RongIMClient.getInstance().setSyncConversationReadStatusListener(new RongIMClient.SyncConversationReadStatusListener() { // from class: io.rong.imkit.RongIM.7
                @Override // io.rong.imlib.RongIMClient.SyncConversationReadStatusListener
                public void onSyncConversationReadStatus(Conversation.ConversationType conversationType, String str) {
                    RongContext.getInstance().getEventBus().post(new Event.SyncReadStatusEvent(conversationType, str));
                }
            });
        }
        RongIMClient.setOnRecallMessageListener(new RongIMClient.OnRecallMessageListener() { // from class: io.rong.imkit.RongIM.8
            @Override // io.rong.imlib.RongIMClient.OnRecallMessageListener
            public boolean onMessageRecalled(Message message, RecallNotificationMessage recallNotificationMessage) {
                RongContext.getInstance().getEventBus().post(new Event.RemoteMessageRecallEvent(message.getMessageId(), message.getConversationType(), recallNotificationMessage, true, message.getTargetId()));
                if (recallNotificationMessage == null) {
                    RLog.i(RongIM.TAG, "Delete the recall message, recallNotificationMessage is null");
                    return true;
                }
                MessageTag messageTag = (MessageTag) recallNotificationMessage.getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && ((messageTag.flag() == 3 || messageTag.flag() == 1) && RongIM.notificationQuiteHoursConfigured)) {
                    MessageNotificationManager.getInstance().notifyIfNeed(RongIM.this.mApplicationContext, message, 0);
                }
                return true;
            }
        });
        RongIMClient.getInstance().setOnReceiveDestructionMessageListener(new RongIMClient.OnReceiveDestructionMessageListener() { // from class: io.rong.imkit.RongIM.9
            @Override // io.rong.imlib.RongIMClient.OnReceiveDestructionMessageListener
            public void onReceive(Message message) {
                EventBus.getDefault().post(new Event.MessageDeleteEvent(message.getMessageId()));
            }
        });
        RongIMClient.setConnectionStatusListener(mConnectionStatusListener);
        RongIMClient.getInstance().setConversationStatusListener(new RongIMClient.ConversationStatusListener() { // from class: io.rong.imkit.RongIM.10
            @Override // io.rong.imlib.RongIMClient.ConversationStatusListener
            public void onStatusChanged(ConversationStatus[] conversationStatusArr) {
                if (conversationStatusArr.length == 0) {
                    RLog.i(RongIM.TAG, "length is 0");
                    return;
                }
                if (conversationStatusArr.length == 1) {
                    RongContext.getInstance().setConversationNotifyStatusToCache(ConversationKey.obtain(conversationStatusArr[0].getTargetId(), conversationStatusArr[0].getConversationType()), conversationStatusArr[0].getNotifyStatus());
                }
                EventBus.getDefault().post(conversationStatusArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(Context context, String str, boolean z) {
        this.mApplicationContext = context;
        String currentProcessName = SystemUtils.getCurrentProcessName(context);
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(currentProcessName) && !packageName.equals(currentProcessName)) {
            RLog.w(TAG, "Init. Current process : " + currentProcessName);
            return;
        }
        RLog.i(TAG, "init : " + currentProcessName);
        RongContext.getInstance().initRegister();
        RongConfigurationManager.init(context);
        RongMessageItemLongClickActionManager.getInstance().init();
        initListener();
        if (TextUtils.isEmpty(str)) {
            try {
                str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("RONG_CLOUD_APP_KEY");
                if (TextUtils.isEmpty(str) || !SystemUtils.isValidAppKey(str)) {
                    throw new IllegalArgumentException("can't find RONG_CLOUD_APP_KEY in AndroidManifest.xml.");
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                throw new ExceptionInInitializerError("can't find packageName!");
            }
        }
        RongUserInfoManager.getInstance().init(this.mApplicationContext, str, new RongUserCacheListener());
        RongIMClient.init(context, str, z);
        registerMessageTemplate(new TextMessageItemProvider());
        registerMessageTemplate(new ImageMessageItemProvider());
        registerMessageTemplate(new GIFMessageItemProvider());
        registerMessageTemplate(new LocationMessageItemProvider());
        registerMessageTemplate(new VoiceMessageItemProvider(context));
        registerMessageTemplate(new HQVoiceMessageItemProvider());
        registerMessageTemplate(new DiscussionNotificationMessageItemProvider());
        registerMessageTemplate(new InfoNotificationMsgItemProvider());
        registerMessageTemplate(new RichContentMessageItemProvider());
        registerMessageTemplate(new PublicServiceMultiRichContentMessageProvider());
        registerMessageTemplate(new PublicServiceRichContentMessageProvider());
        registerMessageTemplate(new HandshakeMessageItemProvider());
        registerMessageTemplate(new RecallMessageItemProvider());
        registerMessageTemplate(new FileMessageItemProvider());
        registerMessageTemplate(new GroupNotificationMessageItemProvider());
        registerMessageTemplate(new RealTimeLocationMessageProvider());
        registerMessageTemplate(new UnknownMessageItemProvider());
        registerMessageTemplate(new CSPullLeaveMsgItemProvider());
        registerMessageTemplate(new HistoryDividerMessageProvider());
        registerMessageTemplate(new CombineMessageItemProvider());
        registerMessageTemplate(new ReferenceMessageItemProvider());
        registerMessageType(CombineMessage.class);
        RongExtensionManager.init(context, str);
        RongExtensionManager.getInstance().registerExtensionModule(new DefaultExtensionModule(context));
        InternalModuleManager.init(context);
        InternalModuleManager.getInstance().onInitialized(str);
        AlbumBitmapCacheHelper.init(context);
        ImageDownloadManager.init(context);
        HQVoiceMsgDownloadManager.getInstance().init(context);
        RongNotificationManager.getInstance().init(this.mApplicationContext);
        ImageLoader.getInstance().init(RongContext.getInstance().getDefaultConfig(this.mApplicationContext));
    }

    public static void registerMessageTemplate(IContainerItemProvider.MessageProvider messageProvider) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().registerMessageTemplate(messageProvider);
        }
    }

    public static void registerMessageType(Class<? extends MessageContent> cls) {
        if (RongContext.getInstance() != null) {
            RongIMClient.registerMessageType(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToken(String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(this.mApplicationContext, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit();
        editorEdit.putString(RongLibConst.KEY_TOKEN, str);
        editorEdit.commit();
    }

    public static void setConnectionStatusListener(RongIMClient.ConnectionStatusListener connectionStatusListener) {
        sConnectionStatusListener = connectionStatusListener;
    }

    public static void setConversationBehaviorListener(ConversationBehaviorListener conversationBehaviorListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setConversationBehaviorListener(conversationBehaviorListener);
        }
    }

    public static void setConversationClickListener(ConversationClickListener conversationClickListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setConversationClickListener(conversationClickListener);
        }
    }

    public static void setConversationListBehaviorListener(ConversationListBehaviorListener conversationListBehaviorListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setConversationListBehaviorListener(conversationListBehaviorListener);
        }
    }

    public static void setGroupInfoProvider(GroupInfoProvider groupInfoProvider, boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setGetGroupInfoProvider(groupInfoProvider, z);
        }
    }

    public static void setGroupUserInfoProvider(GroupUserInfoProvider groupUserInfoProvider, boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setGroupUserInfoProvider(groupUserInfoProvider, z);
        }
    }

    public static void setLocationProvider(LocationProvider locationProvider) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setLocationProvider(locationProvider);
        }
    }

    public static void setOnReceiveMessageListener(RongIMClient.OnReceiveMessageListener onReceiveMessageListener) {
        RLog.i(TAG, "RongIM setOnReceiveMessageListener");
        sMessageListener = onReceiveMessageListener;
    }

    public static void setPublicServiceBehaviorListener(PublicServiceBehaviorListener publicServiceBehaviorListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setPublicServiceBehaviorListener(publicServiceBehaviorListener);
        }
    }

    public static void setPublicServiceProfileProvider(PublicServiceProfileProvider publicServiceProfileProvider) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setPublicServiceProfileProvider(publicServiceProfileProvider);
        }
    }

    public static void setServerInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "setServerInfo naviServer should not be null.");
            throw new IllegalArgumentException("naviServer should not be null.");
        }
        RongIMClient.setServerInfo(str, str2);
    }

    public static void setStatisticDomain(String str) {
        RongIMClient.setStatisticDomain(str);
    }

    public static void setUserInfoProvider(UserInfoProvider userInfoProvider, boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setGetUserInfoProvider(userInfoProvider, z);
        }
    }

    public void addMemberToDiscussion(final String str, final List<String> list, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().addMemberToDiscussion(str, list, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.26
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.AddMemberToDiscussionEvent(str, list));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void addToBlacklist(final String str, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().addToBlacklist(str, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.48
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.AddToBlacklistEvent(str));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void addUnReadMessageCountChangedObserver(IUnReadMessageObserver iUnReadMessageObserver, Conversation.ConversationType... conversationTypeArr) {
        if (iUnReadMessageObserver == null || conversationTypeArr == null || conversationTypeArr.length == 0) {
            RLog.w(TAG, "addOnReceiveUnreadCountChangedListener Illegal argument");
            throw new IllegalArgumentException("observer must not be null and must include at least one conversationType");
        }
        UnReadMessageManager.getInstance().addObserver(conversationTypeArr, iUnReadMessageObserver);
    }

    public void cancelDownloadMediaMessage(Message message, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().cancelDownloadMediaMessage(message, operationCallback);
    }

    public void cancelSendMediaMessage(Message message, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().cancelSendMediaMessage(message, operationCallback);
    }

    public void clearConversations(final RongIMClient.ResultCallback resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        RongIMClient.getInstance().clearConversations(new RongIMClient.ResultCallback() { // from class: io.rong.imkit.RongIM.47
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Object obj) {
                RongContext.getInstance().getEventBus().post(Event.ClearConversationEvent.obtain(conversationTypeArr));
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(obj);
                }
            }
        }, conversationTypeArr);
    }

    public void clearEncryptedConversations() {
        RongIMClient.getInstance().clearEncryptedConversations();
    }

    public void clearMessages(final Conversation.ConversationType conversationType, final String str, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().clearMessages(conversationType, str, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.21
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    RongContext.getInstance().getEventBus().post(new Event.MessagesClearEvent(conversationType, str));
                }
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
            }
        });
    }

    public void clearMessagesUnreadStatus(final Conversation.ConversationType conversationType, final String str, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().clearMessagesUnreadStatus(conversationType, str, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.22
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
                RongContext.getInstance().getEventBus().post(new Event.ConversationUnreadEvent(conversationType, str));
            }
        });
    }

    public void clearTextMessageDraft(Conversation.ConversationType conversationType, String str, RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().clearTextMessageDraft(conversationType, str, resultCallback);
    }

    public void createDiscussion(final String str, final List<String> list, final RongIMClient.CreateDiscussionCallback createDiscussionCallback) {
        RongIMClient.getInstance().createDiscussion(str, list, new RongIMClient.CreateDiscussionCallback() { // from class: io.rong.imkit.RongIM.25
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.CreateDiscussionCallback createDiscussionCallback2 = createDiscussionCallback;
                if (createDiscussionCallback2 != null) {
                    createDiscussionCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(String str2) {
                RongContext.getInstance().getEventBus().post(new Event.CreateDiscussionEvent(str2, str, list));
                RongIMClient.CreateDiscussionCallback createDiscussionCallback2 = createDiscussionCallback;
                if (createDiscussionCallback2 != null) {
                    createDiscussionCallback2.onSuccess(str2);
                }
            }
        });
    }

    public void createDiscussionChat(final Context context, final List<String> list, final String str) {
        if (context == null || list == null || list.size() == 0) {
            RLog.e(TAG, "createDiscussionChat. context, targetUserIds or targetUserIds.size can not be empty!!!");
        } else {
            RongIMClient.getInstance().createDiscussion(str, list, new RongIMClient.CreateDiscussionCallback() { // from class: io.rong.imkit.RongIM.11
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RLog.d(RongIM.TAG, "createDiscussionChat createDiscussion not success." + errorCode);
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(String str2) {
                    String str3 = context.getApplicationInfo().packageName;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.DISCUSSION.getName().toLowerCase(Locale.US)).appendQueryParameter("targetIds", TextUtils.join(",", list)).appendQueryParameter("delimiter", ",").appendQueryParameter("targetId", str2).appendQueryParameter("title", str).build());
                    intent.setPackage(str3);
                    context.startActivity(intent);
                }
            });
        }
    }

    public void deleteMessages(final int[] iArr, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().deleteMessages(iArr, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.18
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    RongContext.getInstance().getEventBus().post(new Event.MessageDeleteEvent(iArr));
                }
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
            }
        });
    }

    public void deleteRemoteMessages(Conversation.ConversationType conversationType, String str, final Message[] messageArr, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().deleteRemoteMessages(conversationType, str, messageArr, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.20
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                int[] iArr = new int[messageArr.length];
                int i = 0;
                while (true) {
                    Message[] messageArr2 = messageArr;
                    if (i >= messageArr2.length) {
                        break;
                    }
                    iArr[i] = messageArr2[i].getMessageId();
                    i++;
                }
                RongContext.getInstance().getEventBus().post(new Event.MessageDeleteEvent(iArr));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    @Deprecated
    public void disconnect(boolean z) {
        RongIMClient.getInstance().disconnect(z);
    }

    public void downloadMedia(Conversation.ConversationType conversationType, String str, RongIMClient.MediaType mediaType, String str2, RongIMClient.DownloadMediaCallback downloadMediaCallback) {
        RongIMClient.getInstance().downloadMedia(conversationType, str, mediaType, str2, downloadMediaCallback);
    }

    public void downloadMediaFile(final String str, String str2, String str3, String str4, final IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback) {
        RongIMClient.getInstance().downloadMediaFile(str, str2, str3, str4, new IRongCallback.IDownloadMediaFileCallback() { // from class: io.rong.imkit.RongIM.38
            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onCanceled() {
                EventBus.getDefault().post(new Event.MediaFileEvent(str, 0, 102, null));
                IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                if (iDownloadMediaFileCallback2 != null) {
                    iDownloadMediaFileCallback2.onCanceled();
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                EventBus.getDefault().post(new Event.MediaFileEvent(str, 0, 103, errorCode));
                IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                if (iDownloadMediaFileCallback2 != null) {
                    iDownloadMediaFileCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onFileNameChanged(String str5) {
                IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                if (iDownloadMediaFileCallback2 != null) {
                    iDownloadMediaFileCallback2.onFileNameChanged(str5);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onProgress(int i) {
                EventBus.getDefault().post(new Event.MediaFileEvent(str, i, 101, null));
                IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                if (iDownloadMediaFileCallback2 != null) {
                    iDownloadMediaFileCallback2.onProgress(i);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaFileCallback
            public void onSuccess() {
                EventBus.getDefault().post(new Event.MediaFileEvent(str, 100, 100, null));
                IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                if (iDownloadMediaFileCallback2 != null) {
                    iDownloadMediaFileCallback2.onSuccess();
                }
            }
        });
    }

    public void downloadMediaMessage(Message message, final IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback) {
        RongIMClient.getInstance().downloadMediaMessage(message, new IRongCallback.IDownloadMediaMessageCallback() { // from class: io.rong.imkit.RongIM.37
            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onCanceled(Message message2) {
                EventBus.getDefault().post(new Event.FileMessageEvent(message2, 0, 102, null));
                IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                if (iDownloadMediaMessageCallback2 != null) {
                    iDownloadMediaMessageCallback2.onCanceled(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                Event.OnReceiveMessageProgressEvent onReceiveMessageProgressEvent = new Event.OnReceiveMessageProgressEvent();
                onReceiveMessageProgressEvent.setMessage(message2);
                onReceiveMessageProgressEvent.setProgress(-1);
                message2.getReceivedStatus().isDownload();
                EventBus.getDefault().post(onReceiveMessageProgressEvent);
                if (message2.getContent() instanceof GIFMessage) {
                    EventBus.getDefault().post(new Event.FileMessageEvent(message2, -1, 103, errorCode));
                } else {
                    EventBus.getDefault().post(new Event.FileMessageEvent(message2, 0, 103, errorCode));
                }
                IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                if (iDownloadMediaMessageCallback2 != null) {
                    iDownloadMediaMessageCallback2.onError(message2, errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onProgress(Message message2, int i) {
                Event.OnReceiveMessageProgressEvent onReceiveMessageProgressEvent = new Event.OnReceiveMessageProgressEvent();
                message2.getReceivedStatus().setDownload();
                onReceiveMessageProgressEvent.setMessage(message2);
                onReceiveMessageProgressEvent.setProgress(i);
                EventBus.getDefault().post(onReceiveMessageProgressEvent);
                EventBus.getDefault().post(new Event.FileMessageEvent(message2, i, 101, null));
                IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                if (iDownloadMediaMessageCallback2 != null) {
                    iDownloadMediaMessageCallback2.onProgress(message2, i);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onSuccess(Message message2) {
                Event.OnReceiveMessageProgressEvent onReceiveMessageProgressEvent = new Event.OnReceiveMessageProgressEvent();
                message2.getReceivedStatus().setDownload();
                onReceiveMessageProgressEvent.setMessage(message2);
                onReceiveMessageProgressEvent.setProgress(100);
                EventBus.getDefault().post(onReceiveMessageProgressEvent);
                EventBus.getDefault().post(new Event.FileMessageEvent(message2, 100, 100, null));
                IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                if (iDownloadMediaMessageCallback2 != null) {
                    iDownloadMediaMessageCallback2.onSuccess(message2);
                }
            }
        });
    }

    public void enableNewComingMessageIcon(boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().showNewMessageIcon(z);
        }
    }

    public void enableUnreadMessageIcon(boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().showUnreadMessageIcon(z);
        }
    }

    public List<RCEncryptedSession> getAllEncryptedConversations() {
        return RongIMClient.getInstance().getAllEncryptedConversations();
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public void getBlacklist(RongIMClient.GetBlacklistCallback getBlacklistCallback) {
        RongIMClient.getInstance().getBlacklist(getBlacklistCallback);
    }

    public void getBlacklistStatus(String str, RongIMClient.ResultCallback<RongIMClient.BlacklistStatus> resultCallback) {
        RongIMClient.getInstance().getBlacklistStatus(str, resultCallback);
    }

    public void getConversation(Conversation.ConversationType conversationType, String str, RongIMClient.ResultCallback<Conversation> resultCallback) {
        RongIMClient.getInstance().getConversation(conversationType, str, resultCallback);
    }

    public void getConversationList(RongIMClient.ResultCallback<List<Conversation>> resultCallback) {
        RongIMClient.getInstance().getConversationList(resultCallback);
    }

    public void getConversationNotificationStatus(final Conversation.ConversationType conversationType, final String str, final RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> resultCallback) {
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "getConversationNotificationStatus. RongIM SDK not init, please do after init.");
            if (resultCallback != null) {
                resultCallback.onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                return;
            }
            return;
        }
        Conversation.ConversationNotificationStatus conversationNotifyStatusFromCache = RongContext.getInstance().getConversationNotifyStatusFromCache(ConversationKey.obtain(str, conversationType));
        if (conversationNotifyStatusFromCache != null) {
            resultCallback.onSuccess(conversationNotifyStatusFromCache);
        } else {
            RongIMClient.getInstance().getConversationNotificationStatus(conversationType, str, new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.RongIM.41
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onError(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
                    RongContext.getInstance().setConversationNotifyStatusToCache(ConversationKey.obtain(str, conversationType), conversationNotificationStatus);
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onSuccess(conversationNotificationStatus);
                    }
                }
            });
        }
    }

    public RongIMClient.ConnectionStatusListener.ConnectionStatus getCurrentConnectionStatus() {
        return RongIMClient.getInstance().getCurrentConnectionStatus();
    }

    public String getCurrentUserId() {
        return RongIMClient.getInstance().getCurrentUserId();
    }

    public long getDeltaTime() {
        return RongIMClient.getInstance().getDeltaTime();
    }

    public void getDiscussion(String str, RongIMClient.ResultCallback<Discussion> resultCallback) {
        RongIMClient.getInstance().getDiscussion(str, resultCallback);
    }

    public int getEncryptedSessionStatus(Context context, String str) {
        return RongIMClient.getInstance().getEncryptedSessionStatus(str);
    }

    @Deprecated
    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, int i, int i2) {
        return RongIMClient.getInstance().getHistoryMessages(conversationType, str, i, i2);
    }

    public void getLatestMessages(Conversation.ConversationType conversationType, String str, int i, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getLatestMessages(conversationType, str, i, resultCallback);
    }

    public void getNotificationQuietHours(final RongIMClient.GetNotificationQuietHoursCallback getNotificationQuietHoursCallback) {
        RongIMClient.getInstance().getNotificationQuietHours(new RongIMClient.GetNotificationQuietHoursCallback() { // from class: io.rong.imkit.RongIM.52
            @Override // io.rong.imlib.RongIMClient.GetNotificationQuietHoursCallback, io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.GetNotificationQuietHoursCallback getNotificationQuietHoursCallback2 = getNotificationQuietHoursCallback;
                if (getNotificationQuietHoursCallback2 != null) {
                    getNotificationQuietHoursCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.GetNotificationQuietHoursCallback
            public void onSuccess(String str, int i) {
                MessageNotificationManager.getInstance().setNotificationQuietHours(str, i);
                boolean unused = RongIM.notificationQuiteHoursConfigured = true;
                RongIMClient.GetNotificationQuietHoursCallback getNotificationQuietHoursCallback2 = getNotificationQuietHoursCallback;
                if (getNotificationQuietHoursCallback2 != null) {
                    getNotificationQuietHoursCallback2.onSuccess(str, i);
                }
            }
        });
    }

    public void getPublicServiceList(RongIMClient.ResultCallback<PublicServiceProfileList> resultCallback) {
        RongIMClient.getInstance().getPublicServiceList(resultCallback);
    }

    public void getPublicServiceProfile(Conversation.PublicServiceType publicServiceType, String str, RongIMClient.ResultCallback<PublicServiceProfile> resultCallback) {
        RongIMClient.getInstance().getPublicServiceProfile(publicServiceType, str, resultCallback);
    }

    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, long j, int i, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getRemoteHistoryMessages(conversationType, str, j, i, resultCallback);
    }

    public int getSamplingRate() {
        return this.sampleRate.getValue();
    }

    public void getTextMessageDraft(Conversation.ConversationType conversationType, String str, RongIMClient.ResultCallback<String> resultCallback) {
        RongIMClient.getInstance().getTextMessageDraft(conversationType, str, resultCallback);
    }

    public void getTotalUnreadCount(final RongIMClient.ResultCallback<Integer> resultCallback) {
        RongIMClient.getInstance().getTotalUnreadCount(new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.RongIM.17
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Integer num) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(num);
                }
            }
        });
    }

    public void getUnreadCount(Conversation.ConversationType conversationType, String str, RongIMClient.ResultCallback<Integer> resultCallback) {
        RongIMClient.getInstance().getUnreadCount(conversationType, str, resultCallback);
    }

    public VoiceMessageType getVoiceMessageType() {
        return this.voiceMessageType;
    }

    public void insertIncomingMessage(Conversation.ConversationType conversationType, String str, String str2, Message.ReceivedStatus receivedStatus, MessageContent messageContent, RongIMClient.ResultCallback<Message> resultCallback) {
        insertIncomingMessage(conversationType, str, str2, receivedStatus, messageContent, System.currentTimeMillis(), resultCallback);
    }

    public void insertOutgoingMessage(Conversation.ConversationType conversationType, String str, Message.SentStatus sentStatus, MessageContent messageContent, RongIMClient.ResultCallback<Message> resultCallback) {
        insertOutgoingMessage(conversationType, str, sentStatus, messageContent, System.currentTimeMillis(), resultCallback);
    }

    public boolean isNotificationQuiteHoursConfigured() {
        return notificationQuiteHoursConfigured;
    }

    public boolean isRegisted(RongIMClient.EncryptedSessionConnectionListener encryptedSessionConnectionListener) {
        List<RongIMClient.EncryptedSessionConnectionListener> list = this.mEncSessionListeners;
        return list != null && list.contains(encryptedSessionConnectionListener);
    }

    public void joinChatRoom(final String str, final int i, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().joinChatRoom(str, i, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.44
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.JoinChatRoomEvent(str, i));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void joinExistChatRoom(final String str, final int i, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().joinExistChatRoom(str, i, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.45
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.JoinChatRoomEvent(str, i));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void logout() {
        Context context = this.mApplicationContext;
        if (context == null) {
            return;
        }
        String currentProcessName = SystemUtils.getCurrentProcessName(context);
        if (!this.mApplicationContext.getPackageName().equals(currentProcessName)) {
            RLog.w(TAG, "only can logout in main progress! current process is:" + currentProcessName);
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "logout. RongIM SDK not init, please do after init.");
        } else {
            RongContext.getInstance().clearConversationNotifyStatusCache();
        }
        RongIMClient.getInstance().logout();
        RongUserInfoManager.getInstance().uninit();
        UnReadMessageManager.getInstance().clearObserver();
        RongExtensionManager.getInstance().disconnect();
        notificationQuiteHoursConfigured = false;
        MessageNotificationManager.getInstance().clearNotificationQuietHours();
    }

    public void pauseDownloadMediaMessage(Message message, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().pauseDownloadMediaMessage(message, operationCallback);
    }

    public void quitChatRoom(final String str, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().quitChatRoom(str, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.46
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.QuitChatRoomEvent(str));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void quitDiscussion(final String str, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().quitDiscussion(str, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.28
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.QuitDiscussionEvent(str));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void quitEncryptedSession(String str) {
        RongIMClient.getInstance().quitEncryptedSession(str);
    }

    public void recallMessage(final Message message, String str) {
        RongIMClient.getInstance().recallMessage(message, str, new RongIMClient.ResultCallback<RecallNotificationMessage>() { // from class: io.rong.imkit.RongIM.54
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RLog.d(RongIM.TAG, "recallMessage errorCode = " + errorCode.getValue());
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(RecallNotificationMessage recallNotificationMessage) {
                RongContext.getInstance().getEventBus().post(new Event.MessageRecallEvent(message.getMessageId(), recallNotificationMessage, true));
            }
        });
    }

    public void recordNotificationEvent(String str) {
        RongPushClient.recordNotificationEvent(str);
    }

    public void refreshDiscussionCache(Discussion discussion) {
        if (discussion == null) {
            return;
        }
        RongUserInfoManager.getInstance().setDiscussionInfo(discussion);
    }

    public void refreshGroupInfoCache(Group group) {
        if (group == null) {
            return;
        }
        RongUserInfoManager.getInstance().setGroupInfo(group);
    }

    public void refreshGroupUserInfoCache(GroupUserInfo groupUserInfo) {
        if (groupUserInfo == null) {
            return;
        }
        RongUserInfoManager.getInstance().setGroupUserInfo(groupUserInfo);
    }

    public void refreshPublicServiceProfile(PublicServiceProfile publicServiceProfile) {
        if (publicServiceProfile == null) {
            return;
        }
        RongUserInfoManager.getInstance().setPublicServiceProfile(publicServiceProfile);
    }

    public void refreshUserInfoCache(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        RongUserInfoManager.getInstance().setUserInfo(userInfo);
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "refreshUserInfoCache. RongIM SDK not init, please do after init.");
            return;
        }
        UserInfo currentUserInfo = RongContext.getInstance().getCurrentUserInfo();
        if (currentUserInfo == null || !currentUserInfo.getUserId().equals(userInfo.getUserId())) {
            return;
        }
        RongContext.getInstance().setCurrentUserInfo(userInfo);
    }

    public void registerConversationTemplate(IContainerItemProvider.ConversationProvider conversationProvider) {
        if (RongContext.getInstance() != null) {
            if (conversationProvider == null) {
                throw new IllegalArgumentException();
            }
            RongContext.getInstance().registerConversationTemplate(conversationProvider);
        }
    }

    public void registerEncSessionListener(RongIMClient.EncryptedSessionConnectionListener encryptedSessionConnectionListener) {
        if (encryptedSessionConnectionListener == null || this.mEncSessionListeners.contains(encryptedSessionConnectionListener)) {
            return;
        }
        this.mEncSessionListeners.add(encryptedSessionConnectionListener);
    }

    public void removeConversation(final Conversation.ConversationType conversationType, final String str, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().removeConversation(conversationType, str, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.14
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
                if (bool.booleanValue()) {
                    RongContext.getInstance().getEventBus().post(new Event.ConversationRemoveEvent(conversationType, str));
                }
            }
        });
    }

    public void removeFromBlacklist(final String str, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().removeFromBlacklist(str, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.49
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.RemoveFromBlacklistEvent(str));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void removeMemberFromDiscussion(final String str, final String str2, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().removeMemberFromDiscussion(str, str2, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.27
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.RemoveMemberFromDiscussionEvent(str, str2));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void removeNotificationQuietHours(final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().removeNotificationQuietHours(new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.51
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                MessageNotificationManager.getInstance().setNotificationQuietHours(null, 0);
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void removeUnReadMessageCountChangedObserver(IUnReadMessageObserver iUnReadMessageObserver) {
        if (iUnReadMessageObserver == null) {
            RLog.w(TAG, "removeOnReceiveUnreadCountChangedListener Illegal argument");
        } else {
            UnReadMessageManager.getInstance().removeObserver(iUnReadMessageObserver);
        }
    }

    public void saveTextMessageDraft(Conversation.ConversationType conversationType, String str, String str2, RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().saveTextMessageDraft(conversationType, str, str2, resultCallback);
    }

    public void searchPublicService(RongIMClient.SearchType searchType, String str, RongIMClient.ResultCallback<PublicServiceProfileList> resultCallback) {
        RongIMClient.getInstance().searchPublicService(searchType, str, resultCallback);
    }

    public void searchPublicServiceByType(Conversation.PublicServiceType publicServiceType, RongIMClient.SearchType searchType, String str, RongIMClient.ResultCallback<PublicServiceProfileList> resultCallback) {
        RongIMClient.getInstance().searchPublicServiceByType(publicServiceType, searchType, str, resultCallback);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
    public void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, final IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            return;
        }
        Message message2 = messageFilterSendMessage != message ? messageFilterSendMessage : message;
        setMessageAttachedUserInfo(message2.getContent());
        final RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
        result.t = new Event.OnReceiveMessageProgressEvent();
        RongIMClient.getInstance().sendDirectionalMediaMessage(message2, strArr, str, str2, new IRongCallback.ISendMediaMessageCallback() { // from class: io.rong.imkit.RongIM.56
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message3) {
                RongContext.getInstance().getEventBus().post(message3);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onAttached(message3);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
            public void onCanceled(Message message3) {
                RongIM.this.filterSentMessage(message3, null);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onCanceled(message3);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message3, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message3, errorCode);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onError(message3, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
            public void onProgress(Message message3, int i) {
                T t = result.t;
                if (t == 0) {
                    return;
                }
                ((Event.OnReceiveMessageProgressEvent) t).setMessage(message3);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onProgress(message3, i);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message3) {
                RongIM.this.filterSentMessage(message3, null);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onSuccess(message3);
                }
            }
        });
    }

    public void sendDirectionalMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String[] strArr, String str2, String str3, final IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageObtain = Message.obtain(str, conversationType, messageContent);
        Message messageFilterSendMessage = filterSendMessage(messageObtain);
        if (messageFilterSendMessage == null) {
            RLog.w(TAG, "sendDirectionalMessage: 因在 onSend 中消息被过滤为 null，取消发送。");
            return;
        }
        if (messageFilterSendMessage != messageObtain) {
            messageObtain = messageFilterSendMessage;
        }
        MessageContent content = messageObtain.getContent();
        setMessageAttachedUserInfo(content);
        messageObtain.setContent(content);
        RongIMClient.getInstance().sendDirectionalMessage(conversationType, str, messageContent, strArr, str2, str3, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.RongIM.58
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
                MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && (messageTag.flag() & 1) == 1) {
                    RongContext.getInstance().getEventBus().post(message);
                }
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onAttached(message);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message, errorCode);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onError(message, errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RongIM.this.filterSentMessage(message, null);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onSuccess(message);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
    public void sendImageMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String str2, String str3, final RongIMClient.SendImageMessageCallback sendImageMessageCallback) {
        Message messageObtain = Message.obtain(str, conversationType, messageContent);
        Message messageFilterSendMessage = filterSendMessage(messageObtain);
        if (messageFilterSendMessage == null) {
            return;
        }
        if (messageFilterSendMessage != messageObtain) {
            messageObtain = messageFilterSendMessage;
        }
        MessageContent content = messageObtain.getContent();
        setMessageAttachedUserInfo(content);
        final RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
        result.t = new Event.OnReceiveMessageProgressEvent();
        RongIMClient.getInstance().sendImageMessage(conversationType, str, content, str2, str3, new RongIMClient.SendImageMessageCallback() { // from class: io.rong.imkit.RongIM.34
            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onAttached(Message message) {
                RongContext.getInstance().getEventBus().post(message);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onAttached(message);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message, errorCode);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onError(message, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onProgress(Message message, int i) {
                T t = result.t;
                if (t == 0) {
                    return;
                }
                ((Event.OnReceiveMessageProgressEvent) t).setMessage(message);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onProgress(message, i);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onSuccess(Message message) {
                RongIM.this.filterSentMessage(message, null);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onSuccess(message);
                }
            }
        });
    }

    public void sendLocationMessage(Message message, String str, String str2, final IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            RLog.w(TAG, "sendLocationMessage: 因在 onSend 中消息被过滤为 null，取消发送。");
            return;
        }
        if (messageFilterSendMessage != message) {
            message = messageFilterSendMessage;
        }
        MessageContent content = message.getContent();
        setMessageAttachedUserInfo(content);
        message.setContent(content);
        RongIMClient.getInstance().sendLocationMessage(message, str, str2, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.RongIM.33
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message2) {
                MessageTag messageTag = (MessageTag) message2.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && (messageTag.flag() & 1) == 1) {
                    RongContext.getInstance().getEventBus().post(message2);
                }
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onAttached(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onError(message2, errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onSuccess(message2);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
    public void sendMediaMessage(Message message, String str, String str2, final IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            return;
        }
        if (messageFilterSendMessage != message) {
            message = messageFilterSendMessage;
        }
        setMessageAttachedUserInfo(message.getContent());
        final RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
        result.t = new Event.OnReceiveMessageProgressEvent();
        RongIMClient.getInstance().sendMediaMessage(message, str, str2, new IRongCallback.ISendMediaMessageCallback() { // from class: io.rong.imkit.RongIM.55
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message2) {
                RongContext.getInstance().getEventBus().post(message2);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onAttached(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
            public void onCanceled(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onCanceled(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onError(message2, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
            public void onProgress(Message message2, int i) {
                T t = result.t;
                if (t == 0) {
                    return;
                }
                ((Event.OnReceiveMessageProgressEvent) t).setMessage(message2);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onProgress(message2, i);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                if (iSendMediaMessageCallback2 != null) {
                    iSendMediaMessageCallback2.onSuccess(message2);
                }
            }
        });
    }

    public void sendMessage(Message message, String str, String str2, final IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            RLog.w(TAG, "sendMessage: 因在 onSend 中消息被过滤为 null，取消发送。");
            return;
        }
        if (messageFilterSendMessage != message) {
            message = messageFilterSendMessage;
        }
        MessageContent content = message.getContent();
        setMessageAttachedUserInfo(content);
        message.setContent(content);
        RongIMClient.getInstance().sendMessage(message, str, str2, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.RongIM.31
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message2) {
                MessageTag messageTag = (MessageTag) message2.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && (messageTag.flag() & 1) == 1) {
                    RongContext.getInstance().getEventBus().post(message2);
                }
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onAttached(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                if (iSendMessageCallback != null) {
                    if (errorCode.equals(RongIMClient.ErrorCode.RC_MSG_REPLACED_SENSITIVE_WORD)) {
                        iSendMessageCallback.onSuccess(message2);
                    } else {
                        iSendMessageCallback.onError(message2, errorCode);
                    }
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onSuccess(message2);
                }
            }
        });
    }

    public void setConversationNotificationStatus(final Conversation.ConversationType conversationType, final String str, final Conversation.ConversationNotificationStatus conversationNotificationStatus, final RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> resultCallback) {
        RongIMClient.getInstance().setConversationNotificationStatus(conversationType, str, conversationNotificationStatus, new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.RongIM.42
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus2) {
                RongContext.getInstance().setConversationNotifyStatusToCache(ConversationKey.obtain(str, conversationType), conversationNotificationStatus2);
                RongContext.getInstance().getEventBus().post(new Event.ConversationNotificationEvent(str, conversationType, conversationNotificationStatus));
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(conversationNotificationStatus2);
                }
            }
        });
    }

    public void setConversationToTop(final Conversation.ConversationType conversationType, final String str, final boolean z, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().setConversationToTop(conversationType, str, z, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.15
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
                if (bool.booleanValue()) {
                    RongContext.getInstance().getEventBus().post(new Event.ConversationTopEvent(conversationType, str, z));
                }
            }
        });
    }

    public void setCurrentUserInfo(UserInfo userInfo) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setCurrentUserInfo(userInfo);
        }
    }

    public void setDiscussionInviteStatus(final String str, final RongIMClient.DiscussionInviteStatus discussionInviteStatus, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().setDiscussionInviteStatus(str, discussionInviteStatus, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.43
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                RongContext.getInstance().getEventBus().post(new Event.DiscussionInviteStatusEvent(str, discussionInviteStatus));
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void setDiscussionName(final String str, final String str2, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().setDiscussionName(str, str2, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.24
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                if (operationCallback != null) {
                    RongUserInfoManager.getInstance().setDiscussionInfo(new Discussion(str, str2));
                    operationCallback.onSuccess();
                }
            }
        });
    }

    public void setGroupMembersProvider(IGroupMembersProvider iGroupMembersProvider) {
        RongMentionManager.getInstance().setGroupMembersProvider(iGroupMembersProvider);
    }

    public void setMaxVoiceDurationg(int i) {
        AudioRecordManager.getInstance().setMaxVoiceDuration(i);
    }

    public void setMessageAttachedUserInfo(boolean z) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setUserInfoAttachedState(z);
        }
    }

    public void setMessageExtra(int i, String str, RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().setMessageExtra(i, str, resultCallback);
    }

    public void setMessageInterceptor(MessageInterceptor messageInterceptor2) {
        messageInterceptor = messageInterceptor2;
    }

    public void setMessageReceivedStatus(int i, Message.ReceivedStatus receivedStatus, RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().setMessageReceivedStatus(i, receivedStatus, resultCallback);
    }

    public void setMessageSentStatus(final Message message, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        if (message == null || message.getMessageId() <= 0) {
            RLog.e(TAG, "setMessageSentStatus message is null or messageId <= 0");
        } else {
            RongIMClient.getInstance().setMessageSentStatus(message, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.23
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onError(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Boolean bool) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onSuccess(bool);
                    }
                    if (bool.booleanValue()) {
                        EventBus eventBus = RongContext.getInstance().getEventBus();
                        Message message2 = message;
                        eventBus.post(new Event.MessageSentStatusUpdateEvent(message2, message2.getSentStatus()));
                    }
                }
            });
        }
    }

    public void setNotificationQuietHours(final String str, final int i, final RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().setNotificationQuietHours(str, i, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.RongIM.50
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                MessageNotificationManager.getInstance().setNotificationQuietHours(str, i);
                RongIMClient.OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    @Deprecated
    public void setNotificationQuiteHoursConfigured(boolean z) {
        RongIM rongIM = SingletonHolder.sRongIM;
        notificationQuiteHoursConfigured = z;
    }

    @Deprecated
    public void setOnReceiveUnreadCountChangedListener(final OnReceiveUnreadCountChangedListener onReceiveUnreadCountChangedListener, Conversation.ConversationType... conversationTypeArr) {
        if (onReceiveUnreadCountChangedListener == null || conversationTypeArr == null || conversationTypeArr.length == 0) {
            RLog.w(TAG, "setOnReceiveUnreadCountChangedListener Illegal argument");
        } else {
            UnReadMessageManager.getInstance().addObserver(conversationTypeArr, new IUnReadMessageObserver() { // from class: io.rong.imkit.RongIM.13
                @Override // io.rong.imkit.manager.IUnReadMessageObserver
                public void onCountChanged(int i) {
                    onReceiveUnreadCountChangedListener.onMessageIncreased(i);
                }
            });
        }
    }

    public void setPublicServiceMenuClickListener(IPublicServiceMenuClickListener iPublicServiceMenuClickListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setPublicServiceMenuClickListener(iPublicServiceMenuClickListener);
        }
    }

    public void setReadReceiptConversationTypeList(Conversation.ConversationType... conversationTypeArr) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setReadReceiptConversationTypeList(conversationTypeArr);
        }
    }

    @Deprecated
    public void setRequestPermissionListener(RequestPermissionsListener requestPermissionsListener) {
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "setRequestPermissionListener. RongIM SDK not init, please do after init.");
        } else {
            RongContext.getInstance().setRequestPermissionListener(requestPermissionsListener);
        }
    }

    public void setSamplingRate(SamplingRate samplingRate) {
        this.sampleRate = samplingRate;
    }

    public void setSendMessageListener(OnSendMessageListener onSendMessageListener) {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().setOnSendMessageListener(onSendMessageListener);
        }
    }

    public void setVoiceMessageType(VoiceMessageType voiceMessageType) {
        this.voiceMessageType = voiceMessageType;
    }

    public void startChatRoomChat(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startChatRoomChat. context or chatRoomId can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startChatRoomChat. RongIM SDK not init, please do after init.");
            return;
        }
        String str2 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str2).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).build());
        intent.setPackage(str2);
        intent.putExtra("createIfNotExist", z);
        context.startActivity(intent);
    }

    public void startConversation(Context context, Conversation.ConversationType conversationType, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || conversationType == null) {
            RLog.e(TAG, "startConversation. context, targetId or conversationType can not be empty!!!");
            return;
        }
        String str3 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setPackage(str3);
        context.startActivity(intent);
    }

    @Deprecated
    public void startConversationList(Context context) {
        if (context == null) {
            RLog.e(TAG, "startConversationList. context can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startConversationList. RongIM SDK not init, please do after init.");
            return;
        }
        String str = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str).buildUpon().appendPath("conversationlist").build());
        intent.setPackage(str);
        context.startActivity(intent);
    }

    public void startCustomerServiceChat(Context context, String str, String str2, CSCustomServiceInfo cSCustomServiceInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startCustomerServiceChat. context or customerServiceId can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startCustomerServiceChat. RongIM SDK not init, please do after init.");
            return;
        }
        String str3 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.CUSTOMER_SERVICE.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
        intent.setPackage(str3);
        intent.putExtra("customServiceInfo", cSCustomServiceInfo);
        context.startActivity(intent);
    }

    public void startDiscussionChat(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startDiscussionChat. context or targetDiscussionId can not be empty!!!");
            return;
        }
        String str3 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.DISCUSSION.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
        intent.setPackage(str3);
        context.startActivity(intent);
    }

    public void startEncryptedSession(Context context, String str, String str2) {
        RongIMClient.getInstance().startEncryptedSession(str);
    }

    public void startGroupChat(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startGroupChat. context or targetGroupId can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startGroupChat. RongIM SDK not init, please do after init.");
            return;
        }
        String str3 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.GROUP.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
        intent.setPackage(str3);
        context.startActivity(intent);
    }

    public void startPrivateChat(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startPrivateChat. context or targetUserId can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startPrivateChat. RongIM SDK not init, please do after init.");
            return;
        }
        String str3 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
        intent.setPackage(str3);
        context.startActivity(intent);
    }

    public void startPublicServiceProfile(Context context, Conversation.ConversationType conversationType, String str) {
        if (context == null || conversationType == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "startPublicServiceProfile. context, conversationType or targetId can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startPublicServiceProfile. RongIM SDK not init, please do after init.");
            return;
        }
        String str2 = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str2).buildUpon().appendPath("publicServiceProfile").appendPath(conversationType.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).build());
        intent.setFlags(268435456);
        intent.setPackage(str2);
        context.startActivity(intent);
    }

    public void startSubConversationList(Context context, Conversation.ConversationType conversationType) {
        if (context == null) {
            RLog.e(TAG, "startSubConversationList. context can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startSubConversationList. RongIM SDK not init, please do after init.");
            return;
        }
        String str = context.getApplicationInfo().packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str).buildUpon().appendPath("subconversationlist").appendQueryParameter("type", conversationType.getName()).build());
        intent.setPackage(str);
        context.startActivity(intent);
    }

    public void subscribePublicService(Conversation.PublicServiceType publicServiceType, String str, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().subscribePublicService(publicServiceType, str, operationCallback);
    }

    public void supportResumeBrokenTransfer(String str, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().supportResumeBrokenTransfer(str, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.59
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
            }
        });
    }

    public void unRegisterEncSessionListener(RongIMClient.EncryptedSessionConnectionListener encryptedSessionConnectionListener) {
        if (encryptedSessionConnectionListener != null) {
            this.mEncSessionListeners.remove(encryptedSessionConnectionListener);
        }
    }

    public void unsubscribePublicService(Conversation.PublicServiceType publicServiceType, String str, RongIMClient.OperationCallback operationCallback) {
        RongIMClient.getInstance().unsubscribePublicService(publicServiceType, str, operationCallback);
    }

    private RongIM() {
        this.sampleRate = SamplingRate.RC_SAMPLE_RATE_8000;
        this.voiceMessageType = VoiceMessageType.Ordinary;
        this.mEncSessionListeners = new LinkedList();
        HandlerThread handlerThread = new HandlerThread("KIT_WORK");
        handlerThread.start();
        this.mWorkHandler = new Handler(handlerThread.getLooper());
        RongIMClient.getInstance().setEncryptedSessionConnectionListener(new RongIMClient.EncryptedSessionConnectionListener() { // from class: io.rong.imkit.RongIM.1
            @Override // io.rong.imlib.RongIMClient.EncryptedSessionConnectionListener
            public void onEncryptedSessionCanceled(String str) {
                RLog.d(RongIM.TAG, "取消加密会话请求");
                if (RongIM.this.mEncSessionListeners != null) {
                    for (int i = 0; i < RongIM.this.mEncSessionListeners.size(); i++) {
                        if (RongIM.this.mEncSessionListeners.get(i) != null) {
                            ((RongIMClient.EncryptedSessionConnectionListener) RongIM.this.mEncSessionListeners.get(i)).onEncryptedSessionCanceled(str);
                        }
                    }
                }
            }

            @Override // io.rong.imlib.RongIMClient.EncryptedSessionConnectionListener
            public void onEncryptedSessionEstablished(String str) {
                RLog.d(RongIM.TAG, "加密会话建立");
                if (str == null || str.length() == 0) {
                    RLog.e(RongIM.TAG, "encrypted session establish failed because the targetId is null or empty.");
                    return;
                }
                if (RongIM.this.mEncSessionListeners != null) {
                    for (int i = 0; i < RongIM.this.mEncSessionListeners.size(); i++) {
                        if (RongIM.this.mEncSessionListeners.get(i) != null) {
                            ((RongIMClient.EncryptedSessionConnectionListener) RongIM.this.mEncSessionListeners.get(i)).onEncryptedSessionEstablished(str);
                        }
                    }
                }
            }

            @Override // io.rong.imlib.RongIMClient.EncryptedSessionConnectionListener
            public void onEncryptedSessionRequest(String str, boolean z) {
                RLog.d(RongIM.TAG, "发送加密会话请求");
                if (RongIM.this.mEncSessionListeners != null) {
                    for (int i = 0; i < RongIM.this.mEncSessionListeners.size(); i++) {
                        if (RongIM.this.mEncSessionListeners.get(i) != null) {
                            ((RongIMClient.EncryptedSessionConnectionListener) RongIM.this.mEncSessionListeners.get(i)).onEncryptedSessionRequest(str, z);
                        }
                    }
                }
            }

            @Override // io.rong.imlib.RongIMClient.EncryptedSessionConnectionListener
            public void onEncryptedSessionResponse(String str) {
                RLog.d(RongIM.TAG, "发送加密会话响应");
                if (RongIM.this.mEncSessionListeners != null) {
                    for (int i = 0; i < RongIM.this.mEncSessionListeners.size(); i++) {
                        if (RongIM.this.mEncSessionListeners.get(i) != null) {
                            ((RongIMClient.EncryptedSessionConnectionListener) RongIM.this.mEncSessionListeners.get(i)).onEncryptedSessionResponse(str);
                        }
                    }
                }
            }

            @Override // io.rong.imlib.RongIMClient.EncryptedSessionConnectionListener
            public void onEncryptedSessionTerminated(String str) {
                RLog.d(RongIM.TAG, "结束加密会话请求");
                if (RongIM.this.mEncSessionListeners != null) {
                    for (int i = 0; i < RongIM.this.mEncSessionListeners.size(); i++) {
                        if (RongIM.this.mEncSessionListeners.get(i) != null) {
                            ((RongIMClient.EncryptedSessionConnectionListener) RongIM.this.mEncSessionListeners.get(i)).onEncryptedSessionTerminated(str);
                        }
                    }
                }
            }
        });
    }

    public static RongIM connect(final String str, int i, final RongIMClient.ConnectCallback connectCallback) {
        RongIMClient.connect(str, i, new RongIMClient.ConnectCallback() { // from class: io.rong.imkit.RongIM.3
            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
                RongIMClient.ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onDatabaseOpened(databaseOpenStatus);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
                RongIMClient.ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onError(connectionErrorCode);
                }
                RongExtensionManager.getInstance().connect(str);
                InternalModuleManager.getInstance().onConnected(str);
                if (RongContext.getInstance() == null) {
                    RLog.d(RongIM.TAG, "connect - onError. RongIM SDK not init, ConnectEvent do not post.");
                } else {
                    RongContext.getInstance().getEventBus().post(Event.ConnectEvent.obtain(false));
                }
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onSuccess(String str2) {
                RongIM.getInstance().saveToken(str);
                RongIMClient.ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onSuccess(str2);
                }
                RongContext.getInstance().getEventBus().post(Event.ConnectEvent.obtain(true));
                RongExtensionManager.getInstance().connect(str);
                InternalModuleManager.getInstance().onConnected(str);
                if (RongIM.notificationQuiteHoursConfigured) {
                    return;
                }
                SingletonHolder.sRongIM.getNotificationQuietHours(null);
            }
        });
        return SingletonHolder.sRongIM;
    }

    public static void init(Context context, String str) {
        SingletonHolder.sRongIM.initSDK(context, str, true);
    }

    public void deleteMessages(final Conversation.ConversationType conversationType, final String str, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().deleteMessages(conversationType, str, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.19
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    RongContext.getInstance().getEventBus().post(new Event.MessagesClearEvent(conversationType, str));
                }
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
            }
        });
    }

    public void disconnect() {
        RongIMClient.getInstance().disconnect();
        RongExtensionManager.getInstance().disconnect();
    }

    public void downloadMedia(String str, final RongIMClient.DownloadMediaCallback downloadMediaCallback) {
        ImageLoader.getInstance().loadImage(str, null, null, new ImageLoadingListener() { // from class: io.rong.imkit.RongIM.39
            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String str2, View view) {
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                RongIMClient.DownloadMediaCallback downloadMediaCallback2 = downloadMediaCallback;
                if (downloadMediaCallback2 != null) {
                    downloadMediaCallback2.onSuccess(str2);
                }
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str2, View view, FailReason failReason) {
                RongIMClient.DownloadMediaCallback downloadMediaCallback2 = downloadMediaCallback;
                if (downloadMediaCallback2 != null) {
                    downloadMediaCallback2.onError(RongIMClient.ErrorCode.RC_NET_UNAVAILABLE);
                }
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str2, View view) {
            }
        }, new ImageLoadingProgressListener() { // from class: io.rong.imkit.RongIM.40
            @Override // io.rong.imageloader.core.listener.ImageLoadingProgressListener
            public void onProgressUpdate(String str2, View view, int i, int i2) {
                RongIMClient.DownloadMediaCallback downloadMediaCallback2 = downloadMediaCallback;
                if (downloadMediaCallback2 != null) {
                    downloadMediaCallback2.onProgress((i * 100) / i2);
                }
            }
        });
    }

    public void getConversationList(RongIMClient.ResultCallback<List<Conversation>> resultCallback, Conversation.ConversationType... conversationTypeArr) {
        RongIMClient.getInstance().getConversationList(resultCallback, conversationTypeArr);
    }

    @Deprecated
    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, String str2, int i, int i2) {
        return RongIMClient.getInstance().getHistoryMessages(conversationType, str, str2, i, i2);
    }

    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, RemoteHistoryMsgOption remoteHistoryMsgOption, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getRemoteHistoryMessages(conversationType, str, remoteHistoryMsgOption, resultCallback);
    }

    public void getUnreadCount(RongIMClient.ResultCallback<Integer> resultCallback, Conversation.ConversationType... conversationTypeArr) {
        RongIMClient.getInstance().getUnreadCount(resultCallback, conversationTypeArr);
    }

    public void insertIncomingMessage(Conversation.ConversationType conversationType, String str, String str2, Message.ReceivedStatus receivedStatus, MessageContent messageContent, long j, final RongIMClient.ResultCallback<Message> resultCallback) {
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        if (messageTag != null && (messageTag.flag() & 1) == 1) {
            RongIMClient.getInstance().insertIncomingMessage(conversationType, str, str2, receivedStatus, messageContent, j, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.RongIM.29
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onError(errorCode);
                    }
                    if (RongContext.getInstance() == null) {
                        RLog.e(RongIM.TAG, "insertIncomingMessage. RongIM SDK not init, please do after init.");
                    } else {
                        RongContext.getInstance().getEventBus().post(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Message message) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onSuccess(message);
                    }
                    RongContext.getInstance().getEventBus().post(message);
                }
            });
            return;
        }
        if (resultCallback != null) {
            resultCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
        }
        RLog.e(TAG, "insertMessage Message is missing MessageTag.ISPERSISTED");
    }

    public void insertOutgoingMessage(Conversation.ConversationType conversationType, String str, Message.SentStatus sentStatus, MessageContent messageContent, long j, final RongIMClient.ResultCallback<Message> resultCallback) {
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        if (messageTag != null && (messageTag.flag() & 1) == 1) {
            RongIMClient.getInstance().insertOutgoingMessage(conversationType, str, sentStatus, messageContent, j, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.RongIM.30
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onError(errorCode);
                    }
                    if (RongContext.getInstance() == null) {
                        RLog.e(RongIM.TAG, "insertOutgoingMessage. RongIM SDK not init, please do after init.");
                    } else {
                        RongContext.getInstance().getEventBus().post(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Message message) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onSuccess(message);
                    }
                    RongContext.getInstance().getEventBus().post(message);
                }
            });
            return;
        }
        if (resultCallback != null) {
            resultCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
        }
        RLog.e(TAG, "insertMessage Message is missing MessageTag.ISPERSISTED");
    }

    public void setConversationToTop(final Conversation.ConversationType conversationType, final String str, final boolean z, final boolean z2, final RongIMClient.ResultCallback<Boolean> resultCallback) {
        RongIMClient.getInstance().setConversationToTop(conversationType, str, z, z2, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.RongIM.16
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongIMClient.ResultCallback resultCallback2 = resultCallback;
                if (resultCallback2 != null) {
                    resultCallback2.onSuccess(bool);
                }
                if (bool.booleanValue()) {
                    if (!z || z2) {
                        RongContext.getInstance().getEventBus().post(new Event.ConversationTopEvent(conversationType, str, z));
                    }
                }
            }
        });
    }

    public static void init(Context context, String str, boolean z) {
        SingletonHolder.sRongIM.initSDK(context, str, z);
    }

    private MessageContent setMessageAttachedUserInfo(MessageContent messageContent) {
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "setMessageAttachedUserInfo. RongIM SDK not init, please do after init.");
            return messageContent;
        }
        if (RongContext.getInstance().getUserInfoAttachedState() && messageContent.getUserInfo() == null) {
            String currentUserId = getInstance().getCurrentUserId();
            UserInfo currentUserInfo = RongContext.getInstance().getCurrentUserInfo();
            if (currentUserInfo == null) {
                currentUserInfo = RongUserInfoManager.getInstance().getUserInfo(currentUserId);
            }
            if (currentUserInfo != null) {
                messageContent.setUserInfo(currentUserInfo);
            }
        }
        return messageContent;
    }

    public void getHistoryMessages(Conversation.ConversationType conversationType, String str, String str2, int i, int i2, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, str, str2, i, i2, resultCallback);
    }

    public void getUnreadCount(Conversation.ConversationType[] conversationTypeArr, boolean z, RongIMClient.ResultCallback<Integer> resultCallback) {
        RongIMClient.getInstance().getUnreadCount(conversationTypeArr, z, resultCallback);
    }

    public static void init(Context context) {
        SingletonHolder.sRongIM.initSDK(context, null, true);
    }

    public void createDiscussionChat(final Context context, final List<String> list, final String str, final RongIMClient.CreateDiscussionCallback createDiscussionCallback) {
        if (context != null && list != null && list.size() != 0) {
            RongIMClient.getInstance().createDiscussion(str, list, new RongIMClient.CreateDiscussionCallback() { // from class: io.rong.imkit.RongIM.12
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RLog.d(RongIM.TAG, "createDiscussionChat createDiscussion not success." + errorCode);
                    RongIMClient.CreateDiscussionCallback createDiscussionCallback2 = createDiscussionCallback;
                    if (createDiscussionCallback2 != null) {
                        createDiscussionCallback2.onError(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(String str2) {
                    String str3 = context.getApplicationInfo().packageName;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.DISCUSSION.getName().toLowerCase(Locale.US)).appendQueryParameter("targetIds", TextUtils.join(",", list)).appendQueryParameter("delimiter", ",").appendQueryParameter("targetId", str2).appendQueryParameter("title", str).build());
                    intent.setPackage(str3);
                    context.startActivity(intent);
                    RongIMClient.CreateDiscussionCallback createDiscussionCallback2 = createDiscussionCallback;
                    if (createDiscussionCallback2 != null) {
                        createDiscussionCallback2.onSuccess(str2);
                    }
                }
            });
        } else {
            RLog.e(TAG, "createDiscussionChat. context, targetUserIds or targetUserIds.size can not be empty!!!");
        }
    }

    public void getHistoryMessages(Conversation.ConversationType conversationType, String str, int i, int i2, RongIMClient.ResultCallback<List<Message>> resultCallback) {
        RongIMClient.getInstance().getHistoryMessages(conversationType, str, i, i2, resultCallback);
    }

    public void getUnreadCount(Conversation.ConversationType[] conversationTypeArr, RongIMClient.ResultCallback<Integer> resultCallback) {
        RongIMClient.getInstance().getUnreadCount(conversationTypeArr, resultCallback);
    }

    public void sendMessage(Message message, String str, String str2, SendMessageOption sendMessageOption, final IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            RLog.w(TAG, "sendMessage: 因在 onSend 中消息被过滤为 null，取消发送。");
            return;
        }
        Message message2 = messageFilterSendMessage != message ? messageFilterSendMessage : message;
        MessageContent content = message2.getContent();
        setMessageAttachedUserInfo(content);
        message2.setContent(content);
        RongIMClient.getInstance().sendMessage(message2, str, str2, sendMessageOption, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.RongIM.32
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message3) {
                MessageTag messageTag = (MessageTag) message3.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && (messageTag.flag() & 1) == 1) {
                    RongContext.getInstance().getEventBus().post(message3);
                }
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onAttached(message3);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message3, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message3, errorCode);
                if (iSendMessageCallback != null) {
                    if (errorCode.equals(RongIMClient.ErrorCode.RC_MSG_REPLACED_SENSITIVE_WORD)) {
                        iSendMessageCallback.onSuccess(message3);
                    } else {
                        iSendMessageCallback.onError(message3, errorCode);
                    }
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message3) {
                RongIM.this.filterSentMessage(message3, null);
                IRongCallback.ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                if (iSendMessageCallback2 != null) {
                    iSendMessageCallback2.onSuccess(message3);
                }
            }
        });
    }

    public void sendMediaMessage(Message message, String str, String str2, final IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            return;
        }
        if (messageFilterSendMessage != message) {
            message = messageFilterSendMessage;
        }
        setMessageAttachedUserInfo(message.getContent());
        RongIMClient.getInstance().sendMediaMessage(message, str, str2, new IRongCallback.ISendMediaMessageCallbackWithUploader() { // from class: io.rong.imkit.RongIM.57
            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallbackWithUploader
            public void onAttached(Message message2, IRongCallback.MediaMessageUploader mediaMessageUploader) {
                MessageTag messageTag = (MessageTag) message2.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag != null && (messageTag.flag() & 1) == 1) {
                    RongContext.getInstance().getEventBus().post(message2);
                }
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onAttached(message2, mediaMessageUploader);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallbackWithUploader
            public void onCanceled(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onCanceled(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallbackWithUploader
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onError(message2, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallbackWithUploader
            public void onProgress(Message message2, int i) {
                RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
                result.t = new Event.OnReceiveMessageProgressEvent();
                ((Event.OnReceiveMessageProgressEvent) result.t).setMessage(message2);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onProgress(message2, i);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallbackWithUploader
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onSuccess(message2);
                }
            }
        });
    }

    private Message filterSendMessage(Message message) {
        if (RongContext.getInstance() != null) {
            return RongContext.getInstance().getOnSendMessageListener() != null ? RongContext.getInstance().getOnSendMessageListener().onSend(message) : message;
        }
        RLog.e(TAG, "filterSendMessage. RongIM SDK not init, please do after init.");
        return message;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
    public void sendImageMessage(Message message, String str, String str2, boolean z, final RongIMClient.SendImageMessageCallback sendImageMessageCallback) {
        if (z) {
            Message messageFilterSendMessage = filterSendMessage(message);
            if (messageFilterSendMessage == null) {
                return;
            }
            if (messageFilterSendMessage != message) {
                message = messageFilterSendMessage;
            }
        }
        setMessageAttachedUserInfo(message.getContent());
        final RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
        result.t = new Event.OnReceiveMessageProgressEvent();
        RongIMClient.getInstance().sendImageMessage(message, str, str2, new RongIMClient.SendImageMessageCallback() { // from class: io.rong.imkit.RongIM.35
            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onAttached(Message message2) {
                RongContext.getInstance().getEventBus().post(message2);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onAttached(message2);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onError(message2, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onProgress(Message message2, int i) {
                T t = result.t;
                if (t == 0) {
                    return;
                }
                ((Event.OnReceiveMessageProgressEvent) t).setMessage(message2);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onProgress(message2, i);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                RongIMClient.SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onSuccess(message2);
                }
            }
        });
    }

    public void sendMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String str2, String str3, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        sendMessage(Message.obtain(str, conversationType, messageContent), str2, str3, iSendMessageCallback);
    }

    public void startConversationList(Context context, Map<String, Boolean> map) {
        if (context == null) {
            RLog.e(TAG, "startConversationList. context can not be empty!!!");
            return;
        }
        if (RongContext.getInstance() == null) {
            RLog.e(TAG, "startConversationList. RongIM SDK not init, please do after init.");
            return;
        }
        String str = context.getApplicationInfo().packageName;
        Uri.Builder builderAppendPath = Uri.parse("rong://" + str).buildUpon().appendPath("conversationlist");
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                builderAppendPath.appendQueryParameter(str2, map.get(str2).booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            }
        }
        Intent intent = new Intent("android.intent.action.VIEW", builderAppendPath.build());
        intent.setPackage(str);
        context.startActivity(intent);
    }

    public void startConversation(Context context, Conversation.ConversationType conversationType, String str, String str2, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && conversationType != null) {
            String str3 = context.getApplicationInfo().packageName;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.setPackage(str3);
            context.startActivity(intent);
            return;
        }
        RLog.e(TAG, "startConversation. context, targetId or conversationType can not be empty!!!");
    }

    public void sendImageMessage(Message message, String str, String str2, RongIMClient.SendImageMessageCallback sendImageMessageCallback) {
        sendImageMessage(message, str, str2, true, sendImageMessageCallback);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, io.rong.imkit.model.Event$OnReceiveMessageProgressEvent] */
    public void sendImageMessage(Message message, String str, String str2, final RongIMClient.SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback) {
        Message messageFilterSendMessage = filterSendMessage(message);
        if (messageFilterSendMessage == null) {
            return;
        }
        if (messageFilterSendMessage != message) {
            message = messageFilterSendMessage;
        }
        final RongIMClient.ResultCallback.Result result = new RongIMClient.ResultCallback.Result();
        result.t = new Event.OnReceiveMessageProgressEvent();
        RongIMClient.getInstance().sendImageMessage(message, str, str2, new RongIMClient.SendImageMessageWithUploadListenerCallback() { // from class: io.rong.imkit.RongIM.36
            @Override // io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback
            public void onAttached(Message message2, RongIMClient.UploadImageStatusListener uploadImageStatusListener) {
                RongContext.getInstance().getEventBus().post(message2);
                RongIMClient.SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                if (sendImageMessageWithUploadListenerCallback2 != null) {
                    sendImageMessageWithUploadListenerCallback2.onAttached(message2, uploadImageStatusListener);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                RongIM.this.filterSentMessage(message2, errorCode);
                RongIMClient.SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                if (sendImageMessageWithUploadListenerCallback2 != null) {
                    sendImageMessageWithUploadListenerCallback2.onError(message2, errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback
            public void onProgress(Message message2, int i) {
                T t = result.t;
                if (t == 0) {
                    return;
                }
                ((Event.OnReceiveMessageProgressEvent) t).setMessage(message2);
                ((Event.OnReceiveMessageProgressEvent) result.t).setProgress(i);
                RongContext.getInstance().getEventBus().post(result.t);
                RongIMClient.SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                if (sendImageMessageWithUploadListenerCallback2 != null) {
                    sendImageMessageWithUploadListenerCallback2.onProgress(message2, i);
                }
            }

            @Override // io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback
            public void onSuccess(Message message2) {
                RongIM.this.filterSentMessage(message2, null);
                RongIMClient.SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                if (sendImageMessageWithUploadListenerCallback2 != null) {
                    sendImageMessageWithUploadListenerCallback2.onSuccess(message2);
                }
            }
        });
    }

    public void startConversation(Context context, Conversation.ConversationType conversationType, String str, String str2, long j) {
        if (context != null && !TextUtils.isEmpty(str) && conversationType != null) {
            String str3 = context.getApplicationInfo().packageName;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + str3).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
            intent.putExtra("indexMessageTime", j);
            intent.setPackage(str3);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        RLog.e(TAG, "startConversation. context, targetId or conversationType can not be empty!!!");
    }
}
