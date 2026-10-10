package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class QP extends LW {
    public final /* synthetic */ C1851Pg A00;

    public QP(C1851Pg c1851Pg) {
        this.A00 = c1851Pg;
    }

    @Override // com.facebook.ads.redexgen.X.LW, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        LX.A0K(this.A00.A01);
        this.A00.A00.AAC();
    }
}
