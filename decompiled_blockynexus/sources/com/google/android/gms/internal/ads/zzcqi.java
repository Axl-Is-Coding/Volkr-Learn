package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcqi implements zzcqj {
    private final zzdzb zzgcz;
    private final Map<String, zzeph<zzcqj>> zzgkt;
    private final zzbwr zzgku;

    public zzcqi(Map<String, zzeph<zzcqj>> map, zzdzb zzdzbVar, zzbwr zzbwrVar) {
        this.zzgkt = map;
        this.zzgcz = zzdzbVar;
        this.zzgku = zzbwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqj
    public final zzdzc<zzdog> zzh(final zzatc zzatcVar) {
        this.zzgku.zzd(zzatcVar);
        zzdzc<zzdog> zzdzcVarImmediateFailedFuture = zzdyq.immediateFailedFuture(new zzcof(zzdpg.NO_FILL));
        for (String str : ((String) zzwm.zzpx().zzd(zzabb.zzcyk)).split(",")) {
            final zzeph<zzcqj> zzephVar = this.zzgkt.get(str.trim());
            if (zzephVar != null) {
                zzdzcVarImmediateFailedFuture = zzdyq.zzb(zzdzcVarImmediateFailedFuture, zzcof.class, new zzdya(zzephVar, zzatcVar) { // from class: com.google.android.gms.internal.ads.zzcqh
                    private final zzatc zzgjc;
                    private final zzeph zzgks;

                    {
                        this.zzgks = zzephVar;
                        this.zzgjc = zzatcVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdya
                    public final zzdzc zzf(Object obj) {
                        zzeph zzephVar2 = this.zzgks;
                        return ((zzcqj) zzephVar2.get()).zzh(this.zzgjc);
                    }
                }, this.zzgcz);
            }
        }
        zzdyq.zza(zzdzcVarImmediateFailedFuture, new zzcqk(this), zzbbz.zzeeu);
        return zzdzcVarImmediateFailedFuture;
    }
}
