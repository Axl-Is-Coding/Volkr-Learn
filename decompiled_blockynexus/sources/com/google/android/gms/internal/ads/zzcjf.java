package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcjf implements Runnable {
    private final zzbgj zzeqk;

    private zzcjf(zzbgj zzbgjVar) {
        this.zzeqk = zzbgjVar;
    }

    static Runnable zzh(zzbgj zzbgjVar) {
        return new zzcjf(zzbgjVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeqk.destroy();
    }
}
