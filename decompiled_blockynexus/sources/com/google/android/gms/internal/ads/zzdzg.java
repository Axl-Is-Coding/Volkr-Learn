package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzg implements Runnable {
    private final /* synthetic */ Runnable zzhtp;
    private final /* synthetic */ zzdzd zzhtq;

    zzdzg(zzdzd zzdzdVar, Runnable runnable) {
        this.zzhtq = zzdzdVar;
        this.zzhtp = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhtq.zzhtl = false;
        this.zzhtp.run();
    }

    public final String toString() {
        return this.zzhtp.toString();
    }
}
