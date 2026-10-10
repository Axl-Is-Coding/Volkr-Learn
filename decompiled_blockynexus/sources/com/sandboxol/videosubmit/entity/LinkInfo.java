package com.sandboxol.videosubmit.entity;

/* JADX INFO: loaded from: classes4.dex */
public class LinkInfo {
    private String gameCode;
    private String gameName;
    private String link;
    private String videoType;

    public String getGameCode() {
        return this.gameCode;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getLink() {
        return this.link;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public LinkInfo setGameCode(String str) {
        this.gameCode = str;
        return this;
    }

    public LinkInfo setGameName(String str) {
        this.gameName = str;
        return this;
    }

    public LinkInfo setLink(String str) {
        this.link = str;
        return this;
    }

    public LinkInfo setVideoType(String str) {
        this.videoType = str;
        return this;
    }
}
