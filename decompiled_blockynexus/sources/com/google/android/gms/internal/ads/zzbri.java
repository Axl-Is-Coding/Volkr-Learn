package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbri implements zzeoy<zzdog> {
    private final zzbre zzfsf;

    private zzbri(zzbre zzbreVar) {
        this.zzfsf = zzbreVar;
    }

    public static zzbri zzf(zzbre zzbreVar) {
        return new zzbri(zzbreVar);
    }

    public static zzdog zzg(zzbre zzbreVar) {
        zzdog zzdogVarZzajc = zzbreVar.zzajc();
        zzepe.zza(zzdogVarZzajc, "Cannot return null from a non-@Nullable @Provides method");
        return zzdogVarZzajc;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzg(this.zzfsf);
    }
}
