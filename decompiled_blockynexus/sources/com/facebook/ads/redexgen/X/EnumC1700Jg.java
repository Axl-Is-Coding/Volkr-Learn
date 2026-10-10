package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1700Jg {
    A06,
    A02,
    A03,
    A04,
    A05;

    public static byte[] A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{ci.l, ci.k, 26, 26, 17, 30, 8, ci.k, 19, 4, 17, 18, 19, 8, 19, 8, 0, 11, -58, -71, -52, -63, -50, -67, -18, -31, -13, -35, -18, -32, -31, -32, -5, -14, -27, -32, -31, -21, -34, -41, -44, -41, -40, -32, -41};
    }

    static {
        A02();
    }

    public static EnumC1700Jg A00(EnumC1702Jj enumC1702Jj) {
        switch (enumC1702Jj) {
            case A05:
                return A04;
            case A09:
            case A0A:
            case A0B:
            case A08:
                return A02;
            case A0C:
            case A0F:
            case A0D:
            case A0E:
                return A03;
            case A06:
                return A05;
            default:
                return A06;
        }
    }

    public final AdPlacementType A03() {
        int i = C1699Jf.A00[ordinal()];
        if (i == 1) {
            return AdPlacementType.INTERSTITIAL;
        }
        if (i == 2) {
            return AdPlacementType.BANNER;
        }
        if (i == 3) {
            return AdPlacementType.NATIVE;
        }
        if (i != 4) {
            return AdPlacementType.UNKNOWN;
        }
        return AdPlacementType.REWARDED_VIDEO;
    }
}
