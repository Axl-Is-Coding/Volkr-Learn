package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcki implements zzeoy<zzcjv> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbyf> zzfbh;
    private final zzeph<zzbvv> zzfbp;
    private final zzeph<zzbvh> zzfch;
    private final zzeph<zzbuc> zzfcn;
    private final zzeph<zzbwa> zzfdj;
    private final zzeph<zzbmu> zzffe;
    private final zzeph<zzcae> zzffn;
    private final zzeph<zzbxu> zzfhl;
    private final zzeph<zzawl> zzftf;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<com.google.android.gms.ads.internal.zza> zzgfq;
    private final zzeph<zzbvb> zzgfr;

    private zzcki(zzeph<zzbuc> zzephVar, zzeph<zzbvh> zzephVar2, zzeph<zzbvv> zzephVar3, zzeph<zzbwa> zzephVar4, zzeph<zzbyf> zzephVar5, zzeph<Executor> zzephVar6, zzeph<zzcae> zzephVar7, zzeph<zzbmu> zzephVar8, zzeph<com.google.android.gms.ads.internal.zza> zzephVar9, zzeph<zzbvb> zzephVar10, zzeph<zzawl> zzephVar11, zzeph<zzeg> zzephVar12, zzeph<zzbxu> zzephVar13) {
        this.zzfcn = zzephVar;
        this.zzfch = zzephVar2;
        this.zzfbp = zzephVar3;
        this.zzfdj = zzephVar4;
        this.zzfbh = zzephVar5;
        this.zzesr = zzephVar6;
        this.zzffn = zzephVar7;
        this.zzffe = zzephVar8;
        this.zzgfq = zzephVar9;
        this.zzgfr = zzephVar10;
        this.zzftf = zzephVar11;
        this.zzfyn = zzephVar12;
        this.zzfhl = zzephVar13;
    }

    public static zzcki zza(zzeph<zzbuc> zzephVar, zzeph<zzbvh> zzephVar2, zzeph<zzbvv> zzephVar3, zzeph<zzbwa> zzephVar4, zzeph<zzbyf> zzephVar5, zzeph<Executor> zzephVar6, zzeph<zzcae> zzephVar7, zzeph<zzbmu> zzephVar8, zzeph<com.google.android.gms.ads.internal.zza> zzephVar9, zzeph<zzbvb> zzephVar10, zzeph<zzawl> zzephVar11, zzeph<zzeg> zzephVar12, zzeph<zzbxu> zzephVar13) {
        return new zzcki(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9, zzephVar10, zzephVar11, zzephVar12, zzephVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcjv(this.zzfcn.get(), this.zzfch.get(), this.zzfbp.get(), this.zzfdj.get(), this.zzfbh.get(), this.zzesr.get(), this.zzffn.get(), this.zzffe.get(), this.zzgfq.get(), this.zzgfr.get(), this.zzftf.get(), this.zzfyn.get(), this.zzfhl.get());
    }
}
