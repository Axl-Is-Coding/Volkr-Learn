package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadAnalyseData {
    private String cdnId;
    private String country;
    private String gameId;
    private double speed;
    private int time;
    private int type;

    public DownloadAnalyseData(String str, String str2, int i) {
        this.cdnId = str;
        this.country = str2;
        this.type = i;
    }

    public String getCdnId() {
        return this.cdnId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getGameId() {
        return this.gameId;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setCdnId(String str) {
        this.cdnId = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setSpeed(double d2) {
        this.speed = d2;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public DownloadAnalyseData(String str, String str2, double d2) {
        this.cdnId = str;
        this.country = str2;
        this.speed = d2;
    }

    public DownloadAnalyseData(int i, String str) {
        this.type = i;
        this.gameId = str;
    }

    public DownloadAnalyseData(String str, int i) {
        this.gameId = str;
        this.time = i;
    }
}
