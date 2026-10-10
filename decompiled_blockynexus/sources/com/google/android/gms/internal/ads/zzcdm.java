package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdm implements zzeoy<zzcdi> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdst> zzezd;
    private final zzeph<zzbuc> zzfcn;
    private final zzeph<zzbuu> zzfcx;
    private final zzeph<JSONObject> zzfey;
    private final zzeph<zzbmu> zzffe;
    private final zzeph<zzcae> zzffn;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<Clock> zzfok;
    private final zzeph<zzcep> zzfqj;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<zzcil> zzfyl;
    private final zzeph<zzcei> zzfym;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<zzcfh> zzfyo;

    public zzcdm(zzeph<Context> zzephVar, zzeph<zzcep> zzephVar2, zzeph<JSONObject> zzephVar3, zzeph<zzcil> zzephVar4, zzeph<zzcei> zzephVar5, zzeph<zzeg> zzephVar6, zzeph<zzbuu> zzephVar7, zzeph<zzbuc> zzephVar8, zzeph<zzdnv> zzephVar9, zzeph<zzbbx> zzephVar10, zzeph<zzdok> zzephVar11, zzeph<zzbmu> zzephVar12, zzeph<zzcfh> zzephVar13, zzeph<Clock> zzephVar14, zzeph<zzcae> zzephVar15, zzeph<zzdst> zzephVar16) {
        this.zzesu = zzephVar;
        this.zzfqj = zzephVar2;
        this.zzfey = zzephVar3;
        this.zzfyl = zzephVar4;
        this.zzfym = zzephVar5;
        this.zzfyn = zzephVar6;
        this.zzfcx = zzephVar7;
        this.zzfcn = zzephVar8;
        this.zzfrj = zzephVar9;
        this.zzfmh = zzephVar10;
        this.zzfqr = zzephVar11;
        this.zzffe = zzephVar12;
        this.zzfyo = zzephVar13;
        this.zzfok = zzephVar14;
        this.zzffn = zzephVar15;
        this.zzezd = zzephVar16;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcdi(this.zzesu.get(), this.zzfqj.get(), this.zzfey.get(), this.zzfyl.get(), this.zzfym.get(), this.zzfyn.get(), this.zzfcx.get(), this.zzfcn.get(), this.zzfrj.get(), this.zzfmh.get(), this.zzfqr.get(), this.zzffe.get(), this.zzfyo.get(), this.zzfok.get(), this.zzffn.get(), this.zzezd.get());
    }
}
