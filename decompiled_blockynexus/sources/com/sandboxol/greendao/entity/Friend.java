package com.sandboxol.greendao.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.databinding.BaseObservable;

/* JADX INFO: loaded from: classes3.dex */
public class Friend extends BaseObservable implements Parcelable {
    public static final Parcelable.Creator<Friend> CREATOR = new Parcelable.Creator<Friend>() { // from class: com.sandboxol.greendao.entity.Friend.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Friend createFromParcel(Parcel parcel) {
            return new Friend(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Friend[] newArray(int i) {
            return new Friend[i];
        }
    };
    private static final long serialVersionUID = 100;
    public Long ID;
    private int age;
    private String alias;
    private long clanId;
    private String clanName;
    private String country;
    private String details;
    private String expireDate;
    private boolean friend;
    private FriendPartyStatus friendPartyStatus;
    private String gameId;
    private String gameName;
    private GamingInfo gamingInfo;
    private boolean isSearchById;
    private String language;
    private long localUserId;
    private long logoutTime;
    private String nickName;
    private String picUrl;
    private int role;
    private int sex;
    private String starCode;
    private int status;
    private UserGameCareerTotalData userGameDataResponse;
    public long userId;
    private int vip;

    protected Friend(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.ID = null;
        } else {
            this.ID = Long.valueOf(parcel.readLong());
        }
        this.userId = parcel.readLong();
        this.localUserId = parcel.readLong();
        this.alias = parcel.readString();
        this.details = parcel.readString();
        this.gameId = parcel.readString();
        this.nickName = parcel.readString();
        this.picUrl = parcel.readString();
        this.status = parcel.readInt();
        this.expireDate = parcel.readString();
        this.vip = parcel.readInt();
        this.sex = parcel.readInt();
        this.friend = parcel.readByte() != 0;
        this.clanId = parcel.readLong();
        this.clanName = parcel.readString();
        this.role = parcel.readInt();
        this.isSearchById = parcel.readByte() != 0;
        this.gameName = parcel.readString();
        this.age = parcel.readInt();
        this.language = parcel.readString();
        this.country = parcel.readString();
        this.friendPartyStatus = (FriendPartyStatus) parcel.readParcelable(FriendPartyStatus.class.getClassLoader());
        this.userGameDataResponse = (UserGameCareerTotalData) parcel.readParcelable(UserGameCareerTotalData.class.getClassLoader());
        this.starCode = parcel.readString();
        this.logoutTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAge() {
        return this.age;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getAliasAndNickName() {
        if (TextUtils.isEmpty(this.alias)) {
            return this.nickName;
        }
        return this.alias + "(" + this.nickName + ")";
    }

    public long getClanId() {
        return this.clanId;
    }

    public String getClanName() {
        return this.clanName;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDetails() {
        return this.details;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public boolean getFriend() {
        return this.friend;
    }

    public FriendPartyStatus getFriendPartyStatus() {
        return this.friendPartyStatus;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public GamingInfo getGamingInfo() {
        return this.gamingInfo;
    }

    public Long getID() {
        return this.ID;
    }

    public String getIdText() {
        return "ID:" + this.userId;
    }

    public boolean getIsSearchById() {
        return this.isSearchById;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLocalUserId() {
        return this.localUserId;
    }

    public long getLogoutTime() {
        return this.logoutTime;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getRole() {
        return this.role;
    }

    public int getSex() {
        return this.sex;
    }

    public String getStarCode() {
        return this.starCode;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalStatus() {
        int i = this.status;
        if (i == 15) {
            this.status = 9;
            return 9;
        }
        if (i != 20) {
            return i;
        }
        this.status = 8;
        return 8;
    }

    public UserGameCareerTotalData getUserGameDataResponse() {
        return this.userGameDataResponse;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isFriend() {
        return this.friend;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setAlias(String str) {
        this.alias = str;
        notifyChange();
    }

    public void setClanId(long j) {
        this.clanId = j;
    }

    public void setClanName(String str) {
        this.clanName = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setFriend(boolean z) {
        this.friend = z;
    }

    public void setFriendPartyStatus(FriendPartyStatus friendPartyStatus) {
        this.friendPartyStatus = friendPartyStatus;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGamingInfo(GamingInfo gamingInfo) {
        this.gamingInfo = gamingInfo;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setIsSearchById(boolean z) {
        this.isSearchById = z;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLocalUserId(long j) {
        this.localUserId = j;
    }

    public void setLogoutTime(long j) {
        this.logoutTime = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStarCode(String str) {
        this.starCode = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserGameDataResponse(UserGameCareerTotalData userGameCareerTotalData) {
        this.userGameDataResponse = userGameCareerTotalData;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.ID == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.ID.longValue());
        }
        parcel.writeLong(this.userId);
        parcel.writeLong(this.localUserId);
        parcel.writeString(this.alias);
        parcel.writeString(this.details);
        parcel.writeString(this.gameId);
        parcel.writeString(this.nickName);
        parcel.writeString(this.picUrl);
        parcel.writeInt(this.status);
        parcel.writeString(this.expireDate);
        parcel.writeInt(this.vip);
        parcel.writeInt(this.sex);
        parcel.writeByte(this.friend ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.clanId);
        parcel.writeString(this.clanName);
        parcel.writeInt(this.role);
        parcel.writeByte(this.isSearchById ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gameName);
        parcel.writeInt(this.age);
        parcel.writeString(this.language);
        parcel.writeString(this.country);
        parcel.writeParcelable(this.friendPartyStatus, 0);
        parcel.writeParcelable(this.userGameDataResponse, 0);
        parcel.writeString(this.starCode);
        parcel.writeLong(this.logoutTime);
    }

    public Friend(Long l, long j, long j2, String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, int i3, boolean z, long j3, String str7, int i4, boolean z2, String str8, int i5, String str9, String str10, FriendPartyStatus friendPartyStatus, GamingInfo gamingInfo, UserGameCareerTotalData userGameCareerTotalData, String str11, long j4) {
        this.ID = l;
        this.userId = j;
        this.localUserId = j2;
        this.alias = str;
        this.details = str2;
        this.gameId = str3;
        this.nickName = str4;
        this.picUrl = str5;
        this.status = i;
        this.expireDate = str6;
        this.vip = i2;
        this.sex = i3;
        this.friend = z;
        this.clanId = j3;
        this.clanName = str7;
        this.role = i4;
        this.isSearchById = z2;
        this.gameName = str8;
        this.age = i5;
        this.language = str9;
        this.country = str10;
        this.friendPartyStatus = friendPartyStatus;
        this.gamingInfo = gamingInfo;
        this.userGameDataResponse = userGameCareerTotalData;
        this.starCode = str11;
        this.logoutTime = j4;
    }

    public Friend() {
    }
}
