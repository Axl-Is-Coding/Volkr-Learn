package com.sandboxol.center.router.moduleInfo.pay;

/* JADX INFO: loaded from: classes3.dex */
public class BuyParam {
    private boolean isSub;
    private String purchaseData;
    private String signature;
    private String sku;

    public String getPurchaseData() {
        return this.purchaseData;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSku() {
        return this.sku;
    }

    public boolean isSub() {
        return this.isSub;
    }

    public void setPurchaseData(String str) {
        this.purchaseData = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setSku(String str) {
        this.sku = str;
    }

    public void setSub(boolean z) {
        this.isSub = z;
    }
}
