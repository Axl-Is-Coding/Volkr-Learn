package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbth implements zzeoy<zzbwk> {
    private final zzeph<zzbwk> zzftr;

    private zzbth(zzeph<zzbwk> zzephVar) {
        this.zzftr = zzephVar;
    }

    public static zzbth zzf(zzeph<zzbwk> zzephVar) {
        return new zzbth(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbwk zzbwkVar = this.zzftr.get();
        zzepe.zza(zzbwkVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbwkVar;
    }
}
