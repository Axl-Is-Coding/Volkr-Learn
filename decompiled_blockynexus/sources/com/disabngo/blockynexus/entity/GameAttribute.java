package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class GameAttribute {
    private String gameName;
    private Long gameTime;

    public GameAttribute(String str, Long l) {
        this.gameName = str;
        this.gameTime = l;
    }

    public String getGameName() {
        return this.gameName;
    }

    public Long getGameTime() {
        return this.gameTime;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameTime(Long l) {
        this.gameTime = l;
    }
}
