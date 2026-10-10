package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MQ extends LinearLayout implements InterfaceC1824Of {
    public final NativeBannerAd A00;
    public final C2026Wb A01;
    public final ArrayList<View> A02;
    public static final int A04 = (int) (LX.A01 * 42.0f);
    public static final int A03 = (int) (LX.A01 * 48.0f);
    public static final int A05 = (int) (LX.A01 * 54.0f);
    public static final int A07 = (int) (LX.A01 * 4.0f);
    public static final int A06 = (int) (LX.A01 * 8.0f);

    public MQ(C2026Wb c2026Wb, NativeBannerAd nativeBannerAd, JS js, JT jt, MediaView mediaView, AdOptionsView adOptionsView) {
        LinearLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        super(c2026Wb);
        this.A02 = new ArrayList<>();
        this.A00 = nativeBannerAd;
        this.A01 = c2026Wb;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int iA00 = A00(jt);
        C1795Nc c1795Nc = new C1795Nc(this.A01);
        c1795Nc.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA00, iA00);
        layoutParams3.gravity = 16;
        c1795Nc.addView(mediaView, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(c1795Nc, layoutParams3);
        C1821Oc c1821Oc = new C1821Oc(c2026Wb, this.A00, jt, js, adOptionsView);
        c1821Oc.setPadding(A06, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        linearLayout.addView(c1821Oc, layoutParams4);
        if (jt == JT.A0A) {
            int i = A07;
            setPadding(i, i, i, i);
            setOrientation(0);
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            linearLayout.setPadding(0, 0, A07, 0);
        } else {
            int i2 = A06;
            setPadding(i2, i2, i2, i2);
            setOrientation(1);
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setPadding(0, 0, 0, A06);
        }
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        int iconSize = A06;
        int i3 = A07;
        textView.setPadding(iconSize, i3, iconSize, i3);
        js.A05(textView);
        textView.setText(this.A00.getAdCallToAction());
        addView(textView, layoutParams2);
        this.A02.add(mediaView);
        this.A02.add(textView);
    }

    public static int A00(JT jt) {
        int i = C1822Od.A00[jt.ordinal()];
        if (i == 1) {
            return A04;
        }
        if (i != 2) {
            return A05;
        }
        return A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1824Of
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1824Of
    public ArrayList<View> getViewsForInteraction() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1824Of
    public final void unregisterView() {
        this.A00.unregisterView();
    }
}
