package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdri implements zzeoy<zzdzb> {
    public static zzdri zzavg() {
        return zzdrh.zzhjs;
    }

    public static zzdzb zzavh() {
        zzdzb zzdzbVar = zzbbz.zzeep;
        zzepe.zza(zzdzbVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzavh();
    }
}
