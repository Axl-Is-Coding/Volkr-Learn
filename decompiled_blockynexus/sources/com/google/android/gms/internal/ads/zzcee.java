package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcee implements zzeoy<zzcdx> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzbqn> zzfeb;
    private final zzeph<zzceq> zzfeg;
    private final zzeph<zzcem> zzfeh;
    private final zzeph<zzced> zzfel;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzcep> zzfqj;
    private final zzeph<zzawp> zzfrp;
    private final zzeph<zzcei> zzfym;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<zzcfe> zzfzh;
    private final zzeph<zzcid> zzfzi;
    private final zzeph<zzcib> zzfzj;
    private final zzeph<zzcik> zzfzk;
    private final zzeph<zzchx> zzfzl;
    private final zzeph<zzcif> zzfzm;
    private final zzeph<zzczn> zzfzn;

    private zzcee(zzeph<zzbqn> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzcei> zzephVar3, zzeph<zzceq> zzephVar4, zzeph<zzcfe> zzephVar5, zzeph<zzcem> zzephVar6, zzeph<zzcep> zzephVar7, zzeph<zzcid> zzephVar8, zzeph<zzcib> zzephVar9, zzeph<zzcik> zzephVar10, zzeph<zzchx> zzephVar11, zzeph<zzcif> zzephVar12, zzeph<zzawp> zzephVar13, zzeph<zzeg> zzephVar14, zzeph<zzbbx> zzephVar15, zzeph<Context> zzephVar16, zzeph<zzced> zzephVar17, zzeph<zzczn> zzephVar18) {
        this.zzfeb = zzephVar;
        this.zzesr = zzephVar2;
        this.zzfym = zzephVar3;
        this.zzfeg = zzephVar4;
        this.zzfzh = zzephVar5;
        this.zzfeh = zzephVar6;
        this.zzfqj = zzephVar7;
        this.zzfzi = zzephVar8;
        this.zzfzj = zzephVar9;
        this.zzfzk = zzephVar10;
        this.zzfzl = zzephVar11;
        this.zzfzm = zzephVar12;
        this.zzfrp = zzephVar13;
        this.zzfyn = zzephVar14;
        this.zzfmh = zzephVar15;
        this.zzesu = zzephVar16;
        this.zzfel = zzephVar17;
        this.zzfzn = zzephVar18;
    }

    public static zzcee zza(zzeph<zzbqn> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzcei> zzephVar3, zzeph<zzceq> zzephVar4, zzeph<zzcfe> zzephVar5, zzeph<zzcem> zzephVar6, zzeph<zzcep> zzephVar7, zzeph<zzcid> zzephVar8, zzeph<zzcib> zzephVar9, zzeph<zzcik> zzephVar10, zzeph<zzchx> zzephVar11, zzeph<zzcif> zzephVar12, zzeph<zzawp> zzephVar13, zzeph<zzeg> zzephVar14, zzeph<zzbbx> zzephVar15, zzeph<Context> zzephVar16, zzeph<zzced> zzephVar17, zzeph<zzczn> zzephVar18) {
        return new zzcee(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9, zzephVar10, zzephVar11, zzephVar12, zzephVar13, zzephVar14, zzephVar15, zzephVar16, zzephVar17, zzephVar18);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcdx(this.zzfeb.get(), this.zzesr.get(), this.zzfym.get(), this.zzfeg.get(), this.zzfzh.get(), this.zzfeh.get(), this.zzfqj.get(), zzeov.zzat(this.zzfzi), zzeov.zzat(this.zzfzj), zzeov.zzat(this.zzfzk), zzeov.zzat(this.zzfzl), zzeov.zzat(this.zzfzm), this.zzfrp.get(), this.zzfyn.get(), this.zzfmh.get(), this.zzesu.get(), this.zzfel.get(), this.zzfzn.get());
    }
}
