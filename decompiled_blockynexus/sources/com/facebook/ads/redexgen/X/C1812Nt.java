package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1812Nt implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C1880Qj A00;

    public C1812Nt(C1880Qj c1880Qj) {
        this.A00 = c1880Qj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.A00.A06.getLayoutParams().height = num.intValue();
        this.A00.A06.requestLayout();
    }
}
