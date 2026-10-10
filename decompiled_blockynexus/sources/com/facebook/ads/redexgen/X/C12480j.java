package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12480j {
    public static byte[] A06;
    public static String[] A07;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final List<String> A05;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{67, 82, 82, 81, 75, 86, 71, 97, 112, 112, 115, 105, 116, 101, 95, 117, 114, 108, 38, 33, 44, 44, 34, 33, 35, 43, 31, 53, 50, 44, 5, 11, 23, 49, 6, ci.m, 29, 6, 11, 29, 122, 118, 101, 124, 114, 99, 72, 98, 101, 126, 26, 11, 9, 1, 11, ci.k, ci.m};
    }

    public static void A03() {
        A07 = new String[]{"DvSn6PhmC3i7LdpG0vBUuRZmjagS5as7", "VQCZ7hz", "zA4klKNJM0QxWDxEFTSTi5yKhMV68", "2vimyyNbMv6AohadWhJSDQSQPpWOARjH", "MVolmMMkLKfWmTv", "tHNO368kkNAVpLeIneqpL6ODf8V7me71", "x8Jgc8MGjZsmc", "KvaBSJwcdZeuQnxX6yqoEJJZ8c4KCJ2u"};
    }

    public C12480j(String str, String str2, String str3, List<String> mKeyHashes, String str4, String str5) {
        this.A04 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A05 = mKeyHashes;
        this.A03 = str4;
        this.A02 = str5;
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0044 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C12480j A00(org.json.JSONObject r10) {
        /*
            if (r10 != 0) goto L4
            r0 = 0
            return r0
        L4:
            r2 = 50
            r1 = 7
            r0 = 38
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r5 = r10.optString(r0)
            r2 = 0
            r1 = 7
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r6 = r10.optString(r0)
            r2 = 7
            r1 = 11
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r7 = r10.optString(r0)
            r2 = 30
            r1 = 10
            r0 = 34
            java.lang.String r0 = A01(r2, r1, r0)
            org.json.JSONArray r4 = r10.optJSONArray(r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r4 == 0) goto L71
            r3 = 0
        L40:
            int r0 = r4.length()
            if (r3 >= r0) goto L71
            java.lang.String r0 = r4.optString(r3)
            r8.add(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C12480j.A07
            r0 = 5
            r1 = r1[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            r0 = 78
            if (r1 == r0) goto L62
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L62:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C12480j.A07
            java.lang.String r1 = "wfKFQtpS7p7Zsd7MRi5uYuHrlLf6T"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "wfKFQtpS7p7Zsd7MRi5uYuHrlLf6T"
            r0 = 2
            r2[r0] = r1
            int r3 = r3 + 1
            goto L40
        L71:
            r2 = 40
            r1 = 10
            r0 = 91
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r9 = r10.optString(r0)
            r2 = 18
            r1 = 12
            r0 = 12
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r10 = r10.optString(r0)
            com.facebook.ads.redexgen.X.0j r4 = new com.facebook.ads.redexgen.X.0j
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12480j.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.0j");
    }

    public final String A04() {
        return this.A00;
    }

    public final String A05() {
        return this.A01;
    }

    public final String A06() {
        return this.A04;
    }
}
