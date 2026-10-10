package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrf implements zzeoy<zzdnw> {
    private final zzbre zzfsf;

    private zzbrf(zzbre zzbreVar) {
        this.zzfsf = zzbreVar;
    }

    public static zzbrf zzc(zzbre zzbreVar) {
        return new zzbrf(zzbreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdnw zzdnwVarZzaje = this.zzfsf.zzaje();
        zzepe.zza(zzdnwVarZzaje, "Cannot return null from a non-@Nullable @Provides method");
        return zzdnwVarZzaje;
    }
}
