package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfb implements Runnable {
    private final /* synthetic */ zzex zzzk;

    zzfb(zzex zzexVar) {
        this.zzzk = zzexVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzabb.initialize(this.zzzk.zzvr);
    }
}
