package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpc {
    private final ScheduledExecutorService zzfmv;
    private final zzdzb zzgcz;
    private final zzeos<zzcqv> zzgjf;
    private final zzcpx zzgjq;

    public zzcpc(ScheduledExecutorService scheduledExecutorService, zzdzb zzdzbVar, zzcpx zzcpxVar, zzeos<zzcqv> zzeosVar) {
        this.zzfmv = scheduledExecutorService;
        this.zzgcz = zzdzbVar;
        this.zzgjq = zzcpxVar;
        this.zzgjf = zzeosVar;
    }

    final /* synthetic */ zzdzc zza(zzatc zzatcVar, int i, Throwable th) throws Exception {
        return this.zzgjf.get().zzd(zzatcVar, i);
    }

    public final zzdzc<InputStream> zzg(final zzatc zzatcVar) {
        String str = zzatcVar.packageName;
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzdzc<InputStream> zzdzcVarImmediateFailedFuture = zzayu.zzer(str) ? zzdyq.immediateFailedFuture(new zzcqm(zzdpg.INTERNAL_ERROR)) : this.zzgjq.zzj(zzatcVar);
        final int callingUid = Binder.getCallingUid();
        return zzdyl.zzg(zzdzcVarImmediateFailedFuture).zza(((Integer) zzwm.zzpx().zzd(zzabb.zzcvb)).intValue(), TimeUnit.SECONDS, this.zzfmv).zza(Throwable.class, new zzdya(this, zzatcVar, callingUid) { // from class: com.google.android.gms.internal.ads.zzcpb
            private final int zzebt;
            private final zzatc zzgjc;
            private final zzcpc zzgjp;

            {
                this.zzgjp = this;
                this.zzgjc = zzatcVar;
                this.zzebt = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgjp.zza(this.zzgjc, this.zzebt, (Throwable) obj);
            }
        }, this.zzgcz);
    }
}
