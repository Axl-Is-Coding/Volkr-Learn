package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavw extends zzavj {
    private final RewardedInterstitialAdLoadCallback zzdwg;
    private final zzavz zzdwh;

    public zzavw(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzavz zzavzVar) {
        this.zzdwg = rewardedInterstitialAdLoadCallback;
        this.zzdwh = zzavzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdwg;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void onRewardedAdLoaded() {
        zzavz zzavzVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdwg;
        if (rewardedInterstitialAdLoadCallback == null || (zzavzVar = this.zzdwh) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzavzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzi(zzva zzvaVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdwg;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(zzvaVar.zzpi());
        }
    }
}
