package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzip implements Runnable {
    private final /* synthetic */ zzij zzajd;
    private final /* synthetic */ int zzalp;

    zzip(zzij zzijVar, int i) {
        this.zzajd = zzijVar;
        this.zzalp = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajd.zzaje.zzx(this.zzalp);
    }
}
