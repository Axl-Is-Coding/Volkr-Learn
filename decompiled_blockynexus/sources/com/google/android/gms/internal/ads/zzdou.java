package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdou implements zzeoy<zzdor> {
    private final zzeph<zzdst> zzezd;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<zzdnw> zzgez;
    private final zzeph<zzcsp> zzggy;

    private zzdou(zzeph<zzcsp> zzephVar, zzeph<zzdst> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzdnw> zzephVar4) {
        this.zzggy = zzephVar;
        this.zzezd = zzephVar2;
        this.zzfrj = zzephVar3;
        this.zzgez = zzephVar4;
    }

    public static zzdou zzi(zzeph<zzcsp> zzephVar, zzeph<zzdst> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzdnw> zzephVar4) {
        return new zzdou(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdor(this.zzggy.get(), this.zzezd.get(), this.zzfrj.get(), this.zzgez.get());
    }
}
