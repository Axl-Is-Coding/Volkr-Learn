package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqj implements Runnable {
    private final /* synthetic */ zzqg zzbmx;
    private final /* synthetic */ int zzbmz;
    private final /* synthetic */ int zzbna;
    private final /* synthetic */ int zzbnb;
    private final /* synthetic */ float zzbnc;

    zzqj(zzqg zzqgVar, int i, int i2, int i3, float f2) {
        this.zzbmx = zzqgVar;
        this.zzbmz = i;
        this.zzbna = i2;
        this.zzbnb = i3;
        this.zzbnc = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zza(this.zzbmz, this.zzbna, this.zzbnb, this.zzbnc);
    }
}
