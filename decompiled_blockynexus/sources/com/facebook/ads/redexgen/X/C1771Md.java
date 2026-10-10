package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1771Md extends LinearLayout {
    public boolean A00;
    public final ImageView A01;
    public final TextView A02;
    public static final int A04 = (int) (LX.A01 * 16.0f);
    public static final int A05 = (int) (LX.A01 * 12.0f);
    public static final int A06 = (int) (LX.A01 * 12.0f);
    public static final int A03 = (int) (LX.A01 * 16.0f);

    public C1771Md(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = false;
        setOrientation(0);
        int i = A04;
        int i2 = A05;
        setPadding(i, i2, i, i2);
        this.A01 = new ImageView(getContext());
        int i3 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        this.A02 = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        addView(this.A01, layoutParams);
        addView(this.A02, layoutParams2);
        A00();
    }

    private void A00() {
        int textColor;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.A00 ? -13272859 : -1315344);
        gradientDrawable.setCornerRadius(50.0f);
        LX.A0W(this, gradientDrawable);
        LX.A0b(this.A02, false, 14);
        if (this.A00) {
            textColor = -1;
        } else {
            textColor = -10459280;
        }
        this.A02.setTextColor(textColor);
        this.A01.setColorFilter(textColor);
    }

    public final void A01() {
        setSelected(!this.A00);
    }

    public void setData(String str, @Nullable EnumC1747Lf enumC1747Lf) {
        this.A02.setText(str);
        if (enumC1747Lf != null) {
            this.A01.setImageBitmap(C1748Lg.A01(enumC1747Lf));
            this.A01.setVisibility(0);
            this.A02.setPadding(A06, 0, 0, 0);
        } else {
            this.A01.setVisibility(8);
            this.A02.setPadding(0, 0, 0, 0);
        }
        A00();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.A00 = z;
        A00();
    }
}
