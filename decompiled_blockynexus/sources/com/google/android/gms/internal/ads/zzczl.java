package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzczl implements Runnable {
    private final zzczs zzgsz;

    private zzczl(zzczs zzczsVar) {
        this.zzgsz = zzczsVar;
    }

    static Runnable zzb(zzczs zzczsVar) {
        return new zzczl(zzczsVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgsz.onAdLoaded();
    }
}
