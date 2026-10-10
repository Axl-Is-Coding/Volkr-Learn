package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class J0 {
    public static byte[] A00;
    public static String[] A01;

    static {
        A0O();
        A0N();
    }

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[2].length() == 18) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "coY8s09zVAK7eBnMiZlV9B8LCQZOBRZX";
            strArr[0] = "coY8s09zVAK7eBnMiZlV9B8LCQZOBRZX";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
            i4++;
        }
    }

    public static void A0N() {
        A00 = new byte[]{113, 48, 18, 29, 84, 7, 83, 3, 18, 1, 0, 22, 83, 0, 18, 30, 3, 31, 26, 29, 20, 93, 60, 58, ci.n, 21, 21, 24, 5, 24, 30, 31, ci.n, 29, 46, 21, 20, 19, 4, 22, 46, 29, 30, 22, 22, 24, 31, 22, 46, 19, 29, ci.n, 18, 26, 46, 29, 24, 2, 5, 55, 50, 50, Utf8.REPLACEMENT_BYTE, 34, Utf8.REPLACEMENT_BYTE, 57, 56, 55, 58, 9, 50, 51, 52, 35, 49, 9, 58, 57, 49, 49, Utf8.REPLACEMENT_BYTE, 56, 49, 9, 52, 58, 55, 53, 61, 9, 58, Utf8.REPLACEMENT_BYTE, 37, 34, 9, 38, 51, 36, 53, 51, 56, 34, 55, 49, 51, 70, 67, 67, 78, 83, 78, 72, 73, 70, 75, 120, 67, 66, 69, 82, 64, 120, 75, 72, 64, 64, 78, 73, 64, 120, 84, 70, 74, 87, 75, 78, 73, 64, 120, 87, 66, 85, 68, 66, 73, 83, 70, 64, 66, 48, 53, Utf8.REPLACEMENT_BYTE, 38, ci.l, 48, 53, 53, 56, 37, 56, 62, Utf8.REPLACEMENT_BYTE, 48, 61, ci.l, 61, 62, 54, 54, 56, Utf8.REPLACEMENT_BYTE, 54, ci.l, 35, 52, 37, 35, 40, ci.l, 61, 56, 60, 56, 37, 9, 12, 6, 31, 55, 9, 12, 12, 1, 28, 1, 7, 6, 9, 4, 55, 4, 7, ci.m, ci.m, 1, 6, ci.m, 55, 29, 27, ci.k, 55, 28, ci.k, 5, 24, 55, ci.l, 1, 4, ci.k, 55, ci.l, 7, 26, 55, 26, ci.k, 31, 26, 1, 28, ci.k, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 80, 93, 70, 80, 72, 66, 110, 93, 94, 86, 110, 82, 94, 67, 84, 110, 87, 68, 95, 95, 84, 93, 110, 84, 71, 84, 95, 69, 66, 28, 25, 19, 10, 34, 28, 19, 25, ci.m, 18, 20, 25, 34, 30, 28, 30, 21, 24, 34, 25, 24, 31, 8, 26, 34, 24, 11, 24, 19, 9, ci.l, 34, ci.l, 28, ci.n, ci.k, 17, 20, 19, 26, 34, ci.m, 28, 9, 24, 17, 20, 30, 7, 47, 17, 30, 20, 2, 31, 25, 20, 47, 20, 25, 3, 0, 17, 4, 19, 24, 21, 2, 47, 25, 30, 25, 4, 25, 17, 28, 47, 2, 21, 4, 2, 9, 47, 20, 21, 28, 17, 9, 47, 29, 3, 113, 116, 126, 103, 79, 113, 126, 116, 98, 127, 121, 116, 79, 116, 121, 99, 96, 113, 100, 115, 120, 117, 98, 79, 125, 113, 104, 79, 98, 117, 100, 98, 105, 79, 115, 127, 101, 126, 100, 8, ci.k, 7, 30, 54, 8, 7, ci.k, 27, 6, 0, ci.k, 54, ci.m, 28, 7, 7, 12, 5, 54, ci.k, 12, 11, 28, ci.l, 54, 12, 31, 12, 7, 29, 26, 54, 26, 8, 4, 25, 5, 0, 7, ci.l, 54, 27, 8, 29, 12, ci.n, 21, 31, 6, 46, ci.n, 31, 21, 3, 30, 24, 21, 46, 24, 1, 18, 46, 21, 20, 19, 4, 22, 46, 20, 7, 20, 31, 5, 2, 46, 2, ci.n, 28, 1, 29, 24, 31, 22, 46, 3, ci.n, 5, 20, 114, 119, 125, 100, 76, 114, 125, 119, 97, 124, 122, 119, 76, 127, 124, 112, 114, 127, 76, 112, 124, 102, 125, 103, 118, 97, 96, 76, 96, 114, 126, 99, 127, 122, 125, 116, 76, 97, 114, 103, 118, 96, 101, 111, 118, 94, 96, 111, 101, 115, 110, 104, 101, 94, 111, 96, 117, 104, 119, 100, 94, 119, 104, 100, 118, 96, 99, 104, 109, 104, 117, 120, 94, 105, 104, 114, 117, 110, 115, 120, 94, 114, 96, 108, 113, 109, 104, 111, 102, 94, 115, 96, 117, 100, 66, 71, 77, 84, 124, 66, 77, 71, 81, 76, 74, 71, 124, 77, 70, 87, 84, 76, 81, 72, 124, 71, 70, 65, 86, 68, 124, 70, 85, 70, 77, 87, 80, 124, 80, 66, 78, 83, 79, 74, 77, 68, 124, 81, 66, 87, 70, 51, 54, 60, 37, ci.k, 51, 60, 54, 32, 61, 59, 54, ci.k, 39, 33, 55, ci.k, 62, 61, 49, 51, 62, ci.k, 49, 61, 39, 60, 38, 55, 32, 33, 74, 79, 69, 92, 116, 79, 78, 73, 94, 76, 116, 71, 68, 76, 116, 77, 66, 71, 78, 116, 88, 66, 81, 78, 116, 71, 66, 70, 66, 95, 116, 73, 82, 95, 78, 88, 94, 91, 81, 72, 96, 91, 90, 93, 74, 88, 96, 83, 80, 88, 88, 86, 81, 88, 44, 41, 35, 58, 18, 41, 40, 47, 56, 42, 18, 33, 34, 42, 42, 36, 35, 42, 18, 40, 59, 40, 35, 57, 18, 33, 36, 32, 36, 57, ci.m, 10, 0, 25, 49, 2, 1, 9, 49, ci.m, 10, 10, 7, 26, 7, 1, 0, ci.m, 2, 49, 2, 1, 9, 9, 7, 0, 9, 49, 11, 24, 11, 0, 26, 29, 49, 2, 7, 3, 7, 26, 100, 97, 107, 114, 90, 105, 106, 98, 90, 100, 97, 97, 108, 113, 108, 106, 107, 100, 105, 90, 105, 106, 98, 98, 108, 107, 98, 90, 108, 107, 90, 104, 96, 104, 106, 119, 124, 90, 96, 115, 96, 107, 113, 118, 90, 105, 108, 104, 108, 113, 66, 71, 77, 84, 124, 79, 76, 68, 124, 66, 71, 71, 74, 87, 74, 76, 77, 66, 79, 124, 79, 76, 68, 68, 74, 77, 68, 124, 80, 70, 80, 80, 74, 76, 77, 124, 70, 85, 70, 77, 87, 80, 124, 66, 79, 84, 66, 90, 80, 99, 102, 108, 117, 93, 113, 103, 108, 102, 93, 99, 102, 102, 107, 118, 107, 109, 108, 99, 110, 93, 102, 103, 96, 119, 101, 93, 110, 109, 101, 101, 107, 108, 101, 93, 113, 118, 99, 97, 105, 118, 112, 99, 97, 103, 123, 126, 116, 109, 69, 105, 114, 117, 111, 118, 126, 69, 111, 105, 127, 69, 124, 115, 118, 127, 69, 120, 123, 105, 127, 126, 69, 104, 127, 121, 117, 104, 126, 69, 126, 123, 110, 123, 120, 123, 105, 127, 35, 38, 44, 53, 29, 55, 49, 39, 29, 49, 42, 45, 48, 54, 29, 39, 44, 52, 29, 38, 35, 54, 35, 29, 
        36, 45, 48, 29, 35, 38, 38, 43, 54, 43, 45, 44, 35, 46, 29, 46, 45, 37, 37, 43, 44, 37, 123, 125, 70, 125, 120, 109, 120, 70, 117, 118, 126, 126, 112, 119, 126, 70, 117, 112, 116, 112, 109, 61, 38, 33, 46, 33, 45, 44, 23, 36, 39, 47, 47, 33, 38, 47, 23, 44, 33, 59, 56, 41, 60, 43, 32, 23, 33, 38, 60, 45, 58, 62, 41, 36, 23, 59, 45, 43, 39, 38, 44, 59, 114, 105, 110, 97, 110, 98, 99, 88, 107, 104, 96, 96, 110, 105, 96, 88, 98, 113, 98, 105, 115, 88, 107, 110, 106, 110, 115, 25, 2, 5, 10, 5, 9, 8, 51, 0, 3, 11, 11, 5, 2, 11, 51, 5, 1, 1, 9, 8, 5, ci.k, 24, 9, 51, 8, 9, 0, ci.k, 21, 51, 1, 31, 126, 101, 98, 109, 98, 110, 111, 84, 103, 100, 108, 108, 98, 101, 108, 84, 121, 110, 127, 121, 114, 84, 103, 98, 102, 98, 127};
    }

    public static void A0O() {
        A01 = new String[]{"UmMlfAJJysNoFzDVq3Qadmy32zpeb1XF", "HllnJbGbN3", "8LLGh47zYIGz9mlPEtFaTcZuh", "UxHymo9qL", "LEtC8FtnVg5ihxRCphfXt4mvpUeUrdN6", "uWIYhcHXlNvGJXs3GUOJ1PEuERlV4x7", "VZrIuYan0GxbimTZrmDwvEADARuUOj", "38Z9W6n0Eu6i9ylO2bMusVthcISfAJzl"};
    }

    public static int A00(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(750, 40, 100), 10);
    }

    public static int A01(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(790, 50, 15), 50);
    }

    public static int A02(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(149, 35, 91), 1);
    }

    public static int A03(Context context) {
        return A0H(context, A0L(59, 46, 92), 0);
    }

    public static int A04(Context context) {
        return A0H(context, A0L(105, 44, 45), 0);
    }

    public static int A05(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(1022, 21, 19), 10);
    }

    public static int A06(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(275, 45, 119), 0);
    }

    public static int A07(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(666, 36, 33), 10485760);
    }

    public static int A08(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(720, 30, 71), 30);
    }

    public static int A09(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(366, 39, 26), 5);
    }

    public static int A0A(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(405, 46, 99), 0);
    }

    public static int A0B(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(451, 43, 123), 0);
    }

    public static int A0C(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(494, 41, 25), 0);
    }

    public static int A0D(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(535, 53, 11), 0);
    }

    public static int A0E(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(588, 47, 41), 0);
    }

    public static int A0F(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(1084, 27, 13), 30);
    }

    public static int A0G(Context context) {
        return C1693Iy.A0M(context).A1m(A0L(1145, 27, 1), 20);
    }

    public static int A0H(Context context, String str, int i) {
        int iA1m = C1693Iy.A0M(context).A1m(str, i);
        if (iA1m >= 0 && iA1m < 101) {
            return iA1m;
        }
        return i;
    }

    public static long A0I(Context context) {
        return C1693Iy.A0M(context).A1n(A0L(320, 46, 122), 2000L);
    }

    public static long A0J(Context context) {
        return ((long) C1693Iy.A0M(context).A1m(A0L(1043, 41, 66), 300)) * 1000;
    }

    public static long A0K(Context context) {
        return C1693Iy.A0M(context).A1n(A0L(1111, 34, 102), 500L);
    }

    public static HashMap<String, Integer> A0M(Context context) throws JSONException {
        String strA1o = C1693Iy.A0M(context).A1o(A0L(24, 35, 123), A0L(22, 2, 109));
        HashMap<String, Integer> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray(strA1o);
        for (int i = 0; i < jSONArray.length(); i++) {
            String blackListString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(blackListString)) {
                String strA0L = A0L(0, 1, 69);
                if (blackListString.contains(strA0L)) {
                    String[] strArrSplit = blackListString.split(strA0L);
                    String eventConfig = strArrSplit[1];
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(eventConfig)));
                    } catch (NumberFormatException unused) {
                        throw new JSONException(A0L(1, 21, 121));
                    }
                } else {
                    map.put(blackListString, -1);
                }
            }
        }
        return map;
    }

    public static boolean A0P(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(184, 49, 98), true);
    }

    public static boolean A0Q(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(702, 18, 53), false);
    }

    public static boolean A0R(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(840, 49, 41), true);
    }

    public static boolean A0S(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(889, 45, 8), false);
    }

    public static boolean A0T(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(233, 42, 59), true);
    }

    public static boolean A0U(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(934, 42, 16), false);
    }

    public static boolean A0V(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(635, 31, 88), false);
    }

    public static boolean A0W(Context context) {
        return C1693Iy.A0M(context).A1q(A0L(976, 46, 72), true);
    }
}
