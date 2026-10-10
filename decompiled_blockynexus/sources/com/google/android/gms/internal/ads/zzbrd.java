package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrd implements zzeoy<zzdnv> {
    private final zzbre zzfsf;

    private zzbrd(zzbre zzbreVar) {
        this.zzfsf = zzbreVar;
    }

    public static zzbrd zza(zzbre zzbreVar) {
        return new zzbrd(zzbreVar);
    }

    public static zzdnv zzb(zzbre zzbreVar) {
        zzdnv zzdnvVarZzajd = zzbreVar.zzajd();
        zzepe.zza(zzdnvVarZzajd, "Cannot return null from a non-@Nullable @Provides method");
        return zzdnvVarZzajd;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzfsf);
    }
}
