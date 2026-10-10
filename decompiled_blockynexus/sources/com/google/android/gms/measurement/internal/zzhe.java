package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhe implements Runnable {
    private final /* synthetic */ zzhb zza;

    zzhe(zzhb zzhbVar) {
        this.zza = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
