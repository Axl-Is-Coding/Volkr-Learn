package com.sandboxol.center.router.moduleInfo.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AdsChannelControllerWrap {
    private AdsChannelControllerImpl adsChannelController;

    static class AdsChannelControllerWrapProxy {
        public static AdsChannelControllerWrap adsChannelControllerWrap = new AdsChannelControllerWrap();

        AdsChannelControllerWrapProxy() {
        }
    }

    public static AdsChannelControllerWrap newInstance() {
        return AdsChannelControllerWrapProxy.adsChannelControllerWrap;
    }

    public int getAdsCount() {
        AdsChannelControllerImpl adsChannelControllerImpl = this.adsChannelController;
        if (adsChannelControllerImpl != null) {
            return adsChannelControllerImpl.MAIN_CAN_VIEW_ADS_COUNT;
        }
        return 0;
    }

    public boolean isShowIronAds(Context context, int i, int i2) {
        AdsChannelControllerImpl adsChannelControllerImpl = this.adsChannelController;
        if (adsChannelControllerImpl != null) {
            return adsChannelControllerImpl.isShowIronAds(context, i, i2);
        }
        return false;
    }

    public void setAdsChannelController(AdsChannelControllerImpl adsChannelControllerImpl) {
        this.adsChannelController = adsChannelControllerImpl;
    }
}
