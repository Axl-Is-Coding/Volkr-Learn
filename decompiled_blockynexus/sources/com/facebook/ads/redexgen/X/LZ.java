package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LZ {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-9, 4, -6, 8, 5, -1, -6, -60, 5, 9, -60, -41, 9, ci.m, 4, -7, -22, -9, 9, 1};
    }

    public static <P, PR, R> AsyncTask<P, PR, R> A00(Executor executor, AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(executor, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02() {
        try {
            Class.forName(A01(0, 20, 32));
        } catch (Throwable unused) {
        }
    }
}
