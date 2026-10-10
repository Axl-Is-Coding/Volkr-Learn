package com.disabngo.blockynexus.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FriendActivityIntentInfo implements Parcelable {
    public static final Parcelable.Creator<FriendActivityIntentInfo> CREATOR = new Parcelable.Creator<FriendActivityIntentInfo>() { // from class: com.disabngo.blockynexus.entity.FriendActivityIntentInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendActivityIntentInfo createFromParcel(Parcel parcel) {
            return new FriendActivityIntentInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendActivityIntentInfo[] newArray(int i) {
            return new FriendActivityIntentInfo[i];
        }
    };
    public static final int TYPE_ADD_FRIEND = 2;
    public static final int TYPE_PASS_VERIFY = 1;
    public static final int TYPE_SEND_MSG = 0;
    private long friendId;
    private boolean isFriend;
    private boolean sendBroadcast;
    private int type;

    public FriendActivityIntentInfo() {
        this.type = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public int getType() {
        return this.type;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.friendId);
        parcel.writeInt(this.type);
        parcel.writeByte(this.isFriend ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.sendBroadcast ? (byte) 1 : (byte) 0);
    }

    public FriendActivityIntentInfo(long j, int i) {
        this.type = 0;
        this.friendId = j;
        this.type = i;
    }

    protected FriendActivityIntentInfo(Parcel parcel) {
        this.type = 0;
        this.friendId = parcel.readLong();
        this.type = parcel.readInt();
        this.isFriend = parcel.readByte() != 0;
        this.sendBroadcast = parcel.readByte() != 0;
    }
}
