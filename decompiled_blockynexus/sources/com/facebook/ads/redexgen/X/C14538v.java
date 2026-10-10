package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14538v {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03;
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[1].charAt(3) == 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "IDfTBPjSyvL4biEe7dLkbKSavqcQmadb";
            strArr[2] = "Oy3yacq1X2KDRnpIDSUXWs28RTZJmhMt";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
            i4++;
        }
    }

    public static void A04() {
        A02 = new byte[]{-58, -57, -57, -53, -55, -61, -55, -53, -66, -70, -71, -19, -36, -31, -35, -26, -37, -35, -58, -35, -20, -17, -25, -22, -29, -62, -77, -70, -113, -40, -35, -40, -29, -40, -48, -37, -40, -23, -48, -29, -40, -34, -35, -113, -30, -29, -48, -31, -29, -44, -45, -60, -43, -36, -111, -24, -46, -28, -111, -46, -35, -29, -42, -46, -43, -22, -111, -38, -33, -38, -27, -38, -46, -35, -38, -21, -42, -43, -110, -111, -60, -36, -38, -31, -31, -38, -33, -40, -97, -62, -40, -34, -119, -51, -40, -41, -112, -35, -119, -52, -54, -43, -43, -119, -86, -34, -51, -46, -50, -41, -52, -50, -73, -50, -35, -32, -40, -37, -44, -86, -51, -36, -105, -46, -41, -46, -35, -46, -54, -43, -46, -29, -50, -111, -110, -105, -119, -68, -40, -42, -50, -119, -49, -34, -41, -52, -35, -46, -40, -41, -54, -43, -46, -35, -30, -119, -42, -54, -30, -119, -41, -40, -35, -119, -32, -40, -37, -44, -119, -39, -37, -40, -39, -50, -37, -43, -30, -105, -66, -51, -58, -31, -33, -24, -33, -20, -29, -35, -9, -4, -9, 2, -9, -17, -6, -9, 8, -13, 5, 10, 5, ci.n, 5, -3, 8, 5, 22, 1, -60, -59, -68, 10, 11, ci.n, -68, -1, -3, 8, 8, 1, 0, -54};
    }

    public static void A05() {
        A03 = new String[]{"qrNp1wG", "4f9SKAEMWw8LBpPH9ClfYFaSVVluVAOE", "62aVnpwn360RV3u8SEcmxFYidJmBvefX", "Gce9ySP9MgoEln4cNVrEo5sJO8CSkBrv", "GAv6eBsy68sSiadtgyjEU9blJSusD372", "OMedkGV5dbFzDsS0dZcen", "wlEAAxVLaYYUt0VSnPi", "2B4l1t7rFez9Iyb0KdS6JKEUq9HBo8Fu"};
    }

    static {
        A05();
        A04();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static KJ A00() {
        return new C2050Wz();
    }

    public static KZ A01(C2027Wc c2027Wc) {
        return new X0(c2027Wc);
    }

    public static void A06(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        LS.A01.execute(new C2049Wy(initListener, initResult));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A08(C2027Wc c2027Wc) {
        if (J0.A0Q(c2027Wc) && !A05.getAndSet(true)) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(new C8O(Thread.getDefaultUncaughtExceptionHandler(), c2027Wc, new X2()));
            } catch (Exception e2) {
                c2027Wc.A04().A8H(A02(181, 7, 62), C8Y.A1F, new C8Z(e2));
            }
        }
    }

    public static void A09(C2027Wc c2027Wc) {
        A0H(c2027Wc, null, null, 3);
    }

    public static void A0A(C2027Wc c2027Wc) {
        A0H(c2027Wc, null, null, 3);
    }

    public static void A0B(C2027Wc c2027Wc) {
        if (C1693Iy.A1I(c2027Wc)) {
            A0G(c2027Wc, 0);
        }
        if (C1693Iy.A1L(c2027Wc)) {
            A0D(c2027Wc);
        }
    }

    public static void A0C(C2027Wc c2027Wc) {
        if (C1693Iy.A1J(c2027Wc)) {
            A0I(c2027Wc, null, null, 3);
        }
    }

    public static void A0D(C2027Wc c2027Wc) {
        ExecutorC1744Lc.A06.execute(new C2048Wx(c2027Wc));
    }

    public static void A0E(C2027Wc c2027Wc) {
        C8S.A0D(c2027Wc, new X3(c2027Wc), new X4(), BuildConfigApi.isDebug());
        b8.A01(c2027Wc);
        C13775l.A05(c2027Wc, null);
    }

    public static void A0G(C2027Wc c2027Wc, int i) {
        AnonymousClass86.A01(c2027Wc);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            C1710Jr.A02();
        }
        A08(c2027Wc);
        KW.A00(C1693Iy.A0i(c2027Wc), BuildConfigApi.isDebug(), A00(), A01(c2027Wc));
        C13705e.A04(C1693Iy.A02(c2027Wc));
        Q1.A0A(new X1(c2027Wc));
        if (i == 3) {
            Log.e(A02(8, 17, 60), A02(89, 89, 45));
            c2027Wc.A04().A8X(A02(178, 3, 33), C8Y.A0G, new C8Z(A02(198, 24, 96)));
        }
        C1728Kk.A05(c2027Wc);
        ExecutorC1744Lc.A06(c2027Wc);
        JF.A03(c2027Wc);
        C12580t.A0D(c2027Wc);
        if (C1693Iy.A0p(c2027Wc)) {
            C13494j.A00(c2027Wc);
        }
    }

    public static void A0H(C2027Wc c2027Wc, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        C1710Jr.A05(A02(188, 10, 82), A02(25, 26, 51), A02(0, 8, 87));
        Q1.A06();
        A0I(c2027Wc, multithreadedBundleWrapper, initListener, i);
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A0I(C2027Wc c2027Wc, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        AnonymousClass86.A01(c2027Wc);
        boolean z = false;
        synchronized (C14538v.class) {
            if (!A00) {
                if (i != 1 && i != 2) {
                    if (i == 3 && !A01) {
                        A01 = true;
                        z = true;
                    }
                } else {
                    A00 = true;
                    z = true;
                }
            }
        }
        if (z) {
            A0G(c2027Wc, i);
            ExecutorC1744Lc.A08.execute(new C2047Ww(c2027Wc, multithreadedBundleWrapper, initListener));
        } else {
            if (i != 1) {
                return;
            }
            String strA02 = A02(51, 38, 53);
            if (initListener != null) {
                A06(initListener, new C14528u(true, strA02));
            } else {
                Log.w(A02(8, 17, 60), strA02);
            }
        }
    }

    public static synchronized boolean A0J() {
        return A00;
    }
}
