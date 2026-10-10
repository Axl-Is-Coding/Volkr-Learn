package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OX {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 93);
            String[] strArr = A01;
            if (strArr[3].charAt(25) == strArr[4].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "ZkkNqMbSq2X5uLLX3N";
            strArr2[7] = "ZkkNqMbSq2X5uLLX3N";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{18, 10, 12, 10, 12, -38, 7, -3, 11, 8, 2, -3, 34, 49, 49, 32, 47, 34, 46, 38, 42, 43, 60, 47, 41, 43, 37, 51, 53, 42, 43, 50, 69, 72, 60, 58, 69, 62, 50, 54, 33, 37, 17, 40, 23, 36, -14, -29, -12, -10, -16, -25, -12, -31, -25, -16, -26, -14, -15, -21, -16, -10, 10, 6, -5, 19, -5, -4, 6, -1, -7, 8, -5, 7, -1, -22, -38, -23, -36, -36, -27, -42, -33, -36, -32, -34, -33, -21, -48, -64, -49, -62, -62, -53, -68, -44, -58, -63, -47, -59, ci.k, -2, 5, -7, ci.n, -1, 12, ci.k, 3, 9, 8, 1, -13, 1, 1, -9, -3, -4, -19, -9, -14};
    }

    public static void A03() {
        A01 = new String[]{"FlapraKYinr7Nj6zb2x", "Je7Oc75DeV26JYLGdoAYQBFZl5wXaWlc", "6eSxJX", "aEepWtzNMaW6JZj4waJ23HNf2aIS7LoC", "JwlyhY0m7wRpvvwBZvP15fqQyn91MpTE", "PlE1oLNOrYKtW3AWK6zlObYGaKJphnE8", "QTcNGp4T1DOVQL9", "izKSydL2onnSjNYNNJlTpUx2BXz"};
    }

    public static Map<String, String> A01(AnonymousClass87 anonymousClass87, String str, String str2) {
        HashMap map = new HashMap();
        C14418i c14418i = new C14418i(anonymousClass87);
        int i = anonymousClass87.getResources().getDisplayMetrics().widthPixels;
        int i2 = anonymousClass87.getResources().getDisplayMetrics().heightPixels;
        map.put(A00(111, 10, 49), anonymousClass87.A05().A02());
        map.put(A00(62, 13, 61), str2);
        map.put(A00(46, 16, 37), str);
        map.put(A00(20, 12, 105), String.valueOf(c14418i.A09()));
        map.put(A00(88, 12, 0), String.valueOf((int) (i / LX.A01)));
        map.put(A00(75, 13, 26), String.valueOf((int) (i2 / LX.A01)));
        map.put(A00(38, 2, 102), A00(5, 7, 60));
        map.put(A00(40, 6, 85), C14418i.A03);
        map.put(A00(32, 6, 124), Locale.getDefault().toString());
        map.put(A00(100, 11, 61), A00(0, 5, 127));
        map.put(A00(12, 8, 100), c14418i.A05());
        return map;
    }
}
