package com.sandboxol.greendao.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class FriendPartyStatus implements Parcelable {
    public static final Parcelable.Creator<FriendPartyStatus> CREATOR = new Parcelable.Creator<FriendPartyStatus>() { // from class: com.sandboxol.greendao.entity.FriendPartyStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendPartyStatus createFromParcel(Parcel parcel) {
            return new FriendPartyStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendPartyStatus[] newArray(int i) {
            return new FriendPartyStatus[i];
        }
    };
    private static final long serialVersionUID = 100;
    private long captainId;
    private String chatGroupId;
    private int cur;
    private int engineVersion;
    private String gameId;
    private String gameName;
    private int max;
    private String psid;
    private int teamCount;
    private String teamId;
    private int teamMemberCount;
    private int teamType;
    private String title;

    protected FriendPartyStatus(Parcel parcel) {
        this.captainId = parcel.readLong();
        this.chatGroupId = parcel.readString();
        this.cur = parcel.readInt();
        this.max = parcel.readInt();
        this.engineVersion = parcel.readInt();
        this.gameId = parcel.readString();
        this.psid = parcel.readString();
        this.teamCount = parcel.readInt();
        this.teamId = parcel.readString();
        this.teamMemberCount = parcel.readInt();
        this.title = parcel.readString();
        this.teamType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCaptainId() {
        return this.captainId;
    }

    public String getChatGroupId() {
        return this.chatGroupId;
    }

    public int getCur() {
        return this.cur;
    }

    public int getEngineVersion() {
        return this.engineVersion;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getMax() {
        return this.max;
    }

    public String getPsid() {
        return this.psid;
    }

    public int getTeamCount() {
        return this.teamCount;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public int getTeamMemberCount() {
        return this.teamMemberCount;
    }

    public int getTeamType() {
        return this.teamType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCaptainId(long j) {
        this.captainId = j;
    }

    public void setChatGroupId(String str) {
        this.chatGroupId = str;
    }

    public void setCur(int i) {
        this.cur = i;
    }

    public void setEngineVersion(int i) {
        this.engineVersion = i;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setPsid(String str) {
        this.psid = str;
    }

    public void setTeamCount(int i) {
        this.teamCount = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setTeamMemberCount(int i) {
        this.teamMemberCount = i;
    }

    public void setTeamType(int i) {
        this.teamType = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.captainId);
        parcel.writeString(this.chatGroupId);
        parcel.writeInt(this.cur);
        parcel.writeInt(this.max);
        parcel.writeInt(this.engineVersion);
        parcel.writeString(this.gameId);
        parcel.writeString(this.psid);
        parcel.writeInt(this.teamCount);
        parcel.writeString(this.teamId);
        parcel.writeInt(this.teamMemberCount);
        parcel.writeString(this.title);
        parcel.writeInt(this.teamType);
    }

    public FriendPartyStatus(long j, String str, int i, int i2, int i3, String str2, String str3, int i4, String str4, int i5, String str5, int i6, String str6) {
        this.captainId = j;
        this.chatGroupId = str;
        this.cur = i;
        this.max = i2;
        this.engineVersion = i3;
        this.gameId = str2;
        this.psid = str3;
        this.teamCount = i4;
        this.teamId = str4;
        this.teamMemberCount = i5;
        this.title = str5;
        this.teamType = i6;
        this.gameName = str6;
    }

    public FriendPartyStatus() {
    }
}
