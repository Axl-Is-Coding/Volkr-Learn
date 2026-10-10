package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7A {
    public static int A00;
    public static int A01;
    public static int A02;
    public static int A03;
    public static int A04;
    public static int A05;
    public static int A06;
    public static int A07;
    public static byte[] A08;
    public static final String A09;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-120, -90, -88, -83, -86, 101, -87, -82, -72, -80, 101, -85, -90, -82, -79, -70, -73, -86, 115, -63, -33, -31, -26, -29, -98, -30, -25, -15, -23, -98, -15, -13, -31, -31, -29, -15, -15, -84, -63, -33, -31, -26, -29, -98, -30, -19, -11, -20, -22, -19, -33, -30, -98, -28, -33, -25, -22, -13, -16, -29, -84, -127, -97, -95, -90, -93, 94, -90, -89, -78, 108, -72, -42, -40, -35, -38, -107, -30, -34, -24, -24, -93, -83, -80, -85, -81, -66, -79, -83, -64, -75, -62, -79, -85, -65, -75, -58, -79, -85, -82, -59, -64, -79, -65, -55, -52, -57, -53, -38, -51, -55, -36, -47, -34, -51, -57, -36, -31, -40, -51, -95, -92, -97, -90, -81, -78, -83, -95, -76, -97, -76, -71, -80, -91, 21, 24, 19, 38, 25, 37, 41, 25, 39, 40, 19, 29, 24, -79, -60, -60, -75, -67, -64, -60, -78, -80, -78, -73, -76, 24, 22, 24, 29, 26, 20, 24, 36, 35, 41, 26, 45, 41, -50, -55, -47, -44, -35, -38, -51, -57, -38, -51, -55, -37, -41, -42, 22, 26, ci.l, 20, 18, 11, ci.l, 0, 3, -2, 19, 8, 12, 4, 5, 2, -4};
    }

    static {
        A01();
        A09 = C7A.class.getSimpleName();
        A05 = C8Y.A0d;
        A06 = C8Y.A0h;
        A02 = C8Y.A0a;
        A01 = C8Y.A0Z;
        A03 = C8Y.A0b;
        A00 = C8Y.A0X;
        A04 = C8Y.A0c;
        A07 = C8Y.A0i;
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02(AnonymousClass87 anonymousClass87, AnonymousClass70 anonymousClass70, int i, String str, long j) {
        if (!A06(anonymousClass87)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), anonymousClass70.A00);
            jSONObject.put(A00(134, 13, 118), anonymousClass70.A01);
            if (j > 0) {
                jSONObject.put(A00(191, 9, 97), LP.A06(System.currentTimeMillis() - j));
            }
            C8Z c8z = new C8Z(str);
            c8z.A05(jSONObject);
            c8z.A03(1);
            anonymousClass87.A04().A8I(A00(154, 5, 17), i, c8z);
        } catch (Throwable th) {
            anonymousClass87.A04().A3S(th);
        }
    }

    public static void A03(AnonymousClass87 anonymousClass87, AnonymousClass74 anonymousClass74, String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l) {
        if (A06(anonymousClass87)) {
            A05(anonymousClass87, anonymousClass74.A05, anonymousClass74.A06, anonymousClass74.A07, A00(186, 5, 111), str, i, str2, num, l, null);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A04(AnonymousClass87 anonymousClass87, AnonymousClass79 anonymousClass79, boolean z) {
        if (!A06(anonymousClass87)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), anonymousClass79.A00);
            jSONObject.put(A00(134, 13, 118), anonymousClass79.A03);
            jSONObject.put(A00(104, 16, 42), anonymousClass79.A02);
            jSONObject.put(A00(159, 13, 119), anonymousClass79.A01);
            if (C1693Iy.A1K(anonymousClass87)) {
                jSONObject.put(A00(200, 3, 82), anonymousClass79.A04);
            }
            String strA00 = z ? A00(61, 10, 0) : A00(71, 11, 55);
            int i = z ? A05 : A06;
            C8Z c8z = new C8Z(strA00);
            c8z.A05(jSONObject);
            c8z.A03(1);
            anonymousClass87.A04().A8I(A00(154, 5, 17), i, c8z);
        } catch (Throwable th) {
            anonymousClass87.A04().A3S(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A05(AnonymousClass87 anonymousClass87, String str, String str2, String str3, String str4, String str5, int i, @Nullable String str6, @Nullable Integer num, @Nullable Long l, @Nullable Integer num2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), str);
            jSONObject.put(A00(134, 13, 118), str2);
            jSONObject.put(A00(104, 16, 42), str4);
            if (str6 != null) {
                jSONObject.put(A00(172, 14, 42), str6);
            }
            if (num != null) {
                jSONObject.put(A00(82, 22, 14), String.valueOf(num));
            }
            if (l != null) {
                jSONObject.put(A00(191, 9, 97), String.valueOf(l));
            }
            if (num2 != null) {
                jSONObject.put(A00(147, 7, 18), String.valueOf(num2));
            }
            jSONObject.put(A00(159, 13, 119), str5);
            if (C1693Iy.A1K(anonymousClass87)) {
                jSONObject.put(A00(200, 3, 82), str3);
            }
            String strA00 = A00(19, 19, 64);
            if (i == A03) {
                strA00 = A00(38, 23, 64);
            } else if (i == A01) {
                strA00 = A00(0, 19, 7);
            }
            C8Z c8z = new C8Z(strA00);
            c8z.A05(jSONObject);
            c8z.A03(1);
            anonymousClass87.A04().A8I(A00(154, 5, 17), i, c8z);
        } catch (Throwable th) {
            anonymousClass87.A04().A3S(th);
        }
    }

    public static boolean A06(AnonymousClass87 anonymousClass87) {
        int iA06;
        if (anonymousClass87.A03().A7l()) {
            iA06 = 1;
        } else {
            iA06 = J0.A06(anonymousClass87);
        }
        if (iA06 == 0) {
            return false;
        }
        return iA06 <= 0 || anonymousClass87.A05().A00() <= 1.0d / ((double) iA06);
    }
}
