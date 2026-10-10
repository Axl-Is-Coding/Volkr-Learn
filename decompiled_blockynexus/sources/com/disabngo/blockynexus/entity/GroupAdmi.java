package com.disabngo.blockynexus.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class GroupAdmi implements Parcelable {
    public static final Parcelable.Creator<GroupAdmi> CREATOR = new Parcelable.Creator<GroupAdmi>() { // from class: com.disabngo.blockynexus.entity.GroupAdmi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupAdmi createFromParcel(Parcel parcel) {
            return new GroupAdmi(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupAdmi[] newArray(int i) {
            return new GroupAdmi[i];
        }
    };
    private String pic;
    private int status;
    private long userId;
    private String userName;

    public GroupAdmi(long j, String str, String str2, int i) {
        this.userId = j;
        this.userName = str;
        this.pic = str2;
        this.status = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPic() {
        return this.pic;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.pic);
        parcel.writeInt(this.status);
    }

    public GroupAdmi() {
    }

    protected GroupAdmi(Parcel parcel) {
        this.userId = parcel.readLong();
        this.userName = parcel.readString();
        this.pic = parcel.readString();
        this.status = parcel.readInt();
    }
}
