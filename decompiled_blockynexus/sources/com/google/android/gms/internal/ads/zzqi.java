package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqi implements Runnable {
    private final /* synthetic */ String zzajg;
    private final /* synthetic */ long zzajh;
    private final /* synthetic */ long zzaji;
    private final /* synthetic */ zzqg zzbmx;

    zzqi(zzqg zzqgVar, String str, long j, long j2) {
        this.zzbmx = zzqgVar;
        this.zzajg = str;
        this.zzajh = j;
        this.zzaji = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zzd(this.zzajg, this.zzajh, this.zzaji);
    }
}
