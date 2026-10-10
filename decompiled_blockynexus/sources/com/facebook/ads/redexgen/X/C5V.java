package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5V {
    public static byte[] A00;
    public static String[] A01;
    public static final AtomicReference<C5T> A02;
    public static final AtomicReference<String> A03;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-98, -90, -95, -100, -84, -77, -94, -81, -81, -90, -95, -94, -95, -97, -88, -97, -84, -93, -99, -20, -25, -23, -28, -30, -14, -7, -24, -11, -11, -20, -25, -24};
    }

    public static void A06() {
        A01 = new String[]{"zJ7sRo3sU3MwvYkxVq5sKXU", "uwqdBBQkb", "sk1pAaPClwmr1DZFuM4XEVJDjMgj4luU", "2DEAuAVf", "LM1sVeBw6DNfIdZzIYsj5hqYQDPEhJFy", "hYSBjzGCwuKpFZFqojmwIwdxMJLMCyYz", "BWOi5Qn34m6VEGTMmYfzcDYeX0GTjOOy", "rscTiGR64sMWr7IEiXLU0M2EjoTwZlLg"};
    }

    static {
        A06();
        A05();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>(A04(0, 0, 68));
    }

    public static C5T A00() {
        C5T c5t = A02.get();
        if (A01[6].charAt(15) == 'M') {
            String[] strArr = A01;
            strArr[3] = "GQnQs3ZS";
            strArr[1] = "yTwJu7KeR";
            C5T c5t2 = c5t;
            if (c5t2 == null) {
                C5T c5tA00 = C5T.A00();
                String[] strArr2 = A01;
                if (strArr2[3].length() != strArr2[1].length()) {
                    String[] strArr3 = A01;
                    strArr3[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                    strArr3[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                    return c5tA00;
                }
            } else {
                return c5t2;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L5;
     */
    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C5T A01(com.facebook.ads.redexgen.X.AnonymousClass87 r5, com.facebook.ads.redexgen.X.C5T r6) {
        /*
            if (r6 == 0) goto Lc
            java.lang.String r0 = r6.A03()     // Catch: java.lang.Throwable -> L11
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L28
        Lc:
            com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C13675b.A00(r5)     // Catch: java.lang.Throwable -> L11
            return r0
        L11:
            r0 = move-exception
            com.facebook.ads.redexgen.X.8X r5 = r5.A04()
            int r4 = com.facebook.ads.redexgen.X.C8Y.A18
            com.facebook.ads.redexgen.X.8Z r3 = new com.facebook.ads.redexgen.X.8Z
            r3.<init>(r0)
            r2 = 12
            r1 = 7
            r0 = 6
            java.lang.String r0 = A04(r2, r1, r0)
            r5.A8H(r0, r4, r3)
        L28:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5V.A01(com.facebook.ads.redexgen.X.87, com.facebook.ads.redexgen.X.5T):com.facebook.ads.redexgen.X.5T");
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static C5T A02(AnonymousClass87 anonymousClass87, C5T c5t, C5U c5u) {
        C5W c5wA00 = null;
        try {
            if (C1692Ix.A07(anonymousClass87) && (c5t == null || TextUtils.isEmpty(c5t.A03()))) {
                c5wA00 = C5X.A00(anonymousClass87.getContentResolver());
            }
        } catch (Throwable th) {
            anonymousClass87.A04().A8H(A04(12, 7, 6), C8Y.A1A, new C8Z(th));
        }
        if (c5wA00 != null && c5wA00.A01 != null) {
            A03.set(c5wA00.A01);
            c5u.A05(c5wA00.A01);
        }
        if (c5t == null && c5wA00 != null && !TextUtils.isEmpty(c5wA00.A00)) {
            return new C5T(c5wA00.A00, c5wA00.A02, C5S.A05);
        }
        return c5t;
    }

    public static String A03() {
        String attributionId = A03.get();
        if (attributionId == null) {
            return A04(0, 0, 68);
        }
        return attributionId;
    }

    public static void A07(C5U c5u) {
        A02.set(c5u.A02());
        A03.set(c5u.A03());
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A08(AnonymousClass87 anonymousClass87) {
        long jA01;
        C5T upToDateAdInfo;
        try {
            C5U c5u = new C5U(anonymousClass87);
            A07(c5u);
            if (A09()) {
                return;
            }
            C5T c5t = A02.get();
            if (c5t != null && !TextUtils.isEmpty(c5t.A03())) {
                jA01 = c5t.A01();
            } else {
                jA01 = -1;
            }
            if (jA01 > 0 && System.currentTimeMillis() - jA01 < C1692Ix.A00(anonymousClass87)) {
                return;
            }
            if (C1692Ix.A08(anonymousClass87)) {
                upToDateAdInfo = A01(anonymousClass87, A02(anonymousClass87, null, c5u));
            } else {
                upToDateAdInfo = A02(anonymousClass87, A01(anonymousClass87, null), c5u);
            }
            if (upToDateAdInfo != null && !TextUtils.isEmpty(upToDateAdInfo.A03())) {
                A02.set(upToDateAdInfo);
                c5u.A04(upToDateAdInfo);
            }
        } catch (Throwable th) {
            anonymousClass87.A04().A8H(A04(12, 7, 6), C8Y.A19, new C8Z(th));
        }
    }

    public static boolean A09() {
        boolean updated = false;
        if (C1731Kp.A04()) {
            if (A01[0].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "OqjdKmMb";
            strArr[1] = "Sbvi0a9C0";
            String strA04 = A04(0, 12, 9);
            if (C1731Kp.A05(strA04)) {
                A03.set(C1731Kp.A01(strA04));
                updated = true;
            }
        }
        boolean zA04 = C1731Kp.A04();
        String[] strArr2 = A01;
        if (strArr2[5].charAt(29) != strArr2[4].charAt(29)) {
            String[] strArr3 = A01;
            strArr3[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            strArr3[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            if (!zA04) {
                return updated;
            }
        } else {
            String[] strArr4 = A01;
            strArr4[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            strArr4[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            if (!zA04) {
                return updated;
            }
        }
        String strA042 = A04(19, 13, 79);
        if (C1731Kp.A05(strA042)) {
            String strA01 = C1731Kp.A01(strA042);
            AtomicReference<C5T> atomicReference = A02;
            if (strA01 == null) {
                strA01 = A04(0, 0, 68);
            }
            atomicReference.set(new C5T(strA01, false, C5S.A04));
            return true;
        }
        return updated;
    }
}
