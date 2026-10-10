package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Sf extends AbstractC1803Nk {
    public static byte[] A06;
    public static String[] A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public HY A00;

    @Nullable
    public C1622Gb A01;
    public GW A02;
    public final AnonymousClass15 A03;
    public final AnonymousClass18 A04;
    public final NT A05;

    public static String A0K(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0L() {
        A06 = new byte[]{9, 5, 7, 68, 12, 11, 9, ci.m, 8, 5, 5, 1, 68, 11, ci.l, 25, 68, 3, 4, 30, ci.m, 24, 25, 30, 3, 30, 3, 11, 6, 68, 9, 6, 3, 9, 1, ci.m, ci.l, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    public static void A0M() {
        A07 = new String[]{"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    }

    static {
        A0M();
        A0L();
        A0B = (int) (LX.A01 * 48.0f);
        A0F = (int) (LX.A01 * 16.0f);
        A08 = (int) (LX.A01 * 4.0f);
        A0E = (int) (LX.A01 * 44.0f);
        A0C = (int) (LX.A01 * 8.0f);
        A0D = (int) (LX.A01 * 12.0f);
        A0H = (int) (LX.A01 * 12.0f);
        A0G = (int) (LX.A01 * 26.0f);
        A09 = C2F.A01(-1, 77);
        A0A = C2F.A01(A09, 90);
    }

    public Sf(C1807No c1807No, boolean z) {
        super(c1807No, z);
        this.A03 = c1807No.A04();
        this.A04 = this.A03.A0M();
        this.A05 = A0J(c1807No);
        AbstractC1762Lu abstractC1762LuA08 = c1807No.A08();
        if (abstractC1762LuA08 != null) {
            abstractC1762LuA08.setLayoutParams(new RelativeLayout.LayoutParams(-1, abstractC1762LuA08.getToolbarHeight()));
            abstractC1762LuA08.setPageDetailsVisible(false);
        }
    }

    private NT A0J(C1807No c1807No) {
        String strA0K;
        NT c2028Wd;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (c1807No.A04().A0T().equals(A0K(37, 14, 56))) {
            strA0K = EnumC1836Or.A04.A02();
        } else {
            if (A07[3].charAt(14) != '2') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "WUaGuSp4tuIpD6iTfwLrbbBI";
            strArr[5] = "WUaGuSp4tuIpD6iTfwLrbbBI";
            strA0K = A0K(0, 37, 124);
        }
        if (C1693Iy.A1P(c1807No.A05())) {
            c2028Wd = new C2116Zq(c1807No.A05(), A0B, getColors(), strA0K, c1807No.A06(), c1807No.A09(), c1807No.A0B(), c1807No.A07());
            layoutParams.setMargins(AbstractC1803Nk.A09, 0, AbstractC1803Nk.A09, AbstractC1803Nk.A09);
        } else {
            c2028Wd = new C2028Wd(c1807No.A05(), A0B, this.A04.A0F().A00() == C1D.A05, getColors(), strA0K, c1807No.A06(), c1807No.A09(), c1807No.A0B(), c1807No.A07());
            this.A02 = new GW(c2028Wd, 400, 100, 0);
        }
        LX.A0N(c2028Wd);
        c2028Wd.A0D(c1807No.A00());
        addView(c2028Wd, layoutParams);
        return c2028Wd;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        super.A0a(anonymousClass18, str, d2, bundle);
        this.A05.setInfo(anonymousClass18.A0F(), anonymousClass18.A0G(), str, this.A03.A0O().A01(), null);
    }

    public final int A0d(@Nullable AbstractC1762Lu abstractC1762Lu) {
        return abstractC1762Lu == null ? AbstractC1762Lu.A00 : abstractC1762Lu.getToolbarHeight();
    }

    public void A0e() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            this.A00 = new HY(true);
            C1622Gb c1622Gb = this.A01;
            if (c1622Gb != null) {
                HY hy = this.A00;
                if (A07[0].charAt(30) == 'l') {
                    throw new RuntimeException();
                }
                String[] strArr = A07;
                strArr[7] = "KTvg88bTO6HmKn15GgbH1";
                strArr[7] = "KTvg88bTO6HmKn15GgbH1";
                hy.A0J(c1622Gb);
            }
            C1G c1gA01 = this.A03.A0L().A01();
            this.A00.A0J(new GX(getAdDetailsView().getCTAButton(), 300, -1, c1gA01.A09(true)));
            this.A00.A0J(new C1623Gc(getAdDetailsView().getCTAButton(), 300, LX.A09(A09, A0A, A08), LX.A06(c1gA01.A08(true), A08)));
            this.A00.A0J(new GY(expandableLayout, 150, false));
            this.A00.A0I(2300);
        }
    }

    public AnonymousClass15 getAdDataBundle() {
        return this.A03;
    }

    public GW getAdDetailsAnimation() {
        return this.A02;
    }

    public NT getAdDetailsView() {
        return this.A05;
    }

    public AnonymousClass18 getAdInfo() {
        return this.A04;
    }

    public HY getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0D(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout == null || !z) {
            return;
        }
        C1622Gb c1622Gb = this.A01;
        if (A07[2].charAt(30) != '4') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        strArr[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        if (c1622Gb == null) {
            this.A01 = new C1622Gb(expandableLayout, 300, expandableLayout.getHeight(), 0);
            this.A00.A0J(this.A01);
            this.A00.A0H();
        }
    }
}
