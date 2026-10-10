package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzp implements Runnable {
    private final /* synthetic */ zzaa zzaa;
    private final /* synthetic */ zzm zzab;

    zzp(zzm zzmVar, zzaa zzaaVar) {
        this.zzab = zzmVar;
        this.zzaa = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzab.zzm.put(this.zzaa);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
