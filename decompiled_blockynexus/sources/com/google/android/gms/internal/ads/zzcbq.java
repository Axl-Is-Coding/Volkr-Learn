package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbq implements zzeoy<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> {
    private final zzeph<zzcco> zzfpj;
    private final zzcbf zzfwx;

    private zzcbq(zzcbf zzcbfVar, zzeph<zzcco> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
    }

    public static zzcbq zzd(zzcbf zzcbfVar, zzeph<zzcco> zzephVar) {
        return new zzcbq(zzcbfVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeet);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
