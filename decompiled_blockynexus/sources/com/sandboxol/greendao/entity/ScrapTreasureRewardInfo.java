package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapTreasureRewardInfo {
    private String gameId;
    private String probability;
    private String scrapDesc;
    private String scrapId;
    private int scrapLevel;
    private String scrapName;
    private String scrapPic;
    private int scrapType;
    private int scrapValue;
    private int status;
    private long userId;

    public ScrapTreasureRewardInfo(long j, String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, String str6, int i4) {
        this.userId = j;
        this.gameId = str;
        this.status = i;
        this.probability = str2;
        this.scrapId = str3;
        this.scrapLevel = i2;
        this.scrapName = str4;
        this.scrapPic = str5;
        this.scrapType = i3;
        this.scrapDesc = str6;
        this.scrapValue = i4;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getProbability() {
        return this.probability;
    }

    public String getScrapDesc() {
        return this.scrapDesc;
    }

    public String getScrapId() {
        return this.scrapId;
    }

    public int getScrapLevel() {
        return this.scrapLevel;
    }

    public String getScrapName() {
        return this.scrapName;
    }

    public String getScrapPic() {
        return this.scrapPic;
    }

    public int getScrapType() {
        return this.scrapType;
    }

    public int getScrapValue() {
        return this.scrapValue;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setProbability(String str) {
        this.probability = str;
    }

    public void setScrapDesc(String str) {
        this.scrapDesc = str;
    }

    public void setScrapId(String str) {
        this.scrapId = str;
    }

    public void setScrapLevel(int i) {
        this.scrapLevel = i;
    }

    public void setScrapName(String str) {
        this.scrapName = str;
    }

    public void setScrapPic(String str) {
        this.scrapPic = str;
    }

    public void setScrapType(int i) {
        this.scrapType = i;
    }

    public void setScrapValue(int i) {
        this.scrapValue = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public ScrapTreasureRewardInfo() {
    }
}
