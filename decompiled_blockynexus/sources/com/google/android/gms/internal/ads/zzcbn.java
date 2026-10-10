package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbn implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<zzcco> zzfpj;
    private final zzcbf zzfwx;

    private zzcbn(zzcbf zzcbfVar, zzeph<zzcco> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
    }

    public static zzcbn zzc(zzcbf zzcbfVar, zzeph<zzcco> zzephVar) {
        return new zzcbn(zzcbfVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeet);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
