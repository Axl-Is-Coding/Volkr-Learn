package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdby implements zzeoy<zzdbx> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzdzc<String>> zzgve;

    private zzdby(zzeph<zzdzc<String>> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzgve = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzdby zzaw(zzeph<zzdzc<String>> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzdby(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdbx(this.zzgve.get(), this.zzesr.get());
    }
}
