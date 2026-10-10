package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmq implements Runnable {
    private final /* synthetic */ zzmn zzbek;

    zzmq(zzmn zzmnVar) {
        this.zzbek = zzmnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbek.zzht();
    }
}
