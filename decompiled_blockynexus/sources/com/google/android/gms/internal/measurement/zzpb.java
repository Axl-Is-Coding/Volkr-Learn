package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpb implements zzoy {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Long> zzb;

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.service.ssaid_removal", true);
        zzb = zzdmVar.zza("measurement.id.ssaid_removal", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
