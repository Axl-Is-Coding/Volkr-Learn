package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmn implements zzeoy<zzcab<zzdso>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcmy> zzfop;

    private zzcmn(zzeph<zzcmy> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfop = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzcmn zzal(zzeph<zzcmy> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzcmn(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfop.get(), this.zzesr.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
