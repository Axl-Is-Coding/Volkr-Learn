package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzql implements Runnable {
    private final /* synthetic */ zzjl zzajj;
    private final /* synthetic */ zzqg zzbmx;

    zzql(zzqg zzqgVar, zzjl zzjlVar) {
        this.zzbmx = zzqgVar;
        this.zzajj = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajj.zzgn();
        this.zzbmx.zzbmy.zzf(this.zzajj);
    }
}
