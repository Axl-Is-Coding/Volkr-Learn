package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdo implements Runnable {
    private final /* synthetic */ zzbdc zzehe;

    zzbdo(zzbdp zzbdpVar, zzbdc zzbdcVar) {
        this.zzehe = zzbdcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzehe.zzzg();
    }
}
