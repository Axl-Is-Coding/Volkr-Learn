package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbph implements zzeoy<zzcab<zzqu>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbqj> zzfpj;
    private final zzbot zzfqp;

    public zzbph(zzbot zzbotVar, zzeph<zzbqj> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzfqp = zzbotVar;
        this.zzfpj = zzephVar;
        this.zzesr = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), this.zzesr.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
