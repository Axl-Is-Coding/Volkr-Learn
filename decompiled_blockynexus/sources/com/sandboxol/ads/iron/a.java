package com.sandboxol.ads.iron;

import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.sdk.U;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.RewardVideoAdapter;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: AdsIronUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RewardVideoAdapter f16030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f16031b;

    a(c cVar, RewardVideoAdapter rewardVideoAdapter) {
        this.f16031b = cVar;
        this.f16030a = rewardVideoAdapter;
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void a(boolean z) {
        RewardVideoAdapter rewardVideoAdapter = this.f16030a;
        if (rewardVideoAdapter != null) {
            rewardVideoAdapter.onRewardedVideoAdLoaded(z);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void b() {
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void b(l lVar) {
        RewardVideoAdapter rewardVideoAdapter = this.f16030a;
        if (rewardVideoAdapter != null) {
            rewardVideoAdapter.onRewardedVideoAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        if (bVar == null || bVar.b() == null || !bVar.b().contains("lack of ad inventory")) {
            return;
        }
        AppToastUtils.showShortNegativeTipToast(BaseApplication.getContext(), R.string.adiron_ads_is_loading);
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void g() {
        RewardVideoAdapter rewardVideoAdapter = this.f16030a;
        if (rewardVideoAdapter != null) {
            rewardVideoAdapter.onRewardedVideoStarted();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void onRewardedVideoAdClosed() {
        RewardVideoAdapter rewardVideoAdapter = this.f16030a;
        if (rewardVideoAdapter != null) {
            rewardVideoAdapter.onRewardedVideoAdClosed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void onRewardedVideoAdOpened() {
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void a(l lVar) {
        RewardVideoAdapter rewardVideoAdapter = this.f16030a;
        if (rewardVideoAdapter != null) {
            rewardVideoAdapter.onRewardedVideoCompleted();
        }
    }
}
