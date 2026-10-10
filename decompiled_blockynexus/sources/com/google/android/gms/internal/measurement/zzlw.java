package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlw implements zzlx {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;

    static {
        zzdm zzdmVar = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdmVar.zza("measurement.androidId.delete_feature", true);
        zzb = zzdmVar.zza("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
