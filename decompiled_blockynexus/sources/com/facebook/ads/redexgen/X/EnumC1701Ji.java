package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSize;
import com.facebook.ads.internal.api.AdSizeApi;
import java.io.Serializable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ji, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1701Ji implements Serializable, AdSizeApi {
    A05(320, 50),
    A08(0, 0),
    A06(-1, 50),
    A07(-1, 90),
    A09(-1, 250);

    public static byte[] A02 = null;
    public static String[] A03 = null;
    public static final long serialVersionUID = 42;
    public final int A00;
    public final int A01;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A02 = new byte[]{-31, -32, -19, -19, -28, -15, -2, -46, -47, -49, -2, -44, -49, -54, -55, -42, -42, -51, -38, -25, -48, -51, -47, -49, -48, -36, -25, -67, -72, -78, -79, -66, -66, -75, -62, -49, -72, -75, -71, -73, -72, -60, -49, -87, -96, -40, -35, -29, -44, -31, -30, -29, -40, -29, -40, -48, -37, -94, -107, -109, -92, -111, -98, -105, -100, -107, -81, -104, -107, -103, -105, -104, -92, -81, -126, -123, -128, -51, -26, -29, -26, -25, -17, -26, -104, -71, -36, -53, -31, -14, -35, -104, -20, -15, -24, -35, -90};
    }

    public static void A05() {
        A03 = new String[]{"NYL1YQCqU8Gixm3Jp8vD7a2pRPzJmUnW", "snvVAOSVL4ktH0HtFHA4dTvXXYla1E6B", "RKsLS5q2cS0IRuJCPJ6xGuIAakz8g2BG", "QUCZbzbnKPS245Tw8RYBskyGMjuP2pyB", "ZOPXK3mvmjhBWd7", "KQA1bVf2RZtqvjex7q5bYVVXXiqadjY3", "eVCC3zJnJ4Hf6U7Nhns1G1PLJfclRjiw", "LavZjpKrW9zdCjT"};
    }

    static {
        A05();
        A04();
    }

    EnumC1701Ji(int i, int i2) {
        this.A01 = i;
        this.A00 = i2;
    }

    public static AdSizeApi A00(int i) {
        if (i == 4) {
            return A05;
        }
        if (i == 5) {
            return A06;
        }
        String[] strArr = A03;
        if (strArr[5].charAt(7) == strArr[2].charAt(7)) {
            String[] strArr2 = A03;
            strArr2[4] = "O3bLg7BXmjMliwd";
            strArr2[7] = "0XIufTpDjqr4Pnl";
            if (i == 6) {
                return A07;
            }
            String[] strArr3 = A03;
            if (strArr3[5].charAt(7) == strArr3[2].charAt(7)) {
                String[] strArr4 = A03;
                strArr4[4] = "iUpalDA9jS8RHtr";
                strArr4[7] = "fbM3x8JxLSeqT8D";
                if (i == 7) {
                    return A09;
                }
                if (i == 100) {
                    return A08;
                }
                throw new IllegalArgumentException(A03(77, 20, 59));
            }
        }
        throw new RuntimeException();
    }

    public static EnumC1701Ji A01(int i, int i2) {
        EnumC1701Ji enumC1701Ji = A08;
        if (enumC1701Ji.A00 == i2 && enumC1701Ji.A01 == i) {
            return enumC1701Ji;
        }
        EnumC1701Ji enumC1701Ji2 = A05;
        if (enumC1701Ji2.A00 == i2 && enumC1701Ji2.A01 == i) {
            return enumC1701Ji2;
        }
        EnumC1701Ji enumC1701Ji3 = A06;
        if (enumC1701Ji3.A00 == i2 && enumC1701Ji3.A01 == i) {
            return enumC1701Ji3;
        }
        EnumC1701Ji enumC1701Ji4 = A07;
        if (A03[0].charAt(2) == '3') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "NIHeFjUj66aWgLiN3zabDQWnsYuMdgze";
        strArr[1] = "NIHeFjUj66aWgLiN3zabDQWnsYuMdgze";
        if (enumC1701Ji4.A00 == i2 && enumC1701Ji4.A01 == i) {
            return enumC1701Ji4;
        }
        EnumC1701Ji enumC1701Ji5 = A09;
        if (enumC1701Ji5.A00 == i2 && enumC1701Ji5.A01 == i) {
            return enumC1701Ji5;
        }
        return null;
    }

    public static EnumC1701Ji A02(AdSize adSize) {
        return A01(adSize.getWidth(), adSize.getHeight());
    }

    public final AdSize A06() {
        return AdSize.fromWidthAndHeight(this.A01, this.A00);
    }

    @Override // com.facebook.ads.internal.api.AdSizeApi
    public final int getHeight() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.AdSizeApi
    public final int getWidth() {
        return this.A01;
    }
}
