package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.text.NumberFormat;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2028Wd extends NT {
    public static byte[] A0G;
    public static String[] A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public static final int A0L;
    public static final int A0M;
    public static final int A0N;
    public static final int A0O;
    public static final int A0P;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public TextView A03;
    public TextView A04;
    public TextView A05;
    public C1F A06;
    public C1H A07;
    public C1796Nd A08;
    public boolean A09;
    public boolean A0A;
    public final LinearLayout A0B;
    public final RelativeLayout A0C;
    public final RelativeLayout A0D;
    public final TextView A0E;
    public final C2026Wb A0F;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0G = new byte[]{-111, -20};
    }

    public static void A08() {
        A0H = new String[]{"ZYFZvgakVe", "Z9juamcNffZ", "L6NhnuluGVbfOuIZp07EBLc1k7rVfOba", "poGipFcmqzgO1AN9d1VwktKUuwbeuE2x", "1MA0bi3k", "zUZ", "l0mlyabDLiJh1QvHe0VixDkOpEP8aZzg", "KStQaqdBmF0CfboN9Wjc4"};
    }

    static {
        A08();
        A07();
        A0O = C2F.A01(-1, 77);
        A0L = (int) (LX.A01 * 12.0f);
        A0M = (int) (LX.A01 * 8.0f);
        A0I = (int) (LX.A01 * 26.0f);
        A0K = (int) (LX.A01 * 144.0f);
        A0J = (int) (LX.A01 * 48.0f);
        A0N = (int) (LX.A01 * 16.0f);
        A0P = (int) (LX.A01 * 14.0f);
    }

    public C2028Wd(C2026Wb c2026Wb, int i, boolean z, C1G c1g, String str, J5 j5, InterfaceC1767Lz interfaceC1767Lz, C1849Pe c1849Pe, LQ lq) {
        this(c2026Wb, i, z, c1g, str, j5, interfaceC1767Lz, c1849Pe, lq, false);
    }

    public C2028Wd(C2026Wb c2026Wb, int i, boolean z, C1G c1g, String str, J5 j5, InterfaceC1767Lz interfaceC1767Lz, C1849Pe c1849Pe, LQ lq, boolean z2) {
        super(c2026Wb, i, c1g, str, j5, interfaceC1767Lz, c1849Pe, lq);
        this.A0A = false;
        this.A00 = 0;
        this.A01 = 0;
        this.A0F = c2026Wb;
        this.A09 = z2;
        super.A04.setFullCircleCorners(z);
        int i2 = A0L;
        setPadding(i2, i2, i2, A0I);
        this.A0C = new RelativeLayout(getContext());
        this.A05 = new TextView(getContext());
        this.A02 = new LinearLayout(getContext());
        this.A08 = new C1796Nd(this.A0F, A0P, 5, A0O, -1);
        this.A0D = new RelativeLayout(getContext());
        this.A0B = new LinearLayout(getContext());
        this.A04 = new TextView(getContext());
        this.A03 = new TextView(getContext());
        super.A01.addView(this.A0C);
        super.A01.addView(this.A0B);
        this.A0E = new TextView(getContext());
        LX.A0V(this, c2026Wb);
        if (C1693Iy.A1N(c2026Wb)) {
            this.A03.setVisibility(8);
        }
        A05();
    }

    private void A01() {
        super.A03.setPadding(0, 0, 0, 0);
        super.A03.setLayoutParams(new LinearLayout.LayoutParams(-1, A0J));
    }

    private void A02() {
        this.A0B.setOrientation(1);
        this.A0B.setPadding(0, 0, 0, A0L);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A0C.getId());
        this.A0B.setLayoutParams(layoutParams);
        this.A0B.removeAllViews();
        this.A03.setMaxLines(2);
        this.A03.setEllipsize(TextUtils.TruncateAt.END);
        this.A03.setGravity(16);
        this.A03.setTextColor(-1);
        LX.A0b(this.A03, false, 16);
        this.A0B.addView(this.A03, new LinearLayout.LayoutParams(-1, -2));
    }

    private void A03() {
        this.A0C.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = A0L;
        this.A0C.setLayoutParams(layoutParams);
        LX.A0N(this.A0C);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(super.A00, super.A00);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        this.A0C.addView(super.A04, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = A0M;
        layoutParams3.addRule(1, super.A04.getId());
        layoutParams3.addRule(15);
        this.A0C.addView(this.A0D, layoutParams3);
        this.A0D.removeAllViews();
        LX.A0N(this.A05);
        this.A05.setLayoutParams(NT.A06);
        this.A05.setTextColor(-1);
        LX.A0b(this.A05, true, 18);
        this.A0D.addView(this.A05);
        this.A02.setOrientation(0);
        this.A02.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0N);
        layoutParams4.topMargin = A0M / 2;
        layoutParams4.addRule(3, this.A05.getId());
        this.A0D.addView(this.A02, layoutParams4);
        this.A02.removeAllViews();
        this.A08.setGravity(16);
        this.A02.addView(this.A08, new LinearLayout.LayoutParams(-2, -1));
        this.A04.setTextColor(-1);
        this.A04.setGravity(16);
        this.A04.setIncludeFontPadding(false);
        LX.A0b(this.A04, false, 14);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.leftMargin = A0M;
        this.A02.addView(this.A04, layoutParams5);
    }

    private void A04() {
        this.A0E.setMaxLines(1);
        this.A0E.setEllipsize(TextUtils.TruncateAt.END);
        this.A0E.setGravity(17);
        this.A0E.setTextColor(-1);
        this.A0E.setAllCaps(true);
        LX.A0b(this.A0E, false, 12);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = A0L;
        this.A0E.setLayoutParams(layoutParams);
    }

    private void A05() {
        removeAllViews();
        super.A01.setLayoutParams(NT.A06);
        A03();
        A02();
        A01();
        A04();
        A06();
        LX.A0M(super.A01);
        LX.A0M(super.A03);
        LX.A0M(this.A0E);
        addView(super.A01);
        addView(super.A03);
        addView(this.A0E);
    }

    private void A06() {
        C1F c1f = this.A06;
        if (c1f == null) {
            return;
        }
        this.A05.setText(c1f.A06());
        this.A03.setText(this.A06.A01());
        this.A0E.setText(this.A06.A04());
        if (TextUtils.isEmpty(this.A07.A03())) {
            LX.A0K(super.A03);
        }
        if (TextUtils.isEmpty(this.A06.A04())) {
            LX.A0K(this.A0E);
        }
        if (TextUtils.isEmpty(this.A06.A03())) {
            this.A02.setVisibility(8);
            return;
        }
        this.A02.setVisibility(0);
        C1796Nd c1796Nd = this.A08;
        String strA03 = this.A06.A03();
        if (A0H[0].length() == 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0H;
        strArr[2] = "VSVKlO90K15ihGB4A0qZPRqEppX5OU7U";
        strArr[6] = "xs76xd0mQfWREabMq0mbrfEp6FCRmbTD";
        c1796Nd.setRating(Float.parseFloat(strA03));
        if (this.A06.A02() == null) {
            return;
        }
        this.A04.setText(A00(0, 1, 6) + NumberFormat.getNumberInstance().format(Integer.parseInt(this.A06.A02())) + A00(1, 1, 96));
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final int A09(int i) {
        return this.A00 + this.A01 + A0M;
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A0D(int i) {
        int i2 = 1;
        boolean z = i == 1;
        if (this.A09 && this.A0A) {
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            setBackgroundResource(0);
            super.A01.setLayoutParams(layoutParams);
            super.A03.setLayoutParams(new LinearLayout.LayoutParams(-1, A0J));
            if (z) {
                this.A0E.setGravity(1);
            } else {
                layoutParams.weight = 0.7f;
                LX.A0P(this, -1087164882);
                A04();
                this.A0E.setGravity(3);
            }
            LX.A0M(this.A0E);
            addView(this.A0E);
        } else {
            if (!z) {
                i2 = 0;
            }
            setOrientation(i2);
            if (!z) {
                setWeightSum(5.0f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 4.0f;
                layoutParams2.bottomMargin = A0I - A0L;
                super.A01.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, A0J);
                layoutParams3.bottomMargin = A0I / 2;
                layoutParams3.weight = 1.0f;
                layoutParams3.gravity = 80;
                super.A03.setLayoutParams(layoutParams3);
                super.A03.setMinWidth(A0K);
                LX.A0M(this.A0E);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams4.topMargin = 0;
                layoutParams4.bottomMargin = A0M;
                this.A0B.addView(this.A0E, layoutParams4);
                this.A0B.setPadding(0, 0, 0, 0);
                this.A0E.setGravity(3);
            } else {
                A05();
            }
        }
        bringToFront();
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A0E(boolean z) {
        this.A0A = z;
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final View getExpandableLayout() {
        return this.A0B;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.A00 == 0) {
            this.A00 = this.A03.getHeight();
            this.A01 = this.A0E.getHeight();
        }
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public void setInfo(C1F c1f, C1H c1h, String str, String str2, @Nullable NW nw) {
        super.setInfo(c1f, c1h, str, str2, nw);
        this.A06 = c1f;
        this.A07 = c1h;
        A06();
    }
}
