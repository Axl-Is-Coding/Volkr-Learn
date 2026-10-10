package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzv implements Runnable {
    private final zzaa zzah;
    private final zzaj zzai;
    private final Runnable zzaj;

    public zzv(zzaa zzaaVar, zzaj zzajVar, Runnable runnable) {
        this.zzah = zzaaVar;
        this.zzai = zzajVar;
        this.zzaj = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzah.isCanceled();
        if (this.zzai.isSuccess()) {
            this.zzah.zza(this.zzai.result);
        } else {
            this.zzah.zzb(this.zzai.zzbt);
        }
        if (this.zzai.zzbu) {
            this.zzah.zzc("intermediate-response");
        } else {
            this.zzah.zzd("done");
        }
        Runnable runnable = this.zzaj;
        if (runnable != null) {
            runnable.run();
        }
    }
}
