package io.rong.imlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.p;
import com.google.gson.s;
import com.tencent.map.geolocation.TencentLocation;
import com.umeng.analytics.pro.au;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.FileUtils;
import io.rong.common.JSONUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.common.fwlog.LogSplitUtil;
import io.rong.common.rlog.IRealTimeLogListener;
import io.rong.common.rlog.RLog;
import io.rong.imlib.NativeObject;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.BuildVar;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SavePathUtils;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.filetransfer.FtUtilities;
import io.rong.imlib.filetransfer.MediaDownloadEngine;
import io.rong.imlib.filetransfer.RequestCallBack;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.MediaUploadEngine;
import io.rong.imlib.model.ChatRoomInfo;
import io.rong.imlib.model.ChatRoomMemberInfo;
import io.rong.imlib.model.ChatroomStatus;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageConfig;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.MessagePushConfig;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.RTCStatusDate;
import io.rong.imlib.model.RTCUser;
import io.rong.imlib.model.RemoteHistoryMsgOption;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.model.UnknownMessage;
import io.rong.imlib.model.UserData;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.imlib.navigation.NavigationClient;
import io.rong.message.ChatRoomKVNotiMessage;
import io.rong.message.DiscussionNotificationMessage;
import io.rong.message.GIFMessage;
import io.rong.message.HQVoiceMessage;
import io.rong.message.IHandleMessageListener;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import io.rong.message.LogCmdMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.MessageExpansionMessage;
import io.rong.message.MessageHandler;
import io.rong.message.RCEncryptedMessage;
import io.rong.message.SightMessage;
import io.rong.message.TextMessage;
import io.rong.message.utils.RCDHCodecTool;
import io.rong.rtlog.upload.RtLogUploadManager;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class NativeClient {
    private static final int EXPANSION_MAX_COUNT = 300;
    private static final int EXPANSION_SINGLE_MAX_COUNT = 20;
    private static final String TAG = "NativeClient";
    private static Context mContext;
    private static IMessageExpansionListener messageExpansionListener;
    private String appKey;
    private ConcurrentHashMap<String, Boolean> chatRoomStatusMap;
    private String curUserId;
    private String dbPath;
    private String deviceId;
    private ScheduledThreadPoolExecutor executorService;
    private Set<String> mCmdObjectNameSet;
    private String mFileServer;
    private KVStatusListener mKVStatusListener;
    private Handler mWorkHandler;
    private HashMap<String, Constructor<? extends MessageContent>> messageContentConstructorMap;
    private HashMap<String, MessageHandler> messageHandlerMap;
    private NativeObject nativeObj;
    private NavigationClient.NaviUpdateListener naviUpdateListener;
    private Executor receiveMessageExecutor;

    public enum BlacklistStatus {
        EXIT_BLACK_LIST(0),
        NOT_EXIT_BLACK_LIST(1);

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
            return NOT_EXIT_BLACK_LIST;
        }

        public int getValue() {
            return this.value;
        }
    }

    public interface GetNotificationQuietHoursCallback {
        void onError(int i);

        void onSuccess(String str, int i);
    }

    public interface ICodeListener {
        void onChanged(int i);
    }

    public interface IConnectResultCallback<T> extends IResultCallback<T> {
        void OnDatabaseOpened(int i);
    }

    public interface IDownloadMediaFileCallback<T> extends IDownloadMediaMessageCallback<T> {
        void onFileNameChanged(String str);
    }

    public interface IDownloadMediaMessageCallback<T> {
        void onCanceled();

        void onError(int i);

        void onProgress(int i);

        void onSuccess(T t);
    }

    public interface IResultCallback<T> {
        void onError(int i);

        void onSuccess(T t);
    }

    public interface IResultCallbackEx<T, K> {
        void onError(int i);

        void onSuccess(T t, K k);
    }

    public interface IResultProgressCallback<T> {
        void onCanceled(int i);

        void onError(int i);

        void onProgress(int i);

        void onSuccess(T t);
    }

    public interface ISendMediaMessageCallback<T> {
        void onAttached(T t);

        void onCanceled(T t);

        void onError(T t, int i);

        void onProgress(T t, int i);

        void onSuccess(T t);
    }

    public interface ISendMessageCallback<T> {
        void onAttached(T t);

        void onError(T t, int i);

        void onSuccess(T t);
    }

    public interface KVStatusListener {
        void onChatRoomKVStatusChange(String str, Map<String, String> map);

        void onChatRoomKVStatusRemove(String str, Map<String, String> map);

        void onChatRoomKVStatusSync(String str);
    }

    private static class MessageExpansionHandle {
        private String extMsgExpansion;
        private final NativeObject.Message nativeMsg;
        private final long ts;
        private final Map<String, String> updateExpansion;
        private String updateStr;

        MessageExpansionHandle(NativeObject.Message message, Map<String, String> map, long j) {
            this.nativeMsg = message;
            this.updateExpansion = map;
            this.ts = j;
        }

        String getExtMsgExpansion() {
            return this.extMsgExpansion;
        }

        String getUpdateStr() {
            return this.updateStr;
        }

        MessageExpansionHandle invoke() {
            List<String> listMergeJson = JSONUtils.mergeJson(JSONUtils.mapTsCombineJson(this.updateExpansion, this.ts), this.nativeMsg.getExtMsg());
            if (listMergeJson == null || listMergeJson.size() == 0) {
                this.extMsgExpansion = "";
                this.updateStr = "";
            } else {
                this.extMsgExpansion = listMergeJson.get(0);
                this.updateStr = listMergeJson.get(1);
            }
            return this;
        }
    }

    private static class NativeClientHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final NativeClient client = new NativeClient();

        private NativeClientHolder() {
        }
    }

    public interface OnReceiveMessageListener {
        void onReceived(Message message, int i, boolean z, boolean z2, int i2);
    }

    public interface OperationCallback {
        void onError(int i);

        void onSuccess();
    }

    public interface PushNotificationListener {
        void OnPushNotificationChanged(long j);
    }

    private Message encryptMessageContentIfNeeded(byte[] bArr, Message message) throws RuntimeException {
        String targetId = message.getTargetId();
        if (TextUtils.isEmpty(targetId)) {
            throw new RuntimeException("error! message TargetId is empty. message -> " + message.toString());
        }
        String[] strArrSplit = targetId.split(";;;");
        if (strArrSplit.length != 2) {
            throw new RuntimeException("error occurs while spliting targetId -> " + targetId);
        }
        RCEncryptedSession rCEncryptedSessionGetEncryptedConversationInfo = this.nativeObj.GetEncryptedConversationInfo(targetId);
        if (rCEncryptedSessionGetEncryptedConversationInfo == null) {
            throw new RuntimeException("error ! getEncryptedConversationInfo is null.");
        }
        RCDHCodecTool.RCSecretKey rCSecretKeyFromString2RCSecretKey = RCDHCodecTool.fromString2RCSecretKey(rCEncryptedSessionGetEncryptedConversationInfo.getEncKey());
        if (rCSecretKeyFromString2RCSecretKey == null) {
            throw new RuntimeException("error occurs when transfering encKey.");
        }
        String strEncodeToString = Base64.encodeToString(RCDHCodecTool.encrypt(bArr, rCSecretKeyFromString2RCSecretKey), 2);
        RCEncryptedMessage rCEncryptedMessage = new RCEncryptedMessage();
        rCEncryptedMessage.setEncryptedContent(strEncodeToString);
        rCEncryptedMessage.setOriginalObjName(message.getObjectName());
        rCEncryptedMessage.setRemoteEncId(rCEncryptedSessionGetEncryptedConversationInfo.getRemoteEncId());
        Message messageObtain = Message.obtain(strArrSplit[1], message.getConversationType(), rCEncryptedMessage);
        messageObtain.setObjectName(((MessageTag) RCEncryptedMessage.class.getAnnotation(MessageTag.class)).value());
        messageObtain.setExtra(message.getExtra());
        messageObtain.setMessageDirection(message.getMessageDirection());
        messageObtain.setMessageId(message.getMessageId());
        messageObtain.setUId(message.getUId());
        messageObtain.setReadReceiptInfo(message.getReadReceiptInfo());
        messageObtain.setReadTime(message.getReadTime());
        messageObtain.setSenderUserId(message.getSenderUserId());
        messageObtain.setSentStatus(message.getSentStatus());
        messageObtain.setReceivedStatus(message.getReceivedStatus());
        messageObtain.setSentTime(message.getSentTime());
        messageObtain.setReceivedTime(message.getReceivedTime());
        return messageObtain;
    }

    public static Context getApplicationContext() {
        return mContext;
    }

    public static NativeClient getInstance() {
        return NativeClientHolder.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMessageExpansion(Message message, Map<String, String> map, String str) {
        List<String> listMergeJson = JSONUtils.mergeJson(JSONUtils.mapTsCombineJson(map, timeDisposal(message)), str);
        return (listMergeJson == null || listMergeJson.size() == 0) ? "" : listMergeJson.get(0);
    }

    private MessageHandler getMessageHandler(String str) {
        return this.messageHandlerMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchableWord(MessageContent messageContent) {
        List<String> searchableWord;
        if (messageContent == null || (searchableWord = messageContent.getSearchableWord()) == null || searchableWord.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = searchableWord.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        return sb.toString();
    }

    private void handleEncryptedMessage(Message message, MessageContent messageContent) {
        if (message.getSenderUserId() != null && message.getSenderUserId().equals(getCurrentUserId())) {
            RLog.d(TAG, "encryptedMsg from the same endpoint , do nothing.");
            return;
        }
        if (messageContent == null) {
            RLog.e(TAG, "render EncryptedMsgContent returns null.");
            return;
        }
        RCEncryptedMessage rCEncryptedMessage = (RCEncryptedMessage) messageContent;
        String remoteEncId = rCEncryptedMessage.getRemoteEncId();
        String targetId = message.getTargetId();
        RCEncryptedSession rCEncryptedSessionGetEncryptedConversationInfo = this.nativeObj.GetEncryptedConversationInfo(remoteEncId + ";;;" + targetId);
        if (rCEncryptedSessionGetEncryptedConversationInfo == null) {
            RLog.w(TAG, "GetEncryptedConversationInfo of " + remoteEncId + ";;;" + targetId + " is null ");
            return;
        }
        String encKey = rCEncryptedSessionGetEncryptedConversationInfo.getEncKey();
        if (TextUtils.isEmpty(encKey)) {
            RLog.w(TAG, "result is null when getEncKey from encryptedSesseion of ->" + remoteEncId + ";;;" + targetId);
            return;
        }
        RCDHCodecTool.RCSecretKey rCSecretKeyFromString2RCSecretKey = RCDHCodecTool.fromString2RCSecretKey(encKey);
        if (rCEncryptedMessage.getEncryptedContent() == null) {
            RLog.e(TAG, "instance of RCEncryptedMessage getEncryptedContent() returns null.");
            return;
        }
        if (rCSecretKeyFromString2RCSecretKey == null) {
            RLog.e(TAG, "secretKey is null.");
            return;
        }
        byte[] bArrDecrypt = RCDHCodecTool.decrypt(Base64.decode(rCEncryptedMessage.getEncryptedContent(), 2), rCSecretKeyFromString2RCSecretKey);
        MessageContent messageContentRenderMessageContent = renderMessageContent(rCEncryptedMessage.getOriginalObjName(), bArrDecrypt, message);
        message.setContent(messageContentRenderMessageContent);
        message.setObjectName(rCEncryptedMessage.getOriginalObjName());
        message.setTargetId(remoteEncId + ";;;" + targetId);
        message.setConversationType(Conversation.ConversationType.ENCRYPTED);
        message.setMessageId(message.getMessageId());
        MessageTag messageTag = (MessageTag) messageContentRenderMessageContent.getClass().getAnnotation(MessageTag.class);
        if ((messageTag.flag() & 1) == 1) {
            int i = ((messageTag.flag() & 3) == 3 ? 1 : 0) ^ 1;
            MessageConfig messageConfig = message.getMessageConfig();
            message.setMessageId((int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), message.getObjectName(), message.getSenderUserId(), bArrDecrypt, true, 0, Message.SentStatus.RECEIVED.getValue(), message.getSentTime(), getSearchableWord(messageContentRenderMessageContent), i, message.getUId(), messageConfig != null ? messageConfig.isDisableNotification() : false, message.isCanIncludeExpansion(), JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExpansionMsg(Message message) {
        MessageExpansionMessage messageExpansionMessage = (MessageExpansionMessage) message.getContent();
        String originalMsgUId = messageExpansionMessage.getOriginalMsgUId();
        Message messageByUid = getMessageByUid(originalMsgUId);
        if (messageByUid == null) {
            RLog.e(TAG, "handleMessageExpansionMsg originMsg is null");
            return;
        }
        NativeObject.Message messageGetMessageByUId = this.nativeObj.GetMessageByUId(originalMsgUId);
        Map<String, String> updateExpansion = messageExpansionMessage.getUpdateExpansion();
        List<String> removeExpansionKeyList = messageExpansionMessage.getRemoveExpansionKeyList();
        boolean zIsRemoveAllKeys = messageExpansionMessage.isRemoveAllKeys();
        long jTimeDisposal = timeDisposal(message);
        if (zIsRemoveAllKeys) {
            removeKeysInExpansionEx(jTimeDisposal, true, new ArrayList(), messageByUid, null);
            return;
        }
        if (updateExpansion == null) {
            removeKeysInExpansionEx(jTimeDisposal, true, removeExpansionKeyList, messageByUid, null);
            return;
        }
        MessageExpansionHandle messageExpansionHandleInvoke = new MessageExpansionHandle(messageGetMessageByUId, updateExpansion, jTimeDisposal).invoke();
        String extMsgExpansion = messageExpansionHandleInvoke.getExtMsgExpansion();
        String updateStr = messageExpansionHandleInvoke.getUpdateStr();
        boolean messageExpansion = setMessageExpansion(messageByUid.getTargetId(), messageByUid.getConversationType().getValue(), originalMsgUId, extMsgExpansion);
        if (messageExpansionListener != null) {
            try {
                JSONObject jSONObject = new JSONObject(updateStr);
                if (messageExpansion) {
                    messageByUid.setExpansion(JSONUtils.expansionExJSONToMap(extMsgExpansion));
                    if (TextUtils.isEmpty(updateStr) || jSONObject.length() == 0) {
                        return;
                    }
                    messageExpansionListener.onMessageExpansionUpdate(JSONUtils.expansionExJSONToMap(updateStr), messageByUid);
                }
            } catch (RemoteException | JSONException e2) {
                RLog.e(TAG, e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReceivedMessage(NativeObject.Message message, int i, boolean z, boolean z2, int i2, OnReceiveMessageListener onReceiveMessageListener) {
        final Message message2 = new Message(message);
        String objectName = message2.getObjectName();
        MessageContent messageContentRenderMessageContent = renderMessageContent(message.getObjectName(), message.getContent(), message2);
        if (objectName.equals("RC:EncryptedMsg")) {
            handleEncryptedMessage(message2, messageContentRenderMessageContent);
        } else {
            message2.setContent(messageContentRenderMessageContent);
        }
        if (message2.getContent() instanceof DiscussionNotificationMessage) {
            DiscussionNotificationMessage discussionNotificationMessage = (DiscussionNotificationMessage) message2.getContent();
            if (this.curUserId.equals(discussionNotificationMessage.getOperator()) || discussionNotificationMessage.getType() != 4) {
                this.nativeObj.GetDiscussionInfo(message2.getTargetId(), new NativeObject.DiscussionInfoListener() { // from class: io.rong.imlib.NativeClient.36
                    @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                    public void OnError(int i3) {
                    }

                    @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                    public void onReceived(NativeObject.DiscussionInfo discussionInfo) {
                    }
                });
            } else {
                String extension = discussionNotificationMessage.getExtension();
                if (!TextUtils.isEmpty(extension)) {
                    for (String str : extension.split(",")) {
                        this.nativeObj.RemoveMemberFromDiscussionSync(message2.getTargetId(), str);
                    }
                }
            }
        }
        if (message2.getContent() instanceof LogCmdMessage) {
            RtLogUploadManager.getInstance().createFullUploadTask(message2);
        }
        if (!(message2.getContent() instanceof MessageExpansionMessage)) {
            if (onReceiveMessageListener != null) {
                onReceiveMessageListener.onReceived(message2, i, z, z2, i2);
            }
        } else {
            Handler handler = this.mWorkHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.rong.imlib.NativeClient.37
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeClient.this.handleExpansionMsg(message2);
                    }
                });
            }
        }
    }

    private void initThreadPool() {
        this.executorService = new ScheduledThreadPoolExecutor(1, threadFactory("Get ChatRoomEntry", false));
        this.executorService.setKeepAliveTime(60L, TimeUnit.SECONDS);
        this.executorService.allowCoreThreadTimeOut(true);
        this.receiveMessageExecutor = Executors.newSingleThreadExecutor(threadFactory("IPC_RECEIVEMSG_WORK", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSendMessage(Message message, String str, String str2, String[] strArr, ISendMessageCallback<Message> iSendMessageCallback, MessageTag messageTag, byte[] bArr, int i, boolean z, boolean z2, String str3) {
        internalSendMessage(message, str, str2, strArr, iSendMessageCallback, messageTag, bArr, i, z, false, false, z2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMentionedMessage(Message message) {
        return (message.getContent() instanceof TextMessage) && ((TextMessage) message.getContent()).getMentionedInfo() != null;
    }

    private boolean judgeExpansionExceedLimit(Map<String, String> map, NativeObject.Message message) {
        Set<String> setKeySet = JSONUtils.jsonToExpansionEx(message.getExtMsg()).keySet();
        if (map.size() > 20 || setKeySet.size() > 300) {
            return true;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = setKeySet.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getKey().toString());
            if (hashSet.size() > 300) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageContent newMessageContent(String str, byte[] bArr) {
        Constructor<? extends MessageContent> constructor = this.messageContentConstructorMap.get(str);
        if (constructor == null || bArr == null) {
            FwLog.write(1, 1, FwLog.LogTag.L_DECODE_MSG_E.getTag(), "msg_type", str);
            return new UnknownMessage(bArr);
        }
        try {
            return constructor.newInstance(bArr);
        } catch (Exception e2) {
            UnknownMessage unknownMessage = new UnknownMessage(bArr);
            FwLog.write(1, 1, FwLog.LogTag.L_DECODE_MSG_E.getTag(), "msg_type|stacks", str, FwLog.stackToString(e2));
            return unknownMessage;
        }
    }

    private void preCheck(Object... objArr) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null || ((obj instanceof String) && TextUtils.isEmpty((String) obj))) {
                throw new IllegalArgumentException("参数异常");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeKeysInExpansionEx(long j, boolean z, List<String> list, Message message, OperationCallback operationCallback) {
        NativeObject.Message messageGetMessageByUId = this.nativeObj.GetMessageByUId(message.getUId());
        List<Object> listRemoveKeysInExpansionEx = j == -1 ? JSONUtils.removeKeysInExpansionEx(list, JSONUtils.jsonToExpansionEx(messageGetMessageByUId.getExtMsg())) : JSONUtils.removeKeysTSInExpansionEx(j, list, JSONUtils.jsonToExpansionEx(messageGetMessageByUId.getExtMsg()));
        HashMap map = (HashMap) listRemoveKeysInExpansionEx.get(0);
        List<String> list2 = (List) listRemoveKeysInExpansionEx.get(1);
        String strExMapToJson = JSONUtils.exMapToJson(map);
        boolean messageExpansion = setMessageExpansion(message.getTargetId(), message.getConversationType().getValue(), message.getUId(), strExMapToJson);
        if (operationCallback != null) {
            if (messageExpansion) {
                operationCallback.onSuccess();
            } else {
                operationCallback.onError(RongIMClient.ErrorCode.RC_MESSAGE_EXPAND_FAIL.getValue());
            }
        }
        if (messageExpansionListener == null || list2.size() == 0 || !z) {
            return;
        }
        try {
            message.setExpansion(JSONUtils.expansionExJSONToMap(strExMapToJson));
            messageExpansionListener.onMessageExpansionRemove(list2, message);
        } catch (RemoteException e2) {
            RLog.e(TAG, e2.toString());
        }
    }

    private Conversation renderConversationFromNative(NativeObject.Conversation conversation) {
        Conversation conversation2 = new Conversation();
        conversation2.setTargetId(conversation.getTargetId());
        conversation2.setLatestMessageId((int) conversation.getMessageId());
        conversation2.setConversationTitle(conversation.getConversationTitle());
        conversation2.setUnreadMessageCount(conversation.getUnreadMessageCount());
        conversation2.setConversationType(Conversation.ConversationType.setValue(conversation.getConversationType()));
        conversation2.setTop(conversation.isTop());
        conversation2.setObjectName(conversation.getObjectName());
        if (conversation.getMessageId() > 0) {
            Message message = new Message();
            message.setMessageId((int) conversation.getMessageId());
            message.setSenderUserId(conversation.getSenderUserId());
            conversation2.setLatestMessage(renderMessageContent(conversation.getObjectName(), conversation.getContent(), message));
        }
        conversation2.setReceivedStatus(new Message.ReceivedStatus(conversation.getReadStatus()));
        conversation2.setReceivedTime(conversation.getReceivedTime());
        conversation2.setSentTime(conversation.getSentTime());
        conversation2.setSenderUserId(conversation.getSenderUserId());
        conversation2.setSentStatus(Message.SentStatus.setValue(conversation.getSentStatus()));
        conversation2.setSenderUserName(conversation.getSenderName());
        conversation2.setDraft(conversation.getDraft());
        conversation2.setPortraitUrl(conversation.getPortraitUrl());
        conversation2.setNotificationStatus(conversation.isBlockPush() ? Conversation.ConversationNotificationStatus.DO_NOT_DISTURB : Conversation.ConversationNotificationStatus.NOTIFY);
        conversation2.setMentionedCount(conversation.getMentionCount());
        return conversation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageContent renderMessageContent(String str, byte[] bArr, Message message) {
        MessageContent messageContentNewMessageContent = newMessageContent(str, bArr);
        if (messageContentNewMessageContent instanceof UnknownMessage) {
            return messageContentNewMessageContent;
        }
        MessageHandler messageHandler = getMessageHandler(str);
        if (messageHandler != null) {
            messageHandler.decodeMessage(message, messageContentNewMessageContent);
        } else {
            RLog.e(TAG, "renderMessageContent 该消息未注册，请调用registerMessageType方法注册。");
        }
        return messageContentNewMessageContent;
    }

    private String replaceNullStr(String str) {
        return str == null ? "" : str;
    }

    private void setChatRoomStatusNotificationListener() {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.SetChatRoomStatusNotificationListener(new NativeObject.StatusNotificationListener() { // from class: io.rong.imlib.NativeClient.77
            @Override // io.rong.imlib.NativeObject.StatusNotificationListener
            public void OnKVChanged(ChatroomStatus[] chatroomStatusArr) {
                if (chatroomStatusArr != null) {
                    RLog.d(NativeClient.TAG, "OnKVChanged changeInfo: " + Arrays.toString(chatroomStatusArr));
                    if (NativeClient.this.mKVStatusListener != null) {
                        HashMap map = new HashMap();
                        HashMap map2 = new HashMap();
                        for (ChatroomStatus chatroomStatus : chatroomStatusArr) {
                            if (chatroomStatus.getIsDelete()) {
                                map2.put(chatroomStatus.getKey(), chatroomStatus.getValue());
                            } else {
                                map.put(chatroomStatus.getKey(), chatroomStatus.getValue());
                            }
                        }
                        String roomId = chatroomStatusArr[0].getRoomId();
                        if (map.size() > 0) {
                            NativeClient.this.mKVStatusListener.onChatRoomKVStatusChange(roomId, map);
                        }
                        if (map2.size() > 0) {
                            NativeClient.this.mKVStatusListener.onChatRoomKVStatusRemove(roomId, map2);
                        }
                    }
                }
            }

            @Override // io.rong.imlib.NativeObject.StatusNotificationListener
            public void OnStatusChanged(final String str) {
                NativeClient.this.chatRoomStatusMap.put(str, true);
                if (NativeClient.this.mKVStatusListener != null) {
                    NativeClient.this.mKVStatusListener.onChatRoomKVStatusSync(str);
                }
                NativeClient.this.getAllChatRoomStatus(str, new IResultCallback<HashMap<String, String>>() { // from class: io.rong.imlib.NativeClient.77.1
                    @Override // io.rong.imlib.NativeClient.IResultCallback
                    public void onError(int i) {
                        RLog.d(NativeClient.TAG, "OnKVChanged sync error: " + i);
                    }

                    @Override // io.rong.imlib.NativeClient.IResultCallback
                    public void onSuccess(HashMap<String, String> map) {
                        if (NativeClient.this.mKVStatusListener == null || map == null) {
                            return;
                        }
                        RLog.d(NativeClient.TAG, "OnKVChanged changeInfo: " + map);
                        NativeClient.this.mKVStatusListener.onChatRoomKVStatusChange(str, map);
                    }
                });
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:33|3)|(1:5)(11:6|(1:8)|31|11|(1:13)(1:15)|16|22|(1:24)(1:25)|(1:27)(1:28)|29|30)|10|31|11|(0)(0)|16|22|(0)(0)|(0)(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        io.rong.common.rlog.RLog.e(io.rong.imlib.NativeClient.TAG, "setEnvInfo SecurityException", r11);
        r9 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: SecurityException -> 0x0032, TRY_LEAVE, TryCatch #0 {SecurityException -> 0x0032, blocks: (B:11:0x0020, B:13:0x002a), top: B:31:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setEnvInfo(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "NativeClient"
            java.lang.String r1 = ""
            java.lang.String r2 = "connectivity"
            java.lang.Object r2 = r11.getSystemService(r2)     // Catch: java.lang.SecurityException -> L34
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.SecurityException -> L34
            if (r2 != 0) goto L14
            java.lang.String r2 = "connectivityManager is null"
            io.rong.common.rlog.RLog.e(r0, r2)     // Catch: java.lang.SecurityException -> L34
            goto L1f
        L14:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L34
            if (r2 == 0) goto L1f
            java.lang.String r2 = r2.getTypeName()     // Catch: java.lang.SecurityException -> L34
            goto L20
        L1f:
            r2 = r1
        L20:
            java.lang.String r3 = "phone"
            java.lang.Object r11 = r11.getSystemService(r3)     // Catch: java.lang.SecurityException -> L32
            android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11     // Catch: java.lang.SecurityException -> L32
            if (r11 == 0) goto L2f
            java.lang.String r11 = r11.getNetworkOperator()     // Catch: java.lang.SecurityException -> L32
            goto L30
        L2f:
            r11 = r1
        L30:
            r9 = r11
            goto L3c
        L32:
            r11 = move-exception
            goto L36
        L34:
            r11 = move-exception
            r2 = r1
        L36:
            java.lang.String r3 = "setEnvInfo SecurityException"
            io.rong.common.rlog.RLog.e(r0, r3, r11)
            r9 = r1
        L3c:
            r8 = r2
            java.lang.String r11 = android.os.Build.MANUFACTURER
            java.lang.String r0 = android.os.Build.MODEL
            if (r11 != 0) goto L45
            r5 = r1
            goto L46
        L45:
            r5 = r11
        L46:
            if (r0 != 0) goto L4a
            r6 = r1
            goto L4b
        L4a:
            r6 = r0
        L4b:
            io.rong.imlib.NativeObject r4 = r10.nativeObj
            int r11 = android.os.Build.VERSION.SDK_INT
            java.lang.String r7 = java.lang.String.valueOf(r11)
            r4.SetDeviceInfo(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.NativeClient.setEnvInfo(android.content.Context):void");
    }

    private void setLogStatus(int i, NativeObject.NativeLogInfoListener nativeLogInfoListener) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.SetLogStatus(i, nativeLogInfoListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setMessageExpansion(String str, int i, String str2, String str3) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject != null) {
            return nativeObject.SetExtraMessageAttribute(str, i, str2, str3);
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    private ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: io.rong.imlib.NativeClient.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    private long timeDisposal(Message message) {
        return message.getSentTime() - 1596211200000L;
    }

    public void SetPushNotificationListener(PushNotificationListener pushNotificationListener) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.SetPushNotificationListener(pushNotificationListener);
    }

    public void addMemberToDiscussion(String str, List<String> list, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            throw new IllegalArgumentException("discussionId 或 userIdList 参数异常。");
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        this.nativeObj.InviteMemberToDiscussion(str, strArr, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.21
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public void addToBlacklist(String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || operationCallback == null) {
            throw new IllegalArgumentException("参数异常。");
        }
        this.nativeObj.AddToBlacklist(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.45
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i == 0) {
                    operationCallback.onSuccess();
                } else {
                    operationCallback.onError(i);
                }
            }
        });
    }

    public void cleanHistoryMessages(Conversation.ConversationType conversationType, String str, long j, OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        boolean zCleanHistoryMessages = this.nativeObj.CleanHistoryMessages(conversationType.getValue(), str, j);
        if (operationCallback != null) {
            if (zCleanHistoryMessages) {
                operationCallback.onSuccess();
            } else {
                operationCallback.onError(-1);
            }
        }
    }

    public void cleanRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, long j, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        this.nativeObj.CleanRemoteHistoryMessage(conversationType.getValue(), str, j, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.14
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j2) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public boolean clearConversations(Conversation.ConversationType... conversationTypeArr) throws IllegalAccessException {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationTypeArr == null || conversationTypeArr.length == 0) {
            throw new IllegalAccessException("ConversationTypes 参数异常。");
        }
        int[] iArr = new int[conversationTypeArr.length];
        int i = 0;
        for (Conversation.ConversationType conversationType : conversationTypeArr) {
            iArr[i] = conversationType.getValue();
            i++;
        }
        return this.nativeObj.ClearConversations(iArr);
    }

    public boolean clearEncryptedConversations() {
        preCheck(new Object[0]);
        return this.nativeObj.ClearEncryptedConversations();
    }

    public boolean clearMessages(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        return this.nativeObj.ClearMessages(conversationType.getValue(), str, false);
    }

    public boolean clearMessagesUnreadStatus(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        return this.nativeObj.ClearUnread(conversationType.getValue(), str);
    }

    public boolean clearTextMessageDraft(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        if (TextUtils.isEmpty(getTextMessageDraft(conversationType, str))) {
            return true;
        }
        return saveTextMessageDraft(conversationType, str, "");
    }

    public boolean clearUnreadByReceipt(int i, String str, long j) {
        return this.nativeObj.ClearUnreadByReceipt(str, i, j);
    }

    void connect(String str, boolean z, boolean z2, IConnectResultCallback<String> iConnectResultCallback) {
        setEnvInfo(mContext);
        RtLogUploadManager.getInstance().startTimingUploadTask();
        ConnectionService.getInstance().connect(str, z, z2, iConnectResultCallback);
    }

    public void createDiscussion(String str, List<String> list, final IResultCallback<String> iResultCallback) {
        if (!TextUtils.isEmpty(this.curUserId)) {
            list.remove(this.curUserId);
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        this.nativeObj.CreateInviteDiscussion(str, strArr, new NativeObject.CreateDiscussionCallback() { // from class: io.rong.imlib.NativeClient.18
            @Override // io.rong.imlib.NativeObject.CreateDiscussionCallback
            public void OnError(int i) {
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(i);
                }
            }

            @Override // io.rong.imlib.NativeObject.CreateDiscussionCallback
            public void OnSuccess(String str2) {
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onSuccess(str2);
                }
            }
        });
    }

    public boolean createEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) {
        preCheck(str, rCEncryptedSession);
        return this.nativeObj.CreateEncryptedConversation(replaceNullStr(str), replaceNullStr(rCEncryptedSession.getTargetId()), replaceNullStr(rCEncryptedSession.getRemoteEncId()), replaceNullStr(rCEncryptedSession.getEncKey()), replaceNullStr(rCEncryptedSession.getEncXA()), rCEncryptedSession.getEncStatus());
    }

    public void deleteChatRoomEntry(String str, String str2, String str3, Boolean bool, String str4, boolean z, boolean z2, final OperationCallback operationCallback) {
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        if (!NavigationCacheHelper.isKvStorageEnabled(mContext) && operationCallback != null) {
            operationCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_AVAILABLE.getValue());
            return;
        }
        NativeObject.StatusData statusData = new NativeObject.StatusData();
        statusData.setKey(str);
        statusData.setValue(str2);
        statusData.setAutoDelete(z);
        statusData.setOverwrite(z2);
        NativeObject.StatusNotification statusNotification = new NativeObject.StatusNotification();
        statusNotification.setAttributeFlag(0);
        statusNotification.setConversationType(Conversation.ConversationType.CHATROOM.getValue());
        statusNotification.setMessageContent(new String(ChatRoomKVNotiMessage.obtain(str, str2, 2, str4).encode()));
        statusNotification.setNotifyAll(bool.booleanValue());
        statusNotification.setObjectName(((MessageTag) ChatRoomKVNotiMessage.class.getAnnotation(MessageTag.class)).value());
        this.nativeObj.DeleteChatRoomStatus(str3, statusData, statusNotification, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.74
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str5, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i);
                    }
                }
            }
        });
    }

    public boolean deleteMessage(Conversation.ConversationType conversationType, String str) {
        return this.nativeObj.ClearMessages(conversationType.getValue(), str, true);
    }

    public boolean deleteMessages(int[] iArr) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        int length = iArr.length;
        if (iArr == null || length == 0) {
            throw new IllegalArgumentException("MessageIds 参数异常。");
        }
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = iArr[i];
        }
        return this.nativeObj.DeleteMessages(jArr);
    }

    public void disconnect() {
        disconnect(true);
    }

    public void downloadMedia(Conversation.ConversationType conversationType, String str, int i, final String str2, final IResultProgressCallback<String> iResultProgressCallback) {
        if (conversationType == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("conversationType，imageUrl 或 targetId 参数异常。");
        }
        String cachePath = FileUtils.getCachePath(mContext, "download");
        String fileName = FtUtilities.getFileName(cachePath, DeviceUtils.ShortMD5(2, str2));
        final FtConst.MimeType mimeType = FtUtilities.getMimeType(fileName);
        final Date date = new Date(System.currentTimeMillis());
        MediaDownloadEngine.getInstance().setMediaPath(cachePath);
        MediaDownloadEngine.getInstance().download(-1, str2, 0L, new RequestOption(fileName, FtConst.MimeType.setValue(i), new RequestCallBack() { // from class: io.rong.imlib.NativeClient.28
            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onCanceled(Object obj) {
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), true, 0, str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), 0);
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onComplete(String str3) {
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), false, Long.valueOf(new File(str3).length() / 1024), str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), 0);
                RLog.d(NativeClient.TAG, "downloadMedia onComplete fileUri =" + str3);
                iResultProgressCallback.onSuccess(str3);
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onError(int i2) {
                FwLog.write(1, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), false, 0, str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), Integer.valueOf(i2));
                RLog.d(NativeClient.TAG, "downloadMedia onError code =" + i2);
                iResultProgressCallback.onError(i2);
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onProgress(int i2) {
                iResultProgressCallback.onProgress(i2);
            }
        }));
    }

    public void downloadMediaFile(String str, final String str2, String str3, String str4, final IDownloadMediaFileCallback<Boolean> iDownloadMediaFileCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        final FtConst.MimeType mimeType = FtUtilities.getMimeType(str3);
        final Date date = new Date(System.currentTimeMillis());
        String fileName = FtUtilities.getFileName(str4, str3);
        if (!new File(FileUtils.getTempFilePath(mContext, str)).exists()) {
            try {
                String strSubstring = fileName.substring(str4.length() + 1);
                if (!strSubstring.equals(str3)) {
                    iDownloadMediaFileCallback.onFileNameChanged(strSubstring);
                }
            } catch (Exception e2) {
                RLog.e(TAG, "downloadMediaFile", e2);
            }
        }
        MediaDownloadEngine.getInstance().setMediaPath(fileName);
        MediaDownloadEngine.getInstance().download(str, str2, new RequestOption(fileName, mimeType, new RequestCallBack() { // from class: io.rong.imlib.NativeClient.30
            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onCanceled(Object obj) {
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), true, 0, str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), 0);
                iDownloadMediaFileCallback.onCanceled();
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onComplete(String str5) {
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), false, Long.valueOf(new File(str5).length() / 1024), str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), 0);
                RLog.d(NativeClient.TAG, "downloadMediaMessage onComplete fileUri =" + str5);
                iDownloadMediaFileCallback.onSuccess(true);
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onError(int i) {
                FwLog.write(1, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "download", mimeType.getName(), false, 0, str2, Long.valueOf(new Date(System.currentTimeMillis()).getTime() - date.getTime()), Integer.valueOf(i));
                RLog.d(NativeClient.TAG, "downloadMediaMessage onError code =" + i);
                iDownloadMediaFileCallback.onError(i);
            }

            @Override // io.rong.imlib.filetransfer.RequestCallBack
            public void onProgress(int i) {
                RLog.i(NativeClient.TAG, "download onProgress " + i);
                iDownloadMediaFileCallback.onProgress(i);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void downloadMediaMessage(final io.rong.imlib.model.Message r19, final io.rong.imlib.NativeClient.IDownloadMediaMessageCallback<io.rong.imlib.model.Message> r20) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.NativeClient.downloadMediaMessage(io.rong.imlib.model.Message, io.rong.imlib.NativeClient$IDownloadMediaMessageCallback):void");
    }

    public void exitRTCRoom(final String str, final OperationCallback operationCallback) {
        FwLog.write(3, 2, "P-leaveRoom-T", "roomId", str);
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-leaveRoom-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.ExitRTCRoom(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.57
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i == 0) {
                    FwLog.write(3, 2, "P-leaveRoom-R", "roomId|code", str, Integer.valueOf(i));
                } else {
                    FwLog.write(1, 2, "P-leaveRoom-E", "roomId|code", str, Integer.valueOf(i));
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i);
                    }
                }
            }
        });
    }

    void getAllChatRoomStatus(final String str, final IResultCallback<HashMap<String, String>> iResultCallback) {
        this.executorService.submit(new Runnable() { // from class: io.rong.imlib.NativeClient.76
            @Override // java.lang.Runnable
            public void run() {
                if (!NavigationCacheHelper.isKvStorageEnabled(NativeClient.mContext)) {
                    iResultCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_AVAILABLE.getValue());
                    return;
                }
                if (NativeClient.this.chatRoomStatusMap.get(str) == null) {
                    iResultCallback.onError(RongIMClient.ErrorCode.NOT_IN_CHATROOM.getValue());
                } else if (!((Boolean) NativeClient.this.chatRoomStatusMap.get(str)).booleanValue()) {
                    iResultCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_SYNC.getValue());
                } else {
                    iResultCallback.onSuccess(NativeClient.this.nativeObj.GetChatRoomStatus(str));
                }
            }
        });
    }

    public List<RCEncryptedSession> getAllEncryptedConversations() {
        preCheck(new Object[0]);
        return this.nativeObj.GetEncryptedConversations();
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void getBlacklist(final IResultCallback<String> iResultCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (iResultCallback == null) {
            throw new IllegalArgumentException("参数异常。");
        }
        nativeObject.GetBlacklist(new NativeObject.SetBlacklistListener() { // from class: io.rong.imlib.NativeClient.49
            @Override // io.rong.imlib.NativeObject.SetBlacklistListener
            public void OnError(int i) {
                iResultCallback.onError(i);
            }

            @Override // io.rong.imlib.NativeObject.SetBlacklistListener
            public void OnSuccess(String str) {
                if (TextUtils.isEmpty(str)) {
                    iResultCallback.onSuccess(null);
                } else {
                    iResultCallback.onSuccess(str);
                }
            }
        });
    }

    public void getBlacklistStatus(String str, final IResultCallback<BlacklistStatus> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || iResultCallback == null) {
            throw new IllegalArgumentException("用户 Id 参数异常。");
        }
        this.nativeObj.GetBlacklistStatus(str, new NativeObject.BizAckListener() { // from class: io.rong.imlib.NativeClient.48
            @Override // io.rong.imlib.NativeObject.BizAckListener
            public void operationComplete(int i, int i2) {
                if (i != 0) {
                    iResultCallback.onError(i);
                } else if (i2 == 0) {
                    iResultCallback.onSuccess(BlacklistStatus.EXIT_BLACK_LIST);
                } else if (i2 == 101) {
                    iResultCallback.onSuccess(BlacklistStatus.NOT_EXIT_BLACK_LIST);
                }
            }
        });
    }

    public List<Conversation> getBlockedConversationList(int[] iArr) {
        NativeObject.Conversation[] conversationArrGetBlockedConversations = this.nativeObj.GetBlockedConversations(iArr);
        if (conversationArrGetBlockedConversations == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeObject.Conversation conversation : conversationArrGetBlockedConversations) {
            arrayList.add(renderConversationFromNative(conversation));
        }
        return arrayList;
    }

    void getChatRoomStatusByKey(final String str, final String str2, final IResultCallback<String> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (iResultCallback == null) {
            return;
        }
        this.executorService.submit(new Runnable() { // from class: io.rong.imlib.NativeClient.75
            @Override // java.lang.Runnable
            public void run() {
                if (!NavigationCacheHelper.isKvStorageEnabled(NativeClient.mContext)) {
                    iResultCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_AVAILABLE.getValue());
                    return;
                }
                if (NativeClient.this.chatRoomStatusMap.get(str) == null) {
                    iResultCallback.onError(RongIMClient.ErrorCode.NOT_IN_CHATROOM.getValue());
                    return;
                }
                if (!((Boolean) NativeClient.this.chatRoomStatusMap.get(str)).booleanValue()) {
                    iResultCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_SYNC.getValue());
                    return;
                }
                String strGetChatRoomStatusByKey = NativeClient.this.nativeObj.GetChatRoomStatusByKey(str, str2);
                if (TextUtils.isEmpty(strGetChatRoomStatusByKey)) {
                    iResultCallback.onError(RongIMClient.ErrorCode.KEY_NOT_EXIST.getValue());
                } else {
                    iResultCallback.onSuccess(strGetChatRoomStatusByKey);
                }
            }
        });
    }

    public void getChatroomHistoryMessages(String str, long j, int i, int i2, final IResultCallbackEx<List<Message>, Long> iResultCallbackEx) {
        RLog.i(TAG, "getChatroomHistoryMessages");
        if (NavigationClient.getInstance().isChatroomHistoryEnabled(mContext)) {
            this.nativeObj.GetChatroomHistoryMessage(str, j, i, i2, new NativeObject.HistoryMessageListener() { // from class: io.rong.imlib.NativeClient.7
                @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                public void onError(int i3) {
                    iResultCallbackEx.onError(i3);
                }

                @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                public void onReceived(NativeObject.Message[] messageArr, long j2) {
                    ArrayList arrayList = new ArrayList();
                    if (messageArr != null && messageArr.length > 0) {
                        for (NativeObject.Message message : messageArr) {
                            Message message2 = new Message(message);
                            message2.setContent(NativeClient.this.renderMessageContent(message.getObjectName(), message.getContent(), message2));
                            arrayList.add(message2);
                        }
                    }
                    iResultCallbackEx.onSuccess(arrayList, Long.valueOf(j2));
                }
            });
        } else {
            iResultCallbackEx.onError(23414);
        }
    }

    public Conversation getConversation(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ConversationType 和 TargetId 参数异常");
        }
        NativeObject.Conversation conversationGetConversationEx = this.nativeObj.GetConversationEx(str, conversationType.getValue());
        if (conversationGetConversationEx == null) {
            return null;
        }
        Conversation conversationRenderConversationFromNative = renderConversationFromNative(conversationGetConversationEx);
        conversationRenderConversationFromNative.setConversationType(conversationType);
        return conversationRenderConversationFromNative;
    }

    public List<Conversation> getConversationList() {
        int[] iArr = {Conversation.ConversationType.PRIVATE.getValue(), Conversation.ConversationType.DISCUSSION.getValue(), Conversation.ConversationType.GROUP.getValue(), Conversation.ConversationType.SYSTEM.getValue()};
        if (this.nativeObj != null) {
            return getConversationList(iArr);
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public List<Conversation> getConversationListByPage(int[] iArr, long j, int i) {
        NativeObject.Conversation[] conversationArrGetConversationList;
        try {
            conversationArrGetConversationList = this.nativeObj.GetConversationList(iArr, j, i);
        } catch (Exception e2) {
            RLog.e(TAG, "getConversationListByPage Exception", e2);
            conversationArrGetConversationList = null;
        }
        if (conversationArrGetConversationList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeObject.Conversation conversation : conversationArrGetConversationList) {
            arrayList.add(renderConversationFromNative(conversation));
        }
        return arrayList;
    }

    public void getConversationNotificationStatus(Conversation.ConversationType conversationType, String str, IResultCallback<Integer> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str) || iResultCallback == null) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        iResultCallback.onSuccess(Integer.valueOf((this.nativeObj.GetBlockPush(str, conversationType.getValue()) == 100 ? Conversation.ConversationNotificationStatus.DO_NOT_DISTURB : Conversation.ConversationNotificationStatus.NOTIFY).getValue()));
    }

    public String getCurrentUserId() {
        if (!TextUtils.isEmpty(this.curUserId)) {
            return this.curUserId;
        }
        String userId = NavigationClient.getInstance().getUserId(mContext);
        this.curUserId = userId;
        return userId;
    }

    public long getDeltaTime() {
        return this.nativeObj.GetDeltaTime();
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void getDiscussion(String str, final IResultCallback<Discussion> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(" discussionId 参数异常。");
        }
        NativeObject.DiscussionInfo discussionInfoGetDiscussionInfoSync = this.nativeObj.GetDiscussionInfoSync(str);
        if (discussionInfoGetDiscussionInfoSync == null) {
            this.nativeObj.GetDiscussionInfo(str, new NativeObject.DiscussionInfoListener() { // from class: io.rong.imlib.NativeClient.16
                @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                public void OnError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        iResultCallback2.onError(i);
                    }
                }

                @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                public void onReceived(NativeObject.DiscussionInfo discussionInfo) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        iResultCallback2.onSuccess(new Discussion(discussionInfo));
                    }
                }
            });
            return;
        }
        Discussion discussion = new Discussion(discussionInfoGetDiscussionInfoSync);
        if (discussion.getMemberIdList() == null || discussion.getMemberIdList().size() == 0) {
            this.nativeObj.GetDiscussionInfo(str, new NativeObject.DiscussionInfoListener() { // from class: io.rong.imlib.NativeClient.15
                @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                public void OnError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        iResultCallback2.onError(i);
                    }
                }

                @Override // io.rong.imlib.NativeObject.DiscussionInfoListener
                public void onReceived(NativeObject.DiscussionInfo discussionInfo) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        iResultCallback2.onSuccess(new Discussion(discussionInfo));
                    }
                }
            });
        } else if (iResultCallback != null) {
            iResultCallback.onSuccess(discussion);
        }
    }

    public RCEncryptedSession getEncryptedConversation(String str) {
        preCheck(str);
        RCEncryptedSession rCEncryptedSessionGetEncryptedConversationInfo = this.nativeObj.GetEncryptedConversationInfo(str);
        StringBuilder sb = new StringBuilder();
        sb.append("getEncryptedConversation --> ");
        sb.append(rCEncryptedSessionGetEncryptedConversationInfo == null ? "null" : rCEncryptedSessionGetEncryptedConversationInfo.toString());
        RLog.d(TAG, sb.toString());
        return rCEncryptedSessionGetEncryptedConversationInfo;
    }

    public int getGIFLimitSize() {
        return NavigationCacheHelper.getGifSizeLimit(mContext);
    }

    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, int i, int i2) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ConversationTypes 或 targetId 参数异常。");
        }
        NativeObject.Message[] messageArrGetHistoryMessagesEx = this.nativeObj.GetHistoryMessagesEx(str.trim(), conversationType.getValue(), "", i, i2, true);
        ArrayList arrayList = new ArrayList();
        if (messageArrGetHistoryMessagesEx == null) {
            return arrayList;
        }
        for (NativeObject.Message message : messageArrGetHistoryMessagesEx) {
            Message message2 = new Message(message);
            message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
            arrayList.add(message2);
        }
        return arrayList;
    }

    public List<Message> getLatestMessages(Conversation.ConversationType conversationType, String str, int i) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ConversationTypes 或 targetId 参数异常。");
        }
        return getHistoryMessages(conversationType, str.trim(), -1, i);
    }

    List<Message> getMatchedMessages(String str, Conversation.ConversationType conversationType, long j, int i, int i2) {
        NativeObject.Message[] messageArrGetMatchedMessages = this.nativeObj.GetMatchedMessages(str, conversationType.getValue(), j, i, i2);
        ArrayList arrayList = new ArrayList();
        if (messageArrGetMatchedMessages != null) {
            for (NativeObject.Message message : messageArrGetMatchedMessages) {
                Message message2 = new Message(message);
                message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                arrayList.add(message2);
            }
        }
        return arrayList;
    }

    public Message getMessage(int i) {
        NativeObject.Message messageGetMessageById = this.nativeObj.GetMessageById(i);
        if (messageGetMessageById == null) {
            return null;
        }
        Message message = new Message(messageGetMessageById);
        message.setContent(renderMessageContent(messageGetMessageById.getObjectName(), messageGetMessageById.getContent(), message));
        return message;
    }

    public Message getMessageByUid(String str) {
        NativeObject.Message messageGetMessageByUId = this.nativeObj.GetMessageByUId(str);
        if (messageGetMessageByUId == null) {
            return null;
        }
        Message message = new Message(messageGetMessageByUId);
        message.setContent(renderMessageContent(messageGetMessageByUId.getObjectName(), messageGetMessageByUId.getContent(), message));
        return message;
    }

    public int getMessageCount(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || conversationType == null) {
            throw new IllegalArgumentException("ConversationType 或 TargetId 参数异常");
        }
        return this.nativeObj.GetMessageCount(str, conversationType.getValue());
    }

    public void getNotificationQuietHours(final GetNotificationQuietHoursCallback getNotificationQuietHoursCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (getNotificationQuietHoursCallback == null) {
            throw new IllegalArgumentException("参数异常。");
        }
        nativeObject.QueryPushSetting(new NativeObject.PushSettingListener() { // from class: io.rong.imlib.NativeClient.52
            @Override // io.rong.imlib.NativeObject.PushSettingListener
            public void OnError(int i) {
                getNotificationQuietHoursCallback.onError(i);
            }

            @Override // io.rong.imlib.NativeObject.PushSettingListener
            public void OnSuccess(String str, int i) {
                getNotificationQuietHoursCallback.onSuccess(str, i);
            }
        });
    }

    String getOffLineLogServer() {
        return NavigationCacheHelper.getOfflineLogServer(mContext);
    }

    public String getOfflineMessageDuration() {
        return this.nativeObj.GetOfflineMessageDuration();
    }

    public void getPublicServiceList(IResultCallback<PublicServiceProfileList> iResultCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("RongIMClient 尚未初始化!");
        }
        if (iResultCallback != null) {
            NativeObject.AccountInfo[] accountInfoArrLoadAccountInfo = nativeObject.LoadAccountInfo();
            if (accountInfoArrLoadAccountInfo == null || accountInfoArrLoadAccountInfo.length <= 0) {
                RLog.e(TAG, "Public service list is empty");
                iResultCallback.onSuccess(new PublicServiceProfileList((ArrayList<PublicServiceProfile>) new ArrayList()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeObject.AccountInfo accountInfo : accountInfoArrLoadAccountInfo) {
                PublicServiceProfile publicServiceProfile = new PublicServiceProfile();
                publicServiceProfile.setTargetId(new String(accountInfo.getAccountId()));
                publicServiceProfile.setName(new String(accountInfo.getAccountName()));
                publicServiceProfile.setPublicServiceType(Conversation.ConversationType.setValue(accountInfo.getAccountType()));
                publicServiceProfile.setPortraitUri(Uri.parse(new String(accountInfo.getAccountUri())));
                publicServiceProfile.setExtra(new String(accountInfo.getExtra()));
                arrayList.add(publicServiceProfile);
            }
            iResultCallback.onSuccess(new PublicServiceProfileList((ArrayList<PublicServiceProfile>) arrayList));
        }
    }

    public void getPublicServiceProfile(String str, int i, IResultCallback<PublicServiceProfile> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("RongIMClient 尚未初始化!");
        }
        if (str == null) {
            throw new IllegalArgumentException("targetId 参数异常。");
        }
        if (iResultCallback != null) {
            PublicServiceProfile publicServiceProfile = new PublicServiceProfile();
            NativeObject.UserInfo userInfoGetUserInfoExSync = this.nativeObj.GetUserInfoExSync(str, i);
            if (userInfoGetUserInfoExSync == null) {
                RLog.e(TAG, "Public service info is null");
                iResultCallback.onError(RongIMClient.ErrorCode.RC_PUBLIC_SERVICE_PROFILE_NOT_EXIST.getValue());
                return;
            }
            publicServiceProfile.setTargetId(str);
            publicServiceProfile.setName(userInfoGetUserInfoExSync.getUserName());
            if (userInfoGetUserInfoExSync.getUrl() != null) {
                publicServiceProfile.setPortraitUri(Uri.parse(userInfoGetUserInfoExSync.getUrl()));
            }
            publicServiceProfile.setPublicServiceType(Conversation.ConversationType.setValue(userInfoGetUserInfoExSync.getCategoryId()));
            publicServiceProfile.setExtra(userInfoGetUserInfoExSync.getAccountExtra());
            iResultCallback.onSuccess(publicServiceProfile);
        }
    }

    public String getPushSetting(int i) {
        return this.nativeObj.GetPushSetting(i);
    }

    public void getRTCConfig(String str, String str2, long j, String str3, final NativeObject.RTCConfigListener rTCConfigListener) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.GetRTCConfig(str, str2, j, str3, new NativeObject.RTCConfigListener() { // from class: io.rong.imlib.NativeClient.68
            @Override // io.rong.imlib.NativeObject.RTCConfigListener
            public void onError(int i) {
                rTCConfigListener.onError(i);
            }

            @Override // io.rong.imlib.NativeObject.RTCConfigListener
            public void onSuccess(String str4, long j2) {
                rTCConfigListener.onSuccess(str4, j2);
            }
        });
    }

    public String getRTCProfile() {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject != null) {
            return nativeObject.GetRTCProfile();
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    void getRTCToken(String str, int i, int i2, final IResultCallback<String> iResultCallback) {
        FwLog.write(3, 2, "P-getRTCToken-T", "roomId|roomType|mediaType", str, Integer.valueOf(i), Integer.valueOf(i2));
        this.nativeObj.RTCGetToken(str, i, i2, new NativeObject.TokenListener() { // from class: io.rong.imlib.NativeClient.69
            @Override // io.rong.imlib.NativeObject.TokenListener
            public void OnError(int i3, String str2) {
                if (i3 == 0) {
                    FwLog.write(3, 2, "P-getRTCToken-R", "code|token", 0, str2);
                } else {
                    FwLog.write(1, 2, "P-getRTCToken-E", "code", Integer.valueOf(i3));
                }
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    if (i3 == 0) {
                        iResultCallback2.onSuccess(str2);
                    } else {
                        iResultCallback2.onError(i3);
                    }
                }
            }
        });
    }

    public void getRTCUserData(String str, int i, final IResultCallback<List<RTCUser>> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.GetRTCUserData(str, i, new NativeObject.RTCUserInfoListener() { // from class: io.rong.imlib.NativeClient.59
            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnError(int i2) {
                iResultCallback.onError(i2);
            }

            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnSuccess(RTCUser[] rTCUserArr, String str2, String str3) {
                iResultCallback.onSuccess(new ArrayList(Arrays.asList(rTCUserArr)));
            }
        });
    }

    public void getRTCUserDatas(String str, String[] strArr, final IResultCallback<List<RTCUser>> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.RTCGetUserData(str, strArr, new NativeObject.RTCUserInfoListener() { // from class: io.rong.imlib.NativeClient.72
            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnError(int i) {
                iResultCallback.onError(i);
            }

            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnSuccess(RTCUser[] rTCUserArr, String str2, String str3) {
                iResultCallback.onSuccess(new ArrayList(Arrays.asList(rTCUserArr)));
            }
        });
    }

    public void getRTCUsers(String str, int i, final IResultCallback<List<RTCUser>> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.GetRTCUsers(str, i, new NativeObject.RTCUserInfoListener() { // from class: io.rong.imlib.NativeClient.58
            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnError(int i2) {
                iResultCallback.onError(i2);
            }

            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnSuccess(RTCUser[] rTCUserArr, String str2, String str3) {
                iResultCallback.onSuccess(new ArrayList(Arrays.asList(rTCUserArr)));
            }
        });
    }

    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, long j, int i, final IResultCallback<List<Message>> iResultCallback) {
        RLog.i(TAG, "getRemoteHistoryMessages call");
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str) || iResultCallback == null) {
            throw new IllegalArgumentException("ConversationTypes，callback 或 targetId 参数异常。");
        }
        String strTrim = str.trim();
        if (NavigationClient.getInstance().isGetRemoteHistoryEnabled(mContext)) {
            this.nativeObj.LoadHistoryMessage(strTrim, conversationType.getValue(), j, i, new NativeObject.HistoryMessageListener() { // from class: io.rong.imlib.NativeClient.5
                @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                public void onError(int i2) {
                    iResultCallback.onError(i2);
                }

                @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                public void onReceived(NativeObject.Message[] messageArr, long j2) {
                    ArrayList arrayList = new ArrayList();
                    if (messageArr != null && messageArr.length > 0) {
                        for (NativeObject.Message message : messageArr) {
                            Message message2 = new Message(message);
                            message2.setContent(NativeClient.this.renderMessageContent(message.getObjectName(), message.getContent(), message2));
                            arrayList.add(message2);
                        }
                    }
                    iResultCallback.onSuccess(arrayList);
                }
            });
        } else {
            iResultCallback.onError(33007);
        }
    }

    public long getSendTimeByMessageId(int i) {
        return this.nativeObj.GetSendTimeByMessageId(i);
    }

    public String getTextMessageDraft(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        return this.nativeObj.GetTextMessageDraft(conversationType.getValue(), str);
    }

    public Message getTheFirstUnreadMessage(int i, String str) {
        NativeObject.Message messageGetTheFirstUnreadMessage = this.nativeObj.GetTheFirstUnreadMessage(i, str);
        if (messageGetTheFirstUnreadMessage == null) {
            return null;
        }
        Message message = new Message(messageGetTheFirstUnreadMessage);
        message.setContent(renderMessageContent(messageGetTheFirstUnreadMessage.getObjectName(), messageGetTheFirstUnreadMessage.getContent(), message));
        return message;
    }

    public String getToken() {
        return NavigationCacheHelper.getToken(mContext);
    }

    public List<Conversation> getTopConversationList(int[] iArr) {
        NativeObject.Conversation[] conversationArrGetTopConversations;
        try {
            conversationArrGetTopConversations = this.nativeObj.GetTopConversations(iArr);
        } catch (Exception e2) {
            RLog.e(TAG, "getTopConversationList Exception", e2);
            conversationArrGetTopConversations = null;
        }
        if (conversationArrGetTopConversations == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeObject.Conversation conversation : conversationArrGetTopConversations) {
            arrayList.add(renderConversationFromNative(conversation));
        }
        return arrayList;
    }

    public int getTotalUnreadCount() {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject != null) {
            return nativeObject.GetTotalUnreadCount();
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public int getUnreadCount(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || conversationType == null) {
            throw new IllegalArgumentException("ConversationType 或 TargetId 参数异常");
        }
        return this.nativeObj.GetUnreadCount(str, conversationType.getValue());
    }

    public List<Message> getUnreadMentionedMessages(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ConversationTypes 或 targetId 参数异常。");
        }
        NativeObject.Message[] messageArrGetMentionMessages = this.nativeObj.GetMentionMessages(str.trim(), conversationType.getValue());
        ArrayList arrayList = new ArrayList();
        if (messageArrGetMentionMessages == null) {
            return arrayList;
        }
        for (NativeObject.Message message : messageArrGetMentionMessages) {
            Message message2 = new Message(message);
            message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
            arrayList.add(message2);
        }
        return arrayList;
    }

    String getUploadConfigInfo() {
        return NavigationClient.getInstance().getUploadLogConfigInfo(mContext);
    }

    public void getUserStatus(String str, final IResultCallbackEx<String, Integer> iResultCallbackEx) {
        this.nativeObj.GetUserStatus(str, new NativeObject.CreateDiscussionCallback() { // from class: io.rong.imlib.NativeClient.8
            @Override // io.rong.imlib.NativeObject.CreateDiscussionCallback
            public void OnError(int i) {
                iResultCallbackEx.onError(i);
            }

            @Override // io.rong.imlib.NativeObject.CreateDiscussionCallback
            public void OnSuccess(String str2) {
                iResultCallbackEx.onSuccess(str2, 0);
            }
        });
    }

    void getVendorToken(final IResultCallback<String> iResultCallback) {
        this.nativeObj.GetVendorToken("", new NativeObject.TokenListener() { // from class: io.rong.imlib.NativeClient.55
            @Override // io.rong.imlib.NativeObject.TokenListener
            public void OnError(int i, String str) {
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    if (i == 0) {
                        iResultCallback2.onSuccess(str);
                    } else {
                        iResultCallback2.onError(i);
                    }
                }
            }
        });
    }

    public int getVideoLimitTime() {
        return NavigationCacheHelper.getVideoLimitTime(mContext);
    }

    public String getVoIPCallInfo() {
        return NavigationClient.getInstance().getVoIPCallInfo(mContext);
    }

    public void getVoIPKey(int i, String str, String str2, final IResultCallback<String> iResultCallback) {
        this.nativeObj.GetVoIPKey(i, str, str2, new NativeObject.TokenListener() { // from class: io.rong.imlib.NativeClient.54
            @Override // io.rong.imlib.NativeObject.TokenListener
            public void OnError(int i2, String str3) {
                if (i2 == 0) {
                    iResultCallback.onSuccess(str3);
                } else {
                    iResultCallback.onError(i2);
                }
            }
        });
    }

    public void init(Context context, String str, String str2) {
        mContext = context.getApplicationContext();
        this.appKey = str;
        this.deviceId = str2;
        this.nativeObj = new NativeObject(context);
        this.messageHandlerMap = new HashMap<>();
        this.messageContentConstructorMap = new HashMap<>();
        this.mCmdObjectNameSet = new TreeSet();
        this.chatRoomStatusMap = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("IPC_WORK");
        handlerThread.start();
        this.mWorkHandler = new Handler(handlerThread.getLooper());
        initThreadPool();
        File filesDir = mContext.getFilesDir();
        if (filesDir == null || !filesDir.exists()) {
            if (filesDir == null) {
                filesDir = mContext.getDir("rcdb", 0);
            } else if (!filesDir.mkdirs()) {
                io.rong.common.RLog.e(TAG, "Created folders UnSuccessfully");
            }
            this.dbPath = filesDir.getPath();
        } else {
            this.dbPath = filesDir.getPath();
        }
        int iInitClient = this.nativeObj.InitClient(str, context.getPackageName(), str2, this.dbPath, BuildVar.SDK_VERSION);
        ConnectionService.getInstance().initService(mContext, this.nativeObj, str);
        HeartBeatManager.getInstance().init(context, this.nativeObj);
        this.nativeObj.SetRealTimeLogListener(new IRealTimeLogListener() { // from class: io.rong.imlib.NativeClient.1
            @Override // io.rong.common.rlog.IRealTimeLogListener
            public void OnLogUpload(String str3) {
                try {
                    for (Map.Entry<String, p> entry : new s().a(str3).e().entrySet()) {
                        String key = entry.getKey();
                        if (key.equals(FirebaseAnalytics.Param.LEVEL)) {
                            int iA = entry.getValue().a();
                            if (iA >= 0 && iA <= 6) {
                                RLog.setLogLevel(iA, false);
                            }
                        } else if (key.equals("upload")) {
                            RLog.uploadRLog(false);
                        }
                    }
                } catch (Exception e2) {
                    RLog.e("OnLogUpload", "json error:" + str3, e2);
                }
            }
        });
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        setLogStatus(applicationInfo != null && (applicationInfo.flags & 2) != 0 ? 2 : 3, new NativeObject.NativeLogInfoListener() { // from class: io.rong.imlib.NativeClient.2
            @Override // io.rong.imlib.NativeObject.NativeLogInfoListener
            public void OnLogInfo(String str3, boolean z) {
                FwLog.onProtocolLog(str3, z);
                RLog.d("OnLogInfo", str3);
            }
        });
        NavigationClient.getInstance().setNaviUpdateListener(new NavigationClient.NaviUpdateListener() { // from class: io.rong.imlib.NativeClient.3
            @Override // io.rong.imlib.navigation.NavigationClient.NaviUpdateListener
            public void onNaviUpdate() {
                RtLogUploadManager.getInstance().updateTimingUploadConfig(NavigationClient.getInstance().getUploadLogConfigInfo(NativeClient.mContext));
                if (NativeClient.this.naviUpdateListener != null) {
                    NativeClient.this.naviUpdateListener.onNaviUpdate();
                }
            }
        });
        FwLog.write(3, 1, FwLog.LogTag.L_INIT_O.getTag(), "appkey|deviceId|dbPath|initResult", str, str2, this.dbPath, Integer.valueOf(iInitClient));
    }

    public void initAppendixModule() {
        RtLogUploadManager.getInstance().init(mContext, BuildVar.SDK_VERSION, this.deviceId, this.appKey);
        setChatRoomStatusNotificationListener();
    }

    public void initHttpDns() {
        NavigationClient.getInstance().getNaviString();
        HttpDnsManager.getInstance().initHttpDns(mContext, this.nativeObj);
    }

    void initIPCEnviroment(String str, int i) {
        ConnectionService.getInstance().initIPCEnviroment(str, i);
    }

    public Message insertMessage(Conversation.ConversationType conversationType, String str, String str2, MessageContent messageContent, long j) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str) || messageContent == null) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            throw new RuntimeException("自定义消息没有加注解信息。");
        }
        if (messageTag.flag() == 16) {
            RLog.e(TAG, "insertMessage MessageTag can not be STATUS.");
            return null;
        }
        Message message = new Message();
        message.setConversationType(conversationType);
        message.setTargetId(str);
        String str3 = TextUtils.isEmpty(str2) ? this.curUserId : str2;
        if (TextUtils.isEmpty(this.curUserId)) {
            message.setMessageDirection(Message.MessageDirection.SEND);
            message.setSentStatus(Message.SentStatus.SENT);
        } else {
            message.setMessageDirection(this.curUserId.equals(str3) ? Message.MessageDirection.SEND : Message.MessageDirection.RECEIVE);
            message.setSentStatus(this.curUserId.equals(str3) ? Message.SentStatus.SENT : Message.SentStatus.RECEIVED);
        }
        message.setSenderUserId(str3);
        message.setReceivedTime(j);
        message.setSentTime(j);
        message.setObjectName(messageTag.value());
        message.setContent(messageContent);
        byte[] bArr = new byte[1];
        if (message.getMessageId() <= 0) {
            boolean z = message.getMessageDirection() != null && message.getMessageDirection().equals(Message.MessageDirection.RECEIVE);
            MessageConfig messageConfig = message.getMessageConfig();
            message.setMessageId((int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), str3, bArr, z, 0, Message.SentStatus.SENDING.getValue(), message.getSentTime(), getSearchableWord(message.getContent()), 1, "", messageConfig != null ? messageConfig.isDisableNotification() : false, message.isCanIncludeExpansion(), JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message))));
        }
        MessageHandler messageHandler = getMessageHandler(messageTag.value());
        if (messageHandler != null) {
            messageHandler.encodeMessage(message);
            this.nativeObj.SetMessageContent(message.getMessageId(), message.getContent().encode(), "");
            this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.SENT.getValue());
            RLog.d(TAG, "insertMessage Inserted, id = " + message.getMessageId());
        } else {
            RLog.e(TAG, "insertMessage 该消息未注册，请调用registerMessageType方法注册。");
        }
        return message;
    }

    public Message insertSettingMessage(Message message) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (message.getConversationType() == null || TextUtils.isEmpty(message.getTargetId()) || message.getContent() == null) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            throw new RuntimeException("自定义消息没有加注解信息。");
        }
        if (messageTag.flag() == 16) {
            RLog.e(TAG, "insertMessage MessageTag can not be STATUS.");
            return null;
        }
        String senderUserId = message.getSenderUserId();
        if (TextUtils.isEmpty(senderUserId)) {
            senderUserId = this.curUserId;
        }
        String str = senderUserId;
        if (TextUtils.isEmpty(this.curUserId)) {
            message.setMessageDirection(Message.MessageDirection.SEND);
            message.setSentStatus(Message.SentStatus.SENT);
        } else if (message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            message.setSentStatus(Message.SentStatus.RECEIVED);
        }
        message.setReceivedTime(System.currentTimeMillis());
        message.setObjectName(messageTag.value());
        byte[] bArr = new byte[1];
        if (message.getMessageId() <= 0) {
            boolean z = message.getMessageDirection() != null && message.getMessageDirection().equals(Message.MessageDirection.RECEIVE);
            int i = (message.getMessageDirection() == Message.MessageDirection.RECEIVE && message.getReceivedStatus().getFlag() == 0 && messageTag.flag() == 3) ? 0 : 1;
            MessageConfig messageConfig = message.getMessageConfig();
            message.setMessageId((int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), str, bArr, z, message.getReceivedStatus().getFlag(), message.getSentStatus().getValue(), message.getSentTime(), getSearchableWord(message.getContent()), i, "", messageConfig != null ? messageConfig.isDisableNotification() : false, message.isCanIncludeExpansion(), JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message))));
        }
        MessageHandler messageHandler = getMessageHandler(messageTag.value());
        if (messageHandler != null) {
            messageHandler.encodeMessage(message);
            this.nativeObj.SetMessageContent(message.getMessageId(), message.getContent().encode(), "");
            this.nativeObj.SetSendStatus(message.getMessageId(), message.getSentStatus().getValue());
            RLog.d(TAG, "insertMessage Inserted, id = " + message.getMessageId());
        } else {
            RLog.e(TAG, "insertMessage 该消息未注册，请调用registerMessageType方法注册。");
        }
        return message;
    }

    public boolean isDnsEnabled() {
        return NavigationCacheHelper.isDnsEnabled(mContext);
    }

    public boolean isKvStorageEnabled() {
        return NavigationCacheHelper.isKvStorageEnabled(mContext);
    }

    public boolean isPhrasesEnabled() {
        return NavigationCacheHelper.isPhraseEnabled(mContext);
    }

    public void joinChatRoom(String str, int i, final OperationCallback operationCallback) {
        RLog.d(TAG, "joinChatRoom id: " + str + ", msgCount : " + i);
        if (this.chatRoomStatusMap.get(str) == null) {
            this.chatRoomStatusMap.put(str, false);
        }
        this.nativeObj.JoinChatRoom(str, Conversation.ConversationType.CHATROOM.getValue(), i, false, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.41
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                if (i2 == 0) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onSuccess();
                        return;
                    }
                    return;
                }
                OperationCallback operationCallback3 = operationCallback;
                if (operationCallback3 != null) {
                    operationCallback3.onError(i2);
                }
            }
        });
    }

    public void joinExistChatRoom(String str, int i, final OperationCallback operationCallback, boolean z) {
        RLog.d(TAG, "joinExistChatRoom id: " + str + ", msgCount : " + i);
        if (this.chatRoomStatusMap.get(str) == null) {
            this.chatRoomStatusMap.put(str, false);
        }
        this.nativeObj.JoinExistingChatroom(str, Conversation.ConversationType.CHATROOM.getValue(), i, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.43
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                if (i2 == 0) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onSuccess();
                        return;
                    }
                    return;
                }
                OperationCallback operationCallback3 = operationCallback;
                if (operationCallback3 != null) {
                    operationCallback3.onError(i2);
                }
            }
        }, z);
    }

    public void joinGroup(String str, String str2, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("groupId 或 groupName不能为空。");
        }
        this.nativeObj.JoinGroup(str, str2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.34
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str3, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public void joinRTCRoomAndGetData(final String str, int i, int i2, final IResultCallbackEx<List<RTCUser>, String[]> iResultCallbackEx) {
        FwLog.write(3, 2, "P-joinRoom-T", "roomId|uid|roomType|liveType", str, getCurrentUserId(), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-joinRoom-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-joinRoom-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.JoinRTCRoomAndGetData(str, i, i2, new NativeObject.RTCUserInfoListener() { // from class: io.rong.imlib.NativeClient.67
            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnError(int i3) {
                FwLog.write(1, 2, "P-joinRoom-E", "roomId|code|desc", str, Integer.valueOf(i3), "Protocol Error");
                iResultCallbackEx.onError(i3);
            }

            @Override // io.rong.imlib.NativeObject.RTCUserInfoListener
            public void OnSuccess(RTCUser[] rTCUserArr, String str2, String str3) {
                String string;
                if (rTCUserArr == null || rTCUserArr.length <= 0) {
                    string = "[]";
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (RTCUser rTCUser : rTCUserArr) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("userId", rTCUser.getUid());
                            JSONObject jSONObject2 = new JSONObject();
                            if (rTCUser.getData() != null) {
                                for (Map.Entry<String, String> entry : rTCUser.getData().entrySet()) {
                                    jSONObject2.put(entry.getKey(), entry.getValue());
                                }
                            }
                            jSONObject.put("streamData", jSONObject2);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    string = jSONArray.toString();
                }
                LogSplitUtil.write(3, "P-joinRoom-R", "roomId|code|remoteUserInfo", str, 0, string);
                iResultCallbackEx.onSuccess(new ArrayList(Arrays.asList(rTCUserArr)), new String[]{str2, str3});
            }
        });
    }

    public Uri obtainMediaFileSavedUri() {
        String strShortMD5 = DeviceUtils.ShortMD5(2, this.appKey, this.curUserId);
        return Uri.parse(SavePathUtils.getSavePath(mContext.getFilesDir().getAbsolutePath()) + File.separator + strShortMD5);
    }

    void queryChatRoomInfo(final String str, int i, int i2, final IResultCallback<ChatRoomInfo> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("聊天室 Id 参数异常。");
        }
        this.nativeObj.QueryChatroomInfo(str, i, i2, new NativeObject.ChatroomInfoListener() { // from class: io.rong.imlib.NativeClient.40
            @Override // io.rong.imlib.NativeObject.ChatroomInfoListener
            public void OnError(int i3) {
                iResultCallback.onError(i3);
            }

            @Override // io.rong.imlib.NativeObject.ChatroomInfoListener
            public void OnSuccess(int i3, NativeObject.UserInfo[] userInfoArr) {
                ArrayList arrayList = new ArrayList();
                if (userInfoArr != null) {
                    for (NativeObject.UserInfo userInfo : userInfoArr) {
                        ChatRoomMemberInfo chatRoomMemberInfo = new ChatRoomMemberInfo();
                        chatRoomMemberInfo.setUserId(userInfo.getUserId());
                        chatRoomMemberInfo.setJoinTime(userInfo.getJoinTime());
                        arrayList.add(chatRoomMemberInfo);
                    }
                }
                ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
                chatRoomInfo.setChatRoomId(str);
                chatRoomInfo.setTotalMemberCount(i3);
                chatRoomInfo.setMemberInfo(arrayList);
                iResultCallback.onSuccess(chatRoomInfo);
            }
        });
    }

    public void quitChatRoom(String str, final OperationCallback operationCallback) {
        RLog.d(TAG, "quitChatRoom id: " + str);
        this.chatRoomStatusMap.remove(str);
        this.nativeObj.QuitChatRoom(str, Conversation.ConversationType.CHATROOM.getValue(), new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.44
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i == 0) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onSuccess();
                        return;
                    }
                    return;
                }
                OperationCallback operationCallback3 = operationCallback;
                if (operationCallback3 != null) {
                    operationCallback3.onError(i);
                }
            }
        });
        clearMessages(Conversation.ConversationType.CHATROOM, str);
    }

    public void quitDiscussion(String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("discussionId 参数异常。");
        }
        this.nativeObj.QuitDiscussion(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.23
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public void quitGroup(String str, final OperationCallback operationCallback) {
        this.nativeObj.QuitGroup(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.35
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public void reJoinChatRoom(String str, int i, final OperationCallback operationCallback) {
        RLog.d(TAG, "reJoinChatRoom id: " + str + ", msgCount : " + i);
        if (this.chatRoomStatusMap.get(str) == null) {
            this.chatRoomStatusMap.put(str, false);
        }
        this.nativeObj.JoinChatRoom(str, Conversation.ConversationType.CHATROOM.getValue(), i, true, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.42
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                if (i2 == 0) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onSuccess();
                        return;
                    }
                    return;
                }
                OperationCallback operationCallback3 = operationCallback;
                if (operationCallback3 != null) {
                    operationCallback3.onError(i2);
                }
            }
        });
    }

    public void recallMessage(String str, byte[] bArr, String str2, int i, String str3, int i2, boolean z, final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化");
        }
        nativeObject.RecallMessage(str, bArr, str2, i, str3, i2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.46
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i3, String str4, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i3 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i3);
                    }
                }
            }
        }, z);
    }

    void registerCmdMsgType(String str) {
        if (TextUtils.isEmpty(str)) {
            RLog.d(TAG, "registerCmdMsgType parameter error");
        } else {
            this.mCmdObjectNameSet.add(str);
            this.nativeObj.RegisterCmdMsgType(new String[]{str});
        }
    }

    void registerDeleteMessageType(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        RLog.e(TAG, "registerDeleteMessageType size: " + list.size());
        this.nativeObj.RegisterDeleteMessageType((String[]) list.toArray(new String[0]));
    }

    public void registerMessageType(Class<? extends MessageContent> cls) {
        try {
            MessageTag messageTag = (MessageTag) cls.getAnnotation(MessageTag.class);
            if (messageTag != null) {
                String strValue = messageTag.value();
                Constructor<? extends MessageContent> declaredConstructor = cls.getDeclaredConstructor(byte[].class);
                this.messageHandlerMap.put(strValue, messageTag.messageHandler().getConstructor(Context.class).newInstance(mContext));
                this.messageContentConstructorMap.put(strValue, declaredConstructor);
                registerMessageType(strValue, messageTag.flag());
            } else {
                FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "tag is null,messageType is" + cls.getName(), new Object[0]);
            }
        } catch (Throwable unused) {
            FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "register is error,messageType is " + cls.getName(), new Object[0]);
        }
    }

    public boolean removeConversation(Conversation.ConversationType conversationType, String str) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            throw new IllegalArgumentException("ConversationType 和 TargetId 参数异常");
        }
        return this.nativeObj.RemoveConversation(conversationType.getValue(), str.trim());
    }

    public boolean removeEncryptedConversation(String str) {
        preCheck(str);
        return this.nativeObj.RemoveEncryptedConversation(replaceNullStr(str));
    }

    public void removeFromBlacklist(String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || operationCallback == null) {
            throw new IllegalArgumentException("用户 Id 参数异常。");
        }
        this.nativeObj.RemoveFromBlacklist(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.47
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i == 0) {
                    operationCallback.onSuccess();
                } else {
                    operationCallback.onError(i);
                }
            }
        });
    }

    public void removeMemberFromDiscussion(String str, String str2, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("discussionId 或 userId 参数异常。");
        }
        this.nativeObj.RemoveMemberFromDiscussion(str, str2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.22
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str3, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public void removeMessageAllExpansion(String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        final Message messageByUid = getMessageByUid(str);
        if (messageByUid != null && messageByUid.isCanIncludeExpansion()) {
            sendMessageOption(Message.obtain(messageByUid.getTargetId(), messageByUid.getConversationType(), MessageExpansionMessage.obtain(str, true)), null, null, null, null, new ISendMessageCallback<Message>() { // from class: io.rong.imlib.NativeClient.80
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message, int i) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onError(i);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message) {
                    NativeClient.this.removeKeysInExpansionEx(-1L, false, new ArrayList(), messageByUid, operationCallback);
                }
            });
        } else if (operationCallback != null) {
            operationCallback.onError(RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND.getValue());
        }
    }

    public void removeMessageExpansion(final List<String> list, String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        final Message messageByUid = getMessageByUid(str);
        if (messageByUid != null && messageByUid.isCanIncludeExpansion()) {
            sendMessageOption(Message.obtain(messageByUid.getTargetId(), messageByUid.getConversationType(), MessageExpansionMessage.obtain(str, list)), null, null, null, null, new ISendMessageCallback<Message>() { // from class: io.rong.imlib.NativeClient.81
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message, int i) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onError(i);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message) {
                    NativeClient.this.removeKeysInExpansionEx(-1L, false, list, messageByUid, operationCallback);
                }
            });
        } else if (operationCallback != null) {
            operationCallback.onError(RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND.getValue());
        }
    }

    public void removeNotificationQuietHours(final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (operationCallback == null) {
            throw new IllegalArgumentException("参数异常。");
        }
        nativeObject.RemovePushSetting(new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.51
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str, long j) {
                if (i == 0) {
                    operationCallback.onSuccess();
                } else {
                    operationCallback.onError(i);
                }
            }
        });
    }

    public void rtcDeleteInnerData(final String str, int i, String[] strArr, String str2, String str3, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCDeleteInnerData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCDeleteInnerData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        FwLog.write(3, 2, "P-RTCDeleteInnerData-T", "roomId|type", str, Integer.valueOf(i));
        this.nativeObj.RTCDeleteInnerData(str, i, strArr, str2, str3, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.63
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str4, long j) {
                if (i2 == 0) {
                    FwLog.write(3, 2, "P-RTCDeleteInnerData-R", "roomId|code", str, 0);
                } else {
                    FwLog.write(1, 2, "P-RTCDeleteInnerData-E", "roomId|code|desc", str, Integer.valueOf(i2), "Protocol Error");
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i2 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i2);
                    }
                }
            }
        });
    }

    public void rtcDeleteOuterData(final String str, int i, String[] strArr, String str2, String str3, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCDeleteOuterData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCDeleteOuterData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        FwLog.write(3, 2, "P-RTCDeleteOuterData-T", "roomId|type", str, Integer.valueOf(i));
        this.nativeObj.RTCDeleteOuterData(str, i, strArr, str2, str3, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.64
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str4, long j) {
                if (i2 == 0) {
                    FwLog.write(3, 2, "P-RTCDeleteOuterData-R", "roomId|code", str, 0);
                } else {
                    FwLog.write(1, 2, "P-RTCDeleteOuterData-E", "roomId|code|desc", str, Integer.valueOf(i2), "Protocol Error");
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i2 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i2);
                    }
                }
            }
        });
    }

    public void rtcGetInnerData(final String str, int i, String[] strArr, final IResultCallback<Map<String, String>> iResultCallback) {
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCGetInnerData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCGetInnerData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        FwLog.write(3, 2, "P-RTCGetInnerData-T", "roomId|type", str, Integer.valueOf(i));
        this.nativeObj.RTCGetInnerData(str, i, strArr, new NativeObject.RTCDataListener() { // from class: io.rong.imlib.NativeClient.65
            @Override // io.rong.imlib.NativeObject.RTCDataListener
            public void OnError(int i2) {
                FwLog.write(1, 2, "P-RTCGetInnerData-E", "roomId|code|desc", str, Integer.valueOf(i2), "Protocol Error");
                iResultCallback.onError(i2);
            }

            @Override // io.rong.imlib.NativeObject.RTCDataListener
            public void OnSuccess(Map<String, String> map) {
                FwLog.write(3, 2, "P-RTCGetInnerData-R", "roomId|code", str, 0);
                iResultCallback.onSuccess(map);
            }
        });
    }

    public void rtcGetOuterData(final String str, int i, String[] strArr, final IResultCallback<Map<String, String>> iResultCallback) {
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCGetOuterData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCGetOuterData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        FwLog.write(3, 2, "P-RTCGetOuterData-T", "roomId|type", str, Integer.valueOf(i));
        this.nativeObj.RTCGetOuterData(str, i, strArr, new NativeObject.RTCDataListener() { // from class: io.rong.imlib.NativeClient.66
            @Override // io.rong.imlib.NativeObject.RTCDataListener
            public void OnError(int i2) {
                FwLog.write(1, 2, "P-RTCGetOuterData-E", "roomId|code|desc", str, Integer.valueOf(i2), "Protocol Error");
                iResultCallback.onError(i2);
            }

            @Override // io.rong.imlib.NativeObject.RTCDataListener
            public void OnSuccess(Map<String, String> map) {
                FwLog.write(3, 2, "P-RTCGetOuterData-R", "roomId|code", str, 0);
                iResultCallback.onSuccess(map);
            }
        });
    }

    public void rtcPutInnerData(final String str, int i, String str2, String str3, String str4, String str5, final OperationCallback operationCallback) {
        LogSplitUtil.write(3, "P-RTCPutInnerData-T", "roomId|type|fullValues|increValues", str, Integer.valueOf(i), str3, str5);
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCPutInnerData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCPutInnerData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        this.nativeObj.RTCPutInnerDatum(str, i, str2, str3, str4, str5, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.61
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str6, long j) {
                if (i2 == 0) {
                    FwLog.write(3, 2, "P-RTCPutInnerData-R", "roomId|code", str, Integer.valueOf(i2));
                } else {
                    FwLog.write(1, 2, "P-RTCPutInnerData-E", "roomId|code", str, Integer.valueOf(i2));
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i2 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i2);
                    }
                }
            }
        });
    }

    public void rtcPutOuterData(final String str, int i, String str2, String str3, String str4, String str5, final OperationCallback operationCallback) {
        LogSplitUtil.write(3, "P-RTCPutOuterData-T", "roomId|type|fullValues|increValues", str, Integer.valueOf(i), str3, str5);
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCPutOuterData-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCPutOuterData-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        this.nativeObj.RTCPutOuterDatum(str, i, str2, str3, str4, str5, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.62
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str6, long j) {
                if (i2 == 0) {
                    FwLog.write(3, 2, "P-RTCPutOuterData-R", "roomId|code", str, 0);
                } else {
                    FwLog.write(1, 2, "P-RTCPutOuterData-E", "roomId|code", str, Integer.valueOf(i2));
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i2 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i2);
                    }
                }
            }
        });
    }

    void rtcSetUserResource(final String str, RTCStatusDate[] rTCStatusDateArr, String str2, RTCStatusDate[] rTCStatusDateArr2, final OperationCallback operationCallback) {
        LogSplitUtil.write(3, "P-RTCSetUserResource-T", "roomId", str);
        if (this.nativeObj == null) {
            FwLog.write(1, 2, "P-RTCSetUserResource-E", "roomId|code|desc", str, -1, "NativeClient is Null");
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            FwLog.write(1, 2, "P-RTCSetUserResource-E", "roomId|code|desc", str, -1, "RoomId is Null");
            throw new IllegalArgumentException("roomId 参数异常。");
        }
        int length = rTCStatusDateArr.length;
        int length2 = rTCStatusDateArr2.length;
        NativeObject.StatusData[] statusDataArr = new NativeObject.StatusData[length];
        for (int i = 0; i < length; i++) {
            NativeObject.StatusData statusData = new NativeObject.StatusData();
            statusData.setKey(rTCStatusDateArr[i].getKey());
            statusData.setValue(rTCStatusDateArr[i].getValue());
            statusData.setAutoDelete(rTCStatusDateArr[i].isAutoDelete());
            statusData.setOverwrite(rTCStatusDateArr[i].isOverwrite());
            statusDataArr[i] = statusData;
        }
        NativeObject.StatusData[] statusDataArr2 = new NativeObject.StatusData[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            NativeObject.StatusData statusData2 = new NativeObject.StatusData();
            statusData2.setKey(rTCStatusDateArr2[i2].getKey());
            statusData2.setValue(rTCStatusDateArr2[i2].getValue());
            statusData2.setAutoDelete(rTCStatusDateArr2[i2].isAutoDelete());
            statusData2.setOverwrite(rTCStatusDateArr2[i2].isOverwrite());
            statusDataArr2[i2] = statusData2;
        }
        this.nativeObj.RTCSetUserResource(str, statusDataArr, str2, statusDataArr2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.78
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i3, String str3, long j) {
                if (i3 == 0) {
                    FwLog.write(3, 2, "P-RTCSetUserResource-R", "roomId|code", str, Integer.valueOf(i3));
                } else {
                    FwLog.write(1, 2, "P-RTCSetUserResource-E", "roomId|code", str, Integer.valueOf(i3));
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i3 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i3);
                    }
                }
            }
        });
    }

    public boolean saveTextMessageDraft(Conversation.ConversationType conversationType, String str, String str2) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationType 或 targetId 参数异常。");
        }
        return this.nativeObj.SetTextMessageDraft(conversationType.getValue(), str, str2);
    }

    public void sdkBackgroundChanged(boolean z) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.sdkBackgroundChanged(z);
    }

    List<SearchConversationResult> searchConversations(String str, int[] iArr, String[] strArr) {
        NativeObject.Conversation[] conversationArrSearchConversations = this.nativeObj.SearchConversations(str, iArr, strArr);
        ArrayList arrayList = new ArrayList();
        if (conversationArrSearchConversations != null) {
            for (NativeObject.Conversation conversation : conversationArrSearchConversations) {
                Conversation conversationRenderConversationFromNative = renderConversationFromNative(conversation);
                SearchConversationResult searchConversationResult = new SearchConversationResult();
                searchConversationResult.setConversation(conversationRenderConversationFromNative);
                searchConversationResult.setMatchCount(conversation.getMatchCount());
                arrayList.add(searchConversationResult);
            }
        }
        return arrayList;
    }

    List<Message> searchMessages(String str, Conversation.ConversationType conversationType, String str2, int i, long j) {
        NativeObject.Message[] messageArrSearchMessages = this.nativeObj.SearchMessages(str, conversationType.getValue(), str2, i, j);
        ArrayList arrayList = new ArrayList();
        if (messageArrSearchMessages != null) {
            for (NativeObject.Message message : messageArrSearchMessages) {
                Message message2 = new Message(message);
                message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                arrayList.add(message2);
            }
        }
        return arrayList;
    }

    List<Message> searchMessagesByUser(String str, Conversation.ConversationType conversationType, String str2, int i, long j) {
        NativeObject.Message[] messageArrSearchMessagesByUser = this.nativeObj.SearchMessagesByUser(str, conversationType.getValue(), str2, i, j);
        ArrayList arrayList = new ArrayList();
        if (messageArrSearchMessagesByUser != null) {
            for (NativeObject.Message message : messageArrSearchMessagesByUser) {
                Message message2 = new Message(message);
                message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                arrayList.add(message2);
            }
        }
        return arrayList;
    }

    public void searchPublicService(String str, int i, int i2, final IResultCallback iResultCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (str == null) {
            throw new IllegalArgumentException("keyWords 参数异常。");
        }
        nativeObject.SearchAccount(str, i, i2, new NativeObject.AccountInfoListener() { // from class: io.rong.imlib.NativeClient.19
            @Override // io.rong.imlib.NativeObject.AccountInfoListener
            public void OnError(int i3) {
                iResultCallback.onError(i3);
            }

            @Override // io.rong.imlib.NativeObject.AccountInfoListener
            public void onReceived(NativeObject.AccountInfo[] accountInfoArr) {
                ArrayList arrayList = new ArrayList();
                for (NativeObject.AccountInfo accountInfo : accountInfoArr) {
                    PublicServiceProfile publicServiceProfile = new PublicServiceProfile();
                    publicServiceProfile.setTargetId(new String(accountInfo.getAccountId()));
                    publicServiceProfile.setName(new String(accountInfo.getAccountName()));
                    publicServiceProfile.setPublicServiceType(Conversation.ConversationType.setValue(accountInfo.getAccountType()));
                    publicServiceProfile.setPortraitUri(Uri.parse(new String(accountInfo.getAccountUri())));
                    String str2 = new String(accountInfo.getExtra());
                    RLog.i(NativeClient.TAG, "getPublicAccountInfoList extra:" + str2);
                    publicServiceProfile.setExtra(str2);
                    arrayList.add(publicServiceProfile);
                }
                iResultCallback.onSuccess(new PublicServiceProfileList((ArrayList<PublicServiceProfile>) arrayList));
            }
        });
    }

    public void sendLocationMessage(Message message, final String str, final String str2, final ISendMessageCallback<Message> iSendMessageCallback) {
        final MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        if (TextUtils.isEmpty(message.getSenderUserId())) {
            message.setSenderUserId(this.curUserId);
        }
        message.setMessageDirection(Message.MessageDirection.SEND);
        message.setSentTime(System.currentTimeMillis());
        message.setObjectName(messageTag.value());
        byte[] bArrEncode = message.getContent().encode();
        MessageConfig messageConfig = message.getMessageConfig();
        final boolean zIsCanIncludeExpansion = message.isCanIncludeExpansion();
        String strMapTsCombineJson = JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message));
        final String strHashMapToJson = JSONUtils.hashMapToJson(message.getExpansion());
        int iSaveMessage = (int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), message.getSenderUserId(), bArrEncode, false, 0, Message.SentStatus.SENDING.getValue(), System.currentTimeMillis(), getSearchableWord(message.getContent()), 1, "", messageConfig != null ? messageConfig.isDisableNotification() : false, zIsCanIncludeExpansion, strMapTsCombineJson);
        if (iSaveMessage < 0 && iSendMessageCallback != null) {
            message.setSentStatus(Message.SentStatus.FAILED);
            if (iSaveMessage == RongIMClient.ErrorCode.PARAMETER_ERROR.getValue()) {
                iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                return;
            } else {
                iSendMessageCallback.onError(message, RongIMClient.ErrorCode.BIZ_ERROR_DATABASE_ERROR.getValue());
                return;
            }
        }
        message.setMessageId(iSaveMessage);
        if (iSendMessageCallback != null) {
            message.setSentStatus(Message.SentStatus.SENDING);
            iSendMessageCallback.onAttached(message);
        }
        if (message.getMessageId() == 0) {
            RLog.e(TAG, "Location Message saved error");
            if (iSendMessageCallback != null) {
                message.setSentStatus(Message.SentStatus.FAILED);
                this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.FAILED.getValue());
                iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                return;
            }
            return;
        }
        MessageHandler messageHandler = getMessageHandler(messageTag.value());
        if (messageHandler != null) {
            messageHandler.setHandleMessageListener(new IHandleMessageListener() { // from class: io.rong.imlib.NativeClient.25
                @Override // io.rong.message.IHandleMessageListener
                public void onHandleResult(Message message2, int i) {
                    RLog.d(NativeClient.TAG, "onHandleResult " + ((LocationMessage) message2.getContent()).getImgUri());
                    if (i == 0) {
                        boolean zIsMentionedMessage = NativeClient.this.isMentionedMessage(message2);
                        byte[] bArrEncode2 = message2.getContent().encode();
                        NativeClient.this.nativeObj.SetMessageContent(message2.getMessageId(), bArrEncode2, "");
                        NativeClient.this.internalSendMessage(message2, str, str2, null, iSendMessageCallback, messageTag, bArrEncode2, 3, zIsMentionedMessage, zIsCanIncludeExpansion, strHashMapToJson);
                        return;
                    }
                    message2.setSentStatus(Message.SentStatus.FAILED);
                    NativeClient.this.nativeObj.SetSendStatus(message2.getMessageId(), Message.SentStatus.FAILED.getValue());
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        iSendMessageCallback2.onError(message2, 30014);
                    }
                }
            });
            messageHandler.encodeMessage(message);
            return;
        }
        RLog.e(TAG, "MessageHandler is null");
        if (iSendMessageCallback != null) {
            message.setSentStatus(Message.SentStatus.FAILED);
            this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.FAILED.getValue());
            iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
        }
    }

    public void sendMediaMessage(final Message message, final String[] strArr, final String str, final String str2, final ISendMediaMessageCallback<Message> iSendMediaMessageCallback) {
        final MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        if (TextUtils.isEmpty(message.getSenderUserId())) {
            message.setSenderUserId(this.curUserId);
        }
        message.setSentTime(System.currentTimeMillis());
        message.setObjectName(messageTag.value());
        final boolean zIsCanIncludeExpansion = message.isCanIncludeExpansion();
        String strMapTsCombineJson = JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message));
        final String strHashMapToJson = JSONUtils.hashMapToJson(message.getExpansion());
        byte[] bArr = new byte[1];
        final boolean z = message.getContent().getMentionedInfo() != null;
        final MediaMessageContent mediaMessageContent = (MediaMessageContent) message.getContent();
        final MessageHandler messageHandler = getMessageHandler(messageTag.value());
        if (messageHandler == null) {
            RLog.e(TAG, "sendMediaMessage MessageHandler is null");
            if (iSendMediaMessageCallback != null) {
                iSendMediaMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                return;
            }
            return;
        }
        if (message.getMessageId() <= 0) {
            MessageConfig messageConfig = message.getMessageConfig();
            int iSaveMessage = (int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), message.getSenderUserId(), bArr, false, 0, Message.SentStatus.SENDING.getValue(), System.currentTimeMillis(), getSearchableWord(message.getContent()), 1, "", messageConfig != null ? messageConfig.isDisableNotification() : false, zIsCanIncludeExpansion, strMapTsCombineJson);
            if (iSaveMessage < 0 && iSendMediaMessageCallback != null) {
                message.setSentStatus(Message.SentStatus.FAILED);
                if (iSaveMessage == RongIMClient.ErrorCode.PARAMETER_ERROR.getValue()) {
                    iSendMediaMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                    return;
                } else {
                    iSendMediaMessageCallback.onError(message, RongIMClient.ErrorCode.BIZ_ERROR_DATABASE_ERROR.getValue());
                    return;
                }
            }
            message.setMessageId(iSaveMessage);
        }
        message.setSentStatus(Message.SentStatus.SENDING);
        message.setMessageDirection(Message.MessageDirection.SEND);
        messageHandler.encodeMessage(message);
        byte[] bArrEncode = message.getContent().encode();
        this.nativeObj.SetMessageContent(message.getMessageId(), bArrEncode, "");
        if (iSendMediaMessageCallback != null) {
            iSendMediaMessageCallback.onAttached(message);
        }
        if (mediaMessageContent.getMediaUrl() == null || (mediaMessageContent.getMediaUrl() != null && TextUtils.isEmpty(mediaMessageContent.getMediaUrl().toString()))) {
            uploadMedia(message, new IResultProgressCallback<String>() { // from class: io.rong.imlib.NativeClient.26
                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onCanceled(int i) {
                    message.setSentStatus(Message.SentStatus.CANCELED);
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        iSendMediaMessageCallback2.onCanceled(message);
                    }
                    NativeClient.this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.CANCELED.getValue());
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onError(int i) {
                    message.setSentStatus(Message.SentStatus.FAILED);
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        iSendMediaMessageCallback2.onError(message, i);
                    }
                    NativeClient.this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.FAILED.getValue());
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onProgress(int i) {
                    RLog.i(NativeClient.TAG, "upload onProgress " + i);
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        iSendMediaMessageCallback2.onProgress(message, i);
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onSuccess(String str3) {
                    mediaMessageContent.setMediaUrl(Uri.parse(str3));
                    messageHandler.encodeMessage(message);
                    message.setContent(mediaMessageContent);
                    byte[] bArrEncode2 = mediaMessageContent.encode();
                    NativeClient.this.nativeObj.SetMessageContent(message.getMessageId(), bArrEncode2, "");
                    NativeClient.this.internalSendMessage(message, str, str2, strArr, new ISendMessageCallback<Message>() { // from class: io.rong.imlib.NativeClient.26.1
                        @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                        public void onAttached(Message message2) {
                        }

                        @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                        public void onError(Message message2, int i) {
                            ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                            if (iSendMediaMessageCallback2 != null) {
                                iSendMediaMessageCallback2.onError(message2, i);
                            }
                        }

                        @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                        public void onSuccess(Message message2) {
                            ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                            if (iSendMediaMessageCallback2 != null) {
                                iSendMediaMessageCallback2.onSuccess(message2);
                            }
                        }
                    }, messageTag, bArrEncode2, 3, z, zIsCanIncludeExpansion, strHashMapToJson);
                }
            });
        } else {
            this.nativeObj.SetMessageContent(message.getMessageId(), bArrEncode, "");
            internalSendMessage(message, str, str2, strArr, new ISendMessageCallback<Message>() { // from class: io.rong.imlib.NativeClient.27
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        iSendMediaMessageCallback2.onError(message2, i);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        iSendMediaMessageCallback2.onSuccess(message2);
                    }
                }
            }, messageTag, bArrEncode, 3, z, zIsCanIncludeExpansion, strHashMapToJson);
        }
    }

    public void sendMessage(Conversation.ConversationType conversationType, String str, MessageContent messageContent, String str2, String str3, ISendMessageCallback<Message> iSendMessageCallback) {
        sendMessage(Message.obtain(str, conversationType, messageContent), str2, str3, null, iSendMessageCallback);
    }

    public void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, String[] strArr, ISendMessageCallback<Message> iSendMessageCallback) {
        sendMessageOption(message, str, str2, sendMessageOption, strArr, false, iSendMessageCallback);
    }

    public void sendRTCPing(String str, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("messages 参数异常。");
        }
        this.nativeObj.SendRTCPing(str, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.60
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i != 0) {
                    FwLog.write(1, 2, "P-RTCPing-E", "code", Integer.valueOf(i));
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i);
                    }
                }
            }
        });
    }

    public void setChatRoomEntry(String str, String str2, String str3, Boolean bool, String str4, boolean z, boolean z2, final OperationCallback operationCallback) {
        if (!NavigationCacheHelper.isKvStorageEnabled(mContext) && operationCallback != null) {
            operationCallback.onError(RongIMClient.ErrorCode.KV_STORE_NOT_AVAILABLE.getValue());
            return;
        }
        NativeObject.StatusData statusData = new NativeObject.StatusData();
        statusData.setKey(str);
        statusData.setValue(str2);
        statusData.setAutoDelete(z);
        statusData.setOverwrite(z2);
        NativeObject.StatusNotification statusNotification = new NativeObject.StatusNotification();
        statusNotification.setAttributeFlag(0);
        statusNotification.setConversationType(Conversation.ConversationType.CHATROOM.getValue());
        statusNotification.setMessageContent(new String(ChatRoomKVNotiMessage.obtain(str, str2, 1, str4).encode()));
        statusNotification.setNotifyAll(bool.booleanValue());
        statusNotification.setObjectName(((MessageTag) ChatRoomKVNotiMessage.class.getAnnotation(MessageTag.class)).value());
        this.nativeObj.SetChatRoomStatus(str3, statusData, statusNotification, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.73
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str5, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i);
                    }
                }
            }
        });
    }

    public void setConnectionStatusListener(ICodeListener iCodeListener) {
        ConnectionService.getInstance().setMainProgressConnectionStatusListener(iCodeListener);
    }

    public void setConversationNotificationStatus(Conversation.ConversationType conversationType, String str, final Conversation.ConversationNotificationStatus conversationNotificationStatus, final IResultCallback<Integer> iResultCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || conversationNotificationStatus == null || TextUtils.isEmpty(str) || iResultCallback == null) {
            throw new IllegalArgumentException("conversationType, notificationStatus 或 targetId 参数异常。");
        }
        this.nativeObj.SetBlockPush(str, conversationType.getValue(), conversationNotificationStatus == Conversation.ConversationNotificationStatus.DO_NOT_DISTURB, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.31
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str2, long j) {
                if (i == 0) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    Conversation.ConversationNotificationStatus conversationNotificationStatus2 = conversationNotificationStatus;
                    Conversation.ConversationNotificationStatus conversationNotificationStatus3 = Conversation.ConversationNotificationStatus.DO_NOT_DISTURB;
                    iResultCallback2.onSuccess(Integer.valueOf(conversationNotificationStatus2 == conversationNotificationStatus3 ? conversationNotificationStatus3.getValue() : Conversation.ConversationNotificationStatus.NOTIFY.getValue()));
                    return;
                }
                RLog.d(NativeClient.TAG, "setConversationNotificationStatus operationComplete: status = " + i);
                iResultCallback.onError(i);
            }
        });
    }

    public void setConversationStatusListener(NativeObject.ConversationStatusListener conversationStatusListener) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.SetConversationStatusListener(conversationStatusListener);
    }

    public boolean setConversationToTop(Conversation.ConversationType conversationType, String str, boolean z, boolean z2) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (conversationType == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ConversationType 或 TargetId 参数异常");
        }
        return this.nativeObj.SetIsTop(conversationType.getValue(), str, z, z2);
    }

    void setCurrentUserId(String str) {
        this.curUserId = str;
    }

    public void setDiscussionInviteStatus(String str, int i, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("targetId 参数异常。");
        }
        this.nativeObj.SetInviteStatus(str, i, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.32
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i2 == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i2);
                }
            }
        });
    }

    public void setDiscussionName(String str, String str2, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim()) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2.trim())) {
            throw new IllegalArgumentException(" discussionId 或 name 参数异常。");
        }
        this.nativeObj.RenameDiscussion(str, str2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.17
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str3, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i);
                }
            }
        });
    }

    public boolean setEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) {
        preCheck(str, rCEncryptedSession);
        return this.nativeObj.SetEncryptedConversationInfo(replaceNullStr(str), replaceNullStr(rCEncryptedSession.getTargetId()), replaceNullStr(rCEncryptedSession.getRemoteEncId()), replaceNullStr(rCEncryptedSession.getEncKey()), replaceNullStr(rCEncryptedSession.getEncXA()), rCEncryptedSession.getEncStatus());
    }

    void setIpcConnectTimeOut() {
        ConnectionService.getInstance().setIpcConnectTimeOut();
    }

    public void setKVStatusListener(KVStatusListener kVStatusListener) {
        this.mKVStatusListener = kVStatusListener;
    }

    public boolean setMessageContent(int i, byte[] bArr, String str) {
        return this.nativeObj.SetMessageContent(i, bArr, str);
    }

    public void setMessageExpansionListener(IMessageExpansionListener iMessageExpansionListener) {
        messageExpansionListener = iMessageExpansionListener;
    }

    public boolean setMessageExtra(int i, String str) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (i != 0) {
            return nativeObject.SetMessageExtra(i, str);
        }
        throw new IllegalArgumentException("messageId 参数异常。");
    }

    boolean setMessageReadTime(long j, long j2) {
        return this.nativeObj.SetReadTime(j, j2);
    }

    public boolean setMessageReceivedStatus(int i, Message.ReceivedStatus receivedStatus) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (receivedStatus == null || i == 0) {
            throw new IllegalArgumentException("receivedStatus 或 messageId 参数异常。");
        }
        return nativeObject.SetReadStatus(i, receivedStatus.getFlag());
    }

    public boolean setMessageSentStatus(int i, Message.SentStatus sentStatus) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (sentStatus == null || i == 0) {
            throw new IllegalArgumentException("sentStatus 或 messageId 参数异常。");
        }
        return nativeObject.SetSendStatus(i, sentStatus.getValue());
    }

    void setNaviContentUpdateListener(NavigationClient.NaviUpdateListener naviUpdateListener) {
        this.naviUpdateListener = naviUpdateListener;
    }

    public void setNotificationQuietHours(String str, int i, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (TextUtils.isEmpty(str) || i <= 0 || i >= 1440 || operationCallback == null) {
            throw new IllegalArgumentException("startTime, spanMinutes 或 spanMinutes 参数异常。");
        }
        if (!Pattern.compile("^(([0-1][0-9])|2[0-3]):[0-5][0-9]:([0-5][0-9])$").matcher(str).find()) {
            throw new IllegalArgumentException("startTime 参数异常。");
        }
        this.nativeObj.AddPushSetting(str, i, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.50
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                if (i2 == 0) {
                    operationCallback.onSuccess();
                } else {
                    operationCallback.onError(i2);
                }
            }
        });
    }

    public void setOfflineMessageDuration(String str, final IResultCallback<Long> iResultCallback) {
        this.nativeObj.SetOfflineMessageDuration(str, new NativeObject.SetOfflineMessageDurationListener() { // from class: io.rong.imlib.NativeClient.56
            @Override // io.rong.imlib.NativeObject.SetOfflineMessageDurationListener
            public void onError(int i) {
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(i);
                }
            }

            @Override // io.rong.imlib.NativeObject.SetOfflineMessageDurationListener
            public void onSuccess(long j) {
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onSuccess(Long.valueOf(j));
                }
            }
        });
    }

    public void setOnReceiveMessageListener(final OnReceiveMessageListener onReceiveMessageListener) {
        this.nativeObj.SetMessageListener(new NativeObject.ReceiveMessageListener() { // from class: io.rong.imlib.NativeClient.38
            @Override // io.rong.imlib.NativeObject.ReceiveMessageListener
            public void onReceived(final NativeObject.Message message, final int i, final boolean z, final boolean z2, final int i2) {
                RLog.d(NativeClient.TAG, "onReceived onLine message:");
                NativeClient.this.receiveMessageExecutor.execute(new Runnable() { // from class: io.rong.imlib.NativeClient.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass38 anonymousClass38 = AnonymousClass38.this;
                        NativeClient.this.handleReceivedMessage(message, i, z, z2, i2, onReceiveMessageListener);
                    }
                });
            }

            @Override // io.rong.imlib.NativeObject.ReceiveMessageListener
            public void onReceived(final NativeObject.Message[] messageArr, final boolean z, final int i) {
                RLog.d(NativeClient.TAG, "onReceived batch of messages.");
                NativeClient.this.receiveMessageExecutor.execute(new Runnable() { // from class: io.rong.imlib.NativeClient.38.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int length = messageArr.length;
                        int i2 = i;
                        for (int i3 = 0; i3 < length; i3++) {
                            int i4 = (length - i3) - 1;
                            if (NativeClient.this.mCmdObjectNameSet.contains(messageArr[i3].getObjectName())) {
                                i2--;
                            }
                            NativeClient nativeClient = NativeClient.this;
                            NativeObject.Message[] messageArr2 = messageArr;
                            nativeClient.handleReceivedMessage(messageArr2[i3], i4, messageArr2[i3].isOffLine(), z, i2, onReceiveMessageListener);
                        }
                    }
                });
            }
        });
        this.nativeObj.SetGetSearchableWordListener(new NativeObject.GetSearchableWordListener() { // from class: io.rong.imlib.NativeClient.39
            @Override // io.rong.imlib.NativeObject.GetSearchableWordListener
            public byte[] getSearchableWord(String str, byte[] bArr) {
                String searchableWord;
                MessageContent messageContentNewMessageContent = NativeClient.this.newMessageContent(str, bArr);
                if (messageContentNewMessageContent instanceof UnknownMessage) {
                    RLog.e(NativeClient.TAG, "result is UnknownMessage");
                    searchableWord = "";
                } else {
                    searchableWord = NativeClient.getInstance().getSearchableWord(messageContentNewMessageContent);
                }
                return searchableWord.getBytes();
            }
        });
    }

    public void setPushSetting(int i, String str, final IResultCallback<Long> iResultCallback) {
        this.nativeObj.SetPushSetting(i, str, new NativeObject.SetPushSettingListener() { // from class: io.rong.imlib.NativeClient.11
            @Override // io.rong.imlib.NativeObject.SetPushSettingListener
            public void onError(int i2) {
                iResultCallback.onError(i2);
            }

            @Override // io.rong.imlib.NativeObject.SetPushSettingListener
            public void onSuccess(long j) {
                iResultCallback.onSuccess(Long.valueOf(j));
            }
        });
    }

    public void setRTCUserData(String str, int i, Map<String, String> map, String str2, String str3, final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (!(map instanceof HashMap)) {
            throw new RuntimeException("setRTCUserData data must be HashMap!");
        }
        nativeObject.RTCSetUserData(str, i, map, str2, str3, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.71
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str4, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i2 == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i2);
                    }
                }
            }
        });
    }

    void setRTCUserState(String str, String str2, final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.RTCSetUserState(str, str2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.70
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str3, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    if (i == 0) {
                        operationCallback2.onSuccess();
                    } else {
                        operationCallback2.onError(i);
                    }
                }
            }
        });
    }

    public void setReconnectKickEnable(boolean z) {
        ConnectionService.getInstance().setReconnectKickEnable(z);
    }

    public void setServerInfo(String str, String str2) {
        if (str != null) {
            NavigationClient.getInstance().setNaviDomainList(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mFileServer = NavigationClient.getInstance().formatServerAddress(str2, "");
    }

    public void setSubscribeStatusListener(final IResultCallbackEx<String, String> iResultCallbackEx) {
        this.nativeObj.SetSubscribeStatusListener(new NativeObject.UserStatusListener() { // from class: io.rong.imlib.NativeClient.10
            @Override // io.rong.imlib.NativeObject.UserStatusListener
            public void onStatusReceived(String str, String str2) {
                iResultCallbackEx.onSuccess(str, str2);
            }
        });
    }

    public void setUserData(UserData userData, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (userData == null) {
            throw new IllegalArgumentException("userData 参数异常。");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (userData.getPersonalInfo() != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("realName", userData.getPersonalInfo().getRealName());
                jSONObject2.putOpt("sex", userData.getPersonalInfo().getSex());
                jSONObject2.putOpt("age", userData.getPersonalInfo().getAge());
                jSONObject2.putOpt("birthday", userData.getPersonalInfo().getBirthday());
                jSONObject2.putOpt("job", userData.getPersonalInfo().getJob());
                jSONObject2.putOpt("portraitUri", userData.getPersonalInfo().getPortraitUri());
                jSONObject2.putOpt("comment", userData.getPersonalInfo().getComment());
                jSONObject.put("personalInfo", jSONObject2);
            }
            if (userData.getAccountInfo() != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("appUserId", userData.getAccountInfo().getAppUserId());
                jSONObject3.putOpt("userName", userData.getAccountInfo().getUserName());
                jSONObject3.putOpt("nickName", userData.getAccountInfo().getNickName());
                jSONObject.putOpt("accountInfo", jSONObject3);
            }
            if (userData.getContactInfo() != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("tel", userData.getContactInfo().getTel());
                jSONObject4.putOpt("email", userData.getContactInfo().getEmail());
                jSONObject4.putOpt("address", userData.getContactInfo().getAddress());
                jSONObject4.putOpt("qq", userData.getContactInfo().getQQ());
                jSONObject4.putOpt("weibo", userData.getContactInfo().getWeibo());
                jSONObject4.putOpt("weixin", userData.getContactInfo().getWeixin());
                jSONObject.putOpt("contactInfo", jSONObject4);
            }
            if (userData.getClientInfo() != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt(TencentLocation.NETWORK_PROVIDER, userData.getClientInfo().getNetwork());
                jSONObject5.putOpt(au.O, userData.getClientInfo().getCarrier());
                jSONObject5.putOpt("systemVersion", userData.getClientInfo().getSystemVersion());
                jSONObject5.putOpt(au.w, userData.getClientInfo().getOs());
                jSONObject5.putOpt("device", userData.getClientInfo().getDevice());
                jSONObject5.putOpt("mobilePhoneManufacturers", userData.getClientInfo().getMobilePhoneManufacturers());
                jSONObject.putOpt("clientInfo", jSONObject5);
            }
            jSONObject.putOpt("appVersion", userData.getAppVersion());
            jSONObject.putOpt("extra", userData.getExtra());
            String string = jSONObject.toString();
            RLog.d(TAG, "UserData " + string);
            this.nativeObj.SetUserData(string, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.53
                @Override // io.rong.imlib.NativeObject.PublishAckListener
                public void operationComplete(int i, String str, long j) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        if (i == 0) {
                            operationCallback2.onSuccess();
                        } else {
                            operationCallback2.onError(i);
                        }
                    }
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setUserStatus(int i, final IResultCallback<Integer> iResultCallback) {
        this.nativeObj.SetUserStatus(i, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.12
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str, long j) {
                if (i2 == 0) {
                    iResultCallback.onSuccess(0);
                } else {
                    iResultCallback.onError(i2);
                }
            }
        });
    }

    public void subscribePublicService(String str, int i, boolean z, final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        nativeObject.SubscribeAccount(str, i, z, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.20
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str2, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i2 == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i2);
                }
            }
        });
    }

    public void subscribeStatus(List<String> list, final IResultCallbackEx<Integer, Integer> iResultCallbackEx) {
        this.nativeObj.SubscribeStatus((String[]) list.toArray(new String[list.size()]), new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.9
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i, String str, long j) {
                if (i == 0) {
                    iResultCallbackEx.onSuccess(Integer.valueOf(i), 0);
                } else {
                    iResultCallbackEx.onError(i);
                }
            }
        });
    }

    public void switchAppKey(String str, String str2) {
        disconnect(false);
        this.appKey = str;
        this.deviceId = str2;
        NavigationCacheHelper.clearCache(mContext);
        NavigationCacheHelper.clearNaviCache(mContext);
        ConnectionService.getInstance().initService(mContext, this.nativeObj, str);
        this.nativeObj.InitClient(str, mContext.getPackageName(), str2, this.dbPath, FileUtils.getCachePath(mContext, "ronglog"));
        ConnectionService.getInstance().initService(mContext, this.nativeObj, str);
        RtLogUploadManager.getInstance().init(mContext, BuildVar.SDK_VERSION, str2, str);
        this.mFileServer = null;
    }

    public void syncGroup(List<Group> list, final OperationCallback operationCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException(" groups 参数异常。");
        }
        String[] strArr = new String[list.size()];
        String[] strArr2 = new String[list.size()];
        int i = 0;
        for (Group group : list) {
            strArr[i] = group.getId();
            strArr2[i] = group.getName();
            i++;
        }
        this.nativeObj.SyncGroups(strArr, strArr2, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.33
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str, long j) {
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null) {
                    return;
                }
                if (i2 == 0) {
                    operationCallback2.onSuccess();
                } else {
                    operationCallback2.onError(i2);
                }
            }
        });
    }

    public boolean updateConversationInfo(Conversation.ConversationType conversationType, String str, String str2, String str3) {
        return this.nativeObj.UpdateConversationInfo(str, conversationType.getValue(), str2, str3);
    }

    public void updateMessageExpansion(final Map<String, String> map, final String str, final OperationCallback operationCallback) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        final NativeObject.Message messageGetMessageByUId = nativeObject.GetMessageByUId(str);
        final Message messageByUid = getMessageByUid(str);
        if (messageByUid == null || !messageByUid.isCanIncludeExpansion()) {
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND.getValue());
            }
        } else {
            if (!Conversation.ConversationType.PRIVATE.equals(messageByUid.getConversationType()) && !Conversation.ConversationType.GROUP.equals(messageByUid.getConversationType())) {
                if (operationCallback != null) {
                    RLog.e(TAG, "only private or group support expansion");
                    operationCallback.onError(RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND.getValue());
                    return;
                }
                return;
            }
            if (!judgeExpansionExceedLimit(map, messageGetMessageByUId)) {
                sendMessageOption(Message.obtain(messageByUid.getTargetId(), messageByUid.getConversationType(), MessageExpansionMessage.obtain(str, map)), null, null, null, null, new ISendMessageCallback<Message>() { // from class: io.rong.imlib.NativeClient.79
                    @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                    public void onAttached(Message message) {
                    }

                    @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                    public void onError(Message message, int i) {
                        RLog.i(NativeClient.TAG, "updateMessageExpansion onError = " + i);
                        OperationCallback operationCallback2 = operationCallback;
                        if (operationCallback2 != null) {
                            operationCallback2.onError(i);
                        }
                    }

                    @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                    public void onSuccess(Message message) {
                        boolean messageExpansion = NativeClient.this.setMessageExpansion(messageByUid.getTargetId(), messageByUid.getConversationType().getValue(), str, NativeClient.this.getMessageExpansion(message, map, messageGetMessageByUId.getExtMsg()));
                        OperationCallback operationCallback2 = operationCallback;
                        if (operationCallback2 != null) {
                            if (messageExpansion) {
                                operationCallback2.onSuccess();
                            } else {
                                operationCallback2.onError(RongIMClient.ErrorCode.RC_MESSAGE_EXPAND_FAIL.getValue());
                            }
                        }
                    }
                });
            } else if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.RC_MSG_EXPANSION_SIZE_LIMIT_EXCEED.getValue());
            }
        }
    }

    public boolean updateMessageReceiptStatus(String str, int i, long j) {
        return this.nativeObj.UpdateMessageReceiptStatus(str, i, j);
    }

    boolean updateReadReceiptRequestInfo(String str, String str2) {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject != null) {
            return nativeObject.UpdateReadReceiptRequestInfo(str, str2);
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public void updateVoIPCallInfo(String str) {
        NavigationCacheHelper.updateVoIPCallInfo(mContext, str);
    }

    public void uploadMedia(Message message, IResultProgressCallback<String> iResultProgressCallback) {
        if (message == null || message.getConversationType() == null || TextUtils.isEmpty(message.getTargetId()) || message.getContent() == null) {
            RLog.e(TAG, "conversation type or targetId or message content can't be null!");
            iResultProgressCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
            return;
        }
        Uri localPath = null;
        if (message.getContent() instanceof ImageMessage) {
            localPath = ((ImageMessage) message.getContent()).getLocalUri();
        } else if (message.getContent() instanceof GIFMessage) {
            if (((GIFMessage) message.getContent()).getGifDataSize() > getGIFLimitSize() * 1024) {
                RLog.e(TAG, "Gif size is too long! ");
                iResultProgressCallback.onError(RongIMClient.ErrorCode.RC_GIF_MSG_SIZE_LIMIT_EXCEED.getValue());
                return;
            }
            localPath = ((GIFMessage) message.getContent()).getLocalPath();
        } else if (message.getObjectName() == null || !message.getObjectName().equals("RC:SightMsg")) {
            if (message.getContent() instanceof HQVoiceMessage) {
                localPath = ((MediaMessageContent) message.getContent()).getLocalPath();
            } else if ((message.getObjectName() != null && message.getObjectName().equals("RC:CombineMsg")) || (message.getContent() instanceof MediaMessageContent)) {
                localPath = ((MediaMessageContent) message.getContent()).getLocalPath();
            }
        } else {
            if (((SightMessage) message.getContent()).getDuration() > getVideoLimitTime()) {
                RLog.e(TAG, "sight duration is too long! ");
                iResultProgressCallback.onError(RongIMClient.ErrorCode.RC_SIGHT_MSG_DURATION_LIMIT_EXCEED.getValue());
                return;
            }
            localPath = ((MediaMessageContent) message.getContent()).getLocalPath();
        }
        Uri uri = localPath;
        if (FileUtils.isFileExistsWithUri(mContext, uri)) {
            MediaUploadEngine.getInstance().uploadMedia(this.mWorkHandler, this.nativeObj, message, uri, this.mFileServer, iResultProgressCallback);
        } else {
            RLog.e(TAG, "local path of the media file can't be empty!");
            iResultProgressCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
        }
    }

    public boolean useRTCOnly() {
        NativeObject nativeObject = this.nativeObj;
        if (nativeObject != null) {
            return nativeObject.UseRTCOnly();
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    private NativeClient() {
        ConnectionService.getInstance();
    }

    private void internalSendMessage(final Message message, String str, String str2, String[] strArr, final ISendMessageCallback<Message> iSendMessageCallback, final MessageTag messageTag, byte[] bArr, int i, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        byte[] bArrEncode;
        Message messageEncryptMessageContentIfNeeded;
        byte[] bArr2;
        if (message.getConversationType() == Conversation.ConversationType.ENCRYPTED) {
            try {
                messageEncryptMessageContentIfNeeded = encryptMessageContentIfNeeded(bArr, message);
                bArrEncode = messageEncryptMessageContentIfNeeded.getContent().encode();
            } catch (RuntimeException e2) {
                RLog.e(TAG, "stop sending message cause exception occurs while calling encrypteMessageContent() -> " + e2.getLocalizedMessage());
                return;
            }
        } else {
            bArrEncode = bArr;
            messageEncryptMessageContentIfNeeded = message;
        }
        if (messageEncryptMessageContentIfNeeded.getContent() instanceof MediaMessageContent) {
            Uri localPath = ((MediaMessageContent) messageEncryptMessageContentIfNeeded.getContent()).getLocalPath();
            getMessageHandler(messageTag.value()).encodeMessage(message);
            ((MediaMessageContent) messageEncryptMessageContentIfNeeded.getContent()).setLocalPath(null);
            byte[] bArrEncode2 = messageEncryptMessageContentIfNeeded.getContent().encode();
            ((MediaMessageContent) messageEncryptMessageContentIfNeeded.getContent()).setLocalPath(localPath);
            bArr2 = bArrEncode2;
        } else {
            bArr2 = bArrEncode;
        }
        MessageConfig messageConfig = message.getMessageConfig();
        boolean zIsDisableNotification = messageConfig != null ? messageConfig.isDisableNotification() : false;
        NativeObject.PushConfig pushConfig = new NativeObject.PushConfig();
        MessagePushConfig messagePushConfig = message.getMessagePushConfig();
        if (messagePushConfig != null) {
            pushConfig.setPushTitle(messagePushConfig.getPushTitle());
            if (TextUtils.isEmpty(messagePushConfig.getPushContent())) {
                pushConfig.setPushContent(str);
            } else {
                pushConfig.setPushContent(messagePushConfig.getPushContent());
            }
            if (TextUtils.isEmpty(messagePushConfig.getPushData())) {
                pushConfig.setPushData(str2);
            } else {
                pushConfig.setPushData(messagePushConfig.getPushData());
            }
            pushConfig.setForceShowDetailContent(messagePushConfig.isForceShowDetailContent());
            if (messagePushConfig.getAndroidConfig() != null) {
                pushConfig.setNotificationId(messagePushConfig.getAndroidConfig().getNotificationId());
            }
            pushConfig.setChannelConfig(messagePushConfig.channelToJson());
        } else {
            pushConfig.setPushContent(str);
            pushConfig.setPushData(str2);
        }
        this.nativeObj.sendMessageWithOption(messageEncryptMessageContentIfNeeded.getTargetId(), messageEncryptMessageContentIfNeeded.getConversationType().getValue(), i, messageTag.value(), bArr2, pushConfig, messageEncryptMessageContentIfNeeded.getMessageId(), strArr, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.24
            @Override // io.rong.imlib.NativeObject.PublishAckListener
            public void operationComplete(int i2, String str4, long j) {
                RLog.d(NativeClient.TAG, "sendMessage code = " + i2 + ", id = " + message.getMessageId() + ", uid = " + str4 + " " + message.getObjectName());
                if (i2 == 0) {
                    message.setSentStatus(Message.SentStatus.SENT);
                    message.setSentTime(j);
                    message.setUId(str4);
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        iSendMessageCallback2.onSuccess(message);
                        return;
                    }
                    return;
                }
                FwLog.write(1, 1, FwLog.LogTag.P_SEND_MSG_S.getTag(), "code|type|id|tag", Integer.valueOf(i2), Integer.valueOf(message.getConversationType().getValue()), message.getTargetId(), messageTag.value());
                if (i2 == RongIMClient.ErrorCode.RC_MSG_BLOCKED_SENSITIVE_WORD.getValue()) {
                    NativeClient.this.nativeObj.SetSendStatus(message.getMessageId(), Message.SentStatus.FAILED.getValue());
                    message.setSentStatus(Message.SentStatus.FAILED);
                } else if (i2 == RongIMClient.ErrorCode.RC_MSG_REPLACED_SENSITIVE_WORD.getValue()) {
                    message.setSentStatus(Message.SentStatus.SENT);
                    message.setSentTime(j);
                    message.setUId(str4);
                } else {
                    message.setSentStatus(Message.SentStatus.FAILED);
                }
                ISendMessageCallback iSendMessageCallback3 = iSendMessageCallback;
                if (iSendMessageCallback3 != null) {
                    iSendMessageCallback3.onError(message, i2);
                }
            }
        }, z, z2, z3, zIsDisableNotification, z4, str3);
    }

    public void disconnect(boolean z) {
        ConnectionService.getInstance().disconnect(z);
    }

    public void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, String[] strArr, boolean z, ISendMessageCallback<Message> iSendMessageCallback) {
        if (this.nativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        if (message.getConversationType() == null || TextUtils.isEmpty(message.getTargetId()) || message.getContent() == null) {
            throw new IllegalArgumentException("message, ConversationType 或 TargetId 参数异常。");
        }
        MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        if (TextUtils.isEmpty(message.getSenderUserId())) {
            message.setSenderUserId(this.curUserId);
        }
        message.setMessageDirection(Message.MessageDirection.SEND);
        message.setSentStatus(Message.SentStatus.SENDING);
        message.setSentTime(System.currentTimeMillis());
        message.setObjectName(messageTag.value());
        boolean zIsCanIncludeExpansion = message.isCanIncludeExpansion();
        String strMapTsCombineJson = JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message));
        String strHashMapToJson = JSONUtils.hashMapToJson(message.getExpansion());
        byte[] bArr = new byte[1];
        if ((messageTag.flag() & 1) == 1 && message.getMessageId() <= 0) {
            MessageConfig messageConfig = message.getMessageConfig();
            int iSaveMessage = (int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), message.getSenderUserId(), bArr, false, 0, Message.SentStatus.SENDING.getValue(), System.currentTimeMillis(), getSearchableWord(message.getContent()), 1, "", messageConfig != null ? messageConfig.isDisableNotification() : false, zIsCanIncludeExpansion, strMapTsCombineJson);
            if (iSaveMessage < 0) {
                message.setSentStatus(Message.SentStatus.FAILED);
                if (iSaveMessage == RongIMClient.ErrorCode.PARAMETER_ERROR.getValue()) {
                    iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                    return;
                } else {
                    iSendMessageCallback.onError(message, RongIMClient.ErrorCode.BIZ_ERROR_DATABASE_ERROR.getValue());
                    return;
                }
            }
            message.setMessageId(iSaveMessage);
        }
        int i = messageTag.flag() == 16 ? 1 : 3;
        MessageHandler messageHandler = getMessageHandler(messageTag.value());
        if (messageHandler == null) {
            RLog.e(TAG, "sendMessage MessageHandler is null");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                return;
            }
            return;
        }
        messageHandler.encodeMessage(message);
        byte[] bArrEncode = message.getContent().encode();
        if (iSendMessageCallback != null) {
            iSendMessageCallback.onAttached(message);
        }
        boolean z2 = message.getContent().getMentionedInfo() != null;
        boolean zIsVoIPPush = sendMessageOption != null ? sendMessageOption.isVoIPPush() : false;
        if (message.getMessageId() > 0) {
            this.nativeObj.SetMessageContent(message.getMessageId(), bArrEncode, "");
        }
        internalSendMessage(message, str, str2, strArr, iSendMessageCallback, messageTag, bArrEncode, i, z2, zIsVoIPPush, z, zIsCanIncludeExpansion, strHashMapToJson);
    }

    public void sendMessage(Message message, String str, String str2, String[] strArr, ISendMessageCallback<Message> iSendMessageCallback) {
        if (this.nativeObj != null) {
            if (message.getConversationType() != null && !TextUtils.isEmpty(message.getTargetId()) && message.getContent() != null) {
                MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
                if (messageTag == null) {
                    RLog.e(TAG, "sendMessage MessageTag is null");
                    return;
                }
                if (TextUtils.isEmpty(message.getSenderUserId())) {
                    message.setSenderUserId(this.curUserId);
                }
                message.setMessageDirection(Message.MessageDirection.SEND);
                message.setSentStatus(Message.SentStatus.SENDING);
                message.setSentTime(System.currentTimeMillis());
                message.setObjectName(messageTag.value());
                boolean zIsCanIncludeExpansion = message.isCanIncludeExpansion();
                String strMapTsCombineJson = JSONUtils.mapTsCombineJson(message.getExpansion(), timeDisposal(message));
                String strHashMapToJson = JSONUtils.hashMapToJson(message.getExpansion());
                byte[] bArr = new byte[1];
                if ((messageTag.flag() & 1) == 1 && message.getMessageId() <= 0) {
                    MessageConfig messageConfig = message.getMessageConfig();
                    int iSaveMessage = (int) this.nativeObj.SaveMessage(message.getTargetId(), message.getConversationType().getValue(), messageTag.value(), message.getSenderUserId(), bArr, false, 0, Message.SentStatus.SENDING.getValue(), System.currentTimeMillis(), getSearchableWord(message.getContent()), 1, "", messageConfig != null ? messageConfig.isDisableNotification() : false, zIsCanIncludeExpansion, strMapTsCombineJson);
                    if (iSaveMessage < 0) {
                        message.setSentStatus(Message.SentStatus.FAILED);
                        if (iSaveMessage == RongIMClient.ErrorCode.PARAMETER_ERROR.getValue()) {
                            iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                            return;
                        } else {
                            iSendMessageCallback.onError(message, RongIMClient.ErrorCode.BIZ_ERROR_DATABASE_ERROR.getValue());
                            return;
                        }
                    }
                    message.setMessageId(iSaveMessage);
                }
                int i = messageTag.flag() == 16 ? 1 : 3;
                MessageHandler messageHandler = getMessageHandler(messageTag.value());
                if (messageHandler == null) {
                    RLog.e(TAG, "sendMessage MessageHandler is null");
                    if (iSendMessageCallback != null) {
                        iSendMessageCallback.onError(message, RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                        return;
                    }
                    return;
                }
                messageHandler.encodeMessage(message);
                byte[] bArrEncode = message.getContent().encode();
                if (iSendMessageCallback != null) {
                    iSendMessageCallback.onAttached(message);
                }
                boolean z = message.getContent().getMentionedInfo() != null;
                if (message.getMessageId() > 0) {
                    this.nativeObj.SetMessageContent(message.getMessageId(), bArrEncode, "");
                }
                internalSendMessage(message, str, str2, strArr, iSendMessageCallback, messageTag, bArrEncode, i, z, zIsCanIncludeExpansion, strHashMapToJson);
                return;
            }
            throw new IllegalArgumentException("message, ConversationType 或 TargetId 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public int getTotalUnreadCount(Conversation... conversationArr) {
        NativeObject.Conversation[] conversationArr2 = new NativeObject.Conversation[conversationArr.length];
        for (int i = 0; i < conversationArr.length; i++) {
            NativeObject.Conversation conversation = new NativeObject.Conversation();
            conversation.setConversationType(conversationArr[i].getConversationType().getValue());
            conversation.setTargetId(conversationArr[i].getTargetId());
            conversationArr2[i] = conversation;
        }
        return this.nativeObj.GetDNDUnreadCount(conversationArr2);
    }

    void registerCmdMsgType(List<String> list) {
        if (list != null && list.size() != 0) {
            this.mCmdObjectNameSet.addAll(list);
            this.nativeObj.RegisterCmdMsgType((String[]) list.toArray(new String[0]));
        } else {
            RLog.d(TAG, "registerCmdMsgType list is empty");
        }
    }

    public List<Conversation> getConversationList(int[] iArr) {
        NativeObject.Conversation[] conversationArrGetConversationListEx;
        try {
            conversationArrGetConversationListEx = this.nativeObj.GetConversationListEx(iArr);
        } catch (Exception e2) {
            RLog.e(TAG, "getConversationList Exception", e2);
            conversationArrGetConversationListEx = null;
        }
        if (conversationArrGetConversationListEx == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeObject.Conversation conversation : conversationArrGetConversationListEx) {
            arrayList.add(renderConversationFromNative(conversation));
        }
        return arrayList;
    }

    public int getUnreadCount(Conversation.ConversationType... conversationTypeArr) {
        if (this.nativeObj != null) {
            if (conversationTypeArr != null && conversationTypeArr.length != 0) {
                int[] iArr = new int[conversationTypeArr.length];
                int i = 0;
                for (Conversation.ConversationType conversationType : conversationTypeArr) {
                    iArr[i] = conversationType.getValue();
                    i++;
                }
                return this.nativeObj.GetCateUnreadCount(iArr, true);
            }
            throw new IllegalArgumentException("ConversationTypes 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public void deleteMessages(Conversation.ConversationType conversationType, String str, Message[] messageArr, final OperationCallback operationCallback) {
        if (this.nativeObj != null) {
            if (messageArr != null && messageArr.length != 0) {
                NativeObject.Message[] messageArr2 = new NativeObject.Message[messageArr.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < messageArr.length; i++) {
                    messageArr2[i] = new NativeObject.Message();
                    messageArr2[i].setUId(messageArr[i].getUId());
                    messageArr2[i].setSentTime(messageArr[i].getSentTime());
                    messageArr2[i].setMessageDirection(messageArr[i].getMessageDirection().equals(Message.MessageDirection.RECEIVE));
                    sb.append(messageArr[i].getUId());
                    sb.append("/");
                }
                FwLog.write(4, 1, FwLog.LogTag.L_DELETE_MESSAGES_S.getTag(), "messageUIds:", sb.toString());
                this.nativeObj.DeleteRemoteMessages(conversationType.getValue(), str, messageArr2, true, new NativeObject.PublishAckListener() { // from class: io.rong.imlib.NativeClient.13
                    @Override // io.rong.imlib.NativeObject.PublishAckListener
                    public void operationComplete(int i2, String str2, long j) {
                        OperationCallback operationCallback2 = operationCallback;
                        if (operationCallback2 == null) {
                            return;
                        }
                        if (i2 == 0) {
                            operationCallback2.onSuccess();
                        } else {
                            operationCallback2.onError(i2);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("messages 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, RemoteHistoryMsgOption remoteHistoryMsgOption, final IResultCallback<List<Message>> iResultCallback) {
        RLog.i(TAG, "getRemoteHistoryMessages call");
        if (this.nativeObj != null) {
            if (conversationType != null && !TextUtils.isEmpty(str) && iResultCallback != null) {
                String strTrim = str.trim();
                if (NavigationClient.getInstance().isGetRemoteHistoryEnabled(mContext)) {
                    this.nativeObj.LoadHistoryMessageOption(strTrim, conversationType.getValue(), remoteHistoryMsgOption.getDataTime(), remoteHistoryMsgOption.getCount(), remoteHistoryMsgOption.getOrder(), remoteHistoryMsgOption.isIncludeLocalExistMessage(), new NativeObject.HistoryMessageListener() { // from class: io.rong.imlib.NativeClient.6
                        @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                        public void onError(int i) {
                            iResultCallback.onError(i);
                        }

                        @Override // io.rong.imlib.NativeObject.HistoryMessageListener
                        public void onReceived(NativeObject.Message[] messageArr, long j) {
                            ArrayList arrayList = new ArrayList();
                            if (messageArr != null && messageArr.length > 0) {
                                for (NativeObject.Message message : messageArr) {
                                    Message message2 = new Message(message);
                                    message2.setContent(NativeClient.this.renderMessageContent(message.getObjectName(), message.getContent(), message2));
                                    arrayList.add(message2);
                                }
                            }
                            iResultCallback.onSuccess(arrayList);
                        }
                    });
                    return;
                } else {
                    iResultCallback.onError(33007);
                    return;
                }
            }
            throw new IllegalArgumentException("ConversationTypes，callback 或 targetId 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public void registerMessageType(List<Class<? extends MessageContent>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Class<? extends MessageContent> cls : list) {
            try {
                MessageTag messageTag = (MessageTag) cls.getAnnotation(MessageTag.class);
                if (messageTag != null) {
                    String strValue = messageTag.value();
                    Constructor<? extends MessageContent> declaredConstructor = cls.getDeclaredConstructor(byte[].class);
                    this.messageHandlerMap.put(strValue, messageTag.messageHandler().getConstructor(Context.class).newInstance(mContext));
                    this.messageContentConstructorMap.put(strValue, declaredConstructor);
                    registerMessageType(strValue, messageTag.flag());
                } else {
                    FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "tag is null,messageType is" + cls.getName(), new Object[0]);
                }
            } catch (Throwable unused) {
                FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "register is error,messageType is " + cls.getName(), new Object[0]);
            }
        }
    }

    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, String str2, int i, int i2) {
        if (this.nativeObj != null) {
            if (conversationType != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                NativeObject.Message[] messageArrGetHistoryMessagesEx = this.nativeObj.GetHistoryMessagesEx(str.trim(), conversationType.getValue(), str2, i, i2, true);
                ArrayList arrayList = new ArrayList();
                if (messageArrGetHistoryMessagesEx == null) {
                    return null;
                }
                for (NativeObject.Message message : messageArrGetHistoryMessagesEx) {
                    Message message2 = new Message(message);
                    message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                    arrayList.add(message2);
                }
                return arrayList;
            }
            throw new IllegalArgumentException("ConversationTypes, objectName 或 targetId 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public int getUnreadCount(boolean z, Conversation.ConversationType... conversationTypeArr) {
        if (this.nativeObj != null) {
            if (conversationTypeArr != null && conversationTypeArr.length != 0) {
                int[] iArr = new int[conversationTypeArr.length];
                int i = 0;
                for (Conversation.ConversationType conversationType : conversationTypeArr) {
                    iArr[i] = conversationType.getValue();
                    i++;
                }
                return this.nativeObj.GetCateUnreadCount(iArr, z);
            }
            throw new IllegalArgumentException("ConversationTypes 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    private void registerMessageType(String str, int i) {
        if (i == 16) {
            i = 0;
        }
        this.nativeObj.RegisterMessageType(str, i);
    }

    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, String str2, int i, int i2, boolean z) {
        if (this.nativeObj != null) {
            if (conversationType != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                NativeObject.Message[] messageArrGetHistoryMessagesEx = this.nativeObj.GetHistoryMessagesEx(str.trim(), conversationType.getValue(), str2, i, i2, z);
                ArrayList arrayList = new ArrayList();
                if (messageArrGetHistoryMessagesEx == null) {
                    return null;
                }
                for (NativeObject.Message message : messageArrGetHistoryMessagesEx) {
                    Message message2 = new Message(message);
                    message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                    arrayList.add(message2);
                }
                return arrayList;
            }
            throw new IllegalArgumentException("ConversationTypes, objectName 或 targetId 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public List<Message> getHistoryMessages(Conversation.ConversationType conversationType, String str, List<String> list, long j, int i, boolean z) {
        if (this.nativeObj != null) {
            if (conversationType != null && !TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                NativeObject.Message[] messageArrGetHistoryMessagesByObjectNames = this.nativeObj.GetHistoryMessagesByObjectNames(str.trim(), conversationType.getValue(), (String[]) list.toArray(new String[list.size()]), j, i, z);
                ArrayList arrayList = new ArrayList();
                if (messageArrGetHistoryMessagesByObjectNames == null) {
                    return null;
                }
                for (NativeObject.Message message : messageArrGetHistoryMessagesByObjectNames) {
                    Message message2 = new Message(message);
                    message2.setContent(renderMessageContent(message.getObjectName(), message.getContent(), message2));
                    arrayList.add(message2);
                }
                return arrayList;
            }
            throw new IllegalArgumentException("ConversationTypes, objectName 或 targetId 参数异常。");
        }
        throw new RuntimeException("NativeClient 尚未初始化!");
    }

    public void sendMediaMessage(Message message, String str, String str2, ISendMediaMessageCallback<Message> iSendMediaMessageCallback) {
        sendMediaMessage(message, null, str, str2, iSendMediaMessageCallback);
    }
}
