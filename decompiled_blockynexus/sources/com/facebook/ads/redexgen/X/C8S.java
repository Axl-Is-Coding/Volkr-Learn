package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8S {

    @VisibleForTesting
    public static SparseIntArray A00;

    @VisibleForTesting
    public static Executor A01;
    public static boolean A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05;
    public static final List<Integer> A06;
    public static final List<C8T> A07;
    public static final AtomicBoolean A08;
    public static final AtomicInteger A09;
    public static final AtomicReference<C8Q> A0A;
    public static final AtomicReference<C8R> A0B;
    public static final AtomicReference<Boolean> A0C;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{-93, -105, -40, -37, -37, -32, -21, -32, -26, -27, -40, -29, -64, -27, -35, -26, -105, -76, -105, -110, -122, -45, -53, -39, -39, -57, -51, -53, -122, -93, -122, 91, 79, -94, -92, -111, -93, -88, -97, -108, 114, -98, -109, -108, 79, 108, 79, 116, -66, -36, -23, -94, -17, -101, -25, -22, -30, -101, -65, -32, -35, -16, -30, -101, -64, -15, -32, -23, -17, -87, -101, -66, -22, -23, -17, -32, -13, -17, -101, -28, -18, -101, -23, -16, -25, -25, -87, 119, -93, -87, -94, -88, -103, -90, 110, 84, -79, -46, -49, -30, -44, -115, -48, -33, -50, -32, -43, -115, -49, -46, -48, -50, -30, -32, -46, -115, -36, -45, -115, -46, -29, -46, -37, -31, -115, -28, -42, -31, -43, -115, -32, -30, -49, -31, -26, -35, -46, -115, -86, -115, 108, -97, -118, -116, -116, -117, -116, -117, 71, -112, -107, 84, -108, -116, -108, -106, -103, -96, 71, -109, -106, -114, 71, -109, -112, -108, -112, -101, 72, 71, 115, -120, -102, -101, 71, -116, -99, -116, -107, -101, 97, 71, -108, -57, -78, -76, -65, -61, -72, -66, -67, 111, -109, -76, -79, -60, -74, 111, -108, -59, -76, -67, -61, 111, -58, -72, -61, -73, 111, -62, -60, -79, -61, -56, -65, -76, 111, -116, 111, -97, -46, -67, -65, -54, -50, -61, -55, -56, 122, -66, -49, -52, -61, -56, -63, 122, -58, -55, -63, -63, -61, -56, -63, 122, -66, -65, -68, -49, -63, 122, -65, -48, -65, -56, -50, -120, -27, 24, 3, 5, ci.n, 20, 9, ci.m, ci.l, -64, 19, 8, ci.m, 21, 12, 4, -64, ci.l, ci.m, 20, -64, 8, 1, ci.n, ci.n, 5, ci.l, -64, 8, 5, 18, 5, -50, -101, -105, -106, -54, -71, -66, -70, -61, -72, -70, -93, -70, -55, -52, -60, -57, -64, -28, 9, 1, 10, -69, -33, 0, -3, ci.n, 2, -69, -32, 17, 0, 9, ci.m, -69, 18, 4, ci.m, 3, -69, ci.l, ci.n, -3, ci.m, 20, 11, 0, -69, -40, -69, -53, -26, -26, -105, -28, -40, -27, -16, -105, -36, -19, -36, -27, -21, -22, -105, -26, -35, -105, -22, -20, -39, -21, -16, -25, -36, -105, -38, -26, -37, -36, -79, -105, -101, -99, -104, -99, -102, -83, -102, -104, -91, -88, -96, -96, -94, -89, -96, -21, -8, -3, -24, -19, -18, -3, -18, -20, -3, -14, -8, -9, -24, 0, -8, -24, -4, -14, -16, -9, -22, -11, -24, -19, -22, -3, -22, -24, -11, -8, -16, -16, -14, -9, -16, -62, -64, -62, -57, -60, -57, -56, -62, -49, -46, -54, -54, -52, -47, -54, -2, ci.k, 6, 6, -3, 4, -49, -42, -55, -59, -36, -57, -46, -49, -54, -57, -38, -49, -43, -44, -36, -45, -30, -27, -35, -32, -39};
    }

    public static void A05() {
        A05 = new String[]{"lfqbOpCQc8eNVWWSF0ti", "aQ5ZOD0I", "7f7up0GBGRCd1p0enpCjG4lcj76", "dHBYXWbpLBdqteinvxBO5bOixoP3oT04", "DPNUUQYEctncegz3shse9IBb8Vdl47", "4q0rwT09y0cbatV7Yp", "6l64E9SK9p5G", "edaEIeRSccYYgTnyelVwcwdzoe4C2sfO"};
    }

    static {
        A05();
        A04();
        A00 = new SparseIntArray();
        A03 = false;
        A0B = new AtomicReference<>();
        A0A = new AtomicReference<>();
        A01 = Executors.newSingleThreadExecutor();
        A06 = Arrays.asList(10, 50, 100, 1000);
        A07 = Collections.synchronizedList(new ArrayList());
        A09 = new AtomicInteger();
        A08 = new AtomicBoolean();
        A0C = new AtomicReference<>();
        A02 = false;
    }

    public static int A00(String str, int i, AnonymousClass87 anonymousClass87) {
        if ((A01(457, 7, 71).equals(str) && C8Y.A1g == i) || A01(422, 5, 56).equals(str) || A01(437, 6, 113).equals(str)) {
            return 200;
        }
        if (A01(386, 36, 98).equals(str)) {
            return 50;
        }
        if (A01(371, 15, 18).equals(str)) {
            return J0.A05(anonymousClass87);
        }
        if (A05[3].charAt(3) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        strArr[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        return -1;
    }

    public static /* synthetic */ List A02() {
        List<C8T> list = A07;
        String[] strArr = A05;
        if (strArr[4].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
        strArr2[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
        return list;
    }

    public static void A06(AnonymousClass87 anonymousClass87, int i, int i2) {
        anonymousClass87.A04().A8H(A01(427, 10, 60), C8Y.A2A, new C8Z(A01(338, 33, 80) + i, A01(87, 9, 13) + i2));
    }

    @Deprecated
    public static void A07(@Nullable AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z) {
        if (anonymousClass87 == null) {
            A0G(new RuntimeException(A01(48, 39, 84)));
            return;
        }
        AnonymousClass86.A01(anonymousClass87.A00());
        if (A02 && c8z.A00() == 0) {
            A0E(new RuntimeException(A01(96, 44, 70) + str + A01(31, 16, 8) + i, c8z));
        }
        try {
            if (A0J(anonymousClass87, str, i, Math.random(), c8z)) {
                A0A(anonymousClass87, str, i, c8z);
            }
        } catch (Throwable th) {
            A0G(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    @Deprecated
    public static void A08(AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z) {
        try {
            c8z.A03(2);
            c8z.A08(false);
            c8z.A04(1);
            if (J0.A0R(anonymousClass87)) {
                c8z.A06(true);
            } else {
                c8z.A06(false);
            }
            A07(anonymousClass87, str, i, c8z);
        } catch (Throwable th) {
            A0G(th);
        }
    }

    @Deprecated
    public static void A09(AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z) {
        try {
            c8z.A03(2);
            c8z.A06(false);
            A07(anonymousClass87, str, i, c8z);
        } catch (Throwable th) {
            A0G(th);
        }
    }

    public static void A0A(AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z) {
        synchronized (C8S.class) {
            if (!A03) {
                int iA01 = J0.A01(anonymousClass87);
                if (A09.getAndIncrement() < iA01 - 1) {
                    A07.add(new C8T(str, i, c8z));
                } else if (A09.get() == iA01) {
                    A07.add(new C8T(A01(427, 10, 60), C8Y.A27, new C8Z(A01(140, 42, 0) + str + A01(47, 1, 19) + i)));
                }
            } else {
                A0B(anonymousClass87, str, i, c8z, true);
            }
        }
    }

    public static void A0B(AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z, boolean z) {
        C8R c8r = A0B.get();
        boolean z2 = c8r != null && c8r.A7y();
        if (A08.get() || z2) {
            int iA00 = c8z.A00();
            String strA01 = A01(289, 17, 46);
            String strA012 = A01(31, 16, 8);
            if (iA00 == 0) {
                Log.e(strA01, A01(182, 37, 40) + str + strA012 + i, c8z);
            } else {
                Log.i(strA01, A01(306, 32, 116) + str + strA012 + i + A01(19, 12, 63) + c8z.getMessage() + A01(0, 19, 80) + c8z.A02());
            }
        }
        C2041Wq c2041Wq = new C2041Wq(anonymousClass87, str, i, c8z, c8r);
        if (z) {
            A01.execute(c2041Wq);
        } else {
            c2041Wq.run();
        }
    }

    public static void A0D(C2027Wc c2027Wc, C8R c8r, C8Q c8q, boolean z) {
        A0A.set(c8q);
        A0B.set(c8r);
        A08.set(z);
        synchronized (C8S.class) {
            if (!A03) {
                A03 = true;
                A01.execute(new C2040Wp(c2027Wc));
            }
        }
    }

    public static void A0E(final RuntimeException runtimeException) {
        if (A02) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.ads.redexgen.X.8P
                @Override // java.lang.Runnable
                public final void run() {
                    throw runtimeException;
                }
            });
        }
    }

    @Deprecated
    public static void A0F(Throwable th) {
        if (A02) {
            A0E(new RuntimeException(A01(256, 33, 121), th));
        }
    }

    public static void A0G(Throwable th) {
        Log.e(A01(289, 17, 46), A01(219, 37, 51), th);
        if (A02) {
            A0E(new RuntimeException(th));
        }
    }

    public static boolean A0I(AnonymousClass87 anonymousClass87) {
        Boolean bool = A0C.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        return J0.A0A(anonymousClass87) != 0;
    }

    @SuppressLint({"CatchGeneralException"})
    @VisibleForTesting
    public static boolean A0J(AnonymousClass87 anonymousClass87, String str, int i, double d2, C8Z c8z) {
        double logProbability;
        int iA0E;
        try {
            int iA04 = J0.A04(anonymousClass87);
            if (iA04 < 1) {
                return false;
            }
            HashMap<String, Integer> mapA0M = J0.A0M(anonymousClass87);
            Set<String> setKeySet = mapA0M.keySet();
            String str2 = str + A01(47, 1, 19) + i;
            boolean zContains = setKeySet.contains(str2);
            if (zContains) {
                Integer num = mapA0M.get(str2);
                int iIntValue = num != null ? num.intValue() : -1;
                if (iIntValue == 0) {
                    return false;
                }
                if (iIntValue > 0) {
                    return d2 <= 1.0d / ((double) iIntValue);
                }
                int iA03 = J0.A03(anonymousClass87);
                if (iA03 < 1) {
                    return false;
                }
                logProbability = ((double) (iA04 * iA03)) / 10000.0d;
            } else if (!c8z.A09()) {
                logProbability = 0.0d;
            } else {
                double logProbability2 = iA04;
                logProbability = logProbability2 / 100.0d;
            }
            double dA00 = anonymousClass87.A05().A00();
            if (A01(422, 5, 56).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    return true;
                }
                int iA06 = J0.A06(anonymousClass87);
                if (iA06 == 0) {
                    return false;
                }
                if (iA06 > 0) {
                    double d3 = 1.0d / ((double) iA06);
                    return zContains ? dA00 <= d3 * logProbability : dA00 <= d3;
                }
            }
            if (A01(457, 7, 71).equals(str) && C8Y.A1g == i) {
                if (!A08.get()) {
                    iA0E = J0.A0E(anonymousClass87);
                } else {
                    iA0E = 1;
                }
                if (iA0E == 0) {
                    return false;
                }
                if (iA0E > 0) {
                    double d4 = 1.0d / ((double) iA0E);
                    return zContains ? dA00 <= d4 * logProbability : dA00 <= d4;
                }
            }
            if (A01(437, 6, 113).equals(str)) {
                if (J0.A0T(anonymousClass87) && c8z.A0A()) {
                    return !zContains || d2 >= 1.0d - logProbability;
                }
                Boolean bool = A0C.get();
                if (bool != null) {
                    return bool.booleanValue();
                }
                int iA0A = J0.A0A(anonymousClass87);
                if (iA0A == 0) {
                    A0C.set(false);
                    return false;
                }
                if (iA0A > 0) {
                    double d5 = 1.0d / ((double) iA0A);
                    if (!zContains) {
                        return dA00 <= d5;
                    }
                    double d6 = d5 * logProbability;
                    if (A05[7].charAt(14) == 'T') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[1] = "";
                    strArr[1] = "";
                    return dA00 <= d6;
                }
            }
            if (A01(443, 14, 63).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    if (A05[3].charAt(3) != 'Y') {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A05;
                    strArr2[4] = "KJjq974XMuOG6VE2UuXyW1KY5FJsZ9";
                    strArr2[0] = "oDF6i4FckldRw4UZ8099";
                    return true;
                }
                int iA0B = J0.A0B(anonymousClass87);
                if (iA0B == 0) {
                    return false;
                }
                if (iA0B > 0) {
                    double d7 = 1.0d / ((double) iA0B);
                    return zContains ? dA00 <= d7 * logProbability : dA00 <= d7;
                }
            }
            return d2 >= 1.0d - logProbability;
        } catch (Throwable th) {
            A0G(th);
            return false;
        }
    }

    @VisibleForTesting
    public static boolean A0K(AnonymousClass87 anonymousClass87, String str, int eventsLimit, C8Z c8z) {
        if (!J0.A0Q(anonymousClass87)) {
            return true;
        }
        int i = A00.get(eventsLimit);
        int iA00 = J0.A00(anonymousClass87);
        if (c8z.A01() != -1) {
            iA00 = c8z.A01();
        } else {
            int iA002 = A00(str, eventsLimit, anonymousClass87);
            if (iA00 < iA002) {
                iA00 = iA002;
            }
        }
        if (i >= iA00) {
            if (A06.contains(Integer.valueOf(i))) {
                boolean zA0B = c8z.A0B();
                if (A05[3].charAt(3) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[5] = "DtDXz8TrFQQZw1pkgy";
                strArr[2] = "wKGFu6BM2pQR03pr0dyvmA98nTz";
                if (zA0B) {
                    A06(anonymousClass87, eventsLimit, i);
                }
            }
            A00.put(eventsLimit, i + 1);
            return true;
        }
        A00.put(eventsLimit, i + 1);
        return false;
    }
}
