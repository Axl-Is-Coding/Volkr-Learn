package com.sandboxol.greendao.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class UserGameCareerTotalData implements Parcelable {
    public static final Parcelable.Creator<UserGameCareerTotalData> CREATOR = new Parcelable.Creator<UserGameCareerTotalData>() { // from class: com.sandboxol.greendao.entity.UserGameCareerTotalData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGameCareerTotalData createFromParcel(Parcel parcel) {
            return new UserGameCareerTotalData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGameCareerTotalData[] newArray(int i) {
            return new UserGameCareerTotalData[i];
        }
    };
    private UserGameCareerInfo userGameCareerInfo;
    private UserGameCareerInfo userGameMonthInfo;

    protected UserGameCareerTotalData(Parcel parcel) {
        this.userGameCareerInfo = (UserGameCareerInfo) parcel.readParcelable(UserGameCareerInfo.class.getClassLoader());
        this.userGameMonthInfo = (UserGameCareerInfo) parcel.readParcelable(UserGameCareerInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserGameCareerInfo getUserGameCareerInfo() {
        return this.userGameCareerInfo;
    }

    public UserGameCareerInfo getUserGameMonthInfo() {
        return this.userGameMonthInfo;
    }

    public void setUserGameCareerInfo(UserGameCareerInfo userGameCareerInfo) {
        this.userGameCareerInfo = userGameCareerInfo;
    }

    public void setUserGameMonthInfo(UserGameCareerInfo userGameCareerInfo) {
        this.userGameMonthInfo = userGameCareerInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.userGameCareerInfo, 0);
        parcel.writeParcelable(this.userGameMonthInfo, 0);
    }

    public UserGameCareerTotalData() {
    }
}
