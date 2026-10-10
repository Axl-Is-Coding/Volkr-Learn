package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjo implements zzeoy<zzcta<zzcjg>> {
    private final zzeph<zzcxv<zzcjg, zzdpa, zzcut>> zzfoi;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzcxv<zzcjg, zzdpa, zzcuu>> zzgfe;

    public zzcjo(zzeph<zzcxv<zzcjg, zzdpa, zzcut>> zzephVar, zzeph<zzcxv<zzcjg, zzdpa, zzcuu>> zzephVar2, zzeph<zzdok> zzephVar3) {
        this.zzfoi = zzephVar;
        this.zzgfe = zzephVar2;
        this.zzfqr = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzeph<zzcxv<zzcjg, zzdpa, zzcut>> zzephVar = this.zzfoi;
        zzcxv<zzcjg, zzdpa, zzcut> zzcxvVar = zzcjl.zzgfd[this.zzfqr.get().zzhfh.zzheo - 1] != 1 ? this.zzgfe.get() : zzephVar.get();
        zzepe.zza(zzcxvVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcxvVar;
    }
}
