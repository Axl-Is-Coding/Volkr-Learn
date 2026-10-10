package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqh implements Runnable {
    private final /* synthetic */ zzho zzajf;
    private final /* synthetic */ zzqg zzbmx;

    zzqh(zzqg zzqgVar, zzho zzhoVar) {
        this.zzbmx = zzqgVar;
        this.zzajf = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zzk(this.zzajf);
    }
}
