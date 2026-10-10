package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgn implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawl zzenh;
    private final /* synthetic */ zzbgi zzeni;
    private final /* synthetic */ int zzenj;

    zzbgn(zzbgi zzbgiVar, View view, zzawl zzawlVar, int i) {
        this.zzeni = zzbgiVar;
        this.val$view = view;
        this.zzenh = zzawlVar;
        this.zzenj = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeni.zza(this.val$view, this.zzenh, this.zzenj - 1);
    }
}
