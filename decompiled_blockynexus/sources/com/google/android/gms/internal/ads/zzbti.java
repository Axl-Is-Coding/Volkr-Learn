package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbti implements zzeoy<zzbtd> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbuu> zzfts;
    private final zzeph<zzdnv> zzftt;
    private final zzeph<ScheduledExecutorService> zzftu;

    private zzbti(zzeph<zzbuu> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<ScheduledExecutorService> zzephVar3, zzeph<Executor> zzephVar4) {
        this.zzfts = zzephVar;
        this.zzftt = zzephVar2;
        this.zzftu = zzephVar3;
        this.zzesr = zzephVar4;
    }

    public static zzbti zzb(zzeph<zzbuu> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<ScheduledExecutorService> zzephVar3, zzeph<Executor> zzephVar4) {
        return new zzbti(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbtd(this.zzfts.get(), this.zzftt.get(), this.zzftu.get(), this.zzesr.get());
    }
}
