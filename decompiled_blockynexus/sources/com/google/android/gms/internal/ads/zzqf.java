package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqf implements Runnable {
    private final /* synthetic */ zzjl zzajc;
    private final /* synthetic */ zzqg zzbmx;

    zzqf(zzqg zzqgVar, zzjl zzjlVar) {
        this.zzbmx = zzqgVar;
        this.zzajc = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zze(this.zzajc);
    }
}
