package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class M6 implements Animation.AnimationListener {
    public final /* synthetic */ C13604u A00;
    public final /* synthetic */ ZU A01;
    public final /* synthetic */ ZU A02;

    public M6(ZU zu, ZU zu2, C13604u c13604u) {
        this.A01 = zu;
        this.A02 = zu2;
        this.A00 = c13604u;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        LX.A0K(this.A02);
        new Handler().postDelayed(new ZX(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
