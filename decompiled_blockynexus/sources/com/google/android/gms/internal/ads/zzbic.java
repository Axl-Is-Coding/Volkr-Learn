package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbic implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawl zzenh;
    private final /* synthetic */ zzbib zzeqq;

    zzbic(zzbib zzbibVar, zzawl zzawlVar) {
        this.zzeqq = zzbibVar;
        this.zzenh = zzawlVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzeqq.zza(view, this.zzenh, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
