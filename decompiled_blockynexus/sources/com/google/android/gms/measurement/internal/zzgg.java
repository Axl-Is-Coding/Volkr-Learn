package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    zzgg(zzfz zzfzVar, zzn zznVar) {
        this.zzb = zzfzVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zza(this.zza);
    }
}
