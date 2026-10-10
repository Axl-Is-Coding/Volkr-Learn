package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbe implements zzeoy<zzdaq> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzeg> zzfnq;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<zzdoz<zzcil>> zzgpq;
    private final zzeph<zzbix> zzguq;

    public zzdbe(zzeph<zzbix> zzephVar, zzeph<Context> zzephVar2, zzeph<zzeg> zzephVar3, zzeph<zzbbx> zzephVar4, zzeph<zzdoz<zzcil>> zzephVar5, zzeph<zzdzb> zzephVar6, zzeph<ScheduledExecutorService> zzephVar7) {
        this.zzguq = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfnq = zzephVar3;
        this.zzfov = zzephVar4;
        this.zzgpq = zzephVar5;
        this.zzesr = zzephVar6;
        this.zzfnm = zzephVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdaq(this.zzguq.get(), this.zzesu.get(), this.zzfnq.get(), this.zzfov.get(), this.zzgpq.get(), this.zzesr.get(), this.zzfnm.get());
    }
}
