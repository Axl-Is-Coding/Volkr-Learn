package com.sandboxol.common.entity;

/* JADX INFO: loaded from: classes3.dex */
public class PayParam {
    private String mOrderId;
    private String mSku;
    private String purchaseData;
    private String signature;

    public String getPurchaseData() {
        return this.purchaseData;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }

    public String getmSku() {
        return this.mSku;
    }

    public void setPurchaseData(String str) {
        this.purchaseData = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setmOrderId(String str) {
        this.mOrderId = str;
    }

    public void setmSku(String str) {
        this.mSku = str;
    }
}
