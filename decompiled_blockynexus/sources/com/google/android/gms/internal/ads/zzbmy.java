package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmy implements zzeoy<zzbml> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzqo> zzfor;
    private final zzeph<zzamk> zzfos;

    private zzbmy(zzeph<zzqo> zzephVar, zzeph<zzamk> zzephVar2, zzeph<Executor> zzephVar3) {
        this.zzfor = zzephVar;
        this.zzfos = zzephVar2;
        this.zzesr = zzephVar3;
    }

    public static zzbmy zzb(zzeph<zzqo> zzephVar, zzeph<zzamk> zzephVar2, zzeph<Executor> zzephVar3) {
        return new zzbmy(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzqo zzqoVar = this.zzfor.get();
        zzbml zzbmlVar = new zzbml(zzqoVar.getUniqueId(), this.zzfos.get(), this.zzesr.get());
        zzepe.zza(zzbmlVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbmlVar;
    }
}
