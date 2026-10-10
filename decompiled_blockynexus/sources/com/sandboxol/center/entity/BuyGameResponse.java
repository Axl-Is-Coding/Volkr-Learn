package com.sandboxol.center.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class BuyGameResponse implements Serializable {
    private long diamonds;
    private long gDiamonds;
    private long golds;
    private String orderId;
    private long userId;

    public long getDiamonds() {
        return this.diamonds;
    }

    public long getGolds() {
        return this.golds;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long getUserId() {
        return this.userId;
    }

    public long getgDiamonds() {
        return this.gDiamonds;
    }

    public void setDiamonds(long j) {
        this.diamonds = j;
    }

    public void setGolds(long j) {
        this.golds = j;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setgDiamonds(long j) {
        this.gDiamonds = j;
    }
}
