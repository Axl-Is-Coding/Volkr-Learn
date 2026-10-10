package io.rong.imlib;

import android.content.Context;
import io.rong.common.RLog;
import io.rong.common.rlog.IRealTimeLogListener;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.ChatroomStatus;
import io.rong.imlib.model.ConversationStatus;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.RTCUser;
import io.rong.imlib.relinker.ReLinker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class NativeObject {
    private static final String TAG = "NativeObject";

    public static class AccountInfo {
        private byte[] accountId;
        private byte[] accountName;
        private int accountType;
        private byte[] accountUri;
        private byte[] extra;

        public byte[] getAccountId() {
            return this.accountId;
        }

        public byte[] getAccountName() {
            return this.accountName;
        }

        public int getAccountType() {
            return this.accountType;
        }

        public byte[] getAccountUri() {
            return this.accountUri;
        }

        public byte[] getExtra() {
            return this.extra;
        }

        public void setAccountId(byte[] bArr) {
            this.accountId = bArr;
        }

        public void setAccountName(byte[] bArr) {
            this.accountName = bArr;
        }

        public void setAccountType(int i) {
            this.accountType = i;
        }

        public void setAccountUri(byte[] bArr) {
            this.accountUri = bArr;
        }

        public void setExtra(byte[] bArr) {
            this.extra = bArr;
        }
    }

    public interface AccountInfoListener {
        void OnError(int i);

        void onReceived(AccountInfo[] accountInfoArr);
    }

    public interface BizAckListener {
        void operationComplete(int i, int i2);
    }

    public interface ChatroomInfoListener {
        void OnError(int i);

        void OnSuccess(int i, UserInfo[] userInfoArr);
    }

    public static class ConnectionEntry {
        private int duration;
        private int error = -1;
        private String host;
        private int netType;
        private int port;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ConnectionEntry.class != obj.getClass()) {
                return false;
            }
            ConnectionEntry connectionEntry = (ConnectionEntry) obj;
            if (this.port != connectionEntry.port) {
                return false;
            }
            String str = this.host;
            return str != null ? str.equals(connectionEntry.host) : connectionEntry.host == null;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getError() {
            return this.error;
        }

        public String getHost() {
            return this.host;
        }

        public int getNetType() {
            return this.netType;
        }

        public int getPort() {
            return this.port;
        }

        public int hashCode() {
            String str = this.host;
            return ((str != null ? str.hashCode() : 0) * 31) + this.port;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public void setError(int i) {
            this.error = i;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setNetType(int i) {
            this.netType = i;
        }

        public void setPort(int i) {
            this.port = i;
        }
    }

    public interface ConnectionStatusListener {
        void OnDatabaseOpened(int i);

        void OnPongReceived();

        void OnRmtpComplete(int i, String str, int i2, short s, String str2);

        void OnRmtpDisconnected(int i, int i2, String str);

        void OnTcpComplete(ConnectionEntry connectionEntry);
    }

    public static class Conversation {
        private long ReceivedTime;
        private String UId;
        private boolean blockPush;
        private byte[] content;
        private String conversationTitle;
        private int conversationType;
        private String draft;
        private String extra;
        private boolean isTop;
        private long lastTime;
        private int matchCount;
        private int mentionCount;
        private String messageContent;
        private boolean messageDirection;
        private long messageId;
        private String objectName;
        private String portraitUrl;
        private int readStatus;
        private int receiveStatus;
        private String senderName;
        private String senderUserId;
        private int sentStatus;
        private long sentTime;
        private String targetId;
        private int unreadMessageCount;
        private String userId;
        private String userName;
        private String userPortrait;

        public Conversation(String str) {
        }

        public byte[] getContent() {
            return this.content;
        }

        public String getConversationTitle() {
            return this.conversationTitle;
        }

        public int getConversationType() {
            return this.conversationType;
        }

        public String getDraft() {
            return this.draft;
        }

        public String getExtra() {
            return this.extra;
        }

        public long getLastTime() {
            return this.lastTime;
        }

        public int getMatchCount() {
            return this.matchCount;
        }

        public int getMentionCount() {
            return this.mentionCount;
        }

        public String getMessageContent() {
            return this.messageContent;
        }

        public long getMessageId() {
            return this.messageId;
        }

        public String getObjectName() {
            return this.objectName;
        }

        public String getPortraitUrl() {
            return this.portraitUrl;
        }

        public int getReadStatus() {
            return this.readStatus;
        }

        public int getReceiveStatus() {
            return this.receiveStatus;
        }

        public long getReceivedTime() {
            return this.ReceivedTime;
        }

        public String getSenderName() {
            return this.senderName;
        }

        public String getSenderUserId() {
            return this.senderUserId;
        }

        public int getSentStatus() {
            return this.sentStatus;
        }

        public long getSentTime() {
            return this.sentTime;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public String getUId() {
            return this.UId;
        }

        public int getUnreadMessageCount() {
            return this.unreadMessageCount;
        }

        public String getUserId() {
            return this.userId;
        }

        public String getUserName() {
            return this.userName;
        }

        public String getUserPortrait() {
            return this.userPortrait;
        }

        public boolean isBlockPush() {
            return this.blockPush;
        }

        public boolean isMessageDirection() {
            return this.messageDirection;
        }

        public boolean isTop() {
            return this.isTop;
        }

        public void setBlockPush(boolean z) {
            this.blockPush = z;
        }

        public void setContent(byte[] bArr) {
            this.content = bArr;
        }

        public void setConversationTitle(byte[] bArr) {
            this.conversationTitle = new String(bArr);
        }

        public void setConversationType(int i) {
            this.conversationType = i;
        }

        public void setDraft(String str) {
            this.draft = str;
        }

        public void setExtra(String str) {
            this.extra = str;
        }

        public void setIsTop(boolean z) {
            this.isTop = z;
        }

        public void setLastTime(long j) {
            this.lastTime = j;
        }

        public void setMatchCount(int i) {
            this.matchCount = i;
        }

        public void setMentionCount(int i) {
            this.mentionCount = i;
        }

        public void setMessageContent(String str) {
            this.messageContent = str;
        }

        public void setMessageDirection(boolean z) {
            this.messageDirection = z;
        }

        public void setMessageId(long j) {
            this.messageId = j;
        }

        public void setObjectName(String str) {
            this.objectName = str;
        }

        public void setPortraitUrl(String str) {
            this.portraitUrl = str;
        }

        public void setReadStatus(int i) {
            this.readStatus = i;
        }

        public void setReceiveStatus(int i) {
            this.receiveStatus = i;
        }

        public void setReceivedTime(long j) {
            this.ReceivedTime = j;
        }

        public void setSenderName(String str) {
            this.senderName = str;
        }

        public void setSenderUserId(String str) {
            this.senderUserId = str;
        }

        public void setSentStatus(int i) {
            this.sentStatus = i;
        }

        public void setSentTime(long j) {
            this.sentTime = j;
        }

        public void setTargetId(String str) {
            this.targetId = str;
        }

        public void setTop(boolean z) {
            this.isTop = z;
        }

        public void setUId(String str) {
            this.UId = str;
        }

        public void setUnreadMessageCount(int i) {
            this.unreadMessageCount = i;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public void setUserPortrait(String str) {
            this.userPortrait = str;
        }

        public Conversation() {
        }
    }

    public interface ConversationStatusListener {
        void OnStatusChanged(ConversationStatus[] conversationStatusArr);
    }

    public interface CreateDiscussionCallback {
        void OnError(int i);

        void OnSuccess(String str);
    }

    public static class DiscussionInfo {
        private String adminId;
        private String discussionId;
        private String discussionName;
        private int inviteStatus;
        private String userIds;

        public String getAdminId() {
            return this.adminId;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public String getDiscussionName() {
            return this.discussionName;
        }

        public int getInviteStatus() {
            return this.inviteStatus;
        }

        public String getUserIds() {
            return this.userIds;
        }

        public void setAdminId(String str) {
            this.adminId = str;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }

        public void setDiscussionName(byte[] bArr) {
            this.discussionName = new String(bArr);
        }

        public void setInviteStatus(int i) {
            this.inviteStatus = i;
        }

        public void setUserIds(String str) {
            this.userIds = str;
        }
    }

    public interface DiscussionInfoListener {
        void OnError(int i);

        void onReceived(DiscussionInfo discussionInfo);
    }

    public interface FileTokenListener {
        void OnError(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public interface GetSearchableWordListener {
        byte[] getSearchableWord(String str, byte[] bArr);
    }

    public interface GetUserDataListener {
        void OnError(int i);

        void OnSuccess(String str);
    }

    public interface HistoryMessageListener {
        void onError(int i);

        void onReceived(Message[] messageArr, long j);
    }

    public interface NativeLogInfoListener {
        void OnLogInfo(String str, boolean z);
    }

    public interface PublishAckListener {
        void operationComplete(int i, String str, long j);
    }

    public static class PushConfig {
        private String channelConfig;
        private boolean disablePushTitle;
        private boolean forceShowDetailContent;
        private String notificationId;
        private String pushContent;
        private String pushData;
        private String pushTitle;

        public String getChannelConfig() {
            return this.channelConfig;
        }

        public String getNotificationId() {
            return this.notificationId;
        }

        public String getPushContent() {
            return this.pushContent;
        }

        public String getPushData() {
            return this.pushData;
        }

        public String getPushTitle() {
            return this.pushTitle;
        }

        public boolean isDisablePushTitle() {
            return this.disablePushTitle;
        }

        public boolean isForceShowDetailContent() {
            return this.forceShowDetailContent;
        }

        public void setChannelConfig(String str) {
            this.channelConfig = str;
        }

        public void setDisablePushTitle(boolean z) {
            this.disablePushTitle = z;
        }

        public void setForceShowDetailContent(boolean z) {
            this.forceShowDetailContent = z;
        }

        public void setNotificationId(String str) {
            this.notificationId = str;
        }

        public void setPushContent(String str) {
            this.pushContent = str;
        }

        public void setPushData(String str) {
            this.pushData = str;
        }

        public void setPushTitle(String str) {
            this.pushTitle = str;
        }
    }

    public interface PushSettingListener {
        void OnError(int i);

        void OnSuccess(String str, int i);
    }

    public interface RTCConfigListener {
        void onError(int i);

        void onSuccess(String str, long j);
    }

    public interface RTCDataListener {
        void OnError(int i);

        void OnSuccess(Map<String, String> map);
    }

    public interface RTCHeartbeatListener {
        void OnRTCHeartbeat(int i, String str);
    }

    public interface RTCUserInfoListener {
        void OnError(int i);

        void OnSuccess(RTCUser[] rTCUserArr, String str, String str2);
    }

    public static class ReceiptInfo {
        private byte[] targetId;
        private long timestamp;

        public byte[] getTargetId() {
            return this.targetId;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTargetId(byte[] bArr) {
            this.targetId = bArr;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }
    }

    public static abstract class ReceiveMessageListener {
        public abstract void onReceived(Message message, int i, boolean z, boolean z2, int i2);

        public abstract void onReceived(Message[] messageArr, boolean z, int i);
    }

    public interface SetBlacklistListener {
        void OnError(int i);

        void OnSuccess(String str);
    }

    interface SetOfflineMessageDurationListener {
        void onError(int i);

        void onSuccess(long j);
    }

    public interface SetPushSettingListener {
        void onError(int i);

        void onSuccess(long j);
    }

    public static class StatusData {
        boolean autoDelete;
        String key;
        boolean overwrite;
        String value;

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isAutoDelete() {
            return this.autoDelete;
        }

        public boolean isOverwrite() {
            return this.overwrite;
        }

        public void setAutoDelete(boolean z) {
            this.autoDelete = z;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setOverwrite(boolean z) {
            this.overwrite = z;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class StatusNotification {
        int attributeFlag;
        int conversationType;
        String messageContent;
        boolean notifyAll;
        String objectName;

        public int getAttributeFlag() {
            return this.attributeFlag;
        }

        public int getConversationType() {
            return this.conversationType;
        }

        public String getMessageContent() {
            return this.messageContent;
        }

        public String getObjectName() {
            return this.objectName;
        }

        public boolean isNotifyAll() {
            return this.notifyAll;
        }

        public void setAttributeFlag(int i) {
            this.attributeFlag = i;
        }

        public void setConversationType(int i) {
            this.conversationType = i;
        }

        public void setMessageContent(String str) {
            this.messageContent = str;
        }

        public void setNotifyAll(boolean z) {
            this.notifyAll = z;
        }

        public void setObjectName(String str) {
            this.objectName = str;
        }
    }

    public interface StatusNotificationListener {
        void OnKVChanged(ChatroomStatus[] chatroomStatusArr);

        void OnStatusChanged(String str);
    }

    public interface TokenListener {
        void OnError(int i, String str);
    }

    public static class UserInfo {
        private String accountExtra;
        private int categoryId;
        private long joinTime;
        private String url;
        private String userId;
        private String userName;

        public String getAccountExtra() {
            return this.accountExtra;
        }

        public int getCategoryId() {
            return this.categoryId;
        }

        public long getJoinTime() {
            return this.joinTime;
        }

        public String getUrl() {
            return this.url;
        }

        public String getUserId() {
            return this.userId;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setAccountExtra(String str) {
            this.accountExtra = str;
        }

        public void setCategoryId(int i) {
            this.categoryId = i;
        }

        public void setJoinTime(long j) {
            this.joinTime = j;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    public static class UserProfile {
        String clientIp;
        int groupMessageLimit;
        String identification;
        boolean ipv6Preferred;
        boolean kvStorageOpened;
        boolean publicService;
        boolean pushSetting;
        boolean sdkReconnect;

        public String getClientIp() {
            return this.clientIp;
        }

        public int getGroupMessageLimit() {
            return this.groupMessageLimit;
        }

        public String getIdentification() {
            return this.identification;
        }

        public boolean isIpv6Preferred() {
            return this.ipv6Preferred;
        }

        public boolean isKvStorageOpened() {
            return this.kvStorageOpened;
        }

        public boolean isPublicService() {
            return this.publicService;
        }

        public boolean isPushSetting() {
            return this.pushSetting;
        }

        public boolean isSdkReconnect() {
            return this.sdkReconnect;
        }

        public void setClientIp(String str) {
            this.clientIp = str;
        }

        public void setGroupMessageLimit(int i) {
            this.groupMessageLimit = i;
        }

        public void setIdentification(String str) {
            this.identification = str;
        }

        public void setIpv6Preferred(boolean z) {
            this.ipv6Preferred = z;
        }

        public void setKvStorageOpened(boolean z) {
            this.kvStorageOpened = z;
        }

        public void setPublicService(boolean z) {
            this.publicService = z;
        }

        public void setPushSetting(boolean z) {
            this.pushSetting = z;
        }

        public void setSdkReconnect(boolean z) {
            this.sdkReconnect = z;
        }
    }

    public interface UserStatusListener {
        void onStatusReceived(String str, String str2);
    }

    NativeObject(Context context) {
        ReLinker.log(new ReLinker.Logger() { // from class: io.rong.imlib.NativeObject.1
            @Override // io.rong.imlib.relinker.ReLinker.Logger
            public void log(String str) {
                RLog.d(NativeObject.TAG, "load RongIMLib:" + str);
            }
        }).recursively().loadLibrary(context, "RongIMLib");
    }

    protected native void AddPushSetting(String str, int i, PublishAckListener publishAckListener);

    protected native void AddToBlacklist(String str, PublishAckListener publishAckListener);

    protected native boolean CleanHistoryMessages(int i, String str, long j);

    protected native void CleanRemoteHistoryMessage(int i, String str, long j, PublishAckListener publishAckListener);

    protected native boolean ClearConversations(int[] iArr);

    protected native boolean ClearEncryptedConversations();

    protected native boolean ClearMessages(int i, String str, boolean z);

    protected native boolean ClearUnread(int i, String str);

    protected native boolean ClearUnreadByReceipt(String str, int i, long j);

    protected native int Connect(String str, ConnectionEntry[] connectionEntryArr, String str2, UserProfile userProfile);

    protected native boolean CreateEncryptedConversation(String str, String str2, String str3, String str4, String str5, int i);

    protected native void CreateInviteDiscussion(String str, String[] strArr, CreateDiscussionCallback createDiscussionCallback);

    protected native void DeleteChatRoomStatus(String str, StatusData statusData, StatusNotification statusNotification, PublishAckListener publishAckListener);

    protected native boolean DeleteMessages(long[] jArr);

    protected native void DeleteRemoteMessages(int i, String str, Message[] messageArr, boolean z, PublishAckListener publishAckListener);

    protected native void Disconnect(int i);

    protected native int EnvironmentChangeNotify(int i);

    protected native void ExitRTCRoom(String str, PublishAckListener publishAckListener);

    protected native void GetBlacklist(SetBlacklistListener setBlacklistListener);

    protected native void GetBlacklistStatus(String str, BizAckListener bizAckListener);

    protected native int GetBlockPush(String str, int i);

    protected native Conversation[] GetBlockedConversations(int[] iArr);

    protected native int GetCateUnreadCount(int[] iArr, boolean z);

    protected native HashMap<String, String> GetChatRoomStatus(String str);

    protected native String GetChatRoomStatusByKey(String str, String str2);

    protected native void GetChatroomHistoryMessage(String str, long j, int i, int i2, HistoryMessageListener historyMessageListener);

    protected native Conversation GetConversationEx(String str, int i);

    protected native Conversation[] GetConversationList(int[] iArr, long j, int i);

    protected native Conversation[] GetConversationListEx(int[] iArr);

    protected native int GetDNDUnreadCount(Conversation[] conversationArr);

    protected native long GetDeltaTime();

    protected native void GetDiscussionInfo(String str, DiscussionInfoListener discussionInfoListener);

    protected native DiscussionInfo GetDiscussionInfoSync(String str);

    public native void GetDownloadUrl(int i, String str, String str2, TokenListener tokenListener, boolean z);

    protected native RCEncryptedSession GetEncryptedConversationInfo(String str);

    protected native List<RCEncryptedSession> GetEncryptedConversations();

    protected native Message[] GetHistoryMessagesByObjectNames(String str, int i, String[] strArr, long j, int i2, boolean z);

    protected native Message[] GetHistoryMessagesEx(String str, int i, String str2, int i2, int i3, boolean z);

    protected native String GetHttpDnsAccountId();

    protected native String GetHttpDnsSecret();

    protected native Message[] GetMatchedMessages(String str, int i, long j, int i2, int i3);

    protected native Message[] GetMentionMessages(String str, int i);

    protected native Message GetMessageById(long j);

    protected native Message GetMessageByUId(String str);

    protected native int GetMessageCount(String str, int i);

    protected native String GetOfflineMessageDuration();

    protected native String GetPushSetting(int i);

    protected native void GetRTCConfig(String str, String str2, long j, String str3, RTCConfigListener rTCConfigListener);

    protected native String GetRTCProfile();

    protected native void GetRTCUserData(String str, int i, RTCUserInfoListener rTCUserInfoListener);

    protected native void GetRTCUsers(String str, int i, RTCUserInfoListener rTCUserInfoListener);

    protected native long GetSendTimeByMessageId(long j);

    protected native String GetTextMessageDraft(int i, String str);

    protected native Message GetTheFirstUnreadMessage(int i, String str);

    protected native Conversation[] GetTopConversations(int[] iArr);

    protected native int GetTotalUnreadCount();

    protected native int GetUnreadCount(String str, int i);

    public native void GetUploadToken(int i, String str, FileTokenListener fileTokenListener);

    protected native UserInfo GetUserInfoExSync(String str, int i);

    protected native void GetUserStatus(String str, CreateDiscussionCallback createDiscussionCallback);

    protected native void GetVendorToken(String str, TokenListener tokenListener);

    protected native void GetVoIPKey(int i, String str, String str2, TokenListener tokenListener);

    protected native int InitClient(String str, String str2, String str3, String str4, String str5);

    protected native void InviteMemberToDiscussion(String str, String[] strArr, PublishAckListener publishAckListener);

    protected native void JoinChatRoom(String str, int i, int i2, boolean z, PublishAckListener publishAckListener);

    protected native void JoinExistingChatroom(String str, int i, int i2, PublishAckListener publishAckListener, boolean z);

    protected native void JoinGroup(String str, String str2, PublishAckListener publishAckListener);

    protected native void JoinRTCRoomAndGetData(String str, int i, int i2, RTCUserInfoListener rTCUserInfoListener);

    protected native void JoinRTCRoomAndGetData(String str, int i, int i2, String str2, String str3, RTCUserInfoListener rTCUserInfoListener);

    protected native AccountInfo[] LoadAccountInfo();

    protected native void LoadHistoryMessage(String str, int i, long j, int i2, HistoryMessageListener historyMessageListener);

    protected native void LoadHistoryMessageOption(String str, int i, long j, int i2, int i3, boolean z, HistoryMessageListener historyMessageListener);

    protected native boolean QueryChatroomInfo(String str, int i, int i2, ChatroomInfoListener chatroomInfoListener);

    protected native void QueryPushSetting(PushSettingListener pushSettingListener);

    protected native void QuitChatRoom(String str, int i, PublishAckListener publishAckListener);

    protected native void QuitDiscussion(String str, PublishAckListener publishAckListener);

    protected native void QuitGroup(String str, PublishAckListener publishAckListener);

    protected native void RTCDeleteInnerData(String str, int i, String[] strArr, String str2, String str3, PublishAckListener publishAckListener);

    protected native void RTCDeleteOuterData(String str, int i, String[] strArr, String str2, String str3, PublishAckListener publishAckListener);

    protected native void RTCGetInnerData(String str, int i, String[] strArr, RTCDataListener rTCDataListener);

    protected native void RTCGetOuterData(String str, int i, String[] strArr, RTCDataListener rTCDataListener);

    protected native void RTCGetToken(String str, int i, int i2, TokenListener tokenListener);

    protected native void RTCGetUserData(String str, String[] strArr, RTCUserInfoListener rTCUserInfoListener);

    protected native void RTCPutInnerDatum(String str, int i, String str2, String str3, String str4, String str5, PublishAckListener publishAckListener);

    protected native void RTCPutOuterDatum(String str, int i, String str2, String str3, String str4, String str5, PublishAckListener publishAckListener);

    protected native void RTCSetUserData(String str, int i, Map<String, String> map, String str2, String str3, PublishAckListener publishAckListener);

    protected native void RTCSetUserResource(String str, StatusData[] statusDataArr, String str2, StatusData[] statusDataArr2, PublishAckListener publishAckListener);

    protected native void RTCSetUserState(String str, String str2, PublishAckListener publishAckListener);

    protected native void RecallMessage(String str, byte[] bArr, String str2, long j, String str3, int i, PublishAckListener publishAckListener, boolean z);

    protected native int RegisterCmdMsgType(String[] strArr);

    protected native int RegisterDeleteMessageType(String[] strArr);

    protected native int RegisterMessage(Conversation[] conversationArr);

    protected native int RegisterMessageType(String str, int i);

    protected native boolean RemoveConversation(int i, String str);

    protected native boolean RemoveEncryptedConversation(String str);

    protected native void RemoveFromBlacklist(String str, PublishAckListener publishAckListener);

    protected native void RemoveMemberFromDiscussion(String str, String str2, PublishAckListener publishAckListener);

    protected native boolean RemoveMemberFromDiscussionSync(String str, String str2);

    protected native void RemovePushSetting(PublishAckListener publishAckListener);

    protected native void RenameDiscussion(String str, String str2, PublishAckListener publishAckListener);

    protected native long SaveMessage(String str, int i, String str2, String str3, byte[] bArr, boolean z, int i2, int i3, long j, String str4, int i4, String str5, boolean z2, boolean z3, String str6);

    protected native void SearchAccount(String str, int i, int i2, AccountInfoListener accountInfoListener);

    protected native Conversation[] SearchConversations(String str, int[] iArr, String[] strArr);

    protected native Message[] SearchMessages(String str, int i, String str2, int i2, long j);

    protected native Message[] SearchMessagesByUser(String str, int i, String str2, int i2, long j);

    protected native void SendMessage(String str, int i, int i2, String str2, byte[] bArr, PushConfig pushConfig, long j, String[] strArr, PublishAckListener publishAckListener, boolean z, boolean z2, boolean z3, String str3);

    protected native void SendRTCHeartbeat(String[] strArr);

    protected native void SendRTCPing(String str, PublishAckListener publishAckListener);

    protected native void SetBlockPush(String str, int i, boolean z, PublishAckListener publishAckListener);

    protected native void SetChatRoomStatus(String str, StatusData statusData, StatusNotification statusNotification, PublishAckListener publishAckListener);

    protected native void SetChatRoomStatusNotificationListener(StatusNotificationListener statusNotificationListener);

    protected native void SetConnectionStatusListener(ConnectionStatusListener connectionStatusListener);

    protected native void SetConversationStatusListener(ConversationStatusListener conversationStatusListener);

    protected native int SetDeviceInfo(String str, String str2, String str3, String str4, String str5);

    protected native boolean SetEncryptedConversationInfo(String str, String str2, String str3, String str4, String str5, int i);

    protected native int SetEnvironment(boolean z);

    protected native boolean SetExtraMessageAttribute(String str, int i, String str2, String str3);

    protected native void SetGetSearchableWordListener(GetSearchableWordListener getSearchableWordListener);

    protected native void SetInviteStatus(String str, int i, PublishAckListener publishAckListener);

    protected native boolean SetIsTop(int i, String str, boolean z, boolean z2);

    protected native void SetLogStatus(int i, NativeLogInfoListener nativeLogInfoListener);

    protected native boolean SetMessageContent(long j, byte[] bArr, String str);

    protected native boolean SetMessageExtra(long j, String str);

    protected native void SetMessageListener(ReceiveMessageListener receiveMessageListener);

    protected native void SetOfflineMessageDuration(String str, SetOfflineMessageDurationListener setOfflineMessageDurationListener);

    protected native void SetPushNotificationListener(NativeClient.PushNotificationListener pushNotificationListener);

    protected native void SetPushSetting(int i, String str, SetPushSettingListener setPushSettingListener);

    protected native void SetRTCHeartbeatListener(RTCHeartbeatListener rTCHeartbeatListener);

    protected native boolean SetReadStatus(long j, int i);

    protected native boolean SetReadTime(long j, long j2);

    protected native void SetRealTimeLogListener(IRealTimeLogListener iRealTimeLogListener);

    protected native boolean SetSendStatus(long j, int i);

    protected native void SetSubscribeStatusListener(UserStatusListener userStatusListener);

    protected native boolean SetTextMessageDraft(int i, String str, String str2);

    protected native void SetUserData(String str, PublishAckListener publishAckListener);

    protected native void SetUserStatus(int i, PublishAckListener publishAckListener);

    protected native void SubscribeAccount(String str, int i, boolean z, PublishAckListener publishAckListener);

    protected native void SubscribeStatus(String[] strArr, PublishAckListener publishAckListener);

    protected native void SyncGroups(String[] strArr, String[] strArr2, PublishAckListener publishAckListener);

    protected native boolean UpdateConversationInfo(String str, int i, String str2, String str3);

    protected native boolean UpdateMessageReceiptStatus(String str, int i, long j);

    protected native boolean UpdateReadReceiptRequestInfo(String str, String str2);

    protected native boolean UseRTCOnly();

    protected void networkUnavailable() {
        EnvironmentChangeNotify(101);
    }

    protected int ping() {
        return EnvironmentChangeNotify(105);
    }

    protected void sdkBackgroundChanged(boolean z) {
        if (z) {
            EnvironmentChangeNotify(102);
        } else {
            EnvironmentChangeNotify(103);
        }
    }

    protected native void sendMessageWithOption(String str, int i, int i2, String str2, byte[] bArr, PushConfig pushConfig, long j, String[] strArr, PublishAckListener publishAckListener, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3);

    public static class Message {
        private String UId;
        private byte[] content;
        private int conversationType;
        private boolean disableNotification;
        private boolean disablePushTitle;
        private String extMsg;
        private boolean extSupport;
        private String extra;
        private boolean forcePushDetail;
        private boolean isOffLine;
        private boolean messageDirection;
        private long messageId;
        private String objectName;
        private String pushConfig;
        private String pushContent;
        private String pushId;
        private String pushTitle;
        private String readReceiptInfo;
        private int readStatus;
        private long readTime;
        private long receivedTime;
        private String senderUserId;
        private int sentStatus;
        private long sentTime;
        private String targetId;

        public Message(JSONObject jSONObject) {
            this.conversationType = jSONObject.optInt("conversation_category");
            this.targetId = jSONObject.optString("target_id");
            this.messageId = jSONObject.optLong("id");
            this.messageDirection = jSONObject.optBoolean("message_direction");
            this.senderUserId = jSONObject.optString("sender_user_id");
            this.readStatus = jSONObject.optInt("read_status");
            this.sentStatus = jSONObject.optInt("send_status");
            this.receivedTime = jSONObject.optLong("receive_time");
            this.sentTime = jSONObject.optLong("send_time");
            this.objectName = jSONObject.optString("object_name");
            this.content = jSONObject.optString("content").getBytes();
            this.extra = jSONObject.optString("extra");
            this.pushContent = jSONObject.optString("push");
            this.extSupport = jSONObject.optBoolean("ext_support");
            this.extMsg = jSONObject.optString("ext_msg");
            this.disablePushTitle = jSONObject.optBoolean("disable_push_title");
            this.forcePushDetail = jSONObject.optBoolean("force_push_detail");
            this.pushTitle = jSONObject.optString("push_title");
            this.pushId = jSONObject.optString("push_id");
            this.pushConfig = jSONObject.optString("push_config");
        }

        public byte[] getContent() {
            return this.content;
        }

        public int getConversationType() {
            return this.conversationType;
        }

        public String getExtMsg() {
            return this.extMsg;
        }

        public String getExtra() {
            return this.extra;
        }

        public boolean getMessageDirection() {
            return this.messageDirection;
        }

        public long getMessageId() {
            return this.messageId;
        }

        public String getObjectName() {
            return this.objectName;
        }

        public String getPushConfig() {
            return this.pushConfig;
        }

        public String getPushContent() {
            return this.pushContent;
        }

        public String getPushId() {
            return this.pushId;
        }

        public String getPushTitle() {
            return this.pushTitle;
        }

        public String getReadReceiptInfo() {
            return this.readReceiptInfo;
        }

        public int getReadStatus() {
            return this.readStatus;
        }

        public long getReadTime() {
            return this.readTime;
        }

        public long getReceivedTime() {
            return this.receivedTime;
        }

        public String getSenderUserId() {
            return this.senderUserId;
        }

        public int getSentStatus() {
            return this.sentStatus;
        }

        public long getSentTime() {
            return this.sentTime;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public String getUId() {
            return this.UId;
        }

        public boolean isDisableNotification() {
            return this.disableNotification;
        }

        public boolean isDisablePushTitle() {
            return this.disablePushTitle;
        }

        public boolean isExtSupport() {
            return this.extSupport;
        }

        public boolean isForcePushDetail() {
            return this.forcePushDetail;
        }

        public boolean isOffLine() {
            return this.isOffLine;
        }

        public void setContent(byte[] bArr) {
            this.content = bArr;
        }

        public void setConversationType(int i) {
            this.conversationType = i;
        }

        public void setDisableNotification(boolean z) {
            this.disableNotification = z;
        }

        public void setDisablePushTitle(boolean z) {
            this.disablePushTitle = z;
        }

        public void setExtMsg(String str) {
            this.extMsg = str;
        }

        public void setExtSupport(boolean z) {
            this.extSupport = z;
        }

        public void setExtra(String str) {
            this.extra = str;
        }

        public void setForcePushDetail(boolean z) {
            this.forcePushDetail = z;
        }

        public void setMessageDirection(boolean z) {
            this.messageDirection = z;
        }

        public void setMessageId(long j) {
            this.messageId = j;
        }

        public void setObjectName(String str) {
            this.objectName = str;
        }

        public void setOffLine(boolean z) {
            this.isOffLine = z;
        }

        public void setPushConfig(String str) {
            this.pushConfig = str;
        }

        public void setPushContent(String str) {
            this.pushContent = str;
        }

        public void setPushId(String str) {
            this.pushId = str;
        }

        public void setPushTitle(String str) {
            this.pushTitle = str;
        }

        public void setReadReceiptInfo(String str) {
            this.readReceiptInfo = str;
        }

        public void setReadStatus(int i) {
            this.readStatus = i;
        }

        public void setReadTime(long j) {
            this.readTime = j;
        }

        public void setReceivedTime(long j) {
            this.receivedTime = j;
        }

        public void setSenderUserId(String str) {
            this.senderUserId = str;
        }

        public void setSentStatus(int i) {
            this.sentStatus = i;
        }

        public void setSentTime(long j) {
            this.sentTime = j;
        }

        public void setTargetId(String str) {
            this.targetId = str;
        }

        public void setUId(String str) {
            this.UId = str;
        }

        public Message() {
        }
    }
}
