package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchd implements zzeoy<zzcgw> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzcgn> zzezr;
    private final zzeph<zzchj> zzezu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<com.google.android.gms.ads.internal.zzb> zzgds;
    private final zzeph<zzts> zzgdt;

    public zzchd(zzeph<Context> zzephVar, zzeph<zzcgn> zzephVar2, zzeph<zzeg> zzephVar3, zzeph<zzbbx> zzephVar4, zzeph<com.google.android.gms.ads.internal.zzb> zzephVar5, zzeph<zzts> zzephVar6, zzeph<Executor> zzephVar7, zzeph<zzdok> zzephVar8, zzeph<zzchj> zzephVar9, zzeph<ScheduledExecutorService> zzephVar10) {
        this.zzesu = zzephVar;
        this.zzezr = zzephVar2;
        this.zzfyn = zzephVar3;
        this.zzfmh = zzephVar4;
        this.zzgds = zzephVar5;
        this.zzgdt = zzephVar6;
        this.zzesr = zzephVar7;
        this.zzfqr = zzephVar8;
        this.zzezu = zzephVar9;
        this.zzfnm = zzephVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcgw(this.zzesu.get(), this.zzezr.get(), this.zzfyn.get(), this.zzfmh.get(), this.zzgds.get(), this.zzgdt.get(), this.zzesr.get(), this.zzfqr.get(), this.zzezu.get(), this.zzfnm.get());
    }
}
