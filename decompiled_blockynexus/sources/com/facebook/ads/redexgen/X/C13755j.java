package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13755j {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{45, 59, ci.n, 42, 55, 59, 61, 46, 60, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 33, 38, 60, 45, 58, 38, 41, 36, 102, 42, 60, 45, 48, 60, 58, 41, 59};
    }

    public static SharedPreferences A00(AnonymousClass87 anonymousClass87) {
        return anonymousClass87.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 105), anonymousClass87), 0);
    }

    @Nullable
    public final String A03(AnonymousClass87 anonymousClass87) {
        return A00(anonymousClass87).getString(A01(0, 9, 110), null);
    }

    public final void A04(AnonymousClass87 anonymousClass87, String str) {
        A00(anonymousClass87).edit().putString(A01(0, 9, 110), str).apply();
    }
}
