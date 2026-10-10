package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ChatroomStatus implements Parcelable {
    public static final Parcelable.Creator<ChatroomStatus> CREATOR = new Parcelable.Creator<ChatroomStatus>() { // from class: io.rong.imlib.model.ChatroomStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatroomStatus createFromParcel(Parcel parcel) {
            return new ChatroomStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatroomStatus[] newArray(int i) {
            return new ChatroomStatus[i];
        }
    };
    private boolean isDelete;
    private String key;
    private String operator;
    private String roomId;
    private long updateTime;
    private String value;

    public ChatroomStatus() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public String getKey() {
        return this.key;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getValue() {
        return this.value;
    }

    public void setIsDelete(boolean z) {
        this.isDelete = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "ChatroomStatus{roomId='" + this.roomId + "', key='" + this.key + "', value='" + this.value + "', operator='" + this.operator + "', updateTime=" + this.updateTime + ", isDelete=" + this.isDelete + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.roomId);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.operator);
        parcel.writeLong(this.updateTime);
        parcel.writeInt(this.isDelete ? 1 : 0);
    }

    protected ChatroomStatus(Parcel parcel) {
        this.roomId = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.operator = parcel.readString();
        this.updateTime = parcel.readLong();
        this.isDelete = parcel.readInt() == 1;
    }
}
