package com.sandboxol.center.router.moduleInfo.game;

import com.sandboxol.greendao.entity.Game;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class EnterRealmsResult implements Serializable {
    private String chatRoomId;
    private String country;
    private String dispatchToken;
    private String dispatchUrl;
    private Game game;
    private String gameAddr;
    private int gameMode;
    private long inviter;
    private boolean isFollow;
    private boolean isNewStartMadel;
    private boolean isTeam;
    private String mapId;
    private String mapName;
    private String mapUrl;
    private int region;
    private String requestId;
    private int resVersion;
    private String resetIp;
    private long targetUserId;
    private long timestamp;
    private long userId;
    private String userName;
    private String userToken;

    public String getChatRoomId() {
        return this.chatRoomId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDispatchToken() {
        return this.dispatchToken;
    }

    public String getDispatchUrl() {
        return this.dispatchUrl;
    }

    public Game getGame() {
        return this.game;
    }

    public String getGameAddr() {
        return this.gameAddr;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public long getInviter() {
        return this.inviter;
    }

    public String getMapId() {
        return this.mapId;
    }

    public String getMapName() {
        return this.mapName;
    }

    public String getMapUrl() {
        return this.mapUrl;
    }

    public int getRegion() {
        return this.region;
    }

    public String getRequestId() {
        String str = this.requestId;
        return str == null ? "" : str;
    }

    public int getResVersion() {
        return this.resVersion;
    }

    public String getResetIp() {
        return this.resetIp;
    }

    public long getTargetUserId() {
        return this.targetUserId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public boolean isNewStartMadel() {
        return this.isNewStartMadel;
    }

    public boolean isTeam() {
        return this.isTeam;
    }

    public void setChatRoomId(String str) {
        this.chatRoomId = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDispatchToken(String str) {
        this.dispatchToken = str;
    }

    public void setDispatchUrl(String str) {
        this.dispatchUrl = str;
    }

    public void setFollow(boolean z) {
        this.isFollow = z;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGameAddr(String str) {
        this.gameAddr = str;
    }

    public void setGameMode(int i) {
        this.gameMode = i;
    }

    public void setInviter(long j) {
        this.inviter = j;
    }

    public void setMapId(String str) {
        this.mapId = str;
    }

    public void setMapName(String str) {
        this.mapName = str;
    }

    public void setMapUrl(String str) {
        this.mapUrl = str;
    }

    public void setNewStartMadel(boolean z) {
        this.isNewStartMadel = z;
    }

    public void setRegion(int i) {
        this.region = i;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setResVersion(int i) {
        this.resVersion = i;
    }

    public void setResetIp(String str) {
        this.resetIp = str;
    }

    public void setTargetUserId(long j) {
        this.targetUserId = j;
    }

    public void setTeam(boolean z) {
        this.isTeam = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserToken(String str) {
        this.userToken = str;
    }
}
