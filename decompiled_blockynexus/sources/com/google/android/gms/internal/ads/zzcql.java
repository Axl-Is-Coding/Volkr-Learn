package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcql {
    private final zzdzb zzgcz;
    private final zzeos<zzcqv> zzgjf;
    private final zzcqc zzgkw;

    public zzcql(zzdzb zzdzbVar, zzcqc zzcqcVar, zzeos<zzcqv> zzeosVar) {
        this.zzgcz = zzdzbVar;
        this.zzgkw = zzcqcVar;
        this.zzgjf = zzeosVar;
    }

    private final <RetT> zzdzc<RetT> zza(final zzatc zzatcVar, zzcqw<InputStream> zzcqwVar, final zzcqw<InputStream> zzcqwVar2, final zzdya<InputStream, RetT> zzdyaVar) {
        String str = zzatcVar.packageName;
        com.google.android.gms.ads.internal.zzp.zzkr();
        return zzdyl.zzg(zzayu.zzer(str) ? zzdyq.immediateFailedFuture(new zzcqm(zzdpg.INTERNAL_ERROR)) : zzdyq.zzb(zzcqwVar.zzq(zzatcVar), ExecutionException.class, zzcqo.zzboo, this.zzgcz)).zzb(zzdyaVar, this.zzgcz).zza(zzcqm.class, new zzdya(this, zzcqwVar2, zzatcVar, zzdyaVar) { // from class: com.google.android.gms.internal.ads.zzcqn
            private final zzcql zzgkx;
            private final zzcqw zzgky;
            private final zzatc zzgkz;
            private final zzdya zzgla;

            {
                this.zzgkx = this;
                this.zzgky = zzcqwVar2;
                this.zzgkz = zzatcVar;
                this.zzgla = zzdyaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgkx.zza(this.zzgky, this.zzgkz, this.zzgla, (zzcqm) obj);
            }
        }, this.zzgcz);
    }

    public final zzdzc<zzatc> zzl(final zzatc zzatcVar) {
        zzdya zzdyaVar = new zzdya(zzatcVar) { // from class: com.google.android.gms.internal.ads.zzcqq
            private final zzatc zzfvc;

            {
                this.zzfvc = zzatcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                zzatc zzatcVar2 = this.zzfvc;
                zzatcVar2.zzduc = new String(zzdxi.toByteArray((InputStream) obj), zzdvs.UTF_8);
                return zzdyq.zzaf(zzatcVar2);
            }
        };
        zzcqc zzcqcVar = this.zzgkw;
        zzcqcVar.getClass();
        return zza(zzatcVar, zzcqp.zza(zzcqcVar), new zzcqw(this) { // from class: com.google.android.gms.internal.ads.zzcqs
            private final zzcql zzgkx;

            {
                this.zzgkx = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcqw
            public final zzdzc zzq(zzatc zzatcVar2) {
                return this.zzgkx.zzp(zzatcVar2);
            }
        }, zzdyaVar);
    }

    public final zzdzc<Void> zzm(zzatc zzatcVar) {
        if (zzfg.zzas(zzatcVar.zzduc)) {
            return zzdyq.immediateFailedFuture(new zzcof(zzdpg.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return zza(zzatcVar, new zzcqw(this) { // from class: com.google.android.gms.internal.ads.zzcqu
            private final zzcql zzgkx;

            {
                this.zzgkx = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcqw
            public final zzdzc zzq(zzatc zzatcVar2) {
                return this.zzgkx.zzo(zzatcVar2);
            }
        }, new zzcqw(this) { // from class: com.google.android.gms.internal.ads.zzcqt
            private final zzcql zzgkx;

            {
                this.zzgkx = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcqw
            public final zzdzc zzq(zzatc zzatcVar2) {
                return this.zzgkx.zzn(zzatcVar2);
            }
        }, zzcqr.zzboo);
    }

    final /* synthetic */ zzdzc zzn(zzatc zzatcVar) {
        return this.zzgjf.get().zzgn(zzatcVar.zzduc);
    }

    final /* synthetic */ zzdzc zzo(zzatc zzatcVar) {
        return this.zzgkw.zzgm(zzatcVar.zzduc);
    }

    final /* synthetic */ zzdzc zzp(zzatc zzatcVar) {
        return this.zzgjf.get().zzc(zzatcVar, Binder.getCallingUid());
    }

    final /* synthetic */ zzdzc zza(zzcqw zzcqwVar, zzatc zzatcVar, zzdya zzdyaVar, zzcqm zzcqmVar) throws Exception {
        return zzdyq.zzb(zzcqwVar.zzq(zzatcVar), zzdyaVar, this.zzgcz);
    }
}
