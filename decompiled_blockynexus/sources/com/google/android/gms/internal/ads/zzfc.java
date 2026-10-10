package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfc implements Runnable {
    private final /* synthetic */ zzex zzzk;
    private final /* synthetic */ int zzzn;
    private final /* synthetic */ boolean zzzo;

    zzfc(zzex zzexVar, int i, boolean z) {
        this.zzzk = zzexVar;
        this.zzzn = i;
        this.zzzo = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcf.zza zzaVarZzb = this.zzzk.zzb(this.zzzn, this.zzzo);
        this.zzzk.zzzb = zzaVarZzb;
        if (zzex.zza(this.zzzn, zzaVarZzb)) {
            this.zzzk.zza(this.zzzn + 1, this.zzzo);
        }
    }
}
