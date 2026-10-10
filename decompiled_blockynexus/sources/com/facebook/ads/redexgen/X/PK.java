package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class PK implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ GW A01;

    public PK(GW gw, View view) {
        this.A01 = gw;
        this.A00 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.A00.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
