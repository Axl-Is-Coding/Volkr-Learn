package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbco {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzbcr(view, onGlobalLayoutListener).attach();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzbcq(view, onScrollChangedListener).attach();
    }
}
