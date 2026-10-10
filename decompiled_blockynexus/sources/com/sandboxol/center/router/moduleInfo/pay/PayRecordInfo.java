package com.sandboxol.center.router.moduleInfo.pay;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class PayRecordInfo implements Serializable {
    private String created;
    private int currency;
    private String description;
    private int inoutType;
    private String orderId;
    private long qty;
    private int status;
    private int transactionType;
    private long userId;

    public String getCreated() {
        return this.created;
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getDescription() {
        return this.description;
    }

    public int getInoutType() {
        return this.inoutType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long getQty() {
        return this.qty;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTransactionType() {
        return this.transactionType;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setCreated(String str) {
        this.created = str;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setInoutType(int i) {
        this.inoutType = i;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setQty(long j) {
        this.qty = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTransactionType(int i) {
        this.transactionType = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
