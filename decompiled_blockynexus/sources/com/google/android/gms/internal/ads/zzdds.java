package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdds implements zzeoy<zzddq> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<String> zzfow;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzckw> zzgwm;

    private zzdds(zzeph<zzdzb> zzephVar, zzeph<zzckw> zzephVar2, zzeph<zzdok> zzephVar3, zzeph<String> zzephVar4) {
        this.zzesr = zzephVar;
        this.zzgwm = zzephVar2;
        this.zzfqr = zzephVar3;
        this.zzfow = zzephVar4;
    }

    public static zzdds zzh(zzeph<zzdzb> zzephVar, zzeph<zzckw> zzephVar2, zzeph<zzdok> zzephVar3, zzeph<String> zzephVar4) {
        return new zzdds(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzddq(this.zzesr.get(), this.zzgwm.get(), this.zzfqr.get(), this.zzfow.get());
    }
}
