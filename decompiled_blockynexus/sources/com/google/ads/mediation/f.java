package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class f implements RewardedVideoAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f12568a;

    f(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f12568a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewarded(RewardItem rewardItem) {
        this.f12568a.zzmn.onRewarded(this.f12568a, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdClosed() {
        this.f12568a.zzmn.onAdClosed(this.f12568a);
        AbstractAdViewAdapter.zza(this.f12568a, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f12568a.zzmn.onAdFailedToLoad(this.f12568a, i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLeftApplication() {
        this.f12568a.zzmn.onAdLeftApplication(this.f12568a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLoaded() {
        this.f12568a.zzmn.onAdLoaded(this.f12568a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdOpened() {
        this.f12568a.zzmn.onAdOpened(this.f12568a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        this.f12568a.zzmn.onVideoCompleted(this.f12568a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoStarted() {
        this.f12568a.zzmn.onVideoStarted(this.f12568a);
    }
}
