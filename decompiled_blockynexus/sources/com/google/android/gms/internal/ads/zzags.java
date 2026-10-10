package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzags extends zzafw {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzdeo;

    public zzags(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzdeo = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zza(zzage zzageVar) {
        this.zzdeo.onUnifiedNativeAdLoaded(new zzagf(zzageVar));
    }
}
