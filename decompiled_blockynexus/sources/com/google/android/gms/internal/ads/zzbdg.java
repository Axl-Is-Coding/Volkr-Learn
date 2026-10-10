package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzbdg implements Runnable {
    private final zzbdf zzegg;

    private zzbdg(zzbdf zzbdfVar) {
        this.zzegg = zzbdfVar;
    }

    static Runnable zza(zzbdf zzbdfVar) {
        return new zzbdg(zzbdfVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzegg.stop();
    }
}
