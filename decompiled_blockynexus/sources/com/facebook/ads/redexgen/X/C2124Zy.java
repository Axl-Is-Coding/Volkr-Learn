package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2124Zy extends LW {
    public final /* synthetic */ View A00;
    public final /* synthetic */ ScaleAnimation A01;

    public C2124Zy(View view, ScaleAnimation scaleAnimation) {
        this.A00 = view;
        this.A01 = scaleAnimation;
    }

    @Override // com.facebook.ads.redexgen.X.LW, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A00.startAnimation(this.A01);
    }
}
