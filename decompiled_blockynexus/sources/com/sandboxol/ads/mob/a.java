package com.sandboxol.ads.mob;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: compiled from: AdsMobUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements RewardedVideoAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RewardVideoAdapter f16038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f16039b;

    a(c cVar, RewardVideoAdapter rewardVideoAdapter) {
        this.f16039b = cVar;
        this.f16038a = rewardVideoAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewarded(RewardItem rewardItem) {
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdClosed() {
        this.f16038a.onRewardedVideoAdClosed();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdFailedToLoad(int i) {
        this.f16038a.onRewardedVideoAdFailedToLoad();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLeftApplication() {
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLoaded() {
        this.f16038a.onRewardedVideoAdLoaded(true);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdOpened() {
        this.f16038a.onRewardedVideoAdOpened();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        this.f16038a.onRewardedVideoCompleted();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoStarted() {
        this.f16038a.onRewardedVideoStarted();
    }
}
