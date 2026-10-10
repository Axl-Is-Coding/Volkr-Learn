package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbp implements zzeoy<zzcab<zzaia>> {
    private final zzeph<zzcje> zzfpj;
    private final zzcbf zzfwx;

    public zzcbp(zzcbf zzcbfVar, zzeph<zzcje> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
