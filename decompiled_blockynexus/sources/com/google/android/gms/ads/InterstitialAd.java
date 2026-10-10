package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzux;
import com.google.android.gms.internal.ads.zzza;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class InterstitialAd {
    private final zzza zzadi;

    public InterstitialAd(Context context) {
        this.zzadi = new zzza(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadi.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.zzadi.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.zzadi.getAdUnitId();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadi.getMediationAdapterClassName();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadi.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.zzadi.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadi.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzadi.zza(adRequest.zzdr());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAdListener(AdListener adListener) {
        this.zzadi.setAdListener(adListener);
        if (adListener != 0 && (adListener instanceof zzux)) {
            this.zzadi.zza((zzux) adListener);
        } else if (adListener == 0) {
            this.zzadi.zza((zzux) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzadi.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadi.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadi.setImmersiveMode(z);
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadi.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzadi.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzadi.show();
    }

    public final void zzd(boolean z) {
        this.zzadi.zzd(true);
    }
}
