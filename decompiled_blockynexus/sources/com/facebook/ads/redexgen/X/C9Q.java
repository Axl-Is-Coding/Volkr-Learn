package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9Q extends Sf implements MJ {
    public static byte[] A0D;
    public static String[] A0E;

    @Nullable
    public View A00;
    public View A01;

    @Nullable
    public ImageView A02;
    public C2026Wb A03;

    @Nullable
    public AbstractC1762Lu A04;
    public C1819Oa A05;

    @Nullable
    public GW A06;
    public boolean A07;
    public final FrameLayout A08;
    public final InterfaceC1767Lz A09;
    public final LU A0A;
    public final C1638Gs A0B;
    public final AtomicBoolean A0C;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0D = new byte[]{-53, -60, -39, -56, -30, -42, -41, -60, -43, -41, -52, -47, -54, -30, -60, -47, -52, -48, -60, -41, -52, -46, -47, -42, -30, -45, -49, -60, -36, -56, -57, -51, -48, -44, -58, -32, -45, -58, -40, -62, -45, -59, -32, -44, -60, -45, -58, -58, -49, -32, -44, -55, -48, -40, -49, -53, -75, -57, -45, -71, -62, -72, -45, -73, -75, -58, -72, -45, -57, -68, -61, -53, -62, -86, -74, -76, 117, -83, -88, -86, -84, -87, -74, -74, -78, 117, -88, -85, -70, 117, -80, -75, -69, -84, -71, -70, -69, -80, -69, -80, -88, -77, 117, -83, -80, -75, -80, -70, -81, -90, -88, -86, -69, -80, -67, -80, -69, -64};
    }

    public static void A0F() {
        A0E = new String[]{"QUFYIN7o4MSHfMbcaqgxGqdg8oING", "Qixa92rp7KQSHPhBId3L5m9SXc6gxNRP", "TUKhftCqFUFv9xNbjbPA3CLhBIkdW", "aNiMBj1VMT3xct4Co4hWzqTsg", "QYSCqyZ4CS", "VjIbmM2G6pRRrYhuKIf6SOzC6eQUF7eo", "KFJXOgKoK7JNlCBWMf", "dachHr6cLZKwbIDqTeRsc0FgbmZCJ"};
    }

    static {
        A0F();
        A0E();
    }

    public C9Q(C1807No c1807No) {
        super(c1807No, false);
        this.A0C = new AtomicBoolean(false);
        this.A07 = false;
        this.A03 = c1807No.A05();
        this.A04 = c1807No.A08();
        this.A01 = new View(this.A03);
        LX.A0N(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.A01, layoutParams);
        A09();
        this.A09 = c1807No.A09();
        C1801Ni.A00(c1807No.A05(), this, getAdInfo().A0E().A07());
        this.A0A = A02(c1807No);
        getAdDetailsView().bringToFront();
        this.A0B = A04(c1807No);
        A0e();
        this.A05 = new C1819Oa(this.A03, c1807No.A06(), getAdDataBundle());
        this.A08 = new FrameLayout(getContext());
        if (!C1693Iy.A1T(this.A03)) {
            A07();
        }
    }

    private LU A02(C1807No c1807No) {
        LU lu = (LU) c1807No.A02();
        int iA0d = A0d(c1807No.A08());
        ImageView imageView = (ImageView) c1807No.A03();
        imageView.setPadding(Sf.A0D, Sf.A0D, Sf.A0D, Sf.A0D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Sf.A0E, Sf.A0E);
        layoutParams.setMargins(0, iA0d, Sf.A0C, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        if (C1693Iy.A1P(this.A03)) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            NT adDetailsView = getAdDetailsView();
            RelativeLayout.LayoutParams simpleVideoViewParams = adDetailsView.A0C(this.A01);
            adDetailsView.setLayoutParams(simpleVideoViewParams);
            if (getResources().getConfiguration().orientation == 1) {
                layoutParams2.addRule(13);
            } else {
                layoutParams2.addRule(0, this.A01.getId());
                layoutParams2.setMargins(0, 0, 0, 0);
            }
            this.A02 = imageView;
            addView(lu, layoutParams2);
            addView(imageView, layoutParams);
        } else {
            RelativeLayout.LayoutParams videoViewParams = new RelativeLayout.LayoutParams(-1, -1);
            videoViewParams.addRule(13);
            addView(lu, videoViewParams);
            lu.addView(imageView, layoutParams);
        }
        return lu;
    }

    private C1638Gs A04(C1807No c1807No) {
        C1638Gs c1638GsA0A = c1807No.A0A();
        c1638GsA0A.A0A(-1, Sf.A09);
        if (C1693Iy.A1P(this.A03)) {
            if (getResources().getConfiguration().orientation == 1) {
                setUpPortraitAdDetails(c1638GsA0A);
            } else {
                setUpLandscapeAdDetails(c1638GsA0A);
            }
        } else {
            c1638GsA0A.setPadding(Sf.A0H, Sf.A0H, Sf.A0H, Sf.A0H);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Sf.A0G);
            layoutParams.addRule(12);
            addView(c1638GsA0A, layoutParams);
        }
        return c1638GsA0A;
    }

    private void A07() {
        String title;
        RewardData rewardDataA0K = getAdDataBundle().A0K();
        if (rewardDataA0K == null) {
            title = getAdDataBundle().A0N().A06();
        } else {
            title = getAdDataBundle().A0N().A07(rewardDataA0K.getCurrency(), rewardDataA0K.getQuantity());
        }
        M8 m8 = new M8(getAdContextWrapper(), -1, -16777216, title, null, getAdDataBundle().A0N().A05(), getAdDataBundle().A0N().A04(), C1748Lg.A01(EnumC1747Lf.REWARD_ICON));
        m8.A02.setOnClickListener(new ViewOnClickListenerC1808Np(this));
        m8.A01.setOnClickListener(new ViewOnClickListenerC1809Nq(this));
        this.A08.addView(m8, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void A08() {
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A0F();
            this.A0A.A0a(getAnimationPlugin());
        }
    }

    private void A09() {
        AbstractC1762Lu abstractC1762Lu = this.A04;
        if (abstractC1762Lu == null) {
            return;
        }
        this.A06 = new GW(abstractC1762Lu, 400, -abstractC1762Lu.getToolbarHeight(), 0);
    }

    private void A0A() {
        new JC(getAdDataBundle().A0Q(), getAdEventManager()).A03(JB.A0n, null);
        if (!getAdInfo().A0N()) {
            return;
        }
        this.A0C.set(true);
        LX.A0X(this);
        LX.A0K(this.A0A);
        LX.A0d(this.A0A, this.A0B, this.A08, this.A00);
        LX.A0O(this.A04);
        C1819Oa c1819Oa = this.A05;
        ViewOnClickListenerC2033Wi ctaButton = getCtaButton();
        String[] strArr = A0E;
        if (strArr[2].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[3] = "FxfG3zWETYKhpCEsP1aqGpvXk";
        strArr2[3] = "FxfG3zWETYKhpCEsP1aqGpvXk";
        Pair<OZ, View> pairA03 = c1819Oa.A03(ctaButton);
        this.A00 = (View) pairA03.second;
        int i = C1810Nr.A00[((OZ) pairA03.first).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            LX.A0d(getAdDetailsView());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(Sf.A0F, Sf.A0F, Sf.A0F, Sf.A0F);
            addView(this.A00, layoutParams);
            return;
        }
        getAdDetailsView().setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (C1693Iy.A1P(this.A03)) {
            ImageView imageView = this.A02;
            if (imageView != null) {
                String[] strArr3 = A0E;
                if (strArr3[2].length() != strArr3[0].length()) {
                    String[] strArr4 = A0E;
                    strArr4[7] = "RenllHEOEhUEXuJGVHYKXOkiOEbWR";
                    strArr4[4] = "Ez9H6xpGZ9";
                    imageView.setVisibility(8);
                } else {
                    String[] strArr5 = A0E;
                    strArr5[2] = "KicgKgsrHX1lzbvbA0fubHpFySDNt";
                    strArr5[0] = "T8uqPR7oq7Ja3xFAu7WdainZogpwN";
                    imageView.setVisibility(8);
                }
            }
            getAdDetailsView().setLayoutParams(getAdDetailsView().A0B(this.A01));
            if (getResources().getConfiguration().orientation == 1) {
                layoutParams2.setMargins(0, A0d(this.A04), 0, AbstractC1803Nk.A09);
                layoutParams2.addRule(2, getAdDetailsView().getId());
            } else {
                layoutParams2.setMargins(0, AbstractC1803Nk.A09, 0, AbstractC1803Nk.A09);
                layoutParams2.addRule(0, this.A01.getId());
            }
        } else {
            layoutParams2.setMargins(0, A0d(this.A04), 0, 0);
            layoutParams2.addRule(2, getAdDetailsView().getId());
        }
        addView(this.A00, layoutParams2);
    }

    private void A0B() {
        AbstractC1762Lu abstractC1762Lu;
        if (!this.A0A.A0g()) {
            this.A0A.A0c(false, false, 11);
        }
        if (C1693Iy.A1T(this.A03) && (abstractC1762Lu = this.A04) != null) {
            abstractC1762Lu.A06(this);
        } else {
            AbstractC1762Lu abstractC1762Lu2 = this.A04;
            if (abstractC1762Lu2 != null) {
                LX.A0K(abstractC1762Lu2);
            }
            LX.A0Q(this.A0A, 4);
            LX.A0Q(this.A0B, 4);
            LX.A0Q(getAdDetailsView(), 4);
            addView(this.A08, new RelativeLayout.LayoutParams(-1, -1));
        }
        this.A07 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C() {
        if (getAdInfo().A0N()) {
            this.A0A.A0X(EnumC1830Ol.A05);
            return;
        }
        InterfaceC1767Lz interfaceC1767Lz = this.A09;
        if (A0E[3].length() != 25) {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[1] = "Zliat4mU5XNL19AyOd3jcD22cYPYEARz";
        strArr[1] = "Zliat4mU5XNL19AyOd3jcD22cYPYEARz";
        interfaceC1767Lz.A3s(A06(73, 45, 58));
    }

    private void A0D() {
        GW gw = this.A06;
        if (gw != null) {
            gw.A3O(true, false);
        }
        if (getAdDetailsAnimation() != null) {
            getAdDetailsAnimation().A3O(true, false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0K(C7l c7l) {
        super.A0K(c7l);
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0L(C14247i c14247i) {
        super.A0L(c14247i);
        int duration = this.A0A.getDuration() - c14247i.A00();
        if (getAnimationPlugin() != null) {
            int remainingVideoTimeInMillis = A0E[1].charAt(18);
            if (remainingVideoTimeInMillis != 51) {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[5] = "xiBnzSw2W6K3rvYkwdUGMYXv5m3ZqRWR";
            strArr[5] = "xiBnzSw2W6K3rvYkwdUGMYXv5m3ZqRWR";
            if (duration < 3000 && getAnimationPlugin().A0K()) {
                getAnimationPlugin().A0G();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0V() {
        super.A0V();
        A08();
        this.A04 = null;
    }

    @Override // com.facebook.ads.redexgen.X.Sf, com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        super.A0a(anonymousClass18, str, d2, bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.getBoolean(A06(0, 31, 118), false)) {
            A0D();
        }
        if (bundle.getBoolean(A06(55, 18, 103), false)) {
            A0A();
        }
        if (bundle.getBoolean(A06(31, 24, 116), false)) {
            A0B();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0b() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0c(boolean r6) {
        /*
            r5 = this;
            r4 = 1
            if (r6 == 0) goto L31
            boolean r0 = r5.A07
            if (r0 != 0) goto L31
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.A0C
            boolean r3 = r0.get()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C9Q.A0E
            r0 = 7
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L68
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C9Q.A0E
            java.lang.String r1 = "IfEmWBIDBUNw5tL7YhS4lNzldGhzw"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "8CoNQoXVMdzgwU1krh95bRLsSKKH4"
            r0 = 0
            r2[r0] = r1
            if (r3 != 0) goto L31
            r5.A0B()
            return r4
        L31:
            com.facebook.ads.redexgen.X.18 r0 = r5.getAdInfo()
            boolean r3 = r0.A0N()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C9Q.A0E
            r0 = 5
            r1 = r1[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L68
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C9Q.A0E
            java.lang.String r1 = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor"
            r0 = 1
            r2[r0] = r1
            if (r3 == 0) goto L66
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.A0C
            boolean r0 = r0.get()
            if (r0 != 0) goto L66
            com.facebook.ads.redexgen.X.LU r1 = r5.A0A
            com.facebook.ads.redexgen.X.Ol r0 = com.facebook.ads.redexgen.X.EnumC1830Ol.A06
            r1.A0X(r0)
            return r4
        L66:
            r0 = 0
            return r0
        L68:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9Q.A0c(boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.Sf
    public final void A0e() {
        super.A0e();
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A86(this.A0A);
        }
    }

    public final boolean A0f() {
        return getAdInfo().A0N();
    }

    @Override // com.facebook.ads.redexgen.X.MJ
    public final void A95() {
        this.A07 = false;
        this.A0A.A0Y(EnumC1834Op.A03, 15);
    }

    @Override // com.facebook.ads.redexgen.X.MJ
    public final void A96() {
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        if (A0f() && !this.A0C.get()) {
            return 1;
        }
        return super.getCloseButtonStyle();
    }

    @Override // com.facebook.ads.redexgen.X.Sf, com.facebook.ads.redexgen.X.AbstractC1803Nk, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C1693Iy.A1P(this.A03)) {
            boolean z = configuration.orientation == 1;
            if (!this.A0C.get()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (z) {
                    setUpPortraitAdDetails(this.A0B);
                    layoutParams.addRule(13);
                } else {
                    setUpLandscapeAdDetails(this.A0B);
                    layoutParams.addRule(0, this.A01.getId());
                    layoutParams.setMargins(0, 0, 0, 0);
                }
                LU lu = this.A0A;
                String[] strArr = A0E;
                if (strArr[7].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[1] = "DO7In235juv9PXUKV934zSaX5akZYCRG";
                strArr2[1] = "DO7In235juv9PXUKV934zSaX5akZYCRG";
                lu.setLayoutParams(layoutParams);
                return;
            }
            if (this.A00 == null) {
                return;
            }
            ImageView imageView = this.A02;
            if (A0E[5].charAt(17) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr3 = A0E;
            strArr3[5] = "g7uXpIwsYCOJvIzf4Zz9qplJQO82wATZ";
            strArr3[5] = "g7uXpIwsYCOJvIzf4Zz9qplJQO82wATZ";
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            getAdDetailsView().setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            getAdDetailsView().setLayoutParams(getAdDetailsView().A0B(this.A01));
            if (z) {
                layoutParams2.setMargins(0, A0d(this.A04), 0, AbstractC1803Nk.A09);
                layoutParams2.addRule(2, getAdDetailsView().getId());
            } else {
                layoutParams2.setMargins(0, AbstractC1803Nk.A09, 0, AbstractC1803Nk.A09);
                layoutParams2.addRule(0, this.A01.getId());
            }
            this.A00.setLayoutParams(layoutParams2);
        }
    }

    private void setUpLandscapeAdDetails(C1638Gs c1638Gs) {
        getAdDetailsView().removeAllViews();
        removeView(c1638Gs);
        getAdDetailsView().setLayoutParams(getAdDetailsView().A0C(this.A01));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C2116Zq.A0G);
        layoutParams.addRule(12);
        addView(c1638Gs, layoutParams);
    }

    private void setUpPortraitAdDetails(C1638Gs c1638Gs) {
        getAdDetailsView().removeAllViews();
        removeView(c1638Gs);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C2116Zq.A0H);
        layoutParams.setMargins(0, 0, 0, C2116Zq.A0I);
        getAdDetailsView().addView(c1638Gs, layoutParams);
        getAdDetailsView().setLayoutParams(getAdDetailsView().A0C(this.A01));
    }
}
