package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcuy implements Runnable {
    private final zzckj zzgnx;

    private zzcuy(zzckj zzckjVar) {
        this.zzgnx = zzckjVar;
    }

    static Runnable zza(zzckj zzckjVar) {
        return new zzcuy(zzckjVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgnx.zzaoc();
    }
}
