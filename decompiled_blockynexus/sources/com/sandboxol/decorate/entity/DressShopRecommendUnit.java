package com.sandboxol.decorate.entity;

/* JADX INFO: loaded from: classes3.dex */
public class DressShopRecommendUnit {
    private ShopRecommendDecorationInfo bigItem;
    private ShopRecommendDecorationInfo midItem;
    private ShopRecommendDecorationInfo smallItemLeft;
    private ShopRecommendDecorationInfo smallItemRight;

    public boolean addItem(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        int i2 = (i + 1) % 4;
        if (i2 == 0) {
            setSmallItemRight(shopRecommendDecorationInfo);
            return true;
        }
        if (i2 == 1) {
            setBigItem(shopRecommendDecorationInfo);
            return false;
        }
        if (i2 == 2) {
            setMidItem(shopRecommendDecorationInfo);
            return false;
        }
        if (i2 != 3) {
            return false;
        }
        setSmallItemLeft(shopRecommendDecorationInfo);
        return false;
    }

    public ShopRecommendDecorationInfo getBigItem() {
        return this.bigItem;
    }

    public ShopRecommendDecorationInfo getMidItem() {
        return this.midItem;
    }

    public ShopRecommendDecorationInfo getSmallItemLeft() {
        return this.smallItemLeft;
    }

    public ShopRecommendDecorationInfo getSmallItemRight() {
        return this.smallItemRight;
    }

    public void setBigItem(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        this.bigItem = shopRecommendDecorationInfo;
    }

    public void setMidItem(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        this.midItem = shopRecommendDecorationInfo;
    }

    public void setSmallItemLeft(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        this.smallItemLeft = shopRecommendDecorationInfo;
    }

    public void setSmallItemRight(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        this.smallItemRight = shopRecommendDecorationInfo;
    }
}
