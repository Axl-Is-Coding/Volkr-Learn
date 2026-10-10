package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TG implements C5Q {
    public static byte[] A02;
    public static String[] A03;
    public final C5R A00;
    public final String A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{5, 10, 1, -10, 78, 75, 69};
    }

    public static void A03() {
        A03 = new String[]{"TFthAsyh9DXeOXmOSrI", "6fWFj2GuIp8edYChPrJEmZ0EGdAH52zr", "1W8BLXCecsGswLg5J6ItB4TJ0IeP92", "LJOYl73w1qtKK7uJcnV", "z6IkqPokH6efARGWKazebLzdy8d5mCY", "2wZEZTk79zqBVt75gMVieTbdYLiT7Zir", "bDoQVkMDKn3JHFmlXSVDRiBYbpx4sGCA", "L28Z4g4sdLlGf5SKMowSfgQKz11TtxJ4"};
    }

    public TG(C5R c5r, String str) {
        this.A00 = c5r;
        this.A01 = str;
    }

    @Nullable
    public static TG A00(JSONObject jSONObject) {
        C5R c5rA00 = C5R.A00(jSONObject.optString(A01(0, 4, 21)));
        String strOptString = jSONObject.optString(A01(4, 3, 93));
        if (c5rA00 != null && strOptString != null) {
            return new TG(c5rA00, strOptString);
        }
        String[] strArr = A03;
        String str = strArr[7];
        String url = strArr[5];
        if (str.charAt(27) != url.charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "YX1kth4";
        strArr2[2] = "YX1kth4";
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C5Q
    public final C5R A7I() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        if (r4 != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        if (r4 != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        r7 = (com.facebook.ads.redexgen.X.TG) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        if (r6.A00 == r7.A00) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        return r6.A01.equals(r7.A01);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            if (r6 != r7) goto L23
            r3 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.TG.A03
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L16
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L16:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.TG.A03
            java.lang.String r1 = "7vOCIJjJCX9CoY0eg8O"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "3BsZIpiI9Segj8T9GPE"
            r0 = 3
            r2[r0] = r1
            return r3
        L23:
            r5 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.TG.A03
            r0 = 7
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L3e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.TG.A03
            java.lang.String r1 = "CUYUmjEQroJXgi3huLe"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "AnYHMDp1ebtK81SsggF"
            r0 = 3
            r2[r0] = r1
            if (r7 == 0) goto L6f
            java.lang.Class r4 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.TG.A03
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L70
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.TG.A03
            java.lang.String r1 = "McBoxOwAJvKvGI9HKqBnGpNAZAcduNL"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "McBoxOwAJvKvGI9HKqBnGpNAZAcduNL"
            r0 = 4
            r2[r0] = r1
            if (r4 == r3) goto L73
        L6f:
            return r5
        L70:
            if (r4 == r3) goto L73
            goto L6f
        L73:
            com.facebook.ads.redexgen.X.TG r7 = (com.facebook.ads.redexgen.X.TG) r7
            com.facebook.ads.redexgen.X.5R r1 = r6.A00
            com.facebook.ads.redexgen.X.5R r0 = r7.A00
            if (r1 == r0) goto L7c
            return r5
        L7c:
            java.lang.String r1 = r6.A01
            java.lang.String r0 = r7.A01
            boolean r0 = r1.equals(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.TG.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C5Q
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }
}
