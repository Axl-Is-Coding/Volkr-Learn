package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavp extends zzavc {
    private final RewardedAdCallback zzdwe;

    public zzavp(RewardedAdCallback rewardedAdCallback) {
        this.zzdwe = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdwe;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzdwe;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdwe;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void zza(zzaux zzauxVar) {
        RewardedAdCallback rewardedAdCallback = this.zzdwe;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzavm(zzauxVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void zzh(zzva zzvaVar) {
        RewardedAdCallback rewardedAdCallback = this.zzdwe;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzvaVar.zzph());
        }
    }
}
