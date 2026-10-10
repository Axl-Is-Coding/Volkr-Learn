package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcto implements zzeoy<zzcth> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzbbx> zzfup;
    private final zzeph<zzcjt> zzgbz;
    private final zzeph<zzbob> zzgof;

    public zzcto(zzeph<zzbob> zzephVar, zzeph<Context> zzephVar2, zzeph<Executor> zzephVar3, zzeph<zzcjt> zzephVar4, zzeph<zzdok> zzephVar5, zzeph<zzbbx> zzephVar6) {
        this.zzgof = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfqk = zzephVar3;
        this.zzgbz = zzephVar4;
        this.zzfqr = zzephVar5;
        this.zzfup = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcth(this.zzgof.get(), this.zzesu.get(), this.zzfqk.get(), this.zzgbz.get(), this.zzfqr.get(), this.zzfup.get());
    }
}
