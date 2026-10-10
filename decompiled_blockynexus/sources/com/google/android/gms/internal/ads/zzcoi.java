package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcoi {
    private final zzdzb zzgcz;
    private final zzdzb zzgjd;
    private final zzcpt zzgje;
    private final zzeos<zzcqv> zzgjf;

    public zzcoi(zzdzb zzdzbVar, zzdzb zzdzbVar2, zzcpt zzcptVar, zzeos<zzcqv> zzeosVar) {
        this.zzgjd = zzdzbVar;
        this.zzgcz = zzdzbVar2;
        this.zzgje = zzcptVar;
        this.zzgjf = zzeosVar;
    }

    final /* synthetic */ zzdzc zza(zzatc zzatcVar, int i, zzcqm zzcqmVar) throws Exception {
        return this.zzgjf.get().zzb(zzatcVar, i);
    }

    public final zzdzc<InputStream> zze(final zzatc zzatcVar) {
        String str = zzatcVar.packageName;
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzdzc zzdzcVarImmediateFailedFuture = zzayu.zzer(str) ? zzdyq.immediateFailedFuture(new zzcqm(zzdpg.INTERNAL_ERROR)) : zzdyq.zzb(this.zzgjd.submit(new Callable(this, zzatcVar) { // from class: com.google.android.gms.internal.ads.zzcoh
            private final zzcoi zzgjb;
            private final zzatc zzgjc;

            {
                this.zzgjb = this;
                this.zzgjc = zzatcVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgjb.zzf(this.zzgjc);
            }
        }), ExecutionException.class, zzcok.zzboo, this.zzgcz);
        final int callingUid = Binder.getCallingUid();
        return zzdyq.zzb(zzdzcVarImmediateFailedFuture, zzcqm.class, new zzdya(this, zzatcVar, callingUid) { // from class: com.google.android.gms.internal.ads.zzcoj
            private final int zzebt;
            private final zzcoi zzgjb;
            private final zzatc zzgjc;

            {
                this.zzgjb = this;
                this.zzgjc = zzatcVar;
                this.zzebt = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgjb.zza(this.zzgjc, this.zzebt, (zzcqm) obj);
            }
        }, this.zzgcz);
    }

    final /* synthetic */ InputStream zzf(zzatc zzatcVar) throws Exception {
        return this.zzgje.zzi(zzatcVar).get(((Integer) zzwm.zzpx().zzd(zzabb.zzcvb)).intValue(), TimeUnit.SECONDS);
    }
}
