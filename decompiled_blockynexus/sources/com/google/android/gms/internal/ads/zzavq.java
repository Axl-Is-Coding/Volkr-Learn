package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavq extends zzavj {
    private final RewardedAdLoadCallback zzdwf;

    public zzavq(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzdwf = rewardedAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdwf;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdwf;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzi(zzva zzvaVar) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdwf;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(zzvaVar.zzpi());
        }
    }
}
