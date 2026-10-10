package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class BuyVipResponse {
    private long diamonds;
    private long diamondsNeed;
    private String expireDate;
    private long golds;
    private long goldsNeed;
    private long userId;
    private int vip;

    public long getDiamonds() {
        return this.diamonds;
    }

    public long getDiamondsNeed() {
        return this.diamondsNeed;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public long getGolds() {
        return this.golds;
    }

    public long getGoldsNeed() {
        return this.goldsNeed;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public void setDiamonds(long j) {
        this.diamonds = j;
    }

    public void setDiamondsNeed(long j) {
        this.diamondsNeed = j;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setGolds(long j) {
        this.golds = j;
    }

    public void setGoldsNeed(long j) {
        this.goldsNeed = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
