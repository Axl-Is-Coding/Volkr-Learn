package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcs implements zzeoy<zzdcr> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzayb> zzgvj;

    private zzdcs(zzeph<Executor> zzephVar, zzeph<zzayb> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgvj = zzephVar2;
    }

    public static zzdcr zza(Executor executor, zzayb zzaybVar) {
        return new zzdcr(executor, zzaybVar);
    }

    public static zzdcs zzax(zzeph<Executor> zzephVar, zzeph<zzayb> zzephVar2) {
        return new zzdcs(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzesr.get(), this.zzgvj.get());
    }
}
