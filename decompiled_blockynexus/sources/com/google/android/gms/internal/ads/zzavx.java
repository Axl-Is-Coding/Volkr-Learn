package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavx extends zzavc {
    private FullScreenContentCallback zzdwi;
    private OnUserEarnedRewardListener zzdwj;

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdwi;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdFailedToShow(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdwi;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzdwi = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzdwj = onUserEarnedRewardListener;
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void zzh(zzva zzvaVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zzdwi;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvaVar.zzph());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void zza(zzaux zzauxVar) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzdwj;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzavm(zzauxVar));
        }
    }
}
