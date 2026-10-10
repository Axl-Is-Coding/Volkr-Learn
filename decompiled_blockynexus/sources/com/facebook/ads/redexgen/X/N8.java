package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N8 {
    public static byte[] A08;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final String A07;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{5, ci.l, 12, 62, 2, ci.l, ci.m, 21, 4, ci.m, 21, 62, ci.k, ci.l, 0, 5, 4, 5, 62, 12, 18, 56, 49, 62, 52, 60, 53, 34, ci.m, 36, 57, 61, 53, ci.m, 61, 35, 24, 31, 24, 5, 24, ci.n, 29, 46, 4, 3, 29, 71, 68, 74, 79, 116, 77, 66, 69, 66, 88, 67, 116, 70, 88, ci.n, 19, 29, 24, 35, ci.m, 8, 29, ci.l, 8, 35, 17, ci.m, 66, 85, 67, 64, 95, 94, 67, 85, 111, 85, 94, 84, 111, 93, 67, 59, 43, 58, 39, 36, 36, 23, 58, 45, 41, 44, 49, 23, 37, 59, 40, 62, 40, 40, 50, 52, 53, 4, 61, 50, 53, 50, 40, 51, 4, 54, 40};
    }

    public N8(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.A07 = str;
        this.A01 = j;
        this.A03 = j2;
        this.A04 = j3;
        this.A00 = j4;
        this.A05 = j5;
        this.A02 = j6;
        this.A06 = j7;
    }

    public final Map<String, String> A02() {
        HashMap map = new HashMap(7);
        map.put(A00(36, 11, 96), this.A07);
        map.put(A00(21, 15, 65), String.valueOf(this.A01));
        map.put(A00(61, 13, 109), String.valueOf(this.A03));
        map.put(A00(74, 15, 33), String.valueOf(this.A04));
        map.put(A00(0, 21, 112), String.valueOf(this.A00));
        map.put(A00(89, 15, 89), String.valueOf(this.A05));
        map.put(A00(47, 14, 58), String.valueOf(this.A02));
        map.put(A00(104, 17, 74), String.valueOf(this.A06));
        return map;
    }
}
