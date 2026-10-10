package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrm implements zzeoy<zzdzb> {
    public static zzdrm zzavl() {
        return zzdrl.zzhju;
    }

    public static zzdzb zzavm() {
        zzdzb zzdzbVar = zzbbz.zzeeq;
        zzepe.zza(zzdzbVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzavm();
    }
}
