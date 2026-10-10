package com.sandboxol.greendao.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class GamePayInfo implements Serializable {
    private int currency;
    private String desc;
    private int orderType;
    private String productId;
    private int qty;

    public int getCurrency() {
        return this.currency;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getQty() {
        return this.qty;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setQty(int i) {
        this.qty = i;
    }
}
