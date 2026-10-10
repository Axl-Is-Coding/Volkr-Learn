package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzil implements Runnable {
    private final /* synthetic */ zzij zzajd;
    private final /* synthetic */ String zzajg;
    private final /* synthetic */ long zzajh;
    private final /* synthetic */ long zzaji;

    zzil(zzij zzijVar, String str, long j, long j2) {
        this.zzajd = zzijVar;
        this.zzajg = str;
        this.zzajh = j;
        this.zzaji = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajd.zzaje.zza(this.zzajg, this.zzajh, this.zzaji);
    }
}
