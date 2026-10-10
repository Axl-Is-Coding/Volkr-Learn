package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhu implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzhb zzb;

    zzhu(zzhb zzhbVar, Boolean bool) {
        this.zzb = zzhbVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
