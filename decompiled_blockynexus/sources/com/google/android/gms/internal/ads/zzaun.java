package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaun extends zzauj {
    private RewardedVideoAdListener zzckd;

    public zzaun(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzckd = rewardedVideoAdListener;
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.zzckd;
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdFailedToLoad(int i) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoCompleted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoCompleted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzckd = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void zza(zzatw zzatwVar) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckd;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzaul(zzatwVar));
        }
    }
}
