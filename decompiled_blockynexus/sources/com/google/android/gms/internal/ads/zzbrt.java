package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrt implements zzeoy<zzcab<zzbuh>> {
    private final zzbrr zzfsy;
    private final zzeph<zzbsa> zzfsz;

    private zzbrt(zzbrr zzbrrVar, zzeph<zzbsa> zzephVar) {
        this.zzfsy = zzbrrVar;
        this.zzfsz = zzephVar;
    }

    public static zzbrt zza(zzbrr zzbrrVar, zzeph<zzbsa> zzephVar) {
        return new zzbrt(zzbrrVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfsz.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
