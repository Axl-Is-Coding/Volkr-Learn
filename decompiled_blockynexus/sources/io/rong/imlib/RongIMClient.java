package io.rong.imlib;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.iid.InstanceID;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.ExpansionUtils;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.SystemUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.common.fwlog.IFwLogWriter;
import io.rong.common.rlog.RLog;
import io.rong.common.rlog.RLogReporter;
import io.rong.imlib.ConversationStatusListener;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.IChatRoomHistoryMessageCallback;
import io.rong.imlib.IConnectStringCallback;
import io.rong.imlib.IConnectionStatusListener;
import io.rong.imlib.IDataByBatchListener;
import io.rong.imlib.IDownloadMediaCallback;
import io.rong.imlib.IDownloadMediaFileCallback;
import io.rong.imlib.IDownloadMediaMessageCallback;
import io.rong.imlib.IGetConversationListWithProcessCallback;
import io.rong.imlib.IGetNotificationQuietHoursCallback;
import io.rong.imlib.IHandler;
import io.rong.imlib.IIntegerCallback;
import io.rong.imlib.ILongCallback;
import io.rong.imlib.IMessageExpansionListener;
import io.rong.imlib.INaviContentUpdateCallBack;
import io.rong.imlib.IOperationCallback;
import io.rong.imlib.IRLogOtherProgressCallback;
import io.rong.imlib.IResultCallback;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.ISendMediaMessageCallback;
import io.rong.imlib.ISendMessageCallback;
import io.rong.imlib.ISetPushSettingCallback;
import io.rong.imlib.IStringCallback;
import io.rong.imlib.IUploadCallback;
import io.rong.imlib.KVStatusDataByBatchListener;
import io.rong.imlib.OnReceiveMessageListener;
import io.rong.imlib.RongCommonDefine;
import io.rong.imlib.UserProfileSettingListener;
import io.rong.imlib.common.BuildVar;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.RongLibConst;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.cs.CustomServiceManager;
import io.rong.imlib.destruct.DestructionTaskManager;
import io.rong.imlib.destruct.MessageBufferPool;
import io.rong.imlib.ipc.IpcCallbackProxy;
import io.rong.imlib.ipc.RongService;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.RealTimeLocationManager;
import io.rong.imlib.location.RealTimeLocationObserver;
import io.rong.imlib.location.RealTimeLocationType;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.ChatRoomInfo;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.ConversationStatus;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageConfig;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.RemoteHistoryMsgOption;
import io.rong.imlib.model.RemoteModelWrap;
import io.rong.imlib.model.RongListWrap;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.rtc.RoomUserStateMessage;
import io.rong.imlib.statistics.Statistics;
import io.rong.imlib.typingmessage.TypingMessageManager;
import io.rong.imlib.typingmessage.TypingStatus;
import io.rong.imlib.typingmessage.TypingStatusMessage;
import io.rong.message.ChatRoomKVNotiMessage;
import io.rong.message.CommandMessage;
import io.rong.message.CommandNotificationMessage;
import io.rong.message.ContactNotificationMessage;
import io.rong.message.DestructionCmdMessage;
import io.rong.message.DiscussionNotificationMessage;
import io.rong.message.FileMessage;
import io.rong.message.GIFMessage;
import io.rong.message.GroupNotificationMessage;
import io.rong.message.HQVoiceMessage;
import io.rong.message.HandshakeMessage;
import io.rong.message.HistoryDividerMessage;
import io.rong.message.ImageMessage;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.LocationMessage;
import io.rong.message.LogCmdMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.MessageExpansionMessage;
import io.rong.message.ProfileNotificationMessage;
import io.rong.message.PublicServiceCommandMessage;
import io.rong.message.PublicServiceMultiRichContentMessage;
import io.rong.message.PublicServiceRichContentMessage;
import io.rong.message.RCEncryptCancelMessage;
import io.rong.message.RCEncryptConfirmMessage;
import io.rong.message.RCEncryptRequestMessage;
import io.rong.message.RCEncryptResponseMessage;
import io.rong.message.RCEncryptTerminateMessage;
import io.rong.message.RCEncryptedMessage;
import io.rong.message.ReadReceiptMessage;
import io.rong.message.ReadReceiptRequestMessage;
import io.rong.message.ReadReceiptResponseMessage;
import io.rong.message.RecallCommandMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.message.ReferenceMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.SuspendMessage;
import io.rong.message.SyncReadStatusMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import io.rong.message.utils.RCDHCodecTool;
import io.rong.push.PushManager;
import io.rong.push.RongPushClient;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.rongpush.PushReceiver;
import io.rong.rtlog.upload.RtFwLogConsolePrinter;
import java.io.File;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class RongIMClient {
    private static String PRIVATE_STATISTIC = null;
    private static final String TAG = "RongIMClient";
    private static String URL_STATISTIC = "https://stats.cn.ronghub.com/active.json";
    private static volatile boolean cancelSDKHeartBeatEnabled;
    private static AtomicReference<ChatRoomActionListener> chatRoomActionListener = new AtomicReference<>();
    private static boolean isInForeground;
    private static boolean isPushEnabled;
    private static String mFileServer;
    private static Handler mHandler;
    private static String mNaviServer;
    private static MessageExpansionListener messageExpansionListener;
    private static volatile boolean needCallBackDBOpen;
    private static ConnectionStatusListener sConnectionListener;
    private static ConversationStatusListener sConversationStatusListener;
    private static KVStatusListener sKVStatusListener;
    private static OnRecallMessageListener sOnRecallMessageListener;
    private static ReadReceiptListener sReadReceiptListener;
    private static OnReceiveMessageListener sReceiveMessageListener;
    private static boolean userPolicy;
    private final int CONVERSATION_NUMBER_OF_ONE_BATCH;
    private ConnectCallback connectCallback;
    private Timer connectTimeoutTimer;
    private IMLibExtensionModuleManager imLibExtensionModuleManager;
    private boolean kickReconnectDevice;
    private AidlConnection mAidlConnection;
    private String mAppKey;
    private HashMap<String, ChatRoomCacheRunnable> mChatRoomCache;
    private Set<String> mCmdObjectNameList;
    private ConnectChangeReceiver mConnectChangeReceiver;
    private ConnectRunnable mConnectRunnable;
    private ConnectionStatusListener.ConnectionStatus mConnectionStatus;
    private Context mContext;
    private String mCurrentUserId;
    private Set<String> mDeleteObjectNameList;
    private EncryptedSessionConnectionListener mEncSessionConListener;
    private IHandler mLibHandler;
    private OnReceiveDestructionMessageListener mOnReceiveDestructionMessageListener;
    private final List<String> mRegCache;
    private HashMap<String, ChatRoomCacheRunnable> mRetryCRCache;
    private StatusListener mStatusListener;
    private SyncConversationReadStatusListener mSyncConversationReadStatusListener;
    private volatile String mToken;
    private Handler mUpStreamHandler;
    private Handler mWorkHandler;
    private ConcurrentHashMap<String, Message> signalBuff;
    private Activity topForegroundActivity;

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$118, reason: invalid class name */
    class AnonymousClass118 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;

        AnonymousClass118(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                if (this.val$ipcCallbackProxy.callback != 0) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            ((IRongCallback.ISendMediaMessageCallback) anonymousClass118.val$ipcCallbackProxy.callback).onError(anonymousClass118.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass118.this.val$ipcCallbackProxy.callback = null;
                        }
                    });
                }
            } else {
                try {
                    RongIMClient.this.mLibHandler.sendMediaMessage(this.val$message, this.val$pushContent, this.val$pushData, new ISendMediaMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.118.2
                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onAttached(final Message message) throws RemoteException {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            if (anonymousClass118.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass118.this.val$ipcCallbackProxy.callback).onAttached(message);
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onCanceled(final Message message) throws RemoteException {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            if (anonymousClass118.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.2.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass118.this.val$ipcCallbackProxy.callback).onCanceled(message);
                                        AnonymousClass118.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onError(final Message message, final int i) throws RemoteException {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            if (anonymousClass118.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.2.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass118.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                        AnonymousClass118.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onProgress(final Message message, final int i) throws RemoteException {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            if (anonymousClass118.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass118.this.val$ipcCallbackProxy.callback).onProgress(message, i);
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onSuccess(final Message message) throws RemoteException {
                            AnonymousClass118 anonymousClass118 = AnonymousClass118.this;
                            if (anonymousClass118.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.118.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass118.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                        AnonymousClass118.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }
                    });
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "sendMediaMessage", e2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$119, reason: invalid class name */
    class AnonymousClass119 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;
        final /* synthetic */ String[] val$userIds;

        AnonymousClass119(IpcCallbackProxy ipcCallbackProxy, Message message, String[] strArr, String str, String str2) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$userIds = strArr;
            this.val$pushContent = str;
            this.val$pushData = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                if (this.val$ipcCallbackProxy.callback != 0) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            ((IRongCallback.ISendMediaMessageCallback) anonymousClass119.val$ipcCallbackProxy.callback).onError(anonymousClass119.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass119.this.val$ipcCallbackProxy.callback = null;
                        }
                    });
                }
            } else {
                try {
                    RongIMClient.this.mLibHandler.sendDirectionalMediaMessage(this.val$message, this.val$userIds, this.val$pushContent, this.val$pushData, new ISendMediaMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.119.2
                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onAttached(final Message message) throws RemoteException {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            if (anonymousClass119.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass119.this.val$ipcCallbackProxy.callback).onAttached(message);
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onCanceled(final Message message) throws RemoteException {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            if (anonymousClass119.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.2.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass119.this.val$ipcCallbackProxy.callback).onCanceled(message);
                                        AnonymousClass119.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onError(final Message message, final int i) throws RemoteException {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            if (anonymousClass119.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.2.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass119.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                        AnonymousClass119.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onProgress(final Message message, final int i) throws RemoteException {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            if (anonymousClass119.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass119.this.val$ipcCallbackProxy.callback).onProgress(message, i);
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onSuccess(final Message message) throws RemoteException {
                            AnonymousClass119 anonymousClass119 = AnonymousClass119.this;
                            if (anonymousClass119.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.119.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.ISendMediaMessageCallback) AnonymousClass119.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                        AnonymousClass119.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }
                    });
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "sendDirectionalMediaMessage", e2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$34, reason: invalid class name */
    class AnonymousClass34 implements Runnable {
        final /* synthetic */ int val$count;
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ TimestampOrder val$order;
        final /* synthetic */ long val$recordTime;
        final /* synthetic */ String val$targetId;

        AnonymousClass34(IpcCallbackProxy ipcCallbackProxy, String str, long j, int i, TimestampOrder timestampOrder) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$targetId = str;
            this.val$recordTime = j;
            this.val$count = i;
            this.val$order = timestampOrder;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                if (this.val$ipcCallbackProxy.callback != 0) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.34.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IRongCallback.IChatRoomHistoryMessageCallback) AnonymousClass34.this.val$ipcCallbackProxy.callback).onError(ErrorCode.IPC_DISCONNECT);
                            AnonymousClass34.this.val$ipcCallbackProxy.callback = null;
                        }
                    });
                    return;
                }
                return;
            }
            try {
                RongIMClient.this.mLibHandler.getChatroomHistoryMessages(this.val$targetId, this.val$recordTime, this.val$count, this.val$order.ordinal(), new IChatRoomHistoryMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.34.2
                    @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
                    public void onComplete(final RemoteModelWrap remoteModelWrap, final long j) throws RemoteException {
                        AnonymousClass34 anonymousClass34 = AnonymousClass34.this;
                        if (anonymousClass34.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.34.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    RemoteModelWrap remoteModelWrap2 = remoteModelWrap;
                                    if (remoteModelWrap2 != null) {
                                        ((IRongCallback.IChatRoomHistoryMessageCallback) AnonymousClass34.this.val$ipcCallbackProxy.callback).onSuccess(((RongListWrap) remoteModelWrap2.getContent()).getList(), j);
                                    } else {
                                        ((IRongCallback.IChatRoomHistoryMessageCallback) AnonymousClass34.this.val$ipcCallbackProxy.callback).onSuccess(null, j);
                                    }
                                    AnonymousClass34.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
                    public void onFailure(final int i) throws RemoteException {
                        AnonymousClass34 anonymousClass34 = AnonymousClass34.this;
                        if (anonymousClass34.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.34.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IChatRoomHistoryMessageCallback) AnonymousClass34.this.val$ipcCallbackProxy.callback).onError(ErrorCode.valueOf(i));
                                    AnonymousClass34.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "getChatroomHistoryMessages", e2);
                if (this.val$ipcCallbackProxy.callback != 0) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.34.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IRongCallback.IChatRoomHistoryMessageCallback) AnonymousClass34.this.val$ipcCallbackProxy.callback).onError(ErrorCode.IPC_DISCONNECT);
                            AnonymousClass34.this.val$ipcCallbackProxy.callback = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$57, reason: invalid class name */
    class AnonymousClass57 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;

        AnonymousClass57(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.57.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass57 anonymousClass57 = AnonymousClass57.this;
                        T t = anonymousClass57.val$ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((IRongCallback.ISendMessageCallback) t).onError(anonymousClass57.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass57.this.val$ipcCallbackProxy.callback = null;
                        }
                    }
                });
                return;
            }
            try {
                RongIMClient.this.mLibHandler.sendLocationMessage(this.val$message, this.val$pushContent, this.val$pushData, new ISendMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.57.2
                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onAttached(final Message message) throws RemoteException {
                        AnonymousClass57 anonymousClass57 = AnonymousClass57.this;
                        if (anonymousClass57.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.57.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass57.this.val$ipcCallbackProxy.callback).onAttached(message);
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onError(final Message message, final int i) throws RemoteException {
                        AnonymousClass57 anonymousClass57 = AnonymousClass57.this;
                        if (anonymousClass57.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.57.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass57.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                    AnonymousClass57.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onSuccess(final Message message) throws RemoteException {
                        AnonymousClass57 anonymousClass57 = AnonymousClass57.this;
                        if (anonymousClass57.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.57.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass57.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                    AnonymousClass57.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "sendLocationMessage", e2);
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$58, reason: invalid class name */
    class AnonymousClass58 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ SendMessageOption val$option;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;

        AnonymousClass58(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2, SendMessageOption sendMessageOption) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
            this.val$option = sendMessageOption;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.58.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                        T t = anonymousClass58.val$ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((IRongCallback.ISendMessageCallback) t).onError(anonymousClass58.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass58.this.val$ipcCallbackProxy.callback = null;
                        }
                    }
                });
                return;
            }
            try {
                RongIMClient.this.mLibHandler.sendMessageOption(this.val$message, this.val$pushContent, this.val$pushData, this.val$option, new ISendMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.58.2
                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onAttached(final Message message) throws RemoteException {
                        AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                        if (anonymousClass58.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.58.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass58.this.val$ipcCallbackProxy.callback).onAttached(message);
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onError(final Message message, final int i) throws RemoteException {
                        AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                        if (anonymousClass58.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.58.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass58.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                    AnonymousClass58.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onSuccess(final Message message) throws RemoteException {
                        AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                        if (anonymousClass58.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.58.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass58.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                    AnonymousClass58.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "sendMessage exception : ", e2);
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$59, reason: invalid class name */
    class AnonymousClass59 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;
        final /* synthetic */ String[] val$userIds;

        AnonymousClass59(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2, String[] strArr) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
            this.val$userIds = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.59.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass59 anonymousClass59 = AnonymousClass59.this;
                        T t = anonymousClass59.val$ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((IRongCallback.ISendMessageCallback) t).onError(anonymousClass59.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass59.this.val$ipcCallbackProxy.callback = null;
                        }
                    }
                });
                return;
            }
            try {
                RongIMClient.this.mLibHandler.sendDirectionalMessage(this.val$message, this.val$pushContent, this.val$pushData, this.val$userIds, new ISendMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.59.2
                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onAttached(final Message message) throws RemoteException {
                        AnonymousClass59 anonymousClass59 = AnonymousClass59.this;
                        if (anonymousClass59.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.59.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass59.this.val$ipcCallbackProxy.callback).onAttached(message);
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onError(final Message message, final int i) throws RemoteException {
                        AnonymousClass59 anonymousClass59 = AnonymousClass59.this;
                        if (anonymousClass59.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.59.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass59.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                    AnonymousClass59.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onSuccess(final Message message) throws RemoteException {
                        AnonymousClass59 anonymousClass59 = AnonymousClass59.this;
                        if (anonymousClass59.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.59.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass59.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                    AnonymousClass59.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "sendDirectionalMessage exception : ", e2);
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$64, reason: invalid class name */
    class AnonymousClass64 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;

        AnonymousClass64(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                if (this.val$ipcCallbackProxy.callback != 0) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.64.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass64 anonymousClass64 = AnonymousClass64.this;
                            ((SendImageMessageCallback) anonymousClass64.val$ipcCallbackProxy.callback).onError(anonymousClass64.val$message, ErrorCode.IPC_DISCONNECT);
                            AnonymousClass64.this.val$ipcCallbackProxy.callback = null;
                        }
                    });
                }
            } else {
                try {
                    RongIMClient.this.mLibHandler.sendMediaMessage(this.val$message, this.val$pushContent, this.val$pushData, new ISendMediaMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.64.2
                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onAttached(Message message) throws RemoteException {
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onCanceled(Message message) throws RemoteException {
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onError(final Message message, final int i) throws RemoteException {
                            AnonymousClass64 anonymousClass64 = AnonymousClass64.this;
                            if (anonymousClass64.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.64.2.2
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((SendImageMessageCallback) AnonymousClass64.this.val$ipcCallbackProxy.callback).onError(message, ErrorCode.valueOf(i));
                                        AnonymousClass64.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onProgress(Message message, int i) throws RemoteException {
                        }

                        @Override // io.rong.imlib.ISendMediaMessageCallback
                        public void onSuccess(final Message message) throws RemoteException {
                            AnonymousClass64 anonymousClass64 = AnonymousClass64.this;
                            if (anonymousClass64.val$ipcCallbackProxy.callback != 0) {
                                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.64.2.1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((SendImageMessageCallback) AnonymousClass64.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                        AnonymousClass64.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }
                    });
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "internalSendImageMessage", e2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$67, reason: invalid class name */
    class AnonymousClass67 implements Runnable {
        final /* synthetic */ IRongCallback.IDownloadMediaMessageCallback val$callback;
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ Message val$message;

        AnonymousClass67(IpcCallbackProxy ipcCallbackProxy, Message message, IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$callback = iDownloadMediaMessageCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                T t = this.val$ipcCallbackProxy.callback;
                if (t != 0) {
                    ((IRongCallback.IDownloadMediaMessageCallback) t).onError(this.val$message, ErrorCode.IPC_DISCONNECT);
                    this.val$ipcCallbackProxy.callback = null;
                    return;
                }
                return;
            }
            try {
                RongIMClient.this.mLibHandler.downloadMediaMessage(this.val$message, new IDownloadMediaMessageCallback.Stub() { // from class: io.rong.imlib.RongIMClient.67.1
                    @Override // io.rong.imlib.IDownloadMediaMessageCallback
                    public void onCanceled() throws RemoteException {
                        AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                        if (anonymousClass67.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.67.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass67 anonymousClass672 = AnonymousClass67.this;
                                    T t2 = anonymousClass672.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaMessageCallback) t2).onCanceled(anonymousClass672.val$message);
                                        AnonymousClass67.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaMessageCallback
                    public void onComplete(final Message message) throws RemoteException {
                        AnonymousClass67.this.val$message.setContent(message.getContent());
                        AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                        if (anonymousClass67.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.67.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    T t2 = AnonymousClass67.this.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaMessageCallback) t2).onSuccess(message);
                                        AnonymousClass67.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaMessageCallback
                    public void onFailure(final int i) throws RemoteException {
                        AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                        if (anonymousClass67.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.67.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass67 anonymousClass672 = AnonymousClass67.this;
                                    T t2 = anonymousClass672.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaMessageCallback) t2).onError(anonymousClass672.val$message, ErrorCode.valueOf(i));
                                        AnonymousClass67.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaMessageCallback
                    public void onProgress(final int i) throws RemoteException {
                        AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                        if (anonymousClass67.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.67.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass67 anonymousClass672 = AnonymousClass67.this;
                                    ((IRongCallback.IDownloadMediaMessageCallback) anonymousClass672.val$ipcCallbackProxy.callback).onProgress(anonymousClass672.val$message, i);
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "downloadMediaMessage", e2);
                if (this.val$callback != null) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.67.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                            anonymousClass67.val$callback.onError(anonymousClass67.val$message, ErrorCode.IPC_DISCONNECT);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.RongIMClient$68, reason: invalid class name */
    class AnonymousClass68 implements Runnable {
        final /* synthetic */ IRongCallback.IDownloadMediaFileCallback val$callback;
        final /* synthetic */ String val$fileName;
        final /* synthetic */ String val$fileUniqueId;
        final /* synthetic */ String val$fileUrl;
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ String val$path;

        AnonymousClass68(IpcCallbackProxy ipcCallbackProxy, String str, String str2, String str3, String str4, IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$fileUniqueId = str;
            this.val$fileUrl = str2;
            this.val$fileName = str3;
            this.val$path = str4;
            this.val$callback = iDownloadMediaFileCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RongIMClient.this.mLibHandler == null) {
                T t = this.val$ipcCallbackProxy.callback;
                if (t != 0) {
                    ((IRongCallback.IDownloadMediaFileCallback) t).onError(ErrorCode.IPC_DISCONNECT);
                    this.val$ipcCallbackProxy.callback = null;
                    return;
                }
                return;
            }
            try {
                RongIMClient.this.mLibHandler.downloadMediaFile(this.val$fileUniqueId, this.val$fileUrl, this.val$fileName, this.val$path, new IDownloadMediaFileCallback.Stub() { // from class: io.rong.imlib.RongIMClient.68.1
                    @Override // io.rong.imlib.IDownloadMediaFileCallback
                    public void onCanceled() throws RemoteException {
                        AnonymousClass68 anonymousClass68 = AnonymousClass68.this;
                        if (anonymousClass68.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.68.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    T t2 = AnonymousClass68.this.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaFileCallback) t2).onCanceled();
                                        AnonymousClass68.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaFileCallback
                    public void onComplete() throws RemoteException {
                        AnonymousClass68 anonymousClass68 = AnonymousClass68.this;
                        if (anonymousClass68.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.68.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    T t2 = AnonymousClass68.this.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaFileCallback) t2).onSuccess();
                                        AnonymousClass68.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaFileCallback
                    public void onFailure(final int i) throws RemoteException {
                        AnonymousClass68 anonymousClass68 = AnonymousClass68.this;
                        if (anonymousClass68.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.68.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    T t2 = AnonymousClass68.this.val$ipcCallbackProxy.callback;
                                    if (t2 != 0) {
                                        ((IRongCallback.IDownloadMediaFileCallback) t2).onError(ErrorCode.valueOf(i));
                                        AnonymousClass68.this.val$ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.IDownloadMediaFileCallback
                    public void onFileNameChanged(String str) {
                        AnonymousClass68.this.val$callback.onFileNameChanged(str);
                    }

                    @Override // io.rong.imlib.IDownloadMediaFileCallback
                    public void onProgress(final int i) throws RemoteException {
                        AnonymousClass68 anonymousClass68 = AnonymousClass68.this;
                        if (anonymousClass68.val$ipcCallbackProxy.callback != 0) {
                            RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.68.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IDownloadMediaFileCallback) AnonymousClass68.this.val$ipcCallbackProxy.callback).onProgress(i);
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "downloadMediaFile", e2);
                if (this.val$callback != null) {
                    RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.68.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass68.this.val$callback.onError(ErrorCode.IPC_DISCONNECT);
                        }
                    });
                }
            }
        }
    }

    private class AidlConnection implements ServiceConnection {
        private AidlConnection() {
        }

        private boolean canConnectStatus() {
            return (RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.SIGN_OUT) || RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.UNCONNECTED) || RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT) || RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.CONN_USER_BLOCKED) || RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.TOKEN_INCORRECT) || RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.TIMEOUT)) ? false : true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            FwLog.write(4, 1, FwLog.LogTag.BIND_SERVICE_S.getTag(), "bent", true);
            RongIMClient.this.mLibHandler = IHandler.Stub.asInterface(iBinder);
            try {
                RongIMClient.this.mLibHandler.initAppendixModule();
            } catch (Exception e2) {
                RLog.e(RongIMClient.TAG, "onServiceConnected initAppendix error", e2);
            }
            if (TextUtils.isEmpty(RongIMClient.this.mToken) && canConnectStatus()) {
                RongIMClient.this.mConnectionStatus = ConnectionStatusListener.ConnectionStatus.UNCONNECTED;
                RLog.i(RongIMClient.TAG, "onServiceConnected token is null；status:" + RongIMClient.this.mConnectionStatus);
            }
            try {
                RLog.i(RongIMClient.TAG, "initIPCEnviroment token:" + RongIMClient.this.mToken + " status:" + RongIMClient.this.mConnectionStatus);
                RongIMClient.this.mLibHandler.initIPCEnviroment(RongIMClient.this.mToken, RongIMClient.this.mConnectionStatus.getValue());
            } catch (Exception e3) {
                RLog.e(RongIMClient.TAG, "onServiceConnected initIPCEnviroment error", e3);
            }
            RongIMClient.this.setIPCLogListener();
            RongIMClient.this.initReceiver();
            ModuleManager.init(RongIMClient.this.mContext, RongIMClient.this.mLibHandler, RongIMClient.sReceiveMessageListener);
            IMLibRTCClient.getInstance().OnServiceConnected(RongIMClient.this.mLibHandler);
            RLog.d(RongIMClient.TAG, "onServiceConnected mConnectionStatus = " + RongIMClient.this.mConnectionStatus);
            if (RongIMClient.this.mConnectRunnable != null) {
                RongIMClient.mHandler.post(RongIMClient.this.mConnectRunnable);
            } else if (RongIMClient.this.mToken != null) {
                RongIMClient rongIMClient = RongIMClient.this;
                rongIMClient.connectServer(rongIMClient.mToken, true);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FwLog.write(4, 1, FwLog.LogTag.BIND_SERVICE_S.getTag(), "bent", false);
            ModuleManager.unInit();
            RongIMClient.this.mLibHandler = null;
            IMLibRTCClient.getInstance().OnServiceDisconnected();
            RLog.d(RongIMClient.TAG, "onServiceDisconnected " + RongIMClient.this.mConnectionStatus);
            if (canConnectStatus()) {
                RongIMClient.this.mStatusListener.onConnectionStatusChange(ConnectionStatusListener.ConnectionStatus.SUSPEND);
            }
            RongIMClient.this.initBindService();
        }
    }

    public enum BlacklistStatus {
        IN_BLACK_LIST(0),
        NOT_IN_BLACK_LIST(1);

        private int value;

        BlacklistStatus(int i) {
            this.value = i;
        }

        public static BlacklistStatus setValue(int i) {
            for (BlacklistStatus blacklistStatus : values()) {
                if (i == blacklistStatus.getValue()) {
                    return blacklistStatus;
                }
            }
            return NOT_IN_BLACK_LIST;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static abstract class Callback {
        public void onCallback() {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.Callback.1
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onSuccess();
                }
            });
        }

        public abstract void onError(ErrorCode errorCode);

        public void onFail(final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.Callback.2
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onError(ErrorCode.valueOf(i));
                }
            });
        }

        public abstract void onSuccess();

        public void onFail(final ErrorCode errorCode) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.Callback.3
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onError(errorCode);
                }
            });
        }
    }

    public interface ChatRoomActionListener {
        void onError(String str, ErrorCode errorCode);

        void onJoined(String str);

        void onJoining(String str);

        void onQuited(String str);
    }

    private class ChatRoomCacheRunnable implements Runnable {
        String chatRoomId;
        boolean chatRoomIdExist;
        int count;
        boolean onceSuccess;

        ChatRoomCacheRunnable(String str, int i, boolean z) {
            this.count = i;
            this.chatRoomId = str;
            this.chatRoomIdExist = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.d(RongIMClient.TAG, "re-join chatroom " + this);
            RongIMClient.this.mRetryCRCache.remove(this.chatRoomId);
            if (RongIMClient.this.mLibHandler == null || !RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
                RLog.e(RongIMClient.TAG, "re-join chatroom error : " + RongIMClient.this.mConnectionStatus + ", mLibHandler = " + RongIMClient.this.mLibHandler);
                return;
            }
            try {
                IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(null);
                ChatRoomActionListener chatRoomActionListener = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
                if (chatRoomActionListener != null) {
                    chatRoomActionListener.onJoining(this.chatRoomId);
                }
                String tag = FwLog.LogTag.A_REJOIN_CHATROOM_T.getTag();
                Object[] objArr = new Object[3];
                objArr[0] = this.chatRoomId;
                objArr[1] = Boolean.valueOf(this.chatRoomIdExist);
                objArr[2] = Integer.valueOf(this.onceSuccess ? -1 : this.count);
                FwLog.write(3, 1, tag, "room_id|existed|count", objArr);
                if (this.chatRoomIdExist) {
                    RongIMClient.this.mLibHandler.joinExistChatRoom(this.chatRoomId, this.onceSuccess ? -1 : this.count, RongIMClient.this.new JoinChatRoomCallback(ipcCallbackProxy, this.chatRoomId, this.count, RongIMClient.this.mLibHandler.getJoinMultiChatRoomEnable(), this.chatRoomIdExist, true), true);
                } else {
                    RongIMClient.this.mLibHandler.reJoinChatRoom(this.chatRoomId, this.onceSuccess ? -1 : this.count, RongIMClient.this.new JoinChatRoomCallback(ipcCallbackProxy, this.chatRoomId, this.count, RongIMClient.this.mLibHandler.getJoinMultiChatRoomEnable(), this.chatRoomIdExist, true));
                }
            } catch (Exception e2) {
                FwLog.write(1, 1, FwLog.LogTag.A_REJOIN_CHATROOM_R.getTag(), "code|room_id|stacks", -1, this.chatRoomId, FwLog.stackToString(e2));
                RLog.e(RongIMClient.TAG, "ChatRoomCacheRunnable", e2);
                RLog.e(RongIMClient.TAG, "re-join chatroom exception");
            }
        }

        public String toString() {
            return "ChatRoomCacheRunnable{chatRoomId='" + this.chatRoomId + "', count=" + this.count + ", onceSuccess=" + this.onceSuccess + ", chatRoomIdExist=" + this.chatRoomIdExist + ", state='" + RongIMClient.this.mConnectionStatus + "'}";
        }
    }

    public static abstract class ConnectCallback {
        void onCallback(final String str) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ConnectCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectCallback.this.onSuccess(str);
                }
            });
        }

        public abstract void onDatabaseOpened(DatabaseOpenStatus databaseOpenStatus);

        public abstract void onError(ConnectionErrorCode connectionErrorCode);

        void onFail(final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ConnectCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectCallback.this.onError(ConnectionErrorCode.valueOf(i));
                }
            });
        }

        public abstract void onSuccess(String str);

        void onFail(final ConnectionErrorCode connectionErrorCode) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ConnectCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectCallback.this.onError(connectionErrorCode);
                }
            });
        }
    }

    private class ConnectRunnable implements Runnable {
        String token;

        ConnectRunnable(String str) {
            RLog.d(RongIMClient.TAG, "[connect] ConnectRunnable for connect");
            this.token = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.d(RongIMClient.TAG, "[connect] ConnectRunnable do connect!");
            RongIMClient.this.connectServer(this.token, false);
        }
    }

    public enum ConnectionErrorCode {
        IPC_DISCONNECT(ErrorCode.IPC_DISCONNECT.getValue()),
        RC_CONN_ID_REJECT(ErrorCode.RC_CONN_ID_REJECT.getValue()),
        RC_CONN_TOKEN_INCORRECT(ErrorCode.RC_CONN_USER_OR_PASSWD_ERROR.getValue()),
        RC_CONN_NOT_AUTHRORIZED(ErrorCode.RC_CONN_NOT_AUTHRORIZED.getValue()),
        RC_CONN_PACKAGE_NAME_INVALID(ErrorCode.RC_CONN_PACKAGE_NAME_INVALID.getValue()),
        RC_CONN_APP_BLOCKED_OR_DELETED(ErrorCode.RC_CONN_APP_BLOCKED_OR_DELETED.getValue()),
        RC_CONN_USER_BLOCKED(ErrorCode.RC_CONN_USER_BLOCKED.getValue()),
        RC_DISCONN_KICK(ErrorCode.RC_DISCONN_KICK.getValue()),
        RC_CONN_OTHER_DEVICE_LOGIN(ErrorCode.RC_CONN_OTHER_DEVICE_LOGIN.getValue()),
        RC_CLIENT_NOT_INIT(ErrorCode.BIZ_ERROR_CLIENT_NOT_INIT.getValue()),
        RC_INVALID_PARAMETER(ErrorCode.PARAMETER_ERROR.getValue()),
        RC_CONNECTION_EXIST(ErrorCode.RC_CONNECTION_EXIST.getValue()),
        RC_ENVIRONMENT_ERROR(ErrorCode.RC_ENVIRONMENT_ERROR.getValue()),
        RC_CONNECT_TIMEOUT(ErrorCode.RC_CONNECT_TIMEOUT.getValue()),
        UNKNOWN(-1);

        private int code;

        ConnectionErrorCode(int i) {
            this.code = i;
        }

        public int getValue() {
            return this.code;
        }

        public static ConnectionErrorCode valueOf(int i) {
            for (ConnectionErrorCode connectionErrorCode : values()) {
                if (i == connectionErrorCode.getValue()) {
                    return connectionErrorCode;
                }
            }
            RLog.d(RongIMClient.TAG, "valueOf,ConnectionErrorCode:" + i);
            ConnectionErrorCode connectionErrorCode2 = UNKNOWN;
            connectionErrorCode2.code = i;
            return connectionErrorCode2;
        }
    }

    public interface ConnectionStatusListener {

        public enum ConnectionStatus {
            NETWORK_UNAVAILABLE(-1, "Network is unavailable."),
            CONNECTED(0, "Connect Success."),
            CONNECTING(1, "Connecting"),
            UNCONNECTED(2, "UNCONNECTED"),
            KICKED_OFFLINE_BY_OTHER_CLIENT(3, "Login on the other device, and be kicked offline."),
            TOKEN_INCORRECT(4, "Token incorrect."),
            CONN_USER_BLOCKED(6, "User blocked by admin"),
            SIGN_OUT(12, "user sign out"),
            SUSPEND(13, "SUSPEND"),
            TIMEOUT(14, InstanceID.ERROR_TIMEOUT);

            private int code;
            private String msg;

            ConnectionStatus(int i, String str) {
                this.code = i;
                this.msg = str;
            }

            public String getMessage() {
                return this.msg;
            }

            public int getValue() {
                return this.code;
            }

            public static ConnectionStatus valueOf(int i) {
                for (ConnectionStatus connectionStatus : values()) {
                    if (connectionStatus.code == i) {
                        return connectionStatus;
                    }
                }
                RLog.d(RongIMClient.TAG, "valueOf,ErrorCode:" + i);
                return CONNECTING;
            }
        }

        void onChanged(ConnectionStatus connectionStatus);
    }

    public interface ConversationStatusListener {
        void onStatusChanged(ConversationStatus[] conversationStatusArr);
    }

    public static abstract class CreateDiscussionCallback extends ResultCallback<String> {
    }

    public enum DatabaseOpenStatus {
        DATABASE_OPEN_SUCCESS(0),
        DATABASE_OPEN_ERROR(33002);

        private int code;

        DatabaseOpenStatus(int i) {
            this.code = i;
        }

        public int getValue() {
            return this.code;
        }

        public static DatabaseOpenStatus valueOf(int i) {
            for (DatabaseOpenStatus databaseOpenStatus : values()) {
                if (i == databaseOpenStatus.getValue()) {
                    return databaseOpenStatus;
                }
            }
            return DATABASE_OPEN_ERROR;
        }
    }

    private class DefaultOperationCallback extends IOperationCallback.Stub {
        private IpcCallbackProxy<OperationCallback> ipcCallbackProxy;

        public DefaultOperationCallback(IpcCallbackProxy<OperationCallback> ipcCallbackProxy) {
            this.ipcCallbackProxy = ipcCallbackProxy;
        }

        public void onComplete() {
            OperationCallback operationCallback = this.ipcCallbackProxy.callback;
            if (operationCallback != null) {
                operationCallback.onCallback();
                this.ipcCallbackProxy.callback = null;
            }
        }

        public void onFailure(int i) {
            OperationCallback operationCallback = this.ipcCallbackProxy.callback;
            if (operationCallback != null) {
                operationCallback.onFail(i);
                this.ipcCallbackProxy.callback = null;
            }
        }
    }

    public interface DestructCountDownTimerListener {
        void onStop(String str);

        void onTick(long j, String str);
    }

    public enum DiscussionInviteStatus {
        CLOSED(1),
        OPENED(0);

        private int value;

        DiscussionInviteStatus(int i) {
            this.value = i;
        }

        public static DiscussionInviteStatus setValue(int i) {
            for (DiscussionInviteStatus discussionInviteStatus : values()) {
                if (i == discussionInviteStatus.getValue()) {
                    return discussionInviteStatus;
                }
            }
            return OPENED;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static abstract class DownloadMediaCallback extends ResultCallback<String> {
        public abstract void onProgress(int i);

        void onProgressCallback(final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.DownloadMediaCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadMediaCallback.this.onProgress(i);
                }
            });
        }
    }

    public interface EncryptedSessionConnectionListener {
        void onEncryptedSessionCanceled(String str);

        void onEncryptedSessionEstablished(String str);

        void onEncryptedSessionRequest(String str, boolean z);

        void onEncryptedSessionResponse(String str);

        void onEncryptedSessionTerminated(String str);
    }

    public enum ErrorCode {
        APP_NOT_CONNECT(-4, "APP hasn't call connect function."),
        PARAMETER_ERROR(33003, "the parameter is error."),
        IPC_DISCONNECT(-2, "IPC is not connected"),
        UNKNOWN(-1, "unknown"),
        CONNECTED(0, "connected"),
        MSG_SEND_OVERFREQUENCY(20604, "message send over frequency."),
        RC_OPERATION_BLOCKED(20605, ""),
        RC_OPERATION_NOT_SUPPORT(20606, ""),
        RC_REQUEST_OVERFREQUENCY(20607, ""),
        MSG_ROAMING_SERVICE_UNAVAILABLE(33007, "Message roaming service unavailable"),
        NOT_IN_DISCUSSION(21406, ""),
        RC_MSG_BLOCKED_SENSITIVE_WORD(21501, "word is blocked"),
        RC_MSG_REPLACED_SENSITIVE_WORD(21502, "word is replaced"),
        NOT_IN_GROUP(22406, ""),
        FORBIDDEN_IN_GROUP(22408, ""),
        NOT_IN_CHATROOM(23406, ""),
        FORBIDDEN_IN_CHATROOM(23408, ""),
        KICKED_FROM_CHATROOM(23409, ""),
        RC_CHATROOM_NOT_EXIST(23410, "Chat room does not exist"),
        RC_CHATROOM_IS_FULL(23411, "Chat room is full"),
        RC_CHATROOM_ILLEGAL_ARGUMENT(23412, "illegal argument."),
        RC_SETTING_SYNC_FAILED(26002, ""),
        RC_APP_PUBLICSERVICE_DEFFOLLOWED(29102, ""),
        RC_APP_PUBLICSERVICE_FOLLOWED(29103, ""),
        RC_APP_PUBLICSERVICE_DEFUNFOLLOWED(29104, ""),
        RC_APP_PUBLICSERVICE_UNFOLLOWED(29105, ""),
        RC_APP_PUBLICSERVICE_UNFOLLOW(29106, ""),
        RC_PUBLICSERVICE_ERROR_TYPE(29201, ""),
        RC_PUBLICSERVICE_DEFFOLLOWED(29202, ""),
        RC_PUBLICSERVICE_FOLLOWED(29203, ""),
        RC_PUBLICSERVICE_DEFUNFOLLOWED(29204, ""),
        RC_PUBLICSERVICE_UNFOLLOWED(29205, ""),
        RC_PUBLICSERVICE_UNFOLLOW(29206, ""),
        REJECTED_BY_BLACKLIST(405, "rejected by blacklist"),
        NOT_IN_WHITELIST(407, ""),
        RC_NET_CHANNEL_INVALID(30001, "Socket does not exist"),
        RC_NET_UNAVAILABLE(30002, ""),
        RC_MSG_RESP_TIMEOUT(30003, ""),
        RC_HTTP_SEND_FAIL(30004, ""),
        RC_HTTP_REQ_TIMEOUT(30005, ""),
        RC_HTTP_RECV_FAIL(30006, ""),
        RC_NAVI_RESOURCE_ERROR(30007, ""),
        RC_NODE_NOT_FOUND(30008, ""),
        RC_DOMAIN_NOT_RESOLVE(30009, ""),
        RC_SOCKET_NOT_CREATED(30010, ""),
        RC_SOCKET_DISCONNECTED(30011, ""),
        RC_PING_SEND_FAIL(30012, ""),
        RC_PONG_RECV_FAIL(30013, ""),
        RC_MSG_SEND_FAIL(30014, ""),
        RC_CONN_OVERFREQUENCY(30015, "Connect over frequency."),
        RC_MSG_SIZE_OUT_OF_LIMIT(30016, ""),
        RC_NETWORK_IS_DOWN_OR_UNREACHABLE(30019, ""),
        RC_CONN_ACK_TIMEOUT(31000, ""),
        RC_CONN_PROTO_VERSION_ERROR(31001, ""),
        RC_CONN_ID_REJECT(31002, ""),
        RC_CONN_SERVER_UNAVAILABLE(31003, ""),
        RC_CONN_USER_OR_PASSWD_ERROR(31004, ""),
        RC_CONN_NOT_AUTHRORIZED(31005, ""),
        RC_CONN_REDIRECTED(31006, ""),
        RC_CONN_PACKAGE_NAME_INVALID(31007, ""),
        RC_CONN_APP_BLOCKED_OR_DELETED(31008, ""),
        RC_CONN_USER_BLOCKED(31009, ""),
        RC_DISCONN_KICK(31010, ""),
        RC_DISCONN_USER_BLOCKED(31011, ""),
        RC_CONN_OTHER_DEVICE_LOGIN(31023, ""),
        CONCURRENT_LIMIT_ERROR(31024, ""),
        RC_QUERY_ACK_NO_DATA(32001, ""),
        RC_MSG_DATA_INCOMPLETE(32002, ""),
        RC_CONN_REFUSED(32061, "connection is refused"),
        RC_CONNECTION_RESET_BY_PEER(32054, "connection reset by peer"),
        BIZ_ERROR_CLIENT_NOT_INIT(33001, ""),
        BIZ_ERROR_DATABASE_ERROR(33002, ""),
        BIZ_ERROR_NO_CHANNEL(33004, ""),
        BIZ_ERROR_RECONNECT_SUCCESS(33005, ""),
        BIZ_ERROR_CONNECTING(33006, ""),
        PARAMETER_INVALID_CHATROOM(23412, "invalid parameter"),
        ROAMING_SERVICE_UNAVAILABLE_CHATROOM(23414, ""),
        EXCCED_MAX_KV_SIZE(23423, ""),
        TRY_OVERWRITE_INVALID_KEY(23424, ""),
        EXCCED_MAX_CALL_API_SIZE(23425, ""),
        KV_STORE_NOT_AVAILABLE(23426, ""),
        KEY_NOT_EXIST(23427, ""),
        RC_CONNECTION_EXIST(34001, ""),
        KV_STORE_NOT_SYNC(34004, ""),
        RC_RECALL_PARAMETER_INVALID(25101, ""),
        RC_PUSHSETTING_PARAMETER_INVALID(26001, ""),
        RC_PUSHSETTING_CONFIG_NOT_OPEN(26002, ""),
        RC_SIGHT_SERVICE_UNAVAILABLE(26101, ""),
        RC_SIGHT_MSG_DURATION_LIMIT_EXCEED(34002, ""),
        RC_GIF_MSG_SIZE_LIMIT_EXCEED(34003, ""),
        RC_ENVIRONMENT_ERROR(34005, ""),
        RC_CONNECT_TIMEOUT(34006, "Time out."),
        RC_PUBLIC_SERVICE_PROFILE_NOT_EXIST(34007, ""),
        RC_MESSAGE_CANT_EXPAND(34008, ""),
        RC_MESSAGE_EXPAND_FAIL(34009, ""),
        RC_MSG_EXPANSION_SIZE_LIMIT_EXCEED(34010, ""),
        RC_FILE_UPLOAD_FAILED(34011, "");

        private int code;
        private String msg;

        ErrorCode(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public String getMessage() {
            return this.msg;
        }

        public int getValue() {
            return this.code;
        }

        public static ErrorCode valueOf(int i) {
            for (ErrorCode errorCode : values()) {
                if (i == errorCode.getValue()) {
                    return errorCode;
                }
            }
            RLog.d(RongIMClient.TAG, "valueOf,ErrorCode:" + i);
            ErrorCode errorCode2 = UNKNOWN;
            errorCode2.code = i;
            errorCode2.msg = i + "";
            return errorCode2;
        }
    }

    public static abstract class GetBlacklistCallback extends ResultCallback<String[]> {
    }

    private class GetConversationListProcessCallBackWrapper extends IGetConversationListWithProcessCallback.Stub {
        private List<Conversation> conversationList = new ArrayList();
        private ResultCallback<List<Conversation>> resultCallback;

        GetConversationListProcessCallBackWrapper(ResultCallback<List<Conversation>> resultCallback) {
            this.resultCallback = resultCallback;
        }

        @Override // io.rong.imlib.IGetConversationListWithProcessCallback
        public void onComplete() {
            if (this.resultCallback != null) {
                if (this.conversationList.size() == 0) {
                    this.resultCallback.onCallback(null);
                } else {
                    this.resultCallback.onCallback(this.conversationList);
                }
            }
        }

        @Override // io.rong.imlib.IGetConversationListWithProcessCallback
        public void onProcess(List<Conversation> list) {
            this.conversationList.addAll(list);
        }
    }

    public static abstract class GetNotificationQuietHoursCallback extends ResultCallback<String> {
        void onCallback(final String str, final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.GetNotificationQuietHoursCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    GetNotificationQuietHoursCallback.this.onSuccess(str, i);
                }
            });
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public abstract void onError(ErrorCode errorCode);

        public abstract void onSuccess(String str, int i);

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public final void onSuccess(String str) {
            throw new RuntimeException("not support");
        }
    }

    private class JoinChatRoomCallback extends DefaultOperationCallback {
        private String chatRoomId;
        private boolean chatRoomIdExist;
        private int count;
        private boolean isRejoin;

        JoinChatRoomCallback(IpcCallbackProxy<OperationCallback> ipcCallbackProxy, String str, int i, boolean z, boolean z2, boolean z3) {
            super(ipcCallbackProxy);
            this.chatRoomId = str;
            this.count = i;
            this.chatRoomIdExist = z2;
            this.isRejoin = z3;
            if (!z) {
                RongIMClient.this.mChatRoomCache.clear();
            }
            RongIMClient.this.mChatRoomCache.put(str, RongIMClient.this.new ChatRoomCacheRunnable(str, i, z2));
            RLog.d(RongIMClient.TAG, this + "; joinMultiCR = " + z);
        }

        @Override // io.rong.imlib.RongIMClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
        public void onComplete() {
            super.onComplete();
            FwLog.write(3, 1, (this.isRejoin ? FwLog.LogTag.A_REJOIN_CHATROOM_R : FwLog.LogTag.A_JOIN_CHATROOM_R).getTag(), "code|room_id", 0, this.chatRoomId);
            RLog.d(RongIMClient.TAG, "onComplete: " + this);
            ChatRoomCacheRunnable chatRoomCacheRunnable = (ChatRoomCacheRunnable) RongIMClient.this.mChatRoomCache.get(this.chatRoomId);
            if (chatRoomCacheRunnable != null) {
                chatRoomCacheRunnable.onceSuccess = true;
            }
            ChatRoomActionListener chatRoomActionListener = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
            if (chatRoomActionListener != null) {
                chatRoomActionListener.onJoined(this.chatRoomId);
            }
        }

        @Override // io.rong.imlib.RongIMClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
        public void onFailure(int i) {
            super.onFailure(i);
            FwLog.write(1, 1, (this.isRejoin ? FwLog.LogTag.A_REJOIN_CHATROOM_R : FwLog.LogTag.A_JOIN_CHATROOM_R).getTag(), "code|room_id", Integer.valueOf(i), this.chatRoomId);
            ErrorCode errorCodeValueOf = ErrorCode.valueOf(i);
            if (errorCodeValueOf.equals(ErrorCode.RC_CHATROOM_NOT_EXIST) || errorCodeValueOf.equals(ErrorCode.RC_CHATROOM_IS_FULL) || errorCodeValueOf.equals(ErrorCode.RC_OPERATION_BLOCKED) || errorCodeValueOf.equals(ErrorCode.KICKED_FROM_CHATROOM)) {
                RLog.e(RongIMClient.TAG, "join chatroom " + this.chatRoomId + " error : " + errorCodeValueOf);
            } else {
                RLog.e(RongIMClient.TAG, "join chatroom " + this.chatRoomId + " error: " + i + ", re-join after 2s");
                ChatRoomCacheRunnable chatRoomCacheRunnable = RongIMClient.this.new ChatRoomCacheRunnable(this.chatRoomId, this.count, this.chatRoomIdExist);
                RongIMClient.this.mRetryCRCache.put(this.chatRoomId, chatRoomCacheRunnable);
                FwLog.write(4, 1, FwLog.LogTag.A_REJOIN_CHATROOM_S.getTag(), "retry_after", 2000L);
                RongIMClient.this.mWorkHandler.postDelayed(chatRoomCacheRunnable, 2000L);
            }
            ChatRoomActionListener chatRoomActionListener = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
            if (chatRoomActionListener != null) {
                chatRoomActionListener.onError(this.chatRoomId, ErrorCode.valueOf(i));
            }
        }

        public String toString() {
            return "JoinChatRoomCallback{chatRoomId='" + this.chatRoomId + "', count=" + this.count + ", chatRoomIdExist=" + this.chatRoomIdExist + '}';
        }
    }

    public interface KVStatusListener {
        void onChatRoomKVRemove(String str, Map<String, String> map);

        void onChatRoomKVSync(String str);

        void onChatRoomKVUpdate(String str, Map<String, String> map);
    }

    public enum MediaType {
        IMAGE(1),
        AUDIO(2),
        VIDEO(3),
        FILE(4);

        private int value;

        MediaType(int i) {
            this.value = i;
        }

        public static MediaType setValue(int i) {
            for (MediaType mediaType : values()) {
                if (i == mediaType.getValue()) {
                    return mediaType;
                }
            }
            return IMAGE;
        }

        public int getValue() {
            return this.value;
        }
    }

    public interface MessageExpansionListener {
        void onMessageExpansionRemove(List<String> list, Message message);

        void onMessageExpansionUpdate(Map<String, String> map, Message message);
    }

    public interface OnRecallMessageListener {
        boolean onMessageRecalled(Message message, RecallNotificationMessage recallNotificationMessage);
    }

    public interface OnReceiveDestructionMessageListener {
        void onReceive(Message message);
    }

    public interface OnReceiveMessageListener {
        boolean onReceived(Message message, int i);
    }

    public static abstract class OnReceiveMessageWrapperListener implements OnReceiveMessageListener {
        @Override // io.rong.imlib.RongIMClient.OnReceiveMessageListener
        public final boolean onReceived(Message message, int i) {
            return onReceived(message, i, false, false);
        }

        public abstract boolean onReceived(Message message, int i, boolean z, boolean z2);
    }

    public static abstract class OperationCallback extends Callback {
    }

    public enum PushLanguage {
        EN_US(1, "en_us"),
        ZH_CN(2, "zh_cn"),
        AR_SA(3, "ar_sa");

        private String msg;
        private int value;

        PushLanguage(int i, String str) {
            this.value = i;
            this.msg = str;
        }

        public String getMsg() {
            return this.msg;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    private enum PushSettings {
        PUSH_SETTINGS_LANGUAGE(1),
        PUSH_SETTINGS_SHOW_CONTENT(2),
        PUSH_SETTINGS_RECEIVE(3);

        private int value;

        PushSettings(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private enum PushStatus {
        STATUS_ON("1"),
        STATUS_OFF("0");

        private String value;

        PushStatus(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public interface RCLogInfoListener {
        void onRCLogInfoOccurred(String str);
    }

    public interface ReadReceiptListener {
        void onMessageReceiptRequest(Conversation.ConversationType conversationType, String str, String str2);

        void onMessageReceiptResponse(Conversation.ConversationType conversationType, String str, String str2, HashMap<String, Long> map);

        void onReadReceiptReceived(Message message);
    }

    public interface RealTimeLocationListener {
        void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode);

        void onParticipantsJoin(String str);

        void onParticipantsQuit(String str);

        void onReceiveLocation(double d2, double d3, String str);

        void onReceiveLocationWithType(double d2, double d3, RealTimeLocationType realTimeLocationType, String str);

        void onStatusChange(RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationStatus);
    }

    public static abstract class ResultCallback<T> {

        public static class Result<T> {
            public T t;
        }

        void onCallback(final T t) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ResultCallback.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    ResultCallback.this.onSuccess(t);
                }
            });
        }

        public abstract void onError(ErrorCode errorCode);

        void onFail(final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ResultCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ResultCallback.this.onError(ErrorCode.valueOf(i));
                }
            });
        }

        public abstract void onSuccess(T t);

        void onFail(final ErrorCode errorCode) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.ResultCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    ResultCallback.this.onError(errorCode);
                }
            });
        }
    }

    public enum SearchType {
        EXACT(0),
        FUZZY(1);

        private int value;

        SearchType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    public static abstract class SendImageMessageCallback extends SendMessageCallback {
        public abstract void onAttached(Message message);

        void onAttachedCallback(final Message message) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendImageMessageCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    SendImageMessageCallback.this.onAttached(message);
                }
            });
        }

        public abstract void onError(Message message, ErrorCode errorCode);

        @Override // io.rong.imlib.RongIMClient.SendMessageCallback
        public void onError(Integer num, ErrorCode errorCode) {
        }

        void onFail(final Message message, final ErrorCode errorCode) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendImageMessageCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    SendImageMessageCallback.this.onError(message, errorCode);
                }
            });
        }

        public abstract void onProgress(Message message, int i);

        void onProgressCallback(final Message message, final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendImageMessageCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    SendImageMessageCallback.this.onProgress(message, i);
                }
            });
        }

        public abstract void onSuccess(Message message);

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onSuccess(Integer num) {
        }
    }

    public static abstract class SendImageMessageWithUploadListenerCallback {
        public abstract void onAttached(Message message, UploadImageStatusListener uploadImageStatusListener);

        void onAttachedCallback(final Message message, final UploadImageStatusListener uploadImageStatusListener) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    SendImageMessageWithUploadListenerCallback.this.onAttached(message, uploadImageStatusListener);
                }
            });
        }

        public abstract void onError(Message message, ErrorCode errorCode);

        void onFail(final Message message, final ErrorCode errorCode) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendImageMessageWithUploadListenerCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    SendImageMessageWithUploadListenerCallback.this.onError(message, errorCode);
                }
            });
        }

        public abstract void onProgress(Message message, int i);

        public abstract void onSuccess(Message message);
    }

    public static abstract class SendMediaMessageCallback extends SendImageMessageCallback {
    }

    public static abstract class SendMessageCallback extends ResultCallback<Integer> {
        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public final void onError(ErrorCode errorCode) {
        }

        public abstract void onError(Integer num, ErrorCode errorCode);

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public final void onFail(int i) {
            super.onFail(i);
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public final void onFail(ErrorCode errorCode) {
            super.onFail(errorCode);
        }

        public final void onFail(final Integer num, final int i) {
            RongIMClient.mHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendMessageCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    SendMessageCallback.this.onError(num, ErrorCode.valueOf(i));
                }
            }, 100L);
        }

        public final void onFail(final Integer num, final ErrorCode errorCode) {
            RongIMClient.mHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.RongIMClient.SendMessageCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    SendMessageCallback.this.onError(num, errorCode);
                }
            }, 100L);
        }
    }

    private static class SingletonHolder {
        static RongIMClient sInstance = new RongIMClient();

        private SingletonHolder() {
        }
    }

    private class StatusListener extends IConnectionStatusListener.Stub {
        private StatusListener() {
        }

        @Override // io.rong.imlib.IConnectionStatusListener
        public void onChanged(int i) throws RemoteException {
            ConnectionStatusListener.ConnectionStatus connectionStatusValueOf = ConnectionStatusListener.ConnectionStatus.valueOf(i);
            RLog.d(RongIMClient.TAG, "[connect] onChanged cur = " + RongIMClient.this.mConnectionStatus + ", to = " + connectionStatusValueOf);
            onConnectionStatusChange(connectionStatusValueOf);
        }

        synchronized void onConnectionStatusChange(final ConnectionStatusListener.ConnectionStatus connectionStatus) {
            if (connectionStatus.equals(ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
                MessageBufferPool.getInstance().retrySendMessages();
                RongIMClient.getInstance().reJoinChatRoomWithCache();
            }
            ModuleManager.connectivityChanged(connectionStatus);
            RongIMClient.this.imLibExtensionModuleManager.onConnectStatusChanged(connectionStatus);
            if (!RongIMClient.this.mConnectionStatus.equals(connectionStatus)) {
                RongIMClient.this.mConnectionStatus = connectionStatus;
                RongIMClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.RongIMClient.StatusListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RongIMClient.sConnectionListener != null) {
                            RongIMClient.sConnectionListener.onChanged(connectionStatus);
                        }
                    }
                });
            }
        }

        @Override // io.rong.imlib.IConnectionStatusListener.Stub, android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            try {
                return super.onTransact(i, parcel, parcel2, i2);
            } catch (RuntimeException e2) {
                RLog.e(RongIMClient.TAG, "StatusListener Unexpected remote exception", e2);
                throw e2;
            }
        }
    }

    static abstract class SyncCallback<T> extends ResultCallback<T> {
        SyncCallback() {
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onCallback(T t) {
            onSuccess(t);
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onFail(int i) {
            onError(ErrorCode.valueOf(i));
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onFail(ErrorCode errorCode) {
            onError(errorCode);
        }
    }

    public interface SyncConversationReadStatusListener {
        void onSyncConversationReadStatus(Conversation.ConversationType conversationType, String str);
    }

    public enum TimestampOrder {
        RC_TIMESTAMP_DESC,
        RC_TIMESTAMP_ASC
    }

    public interface TypingStatusListener {
        void onTypingStatusChanged(Conversation.ConversationType conversationType, String str, Collection<TypingStatus> collection);
    }

    public class UploadImageStatusListener {
        private SendImageMessageWithUploadListenerCallback callback;
        private Message message;
        private String pushContent;
        private String pushData;

        public UploadImageStatusListener(Message message, String str, String str2, SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback) {
            this.callback = sendImageMessageWithUploadListenerCallback;
            this.message = message;
            this.pushContent = str;
            this.pushData = str2;
        }

        public void error() {
            if (this.callback != null) {
                this.message.setSentStatus(Message.SentStatus.FAILED);
                RongIMClient.this.setMessageSentStatus(this.message, null);
                this.callback.onFail(this.message, ErrorCode.RC_MSG_SEND_FAIL);
            }
        }

        public void success(Uri uri) {
            if (uri == null) {
                RLog.e(RongIMClient.TAG, "UploadImageStatusListener uri is null.");
                SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback = this.callback;
                if (sendImageMessageWithUploadListenerCallback != null) {
                    sendImageMessageWithUploadListenerCallback.onFail(this.message, ErrorCode.RC_MSG_SEND_FAIL);
                    return;
                }
                return;
            }
            MessageContent content = this.message.getContent();
            if (content instanceof ImageMessage) {
                ((ImageMessage) content).setRemoteUri(uri);
            } else if (content instanceof GIFMessage) {
                ((GIFMessage) content).setRemoteUri(uri);
            }
            RongIMClient.this.internalSendImageMessage(this.message, this.pushContent, this.pushData, new SendImageMessageCallback() { // from class: io.rong.imlib.RongIMClient.UploadImageStatusListener.1
                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onError(Message message, ErrorCode errorCode) {
                    if (UploadImageStatusListener.this.callback != null) {
                        UploadImageStatusListener.this.callback.onError(message, errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                void onFail(Message message, ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onProgress(Message message, int i) {
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onSuccess(Message message) {
                    if (UploadImageStatusListener.this.callback != null) {
                        UploadImageStatusListener.this.callback.onSuccess(message);
                    }
                }
            });
        }

        public void update(int i) {
            SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback = this.callback;
            if (sendImageMessageWithUploadListenerCallback != null) {
                sendImageMessageWithUploadListenerCallback.onProgress(this.message, i);
            }
        }
    }

    public static abstract class UploadMediaCallback extends ResultCallback<Message> {
        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onError(ErrorCode errorCode) {
        }

        public abstract void onError(Message message, ErrorCode errorCode);

        void onFail(final Message message, final ErrorCode errorCode) {
            RongIMClient.mHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.RongIMClient.UploadMediaCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    UploadMediaCallback.this.onError(message, errorCode);
                }
            }, 100L);
        }

        public abstract void onProgress(Message message, int i);

        void onProgressCallback(final Message message, final int i) {
            RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.UploadMediaCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    UploadMediaCallback.this.onProgress(message, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAllDownloadMediaMessage(OperationCallback operationCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.71
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.cancelAllDownloadMediaMessage(RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "cancelAllDownloadMediaMessage", e2);
                    T t2 = ipcCallbackProxy.callback;
                    if (t2 != 0) {
                        ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanLocalHistoryMessages(Conversation conversation, long j, final IpcCallbackProxy<OperationCallback> ipcCallbackProxy) {
        try {
            this.mLibHandler.cleanHistoryMessages(conversation, j, new IOperationCallback.Stub() { // from class: io.rong.imlib.RongIMClient.33
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.rong.imlib.IOperationCallback
                public void onComplete() throws RemoteException {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onCallback();
                        ipcCallbackProxy.callback = null;
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.rong.imlib.IOperationCallback
                public void onFailure(int i) throws RemoteException {
                    RLog.e(RongIMClient.TAG, "cleanLocalHistoryMessages errorCode" + i);
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.valueOf(i));
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } catch (Exception e2) {
            RLog.e(TAG, "cleanLocalHistoryMessages", e2);
            OperationCallback operationCallback = ipcCallbackProxy.callback;
            if (operationCallback != null) {
                operationCallback.onFail(ErrorCode.IPC_DISCONNECT);
                ipcCallbackProxy.callback = null;
            }
        }
    }

    private void clearToken() {
        RLog.d(TAG, "clear token");
        this.mToken = null;
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(this.mContext, "Statistics", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(RongLibConst.KEY_TOKEN).commit();
        }
    }

    public static RongIMClient connect(String str, ConnectCallback connectCallback) {
        return connect(str, -1, connectCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void connectServer(final String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setToken(str);
        if (this.mLibHandler == null) {
            FwLog.write(3, 1, z ? "L-reconnect-T" : "L-connect-T", "sequences", 0);
            FwLog.write(1, 1, z ? "L-reconnect-R" : "L-connect-R", "code|network|sequences", ErrorCode.IPC_DISCONNECT, DeviceUtils.getNetworkType(this.mContext), 0);
            this.mConnectRunnable = new ConnectRunnable(str);
            initBindService();
        } else {
            try {
                RLog.d(TAG, "[connect] connect");
                this.mLibHandler.connect(str, z, isInForeground, new IConnectStringCallback.Stub() { // from class: io.rong.imlib.RongIMClient.5
                    @Override // io.rong.imlib.IConnectStringCallback
                    public void OnDatabaseOpened(int i) throws RemoteException {
                        if (RongIMClient.needCallBackDBOpen) {
                            if (RongIMClient.this.connectCallback != null) {
                                RongIMClient.this.connectCallback.onDatabaseOpened(DatabaseOpenStatus.valueOf(i));
                            }
                            boolean unused = RongIMClient.needCallBackDBOpen = false;
                        }
                    }

                    @Override // io.rong.imlib.IConnectStringCallback
                    public void onComplete(String str2) {
                        RLog.d(RongIMClient.TAG, "[connect] callback onComplete");
                        SingletonHolder.sInstance.imLibExtensionModuleManager.onConnected(str2, str);
                        RongIMClient.this.mCurrentUserId = str2;
                        SharedPreferencesUtils.get(RongIMClient.this.mContext, "Statistics", 0).edit().putString(RongLibConst.KEY_TOKEN, str).putString("userId", str2).commit();
                        RongIMClient.this.mConnectRunnable = null;
                        if (RongIMClient.this.connectCallback != null) {
                            RongIMClient.this.connectCallback.onCallback(str2);
                            RongIMClient.this.connectCallback = null;
                        }
                        if (RongIMClient.isPushEnabled) {
                            PushManager.getInstance().updatePushServerInfoFromToken(str);
                        }
                        if (RongIMClient.isPushEnabled) {
                            PushManager.getInstance().updatePushServerInfoFromToken(str);
                        }
                        if (RongIMClient.isPushEnabled) {
                            PushManager.getInstance().updatePushServerInfoFromToken(str);
                        }
                    }

                    @Override // io.rong.imlib.IConnectStringCallback
                    public void onFailure(int i) throws RemoteException {
                        RLog.e(RongIMClient.TAG, "[connect] callback onFailure, errorCode = " + i);
                        RongIMClient.this.mConnectRunnable = null;
                        if (RongIMClient.this.connectCallback != null) {
                            RongIMClient.this.connectCallback.onFail(ConnectionErrorCode.valueOf(i));
                            RongIMClient.this.connectCallback = null;
                        }
                        SharedPreferencesUtils.get(RongIMClient.this.mContext, "Statistics", 0).edit().putString(RongLibConst.KEY_TOKEN, str).commit();
                    }
                });
            } catch (Exception e2) {
                if (this.connectCallback != null) {
                    this.connectCallback.onError(ConnectionErrorCode.IPC_DISCONNECT);
                }
                FwLog.write(1, 1, "L-crash_main_ept-F", "stacks", FwLog.stackToString(e2));
                RLog.e(TAG, "connectServer", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] convertTypes(Conversation.ConversationType[] conversationTypeArr) {
        ArrayList arrayList = new ArrayList();
        for (Conversation.ConversationType conversationType : conversationTypeArr) {
            if (conversationType != null) {
                arrayList.add(Integer.valueOf(conversationType.getValue()));
            }
        }
        return toIntArray(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Message> filterDestructionMessage(Conversation.ConversationType conversationType, String str, List<Message> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Message message : list) {
            if (message.getContent().isDestruct() && message.getReadTime() > 0) {
                if (!message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                    arrayList2.add(message);
                } else if ((System.currentTimeMillis() - message.getReadTime()) / 1000 >= message.getContent().getDestructTime()) {
                    arrayList2.add(message);
                }
            }
            arrayList.add(message);
        }
        if (arrayList2.size() > 0) {
            Message[] messageArr = new Message[arrayList2.size()];
            arrayList2.toArray(messageArr);
            deleteRemoteMessages(conversationType, str, messageArr, null);
            deleteMessages(conversationType, str, null);
        }
        return arrayList;
    }

    private ErrorCode filterSendMessage(Message message) {
        if (message == null) {
            RLog.e(TAG, "filterSendMessage : message can't be null!");
            return ErrorCode.PARAMETER_ERROR;
        }
        if (message.getConversationType() == null) {
            RLog.e(TAG, "filterSendMessage : conversation type can't be null!");
            return ErrorCode.PARAMETER_ERROR;
        }
        if (message.getConversationType() == Conversation.ConversationType.SYSTEM) {
            RLog.e(TAG, "filterSendMessage : conversation type can't be system!");
            return ErrorCode.PARAMETER_ERROR;
        }
        if (TextUtils.isEmpty(message.getTargetId())) {
            RLog.e(TAG, "filterSendMessage : targetId can't be null!");
            return ErrorCode.PARAMETER_ERROR;
        }
        if (message.getContent() == null) {
            RLog.e(TAG, "filterSendMessage : content can't be null!");
            return ErrorCode.PARAMETER_ERROR;
        }
        if (ExpansionUtils.filterSendMessage(message) != null) {
            return ExpansionUtils.filterSendMessage(message);
        }
        return null;
    }

    private List<Message> getHistoryMessagesByObjectNamesSync(Conversation.ConversationType conversationType, String str, List<String> list, long j, int i, RongCommonDefine.GetMessageDirection getMessageDirection) {
        if (this.mLibHandler == null) {
            return null;
        }
        Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        try {
            return this.mLibHandler.getOlderMessagesByObjectNames(conversation, list, j, i, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
        } catch (Exception e2) {
            RLog.e(TAG, "getHistoryMessagesByObjectNamesSync", e2);
            return null;
        }
    }

    private List<Message> getHistoryMessagesSync(Conversation.ConversationType conversationType, String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || conversationType == null) {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            return null;
        }
        if (this.mLibHandler == null) {
            return null;
        }
        Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        try {
            return this.mLibHandler.getOlderMessages(conversation, i, i2);
        } catch (Exception e2) {
            RLog.e(TAG, "getHistoryMessagesSync ", e2);
            return null;
        }
    }

    public static RongIMClient getInstance() {
        return SingletonHolder.sInstance;
    }

    private RCDHCodecTool.RCSecretKey getRcSecretKey(RCEncryptResponseMessage rCEncryptResponseMessage) {
        return RCDHCodecTool.obtainWithEncId(rCEncryptResponseMessage.getRequesterEncId()).genSecretKey(RCDHCodecTool.fromString2RCDHPublicKey(rCEncryptResponseMessage.getResponserKey()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleCmdMessages(final Message message, final int i, final boolean z, final boolean z2, final int i2) {
        boolean zRouteMessage = ModuleManager.routeMessage(message, i, z2, i2);
        boolean zOnReceiveMessage = !zRouteMessage ? this.imLibExtensionModuleManager.onReceiveMessage(message, i, z2, i2) : false;
        if (zRouteMessage || zOnReceiveMessage) {
            return true;
        }
        if (TypingMessageManager.getInstance().isShowMessageTyping() && TypingMessageManager.getInstance().onReceiveMessage(message)) {
            return true;
        }
        if (message.getContent() instanceof ReadReceiptMessage) {
            handleReadReceiptMessage(message);
            return true;
        }
        if (message.getContent() instanceof SyncReadStatusMessage) {
            if (message.getMessageDirection() == Message.MessageDirection.SEND) {
                clearMessagesUnreadStatus(message.getConversationType(), message.getTargetId(), ((SyncReadStatusMessage) message.getContent()).getLastMessageSendTime(), null);
                SyncConversationReadStatusListener syncConversationReadStatusListener = this.mSyncConversationReadStatusListener;
                if (syncConversationReadStatusListener != null) {
                    syncConversationReadStatusListener.onSyncConversationReadStatus(message.getConversationType(), message.getTargetId());
                }
            }
            return true;
        }
        if (message.getContent() instanceof ReadReceiptRequestMessage) {
            if (!message.getConversationType().equals(Conversation.ConversationType.GROUP) && !message.getConversationType().equals(Conversation.ConversationType.DISCUSSION)) {
                return true;
            }
            ReadReceiptRequestMessage readReceiptRequestMessage = (ReadReceiptRequestMessage) message.getContent();
            try {
                Message messageByUid = this.mLibHandler.getMessageByUid(readReceiptRequestMessage.getMessageUId());
                if (messageByUid != null) {
                    ReadReceiptInfo readReceiptInfo = messageByUid.getReadReceiptInfo();
                    if (readReceiptInfo == null) {
                        readReceiptInfo = new ReadReceiptInfo();
                        messageByUid.setReadReceiptInfo(readReceiptInfo);
                    }
                    readReceiptInfo.setIsReadReceiptMessage(true);
                    readReceiptInfo.setHasRespond(false);
                    this.mLibHandler.updateReadReceiptRequestInfo(readReceiptRequestMessage.getMessageUId(), readReceiptInfo.toJSON().toString());
                    if (sReadReceiptListener != null) {
                        sReadReceiptListener.onMessageReceiptRequest(message.getConversationType(), message.getTargetId(), readReceiptRequestMessage.getMessageUId());
                    }
                }
            } catch (Exception e2) {
                RLog.e(TAG, "*handleCmdMessages", e2);
            }
            return true;
        }
        if (!(message.getContent() instanceof ReadReceiptResponseMessage)) {
            if (message.getContent() instanceof RecallCommandMessage) {
                final RecallCommandMessage recallCommandMessage = (RecallCommandMessage) message.getContent();
                getMessageByUid(recallCommandMessage.getMessageUId(), new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.99
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(ErrorCode errorCode) {
                        RLog.e(RongIMClient.TAG, "recall message received, but getMessageByUid failed");
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(final Message message2) {
                        if (recallCommandMessage.isDelete()) {
                            if (message2 != null) {
                                int[] iArr = {message2.getMessageId()};
                                FwLog.write(4, 1, FwLog.LogTag.P_DELETE_MSG_S.getTag(), "isDelete|messageId|messageUId", Boolean.valueOf(recallCommandMessage.isDelete()), iArr, recallCommandMessage.getMessageUId());
                                RongIMClient.this.deleteMessages(iArr, new ResultCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.99.1
                                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                                    public void onError(ErrorCode errorCode) {
                                        RLog.e(RongIMClient.TAG, "deleteMessage when recall, error " + errorCode.code);
                                    }

                                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                                    public void onSuccess(Boolean bool) {
                                        RLog.i(RongIMClient.TAG, "deleteMessage success");
                                        if (RongIMClient.sOnRecallMessageListener != null) {
                                            RongIMClient.sOnRecallMessageListener.onMessageRecalled(message2, null);
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (message2 == null) {
                            RecallNotificationMessage recallNotificationMessage = new RecallNotificationMessage(message.getSenderUserId(), recallCommandMessage.getSentTime(), message.getObjectName(), recallCommandMessage.isAdmin(), recallCommandMessage.isDelete());
                            recallNotificationMessage.setUserInfo(recallCommandMessage.getUserInfo());
                            Message messageObtain = Message.obtain(message.getTargetId(), message.getConversationType(), recallNotificationMessage);
                            messageObtain.setSentTime(recallCommandMessage.getSentTime());
                            messageObtain.setSenderUserId(message.getSenderUserId());
                            RongIMClient.this.insertIncomingMessage(message.getConversationType(), message.getTargetId(), message.getSenderUserId(), new Message.ReceivedStatus(0), recallNotificationMessage, recallCommandMessage.getSentTime(), null);
                            if (RongIMClient.sReceiveMessageListener != null) {
                                if (RongIMClient.sReceiveMessageListener instanceof OnReceiveMessageWrapperListener) {
                                    ((OnReceiveMessageWrapperListener) RongIMClient.sReceiveMessageListener).onReceived(messageObtain, i - i2, z, z2);
                                    return;
                                } else {
                                    RongIMClient.sReceiveMessageListener.onReceived(messageObtain, i - i2);
                                    return;
                                }
                            }
                            return;
                        }
                        RecallNotificationMessage recallNotificationMessage2 = new RecallNotificationMessage(message.getSenderUserId(), recallCommandMessage.getSentTime(), message2.getObjectName(), recallCommandMessage.isAdmin(), recallCommandMessage.isDelete());
                        message2.getReceivedStatus().setRead();
                        RongIMClient.this.setMessageReceivedStatus(message2.getMessageId(), message2.getReceivedStatus(), null);
                        if (message2.getContent().getUserInfo() != null) {
                            recallNotificationMessage2.setUserInfo(message2.getContent().getUserInfo());
                        }
                        if (message2.getContent() instanceof RecallNotificationMessage) {
                            RecallNotificationMessage recallNotificationMessage3 = (RecallNotificationMessage) message2.getContent();
                            if (recallNotificationMessage3.getRecallActionTime() > 0) {
                                recallNotificationMessage2.setRecallActionTime(recallNotificationMessage3.getRecallActionTime());
                            }
                            if (!TextUtils.isEmpty(recallNotificationMessage3.getRecallContent())) {
                                recallNotificationMessage2.setRecallContent(recallNotificationMessage3.getRecallContent());
                            }
                        }
                        try {
                            RongIMClient.this.mLibHandler.setMessageContent(message2.getMessageId(), recallNotificationMessage2.encode(), ((MessageTag) RecallNotificationMessage.class.getAnnotation(MessageTag.class)).value());
                            if (RongIMClient.sOnRecallMessageListener != null) {
                                message2.setContent(recallNotificationMessage2);
                                RongIMClient.sOnRecallMessageListener.onMessageRecalled(message2, recallNotificationMessage2);
                            }
                        } catch (RemoteException e3) {
                            RLog.e(RongIMClient.TAG, "handleCmdMessages", e3);
                        }
                    }
                });
                return true;
            }
            if (!(message.getContent() instanceof DestructionCmdMessage)) {
                return this.mCmdObjectNameList.contains(message.getObjectName());
            }
            Iterator<String> it = ((DestructionCmdMessage) message.getContent()).getBurnMessageUIds().iterator();
            while (it.hasNext()) {
                getMessageByUid(it.next(), new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.100
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(Message message2) {
                        if (message2 != null) {
                            RongIMClient.this.setMessageReadTime(message2.getMessageId(), message.getSentTime(), null);
                            message2.setReadTime(message.getSentTime());
                            RongIMClient.getInstance().deleteRemoteMessages(message2.getConversationType(), message2.getTargetId(), new Message[]{message2}, null);
                            RongIMClient.getInstance().deleteMessages(new int[]{message2.getMessageId()}, null);
                            if (RongIMClient.this.mOnReceiveDestructionMessageListener != null) {
                                RongIMClient.this.mOnReceiveDestructionMessageListener.onReceive(message2);
                            }
                        }
                    }
                });
            }
            return true;
        }
        if (message.getMessageDirection().equals(Message.MessageDirection.SEND)) {
            return true;
        }
        if (!message.getConversationType().equals(Conversation.ConversationType.GROUP) && !message.getConversationType().equals(Conversation.ConversationType.DISCUSSION)) {
            return true;
        }
        ArrayList<String> messageUIdListBySenderId = ((ReadReceiptResponseMessage) message.getContent()).getMessageUIdListBySenderId(getCurrentUserId());
        String senderUserId = message.getSenderUserId();
        if (messageUIdListBySenderId != null && this.mLibHandler != null) {
            for (String str : messageUIdListBySenderId) {
                try {
                    Message messageByUid2 = this.mLibHandler.getMessageByUid(str);
                    if (messageByUid2 != null) {
                        ReadReceiptInfo readReceiptInfo2 = messageByUid2.getReadReceiptInfo();
                        if (readReceiptInfo2 == null) {
                            readReceiptInfo2 = new ReadReceiptInfo();
                            messageByUid2.setReadReceiptInfo(readReceiptInfo2);
                        }
                        readReceiptInfo2.setIsReadReceiptMessage(true);
                        HashMap<String, Long> respondUserIdList = readReceiptInfo2.getRespondUserIdList();
                        if (respondUserIdList == null) {
                            respondUserIdList = new HashMap<>();
                            readReceiptInfo2.setRespondUserIdList(respondUserIdList);
                        }
                        respondUserIdList.put(senderUserId, Long.valueOf(message.getSentTime()));
                        this.mLibHandler.updateReadReceiptRequestInfo(str, readReceiptInfo2.toJSON().toString());
                        if (sReadReceiptListener != null) {
                            sReadReceiptListener.onMessageReceiptResponse(message.getConversationType(), message.getTargetId(), str, respondUserIdList);
                        }
                    }
                } catch (RemoteException e3) {
                    RLog.e(TAG, "#handleCmdMessages", e3);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean handleEncMessageContent(Message message, int i, boolean z, int i2) throws RemoteException {
        RLog.d(TAG, "handleEncMsg -> " + message.toString());
        MessageContent content = message.getContent();
        String targetId = message.getTargetId();
        if (content == null) {
            RLog.e(TAG, "messageContent from message is null.");
            return false;
        }
        MessageTag messageTag = (MessageTag) content.getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            RLog.e(TAG, "messageTag is null from -> " + content.getClass());
            return false;
        }
        String strValue = messageTag.value();
        if (strValue.contains("RC:Encrypt")) {
            RLog.d(TAG, "cmdLeft -> " + i2 + "left" + i + " value " + strValue + " isRetriverd = " + message.getReceivedStatus().isRetrieved() + " isMultiRetrived -> " + message.getReceivedStatus().isMultipleReceive());
            if (message.getSenderUserId() != null && message.getSenderUserId().equals(getCurrentUserId())) {
                RLog.w(TAG, "received signal msg from the same account of different endpoints , do nothing.");
                return true;
            }
        }
        byte b2 = -1;
        switch (strValue.hashCode()) {
            case -1919927324:
                if (strValue.equals("RC:EncryptResponseMsg")) {
                    b2 = 1;
                }
                break;
            case -1747006066:
                if (strValue.equals("RC:EncryptRequestMsg")) {
                    b2 = 0;
                }
                break;
            case -1659202549:
                if (strValue.equals("RC:EncryptCancelMsg")) {
                    b2 = 3;
                }
                break;
            case -941711427:
                if (strValue.equals("RC:EncryptConfirmMsg")) {
                    b2 = 2;
                }
                break;
            case -173850244:
                if (strValue.equals("RC:EncryptTerminateMsg")) {
                    b2 = 4;
                }
                break;
        }
        if (b2 == 0) {
            final String requesterEncId = ((RCEncryptRequestMessage) content).getRequesterEncId();
            this.signalBuff.put(requesterEncId, message);
            RLog.d(TAG, requesterEncId + " in buff at " + System.currentTimeMillis());
            this.mWorkHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.RongIMClient.109
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.signalBuff.containsKey(requesterEncId)) {
                        Message message2 = (Message) RongIMClient.this.signalBuff.get(requesterEncId);
                        RongIMClient.this.sendResponseMsg((RCEncryptRequestMessage) message2.getContent(), message2.getTargetId());
                        RLog.d(RongIMClient.TAG, "reqEncId ->" + requesterEncId + " request from buff handled at " + System.currentTimeMillis());
                    }
                }
            }, 200L);
        } else if (b2 == 1) {
            RCEncryptResponseMessage rCEncryptResponseMessage = (RCEncryptResponseMessage) content;
            if (rCEncryptResponseMessage.getResponserEncId() == null) {
                RLog.e(TAG, "error RC:EncryptResponseMsg -> responseEncId is null.");
                return true;
            }
            if (rCEncryptResponseMessage.getRequesterEncId() == null) {
                RLog.e(TAG, "error RC:EncryptResponseMsg -> requestEncId is null.");
                return true;
            }
            String str = rCEncryptResponseMessage.getRequesterEncId() + ";;;" + targetId;
            RCEncryptedSession encryptedConversation = this.mLibHandler.getEncryptedConversation(str);
            if (encryptedConversation == null) {
                RLog.e(TAG, "getEncryptedConversation returns null when onResponse with -> " + str + " isRetrived -> " + message.getReceivedStatus().isRetrieved());
                return true;
            }
            RLog.d(TAG, "session status -> " + encryptedConversation.getEncStatus());
            if (encryptedConversation.getEncStatus() == 3) {
                sendCancelMessage(targetId, rCEncryptResponseMessage, encryptedConversation);
            } else {
                RCDHCodecTool.RCSecretKey rcSecretKey = getRcSecretKey(rCEncryptResponseMessage);
                if (rcSecretKey == null) {
                    RLog.e(TAG, "get secretKey is null, when sending confirmMessage.");
                    return true;
                }
                sendConfirmMessage(targetId, rCEncryptResponseMessage, rcSecretKey, encryptedConversation);
                updateSessionStateAndCallback(rCEncryptResponseMessage.getRequesterEncId(), targetId, rCEncryptResponseMessage.getResponserEncId(), rcSecretKey, encryptedConversation);
            }
        } else if (b2 == 2) {
            RCEncryptConfirmMessage rCEncryptConfirmMessage = (RCEncryptConfirmMessage) content;
            handleRetrivedConfirmMessage(message, i, rCEncryptConfirmMessage);
            String str2 = rCEncryptConfirmMessage.getResponserEncId() + ";;;" + targetId;
            RCEncryptedSession encryptedConversation2 = this.mLibHandler.getEncryptedConversation(str2);
            if (encryptedConversation2 == null) {
                RLog.e(TAG, "getEncryptedConversation return null,there should be error in request codes.");
                return true;
            }
            if (updateConfirmStatusAndCallback(str2, encryptedConversation2)) {
                return true;
            }
        } else if (b2 == 3) {
            RCEncryptCancelMessage rCEncryptCancelMessage = (RCEncryptCancelMessage) content;
            if (handleRetrivedCancelMessage(message, i, rCEncryptCancelMessage)) {
                return true;
            }
            String str3 = rCEncryptCancelMessage.getResponserEncId() + ";;;" + targetId;
            RCEncryptedSession encryptedConversation3 = this.mLibHandler.getEncryptedConversation(str3);
            RLog.d(TAG, "cancleResponserEncId -> " + str3);
            if (encryptedConversation3 == null) {
                RLog.w(TAG, "can not find encrypted conersation while canceling the session with the targetID -> " + str3);
                return true;
            }
            updateCancelStatusAndCallback(str3, encryptedConversation3);
        } else if (b2 == 4) {
            RCEncryptTerminateMessage rCEncryptTerminateMessage = (RCEncryptTerminateMessage) content;
            String receiverEncId = rCEncryptTerminateMessage.getReceiverEncId();
            if (receiverEncId == null) {
                receiverEncId = "";
            }
            if (this.signalBuff.containsKey(receiverEncId)) {
                this.signalBuff.remove(receiverEncId);
                return true;
            }
            String str4 = rCEncryptTerminateMessage.getReceiverEncId() + ";;;" + targetId;
            RCEncryptedSession encryptedConversation4 = this.mLibHandler.getEncryptedConversation(str4);
            if (encryptedConversation4 == null) {
                RLog.w(TAG, "can not find encrypted conversation with encTargetId ->" + str4);
                return true;
            }
            String senderEncId = rCEncryptTerminateMessage.getSenderEncId();
            if (senderEncId == null || !senderEncId.equals(encryptedConversation4.getRemoteEncId())) {
                return true;
            }
            updateTerinateStatusAndCallback(str4, encryptedConversation4);
        }
        return false;
    }

    private void handleReadReceiptMessage(final Message message) {
        if (!message.getMessageDirection().equals(Message.MessageDirection.SEND)) {
            updateMessageReceiptStatus(message.getConversationType(), message.getTargetId(), ((ReadReceiptMessage) message.getContent()).getLastMessageSendTime(), new OperationCallback() { // from class: io.rong.imlib.RongIMClient.98
                @Override // io.rong.imlib.RongIMClient.Callback
                public void onError(ErrorCode errorCode) {
                    RLog.e(RongIMClient.TAG, "RongIMClient : updateMessageReceiptStatus fail");
                }

                @Override // io.rong.imlib.RongIMClient.Callback
                public void onSuccess() {
                    if (RongIMClient.sReadReceiptListener != null) {
                        RongIMClient.sReadReceiptListener.onReadReceiptReceived(message);
                    }
                }
            });
            return;
        }
        clearMessagesUnreadStatus(message.getConversationType(), message.getTargetId(), ((ReadReceiptMessage) message.getContent()).getLastMessageSendTime(), null);
        SyncConversationReadStatusListener syncConversationReadStatusListener = this.mSyncConversationReadStatusListener;
        if (syncConversationReadStatusListener != null) {
            syncConversationReadStatusListener.onSyncConversationReadStatus(message.getConversationType(), message.getTargetId());
        }
    }

    private boolean handleRetrivedCancelMessage(Message message, int i, RCEncryptCancelMessage rCEncryptCancelMessage) {
        String requesterEncId = rCEncryptCancelMessage.getRequesterEncId();
        String responserEncId = rCEncryptCancelMessage.getResponserEncId();
        if (!this.signalBuff.containsKey(requesterEncId)) {
            return false;
        }
        this.signalBuff.remove(requesterEncId);
        RLog.d(TAG, "req -> " + requesterEncId + "resp -> " + responserEncId + " cancel from buff at " + System.currentTimeMillis());
        return true;
    }

    private boolean handleRetrivedConfirmMessage(Message message, int i, RCEncryptConfirmMessage rCEncryptConfirmMessage) {
        String requesterEncId = rCEncryptConfirmMessage.getRequesterEncId();
        if (!this.signalBuff.containsKey(requesterEncId)) {
            return false;
        }
        this.signalBuff.remove(requesterEncId);
        RLog.d(TAG, "confirm from buff at " + System.currentTimeMillis());
        return true;
    }

    public static void init(Application application, String str) {
        init(application, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBindService() {
        if (this.mLibHandler != null) {
            initReceiver();
            return;
        }
        Context context = this.mContext;
        if (context == null || this.mAppKey == null) {
            RLog.d(TAG, "initBindService context or appKey is null,cause by bind before init");
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) RongService.class);
            intent.putExtra("appKey", this.mAppKey);
            intent.putExtra("deviceId", DeviceUtils.getDeviceId(this.mContext, this.mAppKey));
            this.mContext.bindService(intent, this.mAidlConnection, 1);
        } catch (SecurityException e2) {
            RLog.e(TAG, "initBindService SecurityException");
            RLog.e(TAG, "initBindService", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReceiver() {
        RLog.i(TAG, "initMessageReceiver");
        try {
            if (!TextUtils.isEmpty(mNaviServer)) {
                this.mLibHandler.setServerInfo(mNaviServer, TextUtils.isEmpty(mFileServer) ? "" : mFileServer);
            }
            this.mLibHandler.initHttpDns();
            this.mLibHandler.setUserPolicy(userPolicy);
            if (this.mStatusListener == null) {
                this.mStatusListener = new StatusListener();
            }
            this.mLibHandler.setConnectionStatusListener(this.mStatusListener);
            this.mLibHandler.setReconnectKickEnable(this.kickReconnectDevice);
            this.mLibHandler.setOnReceiveMessageListener(new OnReceiveMessageListener.Stub() { // from class: io.rong.imlib.RongIMClient.101
                @Override // io.rong.imlib.OnReceiveMessageListener
                public boolean onReceived(final Message message, final int i, final boolean z, final boolean z2, final int i2) throws RemoteException {
                    RongIMClient.this.mUpStreamHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.101.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (message.getContent() == null) {
                                RLog.e(RongIMClient.TAG, "message content is null. Return directly!");
                                return;
                            }
                            MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
                            if (messageTag != null) {
                                try {
                                    if (messageTag.value().contains("RC:Encrypt")) {
                                        if (RongIMClient.this.handleEncMessageContent(message, i, z, i2)) {
                                            return;
                                        }
                                    }
                                } catch (RemoteException e2) {
                                    RLog.e(RongIMClient.TAG, "message:" + e2.getMessage());
                                }
                            }
                            if (!z2) {
                                RLog.i(RongIMClient.TAG, "onReceived : " + message.getTargetId() + " " + message.getObjectName() + ", sender = " + message.getSenderUserId() + ", uid = " + message.getUId());
                            }
                            if (RongIMClient.this.handleCmdMessages(message, i, z2, z, i2) || RongIMClient.sReceiveMessageListener == null) {
                                return;
                            }
                            if (RongIMClient.sReceiveMessageListener instanceof OnReceiveMessageWrapperListener) {
                                ((OnReceiveMessageWrapperListener) RongIMClient.sReceiveMessageListener).onReceived(message, i - i2, z2, z);
                            } else {
                                RongIMClient.sReceiveMessageListener.onReceived(message, i - i2);
                            }
                        }
                    });
                    return false;
                }

                @Override // io.rong.imlib.OnReceiveMessageListener.Stub, android.os.Binder
                public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
                    try {
                        return super.onTransact(i, parcel, parcel2, i2);
                    } catch (RuntimeException e2) {
                        RLog.e(RongIMClient.TAG, "setOnReceiveMessageListener Unexpected remote exception", e2);
                        throw e2;
                    }
                }
            });
            this.mLibHandler.setUserProfileListener(new UserProfileSettingListener.Stub() { // from class: io.rong.imlib.RongIMClient.102
                @Override // io.rong.imlib.UserProfileSettingListener
                public void OnPushNotificationChanged(long j) throws RemoteException {
                    RongIMClient.this.getPushContentShowStatus(new ResultCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.102.1
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(ErrorCode errorCode) {
                            RLog.i(RongIMClient.TAG, "OnPushNotificationChanged onError  " + errorCode);
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Boolean bool) {
                            RLog.i(RongIMClient.TAG, "OnPushNotificationChanged onSuccess  " + bool);
                            RongPushClient.updatePushContentShowStatus(RongIMClient.this.mContext, bool.booleanValue());
                        }
                    });
                }
            });
            this.mLibHandler.setConversationStatusListener(new ConversationStatusListener.Stub() { // from class: io.rong.imlib.RongIMClient.103
                @Override // io.rong.imlib.ConversationStatusListener
                public void OnStatusChanged(ConversationStatus[] conversationStatusArr) {
                    if (RongIMClient.sConversationStatusListener != null) {
                        RongIMClient.sConversationStatusListener.onStatusChanged(conversationStatusArr);
                    }
                }
            });
            this.mLibHandler.setMessageExpansionListener(new IMessageExpansionListener.Stub() { // from class: io.rong.imlib.RongIMClient.104
                @Override // io.rong.imlib.IMessageExpansionListener
                public void onMessageExpansionRemove(List<String> list, Message message) {
                    if (RongIMClient.messageExpansionListener != null) {
                        RongIMClient.messageExpansionListener.onMessageExpansionRemove(list, message);
                    }
                }

                @Override // io.rong.imlib.IMessageExpansionListener
                public void onMessageExpansionUpdate(Map map, Message message) {
                    if (RongIMClient.messageExpansionListener != null) {
                        RongIMClient.messageExpansionListener.onMessageExpansionUpdate(map, message);
                    }
                }
            });
            synchronized (this.mRegCache) {
                this.mLibHandler.registerMessageTypes(new ArrayList(this.mRegCache));
            }
            this.mLibHandler.registerCmdMsgTypes(new ArrayList(this.mCmdObjectNameList));
            this.mLibHandler.registerDeleteMessageType(new ArrayList(this.mDeleteObjectNameList));
            if (cancelSDKHeartBeatEnabled) {
                try {
                    this.mLibHandler.cancelSDKHeartBeat();
                } catch (RemoteException e2) {
                    RLog.e(TAG, "initReceiver", e2);
                }
            }
            this.mLibHandler.setKvStatusListener(new KVStatusDataByBatchListener.Stub() { // from class: io.rong.imlib.RongIMClient.105
                Map<String, String> resultChange = new HashMap();
                Map<String, String> resultRemove = new HashMap();

                @Override // io.rong.imlib.KVStatusDataByBatchListener
                public void onCompleteDataChange(String str) throws RemoteException {
                    RLog.i(RongIMClient.TAG, "onCompleteDataChange roomId =" + str + " size" + this.resultChange.size());
                    if (RongIMClient.sKVStatusListener != null) {
                        RongIMClient.sKVStatusListener.onChatRoomKVUpdate(str, this.resultChange);
                    }
                    this.resultChange.clear();
                }

                @Override // io.rong.imlib.KVStatusDataByBatchListener
                public void onCompleteDataRemove(String str) throws RemoteException {
                    RLog.i(RongIMClient.TAG, "onCompleteDataRemove roomId =" + str + " size" + this.resultRemove.size());
                    if (RongIMClient.sKVStatusListener != null) {
                        RongIMClient.sKVStatusListener.onChatRoomKVRemove(str, this.resultRemove);
                    }
                    this.resultRemove.clear();
                }

                @Override // io.rong.imlib.KVStatusDataByBatchListener
                public void onDataSync(String str) throws RemoteException {
                    RLog.i(RongIMClient.TAG, "onChatRoomKVStatusSync roomId =" + str);
                    if (RongIMClient.sKVStatusListener != null) {
                        RongIMClient.sKVStatusListener.onChatRoomKVSync(str);
                    }
                }

                @Override // io.rong.imlib.KVStatusDataByBatchListener
                public void onProgressDataChange(Map map) throws RemoteException {
                    this.resultChange.putAll(map);
                }

                @Override // io.rong.imlib.KVStatusDataByBatchListener
                public void onProgressDataRemove(Map map) throws RemoteException {
                    this.resultRemove.putAll(map);
                }
            });
        } catch (Exception e3) {
            RLog.e(TAG, "initReceiver", e3);
        }
    }

    private void initSDK(final Context context, String str) {
        String currentProcessName = SystemUtils.getCurrentProcessName(context);
        String packageName = context.getPackageName();
        RLog.d(TAG, "init : " + currentProcessName + ", " + packageName + ", " + context);
        if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !packageName.equals(currentProcessName)) {
            RLog.e(TAG, "SDK should init in main process.");
            return;
        }
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: io.rong.imlib.RongIMClient.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    if (RongIMClient.this.topForegroundActivity == null) {
                        RLog.i(RongIMClient.TAG, "in Foreground");
                        RongIMClient.this.onAppBackgroundChanged(true);
                    }
                    RongIMClient.this.topForegroundActivity = activity;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    RLog.i(RongIMClient.TAG, "saveInstance");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    if (RongIMClient.this.topForegroundActivity == activity) {
                        RLog.i(RongIMClient.TAG, "in Background");
                        RongIMClient.this.onAppBackgroundChanged(false);
                        RongIMClient.this.topForegroundActivity = null;
                    }
                }
            });
        }
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            try {
                this.mAppKey = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("RONG_CLOUD_APP_KEY");
                if (TextUtils.isEmpty(this.mAppKey) || !SystemUtils.isValidAppKey(this.mAppKey)) {
                    throw new IllegalArgumentException("can't find RONG_CLOUD_APP_KEY in AndroidManifest.xml.");
                }
            } catch (PackageManager.NameNotFoundException e2) {
                RLog.e(TAG, "*initSDK", e2);
                throw new ExceptionInInitializerError("can't find packageName!");
            }
        } else {
            this.mAppKey = str;
        }
        RLog.init(context, this.mAppKey, BuildVar.SDK_VERSION);
        FwLog.setLogConsolePrinter(new RtFwLogConsolePrinter(this.mContext));
        FwLog.write(3, 1, FwLog.LogTag.A_INIT_O.getTag(), "appkey|platform|model|sdk", this.mAppKey, "Android-" + Build.VERSION.SDK_INT, Build.MODEL, BuildVar.SDK_VERSION);
        MessageBufferPool.init(this.mContext);
        this.imLibExtensionModuleManager.loadAllIMLibExtensionModules();
        this.imLibExtensionModuleManager.onCreate(context, this.mAppKey);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesUtils.get(context, "Statistics", 0).edit().putString("appKey", RongIMClient.this.mAppKey).commit();
                RongIMClient.registerMessageType((Class<? extends MessageContent>) TextMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ReferenceMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) VoiceMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) HQVoiceMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ImageMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) GIFMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) LocationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) CommandNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ContactNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RichContentMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) PublicServiceMultiRichContentMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) PublicServiceRichContentMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) PublicServiceCommandMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ProfileNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) HandshakeMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) InformationNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) DiscussionNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) SuspendMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ReadReceiptMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) CommandMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) TypingStatusMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RecallCommandMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RecallNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ReadReceiptRequestMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ReadReceiptResponseMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) SyncReadStatusMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) GroupNotificationMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) FileMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) HistoryDividerMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptedMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptRequestMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptResponseMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptCancelMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptConfirmMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RCEncryptTerminateMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) DestructionCmdMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) RoomUserStateMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) ChatRoomKVNotiMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) LogCmdMessage.class);
                RongIMClient.registerMessageType((Class<? extends MessageContent>) MessageExpansionMessage.class);
                List<Class<? extends MessageContent>> messageContentList = RongIMClient.this.imLibExtensionModuleManager.getMessageContentList();
                if (messageContentList != null) {
                    Iterator it = new ArrayList(messageContentList).iterator();
                    while (it.hasNext()) {
                        RongIMClient.registerMessageType((Class<? extends MessageContent>) it.next());
                    }
                }
                RongIMClient.this.registerCmdMsgType();
                RongIMClient.this.registerDeleteMessageType();
                RongIMClient.this.registerReconnectIntentFilter();
                RongIMClient.this.initBindService();
                RongIMClient rongIMClient = RongIMClient.this;
                rongIMClient.initStatistics(context, rongIMClient.mAppKey);
                if (!RongIMClient.isPushEnabled) {
                    context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushReceiver.class), 2, 1);
                } else if (RongIMClient.mNaviServer != null) {
                    RongPushClient.init(context, RongIMClient.this.mAppKey, RongIMClient.mNaviServer);
                } else {
                    RongPushClient.init(context, RongIMClient.this.mAppKey);
                }
                TypingMessageManager.getInstance().init(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initStatistics(Context context, String str) {
        if (Statistics.sharedInstance().isInitialized()) {
            return;
        }
        if (TextUtils.isEmpty(PRIVATE_STATISTIC)) {
            Statistics.sharedInstance().init(context, URL_STATISTIC, str, DeviceUtils.getDeviceId(context, this.mAppKey));
        } else {
            Statistics.sharedInstance().init(context, PRIVATE_STATISTIC, str, DeviceUtils.getDeviceId(context, this.mAppKey));
        }
        Statistics.sharedInstance().setLoggingEnabled(false);
        Statistics.sharedInstance().onStart();
    }

    private void insertSettingMessage(final Message message, final ResultCallback<Message> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.55
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                message.setSentTime(System.currentTimeMillis());
                message.setSentStatus(null);
                message.setSenderUserId(RongIMClient.this.mCurrentUserId);
                message.setMessageDirection(Message.MessageDirection.SEND);
                try {
                    Message messageInsertSettingMessage = RongIMClient.this.mLibHandler.insertSettingMessage(message);
                    if (resultCallback != null) {
                        if (messageInsertSettingMessage.getMessageId() >= 0) {
                            resultCallback.onCallback(messageInsertSettingMessage);
                        } else if (messageInsertSettingMessage.getMessageId() == ErrorCode.PARAMETER_ERROR.getValue()) {
                            resultCallback.onFail(ErrorCode.PARAMETER_ERROR);
                        } else {
                            resultCallback.onFail(ErrorCode.BIZ_ERROR_DATABASE_ERROR);
                        }
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "insertOutgoingMessage", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSendImageMessage(Message message, String str, String str2, SendImageMessageCallback sendImageMessageCallback) {
        this.mWorkHandler.post(new AnonymousClass64(new IpcCallbackProxy(sendImageMessageCallback), message, str, str2));
    }

    private void isFileDownloading(final String str, final ResultCallback<Boolean> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.136
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    boolean fileDownloadingStatus = RongIMClient.this.mLibHandler.getFileDownloadingStatus(str);
                    if (resultCallback != null) {
                        resultCallback.onCallback(Boolean.valueOf(fileDownloadingStatus));
                    }
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "isFileDownloading", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    private boolean judgeListInvalid(List<String> list, OperationCallback operationCallback) {
        if ((list instanceof ArrayList) || operationCallback == null) {
            return false;
        }
        operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        RLog.e(TAG, "keyArray should be ArrayList!");
        return true;
    }

    private boolean judgeMapInvalid(Map<String, String> map, OperationCallback operationCallback) {
        if ((map instanceof HashMap) || operationCallback == null) {
            return false;
        }
        operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        RLog.e(TAG, "expansion should be HashMap!");
        return true;
    }

    private boolean judgeUIDInvalid(String str, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        RLog.e(TAG, "messageUId is empty!");
        if (operationCallback == null) {
            return true;
        }
        operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackgroundChanged(boolean z) {
        boolean z2 = true;
        FwLog.write(3, 1, FwLog.LogTag.L_APP_STATE_S.getTag(), "foreground", Boolean.valueOf(z));
        isInForeground = z;
        if (this.mLibHandler == null) {
            if (z) {
                RLog.e(TAG, "rebind RongService: " + this.mConnectionStatus);
                initBindService();
                return;
            }
            return;
        }
        if (z) {
            try {
                connectServer(this.mToken, true);
            } catch (Exception e2) {
                RLog.e(TAG, "onAppBackgroundChanged", e2);
                return;
            }
        }
        IHandler iHandler = this.mLibHandler;
        if (isInForeground) {
            z2 = false;
        }
        iHandler.notifyAppBackgroundChanged(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reJoinChatRoomWithCache() {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.79
            @Override // java.lang.Runnable
            public void run() {
                int size = RongIMClient.this.mRetryCRCache.size();
                if (size > 0) {
                    RLog.d(RongIMClient.TAG, "clear retry chatroom cache after connectivity available, cached size = " + size);
                    Iterator it = RongIMClient.this.mRetryCRCache.values().iterator();
                    while (it.hasNext()) {
                        RongIMClient.this.mWorkHandler.removeCallbacks((ChatRoomCacheRunnable) it.next());
                    }
                    RongIMClient.this.mRetryCRCache.clear();
                }
                int size2 = RongIMClient.this.mChatRoomCache.size();
                if (size2 > 0) {
                    RLog.d(RongIMClient.TAG, "re-join chatroom after connectivity available, cached size = " + size2);
                    Iterator it2 = RongIMClient.this.mChatRoomCache.values().iterator();
                    while (it2.hasNext()) {
                        RongIMClient.this.mWorkHandler.post((ChatRoomCacheRunnable) it2.next());
                    }
                }
            }
        });
    }

    static void reconnectServer() {
        if (SingletonHolder.sInstance.mLibHandler == null) {
            mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.4
                @Override // java.lang.Runnable
                public void run() {
                    RongIMClient rongIMClient = SingletonHolder.sInstance;
                    rongIMClient.connectServer(rongIMClient.mToken, true);
                }
            });
            return;
        }
        RLog.d(TAG, "reconnectServer, t = " + SingletonHolder.sInstance.mToken);
        RongIMClient rongIMClient = SingletonHolder.sInstance;
        rongIMClient.connectServer(rongIMClient.mToken, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerCmdMsgType() {
        try {
            this.mCmdObjectNameList.add(((MessageTag) ReadReceiptMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) ReadReceiptRequestMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) ReadReceiptResponseMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) TypingStatusMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) RecallCommandMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) SyncReadStatusMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) LogCmdMessage.class.getAnnotation(MessageTag.class)).value());
            this.mCmdObjectNameList.add(((MessageTag) MessageExpansionMessage.class.getAnnotation(MessageTag.class)).value());
            List<Class<? extends MessageContent>> cmdMessageContentList = this.imLibExtensionModuleManager.getCmdMessageContentList();
            if (cmdMessageContentList != null) {
                Iterator<Class<? extends MessageContent>> it = cmdMessageContentList.iterator();
                while (it.hasNext()) {
                    this.mCmdObjectNameList.add(((MessageTag) it.next().getAnnotation(MessageTag.class)).value());
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            RLog.e(TAG, "Exception when register command messages. e:" + e2.getMessage());
        } catch (IncompatibleClassChangeError e3) {
            RLog.e(TAG, "error when register command message. error message:" + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerDeleteMessageType() {
        try {
            this.mDeleteObjectNameList.add(((MessageTag) ReadReceiptMessage.class.getAnnotation(MessageTag.class)).value());
            this.mDeleteObjectNameList.add(((MessageTag) SyncReadStatusMessage.class.getAnnotation(MessageTag.class)).value());
        } catch (ArrayIndexOutOfBoundsException e2) {
            RLog.e(TAG, "Exception when register deleted messages. e:" + e2.getMessage());
        }
    }

    @Deprecated
    public static void registerMessageType(Class<? extends MessageContent> cls) {
        if (cls == null) {
            FwLog.write(2, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "messageContentClass", "null");
            return;
        }
        synchronized (SingletonHolder.sInstance.mRegCache) {
            if (!SingletonHolder.sInstance.mRegCache.contains(cls.getName())) {
                SingletonHolder.sInstance.mRegCache.add(cls.getName());
            }
        }
        IHandler iHandler = SingletonHolder.sInstance.mLibHandler;
        if (iHandler != null) {
            try {
                iHandler.registerMessageType(cls.getName());
            } catch (Exception e2) {
                RLog.e(TAG, "registerMessageType RemoteException", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerReconnectIntentFilter() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.mContext.registerReceiver(this.mConnectChangeReceiver, intentFilter);
        } catch (Exception e2) {
            RLog.e(TAG, "registerReconnectIntentFilter failed: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        mHandler.post(runnable);
    }

    private void sendCancelMessage(String str, RCEncryptResponseMessage rCEncryptResponseMessage, RCEncryptedSession rCEncryptedSession) {
        RCEncryptCancelMessage rCEncryptCancelMessage = new RCEncryptCancelMessage();
        rCEncryptCancelMessage.setRequesterEncId(rCEncryptResponseMessage.getRequesterEncId());
        rCEncryptCancelMessage.setResponserEncId(rCEncryptResponseMessage.getResponserEncId());
        RLog.d(TAG, "set respEncIdInResp in cancel msg -> " + rCEncryptResponseMessage.getResponserEncId() + Thread.currentThread().getName());
        sendMessage(Conversation.ConversationType.PRIVATE, str, rCEncryptCancelMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.111
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                RLog.d(RongIMClient.TAG, "send cancelMsg error." + Thread.currentThread().getName());
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RLog.d(RongIMClient.TAG, "send cancelMsg successfully.");
            }
        });
    }

    private void sendChangeModelMessage(String str, String str2) {
        CustomServiceManager.getInstance().sendChangeModelMessage(str, str2);
    }

    private void sendConfirmMessage(String str, RCEncryptResponseMessage rCEncryptResponseMessage, RCDHCodecTool.RCSecretKey rCSecretKey, RCEncryptedSession rCEncryptedSession) {
        RCEncryptConfirmMessage rCEncryptConfirmMessage = new RCEncryptConfirmMessage();
        rCEncryptConfirmMessage.setRequesterEncId(rCEncryptResponseMessage.getRequesterEncId());
        rCEncryptConfirmMessage.setResponserEncId(rCEncryptResponseMessage.getResponserEncId());
        sendMessage(Conversation.ConversationType.PRIVATE, str, rCEncryptConfirmMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.110
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                RLog.w(RongIMClient.TAG, "confirm message send failed ,error occurs with error code : " + errorCode);
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RLog.d(RongIMClient.TAG, "confirm message send success.");
            }
        });
    }

    private void sendRequestMsg(final String str, final String str2, final RCDHCodecTool rCDHCodecTool) {
        RCEncryptRequestMessage rCEncryptRequestMessage = new RCEncryptRequestMessage();
        rCEncryptRequestMessage.setRequesterEncId(str2);
        rCEncryptRequestMessage.setRequesterKey(rCDHCodecTool.getRCPubKey().toString());
        sendMessage(Conversation.ConversationType.PRIVATE, str, rCEncryptRequestMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.140
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                RLog.w(RongIMClient.TAG, "request message send failed ,error occurs with error code : " + errorCode);
                if (RongIMClient.this.mEncSessionConListener != null) {
                    RongIMClient.this.mEncSessionConListener.onEncryptedSessionRequest(str2 + ";;;" + str, false);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RCEncryptedSession rCEncryptedSession = new RCEncryptedSession();
                rCEncryptedSession.setTargetId(str2 + ";;;" + str);
                rCEncryptedSession.setRemoteEncId(null);
                rCEncryptedSession.setEncKey(null);
                rCEncryptedSession.setEncXA(rCDHCodecTool.getRCPriKey().toString());
                rCEncryptedSession.setEncStatus(1);
                try {
                    if (!RongIMClient.this.mLibHandler.createEncryptedConversation(str2 + ";;;" + str, rCEncryptedSession) || RongIMClient.this.mEncSessionConListener == null) {
                        return;
                    }
                    RongIMClient.this.mEncSessionConListener.onEncryptedSessionRequest(str2 + ";;;" + str, true);
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "sendRequestMsg", e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendResponseMsg(RCEncryptRequestMessage rCEncryptRequestMessage, final String str) {
        RCDHCodecTool.RCDHPublicKey rCDHPublicKeyFromString2RCDHPublicKey = RCDHCodecTool.fromString2RCDHPublicKey(rCEncryptRequestMessage.getRequesterKey());
        final String requesterEncId = rCEncryptRequestMessage.getRequesterEncId();
        if (requesterEncId == null) {
            RLog.e(TAG, "error in onReceived -> RC:EncryptRequestMsg requestEncId is null!");
            return true;
        }
        final String strGenEncId = RCDHCodecTool.genEncId();
        final RCDHCodecTool rCDHCodecToolObtainWithEncId = RCDHCodecTool.obtainWithEncId(strGenEncId);
        RLog.d(TAG, "responseEncId -> " + strGenEncId);
        if ((rCDHCodecToolObtainWithEncId == null ? null : rCDHCodecToolObtainWithEncId.genSecretKey(rCDHPublicKeyFromString2RCDHPublicKey)) == null) {
            RLog.e(TAG, "genSecretKey is null");
            return true;
        }
        RCEncryptResponseMessage rCEncryptResponseMessage = new RCEncryptResponseMessage();
        rCEncryptResponseMessage.setRequesterEncId(requesterEncId);
        rCEncryptResponseMessage.setResponserEncId(strGenEncId);
        KeyPair orCreateLocalKeyPair = rCDHCodecToolObtainWithEncId.getOrCreateLocalKeyPair(null);
        if (orCreateLocalKeyPair == null) {
            RLog.e(TAG, "create localt keyPair failed!");
            return true;
        }
        if (orCreateLocalKeyPair.getPublic() != null && (orCreateLocalKeyPair.getPublic() instanceof RCDHCodecTool.RCDHPublicKey)) {
            rCEncryptResponseMessage.setResponserKey(rCDHCodecToolObtainWithEncId.getRCPubKey().toString());
        }
        sendMessage(Conversation.ConversationType.PRIVATE, str, rCEncryptResponseMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.112
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                RLog.w(RongIMClient.TAG, "response message send failed ,error occurs with error code : " + errorCode);
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                RCEncryptedSession rCEncryptedSession = new RCEncryptedSession();
                rCEncryptedSession.setTargetId(strGenEncId + ";;;" + str);
                rCEncryptedSession.setRemoteEncId(requesterEncId);
                rCEncryptedSession.setEncXA(rCDHCodecToolObtainWithEncId.getRCPriKey().toString());
                rCEncryptedSession.setEncKey(RCDHCodecTool.getRCSecretKeyByEncId(strGenEncId).toString());
                rCEncryptedSession.setEncStatus(2);
                try {
                    if (!RongIMClient.this.mLibHandler.createEncryptedConversation(strGenEncId + ";;;" + str, rCEncryptedSession)) {
                        RLog.e(RongIMClient.TAG, "createEncryptedConversation failed when sending responseMsg!");
                    } else if (RongIMClient.this.mEncSessionConListener != null) {
                        RongIMClient.this.mEncSessionConListener.onEncryptedSessionResponse(strGenEncId + ";;;" + str);
                    }
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "sendResponseMsg", e2);
                }
            }
        });
        return false;
    }

    public static void setChatRoomActionListener(ChatRoomActionListener chatRoomActionListener2) {
        chatRoomActionListener.set(chatRoomActionListener2);
    }

    public static void setConnectionStatusListener(ConnectionStatusListener connectionStatusListener) {
        sConnectionListener = connectionStatusListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIPCLogListener() {
        try {
            final IHandler iHandler = this.mLibHandler;
            FwLog.setProxyWriter(new IFwLogWriter() { // from class: io.rong.imlib.RongIMClient.106
                @Override // io.rong.common.fwlog.IFwLogWriter
                public void write(int i, String str, String str2, String str3, long j) {
                    try {
                        if (iHandler != null) {
                            iHandler.writeFwLog(i, str, str2, str3, j);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
            if (iHandler != null) {
                iHandler.setRLogOtherProgressCallback(new IRLogOtherProgressCallback.Stub() { // from class: io.rong.imlib.RongIMClient.107
                    @Override // io.rong.imlib.IRLogOtherProgressCallback
                    public void setLogLevel(int i) {
                        RLog.setLogLevel(i);
                    }

                    @Override // io.rong.imlib.IRLogOtherProgressCallback
                    public void uploadRLog() {
                        RLog.uploadRLog();
                    }

                    @Override // io.rong.imlib.IRLogOtherProgressCallback
                    public void write(String str, int i) {
                        RLog.callbackWrite(str, i);
                    }
                });
                iHandler.setNaviContentUpdateListener(new INaviContentUpdateCallBack.Stub() { // from class: io.rong.imlib.RongIMClient.108
                    @Override // io.rong.imlib.INaviContentUpdateCallBack
                    public void naviContentUpdate() {
                        RongIMClient.this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.108.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    RLog.setUploadUrl(iHandler.getOffLineLogServer());
                                } catch (Exception e2) {
                                    RLog.e(RongIMClient.TAG, "getUploadLogConfigInfo", e2);
                                }
                            }
                        });
                    }
                });
            }
        } catch (RemoteException e2) {
            RLog.e(TAG, "setIPCLogListener", e2);
        }
    }

    public static void setOnRecallMessageListener(OnRecallMessageListener onRecallMessageListener) {
        sOnRecallMessageListener = onRecallMessageListener;
    }

    public static void setOnReceiveMessageListener(OnReceiveMessageListener onReceiveMessageListener) {
        sReceiveMessageListener = onReceiveMessageListener;
    }

    private void setPushSetting(final PushSettings pushSettings, final String str, OperationCallback operationCallback) {
        if (this.mLibHandler != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.129
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.setPushSetting(pushSettings.getValue(), str, new ISetPushSettingCallback.Stub() { // from class: io.rong.imlib.RongIMClient.129.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ISetPushSettingCallback
                            public void onComplete() throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((OperationCallback) t2).onCallback();
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ISetPushSettingCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((OperationCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "setPushSetting", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.d(TAG, "[PushSetting] setPushSetting mLibHandler is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.IPC_DISCONNECT);
            }
        }
    }

    public static void setRCLogInfoListener(final RCLogInfoListener rCLogInfoListener) {
        FwLog.setLogListener(new FwLog.ILogListener() { // from class: io.rong.imlib.RongIMClient.115
            @Override // io.rong.common.fwlog.FwLog.ILogListener
            public void onLogEvent(String str) {
                rCLogInfoListener.onRCLogInfoOccurred(str);
            }
        });
    }

    public static void setReadReceiptListener(ReadReceiptListener readReceiptListener) {
        sReadReceiptListener = readReceiptListener;
    }

    public static void setServerInfo(String str, String str2) {
        RLog.d(TAG, "setServerInfo naviServer :" + str + ", fileServer:" + str2);
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "setServerInfo naviServer should not be null.");
            throw new IllegalArgumentException("naviServer should not be null.");
        }
        if (!SystemUtils.isLegalServer(str) || (!TextUtils.isEmpty(str2) && !SystemUtils.isLegalServer(str2))) {
            throw new IllegalArgumentException("Invalid url,check validity of naviServer and fileServer");
        }
        FwLog.write(3, 1, FwLog.LogTag.A_SET_SERVER_O.getTag(), "navi|file", str, str2);
        mNaviServer = str.trim();
        if (str2 != null) {
            mFileServer = str2.trim();
        }
    }

    public static void setStatisticDomain(String str) {
        FwLog.write(3, 1, FwLog.LogTag.A_SET_STATISTIC_SERVER_O.getTag(), "domain", str);
        PRIVATE_STATISTIC = String.format(str.toLowerCase().startsWith("http") ? "%s/active.json" : "http://%s/active.json", str);
    }

    private void setToken(String str) {
        RLog.d(TAG, "set token");
        this.mToken = str;
    }

    public static void setTypingStatusListener(TypingStatusListener typingStatusListener) {
        TypingMessageManager.getInstance().setTypingMessageStatusListener(typingStatusListener);
    }

    private void startConnectTimeoutTimer(int i) {
        stopConnectTimeoutTimer();
        this.connectTimeoutTimer = new Timer();
        this.connectTimeoutTimer.schedule(new TimerTask() { // from class: io.rong.imlib.RongIMClient.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    RongIMClient.this.mStatusListener.onConnectionStatusChange(ConnectionStatusListener.ConnectionStatus.TIMEOUT);
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.setIpcConnectTimeOut();
                } catch (Exception unused) {
                    RongIMClient.this.mStatusListener.onConnectionStatusChange(ConnectionStatusListener.ConnectionStatus.TIMEOUT);
                }
            }
        }, ((long) i) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopConnectTimeoutTimer() {
        Timer timer = this.connectTimeoutTimer;
        if (timer != null) {
            timer.cancel();
            this.connectTimeoutTimer = null;
        }
    }

    private int[] toIntArray(Collection<Integer> collection) {
        int i = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    private void updateCancelStatusAndCallback(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
        rCEncryptedSession.setEncStatus(4);
        if (!this.mLibHandler.setEncryptedConversation(str, rCEncryptedSession)) {
            RLog.e(TAG, "setEncryptedConversation failed when receive EncryptCancelMsg.");
            return;
        }
        EncryptedSessionConnectionListener encryptedSessionConnectionListener = this.mEncSessionConListener;
        if (encryptedSessionConnectionListener != null) {
            encryptedSessionConnectionListener.onEncryptedSessionCanceled(str);
        }
    }

    private boolean updateConfirmStatusAndCallback(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
        rCEncryptedSession.setEncStatus(3);
        if (this.mLibHandler.setEncryptedConversation(str, rCEncryptedSession)) {
            this.mEncSessionConListener.onEncryptedSessionEstablished(str);
            return false;
        }
        RLog.e(TAG, "setEncryptedConversation failed while updating encStatus.");
        return true;
    }

    private void updateMessageReceiptStatus(final Conversation.ConversationType conversationType, final String str, final long j, final OperationCallback operationCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.95
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    if (RongIMClient.this.mLibHandler.updateMessageReceiptStatus(str, conversationType.getValue(), j)) {
                        if (operationCallback != null) {
                            operationCallback.onCallback();
                        }
                    } else if (operationCallback != null) {
                        operationCallback.onFail(ErrorCode.UNKNOWN);
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "updateMessageReceiptStatus", e2);
                }
            }
        });
    }

    private void updatePushContentShowStatus() {
        getPushContentShowStatus(new ResultCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.142
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                RLog.e(RongIMClient.TAG, "Can't get push content show status!");
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                RongPushClient.updatePushContentShowStatus(RongIMClient.this.mContext, bool.booleanValue());
            }
        });
    }

    private void updateSessionStateAndCallback(String str, String str2, String str3, RCDHCodecTool.RCSecretKey rCSecretKey, RCEncryptedSession rCEncryptedSession) {
        try {
            String str4 = str + ";;;" + str2;
            rCEncryptedSession.setRemoteEncId(str3);
            rCEncryptedSession.setEncKey(rCSecretKey.toString());
            rCEncryptedSession.setEncStatus(3);
            if (!this.mLibHandler.setEncryptedConversation(str4, rCEncryptedSession)) {
                RLog.e(TAG, "setEncryptedConversation failed when send confirm ms");
            } else if (this.mEncSessionConListener != null) {
                this.mEncSessionConListener.onEncryptedSessionEstablished(str4);
            }
        } catch (RemoteException e2) {
            RLog.e(TAG, "updateSessionStateAndCallback", e2);
        }
    }

    private void updateTerinateStatusAndCallback(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
        rCEncryptedSession.setEncStatus(5);
        this.mLibHandler.setEncryptedConversation(str, rCEncryptedSession);
        EncryptedSessionConnectionListener encryptedSessionConnectionListener = this.mEncSessionConListener;
        if (encryptedSessionConnectionListener != null) {
            encryptedSessionConnectionListener.onEncryptedSessionTerminated(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadMedia(final Message message, UploadMediaCallback uploadMediaCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (uploadMediaCallback != null) {
                uploadMediaCallback.onError(message, errorCodeFilterSendMessage);
                return;
            }
            return;
        }
        Uri localUri = null;
        if (message.getContent() instanceof ImageMessage) {
            localUri = ((ImageMessage) message.getContent()).getLocalUri();
        } else if (message.getContent() instanceof GIFMessage) {
            localUri = ((GIFMessage) message.getContent()).getLocalUri();
        }
        if (FileUtils.isFileExistsWithUri(this.mContext, localUri)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(uploadMediaCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.65
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((UploadMediaCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.uploadMedia(message, new IUploadCallback.Stub() { // from class: io.rong.imlib.RongIMClient.65.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IUploadCallback
                            public void onComplete(String str) throws RemoteException {
                                RLog.i(RongIMClient.TAG, "uploadMedia onComplete url = " + str);
                                MessageContent content = message.getContent();
                                if (content instanceof ImageMessage) {
                                    ((ImageMessage) content).setRemoteUri(Uri.parse(str));
                                }
                                AnonymousClass65 anonymousClass65 = AnonymousClass65.this;
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((UploadMediaCallback) t2).onCallback(message);
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IUploadCallback
                            public void onFailure(int i) throws RemoteException {
                                RLog.e(RongIMClient.TAG, "uploadMedia onFailure: " + i);
                                AnonymousClass65 anonymousClass65 = AnonymousClass65.this;
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((UploadMediaCallback) t2).onFail(message, ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IUploadCallback
                            public void onProgress(int i) throws RemoteException {
                                AnonymousClass65 anonymousClass65 = AnonymousClass65.this;
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((UploadMediaCallback) t2).onProgressCallback(message, i);
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "uploadMedia", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((UploadMediaCallback) t2).onFail(message, ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "uploadMedia Uri :[" + localUri + "文件不存在");
        if (uploadMediaCallback != null) {
            uploadMediaCallback.onError(message, ErrorCode.PARAMETER_ERROR);
        }
    }

    public void addMemberToDiscussion(final String str, final List<String> list, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.50
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.addMemberToDiscussion(str, list, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception unused) {
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "discussionId or userIdList is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void addRealTimeLocationListener(Conversation.ConversationType conversationType, String str, final RealTimeLocationListener realTimeLocationListener) {
        if (conversationType == null || str == null || RealTimeLocationManager.getInstance() == null) {
            RLog.e(TAG, "addRealTimeLocationListener Type or id is null!");
        } else {
            RealTimeLocationManager.getInstance().addListener(conversationType, str, new RealTimeLocationObserver() { // from class: io.rong.imlib.RongIMClient.114
                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onError(final RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.6
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onError(realTimeLocationErrorCode);
                            }
                        }
                    });
                }

                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onParticipantsJoin(final String str2) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.4
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onParticipantsJoin(str2);
                            }
                        }
                    });
                }

                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onParticipantsQuit(final String str2) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.5
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onParticipantsQuit(str2);
                            }
                        }
                    });
                }

                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onReceiveLocation(final double d2, final double d3, final String str2) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onReceiveLocation(d2, d3, str2);
                            }
                        }
                    });
                }

                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onReceiveLocationWithType(final double d2, final double d3, final RealTimeLocationType realTimeLocationType, final String str2) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onReceiveLocationWithType(d2, d3, realTimeLocationType, str2);
                            }
                        }
                    });
                }

                @Override // io.rong.imlib.location.RealTimeLocationObserver
                public void onStatusChange(final RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationStatus) {
                    RongIMClient.mHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.114.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RealTimeLocationListener realTimeLocationListener2 = realTimeLocationListener;
                            if (realTimeLocationListener2 != null) {
                                realTimeLocationListener2.onStatusChange(realTimeLocationStatus);
                            }
                        }
                    });
                }
            });
        }
    }

    public void addToBlacklist(final String str, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.83
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.addToBlacklist(str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "addToBlacklist", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "userId  is null!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void appOnStart() {
        if (this.mContext == null) {
            RLog.e(TAG, "Event ignored. Please call this api after init.!");
        } else {
            RLog.d(TAG, "appOnStart()");
            onAppBackgroundChanged(true);
        }
    }

    public void beginDestructMessage(Message message, DestructCountDownTimerListener destructCountDownTimerListener) {
        if (message == null || message.getContent() == null) {
            RLog.e(TAG, "beginDestructMessage : message or content can't be null!");
        } else if (message.getContent().isDestruct() && message.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            DestructionTaskManager.getInstance().BeginDestruct(message, destructCountDownTimerListener);
        }
    }

    public void cancelDownloadMediaMessage(final Message message, OperationCallback operationCallback) {
        if (message != null && message.getMessageId() > 0 && (message.getContent() instanceof MediaMessageContent) && ((MediaMessageContent) message.getContent()).getMediaUrl() != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.70
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.cancelDownloadMediaMessage(message, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "cancelDownloadMediaMessage", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "cancelDownloadMediaMessage 参数异常。");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void cancelSDKHeartBeat() {
        RLog.d(TAG, "cancelSDKHeartBeat  " + cancelSDKHeartBeatEnabled);
        cancelSDKHeartBeatEnabled = true;
        RongPushClient.cancelPushHeartBeat(this.mContext);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.149
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    RLog.e(RongIMClient.TAG, "mLibHandler is null");
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.cancelSDKHeartBeat();
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "cancelSDKHeartBeat", e2);
                }
            }
        });
    }

    public void cancelSendMediaMessage(final Message message, OperationCallback operationCallback) {
        if (message != null && message.getMessageId() > 0 && (message.getContent() instanceof MediaMessageContent) && ((MediaMessageContent) message.getContent()).getLocalPath() != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.69
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.cancelSendMediaMessage(message, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "cancelSendMediaMessage", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "cancelSendMediaMessage 参数异常。");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void cleanHistoryMessages(final Conversation.ConversationType conversationType, final String str, final long j, final boolean z, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.32
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                        RLog.e(RongIMClient.TAG, "mLibHandler is null!");
                        return;
                    }
                    final Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    if (!z) {
                        RongIMClient.this.cleanLocalHistoryMessages(conversation, j, ipcCallbackProxy);
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.cleanRemoteHistoryMessages(conversation, j, new IOperationCallback.Stub() { // from class: io.rong.imlib.RongIMClient.32.1
                            @Override // io.rong.imlib.IOperationCallback
                            public void onComplete() throws RemoteException {
                                AnonymousClass32 anonymousClass32 = AnonymousClass32.this;
                                RongIMClient.this.cleanLocalHistoryMessages(conversation, j, ipcCallbackProxy);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onFailure(int i) throws RemoteException {
                                RLog.e(RongIMClient.TAG, "cleanHistoryMessages errorCode :" + i);
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((OperationCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "cleanHistoryMessages", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void cleanRemoteHistoryMessages(final Conversation.ConversationType conversationType, final String str, final long j, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.31
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                        RLog.e(RongIMClient.TAG, "mLibHandler is null!");
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        RongIMClient.this.mLibHandler.cleanRemoteHistoryMessages(conversation, j, new IOperationCallback.Stub() { // from class: io.rong.imlib.RongIMClient.31.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onComplete() throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((OperationCallback) t2).onCallback();
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((OperationCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "cleanRemoteHistoryMessages", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void clearConversations(final ResultCallback resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        if (conversationTypeArr != null && conversationTypeArr.length != 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.82
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zClearConversations = RongIMClient.this.mLibHandler.clearConversations(RongIMClient.this.convertTypes(conversationTypeArr));
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zClearConversations));
                        }
                    } catch (Exception unused) {
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "conversationTypes is null!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public boolean clearEncryptedConversations() {
        try {
            if (this.mLibHandler != null) {
                return this.mLibHandler.clearEncryptedConversations();
            }
            RLog.e(TAG, "clearEncryptedConversations: mLibHandler is null.");
            return false;
        } catch (RemoteException e2) {
            RLog.e(TAG, "clearEncryptedConversations", e2);
            return false;
        }
    }

    public void clearMessages(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Boolean> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.39
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        boolean zClearMessages = RongIMClient.this.mLibHandler.clearMessages(conversation);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zClearMessages));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "clearMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void clearMessagesUnreadStatus(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Boolean> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.40
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        boolean zClearMessagesUnreadStatus = RongIMClient.this.mLibHandler.clearMessagesUnreadStatus(conversation);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zClearMessagesUnreadStatus));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "clearMessagesUnreadStatus", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void clearTextMessageDraft(Conversation.ConversationType conversationType, String str, final ResultCallback<Boolean> resultCallback) {
        final Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.46
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zClearTextMessageDraft = RongIMClient.this.mLibHandler.clearTextMessageDraft(conversation);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zClearTextMessageDraft));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "clearTextMessageDraft", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the value of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void createDiscussion(final String str, final List<String> list, CreateDiscussionCallback createDiscussionCallback) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(createDiscussionCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.49
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((CreateDiscussionCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        String strSubstring = str;
                        if (!TextUtils.isEmpty(str) && str.length() > 40) {
                            strSubstring = str.substring(0, 39);
                        }
                        RongIMClient.this.mLibHandler.createDiscussion(strSubstring, list, new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.49.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                if (ipcCallbackProxy.callback != 0) {
                                    if (remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof Discussion)) {
                                        ((CreateDiscussionCallback) ipcCallbackProxy.callback).onCallback(null);
                                    } else {
                                        ((CreateDiscussionCallback) ipcCallbackProxy.callback).onCallback(((Discussion) remoteModelWrap.getContent()).getId());
                                    }
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((CreateDiscussionCallback) t2).onFail(i);
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception unused) {
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((CreateDiscussionCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "name or userIdList is null");
            if (createDiscussionCallback != null) {
                createDiscussionCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void deleteMessages(final int[] iArr, final ResultCallback<Boolean> resultCallback) {
        if (iArr == null || iArr.length == 0) {
            RLog.e(TAG, "the messageIds is null!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            if (i <= 0) {
                RLog.e(TAG, "the messageIds contains 0 value!");
                if (resultCallback != null) {
                    resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                    return;
                }
                return;
            }
            sb.append(i);
            sb.append("/");
        }
        FwLog.write(4, 1, FwLog.LogTag.A_DELETE_MESSAGES_S.getTag(), "messageIds:", sb.toString());
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.36
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    boolean zDeleteMessage = RongIMClient.this.mLibHandler.deleteMessage(iArr);
                    if (resultCallback != null) {
                        resultCallback.onCallback(Boolean.valueOf(zDeleteMessage));
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "deleteMessages", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void deleteRemoteMessages(final Conversation.ConversationType conversationType, final String str, final Message[] messageArr, OperationCallback operationCallback) {
        if (TextUtils.isEmpty(str) || conversationType == null || conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (messageArr != null && messageArr.length != 0 && messageArr.length <= 100) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.38
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.deleteMessages(conversationType.getValue(), str, messageArr, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "deleteMessages", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the messages size is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void disconnect() {
        disconnect(true);
    }

    public void downloadMedia(Conversation.ConversationType conversationType, String str, final MediaType mediaType, final String str2, DownloadMediaCallback downloadMediaCallback) {
        if (conversationType == null || TextUtils.isEmpty(str) || mediaType == null || TextUtils.isEmpty(str2)) {
            RLog.e(TAG, "downloadMedia 参数异常。");
            if (downloadMediaCallback != null) {
                downloadMediaCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        final Conversation conversation = new Conversation();
        conversation.setTargetId(str);
        conversation.setConversationType(conversationType);
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(downloadMediaCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.66
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((DownloadMediaCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.downloadMedia(conversation, mediaType.getValue(), str2, new IDownloadMediaCallback.Stub() { // from class: io.rong.imlib.RongIMClient.66.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IDownloadMediaCallback
                        public void onComplete(String str3) throws RemoteException {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((DownloadMediaCallback) t2).onCallback(str3);
                                ipcCallbackProxy.callback = null;
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IDownloadMediaCallback
                        public void onFailure(int i) throws RemoteException {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((DownloadMediaCallback) t2).onFail(ErrorCode.valueOf(i));
                                ipcCallbackProxy.callback = null;
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IDownloadMediaCallback
                        public void onProgress(int i) throws RemoteException {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((DownloadMediaCallback) t2).onProgressCallback(i);
                            }
                        }
                    });
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "downloadMedia", e2);
                    T t2 = ipcCallbackProxy.callback;
                    if (t2 != 0) {
                        ((DownloadMediaCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            }
        });
    }

    public void downloadMediaFile(String str, String str2, String str3, String str4, IRongCallback.IDownloadMediaFileCallback iDownloadMediaFileCallback) {
        this.mWorkHandler.post(new AnonymousClass68(new IpcCallbackProxy(iDownloadMediaFileCallback), str, str2, str3, str4, iDownloadMediaFileCallback));
    }

    public void downloadMediaMessage(Message message, IRongCallback.IDownloadMediaMessageCallback iDownloadMediaMessageCallback) {
        if (message != null && message.getConversationType() != null && !TextUtils.isEmpty(message.getTargetId()) && message.getContent() != null && (message.getContent() instanceof MediaMessageContent)) {
            this.mWorkHandler.post(new AnonymousClass67(new IpcCallbackProxy(iDownloadMediaMessageCallback), message, iDownloadMediaMessageCallback));
        } else if (iDownloadMediaMessageCallback != null) {
            iDownloadMediaMessageCallback.onError(message, ErrorCode.PARAMETER_ERROR);
        }
    }

    public void evaluateCustomService(String str, boolean z, String str2) {
        CustomServiceManager.getInstance().evaluateCustomService(str, z, str2);
    }

    public void forceRemoveChatRoomEntry(final String str, final String str2, final Boolean bool, final String str3, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.148
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.deleteChatRoomEntry(str2, null, str, bool.booleanValue(), str3, false, true, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "forceRemoveChatRoomEntry", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "forceRemoveChatRoomEntry chatRoomId or key is empty!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void forceSetChatRoomEntry(final String str, final String str2, final String str3, final boolean z, final boolean z2, final String str4, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && str2.matches("^[A-Za-z0-9+_=-]+$")) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.144
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.setChatRoomEntry(str2, str3, str, z, str4, z2, true, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "forceSetChatRoomEntry", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "forceSetChatRoomEntry chatRoomId or key or value is empty or key contains illegal characters!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getAllChatRoomEntries(final String str, final ResultCallback<Map<String, String>> resultCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.146
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        resultCallback.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.getAllChatRoomEntries(str, new IDataByBatchListener.Stub() { // from class: io.rong.imlib.RongIMClient.146.1
                            HashMap<String, String> result = new HashMap<>();

                            @Override // io.rong.imlib.IDataByBatchListener
                            public void onComplete() {
                                RLog.i(RongIMClient.TAG, "getAllChatRoomEntries size =" + this.result.size());
                                resultCallback.onSuccess(this.result);
                            }

                            @Override // io.rong.imlib.IDataByBatchListener
                            public void onError(int i) {
                                resultCallback.onError(ErrorCode.valueOf(i));
                            }

                            @Override // io.rong.imlib.IDataByBatchListener
                            public void onProgress(Map map) {
                                this.result.putAll(map);
                            }
                        });
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getAllChatRoomEntries", e2);
                        resultCallback.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            });
        } else {
            RLog.e(TAG, "getAllChatRoomEntries chatRoomId  is empty!");
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public List<RCEncryptedSession> getAllEncryptedConversations() {
        IHandler iHandler = this.mLibHandler;
        if (iHandler == null) {
            return null;
        }
        try {
            return iHandler.getAllEncryptedConversations();
        } catch (RemoteException e2) {
            RLog.e(TAG, "getAllEncryptedConversations", e2);
            return null;
        }
    }

    public void getBlacklist(GetBlacklistCallback getBlacklistCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(getBlacklistCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.86
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((GetBlacklistCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.getBlacklist(new IStringCallback.Stub() { // from class: io.rong.imlib.RongIMClient.86.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IStringCallback
                        public void onComplete(String str) throws RemoteException {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                if (str == null) {
                                    ((GetBlacklistCallback) t2).onCallback(null);
                                } else {
                                    ((GetBlacklistCallback) t2).onCallback(str.split(UMCustomLogInfoBuilder.LINE_SEP));
                                }
                                ipcCallbackProxy.callback = null;
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IStringCallback
                        public void onFailure(int i) throws RemoteException {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((GetBlacklistCallback) t2).onFail(i);
                                ipcCallbackProxy.callback = null;
                            }
                        }
                    });
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getBlacklist", e2);
                    T t2 = ipcCallbackProxy.callback;
                    if (t2 != 0) {
                        ((GetBlacklistCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            }
        });
    }

    public void getBlacklistStatus(final String str, ResultCallback<BlacklistStatus> resultCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.85
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.getBlacklistStatus(str, new IIntegerCallback.Stub() { // from class: io.rong.imlib.RongIMClient.85.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IIntegerCallback
                            public void onComplete(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onCallback(BlacklistStatus.setValue(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IIntegerCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(i);
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getBlacklistStatus", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "userId  is null!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getBlockedConversationList(final ResultCallback<List<Conversation>> resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.12
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                Conversation.ConversationType[] conversationTypeArr2 = conversationTypeArr;
                if (conversationTypeArr2 == null || conversationTypeArr2.length == 0) {
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.PARAMETER_ERROR);
                        return;
                    }
                    return;
                }
                try {
                    List<Conversation> blockedConversationList = RongIMClient.this.mLibHandler.getBlockedConversationList(RongIMClient.this.convertTypes(conversationTypeArr2));
                    if (resultCallback != null) {
                        resultCallback.onCallback(blockedConversationList);
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getBlockedConversationList", e2);
                    ResultCallback resultCallback4 = resultCallback;
                    if (resultCallback4 != null) {
                        resultCallback4.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void getChatRoomEntry(final String str, final String str2, final ResultCallback<Map<String, String>> resultCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.145
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        resultCallback.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.getChatRoomEntry(str, str2, new IStringCallback.Stub() { // from class: io.rong.imlib.RongIMClient.145.1
                            @Override // io.rong.imlib.IStringCallback
                            public void onComplete(String str3) {
                                HashMap map = new HashMap();
                                map.put(str2, str3);
                                resultCallback.onSuccess(map);
                            }

                            @Override // io.rong.imlib.IStringCallback
                            public void onFailure(int i) {
                                resultCallback.onError(ErrorCode.valueOf(i));
                            }
                        });
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getChatRoomEntry", e2);
                        resultCallback.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            });
        } else {
            RLog.e(TAG, "getChatRoomEntry Parameter  chatRoomId or key is empty!");
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getChatRoomInfo(final String str, final int i, final ChatRoomInfo.ChatRoomMemberOrder chatRoomMemberOrder, ResultCallback<ChatRoomInfo> resultCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.77
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.getChatRoomInfo(str, i, chatRoomMemberOrder.getValue(), new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.77.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                ChatRoomInfo chatRoomInfo;
                                if (remoteModelWrap != null) {
                                    chatRoomInfo = (ChatRoomInfo) remoteModelWrap.getContent();
                                    chatRoomInfo.setMemberOrder(chatRoomMemberOrder);
                                } else {
                                    chatRoomInfo = null;
                                }
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onCallback(chatRoomInfo);
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i2) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(i2);
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getChatRoomInfo", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "id is null");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getChatroomHistoryMessages(String str, long j, int i, TimestampOrder timestampOrder, IRongCallback.IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) {
        if (!TextUtils.isEmpty(str) && timestampOrder != null) {
            this.mWorkHandler.post(new AnonymousClass34(new IpcCallbackProxy(iChatRoomHistoryMessageCallback), str, j, i, timestampOrder));
        } else {
            RLog.e(TAG, "the parameter of targetId or order is null !");
            if (iChatRoomHistoryMessageCallback != null) {
                iChatRoomHistoryMessageCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getConversation(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Conversation> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.13
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        Conversation conversation = RongIMClient.this.mLibHandler.getConversation(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(conversation);
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getConversation", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "getConversation. the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getConversationList(final ResultCallback<List<Conversation>> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.8
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.getConversationListByBatch(10, RongIMClient.this.new GetConversationListProcessCallBackWrapper(resultCallback));
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getConversationList", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void getConversationListByPage(final ResultCallback<List<Conversation>> resultCallback, final long j, final int i, final Conversation.ConversationType... conversationTypeArr) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.11
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                Conversation.ConversationType[] conversationTypeArr2 = conversationTypeArr;
                if (conversationTypeArr2 == null || conversationTypeArr2.length == 0) {
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.PARAMETER_ERROR);
                        return;
                    }
                    return;
                }
                try {
                    List<Conversation> conversationListByPage = RongIMClient.this.mLibHandler.getConversationListByPage(RongIMClient.this.convertTypes(conversationTypeArr2), j, i);
                    if (resultCallback != null) {
                        resultCallback.onCallback(conversationListByPage);
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getConversationListByPage", e2);
                    ResultCallback resultCallback4 = resultCallback;
                    if (resultCallback4 != null) {
                        resultCallback4.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void getConversationNotificationStatus(final Conversation.ConversationType conversationType, final String str, ResultCallback<Conversation.ConversationNotificationStatus> resultCallback) {
        if (conversationType == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "Conversation parameter is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (!conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.74
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.getConversationNotificationStatus(conversationType.getValue(), str, new ILongCallback.Stub() { // from class: io.rong.imlib.RongIMClient.74.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onComplete(long j) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onCallback(Conversation.ConversationNotificationStatus.setValue((int) j));
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getConversationNotificationStatus", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "Not support ChatRoom ConversationType!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public ConnectionStatusListener.ConnectionStatus getCurrentConnectionStatus() {
        return this.mConnectionStatus;
    }

    public String getCurrentUserId() {
        try {
            if (TextUtils.isEmpty(SingletonHolder.sInstance.mCurrentUserId) && this.mLibHandler != null) {
                SingletonHolder.sInstance.mCurrentUserId = this.mLibHandler.getCurrentUserId();
            }
        } catch (Exception e2) {
            RLog.e(TAG, "getCurrentUserId", e2);
        }
        if (SingletonHolder.sInstance.mCurrentUserId == null) {
            RLog.w(TAG, "ipc process does not created");
            Context context = this.mContext;
            if (context != null) {
                SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "Statistics", 0);
                SingletonHolder.sInstance.mCurrentUserId = sharedPreferences.getString("userId", "");
            } else {
                SingletonHolder.sInstance.mCurrentUserId = null;
            }
        }
        return SingletonHolder.sInstance.mCurrentUserId;
    }

    public long getDeltaTime() {
        try {
            if (this.mLibHandler == null) {
                return 0L;
            }
            return this.mLibHandler.getDeltaTime();
        } catch (Exception e2) {
            RLog.e(TAG, "getDeltaTime", e2);
            return 0L;
        }
    }

    public void getDiscussion(final String str, ResultCallback<Discussion> resultCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.47
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.getDiscussion(str, new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.47.1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                    if (ipcCallbackProxy.callback != 0) {
                                        if (remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof Discussion)) {
                                            ((ResultCallback) ipcCallbackProxy.callback).onCallback(null);
                                        } else {
                                            ((ResultCallback) ipcCallbackProxy.callback).onCallback((Discussion) remoteModelWrap.getContent());
                                        }
                                        ipcCallbackProxy.callback = null;
                                    }
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onFailure(int i) throws RemoteException {
                                    T t = ipcCallbackProxy.callback;
                                    if (t != 0) {
                                        ((ResultCallback) t).onFail(ErrorCode.valueOf(i));
                                        ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "getDiscussion", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "the discussionId can't be empty!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public int getEncryptedSessionStatus(String str) {
        try {
            RCEncryptedSession encryptedConversation = this.mLibHandler.getEncryptedConversation(str);
            if (encryptedConversation != null) {
                return encryptedConversation.getEncStatus();
            }
            RLog.w(TAG, "can not find encCoversation by targetId of " + str + " while calling getEncryptedSessionStatus()");
            return -1;
        } catch (RemoteException e2) {
            RLog.e(TAG, "getEncryptedSessionStatus", e2);
            return -2;
        }
    }

    public int getGIFLimitSize() {
        IHandler iHandler = this.mLibHandler;
        if (iHandler == null) {
            return -1;
        }
        try {
            return iHandler.getGIFLimitSize();
        } catch (RemoteException e2) {
            RLog.e(TAG, "getVideoLimitTime", e2);
            return -1;
        }
    }

    @Deprecated
    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, int i, int i2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ResultCallback.Result result = new ResultCallback.Result();
        getHistoryMessages(conversationType, str, i, i2, new SyncCallback<List<Message>>() { // from class: io.rong.imlib.RongIMClient.24
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                countDownLatch.countDown();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                result.t = list;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            RLog.e(TAG, "getHistoryMessages", e2);
            Thread.currentThread().interrupt();
        }
        return (List) result.t;
    }

    public void getLatestMessages(final Conversation.ConversationType conversationType, final String str, final int i, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.23
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        List<Message> newestMessages = RongIMClient.this.mLibHandler.getNewestMessages(conversation, i);
                        if (resultCallback != null) {
                            resultCallback.onCallback(newestMessages);
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getLatestMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getMessage(final int i, final ResultCallback<Message> resultCallback) {
        if (i > 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.53
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        Message message = RongIMClient.this.mLibHandler.getMessage(i);
                        if (resultCallback != null) {
                            resultCallback.onCallback(message);
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getMessage", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "Illegal argument of messageId.");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getMessageByUid(final String str, final ResultCallback<Message> resultCallback) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "getMessageByUid uid is empty!");
        } else {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.113
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        if (resultCallback != null) {
                            resultCallback.onCallback(RongIMClient.this.mLibHandler.getMessageByUid(str));
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getMessageByUid", e2);
                    }
                }
            });
        }
    }

    public void getMessageCount(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Integer> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.22
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        int messageCount = RongIMClient.this.mLibHandler.getMessageCount(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Integer.valueOf(messageCount));
                        }
                    } catch (Exception unused) {
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "TargetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getNotificationQuietHours(GetNotificationQuietHoursCallback getNotificationQuietHoursCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(getNotificationQuietHoursCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.97
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((GetNotificationQuietHoursCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.getNotificationQuietHours(new IGetNotificationQuietHoursCallback.Stub() { // from class: io.rong.imlib.RongIMClient.97.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
                        public void onError(int i) {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((GetNotificationQuietHoursCallback) t2).onFail(ErrorCode.valueOf(i));
                                ipcCallbackProxy.callback = null;
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
                        public void onSuccess(String str, int i) {
                            T t2 = ipcCallbackProxy.callback;
                            if (t2 != 0) {
                                ((GetNotificationQuietHoursCallback) t2).onCallback(str, i);
                                ipcCallbackProxy.callback = null;
                            }
                        }
                    });
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getNotificationQuietHours", e2);
                    T t2 = ipcCallbackProxy.callback;
                    if (t2 != 0) {
                        ((GetNotificationQuietHoursCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            }
        });
    }

    public void getOfflineMessageDuration(final ResultCallback<String> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.133
            @Override // java.lang.Runnable
            public void run() {
                String offlineMessageDuration;
                try {
                    offlineMessageDuration = RongIMClient.this.mLibHandler.getOfflineMessageDuration();
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "getOfflineMessageDuration", e2);
                    offlineMessageDuration = "";
                }
                if (offlineMessageDuration == null) {
                    resultCallback.onFail(ErrorCode.UNKNOWN);
                } else {
                    resultCallback.onCallback(offlineMessageDuration);
                }
            }
        });
    }

    public void getPublicServiceList(ResultCallback<PublicServiceProfileList> resultCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.92
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler != null) {
                    try {
                        RongIMClient.this.mLibHandler.getPublicServiceList(new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.92.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                if (ipcCallbackProxy.callback != 0) {
                                    ((ResultCallback) ipcCallbackProxy.callback).onCallback((PublicServiceProfileList) remoteModelWrap.getContent());
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((ResultCallback) t).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                        return;
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getPublicServiceList", e2);
                        return;
                    }
                }
                T t = ipcCallbackProxy.callback;
                if (t != 0) {
                    ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            }
        });
    }

    public void getPublicServiceProfile(final Conversation.PublicServiceType publicServiceType, final String str, ResultCallback<PublicServiceProfile> resultCallback) {
        if (publicServiceType != null && !TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.91
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.getPublicServiceProfile(str, publicServiceType.getValue(), new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.91.1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                    if (ipcCallbackProxy.callback != 0) {
                                        ((ResultCallback) ipcCallbackProxy.callback).onCallback(remoteModelWrap != null ? (PublicServiceProfile) remoteModelWrap.getContent() : null);
                                        ipcCallbackProxy.callback = null;
                                    }
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onFailure(int i) throws RemoteException {
                                    T t = ipcCallbackProxy.callback;
                                    if (t != 0) {
                                        ((ResultCallback) t).onFail(ErrorCode.valueOf(i));
                                        ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "getPublicServiceProfile", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "Parameter  is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getPushContentShowStatus(final ResultCallback<Boolean> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.131
            @Override // java.lang.Runnable
            public void run() {
                String pushSetting = "";
                try {
                    if (RongIMClient.this.mLibHandler != null) {
                        pushSetting = RongIMClient.this.mLibHandler.getPushSetting(PushSettings.PUSH_SETTINGS_SHOW_CONTENT.getValue());
                    } else {
                        resultCallback.onError(ErrorCode.IPC_DISCONNECT);
                        RLog.e(RongIMClient.TAG, "getPushContentShowStatus: mLibHandler is null.");
                    }
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "getPushContentShowStatus", e2);
                }
                if (pushSetting == null) {
                    resultCallback.onFail(ErrorCode.UNKNOWN);
                } else {
                    resultCallback.onCallback(Boolean.valueOf(pushSetting.equals(PushStatus.STATUS_ON.getValue())));
                }
            }
        });
    }

    public void getPushLanguage(final ResultCallback<PushLanguage> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.130
            @Override // java.lang.Runnable
            public void run() {
                String pushSetting = "";
                try {
                    if (RongIMClient.this.mLibHandler != null) {
                        pushSetting = RongIMClient.this.mLibHandler.getPushSetting(PushSettings.PUSH_SETTINGS_LANGUAGE.getValue());
                    } else {
                        resultCallback.onError(ErrorCode.IPC_DISCONNECT);
                        RLog.e(RongIMClient.TAG, "getPushLanguage: mLibHandler is null.");
                    }
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "getPushLanguage", e2);
                }
                if (pushSetting == null) {
                    resultCallback.onFail(ErrorCode.UNKNOWN);
                    return;
                }
                if (pushSetting.equals(PushLanguage.EN_US.getMsg())) {
                    resultCallback.onCallback(PushLanguage.EN_US);
                } else if (pushSetting.equals(PushLanguage.AR_SA.getMsg())) {
                    resultCallback.onCallback(PushLanguage.AR_SA);
                } else {
                    resultCallback.onCallback(PushLanguage.ZH_CN);
                }
            }
        });
    }

    public void getPushReceiveStatus(final ResultCallback<Boolean> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.132
            @Override // java.lang.Runnable
            public void run() {
                String pushSetting;
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.PARAMETER_ERROR);
                        return;
                    }
                    return;
                }
                try {
                    pushSetting = RongIMClient.this.mLibHandler.getPushSetting(PushSettings.PUSH_SETTINGS_RECEIVE.getValue());
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "getPushReceiveStatus", e2);
                    pushSetting = "";
                }
                if (pushSetting == null) {
                    resultCallback.onFail(ErrorCode.UNKNOWN);
                } else {
                    resultCallback.onCallback(Boolean.valueOf(pushSetting.equals(PushStatus.STATUS_ON.getValue())));
                }
            }
        });
    }

    public RealTimeLocationConstant.RealTimeLocationErrorCode getRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        if (conversationType != null && str != null) {
            return RealTimeLocationConstant.RealTimeLocationErrorCode.valueOf(RealTimeLocationManager.getInstance().setupRealTimeLocation(conversationType, str));
        }
        RLog.e(TAG, "getRealTimeLocation Type or id is null!");
        return null;
    }

    public RealTimeLocationConstant.RealTimeLocationStatus getRealTimeLocationCurrentState(Conversation.ConversationType conversationType, String str) {
        if (conversationType != null && str != null) {
            return RealTimeLocationManager.getInstance().getRealTimeLocationCurrentState(conversationType, str);
        }
        RLog.e(TAG, "getRealTimeLocationCurrentState Type or id is null!");
        return RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE;
    }

    public List<String> getRealTimeLocationParticipants(Conversation.ConversationType conversationType, String str) {
        if (conversationType != null && str != null && RealTimeLocationManager.getInstance() != null) {
            return RealTimeLocationManager.getInstance().getRealTimeLocationParticipants(conversationType, str);
        }
        RLog.e(TAG, "getRealTimeLocationParticipants Type or id is null!");
        return null;
    }

    public void getRemoteHistoryMessages(final Conversation.ConversationType conversationType, final String str, final long j, final int i, ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.29
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        RongIMClient.this.mLibHandler.getRemoteHistoryMessages(conversation, j, i, new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.29.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                if (ipcCallbackProxy.callback != 0) {
                                    if (remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof RongListWrap)) {
                                        ((ResultCallback) ipcCallbackProxy.callback).onCallback(null);
                                    } else {
                                        ((ResultCallback) ipcCallbackProxy.callback).onCallback(((RongListWrap) remoteModelWrap.getContent()).getList());
                                    }
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i2) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(ErrorCode.valueOf(i2));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getRemoteHistoryMessages", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public long getSendTimeByMessageId(int i) {
        try {
            if (this.mLibHandler != null) {
                return this.mLibHandler.getSendTimeByMessageId(i);
            }
            RLog.e(TAG, "getSendTimeByMessageId mLibHandler is null!");
            return 0L;
        } catch (Exception e2) {
            RLog.e(TAG, "getSendTimeByMessageId", e2);
            return 0L;
        }
    }

    public void getTextMessageDraft(Conversation.ConversationType conversationType, String str, final ResultCallback<String> resultCallback) {
        final Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.44
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        String textMessageDraft = RongIMClient.this.mLibHandler.getTextMessageDraft(conversation);
                        if (resultCallback != null) {
                            resultCallback.onCallback(textMessageDraft);
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getTextMessageDraft", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the value of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getTheFirstUnreadMessage(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Message> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.137
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        Message theFirstUnreadMessage = RongIMClient.this.mLibHandler.getTheFirstUnreadMessage(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(theFirstUnreadMessage);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getTheFirstUnreadMessage", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "getConversation. the parameter of targetId or ConversationType is error!");
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getTopConversationList(final ResultCallback<List<Conversation>> resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.10
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                Conversation.ConversationType[] conversationTypeArr2 = conversationTypeArr;
                if (conversationTypeArr2 == null || conversationTypeArr2.length == 0) {
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.PARAMETER_ERROR);
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.getTopConversationList(RongIMClient.this.convertTypes(conversationTypeArr2), 10, RongIMClient.this.new GetConversationListProcessCallBackWrapper(resultCallback));
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getTopConversationList", e2);
                    ResultCallback resultCallback4 = resultCallback;
                    if (resultCallback4 != null) {
                        resultCallback4.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public Activity getTopForegroundActivity() {
        return this.topForegroundActivity;
    }

    public void getTotalUnreadCount(final ResultCallback<Integer> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.17
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                if (RongIMClient.this.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
                    RLog.d(RongIMClient.TAG, "getTotalUnreadCount return 0 as disconnected.");
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onCallback(0);
                        return;
                    }
                    return;
                }
                try {
                    int totalUnreadCount = RongIMClient.this.mLibHandler.getTotalUnreadCount();
                    if (resultCallback != null) {
                        resultCallback.onCallback(Integer.valueOf(totalUnreadCount));
                    }
                } catch (Exception unused) {
                    ResultCallback resultCallback4 = resultCallback;
                    if (resultCallback4 != null) {
                        resultCallback4.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public Collection<TypingStatus> getTypingUserListFromConversation(Conversation.ConversationType conversationType, String str) {
        return TypingMessageManager.getInstance().getTypingUserListFromConversation(conversationType, str);
    }

    public void getUnreadCount(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Integer> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.19
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        int unreadCountById = RongIMClient.this.mLibHandler.getUnreadCountById(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Integer.valueOf(unreadCountById));
                        }
                    } catch (Exception unused) {
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "TargetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getUnreadMentionedMessages(final Conversation.ConversationType conversationType, final String str, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.117
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        List<Message> unreadMentionedMessages = RongIMClient.this.mLibHandler.getUnreadMentionedMessages(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(unreadMentionedMessages);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getUnreadMentionedMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getVendorToken(ResultCallback<String> resultCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.128
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler != null) {
                    try {
                        RongIMClient.this.mLibHandler.getVendorToken(new IStringCallback.Stub() { // from class: io.rong.imlib.RongIMClient.128.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IStringCallback
                            public void onComplete(String str) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((ResultCallback) t).onCallback(str);
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IStringCallback
                            public void onFailure(int i) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((ResultCallback) t).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                        return;
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getVendorToken", e2);
                        return;
                    }
                }
                T t = ipcCallbackProxy.callback;
                if (t != 0) {
                    ((ResultCallback) t).onFail(ErrorCode.PARAMETER_ERROR);
                    ipcCallbackProxy.callback = null;
                }
            }
        });
    }

    public int getVideoLimitTime() {
        IHandler iHandler = this.mLibHandler;
        if (iHandler == null) {
            return -1;
        }
        try {
            return iHandler.getVideoLimitTime();
        } catch (RemoteException e2) {
            RLog.e(TAG, "getVideoLimitTime", e2);
            return -1;
        }
    }

    public void insertIncomingMessage(Conversation.ConversationType conversationType, String str, String str2, Message.ReceivedStatus receivedStatus, MessageContent messageContent, ResultCallback<Message> resultCallback) {
        insertIncomingMessage(conversationType, str, str2, receivedStatus, messageContent, System.currentTimeMillis(), resultCallback);
    }

    public void insertOutgoingMessage(Conversation.ConversationType conversationType, String str, Message.SentStatus sentStatus, MessageContent messageContent, ResultCallback<Message> resultCallback) {
        insertOutgoingMessage(conversationType, str, sentStatus, messageContent, System.currentTimeMillis(), resultCallback);
    }

    public void joinChatRoom(final String str, final int i, final OperationCallback operationCallback) {
        FwLog.write(3, 1, FwLog.LogTag.A_JOIN_CHATROOM_T.getTag(), "room_id|existed|count", str, false, Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.PARAMETER_ERROR.code), str);
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        } else {
            if (!TextUtils.isEmpty(this.mToken)) {
                final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
                this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.78
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatRoomActionListener chatRoomActionListener2 = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
                        if (chatRoomActionListener2 != null) {
                            chatRoomActionListener2.onJoining(str);
                        }
                        if (RongIMClient.this.mLibHandler == null) {
                            FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.IPC_DISCONNECT.code), str);
                            operationCallback.onFail(ErrorCode.IPC_DISCONNECT);
                            if (chatRoomActionListener2 != null) {
                                chatRoomActionListener2.onError(str, ErrorCode.IPC_DISCONNECT);
                                return;
                            }
                            return;
                        }
                        try {
                            RongIMClient.this.mLibHandler.joinChatRoom(str, i, RongIMClient.this.new JoinChatRoomCallback(ipcCallbackProxy, str, i, RongIMClient.this.mLibHandler.getJoinMultiChatRoomEnable(), false, false));
                        } catch (Exception e2) {
                            FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id|stacks", Integer.valueOf(ErrorCode.IPC_DISCONNECT.getValue()), str, FwLog.stackToString(e2));
                            operationCallback.onFail(ErrorCode.IPC_DISCONNECT);
                            if (chatRoomActionListener2 != null) {
                                chatRoomActionListener2.onError(str, ErrorCode.IPC_DISCONNECT);
                            }
                        }
                    }
                });
                return;
            }
            RLog.e(TAG, "joinChatRoom without connect!");
            FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.APP_NOT_CONNECT.code), str);
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.APP_NOT_CONNECT);
            }
        }
    }

    public void joinExistChatRoom(final String str, final int i, OperationCallback operationCallback) {
        FwLog.write(3, 1, FwLog.LogTag.A_JOIN_CHATROOM_T.getTag(), "room_id|existed|count", str, true, Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.PARAMETER_ERROR.code), str);
            RLog.e(TAG, "id is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.80
                @Override // java.lang.Runnable
                public void run() {
                    JoinChatRoomCallback joinChatRoomCallback = RongIMClient.this.new JoinChatRoomCallback(ipcCallbackProxy, str, i, false, true, false);
                    ChatRoomActionListener chatRoomActionListener2 = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
                    if (chatRoomActionListener2 != null) {
                        chatRoomActionListener2.onJoining(str);
                    }
                    if (RongIMClient.this.mLibHandler == null) {
                        joinChatRoomCallback.onFailure(ErrorCode.IPC_DISCONNECT.getValue());
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.joinExistChatRoom(str, i, RongIMClient.this.new JoinChatRoomCallback(ipcCallbackProxy, str, i, RongIMClient.this.mLibHandler.getJoinMultiChatRoomEnable(), true, false), false);
                    } catch (Exception e2) {
                        FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id|stacks", Integer.valueOf(ErrorCode.IPC_DISCONNECT.getValue()), str, FwLog.stackToString(e2));
                        RLog.e(RongIMClient.TAG, "joinExistChatRoom", e2);
                        joinChatRoomCallback.onFailure(ErrorCode.IPC_DISCONNECT.getValue());
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "joinExitChatRoom without connect!");
        FwLog.write(1, 1, FwLog.LogTag.A_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.APP_NOT_CONNECT.code), str);
        if (operationCallback != null) {
            operationCallback.onError(ErrorCode.APP_NOT_CONNECT);
        }
    }

    public RealTimeLocationConstant.RealTimeLocationErrorCode joinRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        if (conversationType != null && str != null) {
            return RealTimeLocationConstant.RealTimeLocationErrorCode.valueOf(RealTimeLocationManager.getInstance().joinRealTimeLocation(conversationType, str));
        }
        RLog.e(TAG, "joinRealTimeLocation Type or id is null!");
        return null;
    }

    public void leaveMessageCustomService(String str, Map<String, String> map, OperationCallback operationCallback) {
        CustomServiceManager.getInstance().leaveMessageToCustomService(str, map, operationCallback);
    }

    public void logout() {
        disconnect(false);
        this.imLibExtensionModuleManager.onLogout();
    }

    public void pauseDownloadMediaFile(final String str, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.73
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.pauseTransferMediaFile(str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "pauseDownloadMediaFile", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else if (operationCallback != null) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void pauseDownloadMediaMessage(final Message message, OperationCallback operationCallback) {
        if (message != null && message.getMessageId() > 0 && (message.getContent() instanceof MediaMessageContent) && ((MediaMessageContent) message.getContent()).getMediaUrl() != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.72
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.pauseTransferMediaMessage(message, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "pauseDownloadMediaMessage", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "cancelDownloadMediaMessage 参数异常。");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void quitChatRoom(final String str, OperationCallback operationCallback) {
        FwLog.write(3, 1, FwLog.LogTag.A_QUIT_CHATROOM_T.getTag(), "room_id", str);
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.81
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    RongIMClient.this.mChatRoomCache.remove(str);
                    Runnable runnable = (Runnable) RongIMClient.this.mRetryCRCache.remove(str);
                    if (runnable != null) {
                        RongIMClient.this.mWorkHandler.removeCallbacks(runnable);
                    }
                    ChatRoomActionListener chatRoomActionListener2 = (ChatRoomActionListener) RongIMClient.chatRoomActionListener.get();
                    if (chatRoomActionListener2 != null) {
                        chatRoomActionListener2.onQuited(str);
                    }
                    if (RongIMClient.this.mLibHandler == null) {
                        FwLog.write(1, 1, FwLog.LogTag.A_QUIT_CHATROOM_R.getTag(), "code|room_id", ErrorCode.IPC_DISCONNECT, str);
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.quitChatRoom(str, new DefaultOperationCallback(ipcCallbackProxy) { // from class: io.rong.imlib.RongIMClient.81.1
                            {
                                RongIMClient rongIMClient = RongIMClient.this;
                            }

                            @Override // io.rong.imlib.RongIMClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
                            public void onComplete() {
                                super.onComplete();
                                FwLog.write(3, 1, FwLog.LogTag.A_QUIT_CHATROOM_R.getTag(), "code|room_id", 0, str);
                            }

                            @Override // io.rong.imlib.RongIMClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
                            public void onFailure(int i) {
                                super.onFailure(i);
                                FwLog.write(1, 1, FwLog.LogTag.A_QUIT_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(i), str);
                            }
                        });
                    } catch (Exception e2) {
                        FwLog.write(1, 1, FwLog.LogTag.A_QUIT_CHATROOM_R.getTag(), "code|room_id|stacks", -1000, str, FwLog.stackToString(e2));
                        RLog.e(RongIMClient.TAG, "quitChatRoom", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
            return;
        }
        FwLog.write(1, 1, FwLog.LogTag.A_QUIT_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(ErrorCode.PARAMETER_ERROR.code), str);
        RLog.e(TAG, "id is null!");
        if (operationCallback != null) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void quitDiscussion(final String str, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.52
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.quitDiscussion(str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "quitDiscussion", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "discussionId is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void quitEncryptedSession(final String str) {
        if (str == null) {
            RLog.e(TAG, "quitEncryptedSession targetId is null! ");
            return;
        }
        try {
            String[] strArrSplit = str.split(";;;");
            if (strArrSplit.length != 2) {
                RLog.e(TAG, "quitEncrypteSession error while parsing the targetId -> " + str);
                return;
            }
            if (this.mLibHandler == null) {
                return;
            }
            final RCEncryptedSession encryptedConversation = this.mLibHandler.getEncryptedConversation(str);
            if (encryptedConversation == null) {
                RLog.w(TAG, "getEncryptedConversation returns null on call of quitEncryptedSession.");
                return;
            }
            encryptedConversation.setEncStatus(5);
            String remoteEncId = encryptedConversation.getRemoteEncId();
            if (remoteEncId == null) {
                RLog.e(TAG, "removeEncId from encrypted conversaion is null! ");
                return;
            }
            RCEncryptTerminateMessage rCEncryptTerminateMessage = new RCEncryptTerminateMessage();
            rCEncryptTerminateMessage.setSenderEncId(strArrSplit[0]);
            rCEncryptTerminateMessage.setReceiverEncId(remoteEncId);
            sendMessage(Conversation.ConversationType.PRIVATE, strArrSplit[1], rCEncryptTerminateMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.141
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, ErrorCode errorCode) {
                    RLog.w(RongIMClient.TAG, "terminateMessage send failed ,error occurs with error code : " + errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                    try {
                        if (RongIMClient.this.mLibHandler != null && RongIMClient.this.mLibHandler.setEncryptedConversation(str, encryptedConversation) && RongIMClient.this.mLibHandler.removeEncryptedConversation(str)) {
                            RLog.d(RongIMClient.TAG, "send terminateMsg successfully,remove encConversation of ->" + str);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "quitEncryptedSession", e2);
                    }
                }
            });
        } catch (RemoteException e2) {
            RLog.e(TAG, "quitEncryptedSession", e2);
        }
    }

    public void quitRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        if (conversationType == null || str == null) {
            RLog.e(TAG, "quitRealTimeLocation Type or id is null!");
        } else {
            RealTimeLocationManager.getInstance().quitRealTimeLocation(conversationType, str);
        }
    }

    public void recallMessage(Message message, final String str, final ResultCallback<RecallNotificationMessage> resultCallback) {
        if (this.mLibHandler != null) {
            getMessage(message.getMessageId(), new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.116
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(ErrorCode errorCode) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onError(errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(final Message message2) {
                    String strValue = ((MessageTag) RecallCommandMessage.class.getAnnotation(MessageTag.class)).value();
                    if (message2 == null) {
                        RLog.e(RongIMClient.TAG, "recallMessage message is null");
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onError(ErrorCode.PARAMETER_ERROR);
                            return;
                        }
                        return;
                    }
                    MessageConfig messageConfig = message2.getMessageConfig();
                    boolean zIsDisableNotification = messageConfig != null ? messageConfig.isDisableNotification() : false;
                    final RecallCommandMessage recallCommandMessage = new RecallCommandMessage(message2.getUId());
                    recallCommandMessage.setConversationType(message2.getConversationType().getValue());
                    recallCommandMessage.setTargetId(message2.getTargetId());
                    recallCommandMessage.setSentTime(message2.getSentTime());
                    recallCommandMessage.setUserInfo(message2.getContent().getUserInfo());
                    try {
                        RongIMClient.this.mLibHandler.recallMessage(strValue, recallCommandMessage.encode(), str, 0, message2.getTargetId(), message2.getConversationType().getValue(), zIsDisableNotification, new IOperationCallback.Stub() { // from class: io.rong.imlib.RongIMClient.116.1
                            @Override // io.rong.imlib.IOperationCallback
                            public void onComplete() throws RemoteException {
                                RecallNotificationMessage recallNotificationMessage = new RecallNotificationMessage(RongIMClient.this.getCurrentUserId(), message2.getSentTime(), message2.getObjectName(), recallCommandMessage.isAdmin(), recallCommandMessage.isDelete());
                                MessageContent content = message2.getContent();
                                if (content instanceof TextMessage) {
                                    recallNotificationMessage.setRecallContent(((TextMessage) content).getContent());
                                    recallNotificationMessage.setRecallActionTime(System.currentTimeMillis());
                                }
                                recallNotificationMessage.setUserInfo(recallCommandMessage.getUserInfo());
                                try {
                                    RongIMClient.this.mLibHandler.setMessageContent(message2.getMessageId(), recallNotificationMessage.encode(), ((MessageTag) RecallNotificationMessage.class.getAnnotation(MessageTag.class)).value());
                                    if (resultCallback != null) {
                                        resultCallback.onCallback(recallNotificationMessage);
                                    }
                                } catch (RemoteException e2) {
                                    RLog.e(RongIMClient.TAG, "recallMessage", e2);
                                    ResultCallback resultCallback3 = resultCallback;
                                    if (resultCallback3 != null) {
                                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                                    }
                                }
                            }

                            @Override // io.rong.imlib.IOperationCallback
                            public void onFailure(int i) throws RemoteException {
                                ResultCallback resultCallback3 = resultCallback;
                                if (resultCallback3 != null) {
                                    resultCallback3.onFail(ErrorCode.valueOf(i));
                                }
                            }
                        });
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "recallMessage", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onError(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "recallMessage IPC 进程尚未运行。");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.IPC_DISCONNECT);
        }
    }

    public void removeChatRoomEntry(final String str, final String str2, final Boolean bool, final String str3, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.147
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.deleteChatRoomEntry(str2, null, str, bool.booleanValue(), str3, false, false, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "removeChatRoomEntry", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "removeChatRoomEntry chatRoomId or key is empty!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void removeConversation(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Boolean> resultCallback) {
        if (TextUtils.isEmpty(str) || conversationType == null) {
            RLog.e(TAG, "getConversation. the parameter of targetId or ConversationType is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (str.length() > 64) {
            RLog.e(TAG, "TargetId length exceed the limit!");
        }
        if (conversationType == Conversation.ConversationType.ENCRYPTED) {
            quitEncryptedSession(str);
        }
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.15
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    boolean zRemoveConversation = RongIMClient.this.mLibHandler.removeConversation(conversationType.getValue(), str);
                    if (resultCallback != null) {
                        resultCallback.onCallback(Boolean.valueOf(zRemoveConversation));
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "removeConversation", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void removeFromBlacklist(final String str, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.84
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.removeFromBlacklist(str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "removeFromBlacklist", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "userId  is null!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void removeMemberFromDiscussion(final String str, final String str2, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.51
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.removeDiscussionMember(str, str2, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "removeMemberFromDiscussion", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "discussionId or userId is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void removeMessageExpansion(final List<String> list, final String str, OperationCallback operationCallback) {
        if (judgeListInvalid(list, operationCallback) || judgeUIDInvalid(str, operationCallback)) {
            return;
        }
        if (list != null && list.size() != 0) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.152
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.removeMessageExpansion(list, str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "removeMessageExpansion", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else if (operationCallback != null) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void removeNotificationQuietHours(OperationCallback operationCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.94
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.removeNotificationQuietHours(RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "removeNotificationQuietHours", e2);
                    T t2 = ipcCallbackProxy.callback;
                    if (t2 != 0) {
                        ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            }
        });
    }

    public void removeRealTimeLocationObserver(Conversation.ConversationType conversationType, String str) {
        if (conversationType == null || str == null) {
            RLog.e(TAG, "removeRealTimeLocationObserver Type or id is null!");
        } else {
            RealTimeLocationManager.getInstance().removeListener(conversationType, str);
        }
    }

    public void saveTextMessageDraft(Conversation.ConversationType conversationType, String str, final String str2, final ResultCallback<Boolean> resultCallback) {
        final Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.45
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zSaveTextMessageDraft = RongIMClient.this.mLibHandler.saveTextMessageDraft(conversation, str2);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zSaveTextMessageDraft));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "saveTextMessageDraft", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the value of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void searchConversations(final String str, final Conversation.ConversationType[] conversationTypeArr, final String[] strArr, final ResultCallback<List<SearchConversationResult>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationTypeArr != null && conversationTypeArr.length != 0 && strArr != null && strArr.length != 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.124
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.PARAMETER_ERROR);
                            return;
                        }
                        return;
                    }
                    try {
                        List<SearchConversationResult> listSearchConversations = RongIMClient.this.mLibHandler.searchConversations(str, RongIMClient.this.convertTypes(conversationTypeArr), strArr);
                        if (resultCallback != null) {
                            resultCallback.onCallback(listSearchConversations);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "searchConversations", e2);
                    }
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void searchMessages(final Conversation.ConversationType conversationType, final String str, final String str2, final int i, final long j, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.125
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.PARAMETER_ERROR);
                            return;
                        }
                        return;
                    }
                    try {
                        List<Message> listSearchMessages = RongIMClient.this.mLibHandler.searchMessages(str, conversationType.getValue(), str2, i, j);
                        if (resultCallback != null) {
                            resultCallback.onCallback(listSearchMessages);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "searchMessages", e2);
                    }
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void searchMessagesByUser(final Conversation.ConversationType conversationType, final String str, final String str2, int i, final long j, final ResultCallback<List<Message>> resultCallback) {
        final int i2;
        if (i <= 0 || conversationType == null) {
            RLog.e(TAG, "searchMessagesByUser : count count <= 0 or conversationType is null !");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (i > 100) {
            RLog.i(TAG, "searchMessagesByUser : count > 100.");
            i2 = 100;
        } else {
            i2 = i;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.126
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.PARAMETER_ERROR);
                            return;
                        }
                        return;
                    }
                    try {
                        List<Message> listSearchMessagesByUser = RongIMClient.this.mLibHandler.searchMessagesByUser(str, conversationType.getValue(), str2, i2, j);
                        if (resultCallback != null) {
                            resultCallback.onCallback(listSearchMessagesByUser);
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "searchMessagesByUser", e2);
                    }
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void searchPublicService(final SearchType searchType, final String str, ResultCallback<PublicServiceProfileList> resultCallback) {
        if (searchType != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.87
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.searchPublicService(str, 0, searchType.getValue(), new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.87.1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                    if (ipcCallbackProxy.callback == 0 || remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof PublicServiceProfileList)) {
                                        return;
                                    }
                                    ((ResultCallback) ipcCallbackProxy.callback).onCallback((PublicServiceProfileList) remoteModelWrap.getContent());
                                    ipcCallbackProxy.callback = null;
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // io.rong.imlib.IResultCallback
                                public void onFailure(int i) throws RemoteException {
                                    T t = ipcCallbackProxy.callback;
                                    if (t != 0) {
                                        ((ResultCallback) t).onFail(i);
                                        ipcCallbackProxy.callback = null;
                                    }
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "searchPublicService", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "searchType  is null!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void searchPublicServiceByType(Conversation.PublicServiceType publicServiceType, final SearchType searchType, final String str, ResultCallback<PublicServiceProfileList> resultCallback) {
        if (publicServiceType == null || searchType == null) {
            RLog.e(TAG, "searchType  is null!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        final int[] iArr = {0};
        if (publicServiceType == Conversation.PublicServiceType.APP_PUBLIC_SERVICE) {
            iArr[0] = 2;
        } else if (publicServiceType == Conversation.PublicServiceType.PUBLIC_SERVICE) {
            iArr[0] = 1;
        }
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.88
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler != null) {
                    try {
                        RongIMClient.this.mLibHandler.searchPublicService(str, iArr[0], searchType.getValue(), new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.88.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                if (ipcCallbackProxy.callback == 0 || remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof PublicServiceProfileList)) {
                                    return;
                                }
                                ((ResultCallback) ipcCallbackProxy.callback).onCallback((PublicServiceProfileList) remoteModelWrap.getContent());
                                ipcCallbackProxy.callback = null;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((ResultCallback) t).onFail(i);
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                        return;
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "searchPublicServiceByType", e2);
                        return;
                    }
                }
                T t = ipcCallbackProxy.callback;
                if (t != 0) {
                    ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            }
        });
    }

    public void selectCustomServiceGroup(String str, String str2) {
        sendChangeModelMessage(str, str2);
    }

    public void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (iSendMediaMessageCallback != null) {
                iSendMediaMessageCallback.onError(message, errorCodeFilterSendMessage);
                return;
            }
            return;
        }
        MediaMessageContent mediaMessageContent = (MediaMessageContent) message.getContent();
        if (mediaMessageContent.getMediaUrl() != null) {
            sendMessage(message, str, str2, iSendMediaMessageCallback);
            return;
        }
        if (mediaMessageContent.getLocalPath() == null) {
            RLog.e(TAG, "Media file does not exist!");
            if (iSendMediaMessageCallback != null) {
                iSendMediaMessageCallback.onError(message, ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        String string = mediaMessageContent.getLocalPath().toString();
        String strSubstring = string.substring(7);
        if (string.startsWith(LibStorageUtils.FILE) && new File(strSubstring).exists()) {
            this.mWorkHandler.post(new AnonymousClass119(new IpcCallbackProxy(iSendMediaMessageCallback), message, strArr, str, str2));
            return;
        }
        RLog.e(TAG, string + " does not exist!");
        if (iSendMediaMessageCallback != null) {
            iSendMediaMessageCallback.onError(message, ErrorCode.PARAMETER_ERROR);
        }
    }

    public void sendDirectionalMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String[] strArr, String str2, String str3, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageObtain = Message.obtain(str, conversationType, messageContent);
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(messageObtain);
        if (errorCodeFilterSendMessage != null) {
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(messageObtain, errorCodeFilterSendMessage);
            }
        } else {
            if (((MessageTag) messageContent.getClass().getAnnotation(MessageTag.class)) == null) {
                RLog.e(TAG, "sendDirectionalMessage 自定义消息没有加注解信息。");
                if (iSendMessageCallback != null) {
                    iSendMessageCallback.onError(messageObtain, ErrorCode.PARAMETER_ERROR);
                    return;
                }
                return;
            }
            if (TypingMessageManager.getInstance().isShowMessageTyping() && !(messageContent instanceof TypingStatusMessage) && !(messageContent instanceof ReadReceiptMessage)) {
                TypingMessageManager.getInstance().setTypingEnd(messageObtain.getConversationType(), messageObtain.getTargetId());
            }
            this.mWorkHandler.post(new AnonymousClass59(new IpcCallbackProxy(iSendMessageCallback), messageObtain, str2, str3, strArr));
        }
    }

    public void sendImageMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String str2, String str3, SendImageMessageCallback sendImageMessageCallback) {
        Message messageObtain = Message.obtain(str, conversationType, messageContent);
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(messageObtain);
        if (errorCodeFilterSendMessage == null) {
            sendImageMessage(messageObtain, str2, str3, sendImageMessageCallback);
        } else if (sendImageMessageCallback != null) {
            sendImageMessageCallback.onError(errorCodeFilterSendMessage);
        }
    }

    public void sendLocationMessage(Message message, String str, String str2, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null || !(message.getContent() instanceof LocationMessage)) {
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(message, errorCodeFilterSendMessage);
            }
        } else {
            if (TypingMessageManager.getInstance().isShowMessageTyping()) {
                TypingMessageManager.getInstance().setTypingEnd(message.getConversationType(), message.getTargetId());
            }
            this.mWorkHandler.post(new AnonymousClass57(new IpcCallbackProxy(iSendMessageCallback), message, str, str2));
        }
    }

    public void sendMediaMessage(Message message, String str, String str2, IRongCallback.ISendMediaMessageCallback iSendMediaMessageCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (iSendMediaMessageCallback != null) {
                iSendMediaMessageCallback.onError(message, errorCodeFilterSendMessage);
                return;
            }
            return;
        }
        MediaMessageContent mediaMessageContent = (MediaMessageContent) message.getContent();
        if (mediaMessageContent.getMediaUrl() != null) {
            sendMessage(message, str, str2, iSendMediaMessageCallback);
            return;
        }
        if (FileUtils.isFileExistsWithUri(this.mContext, mediaMessageContent.getLocalPath())) {
            this.mWorkHandler.post(new AnonymousClass118(new IpcCallbackProxy(iSendMediaMessageCallback), message, str, str2));
        } else {
            RLog.e(TAG, "localPath does not exist!");
            if (iSendMediaMessageCallback != null) {
                iSendMediaMessageCallback.onError(message, ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void sendMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String str2, String str3, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        sendMessage(Message.obtain(str, conversationType, messageContent), str2, str3, iSendMessageCallback);
    }

    public void sendPing() {
        RLog.d(TAG, "sendPing  ");
        if (isPushEnabled) {
            RongPushClient.sendPushPing(this.mContext);
        }
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.150
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    RLog.e(RongIMClient.TAG, "mLibHandler is null");
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.sendPing();
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "sendPing", e2);
                }
            }
        });
    }

    public void sendReadReceiptMessage(Conversation.ConversationType conversationType, String str, long j) {
        if (conversationType != Conversation.ConversationType.PRIVATE && conversationType != Conversation.ConversationType.ENCRYPTED) {
            RLog.e(TAG, "sendReadReceiptMessage conversationType only support PRIVATE and ENCRYPTED");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "sendReadReceiptMessage targetId is empty");
        } else if (j <= 0) {
            RLog.e(TAG, "sendReadReceiptMessage timestamp is error");
        } else {
            sendMessage(conversationType, str, new ReadReceiptMessage(j), null, null, null);
        }
    }

    public void sendReadReceiptRequest(final Message message, final OperationCallback operationCallback) {
        if (message == null) {
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        } else if (Conversation.ConversationType.GROUP.equals(message.getConversationType()) || Conversation.ConversationType.DISCUSSION.equals(message.getConversationType())) {
            sendMessage(message.getConversationType(), message.getTargetId(), new ReadReceiptRequestMessage(message.getUId()), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.121
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message2) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message2, ErrorCode errorCode) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onError(errorCode);
                    }
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message2) {
                    if (RongIMClient.this.mLibHandler == null) {
                        RLog.d(RongIMClient.TAG, "sendReadReceiptRequest mLibHandler is null");
                        OperationCallback operationCallback2 = operationCallback;
                        if (operationCallback2 != null) {
                            operationCallback2.onError(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        ReadReceiptInfo readReceiptInfo = message.getReadReceiptInfo();
                        if (readReceiptInfo == null) {
                            readReceiptInfo = new ReadReceiptInfo();
                            message.setReadReceiptInfo(readReceiptInfo);
                        }
                        readReceiptInfo.setIsReadReceiptMessage(true);
                        RongIMClient.this.mLibHandler.updateReadReceiptRequestInfo(message.getUId(), readReceiptInfo.toJSON().toString());
                        OperationCallback operationCallback3 = operationCallback;
                        if (operationCallback3 != null) {
                            operationCallback3.onSuccess();
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "sendReadReceiptRequest", e2);
                        OperationCallback operationCallback4 = operationCallback;
                        if (operationCallback4 != null) {
                            operationCallback4.onError(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.w(TAG, "only group and discussion could send read receipt request.");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void sendReadReceiptResponse(Conversation.ConversationType conversationType, String str, final List<Message> list, final OperationCallback operationCallback) {
        if ((!Conversation.ConversationType.GROUP.equals(conversationType) && !Conversation.ConversationType.DISCUSSION.equals(conversationType)) || list == null || list.size() == 0) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            return;
        }
        ReadReceiptResponseMessage readReceiptResponseMessage = new ReadReceiptResponseMessage(list);
        sendDirectionalMessage(conversationType, str, readReceiptResponseMessage, (String[]) readReceiptResponseMessage.getSenderIdSet().toArray(new String[readReceiptResponseMessage.getSenderIdSet().size()]), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.122
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                if (RongIMClient.this.mLibHandler != null) {
                    RongIMClient.this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.122.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                for (Message message2 : list) {
                                    ReadReceiptInfo readReceiptInfo = message2.getReadReceiptInfo();
                                    if (readReceiptInfo == null) {
                                        readReceiptInfo = new ReadReceiptInfo();
                                        message2.setReadReceiptInfo(readReceiptInfo);
                                    }
                                    readReceiptInfo.setHasRespond(true);
                                    RongIMClient.this.mLibHandler.updateReadReceiptRequestInfo(message2.getUId(), readReceiptInfo.toJSON().toString());
                                }
                                OperationCallback operationCallback2 = operationCallback;
                                if (operationCallback2 != null) {
                                    operationCallback2.onCallback();
                                }
                            } catch (RemoteException e2) {
                                RLog.e(RongIMClient.TAG, "sendReadReceiptResponse", e2);
                                OperationCallback operationCallback3 = operationCallback;
                                if (operationCallback3 != null) {
                                    operationCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                                }
                            }
                        }
                    });
                    return;
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(ErrorCode.IPC_DISCONNECT);
                }
            }
        });
    }

    public void sendTypingStatus(Conversation.ConversationType conversationType, String str, String str2) {
        TypingMessageManager.getInstance().sendTypingMessage(conversationType, str, str2);
    }

    public void setAppVer(String str) {
        FwLog.write(3, 1, FwLog.LogTag.A_APP_VER_S.getTag(), "ver", str);
    }

    public void setChatRoomEntry(final String str, final String str2, final String str3, final boolean z, final boolean z2, final String str4, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && str2.matches("^[A-Za-z0-9+_=-]+$")) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.143
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.setChatRoomEntry(str2, str3, str, z, str4, z2, false, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "setChatRoomEntry", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "setChatRoomEntry chatRoomId or key or value is empty or key contains illegal characters!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void setConversationNotificationStatus(final Conversation.ConversationType conversationType, final String str, final Conversation.ConversationNotificationStatus conversationNotificationStatus, ResultCallback<Conversation.ConversationNotificationStatus> resultCallback) {
        if (TextUtils.isEmpty(str) || conversationType == null || conversationNotificationStatus == null) {
            RLog.e(TAG, "Conversation parameter is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (!conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.75
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.setConversationNotificationStatus(conversationType.getValue(), str, conversationNotificationStatus.getValue(), new ILongCallback.Stub() { // from class: io.rong.imlib.RongIMClient.75.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onComplete(long j) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onCallback(Conversation.ConversationNotificationStatus.setValue((int) j));
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setConversationNotificationStatus", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "Not support ChatRoom ConversationType!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void setConversationStatusListener(ConversationStatusListener conversationStatusListener) {
        sConversationStatusListener = conversationStatusListener;
    }

    public void setConversationToTop(Conversation.ConversationType conversationType, String str, boolean z, ResultCallback<Boolean> resultCallback) {
        setConversationToTop(conversationType, str, z, true, resultCallback);
    }

    public void setCustomServiceHumanEvaluateListener(CustomServiceManager.OnHumanEvaluateListener onHumanEvaluateListener) {
        CustomServiceManager.getInstance().setHumanEvaluateListener(onHumanEvaluateListener);
    }

    public void setDiscussionInviteStatus(final String str, final DiscussionInviteStatus discussionInviteStatus, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && discussionInviteStatus != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.76
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.setDiscussionInviteStatus(str, discussionInviteStatus.getValue(), RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setDiscussionInviteStatus", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "Parameter is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void setDiscussionName(final String str, final String str2, OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.48
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        String strSubstring = str2;
                        if (!TextUtils.isEmpty(str2) && str2.length() > 40) {
                            strSubstring = str2.substring(0, 39);
                        }
                        RongIMClient.this.mLibHandler.setDiscussionName(str, strSubstring, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setDiscussionName", e2);
                    }
                }
            });
        } else {
            RLog.e(TAG, "discussionId or name is null");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void setEncryptedSessionConnectionListener(EncryptedSessionConnectionListener encryptedSessionConnectionListener) {
        this.mEncSessionConListener = encryptedSessionConnectionListener;
    }

    public void setKVStatusListener(KVStatusListener kVStatusListener) {
        sKVStatusListener = kVStatusListener;
    }

    public void setMessageExpansionListener(MessageExpansionListener messageExpansionListener2) {
        messageExpansionListener = messageExpansionListener2;
    }

    public void setMessageExtra(final int i, final String str, final ResultCallback<Boolean> resultCallback) {
        if (i != 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.41
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean messageExtra = RongIMClient.this.mLibHandler.setMessageExtra(i, str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(messageExtra));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setMessageExtra", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "messageId is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void setMessageReadTime(final long j, final long j2, final OperationCallback operationCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.139
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onError(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    boolean messageReadTime = RongIMClient.this.mLibHandler.setMessageReadTime(j, j2);
                    if (operationCallback != null) {
                        if (messageReadTime) {
                            operationCallback.onCallback();
                        } else {
                            operationCallback.onError(ErrorCode.UNKNOWN);
                        }
                    }
                } catch (RemoteException e2) {
                    RLog.e(RongIMClient.TAG, "setMessageReadTime", e2);
                    OperationCallback operationCallback3 = operationCallback;
                    if (operationCallback3 != null) {
                        operationCallback3.onError(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void setMessageReceivedStatus(final int i, final Message.ReceivedStatus receivedStatus, final ResultCallback<Boolean> resultCallback) {
        if (i != 0 && receivedStatus != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.42
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean messageReceivedStatus = RongIMClient.this.mLibHandler.setMessageReceivedStatus(i, receivedStatus.getFlag());
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(messageReceivedStatus));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setMessageReceivedStatus", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "Error.messageid is 0 or receivedStatus is null !");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void setMessageSentStatus(final Message message, final ResultCallback<Boolean> resultCallback) {
        if (message != null && message.getMessageId() > 0 && message.getSentStatus() != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.43
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean messageSentStatus = RongIMClient.this.mLibHandler.setMessageSentStatus(message.getMessageId(), message.getSentStatus().getValue());
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(messageSentStatus));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setMessageSentStatus", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "setMessageSentStatus Error. message or the sentStatus of message cant't be null , messageId can't <= 0!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void setNotificationQuietHours(final String str, final int i, OperationCallback operationCallback) {
        if (TextUtils.isEmpty(str) || i <= 0 || i >= 1440) {
            RLog.e(TAG, "startTime, spanMinutes 或 spanMinutes 参数异常。");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (Pattern.compile("^(([0-1][0-9])|2[0-3]):[0-5][0-9]:([0-5][0-9])$").matcher(str).find()) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.93
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.setNotificationQuietHours(str, i, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setNotificationQuietHours", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((OperationCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "startTime 参数异常。");
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void setOfflineMessageDuration(final int i, ResultCallback<Long> resultCallback) {
        if (i >= 1 && i <= 7) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.134
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    try {
                        RongIMClient.this.mLibHandler.setOfflineMessageDuration(String.valueOf(i), new ILongCallback.Stub() { // from class: io.rong.imlib.RongIMClient.134.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onComplete(long j) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onCallback(Long.valueOf(j));
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.ILongCallback
                            public void onFailure(int i2) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(ErrorCode.valueOf(i2));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "setOfflineMessageDuration", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "Parameter is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void setOnReceiveDestructionMessageListener(OnReceiveDestructionMessageListener onReceiveDestructionMessageListener) {
        this.mOnReceiveDestructionMessageListener = onReceiveDestructionMessageListener;
    }

    public void setPushContentShowStatus(boolean z, OperationCallback operationCallback) {
        setPushSetting(PushSettings.PUSH_SETTINGS_SHOW_CONTENT, (z ? PushStatus.STATUS_ON : PushStatus.STATUS_OFF).getValue(), operationCallback);
        PushCacheHelper.getInstance().setPushContentShowStatus(this.mContext, z);
    }

    public void setPushLanguage(PushLanguage pushLanguage, OperationCallback operationCallback) {
        if (pushLanguage != null) {
            setPushSetting(PushSettings.PUSH_SETTINGS_LANGUAGE, pushLanguage.getMsg(), operationCallback);
            return;
        }
        RLog.d(TAG, "[PushSetting] setPushLanguage language is null");
        if (operationCallback != null) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void setPushReceiveStatus(boolean z, OperationCallback operationCallback) {
        setPushSetting(PushSettings.PUSH_SETTINGS_RECEIVE, (z ? PushStatus.STATUS_ON : PushStatus.STATUS_OFF).getValue(), operationCallback);
    }

    public void setRLogFileMaxSize(long j) {
        RLog.setFileMaxSize(j);
    }

    public void setRLogLevel(int i) {
        RLog.setLogLevel(i);
    }

    public void setReconnectKickEnable(boolean z) {
        this.kickReconnectDevice = z;
    }

    public void setSyncConversationReadStatusListener(SyncConversationReadStatusListener syncConversationReadStatusListener) {
        this.mSyncConversationReadStatusListener = syncConversationReadStatusListener;
    }

    public void setUploadCallback(RLogReporter.UploadCallback uploadCallback) {
        RLog.setUploadCallback(uploadCallback);
    }

    public void startCustomService(String str, ICustomServiceListener iCustomServiceListener, CSCustomServiceInfo cSCustomServiceInfo) {
        CustomServiceManager.getInstance().startCustomService(str, iCustomServiceListener, cSCustomServiceInfo);
    }

    public void startEncryptedSession(String str) {
        if (this.mEncSessionConListener == null) {
            RLog.e(TAG, "member of EncSessionConListener in RongIMClient instance is null, can not perform the session creation.");
            return;
        }
        if (str == null) {
            RLog.e(TAG, " startEncryptedSession - targetId is null! ");
            return;
        }
        String strGenEncId = RCDHCodecTool.genEncId();
        RCDHCodecTool rCDHCodecToolObtainWithEncId = RCDHCodecTool.obtainWithEncId(strGenEncId);
        rCDHCodecToolObtainWithEncId.getOrCreateLocalKeyPair(null);
        sendRequestMsg(str, strGenEncId, rCDHCodecToolObtainWithEncId);
    }

    public RealTimeLocationConstant.RealTimeLocationErrorCode startRealTimeLocation(Conversation.ConversationType conversationType, String str) {
        if (conversationType != null && str != null) {
            return RealTimeLocationConstant.RealTimeLocationErrorCode.valueOf(RealTimeLocationManager.getInstance().startRealTimeLocation(conversationType, str));
        }
        RLog.e(TAG, "startRealTimeLocation Type or id is null!");
        return null;
    }

    public void stopCustomService(String str) {
        CustomServiceManager.getInstance().stopCustomService(str);
    }

    public void stopDestructMessage(Message message) {
        if (message == null || message.getContent() == null) {
            RLog.e(TAG, "stopDestructMessage : message or content can't be null!");
        } else if (message.getContent().isDestruct() && message.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            DestructionTaskManager.getInstance().messageStopDestruct(message);
        }
    }

    public void subscribePublicService(final Conversation.PublicServiceType publicServiceType, final String str, OperationCallback operationCallback) {
        if (publicServiceType != null && !TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.89
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.subscribePublicService(str, publicServiceType.getValue(), true, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "subscribePublicService", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "Parameter  is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void supportResumeBrokenTransfer(final String str, final ResultCallback<Boolean> resultCallback) {
        if (!TextUtils.isEmpty(str) || resultCallback == null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.135
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zSupportResumeBrokenTransfer = RongIMClient.this.mLibHandler.supportResumeBrokenTransfer(str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zSupportResumeBrokenTransfer));
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "supportResumeBrokenTransfer", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void switchAppKey(String str) {
        RLog.d(TAG, "switchAppKey.");
        IHandler iHandler = this.mLibHandler;
        if (iHandler == null) {
            RLog.e(TAG, "IPC_DISCONNECT");
            return;
        }
        try {
            iHandler.switchAppKey(str, DeviceUtils.getDeviceId(this.mContext, str));
        } catch (RemoteException e2) {
            RLog.e(TAG, "switchAppKey", e2);
        }
        mNaviServer = null;
        mFileServer = null;
        if (isPushEnabled) {
            RongPushClient.stopService(this.mContext);
        }
    }

    public void switchToHumanMode(String str) {
        CustomServiceManager.getInstance().switchToHumanMode(str);
    }

    public void syncConversationReadStatus(Conversation.ConversationType conversationType, String str, long j, final OperationCallback operationCallback) {
        sendDirectionalMessage(conversationType, str, new SyncReadStatusMessage(j), new String[]{getCurrentUserId()}, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.RongIMClient.123
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, ErrorCode errorCode) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onSuccess();
                }
            }
        });
    }

    public void unsubscribePublicService(final Conversation.PublicServiceType publicServiceType, final String str, OperationCallback operationCallback) {
        if (publicServiceType != null && !TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.90
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.subscribePublicService(str, publicServiceType.getValue(), false, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "unsubscribePublicService", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "Parameter  is error!");
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void updateConversationInfo(final Conversation.ConversationType conversationType, final String str, final String str2, final String str3, final ResultCallback resultCallback) {
        if (TextUtils.isEmpty(str) || conversationType == null) {
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (!TextUtils.isEmpty(str2.trim()) || !TextUtils.isEmpty(str3.trim()))) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.14
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zUpdateConversationInfo = RongIMClient.this.mLibHandler.updateConversationInfo(conversationType.getValue(), str, str2, str3);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zUpdateConversationInfo));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "updateConversationInfo", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void updateMessageExpansion(final Map<String, String> map, final String str, OperationCallback operationCallback) {
        if (judgeMapInvalid(map, operationCallback) || judgeUIDInvalid(str, operationCallback)) {
            return;
        }
        if (ExpansionUtils.judgeKVExceedLimit(map)) {
            if (operationCallback != null) {
                operationCallback.onError(ErrorCode.RC_MSG_EXPANSION_SIZE_LIMIT_EXCEED);
            }
        } else if (!ExpansionUtils.judgeKVIllegality(map)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.151
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler != null) {
                        try {
                            RongIMClient.this.mLibHandler.updateMessageExpansion(map, str, RongIMClient.this.new DefaultOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            RLog.e(RongIMClient.TAG, "updateMessageExpansion", e2);
                            return;
                        }
                    }
                    T t = ipcCallbackProxy.callback;
                    if (t != 0) {
                        ((OperationCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else if (operationCallback != null) {
            operationCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void updateRealTimeLocationStatus(Conversation.ConversationType conversationType, String str, double d2, double d3, RealTimeLocationType realTimeLocationType) {
        if (conversationType == null || str == null) {
            RLog.e(TAG, "updateRealTimeLocationStatus Type or id is null!");
        } else {
            RealTimeLocationManager.getInstance().updateLocation(conversationType, str, d2, d3, realTimeLocationType);
        }
    }

    public void uploadRLog() {
        RLog.uploadRLog();
    }

    private RongIMClient() {
        this.CONVERSATION_NUMBER_OF_ONE_BATCH = 10;
        this.mConnectionStatus = ConnectionStatusListener.ConnectionStatus.UNCONNECTED;
        this.kickReconnectDevice = false;
        this.mRetryCRCache = new HashMap<>();
        this.mChatRoomCache = new HashMap<>();
        this.signalBuff = new ConcurrentHashMap<>();
        RLog.i(TAG, TAG);
        mHandler = new Handler(Looper.getMainLooper());
        this.mRegCache = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("IPC_WORK");
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("UP_WORK");
        handlerThread2.start();
        this.mStatusListener = new StatusListener();
        this.mWorkHandler = new Handler(handlerThread.getLooper());
        this.mUpStreamHandler = new Handler(handlerThread2.getLooper());
        this.mConnectChangeReceiver = new ConnectChangeReceiver();
        this.mAidlConnection = new AidlConnection();
        this.mCmdObjectNameList = new CopyOnWriteArraySet();
        this.mDeleteObjectNameList = new HashSet();
        this.imLibExtensionModuleManager = IMLibExtensionModuleManager.getInstance();
        IMLibRTCClient.getInstance().init(this.mWorkHandler);
    }

    public static RongIMClient connect(String str, int i, final ConnectCallback connectCallback) {
        FwLog.write(3, 1, "A-connect-T", RongLibConst.KEY_TOKEN, str);
        ConnectionErrorCode connectionErrorCode = TextUtils.isEmpty(str) ? ConnectionErrorCode.RC_CONN_TOKEN_INCORRECT : (SingletonHolder.sInstance.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.CONNECTING) || SingletonHolder.sInstance.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.SUSPEND) || SingletonHolder.sInstance.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.CONNECTED) || SingletonHolder.sInstance.mConnectionStatus.equals(ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE)) ? ConnectionErrorCode.RC_CONNECTION_EXIST : null;
        if (connectionErrorCode != null) {
            FwLog.write(3, 1, "A-connect-R", "code", connectionErrorCode);
            if (connectCallback != null) {
                connectCallback.onFail(connectionErrorCode);
            }
            return SingletonHolder.sInstance;
        }
        needCallBackDBOpen = true;
        SingletonHolder.sInstance.connectCallback = new ConnectCallback() { // from class: io.rong.imlib.RongIMClient.3
            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onDatabaseOpened(DatabaseOpenStatus databaseOpenStatus) {
                FwLog.write(3, 1, "A-connect-S", "code", Integer.valueOf(databaseOpenStatus.getValue()));
                RLog.i(RongIMClient.TAG, "DatabaseOpenStatus = " + databaseOpenStatus.getValue());
                ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onDatabaseOpened(databaseOpenStatus);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onError(ConnectionErrorCode connectionErrorCode2) {
                FwLog.write(1, 1, "A-connect-R", "code", Integer.valueOf(connectionErrorCode2.code));
                ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onError(connectionErrorCode2);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onSuccess(String str2) {
                FwLog.write(3, 1, "A-connect-R", "code|user_id", 0, str2);
                SingletonHolder.sInstance.stopConnectTimeoutTimer();
                ConnectCallback connectCallback2 = connectCallback;
                if (connectCallback2 != null) {
                    connectCallback2.onSuccess(str2);
                }
            }
        };
        if (i <= 0) {
            i = 2147483646;
        }
        SingletonHolder.sInstance.startConnectTimeoutTimer(i);
        SingletonHolder.sInstance.connectServer(str, false);
        return SingletonHolder.sInstance;
    }

    public static void init(Context context) {
        init(context, null, true);
    }

    public void disconnect(boolean z) {
        FwLog.write(3, 1, FwLog.LogTag.A_DISCONNECT_O.getTag(), "push", Boolean.valueOf(z));
        Context context = this.mContext;
        if (context != null && !z) {
            SharedPreferencesUtils.get(context, "Statistics", 0).edit().putString("userId", "").apply();
        }
        this.mStatusListener.onConnectionStatusChange(ConnectionStatusListener.ConnectionStatus.SIGN_OUT);
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.7
                @Override // java.lang.Runnable
                public void run() {
                    RongIMClient.this.mChatRoomCache.clear();
                    Iterator it = RongIMClient.this.mRetryCRCache.values().iterator();
                    while (it.hasNext()) {
                        RongIMClient.this.mWorkHandler.removeCallbacks((ChatRoomCacheRunnable) it.next());
                    }
                    RongIMClient.this.mRetryCRCache.clear();
                    RongIMClient.this.cancelAllDownloadMediaMessage(null);
                }
            });
        }
        try {
            if (this.mLibHandler != null) {
                this.mLibHandler.disconnect(z);
            }
        } catch (Exception e2) {
            RLog.e(TAG, "disconnect", e2);
        }
        clearToken();
    }

    public void evaluateCustomService(String str, int i, String str2, String str3) {
        CustomServiceManager.getInstance().evaluateCustomService(str, i, CustomServiceConfig.CSEvaSolveStatus.RESOLVED, str2, str3);
    }

    public void getConversationList(final ResultCallback<List<Conversation>> resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.9
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                Conversation.ConversationType[] conversationTypeArr2 = conversationTypeArr;
                if (conversationTypeArr2 == null || conversationTypeArr2.length == 0) {
                    resultCallback.onCallback(null);
                    return;
                }
                try {
                    RongIMClient.this.mLibHandler.getConversationListOfTypesByBatch(RongIMClient.this.convertTypes(conversationTypeArr2), 10, RongIMClient.this.new GetConversationListProcessCallBackWrapper(resultCallback));
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "getConversationList", e2);
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void getTotalUnreadCount(final ResultCallback<Integer> resultCallback, final Conversation... conversationArr) {
        if (conversationArr == null) {
            throw new IllegalArgumentException("conversations can't be null !");
        }
        for (Conversation conversation : conversationArr) {
            if (conversation.getConversationType() == null || TextUtils.isEmpty(conversation.getTargetId())) {
                throw new IllegalArgumentException("ConversationType or targetId can't be empty !");
            }
        }
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.18
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                try {
                    int unreadCountByConversation = RongIMClient.this.mLibHandler.getUnreadCountByConversation(conversationArr);
                    if (resultCallback != null) {
                        resultCallback.onCallback(Integer.valueOf(unreadCountByConversation));
                    }
                } catch (Exception unused) {
                    ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                    }
                }
            }
        });
    }

    public void insertIncomingMessage(final Conversation.ConversationType conversationType, final String str, final String str2, final Message.ReceivedStatus receivedStatus, final MessageContent messageContent, final long j, final ResultCallback<Message> resultCallback) {
        if (conversationType == null || TextUtils.isEmpty(str) || messageContent == null) {
            RLog.e(TAG, "insertIncomingMessage::ConversationType or targetId or content is null");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            throw new RuntimeException("自定义消息没有加注解信息。");
        }
        if ((messageTag.flag() & 1) == 1) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.56
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Message messageObtain = Message.obtain(str, conversationType, messageContent);
                    messageObtain.setSentTime(j);
                    messageObtain.setReceivedStatus(receivedStatus);
                    messageObtain.setSenderUserId(str2);
                    messageObtain.setMessageDirection(Message.MessageDirection.RECEIVE);
                    try {
                        Message messageInsertSettingMessage = RongIMClient.this.mLibHandler.insertSettingMessage(messageObtain);
                        if (resultCallback != null) {
                            if (messageInsertSettingMessage.getMessageId() >= 0) {
                                resultCallback.onCallback(messageInsertSettingMessage);
                            } else if (messageInsertSettingMessage.getMessageId() == ErrorCode.PARAMETER_ERROR.getValue()) {
                                resultCallback.onFail(ErrorCode.PARAMETER_ERROR);
                            } else {
                                resultCallback.onFail(ErrorCode.BIZ_ERROR_DATABASE_ERROR);
                            }
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "insertIncomingMessage", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
        RLog.e(TAG, "insertMessage Message is missing MessageTag.ISPERSISTED");
    }

    public void insertOutgoingMessage(final Conversation.ConversationType conversationType, final String str, final Message.SentStatus sentStatus, final MessageContent messageContent, final long j, final ResultCallback<Message> resultCallback) {
        if (conversationType == null || TextUtils.isEmpty(str) || messageContent == null) {
            RLog.e(TAG, "insertOutgoingMessage::ConversationType or targetId or content is null");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            throw new RuntimeException("自定义消息没有加注解信息。");
        }
        if ((messageTag.flag() & 1) == 1) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.54
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Message messageObtain = Message.obtain(str, conversationType, messageContent);
                    messageObtain.setSentTime(j);
                    messageObtain.setSentStatus(sentStatus);
                    messageObtain.setSenderUserId(RongIMClient.this.mCurrentUserId);
                    messageObtain.setMessageDirection(Message.MessageDirection.SEND);
                    try {
                        Message messageInsertSettingMessage = RongIMClient.this.mLibHandler.insertSettingMessage(messageObtain);
                        if (resultCallback != null) {
                            if (messageInsertSettingMessage.getMessageId() >= 0) {
                                resultCallback.onCallback(messageInsertSettingMessage);
                            } else if (messageInsertSettingMessage.getMessageId() == ErrorCode.PARAMETER_ERROR.getValue()) {
                                resultCallback.onFail(ErrorCode.PARAMETER_ERROR);
                            } else {
                                resultCallback.onFail(ErrorCode.BIZ_ERROR_DATABASE_ERROR);
                            }
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "insertOutgoingMessage", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
        RLog.e(TAG, "insertMessage Message is missing MessageTag.ISPERSISTED");
    }

    public boolean isFileDownloading(int i) {
        return isFileDownloading(i + "");
    }

    public void setConversationToTop(final Conversation.ConversationType conversationType, final String str, final boolean z, final boolean z2, final ResultCallback<Boolean> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.16
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean conversationTopStatus = RongIMClient.this.mLibHandler.setConversationTopStatus(conversationType.getValue(), str, z, z2);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(conversationTopStatus));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "setConversationToTop", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "getConversation. the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public static void init(Context context, String str) {
        init(context, str, true);
    }

    public void evaluateCustomService(String str, int i, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str2, String str3, String str4, String str5) {
        CustomServiceManager.getInstance().evaluateCustomService(str, i, cSEvaSolveStatus, str2, str3, str4, str5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Boolean] */
    public boolean isFileDownloading(String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ResultCallback.Result result = new ResultCallback.Result();
        result.t = false;
        isFileDownloading(str, new SyncCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.138
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                countDownLatch.countDown();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                if (bool != 0) {
                    result.t = bool;
                } else {
                    RLog.e(RongIMClient.TAG, "removeConversation removeConversation is failure!");
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            RLog.e(TAG, "isFileDownloading", e2);
            Thread.currentThread().interrupt();
        }
        return ((Boolean) result.t).booleanValue();
    }

    public void sendMessage(Message message, String str, String str2, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        sendMessage(message, str, str2, null, iSendMessageCallback);
    }

    public static void init(Context context, String str, boolean z) {
        RLog.d(TAG, "isPushEnabled:" + z);
        isPushEnabled = z;
        SingletonHolder.sInstance.initSDK(context, str);
    }

    public void evaluateCustomService(String str, int i, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str2, String str3) {
        CustomServiceManager.getInstance().evaluateCustomService(str, i, cSEvaSolveStatus, str2, str3);
    }

    public void sendMessage(Message message, String str, String str2, SendMessageOption sendMessageOption, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(message, errorCodeFilterSendMessage);
            }
        } else {
            if (((MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class)) == null) {
                RLog.e(TAG, "sendMessage 自定义消息没有加注解信息。");
                if (iSendMessageCallback != null) {
                    iSendMessageCallback.onError(message, ErrorCode.PARAMETER_ERROR);
                    return;
                }
                return;
            }
            if (TypingMessageManager.getInstance().isShowMessageTyping()) {
                MessageContent content = message.getContent();
                if (!(content instanceof TypingStatusMessage) && !(content instanceof ReadReceiptMessage)) {
                    TypingMessageManager.getInstance().setTypingEnd(message.getConversationType(), message.getTargetId());
                }
            }
            this.mWorkHandler.post(new AnonymousClass58(new IpcCallbackProxy(iSendMessageCallback), message, str, str2, sendMessageOption));
        }
    }

    public void clearMessagesUnreadStatus(final Conversation.ConversationType conversationType, final String str, final long j, final OperationCallback operationCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.96
            @Override // java.lang.Runnable
            public void run() {
                if (RongIMClient.this.mLibHandler == null) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    return;
                }
                if (conversationType == null) {
                    RLog.e(RongIMClient.TAG, "clearMessagesUnreadStatus conversationType is null!");
                    OperationCallback operationCallback3 = operationCallback;
                    if (operationCallback3 != null) {
                        operationCallback3.onFail(ErrorCode.PARAMETER_ERROR);
                        return;
                    }
                    return;
                }
                try {
                    if (RongIMClient.this.mLibHandler.clearUnreadByReceipt(conversationType.getValue(), str, j)) {
                        if (operationCallback != null) {
                            operationCallback.onCallback();
                        }
                    } else if (operationCallback != null) {
                        operationCallback.onFail(ErrorCode.UNKNOWN);
                    }
                } catch (Exception e2) {
                    RLog.e(RongIMClient.TAG, "clearMessagesUnreadStatus", e2);
                }
            }
        });
    }

    public void getUnreadCount(final ResultCallback<Integer> resultCallback, final Conversation.ConversationType... conversationTypeArr) {
        if (conversationTypeArr != null && conversationTypeArr.length != 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.20
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        int unreadCount = RongIMClient.this.mLibHandler.getUnreadCount(RongIMClient.this.convertTypes(conversationTypeArr));
                        if (resultCallback != null) {
                            resultCallback.onCallback(Integer.valueOf(unreadCount));
                        }
                    } catch (Exception unused) {
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "conversationTypes is null. Return directly!!!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendImageMessage(Message message, final String str, final String str2, final SendImageMessageCallback sendImageMessageCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (sendImageMessageCallback != null) {
                sendImageMessageCallback.onError(errorCodeFilterSendMessage);
                return;
            }
            return;
        }
        final ResultCallback.Result result = new ResultCallback.Result();
        result.t = message;
        final UploadMediaCallback uploadMediaCallback = new UploadMediaCallback() { // from class: io.rong.imlib.RongIMClient.60
            @Override // io.rong.imlib.RongIMClient.UploadMediaCallback
            public void onError(Message message2, ErrorCode errorCode) {
                message2.setSentStatus(Message.SentStatus.FAILED);
                RongIMClient.this.setMessageSentStatus(message2, new ResultCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.60.1
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(ErrorCode errorCode2) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(Boolean bool) {
                    }
                });
                SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onFail(message2, errorCode);
                }
            }

            @Override // io.rong.imlib.RongIMClient.UploadMediaCallback
            public void onProgress(Message message2, int i) {
                SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onProgressCallback(message2, i);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Message message2) {
                RongIMClient.this.internalSendImageMessage(message2, str, str2, sendImageMessageCallback);
            }
        };
        ResultCallback<Message> resultCallback = new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.61
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onFail(errorCode);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Message message2) {
                if (message2 == 0) {
                    throw new IllegalArgumentException("Message Content 为空！");
                }
                result.t = message2;
                message2.setSentStatus(Message.SentStatus.SENDING);
                RongIMClient.this.setMessageSentStatus(message2, null);
                SendImageMessageCallback sendImageMessageCallback2 = sendImageMessageCallback;
                if (sendImageMessageCallback2 != null) {
                    sendImageMessageCallback2.onAttachedCallback(message2);
                }
                RongIMClient.this.uploadMedia(message2, uploadMediaCallback);
            }
        };
        if (message.getMessageId() <= 0) {
            insertSettingMessage(message, resultCallback);
            return;
        }
        message.setSentStatus(Message.SentStatus.SENDING);
        setMessageSentStatus(message, new ResultCallback<Boolean>() { // from class: io.rong.imlib.RongIMClient.62
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
            }
        });
        uploadMedia(message, uploadMediaCallback);
    }

    public void getRemoteHistoryMessages(final Conversation.ConversationType conversationType, final String str, final RemoteHistoryMsgOption remoteHistoryMsgOption, ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.30
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        T t = ipcCallbackProxy.callback;
                        if (t != 0) {
                            ((ResultCallback) t).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        RongIMClient.this.mLibHandler.getRemoteHistoryMessagesOption(conversation, remoteHistoryMsgOption, new IResultCallback.Stub() { // from class: io.rong.imlib.RongIMClient.30.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
                                if (ipcCallbackProxy.callback != 0) {
                                    if (remoteModelWrap == null || remoteModelWrap.getContent() == null || !(remoteModelWrap.getContent() instanceof RongListWrap)) {
                                        ((ResultCallback) ipcCallbackProxy.callback).onCallback(null);
                                    } else {
                                        ((ResultCallback) ipcCallbackProxy.callback).onCallback(((RongListWrap) remoteModelWrap.getContent()).getList());
                                    }
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IResultCallback
                            public void onFailure(int i) throws RemoteException {
                                T t2 = ipcCallbackProxy.callback;
                                if (t2 != 0) {
                                    ((ResultCallback) t2).onFail(ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getRemoteHistoryMessages", e2);
                        T t2 = ipcCallbackProxy.callback;
                        if (t2 != 0) {
                            ((ResultCallback) t2).onFail(ErrorCode.IPC_DISCONNECT);
                            ipcCallbackProxy.callback = null;
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    @Deprecated
    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, String str2, int i, int i2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ResultCallback.Result result = new ResultCallback.Result();
        getHistoryMessages(conversationType, str, str2, i, i2, new SyncCallback<List<Message>>() { // from class: io.rong.imlib.RongIMClient.25
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                countDownLatch.countDown();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                result.t = list;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            RLog.e(TAG, "getHistoryMessages", e2);
            Thread.currentThread().interrupt();
        }
        return (List) result.t;
    }

    public void sendReadReceiptMessage(Conversation.ConversationType conversationType, String str, long j, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        if (conversationType != Conversation.ConversationType.PRIVATE && conversationType != Conversation.ConversationType.ENCRYPTED) {
            RLog.e(TAG, "sendReadReceiptMessage conversationType only support PRIVATE and ENCRYPTED");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(null, ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "sendReadReceiptMessage targetId is empty");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(null, ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (j <= 0) {
            RLog.e(TAG, "sendReadReceiptMessage timestamp is error");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(null, ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        sendMessage(conversationType, str, new ReadReceiptMessage(j), null, null, iSendMessageCallback);
    }

    public void getUnreadCount(final Conversation.ConversationType[] conversationTypeArr, final boolean z, final ResultCallback<Integer> resultCallback) {
        if (conversationTypeArr != null && conversationTypeArr.length != 0) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.21
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        int unreadCountWithDND = RongIMClient.this.mLibHandler.getUnreadCountWithDND(RongIMClient.this.convertTypes(conversationTypeArr), z);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Integer.valueOf(unreadCountWithDND));
                        }
                    } catch (Exception unused) {
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "conversationTypes is null. Return directly!!!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public static void registerMessageType(List<Class<? extends MessageContent>> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            synchronized (SingletonHolder.sInstance.mRegCache) {
                Iterator<Class<? extends MessageContent>> it = list.iterator();
                while (it.hasNext()) {
                    String name = it.next().getName();
                    if (!SingletonHolder.sInstance.mRegCache.contains(name)) {
                        SingletonHolder.sInstance.mRegCache.add(name);
                        arrayList.add(name);
                    }
                }
            }
            if (SingletonHolder.sInstance.mLibHandler != null) {
                try {
                    if (arrayList.size() > 0) {
                        SingletonHolder.sInstance.mLibHandler.registerMessageTypes(arrayList);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    RLog.e(TAG, "registerMessageType RemoteException", e2);
                    return;
                }
            }
            return;
        }
        FwLog.write(2, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "messageContentClassList", "messageContentClassList is empty");
    }

    public void deleteMessages(final Conversation.ConversationType conversationType, final String str, final ResultCallback<Boolean> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.37
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    try {
                        boolean zDeleteConversationMessage = RongIMClient.this.mLibHandler.deleteConversationMessage(conversationType.getValue(), str);
                        if (resultCallback != null) {
                            resultCallback.onCallback(Boolean.valueOf(zDeleteConversationMessage));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "deleteMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void sendMediaMessage(final Message message, final String str, final String str2, final IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onError(message, errorCodeFilterSendMessage);
                return;
            }
            return;
        }
        if (!FileUtils.isFileExistsWithUri(this.mContext, ((MediaMessageContent) message.getContent()).getLocalPath())) {
            RLog.e(TAG, "Media file does not exist!");
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onError(message, ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        insertSettingMessage(message, new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.120
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(ErrorCode errorCode) {
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onError(message, ErrorCode.RC_MSG_SEND_FAIL);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Message message2) {
                message2.setSentStatus(Message.SentStatus.SENDING);
                RongIMClient.this.setMessageSentStatus(message2, null);
                IRongCallback.ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader2 = iSendMediaMessageCallbackWithUploader;
                if (iSendMediaMessageCallbackWithUploader2 != null) {
                    iSendMediaMessageCallbackWithUploader2.onAttached(message2, new IRongCallback.MediaMessageUploader(message2, str, str2, iSendMediaMessageCallbackWithUploader2));
                }
            }
        });
    }

    public void getUnreadCount(Conversation.ConversationType[] conversationTypeArr, ResultCallback<Integer> resultCallback) {
        getUnreadCount(resultCallback, conversationTypeArr);
    }

    public void getHistoryMessages(final Conversation.ConversationType conversationType, final String str, final String str2, final int i, final int i2, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null && !TextUtils.isEmpty(str2)) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.26
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        List<Message> olderMessagesByObjectName = RongIMClient.this.mLibHandler.getOlderMessagesByObjectName(conversation, str2, i, i2, true);
                        if (resultCallback != null) {
                            resultCallback.onCallback(RongIMClient.this.filterDestructionMessage(conversationType, str, olderMessagesByObjectName));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getHistoryMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType or objectName is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void sendImageMessage(final Message message, final String str, final String str2, final SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback) {
        ErrorCode errorCodeFilterSendMessage = filterSendMessage(message);
        if (errorCodeFilterSendMessage != null) {
            if (sendImageMessageWithUploadListenerCallback != null) {
                sendImageMessageWithUploadListenerCallback.onError(null, errorCodeFilterSendMessage);
            }
        } else {
            if (this.mLibHandler == null) {
                RLog.e(TAG, "sendImageMessage IPC 进程尚未运行！");
                if (sendImageMessageWithUploadListenerCallback != null) {
                    sendImageMessageWithUploadListenerCallback.onError(message, ErrorCode.IPC_DISCONNECT);
                    return;
                }
                return;
            }
            insertSettingMessage(message, new ResultCallback<Message>() { // from class: io.rong.imlib.RongIMClient.63
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(ErrorCode errorCode) {
                    SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                    if (sendImageMessageWithUploadListenerCallback2 != null) {
                        sendImageMessageWithUploadListenerCallback2.onError(message, errorCode);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Message message2) {
                    if (message2 == null) {
                        throw new IllegalArgumentException("Message Content 为空！");
                    }
                    message2.setSentStatus(Message.SentStatus.SENDING);
                    RongIMClient.this.setMessageSentStatus(message2, null);
                    SendImageMessageWithUploadListenerCallback sendImageMessageWithUploadListenerCallback2 = sendImageMessageWithUploadListenerCallback;
                    if (sendImageMessageWithUploadListenerCallback2 != null) {
                        sendImageMessageWithUploadListenerCallback.onAttachedCallback(message2, RongIMClient.this.new UploadImageStatusListener(message2, str, str2, sendImageMessageWithUploadListenerCallback2));
                    }
                }
            });
        }
    }

    public void getHistoryMessages(final Conversation.ConversationType conversationType, final String str, final String str2, final int i, final int i2, final RongCommonDefine.GetMessageDirection getMessageDirection, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            if (!TextUtils.isEmpty(str2) && i2 > 0 && getMessageDirection != null) {
                this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.27
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RongIMClient.this.mLibHandler == null) {
                            ResultCallback resultCallback2 = resultCallback;
                            if (resultCallback2 != null) {
                                resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                                return;
                            }
                            return;
                        }
                        Conversation conversation = new Conversation();
                        conversation.setConversationType(conversationType);
                        conversation.setTargetId(str);
                        try {
                            List<Message> olderMessagesByObjectName = RongIMClient.this.mLibHandler.getOlderMessagesByObjectName(conversation, str2, i, i2, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
                            if (resultCallback != null) {
                                resultCallback.onCallback(RongIMClient.this.filterDestructionMessage(conversationType, str, olderMessagesByObjectName));
                            }
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "getHistoryMessages", e2);
                            ResultCallback resultCallback3 = resultCallback;
                            if (resultCallback3 != null) {
                                resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                            }
                        }
                    }
                });
                return;
            }
            RLog.e(TAG, "the parameter of objectName, count or direction is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getHistoryMessages(final Conversation.ConversationType conversationType, final String str, final List<String> list, final long j, final int i, final RongCommonDefine.GetMessageDirection getMessageDirection, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            if (list.size() != 0 && i > 0 && getMessageDirection != null) {
                this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.28
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RongIMClient.this.mLibHandler == null) {
                            ResultCallback resultCallback2 = resultCallback;
                            if (resultCallback2 != null) {
                                resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                                return;
                            }
                            return;
                        }
                        Conversation conversation = new Conversation();
                        conversation.setConversationType(conversationType);
                        conversation.setTargetId(str);
                        try {
                            List<Message> olderMessagesByObjectNames = RongIMClient.this.mLibHandler.getOlderMessagesByObjectNames(conversation, list, j, i, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
                            if (resultCallback != null) {
                                resultCallback.onCallback(RongIMClient.this.filterDestructionMessage(conversationType, str, olderMessagesByObjectNames));
                            }
                        } catch (Exception e2) {
                            RLog.e(RongIMClient.TAG, "getHistoryMessages", e2);
                            ResultCallback resultCallback3 = resultCallback;
                            if (resultCallback3 != null) {
                                resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                            }
                        }
                    }
                });
                return;
            }
            RLog.e(TAG, "the parameter size of objectNames, count or direction is error!");
            if (resultCallback != null) {
                resultCallback.onError(ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getHistoryMessages(final Conversation.ConversationType conversationType, final String str, final int i, final int i2, final ResultCallback<List<Message>> resultCallback) {
        if (!TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.35
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.IPC_DISCONNECT);
                            return;
                        }
                        return;
                    }
                    Conversation conversation = new Conversation();
                    conversation.setConversationType(conversationType);
                    conversation.setTargetId(str);
                    try {
                        List<Message> olderMessages = RongIMClient.this.mLibHandler.getOlderMessages(conversation, i, i2);
                        if (resultCallback != null) {
                            resultCallback.onCallback(RongIMClient.this.filterDestructionMessage(conversationType, str, olderMessages));
                        }
                    } catch (Exception e2) {
                        RLog.e(RongIMClient.TAG, "getHistoryMessages", e2);
                        ResultCallback resultCallback3 = resultCallback;
                        if (resultCallback3 != null) {
                            resultCallback3.onFail(ErrorCode.IPC_DISCONNECT);
                        }
                    }
                }
            });
            return;
        }
        RLog.e(TAG, "the parameter of targetId or ConversationType is error!");
        if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }

    public void getHistoryMessages(final Conversation.ConversationType conversationType, final String str, final long j, final int i, final int i2, final ResultCallback<List<Message>> resultCallback) {
        if (j > 0 && i >= 0 && i2 >= 0 && !TextUtils.isEmpty(str) && conversationType != null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.RongIMClient.127
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.this.mLibHandler == null) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onFail(ErrorCode.PARAMETER_ERROR);
                            return;
                        }
                        return;
                    }
                    try {
                        List<Message> matchedMessages = RongIMClient.this.mLibHandler.getMatchedMessages(str, conversationType.getValue(), j, i, i2);
                        if (resultCallback != null) {
                            resultCallback.onCallback(RongIMClient.this.filterDestructionMessage(conversationType, str, matchedMessages));
                        }
                    } catch (RemoteException e2) {
                        RLog.e(RongIMClient.TAG, "getHistoryMessages", e2);
                    }
                }
            });
        } else if (resultCallback != null) {
            resultCallback.onError(ErrorCode.PARAMETER_ERROR);
        }
    }
}
