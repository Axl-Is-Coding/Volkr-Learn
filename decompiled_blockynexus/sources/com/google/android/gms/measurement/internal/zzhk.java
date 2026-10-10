package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhb zzb;

    zzhk(zzhb zzhbVar, long j) {
        this.zzb = zzhbVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
        this.zzb.zzg().zza(new AtomicReference<>());
    }
}
