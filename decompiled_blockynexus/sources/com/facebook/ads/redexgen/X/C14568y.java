package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14568y {
    public static HashMap<String, String> A00;
    public static byte[] A01;
    public static String[] A02;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{Utf8.REPLACEMENT_BYTE, 46, 46, 60, 43, 55, 50, 58, 118, 103, 103, 121, 118, 122, 114, 27, 10, 10, 12, 31, 8, 9, ci.k, 34, 40, 62, 35, 37, 40, 32, 55, 44, 38, 46, 39, ci.k, ci.m, 4, 5, 12, 53, 41, 121, 101, 96, 115, 100, 101, 114, 101, 106, 126, 105, 102, 114, 123, 104, 127, 126, 100, 98, 99, 1, 23, 1, 1, 27, 29, 28, ci.k, 27, 22, 53, 58, 48, 38, 59, 61, 48};
    }

    public static void A04() {
        A02 = new String[]{"khEJJSEBeZAj3OAxCgzNidlYCZn1WdrQ", "WigI19L", "nVQbXZzkIzZCm6ed4Wwsa9gCOy", "HTplkKsJZ28QwTvwNKGrQ1qXfC2z", "xAVvuzXwzMicNcIETZjP5vM2paYATPUF", "ZQBu7F3mQUfNW6aD", "dGQdYWCLx", "hFrznfqGyDFETBry94BNLT7Zi42G"};
    }

    public static synchronized Map<String, String> A01(AnonymousClass87 anonymousClass87) {
        if (A00 != null) {
            return new HashMap(A00);
        }
        A00 = new HashMap<>();
        A00.put(A00(29, 6, 7), anonymousClass87.getPackageName());
        A02(anonymousClass87, A00);
        HashMap map = new HashMap(A00);
        if (A02[6].length() != 9) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN";
        strArr[4] = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN";
        return map;
    }

    public static synchronized Map<String, String> A02(AnonymousClass87 anonymousClass87, Map<String, String> map) {
        map.put(A00(48, 3, 68), A00(72, 7, 49));
        map.put(A00(51, 11, 72), BuildConfigApi.getVersionName(anonymousClass87));
        map.put(A00(40, 2, 31), A00(22, 7, 41));
        map.put(A00(42, 6, 83), C14418i.A03);
        C14418i c14418i = new C14418i(anonymousClass87);
        map.put(A00(15, 7, 63), c14418i.A06());
        map.put(A00(8, 7, 82), c14418i.A05());
        map.put(A00(0, 8, 27), String.valueOf(c14418i.A04()));
        map.put(A00(35, 5, 37), c14418i.A0A());
        map.put(A00(62, 10, 55), anonymousClass87.A05().A02());
        return map;
    }
}
