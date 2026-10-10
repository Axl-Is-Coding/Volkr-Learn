package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmm implements zzeoy<zzbmh> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzdsr> zzezc;
    private final zzeph<zzacb> zzezs;
    private final zzeph<zzdor> zzfcc;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzdog> zzfnn;
    private final zzeph<zzdnv> zzfno;
    private final zzeph<View> zzfnp;
    private final zzeph<zzeg> zzfnq;
    private final zzeph<zzacg> zzfnr;

    private zzbmm(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<ScheduledExecutorService> zzephVar3, zzeph<zzdog> zzephVar4, zzeph<zzdnv> zzephVar5, zzeph<zzdsr> zzephVar6, zzeph<zzdor> zzephVar7, zzeph<View> zzephVar8, zzeph<zzeg> zzephVar9, zzeph<zzacb> zzephVar10, zzeph<zzacg> zzephVar11) {
        this.zzesu = zzephVar;
        this.zzesr = zzephVar2;
        this.zzfnm = zzephVar3;
        this.zzfnn = zzephVar4;
        this.zzfno = zzephVar5;
        this.zzezc = zzephVar6;
        this.zzfcc = zzephVar7;
        this.zzfnp = zzephVar8;
        this.zzfnq = zzephVar9;
        this.zzezs = zzephVar10;
        this.zzfnr = zzephVar11;
    }

    public static zzbmm zza(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<ScheduledExecutorService> zzephVar3, zzeph<zzdog> zzephVar4, zzeph<zzdnv> zzephVar5, zzeph<zzdsr> zzephVar6, zzeph<zzdor> zzephVar7, zzeph<View> zzephVar8, zzeph<zzeg> zzephVar9, zzeph<zzacb> zzephVar10, zzeph<zzacg> zzephVar11) {
        return new zzbmm(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9, zzephVar10, zzephVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbmh(this.zzesu.get(), this.zzesr.get(), this.zzfnm.get(), this.zzfnn.get(), this.zzfno.get(), this.zzezc.get(), this.zzfcc.get(), this.zzfnp.get(), this.zzfnq.get(), this.zzezs.get(), this.zzfnr.get());
    }
}
