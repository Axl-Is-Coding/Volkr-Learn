package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdik implements zzdgx<zzdil> {
    private String packageName;
    private zzdzb zzgcz;
    private zzaxt zzgzh;

    public zzdik(zzaxt zzaxtVar, zzdzb zzdzbVar, String str) {
        this.zzgzh = zzaxtVar;
        this.zzgcz = zzdzbVar;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdil> zzarj() {
        new zzbcg();
        final zzdzc<String> zzdzcVarZzaf = zzdyq.zzaf(null);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvp)).booleanValue()) {
            zzdzcVarZzaf = this.zzgzh.zzeg(this.packageName);
        }
        final zzdzc<String> zzdzcVarZzeh = this.zzgzh.zzeh(this.packageName);
        return zzdyq.zzb(zzdzcVarZzaf, zzdzcVarZzeh).zza(new Callable(zzdzcVarZzaf, zzdzcVarZzeh) { // from class: com.google.android.gms.internal.ads.zzdin
            private final zzdzc zzftx;
            private final zzdzc zzgdq;

            {
                this.zzgdq = zzdzcVarZzaf;
                this.zzftx = zzdzcVarZzeh;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzdil((String) this.zzgdq.get(), (String) this.zzftx.get());
            }
        }, zzbbz.zzeep);
    }
}
