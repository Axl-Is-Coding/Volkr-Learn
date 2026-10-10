package com.facebook.ads.redexgen.X;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O2 {
    public static AbstractC1878Qh A00(final C1807No c1807No, int i, final String str, final C1838Ot c1838Ot) {
        if (i == 1) {
            return new AbstractC1878Qh(c1807No, str, c1838Ot) { // from class: com.facebook.ads.redexgen.X.8j
                public static final int A00 = (int) (LX.A01 * 20.0f);
                public static final int A01 = (int) (LX.A01 * 16.0f);

                @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
                public final boolean A0O() {
                    return false;
                }

                @Override // com.facebook.ads.redexgen.X.AbstractC1878Qh
                public final void A0g(C2026Wb c2026Wb) {
                    C1800Nh titleDescContainer = getTitleDescContainer();
                    titleDescContainer.setAlignment(3);
                    titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    titleDescContainer.setPadding(0, 0, 0, A00);
                    getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout = new LinearLayout(c2026Wb);
                    LX.A0W(linearLayout, new ColorDrawable(-1));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(3, getMediaContainer().getId());
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    int i2 = A01;
                    linearLayout.setPadding(i2, i2, i2, i2);
                    linearLayout.addView(titleDescContainer);
                    linearLayout.addView(getCtaButton());
                    addView(getMediaContainer());
                    addView(linearLayout);
                }
            };
        }
        return new AbstractC1878Qh(c1807No, str, c1838Ot) { // from class: com.facebook.ads.redexgen.X.9L
            public static final int A00 = (int) (LX.A01 * 12.0f);

            @Override // com.facebook.ads.redexgen.X.AbstractC1878Qh, com.facebook.ads.redexgen.X.AbstractC1803Nk
            public final boolean A0M() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
            public final boolean A0N() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1878Qh
            public final void A0g(C2026Wb c2026Wb) {
                C1800Nh titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(8, getMediaContainer().getId());
                titleDescContainer.setLayoutParams(layoutParams);
                int i2 = A00;
                titleDescContainer.setPadding(i2, i2, i2, i2);
                LX.A0V(titleDescContainer, getAdContextWrapper());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, getMediaContainer().getId());
                getCtaButton().setLayoutParams(layoutParams2);
                addView(getMediaContainer());
                addView(titleDescContainer);
                addView(getCtaButton());
            }
        };
    }
}
