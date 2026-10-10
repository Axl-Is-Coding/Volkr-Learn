package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class RCEncryptedSession extends Conversation implements Parcelable {
    public static final Parcelable.Creator<RCEncryptedSession> CREATOR = new Parcelable.Creator<RCEncryptedSession>() { // from class: io.rong.imlib.model.RCEncryptedSession.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptedSession createFromParcel(Parcel parcel) {
            return new RCEncryptedSession(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptedSession[] newArray(int i) {
            return new RCEncryptedSession[i];
        }
    };
    private String encKey;
    private int encStatus;
    private String encXA;
    private String remoteEncId;
    private String targetId;

    public static class RCEncryptedSessionStatus {
        public static final int CANCELED = 4;
        public static final int ENCRYPTED = 3;
        public static final int NOT_FOUND = -1;
        public static final int REQUEST = 1;
        public static final int RESPONSE = 2;
        public static final int TERMINATED = 5;
        public static final int UNKNOWN = -2;
    }

    public RCEncryptedSession() {
    }

    public static Parcelable.Creator<RCEncryptedSession> getCREATOR() {
        return CREATOR;
    }

    @Override // io.rong.imlib.model.Conversation, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEncKey() {
        return this.encKey;
    }

    public int getEncStatus() {
        return this.encStatus;
    }

    public String getEncXA() {
        return this.encXA;
    }

    public String getRemoteEncId() {
        return this.remoteEncId;
    }

    @Override // io.rong.imlib.model.Conversation
    public String getTargetId() {
        return this.targetId;
    }

    public void setEncKey(String str) {
        this.encKey = str;
    }

    public void setEncStatus(int i) {
        this.encStatus = i;
    }

    public void setEncXA(String str) {
        this.encXA = str;
    }

    public void setRemoteEncId(String str) {
        this.remoteEncId = str;
    }

    @Override // io.rong.imlib.model.Conversation
    public void setTargetId(String str) {
        this.targetId = str;
    }

    public String toString() {
        return "RCEncryptedSession{targetId='" + this.targetId + "', remoteEncId='" + this.remoteEncId + "', encKey='" + this.encKey + "', encXA='" + this.encXA + "', encStatus=" + this.encStatus + '}';
    }

    @Override // io.rong.imlib.model.Conversation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.targetId);
        parcel.writeString(this.remoteEncId);
        parcel.writeString(this.encKey);
        parcel.writeString(this.encXA);
        parcel.writeInt(this.encStatus);
    }

    protected RCEncryptedSession(Parcel parcel) {
        this.targetId = parcel.readString();
        this.remoteEncId = parcel.readString();
        this.encKey = parcel.readString();
        this.encXA = parcel.readString();
        this.encStatus = parcel.readInt();
    }
}
