package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class GamingInfo {
    private int appVersion;
    private String gameInstanceId;
    private int isPrivateParty;
    private String regionId;
    private String roomAddr;

    public int getAppVersion() {
        return this.appVersion;
    }

    public String getGameInstanceId() {
        return this.gameInstanceId;
    }

    public int getIsPrivateParty() {
        return this.isPrivateParty;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getRoomAddr() {
        return this.roomAddr;
    }

    public void setAppVersion(int i) {
        this.appVersion = i;
    }

    public void setGameInstanceId(String str) {
        this.gameInstanceId = str;
    }

    public void setIsPrivateParty(int i) {
        this.isPrivateParty = i;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setRoomAddr(String str) {
        this.roomAddr = str;
    }
}
