package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1798Nf extends NT {
    public static final int A04 = (int) (LX.A01 * 12.0f);
    public static final int A05 = (int) (LX.A01 * 16.0f);
    public int A00;
    public boolean A01;
    public boolean A02;
    public final C1800Nh A03;

    public C1798Nf(C2026Wb c2026Wb, int i, C1G c1g, J5 j5, InterfaceC1767Lz interfaceC1767Lz, boolean z, boolean z2, C1849Pe c1849Pe, LQ lq, boolean z3) {
        super(c2026Wb, i, c1g, EnumC1836Or.A04.A02(), j5, interfaceC1767Lz, c1849Pe, lq);
        this.A02 = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, 0, A04, 0);
        if (z2) {
            this.A04.setVisibility(8);
        }
        this.A00 = LX.A03(c2026Wb);
        this.A01 = z3;
        boolean z4 = (this.A00 == 2) && this.A01;
        this.A03 = new C1800Nh(c2026Wb, c1g, true, z4 || z, true);
        this.A03.setUseNewLandscapeEndCard(this.A01);
        this.A03.setAlignment(8388611);
        if (C1693Iy.A1N(super.A02)) {
            this.A03.setDescriptionVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.A04.getId());
        if (!this.A01) {
            layoutParams.addRule(15);
            layoutParams2.addRule(15);
        }
        super.A01.addView(this.A04, layoutParams);
        super.A01.addView(this.A03, layoutParams2);
        if (z4) {
            addView(super.A01, new LinearLayout.LayoutParams(-2, -1, 0.7f));
            return;
        }
        addView(super.A01, new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(WheelView.DividerConfig.FILL);
        LX.A0W(this, gradientDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A0D(int i) {
        LinearLayout.LayoutParams layoutParams;
        LX.A0M(super.A03);
        int i2 = 1;
        boolean z = i == 1;
        boolean isPortrait = this.A01;
        if (isPortrait) {
            this.A00 = i;
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            boolean isPortrait2 = this.A02;
            if (isPortrait2 && !z) {
                layoutParams2.weight = 0.7f;
                setBackgroundResource(0);
                LX.A0P(this, -447721392);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
                gradientDrawable.setCornerRadius(WheelView.DividerConfig.FILL);
                LX.A0W(this, gradientDrawable);
            }
            super.A01.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, A05, 0, 0);
            bringToFront();
        } else {
            if (!z) {
                i2 = 0;
            }
            setOrientation(i2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -1 : 0, -2);
            layoutParams3.weight = 1.0f;
            super.A01.setLayoutParams(layoutParams3);
            layoutParams = new LinearLayout.LayoutParams(z ? -1 : -2, -2);
            layoutParams.setMargins(z ? 0 : A05, z ? A05 : 0, 0, 0);
        }
        layoutParams.gravity = 80;
        addView(super.A03, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A0E(boolean z) {
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public void setInfo(C1F c1f, C1H c1h, String str, String str2, @Nullable NW nw) {
        super.setInfo(c1f, c1h, str, str2, nw);
        this.A03.A02(c1f.A06(), c1f.A05(), null, false, false);
        if (TextUtils.isEmpty(c1h.A03())) {
            LX.A0K(super.A03);
        }
    }
}
