package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmv implements zzeoy<zzcmu> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcmz> zzetn;

    public zzcmv(zzeph<zzcmz> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzetn = zzephVar;
        this.zzesr = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcmu(this.zzetn.get(), this.zzesr.get());
    }
}
