package com.sandboxol.decorate.entity;

import com.sandboxol.center.entity.DressShopGuideConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DressGuideInfo {
    private Map<String, List<DressShopGuideConfig>> dressShopGuideConfigMap;

    public Map<String, List<DressShopGuideConfig>> getDressShopGuideConfigMap() {
        return this.dressShopGuideConfigMap;
    }

    public void setDressShopGuideConfigMap(Map<String, List<DressShopGuideConfig>> map) {
        this.dressShopGuideConfigMap = map;
    }
}
