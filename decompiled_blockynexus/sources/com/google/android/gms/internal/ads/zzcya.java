package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcya implements zzbvo {
    private final /* synthetic */ zzctc zzgqq;
    private boolean zzgrf = false;
    private final /* synthetic */ zzbcg zzgrg;
    private final /* synthetic */ zzcxv zzgrh;

    zzcya(zzcxv zzcxvVar, zzctc zzctcVar, zzbcg zzbcgVar) {
        this.zzgrh = zzcxvVar;
        this.zzgqq = zzctcVar;
        this.zzgrg = zzbcgVar;
    }

    private final void zzm(zzva zzvaVar) {
        zzdpg zzdpgVar = zzdpg.INTERNAL_ERROR;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcux)).booleanValue()) {
            zzdpgVar = zzdpg.NO_FILL;
        }
        this.zzgrg.setException(new zzcte(zzdpgVar, zzvaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final void onAdFailedToLoad(int i) {
        if (this.zzgrf) {
            return;
        }
        zzm(new zzva(i, zzcxv.zza(this.zzgqq.zzcib, i), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final synchronized void onAdLoaded() {
        this.zzgrg.set(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final synchronized void zzf(int i, String str) {
        if (this.zzgrf) {
            return;
        }
        this.zzgrf = true;
        if (str == null) {
            str = zzcxv.zza(this.zzgqq.zzcib, i);
        }
        zzm(new zzva(i, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final synchronized void zzk(zzva zzvaVar) {
        this.zzgrf = true;
        zzm(zzvaVar);
    }
}
