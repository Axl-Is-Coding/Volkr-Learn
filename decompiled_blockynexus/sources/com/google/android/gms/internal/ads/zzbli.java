package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbli implements zzeoy<zzbld> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzcku> zzete;
    private final zzeph<zzcnu> zzetp;
    private final zzeph<zzckw> zzetr;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzctb<zzdpa, zzcut>> zzfmi;
    private final zzeph<zzcza> zzfmj;
    private final zzeph<zzawo> zzfmk;

    public zzbli(zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzcku> zzephVar3, zzeph<zzctb<zzdpa, zzcut>> zzephVar4, zzeph<zzcza> zzephVar5, zzeph<zzcnu> zzephVar6, zzeph<zzawo> zzephVar7, zzeph<zzckw> zzephVar8) {
        this.zzesu = zzephVar;
        this.zzfmh = zzephVar2;
        this.zzete = zzephVar3;
        this.zzfmi = zzephVar4;
        this.zzfmj = zzephVar5;
        this.zzetp = zzephVar6;
        this.zzfmk = zzephVar7;
        this.zzetr = zzephVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbld(this.zzesu.get(), this.zzfmh.get(), this.zzete.get(), this.zzfmi.get(), this.zzfmj.get(), this.zzetp.get(), this.zzfmk.get(), this.zzetr.get());
    }
}
