package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BuyRequest {
    private List<BuyDecorationListBean> buyDecorationList;
    private List<BuySuitListBean> buySuitList;
    private Long engineVersion;

    public BuyRequest() {
    }

    public List<BuyDecorationListBean> getBuyDecorationList() {
        return this.buyDecorationList;
    }

    public List<BuySuitListBean> getBuySuitList() {
        return this.buySuitList;
    }

    public Long getEngineVersion() {
        return this.engineVersion;
    }

    public void setBuyDecorationList(List<BuyDecorationListBean> list) {
        this.buyDecorationList = list;
    }

    public void setBuySuitList(List<BuySuitListBean> list) {
        this.buySuitList = list;
    }

    public void setEngineVersion(Long l) {
        this.engineVersion = l;
    }

    public BuyRequest(Long l) {
        this.engineVersion = l;
    }
}
