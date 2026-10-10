package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzju;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzju {
    private zzjq<AppMeasurementJobService> zza;

    private final zzjq<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzjq<>(this);
        }
        return this.zza;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzju
    public final void zza(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzju
    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzju
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
