package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7v, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7v extends QW {
    public static byte[] A0K;
    public static String[] A0L;

    @Nullable
    public AbstractC1803Nk A00;

    @Nullable
    public EnumC1834Op A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final InterfaceC13584s A08;
    public final C1820Ob A09;
    public final LU A0A;
    public final C7m A0B;
    public final AbstractC1714Jv A0C;
    public final AbstractC1712Jt A0D;
    public final AbstractC1708Jp A0E;
    public final AbstractC1696Jb A0F;
    public final J8 A0G;
    public final IU A0H;
    public final HI A0I;
    public final C1638Gs A0J;

    static {
        A09();
        A08();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0K = new byte[]{-3, 21, 7, 5, 21, -1, -38, -51, -56, -55, -45};
    }

    public static void A09() {
        A0L = new String[]{"Mriq29lS8vjEPztqvg4mnlhqPa1pf4jw", "J0ebGdEZD5oKohgNzUxMA3JiHaSF4bRJ", "IT9tvlYp44pYwsfxgtsksFS", "El43mrOkb3qqMjbYlNbneDDC3riKbt8u", "SsyQgLhJr8BA6K4Jeu0226NIXlotTSUK", "5pKSfcHcmxRzGJ6MCKbxSHPk9j0pnkgf", "vZ9Xs81YGHnjRjGsoTeSsIOHxP", "Y9Sammkz"};
    }

    public C7v(C2026Wb c2026Wb, MU mu, J5 j5, AnonymousClass15 anonymousClass15, AnonymousClass77 anonymousClass77, InterfaceC1767Lz interfaceC1767Lz) {
        super(c2026Wb, mu, j5, anonymousClass15, anonymousClass77, interfaceC1767Lz);
        this.A08 = new P4(this);
        this.A0G = new J8() { // from class: com.facebook.ads.redexgen.X.8U
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                this.A00.A06 = true;
            }
        };
        this.A0F = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.83
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                this.A00.A07 = true;
                this.A00.A0Q();
            }
        };
        this.A0E = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.80
            @Override // com.facebook.ads.redexgen.X.C9A
            public final /* bridge */ /* synthetic */ void A04(AnonymousClass98 anonymousClass98) {
            }
        };
        this.A0H = new IU() { // from class: com.facebook.ads.redexgen.X.7y
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14247i c14247i) {
                this.A00.A0G(c14247i);
                this.A00.A0F(c14247i);
                this.A00.A00.A0L(c14247i);
            }
        };
        this.A0C = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7x
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                C7v c7v = this.A00;
                c7v.A0E(c7l, c7v.A0A.getState() != EnumC1846Pb.A06);
            }
        };
        this.A0D = new C7w(this);
        boolean z = false;
        this.A06 = false;
        this.A07 = false;
        this.A05 = false;
        this.A03 = false;
        this.A0A = new LU(super.A03);
        this.A0A.setFunnelLoggingHandler(super.A05);
        this.A0A.getEventBus().A04(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
        this.A0B = new C7m(super.A03, super.A04, this.A0A, super.A01.A0Q());
        this.A09 = new C1820Ob(super.A03, super.A09, super.A01.A0V(), interfaceC1767Lz);
        this.A0I = new HI(super.A03, super.A05);
        this.A0J = new C1638Gs(super.A03);
        A07();
        this.A0A.setVideoURI(super.A02.A0M(super.A01.A0M().A0E().A08()));
        A05();
        this.A04 = super.A01.A0M().A0E().A03() <= 0;
        if (super.A01.A0M().A0L() && super.A01.A0M().A0E().A02() > 0) {
            z = true;
        }
        this.A02 = z;
        LX.A0P(this, super.A01.A0L().A01().A07(true));
    }

    private AbstractC1803Nk A00(int i) {
        return C1804Nl.A00(new C1806Nn(super.A03, super.A04, super.A08, super.A01, this.A0A, super.A0A, super.A06).A0D(super.A07.getToolbarHeight()).A0F(super.A07).A0C(i).A0E(this.A0I).A0G(this.A0J).A0H(), null, true);
    }

    private void A04() {
        this.A0A.postDelayed(new P2(this), C1693Iy.A0I(super.A03));
    }

    private void A05() {
        this.A0A.postDelayed(new C1842Ox(this), C1693Iy.A0J(super.A03));
    }

    private void A06() {
        this.A04 = true;
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null) {
            abstractC1803Nk.A0Y();
        }
    }

    private void A07() {
        this.A0A.A0Z(this.A0J);
        this.A0A.A0Z(this.A0I);
        if (!TextUtils.isEmpty(super.A01.A0M().A0E().A07())) {
            C7Q c7q = new C7Q(super.A03);
            this.A0A.A0Z(c7q);
            c7q.setImage(super.A01.A0M().A0E().A07());
        }
        AnonymousClass71 anonymousClass71 = new AnonymousClass71(super.A03, true, super.A05);
        this.A0A.A0Z(anonymousClass71);
        this.A0A.A0Z(new HK(anonymousClass71, P1.A03, true));
        this.A0A.A0Z(new C7H(super.A03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(C7l c7l, boolean z) {
        if (this.A05) {
            return;
        }
        this.A05 = true;
        if (!this.A04) {
            A06();
        }
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (A0L[6].length() != 26) {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[1] = "skYYV88BTcDGkk1Ge0IaKZH0HqJ76mgM";
        strArr[1] = "skYYV88BTcDGkk1Ge0IaKZH0HqJ76mgM";
        if (abstractC1803Nk != null) {
            abstractC1803Nk.A0K(c7l);
        }
        super.A07.setToolbarActionMessage(A03(0, 0, 25));
        A0I(z);
        super.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(C14247i c14247i) {
        if (this.A0A.getState() == EnumC1846Pb.A02 && C1693Iy.A0w(super.A03)) {
            this.A0A.postDelayed(new P5(this, c14247i), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(C14247i c14247i) {
        int iA00 = c14247i.A00();
        if (this.A02) {
            int iA02 = super.A01.A0M().A0E().A02() - (iA00 / 1000);
            if (iA02 > 0) {
                super.A07.setToolbarActionMessage(super.A01.A0P().A00().replace(A03(0, 6, 74), String.valueOf(iA02)));
            } else {
                super.A07.setToolbarActionMessage(A03(0, 0, 25));
                A0I(false);
            }
        }
        float fMin = iA00 / Math.min(super.A01.A0M().A0E().A03() * 1000.0f, this.A0A.getDuration());
        super.A07.setProgress(100.0f * fMin);
        if (fMin >= 1.0f && !this.A04) {
            A06();
            String[] strArr = A0L;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[0] = "PXM0w4DTcyhv6xVVxlaJPbpxowOdlGPl";
            strArr2[4] = "ZagmJHoPVKqTZKI94Zh80WtjAbW4VeCE";
            super.A07.setToolbarActionMode(getCloseButtonStyle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(String str) {
        int currentPositionInMillis = 0;
        int duration = 0;
        LU lu = this.A0A;
        if (lu != null) {
            currentPositionInMillis = lu.getCurrentPositionInMillis();
            duration = this.A0A.getDuration();
        }
        super.A03.A04().A8H(A03(6, 5, 12), C8Y.A2C, new C8Z(str));
        if (C1693Iy.A0x(super.A03)) {
            A0E(new C7l(currentPositionInMillis, duration), false);
            return;
        }
        InterfaceC1767Lz interfaceC1767Lz = super.A08;
        if (A0L[3].charAt(0) == 'z') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
        strArr[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
        interfaceC1767Lz.A3s(super.A09.A6J());
        super.A08.A3s(super.A09.A6E());
    }

    private synchronized void A0I(boolean z) {
        boolean z2 = this.A02;
        String[] strArr = A0L;
        if (strArr[2].length() != strArr[7].length()) {
            String[] strArr2 = A0L;
            strArr2[6] = "RUkVKvLXKou3DkajJbljeqXSK8";
            strArr2[6] = "RUkVKvLXKou3DkajJbljeqXSK8";
            if (z2 && !z) {
                super.A08.A3s(super.A09.A5M());
                this.A09.A06();
                this.A02 = false;
                if (this.A00 != null) {
                    this.A00.A0W();
                }
                return;
            }
            this.A02 = false;
            String[] strArr3 = A0L;
            if (strArr3[2].length() != strArr3[7].length()) {
                String[] strArr4 = A0L;
                strArr4[6] = "pCCqOlrdcXyBK9Nv0jyTBmGbmh";
                strArr4[6] = "pCCqOlrdcXyBK9Nv0jyTBmGbmh";
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final void A0R() {
        LX.A0O(this.A00);
        LX.A0O(super.A07);
        this.A0A.setVolume(super.A01.A0M().A0E().A09() ? WheelView.DividerConfig.FILL : 1.0f);
        this.A0A.A0Y(EnumC1834Op.A03, 20);
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null && this.A02) {
            abstractC1803Nk.A0X();
        }
        AbstractC1803Nk abstractC1803Nk2 = this.A00;
        if (abstractC1803Nk2 != null && !this.A04) {
            abstractC1803Nk2.A0Z();
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final void A0T(C13604u c13604u) {
        c13604u.A0L(this.A08);
        this.A00 = A00(c13604u.A0I().getResources().getConfiguration().orientation);
        addView(this.A00, QW.A0D);
        addView(super.A07, new FrameLayout.LayoutParams(-1, super.A07.getToolbarHeight()));
        LX.A0K(this.A00);
        LX.A0K(super.A07);
        AbstractC1803Nk abstractC1803Nk = this.A00;
        setUpFullscreenMode(abstractC1803Nk != null && abstractC1803Nk.A0b());
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final boolean A0U() {
        AbstractC1803Nk abstractC1803Nk = this.A00;
        return abstractC1803Nk != null && abstractC1803Nk.A0c(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        if (this.A0A.A0f()) {
            return;
        }
        this.A01 = this.A0A.getVideoStartReason();
        this.A03 = z;
        this.A0A.A0b(false, 13);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        if (this.A0A.A0g() || this.A05 || this.A0A.getState() == EnumC1846Pb.A06 || this.A01 == null) {
            return;
        }
        if (!this.A03 || z) {
            LU lu = this.A0A;
            EnumC1834Op enumC1834Op = this.A01;
            String[] strArr = A0L;
            if (strArr[0].charAt(8) == strArr[4].charAt(8)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
            strArr2[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
            lu.A0Y(enumC1834Op, 19);
        }
    }

    private int getCloseButtonStyle() {
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null) {
            return abstractC1803Nk.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.QW, com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        super.onDestroy();
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null) {
            abstractC1803Nk.A0V();
        }
        LU lu = this.A0A;
        if (lu != null) {
            if (!this.A05) {
                lu.A0X(EnumC1830Ol.A03);
            }
            this.A0A.getEventBus().A05(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
            this.A0A.A0S();
        }
        this.A0B.A0h();
    }
}
