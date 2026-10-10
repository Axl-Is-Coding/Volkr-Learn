package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgg implements zzeoy<zzcgd> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbuc> zzfcn;
    private final zzeph<zzbuu> zzfcx;
    private final zzeph<zzanu> zzfee;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<zzano> zzgcp;
    private final zzeph<zzanp> zzgcq;

    public zzcgg(zzeph<zzano> zzephVar, zzeph<zzanp> zzephVar2, zzeph<zzanu> zzephVar3, zzeph<zzbuu> zzephVar4, zzeph<zzbuc> zzephVar5, zzeph<Context> zzephVar6, zzeph<zzdnv> zzephVar7, zzeph<zzbbx> zzephVar8, zzeph<zzdok> zzephVar9) {
        this.zzgcp = zzephVar;
        this.zzgcq = zzephVar2;
        this.zzfee = zzephVar3;
        this.zzfcx = zzephVar4;
        this.zzfcn = zzephVar5;
        this.zzesu = zzephVar6;
        this.zzfrj = zzephVar7;
        this.zzfmh = zzephVar8;
        this.zzfqr = zzephVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcgd(this.zzgcp.get(), this.zzgcq.get(), this.zzfee.get(), this.zzfcx.get(), this.zzfcn.get(), this.zzesu.get(), this.zzfrj.get(), this.zzfmh.get(), this.zzfqr.get());
    }
}
