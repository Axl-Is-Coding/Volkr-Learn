package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcw implements Runnable {
    private final /* synthetic */ zzbcs zzefy;
    private final /* synthetic */ String zzega;
    private final /* synthetic */ String zzegb;

    zzbcw(zzbcs zzbcsVar, String str, String str2) {
        this.zzefy = zzbcsVar;
        this.zzega = str;
        this.zzegb = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzefy.zzefw != null) {
            this.zzefy.zzefw.zzm(this.zzega, this.zzegb);
        }
    }
}
