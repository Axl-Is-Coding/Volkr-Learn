package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdco implements zzeoy<zzdcm> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzbbx> zzfup;

    private zzdco(zzeph<zzdzb> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzbbx> zzephVar3) {
        this.zzesr = zzephVar;
        this.zzfqr = zzephVar2;
        this.zzfup = zzephVar3;
    }

    public static zzdco zzs(zzeph<zzdzb> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzbbx> zzephVar3) {
        return new zzdco(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdcm(this.zzesr.get(), this.zzfqr.get(), this.zzfup.get());
    }
}
