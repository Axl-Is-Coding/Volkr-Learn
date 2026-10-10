package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6J {
    public static byte[] A07;
    public static String[] A08;
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final float[] A06;

    static {
        A08();
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-42, -57, -61, -21, -32, -39, -47, 124, 119, -120, -124, -90, -91, -99, -99, -12, -124, -95};
    }

    public static void A08() {
        A08 = new String[]{"Ri7kjkDT8eD7oXZRfiWmTVhv1RjvdWrO", "cxDqg6Vwj60LwY1YIKiyT4H3eIxAUSyl", "eaEWTtVE1fja", "mvH1Awv1nxYu8upPSugfMtSiNjBS99Ai", "3uMupHsAkG9zmQtrmqj", "34ahGknslOLL", "L7UqFynmPX3bSDpWCs3", "GT67L7E4GYLk"};
    }

    public C6J(int i, int i2, int i3, float[] fArr, float f2, float f3, float f4) {
        this.A05 = i;
        this.A03 = i2;
        this.A04 = i3;
        this.A06 = fArr;
        this.A02 = f2;
        this.A01 = f3;
        this.A00 = f4;
    }

    private final float A00() {
        return this.A00;
    }

    private final float A01() {
        return this.A01;
    }

    private final float A02() {
        return this.A02;
    }

    private final int A03() {
        return this.A03;
    }

    private final int A04() {
        return this.A04;
    }

    private final int A05() {
        return this.A05;
    }

    private final float[] A09() {
        return this.A06;
    }

    public final int A0A() {
        return 32;
    }

    public final JSONObject A0B(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A06(0, 3, 95), this.A05);
        jSONObject2.put(A06(3, 2, 116), this.A03);
        jSONObject2.put(A06(13, 2, 38), this.A04);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(A06(16, 1, 9), C14136w.A00(this.A06[0]));
        jSONObject3.put(A06(17, 1, 37), C14136w.A00(this.A06[1]));
        jSONObject2.put(A06(5, 2, 98), jSONObject3);
        jSONObject2.put(A06(11, 2, 47), C14136w.A00(this.A02));
        jSONObject2.put(A06(9, 2, 17), C14136w.A00(this.A01));
        jSONObject2.put(A06(7, 2, 5), C14136w.A00(this.A00));
        jSONObject.put(A06(15, 1, 123), jSONObject2);
        return jSONObject;
    }

    public final boolean A0C(C6J c6j) {
        if (A05() == c6j.A05() && A03() == c6j.A03() && A04() == c6j.A04()) {
            float fAbs = Math.abs(A09()[0] - c6j.A09()[0]);
            String[] strArr = A08;
            if (strArr[0].charAt(29) != strArr[3].charAt(29)) {
                String[] strArr2 = A08;
                strArr2[6] = "Q56kdX7pfJkTmJKAWug";
                strArr2[4] = "SmNIYc6TXNif2amUYYL";
                if (fAbs < C13815p.A01() && Math.abs(A09()[1] - c6j.A09()[1]) < C13815p.A01()) {
                    float fAbs2 = Math.abs(A02() - c6j.A02());
                    float fA01 = C13815p.A01();
                    String[] strArr3 = A08;
                    if (strArr3[7].length() != strArr3[2].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A08;
                    strArr4[6] = "PKTdm45ZSsz2a1wWaXr";
                    strArr4[4] = "Kjnff0uul5Scqwkbf9l";
                    if (fAbs2 < fA01 && Math.abs(A01() - c6j.A01()) < C13815p.A01() && Math.abs(A00() - c6j.A00()) < C13815p.A01()) {
                        return true;
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }
}
