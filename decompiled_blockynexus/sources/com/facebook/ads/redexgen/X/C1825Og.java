package com.facebook.ads.redexgen.X;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Og, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1825Og extends LinearLayout {
    public static final int A00 = (int) (LX.A01 * 32.0f);
    public static final int A01 = (int) (LX.A01 * 8.0f);

    public C1825Og(C2026Wb c2026Wb, NativeAd nativeAd, JS js, C1794Nb c1794Nb, AdOptionsView adOptionsView) {
        super(c2026Wb);
        setOrientation(0);
        c1794Nb.setFullCircleCorners(true);
        int i = A00;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, A01, 0);
        addView(c1794Nb, layoutParams);
        TextView textView = new TextView(c2026Wb);
        js.A08(textView);
        textView.setMaxLines(1);
        textView.setText(nativeAd.getAdvertiserName());
        TextView textView2 = new TextView(c2026Wb);
        js.A06(textView2);
        textView2.setMaxLines(1);
        textView2.setText(nativeAd.getSponsoredTranslation());
        LinearLayout linearLayout = new LinearLayout(c2026Wb);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout, layoutParams2);
        addView(adOptionsView, new LinearLayout.LayoutParams(-2, -2));
    }
}
