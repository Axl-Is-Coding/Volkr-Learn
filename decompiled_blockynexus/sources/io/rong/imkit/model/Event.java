package io.rong.imkit.model;

import android.app.Activity;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.message.RecallNotificationMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Event {

    public static class AddMemberToDiscussionEvent {
        String discussionId;
        List<String> userIdList;

        public AddMemberToDiscussionEvent(String str, List<String> list) {
            this.discussionId = str;
            this.userIdList = list;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public List<String> getUserIdList() {
            return this.userIdList;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }

        public void setUserIdList(List<String> list) {
            this.userIdList = list;
        }
    }

    public static class AddToBlacklistEvent {
        String userId;

        public AddToBlacklistEvent(String str) {
            this.userId = str;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public static class AudioListenedEvent extends BaseConversationEvent {
        private Message message;

        public AudioListenedEvent(Message message) {
            this.message = message;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ Conversation.ConversationType getConversationType() {
            return super.getConversationType();
        }

        public Message getMessage() {
            return this.message;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ String getTargetId() {
            return super.getTargetId();
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setConversationType(Conversation.ConversationType conversationType) {
            super.setConversationType(conversationType);
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setTargetId(String str) {
            super.setTargetId(str);
        }
    }

    protected static class BaseConversationEvent {
        protected Conversation.ConversationType mConversationType;
        protected String mTargetId;

        protected BaseConversationEvent() {
        }

        public Conversation.ConversationType getConversationType() {
            return this.mConversationType;
        }

        public String getTargetId() {
            return this.mTargetId;
        }

        public void setConversationType(Conversation.ConversationType conversationType) {
            this.mConversationType = conversationType;
        }

        public void setTargetId(String str) {
            this.mTargetId = str;
        }
    }

    public static class CSTerminateEvent {
        private Activity activity;
        private String text;

        public CSTerminateEvent(Activity activity, String str) {
            this.activity = activity;
            this.text = str;
        }

        public Activity getActivity() {
            return this.activity;
        }

        public String getText() {
            return this.text;
        }
    }

    public static class ClearConversationEvent {
        private List<Conversation.ConversationType> typeList = new ArrayList();

        public static ClearConversationEvent obtain(Conversation.ConversationType... conversationTypeArr) {
            ClearConversationEvent clearConversationEvent = new ClearConversationEvent();
            clearConversationEvent.setTypes(conversationTypeArr);
            return clearConversationEvent;
        }

        public List<Conversation.ConversationType> getTypes() {
            return this.typeList;
        }

        public void setTypes(Conversation.ConversationType[] conversationTypeArr) {
            if (conversationTypeArr == null || conversationTypeArr.length == 0) {
                return;
            }
            this.typeList.clear();
            this.typeList.addAll(Arrays.asList(conversationTypeArr));
        }
    }

    public static class ConnectEvent {
        private boolean isConnectSuccess;

        public static ConnectEvent obtain(boolean z) {
            ConnectEvent connectEvent = new ConnectEvent();
            connectEvent.setConnectStatus(z);
            return connectEvent;
        }

        public boolean getConnectStatus() {
            return this.isConnectSuccess;
        }

        public void setConnectStatus(boolean z) {
            this.isConnectSuccess = z;
        }
    }

    public static class ConversationNotificationEvent extends BaseConversationEvent {
        private Conversation.ConversationNotificationStatus mStatus;

        public ConversationNotificationEvent(String str, Conversation.ConversationType conversationType, Conversation.ConversationNotificationStatus conversationNotificationStatus) {
            setTargetId(str);
            setConversationType(conversationType);
            setStatus(conversationNotificationStatus);
        }

        public static ConversationNotificationEvent obtain(String str, Conversation.ConversationType conversationType, Conversation.ConversationNotificationStatus conversationNotificationStatus) {
            return new ConversationNotificationEvent(str, conversationType, conversationNotificationStatus);
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ Conversation.ConversationType getConversationType() {
            return super.getConversationType();
        }

        public Conversation.ConversationNotificationStatus getStatus() {
            return this.mStatus;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ String getTargetId() {
            return super.getTargetId();
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setConversationType(Conversation.ConversationType conversationType) {
            super.setConversationType(conversationType);
        }

        public void setStatus(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
            this.mStatus = conversationNotificationStatus;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setTargetId(String str) {
            super.setTargetId(str);
        }
    }

    public static class ConversationRemoveEvent {
        String targetId;
        Conversation.ConversationType type;

        public ConversationRemoveEvent(Conversation.ConversationType conversationType, String str) {
            this.type = conversationType;
            this.targetId = str;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public Conversation.ConversationType getType() {
            return this.type;
        }

        public void setTargetId(String str) {
            this.targetId = str;
        }

        public void setType(Conversation.ConversationType conversationType) {
            this.type = conversationType;
        }
    }

    public static class ConversationTopEvent extends BaseConversationEvent {
        boolean isTop;

        public ConversationTopEvent(Conversation.ConversationType conversationType, String str, boolean z) {
            setConversationType(conversationType);
            setTargetId(str);
            this.isTop = z;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ Conversation.ConversationType getConversationType() {
            return super.getConversationType();
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ String getTargetId() {
            return super.getTargetId();
        }

        public boolean isTop() {
            return this.isTop;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setConversationType(Conversation.ConversationType conversationType) {
            super.setConversationType(conversationType);
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setTargetId(String str) {
            super.setTargetId(str);
        }

        public void setTop(boolean z) {
            this.isTop = z;
        }
    }

    public static class ConversationUnreadEvent {
        String targetId;
        Conversation.ConversationType type;

        public ConversationUnreadEvent(Conversation.ConversationType conversationType, String str) {
            this.type = conversationType;
            this.targetId = str;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public Conversation.ConversationType getType() {
            return this.type;
        }

        public void setTargetId(String str) {
            this.targetId = str;
        }

        public void setType(Conversation.ConversationType conversationType) {
            this.type = conversationType;
        }
    }

    public static class CreateDiscussionEvent {
        String discussionId;
        String discussionName;
        List<String> userIdList;

        public CreateDiscussionEvent(String str, String str2, List<String> list) {
            this.discussionId = str;
            this.discussionName = str2;
            this.userIdList = list;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public String getDiscussionName() {
            return this.discussionName;
        }

        public List<String> getUserIdList() {
            return this.userIdList;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }

        public void setDiscussionName(String str) {
            this.discussionName = str;
        }

        public void setUserIdList(List<String> list) {
            this.userIdList = list;
        }
    }

    public static class DiscussionInviteStatusEvent {
        String discussionId;
        RongIMClient.DiscussionInviteStatus status;

        public DiscussionInviteStatusEvent(String str, RongIMClient.DiscussionInviteStatus discussionInviteStatus) {
            this.discussionId = str;
            this.status = discussionInviteStatus;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public RongIMClient.DiscussionInviteStatus getStatus() {
            return this.status;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }

        public void setStatus(RongIMClient.DiscussionInviteStatus discussionInviteStatus) {
            this.status = discussionInviteStatus;
        }
    }

    public static class DraftEvent {
        private String content;
        private Conversation.ConversationType conversationType;
        private String targetId;

        public DraftEvent(Conversation.ConversationType conversationType, String str, String str2) {
            this.conversationType = conversationType;
            this.targetId = str;
            this.content = str2;
        }

        public String getContent() {
            return this.content;
        }

        public Conversation.ConversationType getConversationType() {
            return this.conversationType;
        }

        public String getTargetId() {
            return this.targetId;
        }
    }

    public static class EncryptedConversationTerminatedEvent {
        public String targetId;

        public EncryptedConversationTerminatedEvent(String str) {
            this.targetId = str;
        }
    }

    public static class FileMessageEvent {
        int callBackType;
        RongIMClient.ErrorCode errorCode;
        Message message;
        int progress;

        public FileMessageEvent(Message message, int i, int i2, RongIMClient.ErrorCode errorCode) {
            this.message = message;
            this.progress = i;
            this.callBackType = i2;
            this.errorCode = errorCode;
        }

        public int getCallBackType() {
            return this.callBackType;
        }

        public RongIMClient.ErrorCode getErrorCode() {
            return this.errorCode;
        }

        public Message getMessage() {
            return this.message;
        }

        public int getProgress() {
            return this.progress;
        }

        public void setCallBackType(int i) {
            this.callBackType = i;
        }

        public void setErrorCode(RongIMClient.ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public void setProgress(int i) {
            this.progress = i;
        }
    }

    public static class GroupUserInfoEvent {
        private GroupUserInfo userInfo;

        public static GroupUserInfoEvent obtain(GroupUserInfo groupUserInfo) {
            GroupUserInfoEvent groupUserInfoEvent = new GroupUserInfoEvent();
            groupUserInfoEvent.userInfo = groupUserInfo;
            return groupUserInfoEvent;
        }

        public GroupUserInfo getUserInfo() {
            return this.userInfo;
        }
    }

    public static class JoinChatRoomEvent {
        String chatRoomId;
        int defMessageCount;

        public JoinChatRoomEvent(String str, int i) {
            this.chatRoomId = str;
            this.defMessageCount = i;
        }

        public String getChatRoomId() {
            return this.chatRoomId;
        }

        public int getDefMessageCount() {
            return this.defMessageCount;
        }

        public void setChatRoomId(String str) {
            this.chatRoomId = str;
        }

        public void setDefMessageCount(int i) {
            this.defMessageCount = i;
        }
    }

    public static class JoinGroupEvent {
        String groupId;
        String groupName;

        public JoinGroupEvent(String str, String str2) {
            this.groupId = str;
            this.groupName = str2;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getGroupName() {
            return this.groupName;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }

        public void setGroupName(String str) {
            this.groupName = str;
        }
    }

    public static class MediaFileEvent {
        int callBackType;
        RongIMClient.ErrorCode errorCode;
        int progress;
        String uid;

        public MediaFileEvent(String str, int i, int i2, RongIMClient.ErrorCode errorCode) {
            this.uid = str;
            this.progress = i;
            this.callBackType = i2;
            this.errorCode = errorCode;
        }

        public int getCallBackType() {
            return this.callBackType;
        }

        public RongIMClient.ErrorCode getErrorCode() {
            return this.errorCode;
        }

        public int getProgress() {
            return this.progress;
        }

        public String getUid() {
            return this.uid;
        }

        public void setCallBackType(int i) {
            this.callBackType = i;
        }

        public void setErrorCode(RongIMClient.ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public void setProgress(int i) {
            this.progress = i;
        }

        public void setUid(String str) {
            this.uid = str;
        }
    }

    public static class MessageDeleteEvent {
        List<Integer> messageIds;

        public MessageDeleteEvent(int... iArr) {
            if (iArr == null || iArr.length == 0) {
                return;
            }
            this.messageIds = new ArrayList();
            for (int i : iArr) {
                this.messageIds.add(Integer.valueOf(i));
            }
        }

        public List<Integer> getMessageIds() {
            return this.messageIds;
        }

        public void setMessageIds(List<Integer> list) {
            this.messageIds = list;
        }
    }

    public static class MessageLeftEvent {
        public int left;

        public MessageLeftEvent(int i) {
            this.left = i;
        }
    }

    public static class MessageRecallEvent {
        private int mMessageId;
        private RecallNotificationMessage mRecallNotificationMessage;
        private boolean mRecallSuccess;

        public MessageRecallEvent(int i, RecallNotificationMessage recallNotificationMessage, boolean z) {
            this.mMessageId = i;
            this.mRecallNotificationMessage = recallNotificationMessage;
            this.mRecallSuccess = z;
        }

        public int getMessageId() {
            return this.mMessageId;
        }

        public RecallNotificationMessage getRecallNotificationMessage() {
            return this.mRecallNotificationMessage;
        }

        public boolean isRecallSuccess() {
            return this.mRecallSuccess;
        }
    }

    public static class MessageSentStatusEvent {
        int messageId;
        Message.SentStatus sentStatus;

        public MessageSentStatusEvent(int i, Message.SentStatus sentStatus) {
            this.messageId = i;
            this.sentStatus = sentStatus;
        }

        public int getMessageId() {
            return this.messageId;
        }

        public Message.SentStatus getSentStatus() {
            return this.sentStatus;
        }

        public void setMessageId(int i) {
            this.messageId = i;
        }

        public void setSentStatus(Message.SentStatus sentStatus) {
            this.sentStatus = sentStatus;
        }
    }

    public static class MessageSentStatusUpdateEvent {
        Message message;
        Message.SentStatus sentStatus;

        public MessageSentStatusUpdateEvent(Message message, Message.SentStatus sentStatus) {
            this.message = message;
            this.sentStatus = sentStatus;
        }

        public Message getMessage() {
            return this.message;
        }

        public Message.SentStatus getSentStatus() {
            return this.sentStatus;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public void setSentStatus(Message.SentStatus sentStatus) {
            this.sentStatus = sentStatus;
        }
    }

    public static class MessagesClearEvent {
        String targetId;
        Conversation.ConversationType type;

        public MessagesClearEvent(Conversation.ConversationType conversationType, String str) {
            this.type = conversationType;
            this.targetId = str;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public Conversation.ConversationType getType() {
            return this.type;
        }

        public void setTargetId(String str) {
            this.targetId = str;
        }

        public void setType(Conversation.ConversationType conversationType) {
            this.type = conversationType;
        }
    }

    public static class NotificationDiscussionInfoEvent {
        private String key;

        NotificationDiscussionInfoEvent(String str) {
            setKey(str);
        }

        public static NotificationDiscussionInfoEvent obtain(String str) {
            return new NotificationDiscussionInfoEvent(str);
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public static class NotificationGroupInfoEvent {
        private String key;

        NotificationGroupInfoEvent(String str) {
            setKey(str);
        }

        public static NotificationGroupInfoEvent obtain(String str) {
            return new NotificationGroupInfoEvent(str);
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public static class NotificationPublicServiceInfoEvent {
        private String key;

        NotificationPublicServiceInfoEvent(String str) {
            setKey(str);
        }

        public static NotificationPublicServiceInfoEvent obtain(String str) {
            return new NotificationPublicServiceInfoEvent(str);
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public static class NotificationUserInfoEvent {
        private String key;

        NotificationUserInfoEvent(String str) {
            setKey(str);
        }

        public static NotificationUserInfoEvent obtain(String str) {
            return new NotificationUserInfoEvent(str);
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public static class OnMessageSendErrorEvent {
        RongIMClient.ErrorCode errorCode;
        Message message;

        public OnMessageSendErrorEvent(Message message, RongIMClient.ErrorCode errorCode) {
            this.message = message;
            this.errorCode = errorCode;
        }

        public RongIMClient.ErrorCode getErrorCode() {
            return this.errorCode;
        }

        public Message getMessage() {
            return this.message;
        }

        public void setErrorCode(RongIMClient.ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    public static class OnReceiveMessageEvent {
        boolean hasPackage;
        int left;
        Message message;
        boolean offline;

        public OnReceiveMessageEvent(Message message, int i, boolean z, boolean z2) {
            this.message = message;
            this.left = i;
            this.hasPackage = z;
            this.offline = z2;
        }

        public int getLeft() {
            return this.left;
        }

        public Message getMessage() {
            return this.message;
        }

        public boolean hasPackage() {
            return this.hasPackage;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public void setHasPackage(boolean z) {
            this.hasPackage = z;
        }

        public void setLeft(int i) {
            this.left = i;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public void setOffline(boolean z) {
            this.offline = z;
        }
    }

    public static class OnReceiveMessageProgressEvent {
        Message message;
        int progress;

        public Message getMessage() {
            return this.message;
        }

        public int getProgress() {
            return this.progress;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public void setProgress(int i) {
            this.progress = i;
        }
    }

    public static class PlayAudioEvent {
        public boolean continuously;
        public int messageId;

        public static PlayAudioEvent obtain() {
            return new PlayAudioEvent();
        }
    }

    public static class PublicServiceFollowableEvent extends BaseConversationEvent {
        private boolean isFollow = false;

        public PublicServiceFollowableEvent(String str, Conversation.ConversationType conversationType, boolean z) {
            setTargetId(str);
            setConversationType(conversationType);
            setIsFollow(z);
        }

        public static PublicServiceFollowableEvent obtain(String str, Conversation.ConversationType conversationType, boolean z) {
            return new PublicServiceFollowableEvent(str, conversationType, z);
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ Conversation.ConversationType getConversationType() {
            return super.getConversationType();
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ String getTargetId() {
            return super.getTargetId();
        }

        public boolean isFollow() {
            return this.isFollow;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setConversationType(Conversation.ConversationType conversationType) {
            super.setConversationType(conversationType);
        }

        public void setIsFollow(boolean z) {
            this.isFollow = z;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setTargetId(String str) {
            super.setTargetId(str);
        }
    }

    public static class QuitChatRoomEvent {
        String chatRoomId;

        public QuitChatRoomEvent(String str) {
            this.chatRoomId = str;
        }

        public String getChatRoomId() {
            return this.chatRoomId;
        }

        public void setChatRoomId(String str) {
            this.chatRoomId = str;
        }
    }

    public static class QuitDiscussionEvent {
        String discussionId;

        public QuitDiscussionEvent(String str) {
            this.discussionId = str;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }
    }

    public static class QuitGroupEvent {
        String groupId;

        public QuitGroupEvent(String str) {
            this.groupId = str;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }
    }

    public static class ReadReceiptEvent {
        private Message readReceiptMessage;

        public ReadReceiptEvent(Message message) {
            this.readReceiptMessage = message;
        }

        public Message getMessage() {
            return this.readReceiptMessage;
        }
    }

    public static class ReadReceiptRequestEvent {
        private String messageUId;
        private String targetId;
        private Conversation.ConversationType type;

        public ReadReceiptRequestEvent(Conversation.ConversationType conversationType, String str, String str2) {
            this.type = conversationType;
            this.targetId = str;
            this.messageUId = str2;
        }

        public Conversation.ConversationType getConversationType() {
            return this.type;
        }

        public String getMessageUId() {
            return this.messageUId;
        }

        public String getTargetId() {
            return this.targetId;
        }
    }

    public static class ReadReceiptResponseEvent {
        private String messageUId;
        private HashMap<String, Long> responseUserIdList;
        private String targetId;
        private Conversation.ConversationType type;

        public ReadReceiptResponseEvent(Conversation.ConversationType conversationType, String str, String str2, HashMap<String, Long> map) {
            this.type = conversationType;
            this.targetId = str;
            this.messageUId = str2;
            this.responseUserIdList = map;
        }

        public Conversation.ConversationType getConversationType() {
            return this.type;
        }

        public String getMessageUId() {
            return this.messageUId;
        }

        public HashMap<String, Long> getResponseUserIdList() {
            return this.responseUserIdList;
        }

        public String getTargetId() {
            return this.targetId;
        }
    }

    public static class RecallMessageEditClickEvent extends BaseConversationEvent {
        private Message message;

        public RecallMessageEditClickEvent(Message message) {
            this.message = message;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ Conversation.ConversationType getConversationType() {
            return super.getConversationType();
        }

        public Message getMessage() {
            return this.message;
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ String getTargetId() {
            return super.getTargetId();
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setConversationType(Conversation.ConversationType conversationType) {
            super.setConversationType(conversationType);
        }

        @Override // io.rong.imkit.model.Event.BaseConversationEvent
        public /* bridge */ /* synthetic */ void setTargetId(String str) {
            super.setTargetId(str);
        }
    }

    public static class RemoteMessageRecallEvent {
        private Conversation.ConversationType mConversationType;
        private int mMessageId;
        private RecallNotificationMessage mRecallNotificationMessage;
        private boolean mRecallSuccess;
        private String mTargetId;

        public RemoteMessageRecallEvent(int i, Conversation.ConversationType conversationType, RecallNotificationMessage recallNotificationMessage, boolean z, String str) {
            this.mMessageId = i;
            this.mRecallNotificationMessage = recallNotificationMessage;
            this.mRecallSuccess = z;
            this.mConversationType = conversationType;
            this.mTargetId = str;
        }

        public Conversation.ConversationType getConversationType() {
            return this.mConversationType;
        }

        public int getMessageId() {
            return this.mMessageId;
        }

        public RecallNotificationMessage getRecallNotificationMessage() {
            return this.mRecallNotificationMessage;
        }

        public String getTargetId() {
            return this.mTargetId;
        }

        public boolean isRecallSuccess() {
            return this.mRecallSuccess;
        }
    }

    public static class RemoveFromBlacklistEvent {
        String userId;

        public RemoveFromBlacklistEvent(String str) {
            this.userId = str;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public static class RemoveMemberFromDiscussionEvent {
        String discussionId;
        String userId;

        public RemoveMemberFromDiscussionEvent(String str, String str2) {
            this.discussionId = str;
            this.userId = str2;
        }

        public String getDiscussionId() {
            return this.discussionId;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setDiscussionId(String str) {
            this.discussionId = str;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public static class ShowDurnDialogEvent {
    }

    public static class ShowLoginBarEvent {
        private boolean isShowBar;

        public ShowLoginBarEvent(boolean z) {
            this.isShowBar = z;
        }

        public boolean isShowBar() {
            return this.isShowBar;
        }

        public void setShowBar(boolean z) {
            this.isShowBar = z;
        }
    }

    public static class SyncGroupEvent {
        List<Group> groups;

        public SyncGroupEvent(List<Group> list) {
            this.groups = list;
        }

        public List<Group> getGroups() {
            return this.groups;
        }

        public void setGroups(List<Group> list) {
            this.groups = list;
        }
    }

    public static class SyncReadStatusEvent {
        private String targetId;
        private Conversation.ConversationType type;

        public SyncReadStatusEvent(Conversation.ConversationType conversationType, String str) {
            this.type = conversationType;
            this.targetId = str;
        }

        public Conversation.ConversationType getConversationType() {
            return this.type;
        }

        public String getTargetId() {
            return this.targetId;
        }
    }

    public static class VoiceInputOperationEvent {
        public static final int STATUS_DEFAULT = -1;
        public static final int STATUS_INPUTING = 0;
        public static final int STATUS_INPUT_COMPLETE = 1;
        private int status;

        public VoiceInputOperationEvent(int i) {
            setStatus(i);
        }

        public static VoiceInputOperationEvent obtain(int i) {
            return new VoiceInputOperationEvent(i);
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }
    }

    public static class changeDestructionReadTimeEvent {
        public Message message;

        public changeDestructionReadTimeEvent(Message message) {
            this.message = message;
        }
    }
}
