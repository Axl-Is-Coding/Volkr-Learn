package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzrj implements Runnable {
    private final /* synthetic */ View zzbtd;
    private final /* synthetic */ zzrk zzbte;

    zzrj(zzrk zzrkVar, View view) {
        this.zzbte = zzrkVar;
        this.zzbtd = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbte.zzj(this.zzbtd);
    }
}
