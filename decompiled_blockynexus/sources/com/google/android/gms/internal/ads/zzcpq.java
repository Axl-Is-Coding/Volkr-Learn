package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpq implements zzeoy<zzcpm> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzcsc> zzewe;
    private final zzeph<zzcoi> zzfag;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzdok> zzfqr;

    private zzcpq(zzeph<zzdok> zzephVar, zzeph<zzcoi> zzephVar2, zzeph<zzdzb> zzephVar3, zzeph<ScheduledExecutorService> zzephVar4, zzeph<zzcsc> zzephVar5) {
        this.zzfqr = zzephVar;
        this.zzfag = zzephVar2;
        this.zzesr = zzephVar3;
        this.zzfnm = zzephVar4;
        this.zzewe = zzephVar5;
    }

    public static zzcpq zzf(zzeph<zzdok> zzephVar, zzeph<zzcoi> zzephVar2, zzeph<zzdzb> zzephVar3, zzeph<ScheduledExecutorService> zzephVar4, zzeph<zzcsc> zzephVar5) {
        return new zzcpq(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcpm(this.zzfqr.get(), this.zzfag.get(), this.zzesr.get(), this.zzfnm.get(), this.zzewe.get());
    }
}
