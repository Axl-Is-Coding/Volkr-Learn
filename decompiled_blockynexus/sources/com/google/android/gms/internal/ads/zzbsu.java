package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsu implements zzeoy<zzcab<zzbyc>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcmi> zzfop;

    private zzbsu(zzeph<zzcmi> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfop = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzbsu zzs(zzeph<zzcmi> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzbsu(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfop.get(), this.zzesr.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
