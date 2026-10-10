package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public class zzazg extends zzazh {
    @Override // com.google.android.gms.internal.ads.zzazh, com.google.android.gms.internal.ads.zzazd
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final ViewGroup.LayoutParams zzxx() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
