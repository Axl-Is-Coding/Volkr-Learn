package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfh implements Runnable {
    private final /* synthetic */ zzfi zzaag;

    zzfh(zzfi zzfiVar) {
        this.zzaag = zzfiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaag.zzcv();
    }
}
