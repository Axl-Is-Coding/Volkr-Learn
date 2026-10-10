package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class L2 {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{108, 78, 65, 8, 91, ci.m, 75, 74, 91, 74, 93, 66, 70, 65, 74, ci.m, 70, 73, ci.m, 78, 95, 95, ci.m, 70, 92, ci.m, 122, 65, 70, 91, 86, 1, 24, 34, 113, 4, Utf8.REPLACEMENT_BYTE, 56, 37, 40, 113, 48, 33, 33, 107, 113, 118, 122, 120, 59, 115, 116, 118, 112, 119, 122, 122, 126, 59, 103, 112, 116, 118, 97, 59, 71, 112, 116, 118, 97, 84, 118, 97, 124, 99, 124, 97, 108, 4, 8, 10, 73, 18, 9, ci.l, 19, 30, 84, 3, 73, 23, 11, 6, 30, 2, 21, 73, 50, 9, ci.l, 19, 30, 55, 11, 6, 30, 2, 21, 38, 4, 19, ci.l, 17, ci.l, 19, 30};
    }

    static {
        A01();
        A01 = L2.class.getSimpleName();
    }

    @SuppressLint({"CatchGeneralException"})
    public static boolean A02() {
        try {
            Class.forName(A00(46, 32, 76));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A03() {
        try {
            Class.forName(A00(78, 38, 62));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A04(int i, int i2) {
        return i >= 640 && i2 >= 640;
    }

    public static boolean A05(Context context) {
        boolean z = false;
        try {
            boolean z2 = true;
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (A00(78, 38, 62).equals(activityInfo.name)) {
                        z = true;
                    }
                }
            }
            if (!z && !A03()) {
                z2 = false;
            }
            boolean isUnity = BuildConfigApi.isDebug();
            if (isUnity) {
                String str = A00(32, 14, 8) + z2;
            }
            return z2;
        } catch (Throwable th) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A01, A00(0, 32, 118), th);
            }
            return false;
        }
    }
}
