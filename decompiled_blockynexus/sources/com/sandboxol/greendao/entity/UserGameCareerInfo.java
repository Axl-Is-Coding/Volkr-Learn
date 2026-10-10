package com.sandboxol.greendao.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class UserGameCareerInfo implements Parcelable {
    public static final Parcelable.Creator<UserGameCareerInfo> CREATOR = new Parcelable.Creator<UserGameCareerInfo>() { // from class: com.sandboxol.greendao.entity.UserGameCareerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGameCareerInfo createFromParcel(Parcel parcel) {
            return new UserGameCareerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGameCareerInfo[] newArray(int i) {
            return new UserGameCareerInfo[i];
        }
    };
    private int averageTime;
    private int completeRate;
    private HashMap<String, Long> gameTimeMap;
    private int killCount;
    private int totalTime;
    private int victoryRate;

    protected UserGameCareerInfo(Parcel parcel) {
        this.completeRate = parcel.readInt();
        this.victoryRate = parcel.readInt();
        this.killCount = parcel.readInt();
        this.averageTime = parcel.readInt();
        this.totalTime = parcel.readInt();
        this.gameTimeMap = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAverageTime() {
        return this.averageTime;
    }

    public String getAverageTimeText() {
        return (this.averageTime / 60) + "min";
    }

    public int getCompleteRate() {
        return this.completeRate;
    }

    public String getCompleteRateText() {
        if (this.completeRate > 100) {
            return "100%";
        }
        return this.completeRate + "%";
    }

    public HashMap<String, Long> getGameTimeMap() {
        return this.gameTimeMap;
    }

    public int getKillCount() {
        return this.killCount;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public String getTotalTimeText() {
        return (this.totalTime / 3600) + "h" + ((this.totalTime % 3600) / 60) + "m";
    }

    public int getVictoryRate() {
        return this.victoryRate;
    }

    public String getVictoryRateText() {
        return this.victoryRate + "%";
    }

    public void setAverageTime(int i) {
        this.averageTime = i;
    }

    public void setCompleteRate(int i) {
        this.completeRate = i;
    }

    public void setGameTimeMap(HashMap<String, Long> map) {
        this.gameTimeMap = map;
    }

    public void setKillCount(int i) {
        this.killCount = i;
    }

    public void setTotalTime(int i) {
        this.totalTime = i;
    }

    public void setVictoryRate(int i) {
        this.victoryRate = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.completeRate);
        parcel.writeInt(this.victoryRate);
        parcel.writeInt(this.killCount);
        parcel.writeInt(this.averageTime);
        parcel.writeInt(this.totalTime);
        parcel.writeMap(this.gameTimeMap);
    }

    public UserGameCareerInfo() {
    }
}
