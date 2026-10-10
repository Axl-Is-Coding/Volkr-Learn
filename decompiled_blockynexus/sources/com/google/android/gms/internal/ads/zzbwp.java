package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbwp implements Runnable {
    private final WeakReference<zzbwk> zzfvb;

    private zzbwp(zzbwk zzbwkVar) {
        this.zzfvb = new WeakReference<>(zzbwkVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbwk zzbwkVar = this.zzfvb.get();
        if (zzbwkVar != null) {
            zzbwkVar.zzaka();
        }
    }
}
