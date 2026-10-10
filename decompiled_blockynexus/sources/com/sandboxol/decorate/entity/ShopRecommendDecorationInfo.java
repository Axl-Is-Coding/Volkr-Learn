package com.sandboxol.decorate.entity;

import androidx.databinding.BaseObservable;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ShopRecommendDecorationInfo extends BaseObservable implements Serializable {
    private int hasPurchase;
    private String iconUrl;
    private int id;
    private int isNew;
    private SingleDressInfo shopDecorationInfo;
    private SuitDressInfo shopSuitDecorationInfo;

    public ShopRecommendDecorationInfo(SingleDressInfo singleDressInfo) {
        this.shopDecorationInfo = singleDressInfo;
    }

    public int getHasPurchase() {
        return this.hasPurchase;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getId() {
        return this.id;
    }

    public int getIsNew() {
        return this.isNew;
    }

    public SingleDressInfo getShopDecorationInfo() {
        return this.shopDecorationInfo;
    }

    public SuitDressInfo getShopSuitDecorationInfo() {
        return this.shopSuitDecorationInfo;
    }

    public void setHasPurchase(int i) {
        this.hasPurchase = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsNew(int i) {
        this.isNew = i;
    }

    public void setShopDecorationInfo(SingleDressInfo singleDressInfo) {
        this.shopDecorationInfo = singleDressInfo;
    }

    public void setShopSuitDecorationInfo(SuitDressInfo suitDressInfo) {
        this.shopSuitDecorationInfo = suitDressInfo;
    }

    public ShopRecommendDecorationInfo(SuitDressInfo suitDressInfo) {
        this.shopSuitDecorationInfo = suitDressInfo;
    }

    public ShopRecommendDecorationInfo() {
    }
}
