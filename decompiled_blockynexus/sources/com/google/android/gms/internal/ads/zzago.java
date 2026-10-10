package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzago extends zzafd {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdei;

    public zzago(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdei = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void zza(zzaes zzaesVar) {
        this.zzdei.onAppInstallAdLoaded(new zzaet(zzaesVar));
    }
}
