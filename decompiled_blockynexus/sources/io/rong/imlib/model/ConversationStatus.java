package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.model.Conversation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationStatus implements Parcelable {
    public static final Parcelable.Creator<ConversationStatus> CREATOR = new Parcelable.Creator<ConversationStatus>() { // from class: io.rong.imlib.model.ConversationStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConversationStatus createFromParcel(Parcel parcel) {
            return new ConversationStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConversationStatus[] newArray(int i) {
            return new ConversationStatus[i];
        }
    };
    private int conversationType;
    private HashMap<String, String> status;
    private String targetId;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IsTop {
        public static final String top = "1";
        public static final String unTop = "0";
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusMode {
        public static final String NOTIFICATION_STATUS = "1";
        public static final String TOP_STATUS = "2";
    }

    public ConversationStatus() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Conversation.ConversationType getConversationType() {
        return Conversation.ConversationType.setValue(this.conversationType);
    }

    public Conversation.ConversationNotificationStatus getNotifyStatus() {
        return String.valueOf(Conversation.ConversationNotificationStatus.NOTIFY.getValue()).equals(this.status.get("1")) ? Conversation.ConversationNotificationStatus.DO_NOT_DISTURB : Conversation.ConversationNotificationStatus.NOTIFY;
    }

    public HashMap<String, String> getStatus() {
        return this.status;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public boolean isTop() {
        return "1".equals(this.status.get("2"));
    }

    public void setConversationType(int i) {
        this.conversationType = i;
    }

    public void setStatus(HashMap<String, String> map) {
        this.status = map;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.targetId);
        parcel.writeInt(this.conversationType);
        parcel.writeSerializable(this.status);
    }

    protected ConversationStatus(Parcel parcel) {
        this.targetId = parcel.readString();
        this.conversationType = parcel.readInt();
        this.status = (HashMap) parcel.readSerializable();
    }
}
