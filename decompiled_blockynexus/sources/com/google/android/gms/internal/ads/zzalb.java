package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzalb implements Runnable {
    private final zzaki zzdhp;

    private zzalb(zzaki zzakiVar) {
        this.zzdhp = zzakiVar;
    }

    static Runnable zzb(zzaki zzakiVar) {
        return new zzalb(zzakiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhp.destroy();
    }
}
