package com.sandboxol.center.download.entity;

import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
public class GameReqParam {
    private String commonResVersion;
    private Game game;
    private String gameId;
    private String gameResVersion;

    public String getCommonResVersion() {
        return this.commonResVersion;
    }

    public Game getGame() {
        return this.game;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameResVersion() {
        return this.gameResVersion;
    }

    public GameReqParam setCommonResVersion(String str) {
        this.commonResVersion = str;
        return this;
    }

    public GameReqParam setGame(Game game) {
        this.game = game;
        return this;
    }

    public GameReqParam setGameId(String str) {
        this.gameId = str;
        return this;
    }

    public GameReqParam setGameResVersion(String str) {
        this.gameResVersion = str;
        return this;
    }
}
