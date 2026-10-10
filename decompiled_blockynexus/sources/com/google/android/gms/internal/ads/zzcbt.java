package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbt implements zzeoy<zzcab<zzbuh>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzccs> zzfpj;
    private final zzcbf zzfwx;

    private zzcbt(zzcbf zzcbfVar, zzeph<zzccs> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzcbt zzb(zzcbf zzcbfVar, zzeph<zzccs> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzcbt(zzcbfVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), this.zzesr.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
