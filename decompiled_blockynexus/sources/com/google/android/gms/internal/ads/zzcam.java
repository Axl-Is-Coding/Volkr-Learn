package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcam implements zzeoy<zzcaj> {
    private final zzeph<zzdst> zzezd;
    private final zzeph<zzdnv> zzfno;

    private zzcam(zzeph<zzdnv> zzephVar, zzeph<zzdst> zzephVar2) {
        this.zzfno = zzephVar;
        this.zzezd = zzephVar2;
    }

    public static zzcam zzv(zzeph<zzdnv> zzephVar, zzeph<zzdst> zzephVar2) {
        return new zzcam(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcaj(this.zzfno.get(), this.zzezd.get());
    }
}
