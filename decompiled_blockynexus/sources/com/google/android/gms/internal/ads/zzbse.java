package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbse implements zzeoy<zzcab<zzbuh>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbmh> zzfpj;

    private zzbse(zzeph<zzbmh> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfpj = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzbse zzh(zzeph<zzbmh> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzbse(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), this.zzesr.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
