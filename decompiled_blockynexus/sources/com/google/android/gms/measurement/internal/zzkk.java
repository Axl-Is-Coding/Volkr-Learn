package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkk implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzkl zzb;

    zzkk(zzkl zzklVar, zzks zzksVar) {
        this.zzb = zzklVar;
        this.zza = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
