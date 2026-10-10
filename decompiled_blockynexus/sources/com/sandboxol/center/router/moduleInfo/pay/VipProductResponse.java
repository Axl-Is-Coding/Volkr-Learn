package com.sandboxol.center.router.moduleInfo.pay;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class VipProductResponse {
    private String expireDate;
    private Map<String, List<VipProductEntity>> products;
    private int vip;

    public String getExpireDate() {
        return this.expireDate;
    }

    public Map<String, List<VipProductEntity>> getProducts() {
        return this.products;
    }

    public int getVip() {
        return this.vip;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setProducts(Map<String, List<VipProductEntity>> map) {
        this.products = map;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
