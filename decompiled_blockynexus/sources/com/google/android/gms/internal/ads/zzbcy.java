package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcy implements Runnable {
    private final /* synthetic */ zzbcs zzefy;
    private final /* synthetic */ int zzegc;
    private final /* synthetic */ int zzegd;

    zzbcy(zzbcs zzbcsVar, int i, int i2) {
        this.zzefy = zzbcsVar;
        this.zzegc = i;
        this.zzegd = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzefy.zzefw != null) {
            this.zzefy.zzefw.zzk(this.zzegc, this.zzegd);
        }
    }
}
