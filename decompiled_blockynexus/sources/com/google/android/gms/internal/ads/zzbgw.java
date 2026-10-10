package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgw implements Runnable {
    private final /* synthetic */ zzbgu zzeoi;

    zzbgw(zzbgu zzbguVar) {
        this.zzeoi = zzbguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeoi.zzeof.destroy();
    }
}
