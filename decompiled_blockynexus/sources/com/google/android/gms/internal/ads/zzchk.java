package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchk implements zzeoy<zzchg> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcgw> zzgdc;

    public zzchk(zzeph<Executor> zzephVar, zzeph<zzcgw> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgdc = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzchg(this.zzesr.get(), this.zzgdc.get());
    }
}
