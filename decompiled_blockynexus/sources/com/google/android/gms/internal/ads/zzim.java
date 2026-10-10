package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzim implements Runnable {
    private final /* synthetic */ zzij zzajd;
    private final /* synthetic */ zzjl zzajj;

    zzim(zzij zzijVar, zzjl zzjlVar) {
        this.zzajd = zzijVar;
        this.zzajj = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajj.zzgn();
        this.zzajd.zzaje.zzb(this.zzajj);
    }
}
