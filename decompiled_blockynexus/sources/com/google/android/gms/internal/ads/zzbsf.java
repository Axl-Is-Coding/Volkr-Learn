package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsf implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbmh> zzfpj;

    private zzbsf(zzeph<zzbmh> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfpj = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzcab<zzbvs> zza(zzbmh zzbmhVar, Executor executor) {
        zzcab<zzbvs> zzcabVar = new zzcab<>(zzbmhVar, executor);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }

    public static zzbsf zzi(zzeph<zzbmh> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzbsf(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfpj.get(), this.zzesr.get());
    }
}
