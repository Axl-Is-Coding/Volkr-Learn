package com.sandboxol.center.entity;

import android.content.Context;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DressAdsInfo implements Serializable {
    private int adType;
    private int currency;
    private int nextCurrency;
    private long nextQty;
    private long qty;
    private int status;

    public int getAdType() {
        return this.adType;
    }

    public String getAddNextQty() {
        return "+" + this.nextQty;
    }

    public String getAddQty() {
        return "+" + this.qty;
    }

    public int getCurrency() {
        return this.currency;
    }

    public int getNextCurrency() {
        return this.nextCurrency;
    }

    public long getNextQty() {
        return this.nextQty;
    }

    public String getNextQtyTip() {
        Context context = BaseApplication.getContext();
        int i = R.string.ads_dress_next_reward_tip;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(getNextQty());
        objArr[1] = BaseApplication.getContext().getString(getNextCurrency() == 2 ? R.string.gold : R.string.Bcube);
        return context.getString(i, objArr);
    }

    public long getQty() {
        return this.qty;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setNextCurrency(int i) {
        this.nextCurrency = i;
    }

    public void setNextQty(long j) {
        this.nextQty = j;
    }

    public void setQty(long j) {
        this.qty = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
