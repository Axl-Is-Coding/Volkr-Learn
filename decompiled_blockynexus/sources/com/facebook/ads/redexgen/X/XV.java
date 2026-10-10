package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XV extends MZ {
    public static String[] A02;
    public static final int A03;
    public final RelativeLayout A00;
    public final C2026Wb A01;

    public static void A0C() {
        A02 = new String[]{"ixUXsyhysd", "OPv8qP0MhbtkKZTtC7nh2I9a6WHAwpWs", "vXGbyjT4IhQUpn", "fkCzuvVfwHm7OJpjmgBYeP3AajMmrNF6", "BQFEEs7xBV9CwTHtkGRziYqWB8GhQG3x", "ODdJk2", "", "xXrbtEFvrY2"};
    }

    static {
        A0C();
        A03 = (int) (LX.A01 * 8.0f);
    }

    public XV(C2026Wb c2026Wb, J5 j5, String str, C1P c1p, M0 m0, InterfaceC1767Lz interfaceC1767Lz) {
        super(c2026Wb, j5, str, c1p, m0, interfaceC1767Lz);
        this.A01 = c2026Wb;
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        LX.A0P(this.A00, -1728053248);
        this.A00.setOnClickListener(new ViewOnClickListenerC1772Me(this));
    }

    public static RelativeLayout.LayoutParams A0A(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        if (A02[7].length() == 30) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "p8zovDyK5QtHis";
        strArr[0] = "GXgRrx0bJv";
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A0B() {
        if (Build.VERSION.SDK_INT >= 21) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
            LX.A0Z(this, transitionSet);
            return;
        }
        LX.A0X(this);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0K() {
        AnonymousClass25 anonymousClass25A03 = AnonymousClass22.A03(this.A01.A00());
        C1781Mo adChoicesView = new C1781Mo(this.A01);
        adChoicesView.setInfo(EnumC1747Lf.HIDE_AD, AnonymousClass22.A0B(this.A01.A00()), AnonymousClass22.A0A(this.A01.A00()));
        adChoicesView.setOnClickListener(new ViewOnClickListenerC1773Mf(this));
        AnonymousClass25 anonymousClass25A04 = AnonymousClass22.A04(this.A01.A00());
        C1781Mo c1781Mo = new C1781Mo(this.A01);
        c1781Mo.setInfo(EnumC1747Lf.REPORT_AD, AnonymousClass22.A0F(this.A01.A00()), AnonymousClass22.A0E(this.A01.A00()));
        c1781Mo.setOnClickListener(new ViewOnClickListenerC1774Mg(this));
        C1781Mo c1781Mo2 = new C1781Mo(this.A01);
        c1781Mo2.setInfo(EnumC1747Lf.AD_CHOICES_ICON, AnonymousClass22.A0G(this.A01.A00()), "");
        c1781Mo2.setOnClickListener(new ViewOnClickListenerC1775Mh(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        int i = A03;
        linearLayout.setPadding(i * 2, i, i * 2, i);
        LX.A0P(linearLayout, -1);
        if (!anonymousClass25A03.A05().isEmpty()) {
            linearLayout.addView(adChoicesView, layoutParams);
        }
        if (!anonymousClass25A04.A05().isEmpty()) {
            linearLayout.addView(c1781Mo, layoutParams);
        }
        linearLayout.addView(c1781Mo2, layoutParams);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        LX.A0L(this);
        this.A00.removeAllViews();
        LX.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0M(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        String strA08;
        int i;
        if (anonymousClass23 == AnonymousClass23.A04) {
            return;
        }
        boolean z = anonymousClass23 == AnonymousClass23.A05;
        MX mx = new MX(this.A01, this.A0A);
        if (z) {
            strA08 = AnonymousClass22.A09(this.A01.A00());
        } else {
            strA08 = AnonymousClass22.A08(this.A01.A00());
        }
        MX mxA0E = mx.A0I(strA08).A0H(AnonymousClass22.A07(this.A01.A00())).A0F(anonymousClass25.A04()).A0E(z ? EnumC1747Lf.REPORT_AD : EnumC1747Lf.HIDE_AD);
        if (z) {
            i = -552389;
        } else {
            i = -13272859;
        }
        MY myA0M = mxA0E.A0D(i).A0G(this.A09 != null ? this.A09.A01() : "").A0M();
        LX.A0P(myA0M, -1);
        LX.A0X(this);
        this.A00.removeAllViews();
        this.A00.addView(myA0M, A0A(true));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0N(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        String strA0B;
        boolean z = anonymousClass23 == AnonymousClass23.A05;
        C2026Wb c2026Wb = this.A01;
        InterfaceC1769Mb interfaceC1769Mb = this.A0A;
        if (z) {
            strA0B = AnonymousClass22.A0F(this.A01.A00());
        } else {
            strA0B = AnonymousClass22.A0B(this.A01.A00());
        }
        C1784Mr c1784Mr = new C1784Mr(c2026Wb, anonymousClass25, interfaceC1769Mb, strA0B, z ? EnumC1747Lf.REPORT_AD : EnumC1747Lf.HIDE_AD);
        c1784Mr.setClickable(true);
        LX.A0P(c1784Mr, -1);
        int i = A03;
        c1784Mr.setPadding(i * 2, i, i * 2, i);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(c1784Mr, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return false;
    }
}
