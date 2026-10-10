package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MY extends RelativeLayout {
    public final int A00;
    public final int A01;
    public final C2026Wb A02;
    public final InterfaceC1769Mb A03;
    public final boolean A04;
    public static final int A08 = (int) (LX.A01 * 16.0f);
    public static final int A09 = (int) (LX.A01 * 8.0f);
    public static final int A0C = (int) (LX.A01 * 44.0f);
    public static final int A07 = (int) (LX.A01 * 10.0f);
    public static final int A06 = A08 - A07;
    public static final int A0D = (int) (LX.A01 * 75.0f);
    public static final int A0A = (int) (LX.A01 * 25.0f);
    public static final int A0E = (int) (LX.A01 * 45.0f);
    public static final int A0B = (int) (LX.A01 * 15.0f);
    public static final int A05 = (int) (LX.A01 * 16.0f);

    public MY(MX mx) {
        super(mx.A0C);
        this.A02 = mx.A0C;
        this.A03 = mx.A02;
        this.A01 = mx.A0B ? A0D : A0E;
        this.A00 = mx.A0B ? A0A : A0B;
        this.A04 = mx.A07;
        setFocusable(true);
        View viewA01 = A01(mx);
        View viewA00 = A00(mx);
        View footerView = getFooterView();
        LX.A0N(viewA01);
        LX.A0N(viewA00);
        LX.A0N(footerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        layoutParams2.addRule(3, viewA01.getId());
        layoutParams2.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        int i = A08;
        layoutParams3.setMargins(i, 0, i, i);
        addView(viewA01, layoutParams);
        addView(viewA00, layoutParams2);
        addView(footerView, layoutParams3);
        footerView.setVisibility(mx.A08 ? 0 : 8);
    }

    public /* synthetic */ MY(MX mx, MV mv) {
        this(mx);
    }

    private View A00(MX mx) {
        ImageView imageView = new ImageView(getContext());
        int i = this.A00;
        imageView.setPadding(i, i, i, i);
        imageView.setImageBitmap(C1748Lg.A01(mx.A01));
        imageView.setColorFilter(-1);
        int i2 = this.A01;
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(mx.A00);
        LX.A0W(imageView, gradientDrawable);
        titleParams.gravity = 17;
        int i3 = A08;
        titleParams.setMargins(i3, 0, i3, i3);
        TextView textView = new TextView(getContext());
        LX.A0b(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(mx.A06);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i4 = A08;
        layoutParams.setMargins(i4, 0, i4, i4);
        TextView textView2 = new TextView(getContext());
        LX.A0b(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(mx.A05);
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int i5 = A08;
        layoutParams2.setMargins(i5, 0, i5, i5);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, titleParams);
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(textView2, layoutParams2);
        if (mx.A09) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(mx.A04)) {
                C1794Nb c1794Nb = new C1794Nb(this.A02);
                int i6 = A0E;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i6, i6);
                layoutParams3.setMargins(0, 0, A09, 0);
                c1794Nb.setFullCircleCorners(true);
                AsyncTaskC2037Wm asyncTaskC2037Wm = new AsyncTaskC2037Wm(c1794Nb, this.A02);
                int i7 = A0E;
                asyncTaskC2037Wm.A06(i7, i7).A08(mx.A04);
                linearLayout2.addView(c1794Nb, layoutParams3);
            }
            C1771Md c1771Md = new C1771Md(this.A02);
            c1771Md.setData(mx.A03, EnumC1747Lf.CHECKMARK);
            c1771Md.setSelected(true);
            LinearLayout.LayoutParams selectedOptionParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout2.addView(c1771Md, selectedOptionParams);
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(MX mx) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        if (mx.A0A) {
            ImageView imageView = new ImageView(getContext());
            int i = A07;
            imageView.setPadding(i, i, i, i);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(C1748Lg.A01(EnumC1747Lf.CROSS));
            imageView.setOnClickListener(new MV(this));
            int i2 = A0C;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            int i3 = A06;
            layoutParams.setMargins(i3, i3, i3, i3);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(C1748Lg.A01(EnumC1747Lf.SETTINGS));
        imageView.setColorFilter(-13272859);
        int i = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        LX.A0b(textView, false, 16);
        textView.setTextColor(-13272859);
        int i2 = A09;
        textView.setPadding(i2, i2, i2, i2);
        textView.setText(AnonymousClass22.A0D(this.A02.A00()));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new MW(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
