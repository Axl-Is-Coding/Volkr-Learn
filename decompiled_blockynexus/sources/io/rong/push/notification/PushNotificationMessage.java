package io.rong.push.notification;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import io.rong.push.RongPushClient;

/* JADX INFO: loaded from: classes5.dex */
public class PushNotificationMessage implements Parcelable {
    public static final Parcelable.Creator<PushNotificationMessage> CREATOR = new Parcelable.Creator<PushNotificationMessage>() { // from class: io.rong.push.notification.PushNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushNotificationMessage createFromParcel(Parcel parcel) {
            return new PushNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushNotificationMessage[] newArray(int i) {
            return new PushNotificationMessage[i];
        }
    };
    private String channelIdHW;
    private String channelIdMi;
    private String channelIdOPPO;
    private RongPushClient.ConversationType conversationType;
    private boolean disablePushTitle;
    private String extra;
    private String isFromPush;
    private boolean isShowDetail;
    private String notificationId;
    private String objectName;
    private String pushContent;
    private String pushData;
    private String pushId;
    private String pushTitle;
    private long receivedTime;
    private String senderId;
    private String senderName;
    private Uri senderPortrait;
    private PushSourceType sourceType;
    private String targetId;
    private String targetUserName;
    private String toId;

    public enum PushSourceType {
        FROM_OFFLINE_MESSAGE,
        FROM_ADMIN,
        LOCAL_MESSAGE,
        UNKNOWN
    }

    public PushNotificationMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getChannelIdHW() {
        return this.channelIdHW;
    }

    public String getChannelIdMi() {
        return this.channelIdMi;
    }

    public String getChannelIdOPPO() {
        return this.channelIdOPPO;
    }

    public RongPushClient.ConversationType getConversationType() {
        return this.conversationType;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getPushContent() {
        return this.pushContent;
    }

    public String getPushData() {
        return this.pushData;
    }

    public String getPushFlag() {
        return this.isFromPush;
    }

    public String getPushId() {
        return this.pushId;
    }

    public String getPushTitle() {
        return this.pushTitle;
    }

    public long getReceivedTime() {
        return this.receivedTime;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public Uri getSenderPortrait() {
        return this.senderPortrait;
    }

    public PushSourceType getSourceType() {
        return this.sourceType;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public String getTargetUserName() {
        return this.targetUserName;
    }

    public String getToId() {
        return this.toId;
    }

    public boolean isDisablePushTitle() {
        return this.disablePushTitle;
    }

    public boolean isShowDetail() {
        return this.isShowDetail;
    }

    public void setChannelIdHW(String str) {
        this.channelIdHW = str;
    }

    public void setChannelIdMi(String str) {
        this.channelIdMi = str;
    }

    public void setChannelIdOPPO(String str) {
        this.channelIdOPPO = str;
    }

    public void setConversationType(RongPushClient.ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public void setDisablePushTitle(boolean z) {
        this.disablePushTitle = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setPushContent(String str) {
        this.pushContent = str;
    }

    public void setPushData(String str) {
        this.pushData = str;
    }

    public void setPushFlag(String str) {
        this.isFromPush = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setPushTitle(String str) {
        this.pushTitle = str;
    }

    public void setReceivedTime(long j) {
        this.receivedTime = j;
    }

    public void setSenderId(String str) {
        this.senderId = str;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setSenderPortrait(Uri uri) {
        this.senderPortrait = uri;
    }

    public void setShowDetail(boolean z) {
        this.isShowDetail = z;
    }

    public void setSourceType(PushSourceType pushSourceType) {
        this.sourceType = pushSourceType;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    public void setTargetUserName(String str) {
        this.targetUserName = str;
    }

    public void setToId(String str) {
        this.toId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pushId);
        RongPushClient.ConversationType conversationType = this.conversationType;
        parcel.writeInt(conversationType == null ? -1 : conversationType.ordinal());
        parcel.writeLong(this.receivedTime);
        parcel.writeString(this.objectName);
        parcel.writeString(this.senderId);
        parcel.writeString(this.senderName);
        parcel.writeParcelable(this.senderPortrait, i);
        parcel.writeString(this.targetId);
        parcel.writeString(this.targetUserName);
        parcel.writeString(this.toId);
        parcel.writeString(this.pushTitle);
        parcel.writeString(this.pushContent);
        parcel.writeString(this.pushData);
        parcel.writeString(this.extra);
        parcel.writeByte(this.disablePushTitle ? (byte) 1 : (byte) 0);
        parcel.writeString(this.isFromPush);
        PushSourceType pushSourceType = this.sourceType;
        parcel.writeInt(pushSourceType != null ? pushSourceType.ordinal() : -1);
        parcel.writeString(this.notificationId);
        parcel.writeByte(this.isShowDetail ? (byte) 1 : (byte) 0);
        parcel.writeString(this.channelIdHW);
        parcel.writeString(this.channelIdMi);
        parcel.writeString(this.channelIdOPPO);
    }

    protected PushNotificationMessage(Parcel parcel) {
        this.pushId = parcel.readString();
        int i = parcel.readInt();
        this.conversationType = i == -1 ? null : RongPushClient.ConversationType.values()[i];
        this.receivedTime = parcel.readLong();
        this.objectName = parcel.readString();
        this.senderId = parcel.readString();
        this.senderName = parcel.readString();
        this.senderPortrait = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.targetId = parcel.readString();
        this.targetUserName = parcel.readString();
        this.toId = parcel.readString();
        this.pushTitle = parcel.readString();
        this.pushContent = parcel.readString();
        this.pushData = parcel.readString();
        this.extra = parcel.readString();
        this.disablePushTitle = parcel.readByte() != 0;
        this.isFromPush = parcel.readString();
        int i2 = parcel.readInt();
        this.sourceType = i2 != -1 ? PushSourceType.values()[i2] : null;
        this.notificationId = parcel.readString();
        this.isShowDetail = parcel.readByte() != 0;
        this.channelIdHW = parcel.readString();
        this.channelIdMi = parcel.readString();
        this.channelIdOPPO = parcel.readString();
    }
}
