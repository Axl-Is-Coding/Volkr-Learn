package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LG {
    public static byte[] A00;
    public static final Pattern A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{89, 45, 2, 90, ci.n, 5, 45, 2, 90, 42, ci.n, 92, 11, 95, 44, 90, 88, 42, 48, 92, 43, 44, 95, 91, 120, 78, 73, 73, 94, 85, 79, 27, 72, 79, 90, 88, 80, 27, 79, 73, 90, 88, 94, 33, 45, 47, 108, 36, 35, 33, 39, 32, 45, 45, 41, 108, 35, 38, 49};
    }

    static {
        A07();
        A01 = Pattern.compile(A02(0, 24, 13));
    }

    public static String A00() {
        return A06(new Exception(A02(24, 19, 71)), -1, -1, false);
    }

    public static String A01(int i) {
        if (i <= 0) {
            return null;
        }
        float rate = i;
        if (new Random().nextFloat() >= 1.0f / rate) {
            return null;
        }
        return A00();
    }

    public static String A03(Context context, @Nullable Throwable th) {
        return A06(th, C1693Iy.A0G(context), C1693Iy.A01(context), C1693Iy.A0y(context));
    }

    public static String A04(String str) {
        Matcher matcher = A01.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return str;
    }

    public static String A06(@Nullable Throwable th, int i, int i2, boolean z) {
        String strA02 = A02(0, 0, 122);
        if (th == null) {
            return strA02;
        }
        try {
            C2128a3 c2128a3 = new C2128a3();
            LE c2127a2 = c2128a3;
            if (i2 >= 0) {
                c2127a2 = new C2126a1(c2127a2, i2);
            }
            if (i >= 0) {
                c2127a2 = new C2125a0(c2127a2, i, i);
            }
            if (z) {
                c2127a2 = new C2127a2(c2127a2);
            }
            a6 a6Var = new a6(c2128a3, 1, c2127a2);
            th.printStackTrace(new PrintWriter(new LF(a6Var)));
            a6Var.flush();
            return c2128a3.toString();
        } catch (Exception unused) {
            return strA02;
        }
    }

    public static boolean A08(LD ld) {
        String strA03 = ld.A03();
        if (strA03 == null) {
            return false;
        }
        if (A0A(strA03)) {
            return true;
        }
        Iterator<String> it = ld.A02().iterator();
        while (it.hasNext()) {
            if (A0A(it.next())) {
                return true;
            }
        }
        Iterator<String> it2 = ld.A01().iterator();
        while (it2.hasNext()) {
            if (A0A(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0A(String str) {
        return str.contains(A02(43, 16, 62));
    }
}
