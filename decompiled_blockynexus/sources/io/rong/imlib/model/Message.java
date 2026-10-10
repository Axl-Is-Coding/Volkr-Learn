package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.JSONUtils;
import io.rong.common.ParcelUtils;
import io.rong.imlib.NativeObject;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MessageConfig;
import io.rong.imlib.model.MessagePushConfig;
import io.rong.push.common.RLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Message implements Parcelable {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() { // from class: io.rong.imlib.model.Message.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message[] newArray(int i) {
            return new Message[i];
        }
    };
    private static final String TAG = "Message";
    private String UId;
    private boolean canIncludeExpansion;
    private MessageContent content;
    private Conversation.ConversationType conversationType;
    private Map<String, String> expansion;
    private Map<String, MessageExpansion> expansionEx;
    private String extra;
    private MessageConfig messageConfig;
    private MessageDirection messageDirection;
    private int messageId;
    private MessagePushConfig messagePushConfig;
    private String objectName;
    private ReadReceiptInfo readReceiptInfo;
    private long readTime;
    private ReceivedStatus receivedStatus;
    private long receivedTime;
    private String senderUserId;
    private SentStatus sentStatus;
    private long sentTime;
    private String targetId;

    /* JADX INFO: loaded from: classes5.dex */
    public enum MessageDirection {
        SEND(1),
        RECEIVE(2);

        private int value;

        MessageDirection(int i) {
            this.value = i;
        }

        public static MessageDirection setValue(int i) {
            for (MessageDirection messageDirection : values()) {
                if (i == messageDirection.getValue()) {
                    return messageDirection;
                }
            }
            return SEND;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class ReceivedStatus {
        private static final int DOWNLOADED = 4;
        private static final int LISTENED = 2;
        private static final int MULTIPLERECEIVE = 16;
        private static final int READ = 1;
        private static final int RETRIEVED = 8;
        private int flag;
        private boolean isDownload;
        private boolean isListened;
        private boolean isMultipleReceive;
        private boolean isRead;
        private boolean isRetrieved;

        public ReceivedStatus(int i) {
            this.flag = i;
            this.isRead = (i & 1) == 1;
            this.isListened = (i & 2) == 2;
            this.isDownload = (i & 4) == 4;
            this.isRetrieved = (i & 8) == 8;
            this.isMultipleReceive = (i & 16) == 16;
        }

        public int getFlag() {
            return this.flag;
        }

        public boolean isDownload() {
            return this.isDownload;
        }

        public boolean isListened() {
            return this.isListened;
        }

        public boolean isMultipleReceive() {
            return this.isMultipleReceive;
        }

        public boolean isRead() {
            return this.isRead;
        }

        public boolean isRetrieved() {
            return this.isRetrieved;
        }

        public void setDownload() {
            this.flag |= 4;
            this.isDownload = true;
        }

        public void setListened() {
            this.flag |= 2;
            this.isListened = true;
        }

        public void setMultipleReceive() {
            this.flag |= 16;
            this.isMultipleReceive = true;
        }

        public void setRead() {
            this.flag |= 1;
            this.isRead = true;
        }

        public void setRetrieved() {
            this.flag |= 8;
            this.isRetrieved = true;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public enum SentStatus {
        SENDING(10),
        FAILED(20),
        SENT(30),
        RECEIVED(40),
        READ(50),
        DESTROYED(60),
        CANCELED(70);

        private final int value;

        SentStatus(int i) {
            this.value = i;
        }

        public static SentStatus setValue(int i) {
            for (SentStatus sentStatus : values()) {
                if (i == sentStatus.getValue()) {
                    return sentStatus;
                }
            }
            return SENDING;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Message() {
    }

    public static Message obtain(String str, Conversation.ConversationType conversationType, MessageContent messageContent) {
        Message message = new Message();
        message.setTargetId(str);
        message.setConversationType(conversationType);
        message.setContent(messageContent);
        return message;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof Message ? this.messageId == ((Message) obj).getMessageId() : super.equals(obj);
    }

    public MessageContent getContent() {
        return this.content;
    }

    public Conversation.ConversationType getConversationType() {
        return this.conversationType;
    }

    public Map<String, String> getExpansion() {
        return this.expansion;
    }

    public String getExtra() {
        return this.extra;
    }

    public MessageConfig getMessageConfig() {
        return this.messageConfig;
    }

    public MessageDirection getMessageDirection() {
        return this.messageDirection;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public MessagePushConfig getMessagePushConfig() {
        return this.messagePushConfig;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public ReadReceiptInfo getReadReceiptInfo() {
        return this.readReceiptInfo;
    }

    public long getReadTime() {
        return this.readTime;
    }

    public ReceivedStatus getReceivedStatus() {
        return this.receivedStatus;
    }

    public long getReceivedTime() {
        return this.receivedTime;
    }

    public String getSenderUserId() {
        return this.senderUserId;
    }

    public SentStatus getSentStatus() {
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

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isCanIncludeExpansion() {
        return this.canIncludeExpansion;
    }

    public void setCanIncludeExpansion(boolean z) {
        if (!Conversation.ConversationType.PRIVATE.equals(this.conversationType) && !Conversation.ConversationType.GROUP.equals(this.conversationType)) {
            this.canIncludeExpansion = false;
        }
        this.canIncludeExpansion = z;
    }

    public void setContent(MessageContent messageContent) {
        this.content = messageContent;
    }

    public void setConversationType(Conversation.ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public void setExpansion(HashMap<String, String> map) {
        this.expansion = map;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }

    public void setMessageDirection(MessageDirection messageDirection) {
        this.messageDirection = messageDirection;
    }

    public void setMessageId(int i) {
        this.messageId = i;
    }

    public void setMessagePushConfig(MessagePushConfig messagePushConfig) {
        this.messagePushConfig = messagePushConfig;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setReadReceiptInfo(ReadReceiptInfo readReceiptInfo) {
        this.readReceiptInfo = readReceiptInfo;
    }

    public void setReadTime(long j) {
        this.readTime = j;
    }

    public void setReceivedStatus(ReceivedStatus receivedStatus) {
        this.receivedStatus = receivedStatus;
    }

    public void setReceivedTime(long j) {
        this.receivedTime = j;
    }

    public void setSenderUserId(String str) {
        this.senderUserId = str;
    }

    public void setSentStatus(SentStatus sentStatus) {
        this.sentStatus = sentStatus;
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

    public String toString() {
        return "Message{conversationType=" + this.conversationType + ", targetId='" + this.targetId + "', messageId=" + this.messageId + ", messageDirection=" + this.messageDirection + ", senderUserId='" + this.senderUserId + "', receivedStatus=" + this.receivedStatus + ", sentStatus=" + this.sentStatus + ", receivedTime=" + this.receivedTime + ", sentTime=" + this.sentTime + ", objectName='" + this.objectName + "', content=" + this.content + ", extra='" + this.extra + "', readReceiptInfo=" + this.readReceiptInfo + ", messageConfig=" + this.messageConfig + ", messageConfig=" + this.messagePushConfig + ", canIncludeExpansion=" + this.canIncludeExpansion + ", expansionDic=" + this.expansion + ", expansionDicEx=" + this.expansionEx + ", UId='" + this.UId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getContent() != null ? getContent().getClass().getName() : null);
        ParcelUtils.writeToParcel(parcel, getTargetId());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getMessageId()));
        ParcelUtils.writeToParcel(parcel, getSenderUserId());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getReceivedTime()));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getSentTime()));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getReadTime()));
        ParcelUtils.writeToParcel(parcel, getObjectName());
        ParcelUtils.writeToParcel(parcel, getContent());
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getUId());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getConversationType() == null ? 0 : getConversationType().getValue()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getMessageDirection() == null ? 0 : getMessageDirection().getValue()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getReceivedStatus() == null ? 0 : getReceivedStatus().getFlag()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getSentStatus() != null ? getSentStatus().getValue() : 0));
        ParcelUtils.writeToParcel(parcel, getReadReceiptInfo());
        ParcelUtils.writeToParcel(parcel, getMessageConfig());
        ParcelUtils.writeToParcel(parcel, getMessagePushConfig());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isCanIncludeExpansion() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, getExpansion());
    }

    public Message(NativeObject.Message message) {
        this.conversationType = Conversation.ConversationType.setValue(message.getConversationType());
        this.targetId = message.getTargetId();
        this.messageId = (int) message.getMessageId();
        this.messageDirection = !message.getMessageDirection() ? MessageDirection.SEND : MessageDirection.RECEIVE;
        this.senderUserId = message.getSenderUserId();
        this.receivedStatus = new ReceivedStatus(message.getReadStatus());
        this.sentStatus = SentStatus.setValue(message.getSentStatus());
        this.receivedTime = message.getReceivedTime();
        this.sentTime = message.getSentTime();
        this.readTime = message.getReadTime();
        this.objectName = message.getObjectName();
        this.UId = message.getUId();
        this.extra = message.getExtra();
        this.readReceiptInfo = new ReadReceiptInfo(message.getReadReceiptInfo());
        this.messageConfig = new MessageConfig.Builder().setDisableNotification(message.isDisableNotification()).build();
        MessagePushConfig messagePushConfigBuild = new MessagePushConfig.Builder().setPushTitle(message.getPushTitle()).setPushContent(message.getPushContent()).setForceShowDetailContent(message.isForcePushDetail()).build();
        messagePushConfigBuild.setChannelFromJson(message.getPushConfig());
        if (messagePushConfigBuild.getAndroidConfig() != null) {
            messagePushConfigBuild.getAndroidConfig().setNotificationId(message.getPushId());
        }
        this.messagePushConfig = messagePushConfigBuild;
        this.canIncludeExpansion = message.isExtSupport();
        this.expansionEx = JSONUtils.jsonToExpansionEx(message.getExtMsg());
        this.expansion = JSONUtils.expansionExToMap(this.expansionEx);
    }

    public Message(Parcel parcel) {
        Class cls;
        String fromParcel = ParcelUtils.readFromParcel(parcel);
        if (fromParcel != null) {
            try {
                cls = Class.forName(fromParcel);
            } catch (ClassNotFoundException e2) {
                RLog.e(TAG, "Message class catch exception :" + e2);
                cls = UnknownMessage.class;
            }
        } else {
            cls = UnknownMessage.class;
            RLog.e(TAG, "ClassName is null! Illegal messageContent");
        }
        setTargetId(ParcelUtils.readFromParcel(parcel));
        setMessageId(ParcelUtils.readIntFromParcel(parcel).intValue());
        String fromParcel2 = ParcelUtils.readFromParcel(parcel);
        setSenderUserId(TextUtils.isEmpty(fromParcel2) ? "" : fromParcel2);
        setReceivedTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setSentTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setReadTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setObjectName(ParcelUtils.readFromParcel(parcel));
        setContent((MessageContent) ParcelUtils.readFromParcel(parcel, cls));
        setExtra(ParcelUtils.readFromParcel(parcel));
        setUId(ParcelUtils.readFromParcel(parcel));
        setConversationType(Conversation.ConversationType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setMessageDirection(MessageDirection.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setReceivedStatus(new ReceivedStatus(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setSentStatus(SentStatus.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setReadReceiptInfo((ReadReceiptInfo) ParcelUtils.readFromParcel(parcel, ReadReceiptInfo.class));
        setMessageConfig((MessageConfig) ParcelUtils.readFromParcel(parcel, MessageConfig.class));
        setMessagePushConfig((MessagePushConfig) ParcelUtils.readFromParcel(parcel, MessagePushConfig.class));
        setCanIncludeExpansion(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setExpansion((HashMap) ParcelUtils.readMapFromParcel(parcel));
    }
}
