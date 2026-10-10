package com.facebook.ads.redexgen.X;

import android.widget.LinearLayout;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1796Nd extends LinearLayout {
    public static final int A06 = (int) (LX.A01 * 4.0f);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C2026Wb A04;
    public final C1797Ne[] A05;

    public C1796Nd(C2026Wb c2026Wb, int i, int i2, int i3, int i4) {
        super(c2026Wb);
        this.A00 = A06;
        this.A04 = c2026Wb;
        setOrientation(0);
        this.A03 = i;
        this.A01 = i3;
        this.A02 = i4;
        this.A05 = new C1797Ne[i2];
        for (int i5 = 0; i5 < i2; i5++) {
            this.A05[i5] = A00();
            addView(this.A05[i5]);
        }
        A01();
    }

    private C1797Ne A00() {
        C1797Ne c1797Ne = new C1797Ne(this.A04, this.A01, this.A02);
        int i = this.A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        c1797Ne.setLayoutParams(layoutParams);
        return c1797Ne;
    }

    private void A01() {
        int i = 0;
        while (true) {
            C1797Ne[] c1797NeArr = this.A05;
            if (i < c1797NeArr.length) {
                ((LinearLayout.LayoutParams) c1797NeArr[i].getLayoutParams()).leftMargin = i == 0 ? 0 : this.A00;
                i++;
            } else {
                requestLayout();
                return;
            }
        }
    }

    private void A02(float f2) {
        for (int i = 0; i < this.A05.length; i++) {
            float fMin = Math.min(1.0f, f2 - i);
            if (fMin < WheelView.DividerConfig.FILL) {
                fMin = WheelView.DividerConfig.FILL;
            }
            this.A05[i].setFillRatio(fMin);
        }
    }

    public void setItemSpacing(int i) {
        this.A00 = i;
        A01();
    }

    public void setRating(float f2) {
        A02(f2);
    }
}
