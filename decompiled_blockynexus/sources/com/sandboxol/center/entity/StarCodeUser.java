package com.sandboxol.center.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class StarCodeUser implements Parcelable {
    public static final Parcelable.Creator<StarCodeUser> CREATOR = new Parcelable.Creator<StarCodeUser>() { // from class: com.sandboxol.center.entity.StarCodeUser.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StarCodeUser createFromParcel(Parcel parcel) {
            return new StarCodeUser(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StarCodeUser[] newArray(int i) {
            return new StarCodeUser[i];
        }
    };
    private int disable;
    private long id;
    private String nickName;
    private String picUrl;
    private String starCode;
    private long userId;

    public StarCodeUser() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDisable() {
        return this.disable;
    }

    public long getId() {
        return this.id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getStarCode() {
        return this.starCode;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDisable(int i) {
        this.disable = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setStarCode(String str) {
        this.starCode = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.disable);
        parcel.writeLong(this.id);
        parcel.writeString(this.nickName);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.starCode);
        parcel.writeLong(this.userId);
    }

    protected StarCodeUser(Parcel parcel) {
        this.disable = parcel.readInt();
        this.id = parcel.readLong();
        this.nickName = parcel.readString();
        this.picUrl = parcel.readString();
        this.starCode = parcel.readString();
        this.userId = parcel.readLong();
    }
}
