package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqk implements Runnable {
    private final /* synthetic */ zzqg zzbmx;
    private final /* synthetic */ int zzbnd;
    private final /* synthetic */ long zzbne;

    zzqk(zzqg zzqgVar, int i, long j) {
        this.zzbmx = zzqgVar;
        this.zzbnd = i;
        this.zzbne = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zze(this.zzbnd, this.zzbne);
    }
}
