package com.sandboxol.greendao.entity;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BuyDressResponse implements Serializable {
    private Map<String, Boolean> decorationPurchaseStatus;
    private long diamondsNeed;
    private long goldsNeed;
    private boolean needShowAds;
    private Map<String, Boolean> suitPurchaseStatus;

    public Map<String, Boolean> getDecorationPurchaseStatus() {
        return this.decorationPurchaseStatus;
    }

    public long getDiamondsNeed() {
        return this.diamondsNeed;
    }

    public long getGoldsNeed() {
        return this.goldsNeed;
    }

    public Map<String, Boolean> getSuitPurchaseStatus() {
        return this.suitPurchaseStatus;
    }

    public boolean isNeedShowAds() {
        return this.needShowAds;
    }

    public void setDecorationPurchaseStatus(Map<String, Boolean> map) {
        this.decorationPurchaseStatus = map;
    }

    public void setDiamondsNeed(long j) {
        this.diamondsNeed = j;
    }

    public void setGoldsNeed(long j) {
        this.goldsNeed = j;
    }

    public void setNeedShowAds(boolean z) {
        this.needShowAds = z;
    }

    public void setSuitPurchaseStatus(Map<String, Boolean> map) {
        this.suitPurchaseStatus = map;
    }
}
