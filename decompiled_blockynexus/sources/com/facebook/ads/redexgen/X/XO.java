package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XO extends MZ {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C2026Wb A03;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A04 = new byte[]{53, 22, 20, 28, 105, 70, 69, 89, 79, 10, 107, 78, 10, 120, 79, 90, 69, 88, 94, 67, 68, 77};
    }

    static {
        A0B();
        A07 = (int) (LX.A01 * 8.0f);
        A06 = (int) (LX.A01 * 10.0f);
        A05 = (int) (LX.A01 * 44.0f);
    }

    public XO(C2026Wb c2026Wb, J5 j5, String str) {
        super(c2026Wb, j5, str);
        this.A03 = c2026Wb;
        this.A00 = new ImageView(getContext());
        ImageView imageView = this.A00;
        int i = A06;
        imageView.setPadding(i, i, i, i);
        this.A00.setColorFilter(-10459280);
        int i2 = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        LX.A0P(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        LinearLayout linearLayout = this.A01;
        int i3 = A07;
        linearLayout.setPadding(i3, i3, i3, i3);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0K() {
        this.A00.setImageBitmap(C1748Lg.A01(EnumC1747Lf.CROSS));
        this.A00.setOnClickListener(new ViewOnClickListenerC1785Ms(this));
        this.A00.setContentDescription(A0A(4, 18, 29));
        C1771Md c1771Md = new C1771Md(this.A03);
        c1771Md.setData(AnonymousClass22.A0B(this.A03.A00()), EnumC1747Lf.HIDE_AD);
        c1771Md.setOnClickListener(new ViewOnClickListenerC1786Mt(this, c1771Md));
        C1771Md c1771Md2 = new C1771Md(this.A03);
        c1771Md2.setData(AnonymousClass22.A0F(this.A03.A00()), EnumC1747Lf.REPORT_AD);
        c1771Md2.setOnClickListener(new ViewOnClickListenerC1787Mu(this, c1771Md2));
        C1771Md c1771Md3 = new C1771Md(this.A03);
        c1771Md3.setData(AnonymousClass22.A0G(this.A03.A00()), EnumC1747Lf.AD_CHOICES_ICON);
        c1771Md3.setOnClickListener(new ViewOnClickListenerC1788Mv(this, c1771Md3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A07;
        layoutParams.setMargins(i, i, i, i);
        layoutParams.gravity = 17;
        LinearLayout menuLayout = new LinearLayout(getContext());
        menuLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        LX.A0X(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(menuLayout, layoutParams2);
        menuLayout.addView(c1771Md, layoutParams);
        menuLayout.addView(c1771Md2, layoutParams);
        menuLayout.addView(c1771Md3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        LX.A0L(this);
        LX.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0M(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        String strA0B;
        EnumC1747Lf enumC1747Lf;
        int i;
        this.A00.setOnClickListener(null);
        if (anonymousClass23 == AnonymousClass23.A05) {
            strA0B = AnonymousClass22.A09(this.A03.A00());
            enumC1747Lf = EnumC1747Lf.REPORT_AD;
            i = -552389;
        } else {
            strA0B = AnonymousClass22.A0B(this.A03.A00());
            enumC1747Lf = EnumC1747Lf.HIDE_AD;
            i = -13272859;
        }
        MY myA0M = new MX(this.A03, this.A0A).A0I(strA0B).A0H(AnonymousClass22.A07(this.A03.A00())).A0F(anonymousClass25.A04()).A0K(false).A0E(enumC1747Lf).A0D(i).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        LX.A0X(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(myA0M, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0N(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        C1784Mr c1784Mr = new C1784Mr(this.A03, anonymousClass25, this.A0A, anonymousClass23 == AnonymousClass23.A05 ? EnumC1747Lf.REPORT_AD : EnumC1747Lf.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(C1748Lg.A01(EnumC1747Lf.BACK_ARROW));
        this.A00.setOnClickListener(new ViewOnClickListenerC1789Mw(this));
        this.A00.setContentDescription(A0A(0, 4, 64));
        LX.A0X(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(c1784Mr, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return true;
    }
}
