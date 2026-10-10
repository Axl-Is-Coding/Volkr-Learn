package com.sandboxol.greendao.entity;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GameDiskCacheInfo {
    private long diskSpaceSize;
    private String gameCoverPic;
    private String gameId;
    private String gameName;
    private String gameTitle;
    private boolean isDataChange;
    private int isNewEngine;
    private int isUgcGame;
    private long lastOpenedTime;
    private Map<String, String> mapPathName;

    public GameDiskCacheInfo(String str, String str2, String str3, String str4, int i, long j, long j2, Map<String, String> map, boolean z, int i2) {
        this.isDataChange = true;
        this.gameId = str;
        this.gameTitle = str2;
        this.gameName = str3;
        this.gameCoverPic = str4;
        this.isNewEngine = i;
        this.lastOpenedTime = j;
        this.diskSpaceSize = j2;
        this.mapPathName = map;
        this.isDataChange = z;
        this.isUgcGame = i2;
    }

    public long getDiskSpaceSize() {
        return this.diskSpaceSize;
    }

    public String getGameCoverPic() {
        return this.gameCoverPic;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public boolean getIsDataChange() {
        return this.isDataChange;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsUgcGame() {
        return this.isUgcGame;
    }

    public long getLastOpenedTime() {
        return this.lastOpenedTime;
    }

    public Map<String, String> getMapPathName() {
        return this.mapPathName;
    }

    public void setDiskSpaceSize(long j) {
        this.diskSpaceSize = j;
    }

    public void setGameCoverPic(String str) {
        this.gameCoverPic = str;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameTitle(String str) {
        this.gameTitle = str;
    }

    public void setIsDataChange(boolean z) {
        this.isDataChange = z;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setIsUgcGame(int i) {
        this.isUgcGame = i;
    }

    public void setLastOpenedTime(long j) {
        this.lastOpenedTime = j;
    }

    public void setMapPathName(Map<String, String> map) {
        this.mapPathName = map;
    }

    public GameDiskCacheInfo() {
        this.isDataChange = true;
    }
}
