package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchy implements zzeoy<zzchj> {
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzcjt> zzgbz;

    public zzchy(zzeph<zzdok> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzcjt> zzephVar3) {
        this.zzfqr = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzgbz = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzchj(this.zzfqr.get(), this.zzfqk.get(), this.zzgbz.get());
    }
}
