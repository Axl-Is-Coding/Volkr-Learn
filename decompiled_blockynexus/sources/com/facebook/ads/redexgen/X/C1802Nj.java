package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1802Nj {
    public static final int A00 = LX.A02.heightPixels;
    public static final int A01 = LX.A02.widthPixels;

    public static float A00(AnonymousClass18 anonymousClass18) {
        int iA01 = anonymousClass18.A0E().A01();
        int height = anonymousClass18.A0E().A00();
        if (height > 0) {
            return iA01 / height;
        }
        return -1.0f;
    }

    public static int A01(double d2) {
        return (int) (((double) (A01 - (AbstractC1803Nk.A09 * 2))) / d2);
    }

    public static int A02(int ctaTextHeight) {
        int ctaMargin = LX.A01(16);
        int i = NZ.A0B * 2;
        int ctaSpacing = AbstractC1803Nk.A09;
        int ctaMargin2 = ctaMargin + i + (ctaSpacing * 2);
        int bottomMargin = A00;
        return (bottomMargin - ctaTextHeight) - ctaMargin2;
    }

    public static boolean A03(double d2) {
        return d2 < 0.9d;
    }

    public static boolean A04(double d2, int i) {
        return A02(i) < A01(d2);
    }

    public static boolean A05(int i, int i2, double d2) {
        return i == 2 || A04(d2, i2);
    }
}
