package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzik implements Runnable {
    private final /* synthetic */ zzij zzajd;
    private final /* synthetic */ zzho zzajf;

    zzik(zzij zzijVar, zzho zzhoVar) {
        this.zzajd = zzijVar;
        this.zzajf = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzajd.zzaje.zzb(this.zzajf);
    }
}
