package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbub implements zzeoy<zzbty> {
    private final zzeph<zzctd> zzewv;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<String> zzfun;

    private zzbub(zzeph<zzdnv> zzephVar, zzeph<String> zzephVar2, zzeph<zzctd> zzephVar3) {
        this.zzfrj = zzephVar;
        this.zzfun = zzephVar2;
        this.zzewv = zzephVar3;
    }

    public static zzbub zzi(zzeph<zzdnv> zzephVar, zzeph<String> zzephVar2, zzeph<zzctd> zzephVar3) {
        return new zzbub(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbty(this.zzfrj.get(), this.zzfun.get(), this.zzewv.get());
    }
}
