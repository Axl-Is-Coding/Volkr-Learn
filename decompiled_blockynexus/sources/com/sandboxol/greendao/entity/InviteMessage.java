package com.sandboxol.greendao.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class InviteMessage implements Serializable {
    private String UId;
    private long captainId;
    private String captainName;
    private String captainPicUrl;
    private String chatRoomId;
    private String gameName;
    private String gameType;
    private long gameVersion;
    private int isNewEngine;
    private int isUgc;
    private int maxMember;
    private int memberCount;
    private String picUrl;
    private String psid;
    private String roomName;
    private int teamCount;
    private String teamId;
    private int teamType;

    public InviteMessage(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, long j2, String str8, int i, int i2, int i3, int i4, String str9, int i5, int i6, String str10) {
        this.gameName = str;
        this.gameType = str2;
        this.picUrl = str3;
        this.captainPicUrl = str4;
        this.captainId = j;
        this.chatRoomId = str5;
        this.captainName = str6;
        this.teamId = str7;
        this.gameVersion = j2;
        this.roomName = str8;
        this.maxMember = i;
        this.memberCount = i2;
        this.teamCount = i3;
        this.teamType = i4;
        this.psid = str9;
        this.isNewEngine = i5;
        this.isUgc = i6;
        this.UId = str10;
    }

    public long getCaptainId() {
        return this.captainId;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public String getCaptainPicUrl() {
        return this.captainPicUrl;
    }

    public String getChatRoomId() {
        return this.chatRoomId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameType() {
        return this.gameType;
    }

    public long getGameVersion() {
        return this.gameVersion;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsUgc() {
        return this.isUgc;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPsid() {
        return this.psid;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getTeamCount() {
        return this.teamCount;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public int getTeamType() {
        return this.teamType;
    }

    public String getUId() {
        return this.UId;
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

    public void setChatRoomId(String str) {
        this.chatRoomId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setGameVersion(long j) {
        this.gameVersion = j;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setIsUgc(int i) {
        this.isUgc = i;
    }

    public void setMaxMember(int i) {
        this.maxMember = i;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPsid(String str) {
        this.psid = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setTeamCount(int i) {
        this.teamCount = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setTeamType(int i) {
        this.teamType = i;
    }

    public void setUId(String str) {
        this.UId = str;
    }
}
