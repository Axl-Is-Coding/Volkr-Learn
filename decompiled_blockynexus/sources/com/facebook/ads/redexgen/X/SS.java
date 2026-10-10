package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SS extends AbstractC1803Nk {
    public SS(C1807No c1807No, boolean z) {
        super(c1807No, true);
        RelativeLayout relativeLayout = new RelativeLayout(c1807No.A05());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        LX.A0V(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(c1807No.A05());
        linearLayout.setOrientation(!z ? 1 : 0);
        linearLayout.setGravity(80);
        LX.A0N(linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(AbstractC1803Nk.A09, 0, AbstractC1803Nk.A09, AbstractC1803Nk.A09);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -2 : -1, -2);
        layoutParams3.setMargins(z ? AbstractC1803Nk.A09 : 0, z ? 0 : AbstractC1803Nk.A09, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        addView(c1807No.A02(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        super.A0a(anonymousClass18, str, d2, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0b() {
        return true;
    }
}
