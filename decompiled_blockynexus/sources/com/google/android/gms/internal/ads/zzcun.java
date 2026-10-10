package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcun implements zzcta<zzboq> {
    private final ScheduledExecutorService zzfmv;
    private final zzbug zzfwd;
    private final zzdzb zzgcz;
    private final zzbpm zzgov;
    private final zzctt zzgow;

    public zzcun(zzbpm zzbpmVar, zzctt zzcttVar, zzbug zzbugVar, ScheduledExecutorService scheduledExecutorService, zzdzb zzdzbVar) {
        this.zzgov = zzbpmVar;
        this.zzgow = zzcttVar;
        this.zzfwd = zzbugVar;
        this.zzfmv = scheduledExecutorService;
        this.zzgcz = zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        return zzdogVar.zzhev.zzfsk.zzati() != null && this.zzgow.zza(zzdogVar, zzdnvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzboq> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        return this.zzgcz.submit(new Callable(this, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzcuq
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzcun zzgoy;

            {
                this.zzgoy = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgoy.zzc(this.zzgcx, this.zzfqn);
            }
        });
    }

    final /* synthetic */ zzboq zzc(final zzdog zzdogVar, final zzdnv zzdnvVar) throws Exception {
        return this.zzgov.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzbqa(zzdogVar.zzhev.zzfsk.zzati(), new Runnable(this, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzcup
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzcun zzgoy;

            {
                this.zzgoy = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgoy.zzd(this.zzgcx, this.zzfqn);
            }
        })).zzagg();
    }

    final /* synthetic */ void zzd(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdyq.zza(zzdyq.zza(this.zzgow.zzb(zzdogVar, zzdnvVar), zzdnvVar.zzheb, TimeUnit.SECONDS, this.zzfmv), new zzcus(this), this.zzgcz);
    }
}
