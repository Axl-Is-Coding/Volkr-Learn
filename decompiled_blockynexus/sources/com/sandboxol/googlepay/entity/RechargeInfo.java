package com.sandboxol.googlepay.entity;

import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;

/* JADX INFO: loaded from: classes3.dex */
public class RechargeInfo {
    private boolean isFree;
    private boolean isVip;
    private ProductEntity productEntity;
    private VipProductEntity vipProductEntity;

    public ProductEntity getProductEntity() {
        return this.productEntity;
    }

    public VipProductEntity getVipProductEntity() {
        return this.vipProductEntity;
    }

    public boolean isFree() {
        return this.isFree;
    }

    public boolean isVip() {
        return this.isVip;
    }

    public void setFree(boolean z) {
        this.isFree = z;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public void setVip(boolean z) {
        this.isVip = z;
    }

    public void setVipProductEntity(VipProductEntity vipProductEntity) {
        this.vipProductEntity = vipProductEntity;
    }
}
