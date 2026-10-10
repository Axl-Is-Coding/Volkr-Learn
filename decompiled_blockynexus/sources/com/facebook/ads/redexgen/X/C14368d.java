package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14368d {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            if (A01[1].charAt(1) == 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "1M2Y98BwTvEPUGLlCwxj254fliWahs1n";
            strArr[0] = "azYACSqPfJkxfvivKERNz1YXvsYHtm8K";
            bArrCopyOfRange[i4] = (byte) (i5 - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-47, -12, -20, -20, -18, -13, -20, -91, -45, -22, -7, -4, -12, -9, -16, -91, -54, -5, -22, -13, -7, -52, -35, -38, -55, -36, -47, -41, -42, 28, 41, 41, 38, 41, -9, 3, 3, -1, -18, 2, 3, -16, 3, 4, 2, -18, -14, -2, -13, -12, 22, ci.k, 28, 31, 23, 26, 19, -38, -53, -29, -42, -39, -53, -50, -55, -35, -45, -28, -49, ci.m, ci.n, -3, ci.l, ci.n, -5, ci.n, 5, 9, 1, -40, -45, -49, -46, -60, -57, -62, -42, -52, -35, -56};
    }

    public static void A03() {
        A01 = new String[]{"a6IxlCkVmcf1QOD6ZYjDV7INHBfwC5pE", "pjHGmgbtiOqji60ouNqSwKm8iDwdL2il", "jT1wBn6CKnjHaXeX1", "64rNhN6ZFhDWGxpIQ", "ze8vByysvbBiliYVuotBM6Di85tpEUzv", "oRRmyqjSmqskFAvbDRZ10d57ZrKFDjEI", "44vbl6FfanMIMy7ytQNCDD1eXfOrnFTF", "rkbwsxy0OcV7GrP7ELmdkRDeQR2uGuGh"};
    }

    public static JSONObject A01(AnonymousClass87 anonymousClass87, long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 88), j);
                try {
                    jSONObject.put(A00(21, 8, 36), j2 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 38), j3);
                        try {
                            jSONObject.put(A00(79, 11, 31), j4);
                            try {
                                jSONObject.put(A00(34, 16, 75), i);
                                if (exc != null) {
                                    jSONObject.put(A00(29, 5, 115), exc.getMessage());
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                anonymousClass87.A04().A3S(e);
                            }
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                    }
                } catch (JSONException e5) {
                    e = e5;
                }
            } catch (JSONException e6) {
                e = e6;
            }
        } catch (JSONException e7) {
            e = e7;
        }
        return jSONObject;
    }

    public static void A04(AnonymousClass87 anonymousClass87, long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        C8Z c8z = new C8Z(A00(0, 21, 65));
        c8z.A03(1);
        c8z.A05(A01(anonymousClass87, j, j2, j3, j4, i, exc));
        anonymousClass87.A04().A8f(A00(50, 7, 100), C8Y.A1g, c8z);
    }
}
