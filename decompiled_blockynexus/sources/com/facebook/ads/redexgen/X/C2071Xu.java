package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.RewardData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2071Xu extends RelativeLayout implements M0, MJ {
    public static byte[] A0j;
    public static String[] A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final int A0p;
    public static final int A0q;
    public static final RelativeLayout.LayoutParams A0r;
    public static final int A0s;
    public static final int A0t;
    public static final int A0u;
    public static final int A0v;
    public static final int A0w;
    public int A00;
    public int A01;

    @Nullable
    public View A02;
    public View A03;

    @Nullable
    public AbstractC1762Lu A04;

    @Nullable
    public InterfaceC1767Lz A05;

    @Nullable
    public NT A06;
    public C1819Oa A07;
    public C1820Ob A08;

    @Nullable
    public LU A09;

    @Nullable
    public EnumC1834Op A0A;
    public HY A0B;

    @Nullable
    public HK A0C;

    @Nullable
    public AnonymousClass71 A0D;

    @Nullable
    public C1622Gb A0E;
    public GW A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final int A0K;
    public final Handler A0L;
    public final Handler A0M;
    public final RelativeLayout A0N;
    public final C1G A0O;
    public final RO A0P;
    public final InterfaceC13584s A0Q;
    public final C2026Wb A0R;
    public final J5 A0S;
    public final JC A0T;
    public final LL A0U;
    public final LQ A0V;
    public final C7m A0W;
    public final AbstractC1714Jv A0X;
    public final AbstractC1712Jt A0Y;
    public final AbstractC1696Jb A0Z;
    public final J8 A0a;
    public final IU A0b;
    public final HI A0c;
    public final C1638Gs A0d;

    @DoNotStrip
    public final AbstractC1848Pd A0e;
    public final C1849Pe A0f;
    public final AtomicBoolean A0g;
    public final boolean A0h;
    public final boolean A0i;

    public static String A0F(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0j, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0S() {
        A0j = new byte[]{29, ci.n, 11, 12, 22};
    }

    public static void A0T() {
        A0k = new String[]{"vsdEBwVgd8xuD4acIyCMTbEVgnYoxSzn", "ksTg5", "PS2LqNPtHz7Bj2TqhJ7TZjs4LL9ATMRr", "qSNvo2HWKXxTUkx77WQBoFZa4uZWek8Z", "kV", "kWwRq1ENXLXBTFEhopAwPvilnneCtOoi", "1j3TsCoxoqnujqaJP1b9vcmgNjtc01PK", "DySaXvgrVXG8E60xfPO0YxcmTr0eS0sa"};
    }

    static {
        A0T();
        A0S();
        A0n = (int) (LX.A01 * 10.0f);
        A0o = (int) (LX.A01 * 18.0f);
        A0q = (int) (LX.A01 * 16.0f);
        A0m = (int) (LX.A01 * 48.0f);
        A0p = (int) (LX.A01 * 28.0f);
        A0l = (int) (LX.A01 * 250.0f);
        A0w = (int) (LX.A01 * 12.0f);
        A0v = (int) (LX.A01 * 26.0f);
        A0s = (int) (LX.A01 * 4.0f);
        A0t = C2F.A01(-1, 77);
        A0u = C2F.A01(A0t, 90);
        A0r = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C2071Xu(C2026Wb c2026Wb, J5 j5, LU lu, InterfaceC1767Lz interfaceC1767Lz, RO ro) {
        super(c2026Wb);
        this.A0L = new Handler(Looper.getMainLooper());
        this.A0Q = new Y2(this);
        this.A0X = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.9i
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                this.A00.A0d(c7l);
            }
        };
        this.A0Y = new AbstractC1712Jt() { // from class: com.facebook.ads.redexgen.X.9h
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 4);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{-108, -89, -94, -93, -83, -114, -86, -97, -73, -128, -97, -95, -87, -125, -80, -80, -83, -80};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A04(C1713Ju c1713Ju) {
                this.A00.A0e(A00(0, 18, 58));
            }
        };
        this.A0a = new J8() { // from class: com.facebook.ads.redexgen.X.9g
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                if (this.A00.A09 == null) {
                    return;
                }
                this.A00.A0G = true;
                if (!this.A00.A0P.A0M().A0O()) {
                    this.A00.A0P();
                }
                this.A00.A0g.set(this.A00.A09.A0d());
                this.A00.A0R();
            }
        };
        this.A0Z = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.9f
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (this.A00.A0J) {
                    return;
                }
                this.A00.A0f.A0W();
                this.A00.A0J = true;
            }
        };
        this.A0b = new C14629e(this);
        this.A0V = new LQ();
        this.A0g = new AtomicBoolean(false);
        this.A0M = new Handler();
        this.A0I = false;
        this.A0H = false;
        this.A0G = false;
        this.A0J = false;
        this.A01 = -1;
        this.A0R = c2026Wb;
        this.A0h = false;
        this.A0i = C1693Iy.A1h(this.A0R);
        this.A05 = interfaceC1767Lz;
        this.A0S = j5;
        this.A0P = ro;
        this.A0T = new JC(this.A0P.A0Q(), this.A0S);
        this.A09 = lu;
        this.A09.setFunnelLoggingHandler(this.A0T);
        this.A0O = this.A0P.A0L().A01();
        this.A0N = new RelativeLayout(c2026Wb);
        this.A0d = new C1638Gs(this.A0R);
        this.A0c = new HI(this.A0R, this.A0T);
        C1B c1bA0E = this.A0P.A0M().A0E();
        this.A0K = Math.min(c1bA0E.A02(), c1bA0E.A04());
        this.A09.setVolume(c1bA0E.A09() ? WheelView.DividerConfig.FILL : 1.0f);
        this.A03 = new View(this.A0R);
        LX.A0N(this.A03);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        this.A03.setLayoutParams(layoutParams);
        this.A0e = new C2076Xz(this);
        this.A0f = new C1849Pe(this, 1, new WeakReference(this.A0e), c2026Wb);
        this.A0f.A0Y(250);
        this.A0W = new C7m(this.A0R, this.A0S, this.A09, this.A0P.A0Q());
        this.A07 = new C1819Oa(this.A0R, this.A0S, this.A0P);
        this.A08 = new C1820Ob(this.A0R, new XY(), this.A0P.A0V(), this.A05);
        new AsyncTaskC2037Wm(this, c2026Wb).A08(c1bA0E.A07());
        this.A09.setVideoProgressReportIntervalMs(ro.A0F());
        this.A09.getEventBus().A04(this.A0X, this.A0Y, this.A0a, this.A0Z, this.A0b);
        c2026Wb.A0A().A2q();
        this.A0U = new LL(this);
        this.A0U.A05(LK.A03);
    }

    private void A0H() {
        C2026Wb c2026Wb = this.A0R;
        if (c2026Wb == null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(c2026Wb);
        frameLayout.setLayoutParams(A0r);
        LX.A0P(frameLayout, 1711276032);
        this.A0N.addView(frameLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        InterfaceC1767Lz interfaceC1767Lz = this.A05;
        if (interfaceC1767Lz == null) {
            return;
        }
        interfaceC1767Lz.A3s(EnumC1836Or.A08.A02());
    }

    private void A0J() {
        NT nt = this.A06;
        if (nt != null) {
            nt.removeAllViews();
            this.A0N.removeView(this.A0d);
            NT nt2 = this.A06;
            nt2.setLayoutParams(nt2.A0C(this.A03));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C2116Zq.A0G);
            layoutParams.addRule(12);
            this.A0N.addView(this.A0d, layoutParams);
        }
    }

    private void A0K() {
        NT nt = this.A06;
        if (nt != null) {
            nt.removeAllViews();
            this.A0N.removeView(this.A0d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C2116Zq.A0H);
            layoutParams.setMargins(0, 0, 0, C2116Zq.A0I);
            this.A06.addView(this.A0d, layoutParams);
            NT nt2 = this.A06;
            nt2.setLayoutParams(nt2.A0C(this.A03));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        this.A0I = true;
        LX.A0X(this.A0N);
        LU lu = this.A09;
        if (lu != null) {
            lu.A0U();
            this.A09.setVisibility(4);
        }
        AbstractC1762Lu abstractC1762Lu = this.A04;
        if (abstractC1762Lu == null) {
            return;
        }
        abstractC1762Lu.setPageDetailsVisible(false);
        this.A04.setToolbarActionMode(0);
        this.A04.setToolbarActionMessage(A0F(0, 0, 87));
        LX.A0d(this.A09, this.A0c, this.A0d);
        Pair<OZ, View> pairA03 = this.A07.A03(getCTAButton());
        this.A02 = (View) pairA03.second;
        int i = ME.A00[((OZ) pairA03.first).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            LX.A0d(this.A06);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int i2 = A0q;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.A0N.addView((View) pairA03.second, layoutParams);
            this.A0V.A06();
            return;
        }
        if (C1693Iy.A1P(this.A0R) && this.A06 != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            NT nt = this.A06;
            RelativeLayout.LayoutParams screenshotParams = nt.A0B(this.A03);
            nt.setLayoutParams(screenshotParams);
            if (getResources().getConfiguration().orientation == 1) {
                layoutParams2.setMargins(0, this.A04.getToolbarHeight(), 0, A0n);
                layoutParams2.addRule(2, this.A06.getId());
            } else {
                int i3 = A0n;
                layoutParams2.setMargins(0, i3, 0, i3);
                layoutParams2.addRule(0, this.A03.getId());
            }
            this.A0N.addView((View) pairA03.second, layoutParams2);
        } else if (!this.A0i) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.setMargins(0, this.A04.getToolbarHeight(), 0, 0);
            this.A0N.addView((View) pairA03.second, layoutParams3);
            NT nt2 = this.A06;
            if (nt2 != null) {
                int id = nt2.getId();
                if (A0k[4].length() != 2) {
                    throw new RuntimeException();
                }
                String[] strArr = A0k;
                strArr[2] = "unAGmyqFwvprojiFSqdEJubKYqzfvtr5";
                strArr[2] = "unAGmyqFwvprojiFSqdEJubKYqzfvtr5";
                layoutParams3.addRule(2, id);
            }
        } else {
            this.A0N.addView((View) pairA03.second);
        }
        NT nt3 = this.A06;
        if (nt3 != null) {
            nt3.setVisibility(0);
            this.A06.A0E(true);
        }
        A0Q();
        this.A0V.A06();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0M() {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2071Xu.A0M():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        String strA07;
        if (C1693Iy.A1T(this.A0R)) {
            this.A04.A06(this);
            return;
        }
        RewardData rewardDataA0K = this.A0P.A0K();
        if (rewardDataA0K == null) {
            strA07 = this.A0P.A0N().A06();
        } else {
            strA07 = this.A0P.A0N().A07(rewardDataA0K.getCurrency(), rewardDataA0K.getQuantity());
        }
        M8 m8 = new M8(this.A0R, -1, -16777216, strA07, null, this.A0P.A0N().A05(), this.A0P.A0N().A04(), C1748Lg.A01(EnumC1747Lf.REWARD_ICON));
        m8.A02.setOnClickListener(new MC(this, m8));
        m8.A01.setOnClickListener(new MD(this, m8));
        LX.A0K(this.A0N);
        LX.A0K(this.A04);
        LX.A0P(m8, 1711276032);
        m8.setClickable(true);
        LU lu = this.A09;
        if (lu != null && !lu.A0g()) {
            this.A09.A0c(false, false, 16);
        }
        addView(m8, new RelativeLayout.LayoutParams(-1, -1));
        m8.bringToFront();
    }

    private void A0O() {
        if (this.A0P.A0M().A0O() && this.A05 != null) {
            OE oeA0B = new OC(this.A0R, this.A0P.A0M().A0F(), this.A0P.A0O()).A08(this.A0P.A0L().A01()).A0B();
            JE.A04(oeA0B, this.A0T, JB.A0U);
            this.A05.A3K(oeA0B, 1, A0r);
            oeA0B.bringToFront();
            oeA0B.A04(new C2072Xv(this));
            this.A0R.A0A().A2b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P() {
        LU lu = this.A09;
        if (lu == null) {
            return;
        }
        lu.A0Y(EnumC1834Op.A03, 22);
        postDelayed(new Y4(this), C1693Iy.A0I(getContext()));
    }

    private void A0Q() {
        C1819Oa c1819Oa;
        if (this.A0i && this.A02 != null && (c1819Oa = this.A07) != null && c1819Oa.A04() == OZ.A04) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            boolean z = this.A00 == 2;
            layoutParams.setMargins(0, !z ? getToolbarHeight() : A0n, 0, !z ? 0 : A0n);
            NS ns = (NS) ((EI) this.A02).getAdapter();
            ns.A08();
            int i = this.A00;
            boolean isLandscape = this.A0i;
            ns.A0G(i, isLandscape);
            NT nt = this.A06;
            if (nt != null) {
                if (z) {
                    nt.A0D(this.A00);
                } else {
                    int id = nt.getId();
                    String[] strArr = A0k;
                    if (strArr[5].charAt(31) == strArr[3].charAt(31)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0k;
                    strArr2[0] = "LwDo8VVUwsuJrlNU8QrzJ41vhXhK4VzE";
                    strArr2[7] = "9aOkUkxqZvQgWgLWjLrmfK9aYM0kVuqh";
                    layoutParams.addRule(2, id);
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(!z ? -1 : A0l, z ? -1 : -2);
                layoutParams2.addRule(12);
                NT nt2 = this.A06;
                int i2 = A0q;
                int toolbarHeight = !z ? i2 : getToolbarHeight() + i2;
                int i3 = A0q;
                nt2.setPadding(i2, toolbarHeight, i3, i3);
                this.A06.setLayoutParams(layoutParams2);
            }
            this.A02.setLayoutParams(layoutParams);
            this.A02.setOverScrollMode(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0R() {
        this.A0c.setVisibility(this.A0g.get() ? 0 : 8);
        this.A0c.A0A();
    }

    private final void A0U() {
        if (this.A06 == null) {
            return;
        }
        this.A0B = new HY(true);
        C1622Gb c1622Gb = this.A0E;
        if (c1622Gb != null) {
            this.A0B.A0J(c1622Gb);
        }
        C1G c1gA01 = this.A0P.A0L().A01();
        this.A0B.A0J(new GX(this.A06.getCTAButton(), 300, c1gA01.A08(true), -14934495));
        this.A0B.A0J(new C1623Gc(this.A06.getCTAButton(), 300, LX.A09(A0t, A0u, A0s), LX.A06(c1gA01.A08(true), A0s)));
        this.A0B.A0J(new GY(this.A06.getExpandableLayout(), 150, false));
        this.A0B.A0I(2300);
        this.A0B.A86(this.A09);
    }

    private final void A0V() {
        LU lu = this.A09;
        if (lu != null) {
            lu.A0W(2);
            this.A09.A0S();
        }
        C1849Pe c1849Pe = this.A0f;
        if (c1849Pe != null) {
            c1849Pe.A0X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d(C7l c7l) {
        if (this.A0I) {
            return;
        }
        this.A08.A06();
        A0L();
        InterfaceC1767Lz interfaceC1767Lz = this.A05;
        if (interfaceC1767Lz != null) {
            interfaceC1767Lz.A3t(EnumC1836Or.A06.A02(), c7l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0e(String str) {
        this.A0R.A0A().A2r(str);
        int currentPositionInMillis = 0;
        int duration = 0;
        LU lu = this.A09;
        if (lu != null) {
            currentPositionInMillis = lu.getCurrentPositionInMillis();
            duration = this.A09.getDuration();
        }
        A0V();
        this.A0R.A04().A8H(A0F(0, 5, 84), C8Y.A2C, new C8Z(str));
        if (C1693Iy.A0x(this.A0R)) {
            A0d(new C7l(currentPositionInMillis, duration));
            return;
        }
        InterfaceC1767Lz interfaceC1767Lz = this.A05;
        if (interfaceC1767Lz == null) {
            return;
        }
        interfaceC1767Lz.A3s(EnumC1836Or.A09.A02());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0f() {
        LU lu = this.A09;
        return lu != null && lu.getCurrentPositionInMillis() / 1000 >= this.A0P.A0M().A0E().A02();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, Bundle bundle, C13604u c13604u) {
        if (this.A09 != null) {
            InterfaceC1767Lz interfaceC1767Lz = this.A05;
            if (A0k[2].charAt(24) == 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[0] = "e6V6RqcsweZ5TPTb9FgQuQ0pryALZ0j5";
            strArr[7] = "lv4Tf42JMHAUVPcypCqljFxIq3tnjr4p";
            if (interfaceC1767Lz == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.A0U.A05(LK.A04);
            }
            A0M();
            c13604u.A0L(this.A0Q);
            this.A09.setVideoURI(new AnonymousClass77(this.A0R).A0M(this.A0P.A0M().A0E().A08()));
            setUpContentLayoutForVideo(c13604u.A0I().getResources().getConfiguration().orientation);
            addView(this.A0N, A0r);
            AbstractC1762Lu abstractC1762Lu = this.A04;
            if (abstractC1762Lu != null) {
                LX.A0N(abstractC1762Lu);
                this.A04.A05(this.A0O, true);
                addView(this.A04, new RelativeLayout.LayoutParams(-1, this.A04.getToolbarHeight()));
            }
            this.A05.A3K(this, 0, A0r);
            A0O();
            postDelayed(new C2075Xy(this), C1693Iy.A0J(getContext()));
        }
    }

    @Override // com.facebook.ads.redexgen.X.MJ
    public final void A95() {
        LU lu = this.A09;
        if (lu != null) {
            EnumC1834Op enumC1834Op = EnumC1834Op.A03;
            if (A0k[6].charAt(1) != 'j') {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[6] = "Tj2Tj3snk4deQrW2TFaqKUqYHOA0aFA3";
            strArr[6] = "Tj2Tj3snk4deQrW2TFaqKUqYHOA0aFA3";
            lu.A0Y(enumC1834Op, 23);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MJ
    public final void A96() {
        A0L();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        LU lu = this.A09;
        if (lu == null || lu.A0f()) {
            return;
        }
        this.A0A = this.A09.getVideoStartReason();
        this.A0H = z;
        LU lu2 = this.A09;
        if (A0k[1].length() != 5) {
            throw new RuntimeException();
        }
        String[] strArr = A0k;
        strArr[4] = "af";
        strArr[4] = "af";
        lu2.A0b(false, 14);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        LU lu = this.A09;
        if (lu == null || lu.A0g() || this.A0I || this.A09.getState() == EnumC1846Pb.A06 || this.A0A == null) {
            return;
        }
        if (!this.A0H || z) {
            LU lu2 = this.A09;
            String[] strArr = A0k;
            if (strArr[0].charAt(9) == strArr[7].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0k;
            strArr2[1] = "7lFur";
            strArr2[1] = "7lFur";
            lu2.A0Y(this.A0A, 21);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
    }

    @Nullable
    private ViewOnClickListenerC2033Wi getCTAButton() {
        if (this.A05 == null) {
            return null;
        }
        ViewOnClickListenerC2033Wi viewOnClickListenerC2033Wi = new ViewOnClickListenerC2033Wi(this.A0R, EnumC1836Or.A04.A02(), this.A0O, this.A0S, this.A05, this.A0f, this.A0V);
        viewOnClickListenerC2033Wi.setRoundedCornersEnabled(true);
        viewOnClickListenerC2033Wi.setViewShowsOverMedia(true);
        LX.A0J(1001, viewOnClickListenerC2033Wi);
        viewOnClickListenerC2033Wi.setCta(this.A0P.A0M().A0G(), this.A0P.A0Q(), new HashMap());
        return viewOnClickListenerC2033Wi;
    }

    private int getToolbarHeight() {
        AbstractC1762Lu abstractC1762Lu = this.A04;
        return abstractC1762Lu == null ? AbstractC1762Lu.A00 : abstractC1762Lu.getToolbarHeight();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        C1622Gb c1622Gb;
        if (C1693Iy.A1P(this.A0R) && this.A06 != null) {
            boolean z = configuration.orientation == 1;
            if (this.A02 != null && this.A04 != null) {
                this.A06.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                NT nt = this.A06;
                nt.setLayoutParams(nt.A0B(this.A03));
                if (z) {
                    layoutParams.setMargins(0, this.A04.getToolbarHeight(), 0, A0n);
                    layoutParams.addRule(2, this.A06.getId());
                } else {
                    int i = A0n;
                    layoutParams.setMargins(0, i, 0, i);
                    layoutParams.addRule(0, this.A03.getId());
                }
                this.A02.setLayoutParams(layoutParams);
            } else if (this.A09 != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                if (z) {
                    A0K();
                    layoutParams2.addRule(13);
                } else {
                    A0J();
                    layoutParams2.addRule(0, this.A03.getId());
                    layoutParams2.setMargins(0, 0, 0, 0);
                }
                this.A09.setLayoutParams(layoutParams2);
            }
        } else {
            NT nt2 = this.A06;
            if (A0k[1].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[2] = "taNSjGkhdG2DcrPTICkef1XKgKxpKPDd";
            strArr[2] = "taNSjGkhdG2DcrPTICkef1XKgKxpKPDd";
            if (nt2 != null) {
                nt2.A0D(configuration.orientation);
                if (this.A0h && (c1622Gb = this.A0E) != null) {
                    c1622Gb.A09(this.A06.A09(configuration.orientation));
                }
            }
        }
        this.A00 = configuration.orientation;
        A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        this.A0U.A03();
        A0V();
        LU lu = this.A09;
        if (lu != null) {
            lu.getEventBus().A05(this.A0X, this.A0Y, this.A0a, this.A0Z, this.A0b);
        }
        if (!TextUtils.isEmpty(this.A0P.A0Q())) {
            this.A0S.A8E(this.A0P.A0Q(), new NQ().A04(this.A0f).A03(this.A0V).A06());
        }
        AbstractC1762Lu abstractC1762Lu = this.A04;
        if (abstractC1762Lu != null) {
            abstractC1762Lu.setToolbarListener(null);
        }
        this.A0W.A0h();
        this.A09 = null;
        this.A06 = null;
        this.A0C = null;
        this.A05 = null;
        this.A0d.A09();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0V.A07(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = this.A06.getExpandableLayout();
        if (expandableLayout != null && this.A0h && z && this.A0E == null) {
            this.A0E = new C1622Gb(expandableLayout, 300, expandableLayout.getHeight(), 0);
            this.A0B.A0J(this.A0E);
            this.A0B.A0H();
        }
    }

    public void setListener(InterfaceC1767Lz interfaceC1767Lz) {
    }

    @VisibleForTesting
    public void setServerSideRewardHandler(C1820Ob c1820Ob) {
        this.A08 = c1820Ob;
    }

    private void setUpContentLayoutForVideo(int i) {
        this.A0N.removeAllViews();
        A0H();
        if (this.A06 != null) {
            C2026Wb c2026Wb = this.A0R;
            if (A0k[2].charAt(24) == 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[5] = "4i2csOaoNdqQlmOU4oeneSGIvSddu1uE";
            strArr[3] = "nuT450uQsQsD47HYSiniJ05GRT2hP0Qn";
            if (C1693Iy.A1P(c2026Wb)) {
                this.A0N.addView(this.A03);
                this.A0d.A0A(-1, A0t);
                if (i == 1) {
                    A0K();
                    this.A0N.addView(this.A09, A0r);
                } else {
                    A0J();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(0, this.A03.getId());
                    layoutParams.setMargins(0, 0, 0, 0);
                    this.A0N.addView(this.A09, layoutParams);
                }
                this.A0N.addView(this.A06);
            } else {
                this.A0N.addView(this.A09, A0r);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                this.A06.A0E(false);
                LX.A0N(this.A06);
                this.A06.A0D(i);
                NT nt = this.A06;
                int i2 = A0q;
                nt.setPadding(i2, i2, i2, i2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.A0h ? A0v : -2);
                if (this.A0h) {
                    int i3 = A0q;
                    layoutParams2.setMargins(i3, i3, i3, i3);
                    C1638Gs c1638Gs = this.A0d;
                    int i4 = A0w;
                    c1638Gs.setPadding(i4, i4, i4, i4);
                    this.A0d.A0A(-1, A0t);
                }
                layoutParams3.addRule(12);
                this.A0N.addView(this.A0d, layoutParams3);
                this.A0N.addView(this.A06, layoutParams2);
            }
        }
        int i5 = A0p;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i5, i5);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        int i6 = A0n;
        layoutParams4.setMargins(i6, getToolbarHeight() + i6, A0n, A0o);
        this.A0N.addView(this.A0c, layoutParams4);
        A0R();
    }
}
