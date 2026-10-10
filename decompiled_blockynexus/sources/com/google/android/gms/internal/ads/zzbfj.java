package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfj implements Runnable {
    private final /* synthetic */ zzbfg zzelm;

    zzbfj(zzbfg zzbfgVar) {
        this.zzelm = zzbfgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzp.zzln().zzb(this.zzelm);
    }
}
