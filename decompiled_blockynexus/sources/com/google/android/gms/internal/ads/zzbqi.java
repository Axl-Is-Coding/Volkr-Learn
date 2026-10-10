package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqi implements zzeoy<zzbqf> {
    private final zzeph<zzdnv> zzfno;
    private final zzeph<zzbuu> zzfrl;
    private final zzeph<zzbvw> zzfrm;

    private zzbqi(zzeph<zzdnv> zzephVar, zzeph<zzbuu> zzephVar2, zzeph<zzbvw> zzephVar3) {
        this.zzfno = zzephVar;
        this.zzfrl = zzephVar2;
        this.zzfrm = zzephVar3;
    }

    public static zzbqi zzf(zzeph<zzdnv> zzephVar, zzeph<zzbuu> zzephVar2, zzeph<zzbvw> zzephVar3) {
        return new zzbqi(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbqf(this.zzfno.get(), this.zzfrl.get(), this.zzfrm.get());
    }
}
