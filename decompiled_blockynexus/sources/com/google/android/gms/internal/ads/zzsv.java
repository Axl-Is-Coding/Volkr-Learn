package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzsv implements Runnable {
    private final /* synthetic */ zzsw zzbuz;

    zzsv(zzsw zzswVar) {
        this.zzbuz = zzswVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbuz.disconnect();
    }
}
