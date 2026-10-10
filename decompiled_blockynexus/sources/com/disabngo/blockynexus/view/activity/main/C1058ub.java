package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.ub, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1058ub implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10975a;

    C1058ub(MainActivity mainActivity) {
        this.f10975a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        int iA = fVar.a(GameConstant.GAME_AD_INFO, 4);
        if (DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd").equals(DateUtils.timeStamp2Date(SharedUtils.getLong(this.f10975a, AccountCenter.newInstance().userId.get() + SharedConstant.ADS_GAME_WATCH_TIME), "yyyy-MM-dd"))) {
            AppToastUtils.showShortNegativeTipToast(this.f10975a, R.string.campaign_reward_received);
            return;
        }
        if (!AdsManager.isVideoLoaded()) {
            AppToastUtils.showShortNegativeTipToast(this.f10975a, R.string.ads_resource_not_has);
            return;
        }
        SharedUtils.putLong(this.f10975a, AccountCenter.newInstance().userId.get() + SharedConstant.ADS_GAME_WATCH_TIME, System.currentTimeMillis());
        AdsManager.showRewardVideo(iA);
    }
}
