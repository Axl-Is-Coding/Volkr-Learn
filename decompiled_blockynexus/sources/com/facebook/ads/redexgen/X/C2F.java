package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2F {
    public static byte[] A00;
    public static String[] A01;
    public static final ThreadLocal<double[]> A02;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-104, -93, -89, -97, -104, 87, -92, -84, -86, -85, 87, -103, -100, 87, -103, -100, -85, -82, -100, -100, -91, 87, 103, 87, -104, -91, -101, 87, 105, 108, 108, 101, -59, -53, -54, -82, -49, -48, 118, -61, -53, -55, -54, 118, -66, -73, -52, -69, 118, -73, 118, -62, -69, -60, -67, -54, -66, 118, -59, -68, 118, -119, -124};
    }

    public static void A05() {
        A01 = new String[]{"5xFyhJyAmXwpndJ9EoKqTFqqLI0O0t2g", "XKBE22ujheeLcTYagdBtfv4d5l35c1GL", "dLXeMiu6Rni", "1iBW7", "i8dAz", "3kaHypJVzQjnFbgNDhrnWnyYOdOCg92b", "E8vO87QQkuay4qK7aMyGFQLc0ZjeOzJS", "6MpCOYCclTS"};
    }

    static {
        A05();
        A04();
        A02 = new ThreadLocal<>();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double A00(@ColorInt int i) {
        double[] dArrA08 = A08();
        A07(i, dArrA08);
        return dArrA08[1] / 100.0d;
    }

    @ColorInt
    public static int A01(@ColorInt int i, @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2) {
        if (i2 >= 0) {
            String[] strArr = A01;
            if (strArr[7].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "QbRpT";
            strArr2[3] = "VTwjf";
            if (i2 <= 255) {
                return (16777215 & i) | (i2 << 24);
            }
        }
        throw new IllegalArgumentException(A03(0, 32, 3));
    }

    @ColorInt
    public static int A02(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float r) {
        float g = 1.0f - r;
        return Color.argb((int) ((Color.alpha(i) * g) + (Color.alpha(i2) * r)), (int) ((Color.red(i) * g) + (Color.red(i2) * r)), (int) ((Color.green(i) * g) + (Color.green(i2) * r)), (int) ((Color.blue(i) * g) + (Color.blue(i2) * r)));
    }

    public static void A06(@IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i, @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2, @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i3, @NonNull double[] dArr) {
        double dPow;
        double dPow2;
        if (dArr.length == 3) {
            double d2 = ((double) i) / 255.0d;
            if (d2 < 0.04045d) {
                dPow = d2 / 12.92d;
            } else {
                dPow = Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            }
            double d3 = ((double) i2) / 255.0d;
            if (d3 < 0.04045d) {
                dPow2 = d3 / 12.92d;
            } else {
                dPow2 = Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            }
            double sb = ((double) i3) / 255.0d;
            double sb2 = sb < 0.04045d ? sb / 12.92d : Math.pow((0.055d + sb) / 1.055d, 2.4d);
            double sg = 0.3576d * dPow2;
            double d4 = (0.4124d * dPow) + sg;
            double sg2 = 0.1805d * sb2;
            dArr[0] = (d4 + sg2) * 100.0d;
            double sg3 = 0.7152d * dPow2;
            double d5 = (0.2126d * dPow) + sg3;
            double sg4 = 0.0722d * sb2;
            dArr[1] = (d5 + sg4) * 100.0d;
            double sg5 = 0.1192d * dPow2;
            double d6 = (0.0193d * dPow) + sg5;
            double sg6 = 0.9505d * sb2;
            dArr[2] = (d6 + sg6) * 100.0d;
            return;
        }
        throw new IllegalArgumentException(A03(32, 31, 34));
    }

    public static void A07(@ColorInt int i, @NonNull double[] dArr) {
        A06(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static double[] A08() {
        double[] dArr = A02.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            A02.set(dArr2);
            return dArr2;
        }
        return dArr;
    }
}
