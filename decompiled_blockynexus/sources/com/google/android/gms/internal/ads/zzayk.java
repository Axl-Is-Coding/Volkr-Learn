package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayk implements Runnable {
    private final /* synthetic */ zzayl zzead;

    zzayk(zzayl zzaylVar) {
        this.zzead = zzaylVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzead.thread = Thread.currentThread();
        this.zzead.zzvb();
    }
}
