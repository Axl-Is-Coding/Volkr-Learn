package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqf implements zzbvs, zzqu {
    private final zzdnv zzfmx;
    private final zzbuu zzfrf;
    private final zzbvw zzfrg;
    private final AtomicBoolean zzfrh = new AtomicBoolean();
    private final AtomicBoolean zzfri = new AtomicBoolean();

    public zzbqf(zzdnv zzdnvVar, zzbuu zzbuuVar, zzbvw zzbvwVar) {
        this.zzfmx = zzdnvVar;
        this.zzfrf = zzbuuVar;
        this.zzfrg = zzbvwVar;
    }

    private final void zzaiu() {
        if (this.zzfrh.compareAndSet(false, true)) {
            this.zzfrf.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final synchronized void onAdLoaded() {
        if (this.zzfmx.zzhdk != 1) {
            zzaiu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqrVar) {
        if (this.zzfmx.zzhdk == 1 && zzqrVar.zzbro) {
            zzaiu();
        }
        if (zzqrVar.zzbro && this.zzfri.compareAndSet(false, true)) {
            this.zzfrg.zzajx();
        }
    }
}
