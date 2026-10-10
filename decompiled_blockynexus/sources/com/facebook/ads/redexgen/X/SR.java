package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SR extends AbstractC1803Nk {
    public static final int A01 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final C1814Nv A00;

    public SR(C1807No c1807No, boolean z) {
        super(c1807No, z);
        this.A00 = new C1814Nv(c1807No.A05(), c1807No.A02());
        this.A00.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC1803Nk.A09, AbstractC1803Nk.A09, AbstractC1803Nk.A09, AbstractC1803Nk.A09);
        getCtaButton().setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(c1807No.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC1803Nk.A09, 0, AbstractC1803Nk.A09, 0);
        frameLayout.addView(this.A00, layoutParams3);
        addView(frameLayout);
        addView(getCtaButton());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0P() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        super.A0a(anonymousClass18, str, d2, bundle);
        if (d2 > 0.0d) {
            this.A00.A00((int) (((double) (A01 - (AbstractC1803Nk.A09 * 2))) / d2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0b() {
        return false;
    }
}
