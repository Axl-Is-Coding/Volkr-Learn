package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmp implements Runnable {
    private final /* synthetic */ zzmn zzbek;

    zzmp(zzmn zzmnVar) {
        this.zzbek = zzmnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbek.zzagi) {
            return;
        }
        this.zzbek.zzbdv.zza(this.zzbek);
    }
}
