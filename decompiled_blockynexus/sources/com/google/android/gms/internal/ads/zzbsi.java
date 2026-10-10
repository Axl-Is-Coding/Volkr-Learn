package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsi implements zzeoy<zzbqn> {
    private final zzeph<zzbvb> zzfbx;
    private final zzeph<zzbwv> zzfby;
    private final zzeph<zzbvr> zzfdf;
    private final zzeph<zzdog> zzfnn;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<zzdls> zzftc;
    private final zzeph<zzbty> zzftd;

    private zzbsi(zzeph<zzdog> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<zzbvb> zzephVar3, zzeph<zzbvr> zzephVar4, zzeph<zzdls> zzephVar5, zzeph<zzbty> zzephVar6, zzeph<zzbwv> zzephVar7) {
        this.zzfnn = zzephVar;
        this.zzfrj = zzephVar2;
        this.zzfbx = zzephVar3;
        this.zzfdf = zzephVar4;
        this.zzftc = zzephVar5;
        this.zzftd = zzephVar6;
        this.zzfby = zzephVar7;
    }

    public static zzbsi zza(zzeph<zzdog> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<zzbvb> zzephVar3, zzeph<zzbvr> zzephVar4, zzeph<zzdls> zzephVar5, zzeph<zzbty> zzephVar6, zzeph<zzbwv> zzephVar7) {
        return new zzbsi(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbqn(this.zzfnn.get(), this.zzfrj.get(), this.zzfbx.get(), this.zzfdf.get(), this.zzftc.get(), this.zzftd.get(), this.zzfby.get());
    }
}
