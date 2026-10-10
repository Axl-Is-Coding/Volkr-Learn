package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvb implements zzeoy<zzcuw> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzcjt> zzgbz;
    private final zzeph<zzcce> zzgof;

    public zzcvb(zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdok> zzephVar3, zzeph<Executor> zzephVar4, zzeph<zzcce> zzephVar5, zzeph<zzcjt> zzephVar6) {
        this.zzesu = zzephVar;
        this.zzfov = zzephVar2;
        this.zzfqr = zzephVar3;
        this.zzfqk = zzephVar4;
        this.zzgof = zzephVar5;
        this.zzgbz = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcuw(this.zzesu.get(), this.zzfov.get(), this.zzfqr.get(), this.zzfqk.get(), this.zzgof.get(), this.zzgbz.get());
    }
}
