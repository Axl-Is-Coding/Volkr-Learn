package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcur implements zzeoy<zzcun> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzbpm> zzfji;
    private final zzeph<zzctt> zzfjm;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzbug> zzgoz;

    public zzcur(zzeph<zzbpm> zzephVar, zzeph<zzctt> zzephVar2, zzeph<zzbug> zzephVar3, zzeph<ScheduledExecutorService> zzephVar4, zzeph<zzdzb> zzephVar5) {
        this.zzfji = zzephVar;
        this.zzfjm = zzephVar2;
        this.zzgoz = zzephVar3;
        this.zzfnm = zzephVar4;
        this.zzesr = zzephVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcun(this.zzfji.get(), this.zzfjm.get(), this.zzgoz.get(), this.zzfnm.get(), this.zzesr.get());
    }
}
