package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpe implements zzeoy<zzcpc> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzcpx> zzgjh;
    private final zzeph<zzcqv> zzgji;

    public zzcpe(zzeph<ScheduledExecutorService> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcpx> zzephVar3, zzeph<zzcqv> zzephVar4) {
        this.zzfnm = zzephVar;
        this.zzesr = zzephVar2;
        this.zzgjh = zzephVar3;
        this.zzgji = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcpc(this.zzfnm.get(), this.zzesr.get(), this.zzgjh.get(), zzeov.zzat(this.zzgji));
    }
}
