package com.facebook.ads.redexgen.X;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1851Pg extends KT {
    public final /* synthetic */ OD A00;
    public final /* synthetic */ OE A01;

    public C1851Pg(OE oe, OD od) {
        this.A01 = oe;
        this.A00 = od;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, WheelView.DividerConfig.FILL);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new QP(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
