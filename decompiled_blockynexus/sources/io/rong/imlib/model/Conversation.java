package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.model.Message;

/* JADX INFO: loaded from: classes5.dex */
public class Conversation implements Parcelable {
    public static final Parcelable.Creator<Conversation> CREATOR = new Parcelable.Creator<Conversation>() { // from class: io.rong.imlib.model.Conversation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Conversation createFromParcel(Parcel parcel) {
            return new Conversation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Conversation[] newArray(int i) {
            return new Conversation[i];
        }
    };
    private static final String TAG = "Conversation";
    private String conversationTitle;
    private ConversationType conversationType;
    private String draft;
    private boolean isTop;
    private MessageContent latestMessage;
    private int latestMessageId;
    private int mentionedCount;
    private ConversationNotificationStatus notificationStatus;
    private String objectName;
    private String portraitUrl;
    private Message.ReceivedStatus receivedStatus;
    private long receivedTime;
    private String senderUserId;
    private String senderUserName;
    private Message.SentStatus sentStatus;
    private long sentTime;
    private String targetId;
    private int unreadMessageCount;

    public enum ConversationNotificationStatus {
        DO_NOT_DISTURB(0),
        NOTIFY(1);

        private int value;

        ConversationNotificationStatus(int i) {
            this.value = i;
        }

