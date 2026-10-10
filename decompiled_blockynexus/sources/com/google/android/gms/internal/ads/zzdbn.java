package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbn implements zzeoy<zzdbl> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcpc> zzgjh;

    public zzdbn(zzeph<Executor> zzephVar, zzeph<zzcpc> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgjh = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdbl(this.zzesr.get(), this.zzgjh.get());
    }
}
