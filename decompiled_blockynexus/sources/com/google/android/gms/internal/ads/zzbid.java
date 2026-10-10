package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbid implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawl zzenh;
    private final /* synthetic */ int zzenj;
    private final /* synthetic */ zzbib zzeqq;

    zzbid(zzbib zzbibVar, View view, zzawl zzawlVar, int i) {
        this.zzeqq = zzbibVar;
        this.val$view = view;
        this.zzenh = zzawlVar;
        this.zzenj = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeqq.zza(this.val$view, this.zzenh, this.zzenj - 1);
    }
}
