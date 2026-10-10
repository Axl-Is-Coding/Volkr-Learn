package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class DailySignInfo {
    private long adQuantity;
    private String adType;
    private int dailyId;
    private long id;
    private String name;
    private int quantity;
    private int status;
    private String type;
    private String url;

    public long getAdAndSignQuantity() {
        return this.adQuantity + ((long) this.quantity);
    }

    public long getAdQuantity() {
        return this.adQuantity;
    }

    public String getAdType() {
        return this.adType;
    }

    public int getDailyId() {
        return this.dailyId;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAdQuantity(long j) {
        this.adQuantity = j;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setDailyId(int i) {
        this.dailyId = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
