package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzail implements Runnable {
    private final /* synthetic */ zzaik zzdfy;

    zzail(zzaik zzaikVar) {
        this.zzdfy = zzaikVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdfy.disconnect();
    }
}
