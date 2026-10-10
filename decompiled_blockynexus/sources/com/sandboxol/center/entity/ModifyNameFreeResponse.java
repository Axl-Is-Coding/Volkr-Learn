package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ModifyNameFreeResponse {
    private int currencyType;
    private boolean free;
    private int quantity;

    public int getCurrencyType() {
        return this.currencyType;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isFree() {
        return this.free;
    }

    public void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public void setFree(boolean z) {
        this.free = z;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }
}
