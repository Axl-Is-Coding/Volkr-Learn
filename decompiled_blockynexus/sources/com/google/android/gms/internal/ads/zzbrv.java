package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrv implements zzeoy<zzcab<zzbvs>> {
    private final zzbrr zzfsy;
    private final zzeph<zzbsa> zzfsz;

    private zzbrv(zzbrr zzbrrVar, zzeph<zzbsa> zzephVar) {
        this.zzfsy = zzbrrVar;
        this.zzfsz = zzephVar;
    }

    public static zzbrv zzc(zzbrr zzbrrVar, zzeph<zzbsa> zzephVar) {
        return new zzbrv(zzbrrVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfsz.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
