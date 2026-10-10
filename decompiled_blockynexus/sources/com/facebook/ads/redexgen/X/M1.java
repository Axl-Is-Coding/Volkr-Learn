package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M1 extends AdNativeComponentView {
    public static String[] A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public final LinearLayout A00;
    public final RelativeLayout A01;
    public final RelativeLayout A02;
    public final TextView A03;
    public final TextView A04;
    public final TextView A05;
    public final JS A06;
    public final C2064Xn A07;

    public static void A0E() {
        A08 = new String[]{"uC9D5qmNt6hBQ30WTqHbWjXyd7i1Eya7", "gODvKHA4maP1ueedVTfLSKuHicNhKgsI", "CsSG52h0mPiGpGKpZqt1sL51qY2PgKJk", "t8ZdPgNdDyW7PJ5OFmmKGTW0QKkF2iLl", "957CjoSzFmlmvQzAWdXFvCjH6Z48RGY7", "Wj5TDMvsQRhldaVPvD6nNpKwpdYrUsC9", "EcmINfrxIVIGvxUX8", "04S0zAGn7nkSUB63PmP3o85Q9zROVkT0"};
    }

    static {
        A0E();
        A09 = ((int) LX.A01) * 500;
        A0H = (int) (LX.A01 * 500.0f);
        A0D = (int) (LX.A01 * 4.0f);
        A0B = (int) (LX.A01 * 8.0f);
        A0G = (int) (LX.A01 * 8.0f);
        A0E = (int) (LX.A01 * 4.0f);
        A0C = (int) LX.A01;
        A0F = (int) (LX.A01 * 4.0f);
        A0A = (int) (((double) LX.A01) * 0.5d);
    }

    public M1(C2026Wb c2026Wb, JS js) {
        super(c2026Wb);
        this.A06 = js;
        this.A05 = new TextView(c2026Wb);
        this.A04 = new TextView(c2026Wb);
        this.A03 = new TextView(c2026Wb);
        this.A02 = new RelativeLayout(c2026Wb);
        this.A00 = new LinearLayout(c2026Wb);
        this.A01 = new RelativeLayout(c2026Wb);
        this.A07 = new C2064Xn(c2026Wb);
        A09();
        A0D();
        A05();
        A0A();
        A00();
        A0B();
        A03();
        A0A();
        A08();
        A0C();
    }

    private void A00() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 1;
        this.A00.addView(this.A01, layoutParams);
    }

    private void A01() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A04.getId());
        LX.A0M(this.A03);
        this.A02.addView(this.A03, layoutParams);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -2);
        this.A02.setBackgroundDrawable(null);
        RelativeLayout relativeLayout = this.A02;
        int i = A0G;
        relativeLayout.setPadding(i, i, i, i);
        LX.A0M(this.A02);
        this.A00.addView(this.A02, params);
    }

    private void A02() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A0B;
        int i2 = A0D;
        layoutParams.setMargins(i, i2, i, i2);
        LX.A0M(this.A03);
        this.A00.addView(this.A03, layoutParams);
    }

    private void A03() {
        this.A01.addView(this.A07, new LinearLayout.LayoutParams(-2, -1));
    }

    private void A04() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, this.A07.getId());
        layoutParams.addRule(5, this.A07.getId());
        layoutParams.addRule(7, this.A07.getId());
        RelativeLayout relativeLayout = this.A02;
        int i = A0G;
        relativeLayout.setPadding(i, 0, i, 0);
        this.A02.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-872415232, 0}));
        LX.A0M(this.A02);
        this.A01.addView(this.A02, layoutParams);
    }

    private void A05() {
        addView(this.A00, new LinearLayout.LayoutParams(-2, -2));
    }

    private void A06() {
        this.A05.setTextColor(-1);
        this.A04.setTextColor(-1);
        this.A03.setTextColor(this.A06.A03());
    }

    private void A07() {
        this.A07.setMaxWidth(A0H);
        this.A05.setTextColor(this.A06.A04(0.2f));
        this.A04.setTextColor(this.A06.A04(0.4f));
        this.A03.setTextColor(this.A06.A03());
        ((LinearLayout.LayoutParams) this.A01.getLayoutParams()).gravity = 1;
    }

    private void A08() {
        TextView textView = this.A03;
        int i = A0C;
        textView.setPadding(i, i, i, i);
        this.A03.setTextSize(14.0f);
        LX.A0N(this.A03);
    }

    private void A09() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.A06.A01());
        gradientDrawable.setCornerRadius(A0F);
        gradientDrawable.setStroke(1, this.A06.A02());
        setBackgroundDrawable(gradientDrawable);
        int i = A0A;
        setPadding(i, i, i, i);
    }

    private void A0A() {
        LX.A0N(this.A01);
    }

    private void A0B() {
        this.A07.setScaleType(ImageView.ScaleType.FIT_XY);
        C2064Xn c2064Xn = this.A07;
        int i = A0F;
        c2064Xn.setRadius(new float[]{i, i, i, i, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL});
        this.A07.setAdjustViewBounds(true);
        L5.A04(this.A07, L5.A0A);
        LX.A0N(this.A07);
    }

    private void A0C() {
        LX.A0N(this.A02);
        this.A05.setTextSize(14.0f);
        LX.A0N(this.A05);
        this.A05.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, A0E);
        this.A02.addView(this.A05, layoutParams);
        this.A04.setTextSize(12.0f);
        LX.A0N(this.A04);
        this.A04.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, this.A05.getId());
        layoutParams2.setMargins(0, 0, 0, A0E);
        this.A02.addView(this.A04, layoutParams2);
    }

    private void A0D() {
        this.A00.setOrientation(1);
        LX.A0N(this.A00);
    }

    @Override // com.facebook.ads.internal.api.AdNativeComponentView
    public View getAdContentsView() {
        return this.A07;
    }

    public ImageView getImageCardView() {
        return this.A07;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    @Override // com.facebook.ads.internal.api.AdNativeComponentView, android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            float r0 = com.facebook.ads.redexgen.X.LX.A01
            int r1 = (int) r0
            android.content.Context r0 = r4.getContext()
            int r0 = com.facebook.ads.redexgen.X.C1693Iy.A0C(r0)
            int r1 = r1 * r0
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            if (r0 >= r1) goto L38
            int r3 = android.view.View.MeasureSpec.getMode(r6)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.M1.A08
            r0 = 3
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L4c
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.M1.A08
            java.lang.String r1 = "15DEnWMwGzueTnQFE8qATib1q5d5oHj9"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "kyJeuSgnvxhO6LbcYzomu9S0GmVFz9Qa"
            r0 = 4
            r2[r0] = r1
            if (r3 != 0) goto L42
        L38:
            r4.A01()
            r4.A07()
        L3e:
            super.onMeasure(r5, r6)
            return
        L42:
            r4.A02()
            r4.A04()
            r4.A06()
            goto L3e
        L4c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M1.onMeasure(int, int):void");
    }

    public void setButtonText(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A03.setVisibility(8);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
        this.A03.setText(spannableString);
    }

    public void setSubtitle(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A04.setVisibility(8);
        }
        this.A04.setText(str);
    }

    public void setTitle(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A05.setVisibility(8);
        }
        this.A05.setText(str);
    }
}
