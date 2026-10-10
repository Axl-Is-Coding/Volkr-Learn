package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfi implements zzeoy<zzcfe> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzayr> zzevu;
    private final zzeph<zzcem> zzfeh;
    private final zzeph<zzcfm> zzfei;
    private final zzeph<zzcfu> zzfej;
    private final zzeph<zzced> zzfel;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzcei> zzfym;

    private zzcfi(zzeph<zzayr> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzcem> zzephVar3, zzeph<zzcei> zzephVar4, zzeph<zzcfm> zzephVar5, zzeph<zzcfu> zzephVar6, zzeph<Executor> zzephVar7, zzeph<Executor> zzephVar8, zzeph<zzced> zzephVar9) {
        this.zzevu = zzephVar;
        this.zzfqr = zzephVar2;
        this.zzfeh = zzephVar3;
        this.zzfym = zzephVar4;
        this.zzfei = zzephVar5;
        this.zzfej = zzephVar6;
        this.zzfqk = zzephVar7;
        this.zzesr = zzephVar8;
        this.zzfel = zzephVar9;
    }

    public static zzcfi zza(zzeph<zzayr> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzcem> zzephVar3, zzeph<zzcei> zzephVar4, zzeph<zzcfm> zzephVar5, zzeph<zzcfu> zzephVar6, zzeph<Executor> zzephVar7, zzeph<Executor> zzephVar8, zzeph<zzced> zzephVar9) {
        return new zzcfi(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcfe(this.zzevu.get(), this.zzfqr.get(), this.zzfeh.get(), this.zzfym.get(), this.zzfei.get(), this.zzfej.get(), this.zzfqk.get(), this.zzesr.get(), this.zzfel.get());
    }
}
