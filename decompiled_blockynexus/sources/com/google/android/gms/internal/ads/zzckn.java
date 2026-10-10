package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckn implements zzeoy<zzcab<zzbuy>> {
    private final zzeph<zzckm> zzfpj;
    private final zzcko zzgft;

    private zzckn(zzcko zzckoVar, zzeph<zzckm> zzephVar) {
        this.zzgft = zzckoVar;
        this.zzfpj = zzephVar;
    }

    public static zzckn zza(zzcko zzckoVar, zzeph<zzckm> zzephVar) {
        return new zzckn(zzckoVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeet);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
