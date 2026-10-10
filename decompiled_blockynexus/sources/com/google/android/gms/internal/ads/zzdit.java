package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdit implements zzdgx<zzdiq> {
    private ApplicationInfo applicationInfo;
    private boolean zzdtz;
    private ScheduledExecutorService zzfmv;
    private zzams zzgwp;

    public zzdit(zzams zzamsVar, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.zzgwp = zzamsVar;
        this.zzfmv = scheduledExecutorService;
        this.zzdtz = z;
        this.applicationInfo = applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdiq> zzarj() {
        if (!zzacl.zzdac.get().booleanValue()) {
            return zzdyq.immediateFailedFuture(new Exception("Auto Collect Location by gms is disabled."));
        }
        if (!this.zzdtz) {
            return zzdyq.immediateFailedFuture(new Exception("Auto Collect Location is false."));
        }
        return zzdyq.zzb(zzdyq.zza(this.zzgwp.zza(this.applicationInfo), ((Long) zzwm.zzpx().zzd(zzabb.zzcsm)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv), zzdis.zzdwz, zzbbz.zzeep);
    }
}
