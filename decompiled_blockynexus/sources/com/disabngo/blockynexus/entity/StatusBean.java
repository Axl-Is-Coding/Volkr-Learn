package com.disabngo.blockynexus.entity;

import com.sandboxol.greendao.entity.FriendPartyStatus;
import com.sandboxol.greendao.entity.GamingInfo;

/* JADX INFO: loaded from: classes2.dex */
public class StatusBean {
    private String gameId;
    private String gameName;
    private String gamePic;
    private GamingInfo gamingInfo;
    private long logoutTime;
    private FriendPartyStatus partyInfo;
    private int status;
    private long userId;

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGamePic() {
        String str;
        return (this.gamingInfo == null || (str = this.gamePic) == null) ? this.partyInfo != null ? this.gamePic : "" : str;
    }

    public GamingInfo getGamingInfo() {
        return this.gamingInfo;
    }

    public long getLogoutTime() {
        return this.logoutTime;
    }

    public FriendPartyStatus getPartyInfo() {
        return this.partyInfo;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGamePic(String str) {
        this.gamePic = str;
    }

    public void setGamingInfo(GamingInfo gamingInfo) {
        this.gamingInfo = gamingInfo;
    }

    public void setLogoutTime(long j) {
        this.logoutTime = j;
    }

    public void setPartyInfo(FriendPartyStatus friendPartyStatus) {
        this.partyInfo = friendPartyStatus;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
