package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbi extends Thread {
    private final /* synthetic */ String zzecs;

    zzbbi(zzbbj zzbbjVar, String str) {
        this.zzecs = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzbbu().zzes(this.zzecs);
    }
}
