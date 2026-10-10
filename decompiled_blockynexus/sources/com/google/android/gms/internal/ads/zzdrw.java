package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrw {
    private final E zzhjx;
    private final List<zzdzc<?>> zzhkc;
    private final /* synthetic */ zzdru zzhkd;

    private zzdrw(zzdru zzdruVar, E e2, List<zzdzc<?>> list) {
        this.zzhkd = zzdruVar;
        this.zzhjx = e2;
        this.zzhkc = list;
    }

    public final <O> zzdsa<O> zzb(Callable<O> callable) {
        zzdyv zzdyvVarZzk = zzdyq.zzk(this.zzhkc);
        zzdzc zzdzcVarZza = zzdyvVarZzk.zza(zzdrv.zzgww, zzbbz.zzeeu);
        zzdru zzdruVar = this.zzhkd;
        return new zzdsa<>(zzdruVar, this.zzhjx, zzdzcVarZza, this.zzhkc, zzdyvVarZzk.zza(callable, zzdruVar.zzgcz));
    }
}
