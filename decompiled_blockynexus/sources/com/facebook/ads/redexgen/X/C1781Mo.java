package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1781Mo extends LinearLayout {
    public final ImageView A00;
    public final LinearLayout A01;
    public final TextView A02;
    public static final int A05 = (int) (LX.A01 * 8.0f);
    public static final int A06 = (int) (((double) LX.A01) * 14.5d);
    public static final int A04 = (int) (LX.A01 * 20.0f);
    public static final LinearLayout.LayoutParams A03 = new LinearLayout.LayoutParams(-1, -2);

    public C1781Mo(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = new ImageView(c2026Wb);
        this.A00.setColorFilter(-10459280);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        this.A00.setLayoutParams(layoutParams);
        this.A01 = new LinearLayout(c2026Wb);
        this.A01.setOrientation(1);
        this.A01.setPadding(A05 * 2, 0, 0, 0);
        this.A01.setLayoutParams(A03);
        this.A02 = new TextView(c2026Wb);
        LX.A0b(this.A02, true, 16);
        this.A02.setTextColor(-14934495);
        this.A01.addView(this.A02, A03);
        setOrientation(0);
        addView(this.A00);
        addView(this.A01);
    }

    public void setInfo(EnumC1747Lf enumC1747Lf, String str, String str2) {
        this.A00.setImageBitmap(C1748Lg.A01(enumC1747Lf));
        this.A02.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            TextView textView = new TextView(getContext());
            LX.A0b(textView, false, 14);
            textView.setTextColor(-10459280);
            textView.setText(str2);
            this.A01.addView(textView, A03);
            int i = A05;
            setPadding(0, i, 0, i);
            return;
        }
        int i2 = A06;
        setPadding(0, i2, 0, i2);
    }
}
