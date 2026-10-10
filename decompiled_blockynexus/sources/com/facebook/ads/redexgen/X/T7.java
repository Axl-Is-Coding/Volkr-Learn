package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T7 implements C5C {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ C5E A01;
    public final /* synthetic */ C2213bT A02;

    public T7(C5E c5e, ImageView imageView, C2213bT c2213bT) {
        this.A01 = c5e;
        this.A00 = imageView;
        this.A02 = c2213bT;
    }

    @Override // com.facebook.ads.redexgen.X.C5C
    public final void AA0(@Nullable Drawable drawable) {
        C2213bT.A0a(drawable, this.A00);
        this.A02.A1D(drawable);
    }
}
