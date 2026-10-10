package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapMakeSureInfo {
    private String scrapId;
    private int scrapLevel;
    private String scrapName;
    private int scrapNum;
    private String scrapPic;
    private long userId;
    private String userName;

    public ScrapMakeSureInfo() {
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

    public int getScrapNum() {
        return this.scrapNum;
    }

    public String getScrapPic() {
        return this.scrapPic;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
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

    public void setScrapNum(int i) {
        this.scrapNum = i;
    }

    public void setScrapPic(String str) {
        this.scrapPic = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public ScrapMakeSureInfo(String str, String str2, String str3, long j, int i, String str4, int i2) {
        this.scrapId = str;
        this.scrapName = str2;
        this.userName = str3;
        this.userId = j;
        this.scrapLevel = i;
        this.scrapPic = str4;
        this.scrapNum = i2;
    }
}
