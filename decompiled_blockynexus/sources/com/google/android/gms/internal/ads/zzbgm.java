package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgm implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawl zzenh;
    private final /* synthetic */ zzbgi zzeni;

    zzbgm(zzbgi zzbgiVar, zzawl zzawlVar) {
        this.zzeni = zzbgiVar;
        this.zzenh = zzawlVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzeni.zza(view, this.zzenh, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
