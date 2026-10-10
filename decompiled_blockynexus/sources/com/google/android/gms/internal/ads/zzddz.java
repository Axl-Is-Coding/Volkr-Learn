package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.location.Location;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddz implements zzdgx<zzddw> {
    private ApplicationInfo applicationInfo;
    private zzayr zzdzr;
    private ScheduledExecutorService zzfmv;
    zzdok zzfsk;
    private zzams zzgwp;

    public zzddz(zzams zzamsVar, ScheduledExecutorService scheduledExecutorService, zzayr zzayrVar, ApplicationInfo applicationInfo, zzdok zzdokVar) {
        this.zzgwp = zzamsVar;
        this.zzfmv = scheduledExecutorService;
        this.zzdzr = zzayrVar;
        this.applicationInfo = applicationInfo;
        this.zzfsk = zzdokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzddw> zzarj() {
        zzdzc zzdzcVarZzb;
        if (zzacl.zzdab.get().booleanValue() && this.zzdzr.zzxi()) {
            zzdzcVarZzb = zzdyq.zzb(zzdyq.zza(this.zzgwp.zza(this.applicationInfo), ((Long) zzwm.zzpx().zzd(zzabb.zzcsm)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv), Throwable.class, zzdea.zzboo, zzbbz.zzeeu);
        } else {
            zzdzcVarZzb = zzdyq.zzaf(null);
        }
        return zzdyq.zzb(zzdyq.zzb(zzdzcVarZzb, new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzdeb
            private final zzddz zzgwq;

            {
                this.zzgwq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                Location location = (Location) obj;
                return location != null ? location : this.zzgwq.zzfsk.zzhfa.zznb;
            }
        }, this.zzfmv), zzddy.zzdwz, zzbbz.zzeep);
    }
}
