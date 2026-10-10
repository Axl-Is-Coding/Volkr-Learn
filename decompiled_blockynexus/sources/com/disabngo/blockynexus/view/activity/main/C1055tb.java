package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.DressAdsInfo;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.tb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1055tb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10971a;

    C1055tb(MainActivity mainActivity) {
        this.f10971a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        DressAdsInfo dressAdsInfo = (DressAdsInfo) fVar.b(StringConstant.GAME_SHOP_AD_INFO);
        if (dressAdsInfo.getStatus() != 1) {
            AppToastUtils.showShortNegativeTipToast(this.f10971a, R.string.ads_cant_watch_today);
        } else if (AdsManager.isVideoLoaded()) {
            AdsManager.showRewardVideo(dressAdsInfo.getAdType(), dressAdsInfo.getNextQty());
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f10971a, R.string.ads_resource_not_has);
        }
    }
}
