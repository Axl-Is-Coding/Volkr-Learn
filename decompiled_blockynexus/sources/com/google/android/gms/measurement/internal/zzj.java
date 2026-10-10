package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzj implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzw zza;
    private final /* synthetic */ zzaq zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzw zzwVar, zzaq zzaqVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzwVar;
        this.zzb = zzaqVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzv().zza(this.zza, this.zzb, this.zzc);
    }
}
