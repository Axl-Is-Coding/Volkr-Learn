package com.sandboxol.center.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class AllGameIdInfo implements Serializable {
    private String gameId;
    private String gameName;
    private int isNewEngine;
    private int isUgc;
    private String picUrl;

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsUgc() {
        return this.isUgc;
    }

    public String getPicUrl() {
        return this.picUrl;
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

    public void setIsUgc(int i) {
        this.isUgc = i;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }
}
