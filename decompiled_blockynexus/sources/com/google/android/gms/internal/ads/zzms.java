package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzms implements Runnable {
    private final /* synthetic */ zzmn zzbek;
    private final /* synthetic */ zzmt zzbem;

    zzms(zzmn zzmnVar, zzmt zzmtVar) {
        this.zzbek = zzmnVar;
        this.zzbem = zzmtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbem.release();
        int size = this.zzbek.zzbdu.size();
        for (int i = 0; i < size; i++) {
            ((zznh) this.zzbek.zzbdu.valueAt(i)).disable();
        }
    }
}
