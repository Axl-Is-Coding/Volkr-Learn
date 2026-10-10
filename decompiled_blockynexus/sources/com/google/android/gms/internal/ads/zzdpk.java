package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpk implements zzeoy<zzcab<zzbui>> {
    private final zzeph<zzdpj> zzfsz;
    private final zzdph zzhgm;

    private zzdpk(zzdph zzdphVar, zzeph<zzdpj> zzephVar) {
        this.zzhgm = zzdphVar;
        this.zzfsz = zzephVar;
    }

    public static zzdpk zza(zzdph zzdphVar, zzeph<zzdpj> zzephVar) {
        return new zzdpk(zzdphVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfsz.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
