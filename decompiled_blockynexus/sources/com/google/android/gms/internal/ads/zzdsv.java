package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsv implements zzeoy<zzdst> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbbu> zzetm;

    private zzdsv(zzeph<Executor> zzephVar, zzeph<zzbbu> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzetm = zzephVar2;
    }

    public static zzdsv zzbj(zzeph<Executor> zzephVar, zzeph<zzbbu> zzephVar2) {
        return new zzdsv(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdst(this.zzesr.get(), this.zzetm.get());
    }
}
