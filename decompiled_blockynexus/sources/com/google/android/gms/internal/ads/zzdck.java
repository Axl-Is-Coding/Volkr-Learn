package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdck implements zzeoy<zzdci> {
    private final zzeph<zzcku> zzeso;
    private final zzeph<zzdzb> zzgvb;
    private final zzeph<String> zzgvp;

    private zzdck(zzeph<String> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcku> zzephVar3) {
        this.zzgvp = zzephVar;
        this.zzgvb = zzephVar2;
        this.zzeso = zzephVar3;
    }

    public static zzdck zzr(zzeph<String> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcku> zzephVar3) {
        return new zzdck(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdci(this.zzgvp.get(), this.zzgvb.get(), this.zzeso.get());
    }
}