        public static ConversationNotificationStatus setValue(int i) {
            for (ConversationNotificationStatus conversationNotificationStatus : values()) {
                if (i == conversationNotificationStatus.getValue()) {
                    return conversationNotificationStatus;
                }
            }
            return NOTIFY;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ConversationType {
        NONE(0, "none"),
        PRIVATE(1, "private"),
        DISCUSSION(2, "discussion"),
        GROUP(3, "group"),
        CHATROOM(4, "chatroom"),
        CUSTOMER_SERVICE(5, "customer_service"),
        SYSTEM(6, "system"),
        APP_PUBLIC_SERVICE(7, "app_public_service"),
        PUBLIC_SERVICE(8, "public_service"),
        PUSH_SERVICE(9, "push_service"),
        ENCRYPTED(11, "encrypted"),
        RTC_ROOM(12, "rtc_room");

        private String name;
        private int value;

        ConversationType(int i, String str) {
            this.value = i;
            this.name = str;
        }

        public static ConversationType setValue(int i) {
            for (ConversationType conversationType : values()) {
                if (i == conversationType.getValue()) {
                    return conversationType;
                }
            }
            return PRIVATE;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum PublicServiceType {
        APP_PUBLIC_SERVICE(7, "app_public_service"),
        PUBLIC_SERVICE(8, "public_service");

        private String name;
        private int value;

        PublicServiceType(int i, String str) {
            this.value = i;
            this.name = str;
        }

        public static PublicServiceType setValue(int i) {
            for (PublicServiceType publicServiceType : values()) {
                if (i == publicServiceType.getValue()) {
                    return publicServiceType;
                }
            }
            return null;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Conversation() {
    }

    public static Conversation obtain(ConversationType conversationType, String str, String str2) {
        Conversation conversation = new Conversation();
        conversation.setConversationType(conversationType);
        conversation.setTargetId(str);
        conversation.setConversationTitle(str2);
        return conversation;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getConversationTitle() {
        return this.conversationTitle;
    }

    public ConversationType getConversationType() {
        return this.conversationType;
    }

    public String getDraft() {
        return this.draft;
    }

    public MessageContent getLatestMessage() {
        return this.latestMessage;
    }

    public int getLatestMessageId() {
        return this.latestMessageId;
    }

    public int getMentionedCount() {
        return this.mentionedCount;
    }

    public ConversationNotificationStatus getNotificationStatus() {
        return this.notificationStatus;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public Message.ReceivedStatus getReceivedStatus() {
        return this.receivedStatus;
    }

    public long getReceivedTime() {
        return this.receivedTime;
    }

    public String getSenderUserId() {
        return this.senderUserId;
    }

    public String getSenderUserName() {
        return this.senderUserName;
    }

    public Message.SentStatus getSentStatus() {
        return this.sentStatus;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public boolean isTop() {
        return this.isTop;
    }

    public void setConversationTitle(String str) {
        this.conversationTitle = str;
    }

    public void setConversationType(ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public void setDraft(String str) {
        this.draft = str;
    }

    public void setLatestMessage(MessageContent messageContent) {
        this.latestMessage = messageContent;
    }

    public void setLatestMessageId(int i) {
        this.latestMessageId = i;
    }

    public void setMentionedCount(int i) {
        this.mentionedCount = i;
    }

    public void setNotificationStatus(ConversationNotificationStatus conversationNotificationStatus) {
        this.notificationStatus = conversationNotificationStatus;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public void setReceivedStatus(Message.ReceivedStatus receivedStatus) {
        this.receivedStatus = receivedStatus;
    }

    public void setReceivedTime(long j) {
        this.receivedTime = j;
    }

    public void setSenderUserId(String str) {
        this.senderUserId = str;
    }

    public void setSenderUserName(String str) {
        this.senderUserName = str;
    }

    public void setSentStatus(Message.SentStatus sentStatus) {
        this.sentStatus = sentStatus;
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

    public void setUnreadMessageCount(int i) {
        this.unreadMessageCount = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getLatestMessage() == null ? null : getLatestMessage().getClass().getName());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getConversationType().getValue()));
        ParcelUtils.writeToParcel(parcel, getTargetId());
        ParcelUtils.writeToParcel(parcel, getConversationTitle());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getUnreadMessageCount()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isTop() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getLatestMessageId()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getReceivedStatus() == null ? 0 : getReceivedStatus().getFlag()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getSentStatus() != null ? getSentStatus().getValue() : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.receivedTime));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getSentTime()));
        ParcelUtils.writeToParcel(parcel, getObjectName());
        ParcelUtils.writeToParcel(parcel, getSenderUserId());
        ParcelUtils.writeToParcel(parcel, this.senderUserName);
        ParcelUtils.writeToParcel(parcel, getLatestMessage());
        ParcelUtils.writeToParcel(parcel, getDraft());
        ParcelUtils.writeToParcel(parcel, getPortraitUrl());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getNotificationStatus() == null ? -1 : getNotificationStatus().getValue()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getMentionedCount()));
    }

    public Conversation(Parcel parcel) {
        String fromParcel = ParcelUtils.readFromParcel(parcel);
        setConversationType(ConversationType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setTargetId(ParcelUtils.readFromParcel(parcel));
        setConversationTitle(ParcelUtils.readFromParcel(parcel));
        setUnreadMessageCount(ParcelUtils.readIntFromParcel(parcel).intValue());
        setTop(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setLatestMessageId(ParcelUtils.readIntFromParcel(parcel).intValue());
        setReceivedStatus(new Message.ReceivedStatus(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setSentStatus(Message.SentStatus.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setReceivedTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setSentTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setObjectName(ParcelUtils.readFromParcel(parcel));
        setSenderUserId(ParcelUtils.readFromParcel(parcel));
        setSenderUserName(ParcelUtils.readFromParcel(parcel));
        if (TextUtils.isEmpty(fromParcel)) {
            setLatestMessage((MessageContent) ParcelUtils.readFromParcel(parcel, MessageContent.class));
        } else {
            try {
                setLatestMessage((MessageContent) ParcelUtils.readFromParcel(parcel, Class.forName(fromParcel)));
            } catch (Exception e2) {
                RLog.e(TAG, "Conversation setLastMessage Fail : ", e2);
            }
        }
        setDraft(ParcelUtils.readFromParcel(parcel));
        setPortraitUrl(ParcelUtils.readFromParcel(parcel));
        int iIntValue = ParcelUtils.readIntFromParcel(parcel).intValue();
        if (iIntValue != -1) {
            setNotificationStatus(ConversationNotificationStatus.setValue(iIntValue));
        }
        int iIntValue2 = ParcelUtils.readIntFromParcel(parcel).intValue();
        if (iIntValue2 > 0) {
            setMentionedCount(iIntValue2);
        }
    }
}
