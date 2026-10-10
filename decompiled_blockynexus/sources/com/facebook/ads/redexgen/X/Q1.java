package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.sandboxol.center.config.IntConstant;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q1 {

    @Nullable
    public static InterfaceC1852Ph A00;
    public static byte[] A01;
    public static String[] A02;
    public static final Set<String> A03;
    public static final Set<String> A04;
    public static final AtomicBoolean A05;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{36, 121, 104, 23, 81, 81, 30, 99, 22, 103, 127, 85, 116, 20, 73, 126, 19, 74, 72, 66, 77, 20, 78, 81, 86, 20, 115, 73, 85, 77, 27, 44, 9, 86, 113, 76, 80, 116, 73, 92, 87, 72, 84, 17, 109, 87, 92, 126, 82, 76, 72, 8, 83, 108, 82, 21, 67, 104, 73, 7, 48, ci.l, 124, 116, 29, 56, 9, 120, 53, 0, ci.m, 40, 32, 37, 120, 62, 60, 56, 53, 61, ci.k, 9, 47, 54, 20, 3, 41, ci.k, 113, 70, 1, 42, 59, 56, 32, 61, 36, 38, 33, 40, 111, 45, 42, 41, 32, 61, 42, 111, 38, 33, 38, 59, 110, 125, 127, 125, 108, 19, 68, 75, 127, 71, 65, 110, 67, ci.l, 81, 68, 112, 119, 65, 75, 92, 112, 109, ci.n, 76, 85, 66, 104, 24, 47, 72, 64, 91, 89, 69, 72, 71, 76, 118, 68, 70, 77, 76, 118, 70, 71, 57, 50, 35, 32, 56, 37, 60, 29, 6, 51, 91, 46, 59, 7, 59, 3, 42, 80, 57, 92, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 60, ci.k, 42, 25, 38, 27, 47, 33, 81, 5, ci.m, 56, 84, 99};
    }

    public static void A08() {
        A02 = new String[]{"b", "jWWIi2TrnHAAyoG5itvaKpzBpE6rwsKb", "4piz2zd6PBPCOA5LKuru6huyc0Gk9hmI", "ThWxRwfxtMClt6xxWNEGrvPqHoOGiBgN", "VC0ltrZe3ujZ5yBmE9F34w5pTHRf8GMT", "g0Z7XyqsbnnTrD4DkPgr08gcmreNHhpx", "VVYGWntGozQ2sTcwE1XxLnyTeGzWkyyX", "XVqTwdXEkxL4UUDwn3dakWK60VTsxJd5"};
    }

    static {
        A08();
        A07();
        A03 = new HashSet();
        A04 = new HashSet();
        A03.add(A05(3, 29, 30));
        A04.add(A05(165, 29, 81));
        A04.add(A05(32, 29, 2));
        A04.add(A05(61, 29, 116));
        A04.add(A05(113, 29, 29));
        A05 = new AtomicBoolean();
    }

    public static InterfaceC1854Pj A00(AnonymousClass87 anonymousClass87) {
        return A03(true, anonymousClass87);
    }

    public static InterfaceC1854Pj A01(AnonymousClass87 anonymousClass87) {
        return A02(true, anonymousClass87);
    }

    public static InterfaceC1854Pj A02(boolean z, AnonymousClass87 anonymousClass87) {
        C1858Pn c1858Pn = new C1858Pn();
        C1861Pq c1861PqA04 = A04(anonymousClass87);
        if (!A0B()) {
            c1858Pn.A02(A04);
            c1858Pn.A01(A03);
        }
        if (C1731Kp.A04()) {
            Map<String, String> mapA02 = C1731Kp.A02();
            String[] strArr = A02;
            if (strArr[2].charAt(7) == strArr[1].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "6CjO7LbqJIONUadrRHmx0RuGBypxStir";
            strArr2[3] = "VKsjD9ddp6JrHwn0FL0Df9QGs7RhJ4JT";
            c1861PqA04.A08(mapA02);
        }
        return AbstractC1856Pl.A00().A01(c1858Pn.A00(c1861PqA04.A09()).A03(z).A04(BuildConfigApi.isDebug()).A05(), anonymousClass87.A04(), ExecutorC1744Lc.A01());
    }

    public static InterfaceC1854Pj A03(boolean z, AnonymousClass87 anonymousClass87) {
        return AbstractC1856Pl.A00().A01(new C1858Pn().A03(z).A00(A04(anonymousClass87).A09()).A04(BuildConfigApi.isDebug()).A05(), anonymousClass87.A04(), ExecutorC1744Lc.A01());
    }

    public static C1861Pq A04(AnonymousClass87 anonymousClass87) {
        A09(anonymousClass87);
        C1861Pq c1861Pq = new C1861Pq();
        if (A0B()) {
            c1861Pq.A02(360000).A04(IntConstant.ADS_INTERVAL);
        } else {
            int iA07 = C1693Iy.A07(anonymousClass87);
            if (A02[4].charAt(20) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "dD0oPHmij4s2ObzR7OPOejAtm2pYkwQj";
            strArr[1] = "6BD1tyrnooF6YeHGpiFkkFGNAjU2pFFN";
            c1861Pq.A02(iA07);
        }
        c1861Pq.A03(C1693Iy.A08(anonymousClass87)).A04(C1693Iy.A09(anonymousClass87)).A05(C1693Iy.A0A(anonymousClass87)).A06(C1693Iy.A0B(anonymousClass87));
        synchronized (Q1.class) {
            if (A00 != null && (A00 instanceof InterfaceC1852Ph)) {
                c1861Pq.A07(A00);
            }
        }
        return c1861Pq;
    }

    public static void A06() {
        A05.set(true);
    }

    public static void A09(AnonymousClass87 anonymousClass87) {
        if (!A05.get()) {
            anonymousClass87.A04().A8H(A05(158, 7, 111), C8Y.A1h, new C8Z(A05(90, 23, 119)));
        }
    }

    public static synchronized void A0A(InterfaceC1852Ph interfaceC1852Ph) {
        A00 = interfaceC1852Ph;
    }

    public static boolean A0B() {
        String urlPrefix = AdInternalSettings.getUrlPrefix();
        return !TextUtils.isEmpty(urlPrefix) && urlPrefix.endsWith(A05(0, 3, 50));
    }

    public static boolean A0C(AnonymousClass87 anonymousClass87) {
        int i = Build.VERSION.SDK_INT;
        String strA05 = A05(142, 16, 17);
        if (i < 17) {
            return Settings.System.getInt(anonymousClass87.getContentResolver(), strA05, 0) != 0;
        }
        int i2 = Settings.Global.getInt(anonymousClass87.getContentResolver(), strA05, 0);
        if (A02[0].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "6SlcDzdssqL5L6jmaJN4q0YtRJ9ZiIN0";
        strArr[1] = "IhCDgNyX5tEXKuNPsF1SGphg5lyX1n5g";
        return i2 != 0;
    }
}
