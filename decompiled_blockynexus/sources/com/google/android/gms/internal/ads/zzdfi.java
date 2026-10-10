package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgu;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfi<S extends zzdgu<?>> implements zzdgx<S> {
    private final ScheduledExecutorService zzfoz;
    private final zzdgx<S> zzgwj;
    private final long zzgxd;

    public zzdfi(zzdgx<S> zzdgxVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgwj = zzdgxVar;
        this.zzgxd = j;
        this.zzfoz = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<S> zzarj() {
        zzdzc<S> zzdzcVarZzarj = this.zzgwj.zzarj();
        long j = this.zzgxd;
        if (j > 0) {
            zzdzcVarZzarj = zzdyq.zza(zzdzcVarZzarj, j, TimeUnit.MILLISECONDS, this.zzfoz);
        }
        return zzdyq.zzb(zzdzcVarZzarj, Throwable.class, zzdfl.zzboo, zzbbz.zzeeu);
    }
}
