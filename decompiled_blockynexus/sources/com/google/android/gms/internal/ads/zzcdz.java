package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcdz implements Runnable {
    private final zzceq zzfzf;

    private zzcdz(zzceq zzceqVar) {
        this.zzfzf = zzceqVar;
    }

    static Runnable zza(zzceq zzceqVar) {
        return new zzcdz(zzceqVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfzf.zzalr();
    }
}
