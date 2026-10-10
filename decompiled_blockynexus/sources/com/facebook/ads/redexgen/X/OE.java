package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OE extends LinearLayout {

    @Nullable
    public LinearLayout A00;
    public final int A01;
    public final C2026Wb A02;
    public final C1794Nb A03;
    public final C1800Nh A04;
    public static final int A07 = (int) (LX.A01 * 16.0f);
    public static final int A08 = (int) (LX.A01 * 16.0f);
    public static final int A06 = (int) (LX.A01 * 8.0f);
    public static final int A05 = (int) (LX.A01 * 72.0f);

    public OE(OC oc) {
        super(oc.A06);
        this.A02 = oc.A06;
        this.A03 = new C1794Nb(this.A02);
        this.A04 = new C1800Nh(this.A02, oc.A01, true, false, true);
        this.A01 = oc.A00;
        A03(oc);
    }

    public /* synthetic */ OE(OC oc, C1851Pg c1851Pg) {
        this(oc);
    }

    private void A00() {
        A01(this.A03, 150);
        A01(this.A04, 170);
        LinearLayout linearLayout = this.A00;
        if (linearLayout != null) {
            A01(linearLayout, 190);
        }
    }

    private void A01(View view, int i) {
        view.setTranslationY(i);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(OC oc) {
        if (!TextUtils.isEmpty(oc.A03)) {
            this.A00 = new LinearLayout(getContext());
            this.A00.setGravity(17);
            LinearLayout linearLayout = this.A00;
            int i = A08;
            linearLayout.setPadding(i, i / 2, i, i / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, A08 / 2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            LX.A0b(textView, false, 16);
            textView.setText(oc.A03);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getContext());
            new AsyncTaskC2037Wm(imageView, this.A02).A05().A08(oc.A02);
            int i2 = A07;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams3.setMargins(0, 0, A08 / 2, 0);
            this.A00.addView(imageView, layoutParams3);
            this.A00.addView(textView, layoutParams2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(100.0f);
            gradientDrawable.setColor(469762047);
            LX.A0W(this.A00, gradientDrawable);
            addView(this.A00, layoutParams);
        }
    }

    private void A03(OC oc) {
        LX.A0P(this.A03, 0);
        this.A03.setRadius(50);
        if (oc.A04.A00() == C1D.A05) {
            this.A03.setFullCircleCorners(true);
        } else {
            this.A03.setRadius(A06);
        }
        new AsyncTaskC2037Wm(this.A03, this.A02).A05().A08(oc.A05.A01());
        this.A04.A02(oc.A04.A06(), oc.A05.A03(), null, false, true);
        this.A04.getDescriptionTextView().setAlpha(0.8f);
        this.A04.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        layoutParams.setMargins(0, i, 0, i / 2);
        View view = this.A03;
        int i2 = A05;
        addView(view, new LinearLayout.LayoutParams(i2, i2));
        addView(this.A04, layoutParams);
        A02(oc);
        LX.A0P(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(OD od) {
        A00();
        postDelayed(new C1851Pg(this, od), this.A01);
    }
}
