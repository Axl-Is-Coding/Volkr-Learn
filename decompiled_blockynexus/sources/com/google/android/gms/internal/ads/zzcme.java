package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcme implements zzdso {
    private zzts zzggj;
    private Map<zzdsf, zzcmg> zzggs;

    zzcme(zzts zztsVar, Map<zzdsf, zzcmg> map) {
        this.zzggs = map;
        this.zzggj = zztsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str, Throwable th) {
        if (this.zzggs.containsKey(zzdsfVar)) {
            this.zzggj.zza(this.zzggs.get(zzdsfVar).zzggw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzb(zzdsf zzdsfVar, String str) {
        if (this.zzggs.containsKey(zzdsfVar)) {
            this.zzggj.zza(this.zzggs.get(zzdsfVar).zzggu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzc(zzdsf zzdsfVar, String str) {
        if (this.zzggs.containsKey(zzdsfVar)) {
            this.zzggj.zza(this.zzggs.get(zzdsfVar).zzggv);
        }
    }
}
