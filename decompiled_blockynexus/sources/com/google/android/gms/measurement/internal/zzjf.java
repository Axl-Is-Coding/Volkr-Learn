package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjf implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzir zzb;

    zzjf(zzir zzirVar, zzn zznVar) {
        this.zzb = zzirVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar = this.zzb.zzb;
        if (zzeiVar == null) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to service");
            return;
        }
        try {
            zzeiVar.zze(this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e2) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to the service", e2);
        }
    }
}
