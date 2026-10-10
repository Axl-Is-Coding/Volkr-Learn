package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzayl {
    private volatile Thread thread;
    private final Runnable zzeae = new zzayk(this);
    private boolean zzeaf = false;

    public abstract void zzvb();

    public final zzdzc<?> zzwz() {
        return zzbbz.zzeeq.zzg(this.zzeae);
    }
}
