package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcu implements Runnable {
    private final /* synthetic */ zzbcs zzefy;

    zzbcu(zzbcs zzbcsVar) {
        this.zzefy = zzbcsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzefy.zzefw != null) {
            this.zzefy.zzefw.zzfb();
        }
    }
}
