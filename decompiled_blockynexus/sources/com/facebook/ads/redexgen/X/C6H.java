package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6H {
    public static byte[] A01;
    public static String[] A02;
    public static final String[] A03;
    public final float[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{21, -63, 7, -23, -33};
    }

    public static void A02() {
        A02 = new String[]{"GyiBUCkC", "sqowKkdsw23oOctujh4JS", "WS", "sGW2HqLA0299cVeMoAEL9ZXgIk1rlANi", "Ioat5RRD6XPbEJm7hsBEOKFMb", "Zw1v1TMFRqO", "eQUvG0dkOz1", "pYpbsacuB19XJGtGbFCxjlIFedam8DTp"};
    }

    static {
        A02();
        A01();
        A03 = new String[]{A00(2, 1, 93), A00(3, 1, 62), A00(4, 1, 51), A00(1, 1, 24)};
    }

    public C6H(float[] fArr) {
        this.A00 = fArr;
    }

    private final float[] A03() {
        return this.A00;
    }

    public final int A04() {
        return this.A00.length * 4;
    }

    public final JSONObject A05(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        int i = 0;
        while (true) {
            if (i >= this.A00.length) {
                break;
            }
            String[] strArr = A03;
            if (i < strArr.length) {
                jSONObject2.put(strArr[i], r3[i]);
            }
            i++;
        }
        if (A02[4].length() == 24) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "3DgDBkbuSJHHMnWd9lbj3dg5obl1cN";
        strArr2[5] = "3DgDBkbuSJHHMnWd9lbj3dg5obl1cN";
        jSONObject.put(A00(0, 1, 109), jSONObject2);
        return jSONObject;
    }

    public final boolean A06(C6H c6h) {
        float[] fArrA03 = c6h.A03();
        if (fArrA03.length != this.A00.length) {
            return false;
        }
        for (int i = 0; i < fArrA03.length; i++) {
            if (Math.abs(A03()[i] - fArrA03[i]) > C13815p.A01()) {
                return false;
            }
        }
        return true;
    }
}
