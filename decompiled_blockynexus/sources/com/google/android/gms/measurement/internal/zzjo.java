package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjo implements Runnable {
    private final /* synthetic */ zzjl zza;

    zzjo(zzjl zzjlVar) {
        this.zza = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzir.zza(this.zza.zza, (zzei) null);
        this.zza.zza.zzam();
    }
}
