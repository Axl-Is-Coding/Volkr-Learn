package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzok implements zzol {
    private static final zzdh<Long> zza;
    private static final zzdh<Long> zzb;

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.id.max_bundles_per_iteration", 0L);
        zzb = zzdmVar.zza("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // com.google.android.gms.internal.measurement.zzol
    public final long zza() {
        return zzb.zzc().longValue();
    }
}
