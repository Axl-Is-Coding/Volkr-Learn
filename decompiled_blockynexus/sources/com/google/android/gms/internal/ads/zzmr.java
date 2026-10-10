package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmr implements Runnable {
    private final /* synthetic */ zzmn zzbek;
    private final /* synthetic */ IOException zzbel;

    zzmr(zzmn zzmnVar, IOException iOException) {
        this.zzbek = zzmnVar;
        this.zzbel = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbek.zzbdk.zzb(this.zzbel);
    }
}
