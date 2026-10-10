package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtm {
    private final String packageName;
    private final zzbbx zzbot;
    private final PackageInfo zzdqs;
    private final List<String> zzdrc;
    private final String zzdua;
    private final zzayr zzdzr;
    private final zzdsi zzfsl;
    private final ApplicationInfo zzfty;
    private final zzeos<zzdzc<String>> zzftz;
    private final zzdgw<Bundle> zzfua;

    public zzbtm(zzdsi zzdsiVar, zzbbx zzbbxVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeos<zzdzc<String>> zzeosVar, zzayr zzayrVar, String str2, zzdgw<Bundle> zzdgwVar) {
        this.zzfsl = zzdsiVar;
        this.zzbot = zzbbxVar;
        this.zzfty = applicationInfo;
        this.packageName = str;
        this.zzdrc = list;
        this.zzdqs = packageInfo;
        this.zzftz = zzeosVar;
        this.zzdzr = zzayrVar;
        this.zzdua = str2;
        this.zzfua = zzdgwVar;
    }

    public final zzdzc<Bundle> zzajo() {
        return this.zzfsl.zzu(zzdsf.SIGNALS).zze(this.zzfua.zzt(new Bundle())).zzavs();
    }

    public final zzdzc<zzatc> zzajp() {
        final zzdzc<Bundle> zzdzcVarZzajo = zzajo();
        return this.zzfsl.zza(zzdsf.REQUEST_PARCEL, zzdzcVarZzajo, this.zzftz.get()).zzb(new Callable(this, zzdzcVarZzajo) { // from class: com.google.android.gms.internal.ads.zzbtl
            private final zzbtm zzftw;
            private final zzdzc zzftx;

            {
                this.zzftw = this;
                this.zzftx = zzdzcVarZzajo;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzftw.zzc(this.zzftx);
            }
        }).zzavs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzatc zzc(zzdzc zzdzcVar) throws Exception {
        return new zzatc((Bundle) zzdzcVar.get(), this.zzbot, this.zzfty, this.packageName, this.zzdrc, this.zzdqs, this.zzftz.get().get(), this.zzdzr.zzxi(), this.zzdua, null, null);
    }
}
