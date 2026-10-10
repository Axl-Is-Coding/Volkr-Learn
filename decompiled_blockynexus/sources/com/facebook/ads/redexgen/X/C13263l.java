package com.facebook.ads.redexgen.X;

import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13263l {
    public static byte[] A06;
    public static String[] A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C4W A04;
    public C4W A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 94);
            if (A07[0].length() == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[4] = "AHVWCXL94tyjuu8jVJzYXjJpXDntUCwP";
            strArr[4] = "AHVWCXL94tyjuu8jVJzYXjJpXDntUCwP";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{-52, -64, 6, 18, ci.m, ci.k, -8, -35, -103, -115, -45, -33, -36, -38, -58, -86, -18, -30, 48, 39, 57, 10, 49, 46, 38, 39, 52, -1, -77, -89, -5, -10, -33, -60, -70, -82, 2, -3, -25, -53, -52, -15, -22, -9, -16, -18, -46, -9, -17, -8, 4, -8, -11, -19, -47, -8, -11, -19, -18, -5, -58};
    }

    public static void A02() {
        A07 = new String[]{"xh4Y4QcmM1wa5ldyXwFix7", "nmU7", "oStcn17TrhEMCT80qINsWqFBzeEgJkSk", "ejnuP30nVsgr2lyZF", "TwVj4lrjiRaSjHpnKGXYnUPcFE6raeBX", "wQpR2en2jkfHgW4", "pxsGGNitIZPjAkQbFzIWarOMOhpj3cU0", VipSubscribeStatus.SUBSCRIPTION_RESTARTED};
    }

    public C13263l(C4W c4w, C4W c4w2) {
        this.A05 = c4w;
        this.A04 = c4w2;
    }

    public C13263l(C4W c4w, C4W c4w2, int i, int i2, int i3, int i4) {
        this(c4w, c4w2);
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
    }

    public final String toString() {
        return A00(40, 21, 43) + this.A05 + A00(16, 12, 100) + this.A04 + A00(0, 8, 66) + this.A00 + A00(8, 8, 15) + this.A01 + A00(28, 6, 41) + this.A02 + A00(34, 6, 48) + this.A03 + '}';
    }
}
