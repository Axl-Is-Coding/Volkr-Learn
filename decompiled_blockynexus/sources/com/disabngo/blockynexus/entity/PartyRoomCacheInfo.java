package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class PartyRoomCacheInfo {
    private String gameId;
    private String gameName;
    private int iMemberNum;
    private int iPublicParty;
    private int isNewEngine;
    private String memberNum;
    private String publicParty;
    private String roomName;

    public PartyRoomCacheInfo(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3) {
        this.roomName = str;
        this.gameName = str2;
        this.memberNum = str3;
        this.publicParty = str4;
        this.gameId = str5;
        this.iMemberNum = i;
        this.iPublicParty = i2;
        this.isNewEngine = i3;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public String getMemberNum() {
        return this.memberNum;
    }

    public String getPublicParty() {
        return this.publicParty;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getiMemberNum() {
        return this.iMemberNum;
    }

    public int getiPublicParty() {
        return this.iPublicParty;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setMemberNum(String str) {
        this.memberNum = str;
    }

    public void setPublicParty(String str) {
        this.publicParty = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setiMemberNum(int i) {
        this.iMemberNum = i;
    }

    public void setiPublicParty(int i) {
        this.iPublicParty = i;
    }
}
