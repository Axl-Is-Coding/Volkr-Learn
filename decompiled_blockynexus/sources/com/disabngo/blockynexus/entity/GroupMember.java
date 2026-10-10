package com.disabngo.blockynexus.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class GroupMember implements Parcelable {
    public static final Parcelable.Creator<GroupMember> CREATOR = new Parcelable.Creator<GroupMember>() { // from class: com.disabngo.blockynexus.entity.GroupMember.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMember createFromParcel(Parcel parcel) {
            return new GroupMember(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMember[] newArray(int i) {
            return new GroupMember[i];
        }
    };
    private int banStatus;
    private int identity;
    private String pic;
    private long userId;
    private String userName;
    private int vip;

    public GroupMember() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBanStatus() {
        return this.banStatus;
    }

    public int getIdentity() {
        return this.identity;
    }

    public String getPic() {
        return this.pic;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getVip() {
        return this.vip;
    }

    public void setBanStatus(int i) {
        this.banStatus = i;
    }

    public void setIdentity(int i) {
        this.identity = i;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.pic);
        parcel.writeInt(this.identity);
        parcel.writeInt(this.vip);
        parcel.writeInt(this.banStatus);
    }

    public GroupMember(long j) {
        this.userId = j;
    }

    protected GroupMember(Parcel parcel) {
        this.userId = parcel.readLong();
        this.userName = parcel.readString();
        this.pic = parcel.readString();
        this.identity = parcel.readInt();
        this.vip = parcel.readInt();
        this.banStatus = parcel.readInt();
    }
}
