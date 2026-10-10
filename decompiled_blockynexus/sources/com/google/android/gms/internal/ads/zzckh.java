package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckh implements zzeoy<zzcjt> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzacb> zzezs;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzbwk> zzfqs;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<zzts> zzgdt;
    private final zzeph<zzbgr> zzgey;
    private final zzeph<com.google.android.gms.ads.internal.zzb> zzgfo;
    private final zzeph<zzcaz> zzgfp;

    private zzckh(zzeph<zzbgr> zzephVar, zzeph<Context> zzephVar2, zzeph<zzeg> zzephVar3, zzeph<zzacb> zzephVar4, zzeph<zzbbx> zzephVar5, zzeph<com.google.android.gms.ads.internal.zzb> zzephVar6, zzeph<zzts> zzephVar7, zzeph<zzbwk> zzephVar8, zzeph<zzcaz> zzephVar9) {
        this.zzgey = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfyn = zzephVar3;
        this.zzezs = zzephVar4;
        this.zzfmh = zzephVar5;
        this.zzgfo = zzephVar6;
        this.zzgdt = zzephVar7;
        this.zzfqs = zzephVar8;
        this.zzgfp = zzephVar9;
    }

    public static zzckh zzb(zzeph<zzbgr> zzephVar, zzeph<Context> zzephVar2, zzeph<zzeg> zzephVar3, zzeph<zzacb> zzephVar4, zzeph<zzbbx> zzephVar5, zzeph<com.google.android.gms.ads.internal.zzb> zzephVar6, zzeph<zzts> zzephVar7, zzeph<zzbwk> zzephVar8, zzeph<zzcaz> zzephVar9) {
        return new zzckh(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcjt(this.zzgey.get(), this.zzesu.get(), this.zzfyn.get(), this.zzezs.get(), this.zzfmh.get(), this.zzgfo.get(), this.zzgdt.get(), this.zzfqs.get(), this.zzgfp.get());
    }
}
