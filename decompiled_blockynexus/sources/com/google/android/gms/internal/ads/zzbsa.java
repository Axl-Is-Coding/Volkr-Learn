package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsa implements zzbuh, zzbuz, zzbvs, zzbws, zzux {
    private final Clock zzbqa;
    private final zzaxw zzftb;

    public zzbsa(Clock clock, zzaxw zzaxwVar) {
        this.zzbqa = clock;
        this.zzftb = zzaxwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final void onAdClicked() {
        this.zzftb.zzwb();
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
        this.zzftb.zzwc();
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        this.zzftb.zzwa();
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        this.zzftb.zzan(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(zzdog zzdogVar) {
        this.zzftb.zzey(this.zzbqa.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
    }

    public final void zzf(zzvg zzvgVar) {
        this.zzftb.zze(zzvgVar);
    }

    public final String zzwd() {
        return this.zzftb.zzwd();
    }
}
