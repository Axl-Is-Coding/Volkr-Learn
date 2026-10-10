package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzio implements Runnable {
    private final /* synthetic */ zzii zza;

    zzio(zzii zziiVar) {
        this.zza = zziiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzii.zza(this.zza, (zzij) null);
    }
}
