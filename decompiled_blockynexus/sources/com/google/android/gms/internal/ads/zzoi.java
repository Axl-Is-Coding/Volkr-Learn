package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoi {
    public final zznp zzbhw;
    public final zzod zzbhx;
    public final Object zzbhy;
    public final zzhz[] zzbhz;

    public zzoi(zznp zznpVar, zzod zzodVar, Object obj, zzhz[] zzhzVarArr) {
        this.zzbhw = zznpVar;
        this.zzbhx = zzodVar;
        this.zzbhy = obj;
        this.zzbhz = zzhzVarArr;
    }

    public final boolean zza(zzoi zzoiVar, int i) {
        return zzoiVar != null && zzpq.zza(this.zzbhx.zzbg(i), zzoiVar.zzbhx.zzbg(i)) && zzpq.zza(this.zzbhz[i], zzoiVar.zzbhz[i]);
    }
}
