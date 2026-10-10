package com.sandboxol.center.utils;

import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;

/* JADX INFO: loaded from: classes3.dex */
public class VipDataManager {
    private static VipDataManager vipDataManager;
    private VipProductResponse vipProductResponse;
    private VipSubInfo vipSubInfo;

    private VipDataManager() {
    }

    public static VipDataManager getInstance() {
        if (vipDataManager == null) {
            vipDataManager = new VipDataManager();
        }
        return vipDataManager;
    }

    public VipProductResponse getVipProductResponse() {
        return this.vipProductResponse;
    }

    public VipSubInfo getVipSubInfo() {
        return this.vipSubInfo;
    }

    public void setVipProductResponse(VipProductResponse vipProductResponse) {
        this.vipProductResponse = vipProductResponse;
    }

    public void setVipSubInfo(VipSubInfo vipSubInfo) {
        this.vipSubInfo = vipSubInfo;
    }
}
