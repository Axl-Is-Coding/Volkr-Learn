package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchv implements zzeoy<zzchs> {
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzbnd> zzgca;
    private final zzeph<zzcae> zzgea;

    public zzchv(zzeph<Executor> zzephVar, zzeph<zzbnd> zzephVar2, zzeph<zzcae> zzephVar3) {
        this.zzfqk = zzephVar;
        this.zzgca = zzephVar2;
        this.zzgea = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzchs(this.zzfqk.get(), this.zzgca.get(), this.zzgea.get());
    }
}
