package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzh implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzw zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzw zzwVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzv().zza(this.zza);
    }
}
