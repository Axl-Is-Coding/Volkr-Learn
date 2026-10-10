package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzii implements Runnable {
    private final /* synthetic */ zzjl zzajc;
    private final /* synthetic */ zzij zzajd;

    zzii(zzij zzijVar, zzjl zzjlVar) {
        this.zzajd = zzijVar;
        this.zzajc = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajd.zzaje.zza(this.zzajc);
    }
}
