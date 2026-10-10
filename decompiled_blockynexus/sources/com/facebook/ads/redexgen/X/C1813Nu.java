package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1813Nu extends AnimatorListenerAdapter {
    public final /* synthetic */ C1880Qj A00;
    public final /* synthetic */ boolean A01;

    public C1813Nu(C1880Qj c1880Qj, boolean z) {
        this.A00 = c1880Qj;
        this.A01 = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0F.setTranslationY(WheelView.DividerConfig.FILL);
        this.A00.A0H();
        if (this.A01 || this.A00.A0D == null) {
            return;
        }
        this.A00.A0D.destroy();
    }
}
