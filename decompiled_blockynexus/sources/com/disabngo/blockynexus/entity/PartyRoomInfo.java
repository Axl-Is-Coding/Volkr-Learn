package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class PartyRoomInfo {
    private long captainId;
    private String captainName;
    private String captainPicUrl;
    private int cur;
    private String gameName;
    private String gameType;
    private int max;
    private String teamId;
    private String title;

    public long getCaptainId() {
        return this.captainId;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public String getCaptainPicUrl() {
        return this.captainPicUrl;
    }

    public int getCur() {
        return this.cur;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameType() {
        return this.gameType;
    }

    public int getMax() {
        return this.max;
    }

    public String getRoomMember() {
        return this.cur + "/" + this.max;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCaptainId(long j) {
        this.captainId = j;
    }

    public void setCaptainName(String str) {
        this.captainName = str;
    }

    public void setCaptainPicUrl(String str) {
        this.captainPicUrl = str;
    }

    public void setCur(int i) {
        this.cur = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
