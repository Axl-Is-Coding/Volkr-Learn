package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbaw {
    private long zzedf;
    private long zzedg = Long.MIN_VALUE;
    private final Object lock = new Object();

    public zzbaw(long j) {
        this.zzedf = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
            if (this.zzedg + this.zzedf > jElapsedRealtime) {
                return false;
            }
            this.zzedg = jElapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzedf = j;
        }
    }
}
