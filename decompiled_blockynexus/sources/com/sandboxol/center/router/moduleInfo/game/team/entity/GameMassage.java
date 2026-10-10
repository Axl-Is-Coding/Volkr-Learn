package com.sandboxol.center.router.moduleInfo.game.team.entity;

import androidx.databinding.BaseObservable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class GameMassage extends BaseObservable implements Serializable {
    private String appVersion;
    private long captainId;
    private String captainName;
    private String chatRoomId;
    private String country;
    private String dispUrl;
    private int enterType;
    private String gameId;
    private String gameName;
    private String gamePic;
    private String gameType;
    private boolean isCreate;
    private int isNewEngine;
    private boolean isTeamRoom;
    private int isUgc;
    private int maxMember;
    private int memberCount;
    private String messageId;
    private String nickName;
    private String organizeTeamUrl;
    private String packageName;
    private String picUrl;
    private String psid;
    private int regionId;
    private String roomName;
    private int sex;
    private int teamCount;
    private String teamId;
    private int teamType;
    private String token;
    private long userId;
    private int vip;

    public String getAppVersion() {
        return this.appVersion;
    }

    public long getCaptainId() {
        return this.captainId;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public String getChatRoomId() {
        return this.chatRoomId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDispUrl() {
        return this.dispUrl;
    }

    public int getEnterType() {
        return this.enterType;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGamePic() {
        return this.gamePic;
    }

    public String getGameType() {
        return this.gameType;
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

    public String getMessageId() {
        return this.messageId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getOrganizeTeamUrl() {
        return this.organizeTeamUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPsid() {
        return this.psid;
    }

    public int getRegionId() {
        return this.regionId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getSex() {
        return this.sex;
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

    public String getToken() {
        return this.token;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isCaptain() {
        return this.userId == this.captainId;
    }

    public boolean isCreate() {
        return this.isCreate;
    }

    public boolean isTeamRoom() {
        return this.isTeamRoom;
    }

    public void notifyData(GameMassage gameMassage) {
        setCaptainId(gameMassage.getCaptainId());
        setTeamId(gameMassage.getTeamId());
        setChatRoomId(gameMassage.getChatRoomId());
        setMessageId(gameMassage.getMessageId());
        setGamePic(gameMassage.getGamePic());
        setGameName(gameMassage.getGameName());
        setCaptainName(gameMassage.getCaptainName());
        setNickName(gameMassage.getNickName());
        setGameType(gameMassage.getGameType());
        setOrganizeTeamUrl(gameMassage.getOrganizeTeamUrl());
        setPicUrl(gameMassage.getPicUrl());
        setToken(gameMassage.getToken());
        setUserId(gameMassage.getUserId());
        setRegionId(gameMassage.getRegionId());
        setDispUrl(gameMassage.getDispUrl());
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCaptainId(long j) {
        this.captainId = j;
    }

    public void setCaptainName(String str) {
        this.captainName = str;
    }

    public void setChatRoomId(String str) {
        this.chatRoomId = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreate(boolean z) {
        this.isCreate = z;
    }

    public void setDispUrl(String str) {
        this.dispUrl = str;
    }

    public void setEnterType(int i) {
        this.enterType = i;
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

    public void setGameType(String str) {
        this.gameType = str;
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

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOrganizeTeamUrl(String str) {
        this.organizeTeamUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPsid(String str) {
        this.psid = str;
    }

    public void setRegionId(int i) {
        this.regionId = i;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setTeamCount(int i) {
        this.teamCount = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setTeamRoom(boolean z) {
        this.isTeamRoom = z;
    }

    public void setTeamType(int i) {
        this.teamType = i;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
