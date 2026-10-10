package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayc {
    private final Object lock;
    private volatile int zzdzi;
    private volatile long zzdzj;

    private zzayc() {
        this.lock = new Object();
        this.zzdzi = zzayf.zzdzu;
        this.zzdzj = 0L;
    }

    public final void zzwp() {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzdzi == zzayf.zzdzw) {
                if (this.zzdzj + ((Long) zzwm.zzpx().zzd(zzabb.zzcvx)).longValue() <= jCurrentTimeMillis) {
                    this.zzdzi = zzayf.zzdzu;
                }
            }
        }
        long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzdzi != 2) {
                return;
            }
            this.zzdzi = 3;
            if (this.zzdzi == zzayf.zzdzw) {
                this.zzdzj = jCurrentTimeMillis2;
            }
        }
    }

    /* synthetic */ zzayc(zzayd zzaydVar) {
        this();
    }
}
