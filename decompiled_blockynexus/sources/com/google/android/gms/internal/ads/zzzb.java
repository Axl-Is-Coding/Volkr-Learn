package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzzb extends zzwp {
    private final /* synthetic */ zzyy zzckf;

    zzzb(zzyy zzyyVar) {
        this.zzckf = zzyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzckf.zzcjt.zza(this.zzckf.zzdv());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzckf.zzcjt.zza(this.zzckf.zzdv());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzckf.zzcjt.zza(this.zzckf.zzdv());
        super.onAdFailedToLoad(loadAdError);
    }
}
