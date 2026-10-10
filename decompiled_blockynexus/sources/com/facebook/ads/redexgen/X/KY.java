package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KY {
    public static String[] A01;
    public static final ThreadLocal<KY> A02;
    public final KH A00 = new KH();

    public static void A03() {
        A01 = new String[]{"vWOWhJ9TqiA1ty478f", "MWb8A3Nd6tPLcAimCp0hVAmYX6QHiaZm", "Xd3YBUkiMhOleC4V056rVyOXhinwtSii", "tT8mJINbcEXXPPmKiWyTepfA0JHaFg93", "WoudJsrKOqRuVhNYSdRTZjqc00A0B3WY", "YTheXaZSxrm1KPF5Yd", "huHeChgRkwF7QVPgKoMeW6tLhEc13T9K", "ASVM8zHOtJrSOKsDwpZwweqDqvgS8KFW"};
    }

    static {
        A03();
        A02 = new ThreadLocal<>();
    }

    public static KH A00() {
        return A02().A00;
    }

    public static KH A01(KX kx) {
        KH kh = new KH(A00());
        kh.add(kx);
        return kh;
    }

    public static KY A02() {
        KY ky = A02.get();
        String[] strArr = A01;
        if (strArr[6].charAt(1) == strArr[2].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "JnfSkSuIf6osqUQGv4Nkh0Vi2QZsQFPV";
        strArr2[4] = "e9u3CRl6fKpCeCDR9nRPR0cml03xK1Bs";
        if (ky == null) {
            KY ky2 = new KY();
            A02.set(ky2);
            return ky2;
        }
        return ky;
    }

    public static void A04(KT kt) {
        KH createRunnableAsyncStackTrace = kt.A06();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.addAll(createRunnableAsyncStackTrace);
        }
    }

    public static void A05(KT kt) {
        KH createRunnableAsyncStackTrace = kt.A06();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.removeAll(createRunnableAsyncStackTrace);
        }
    }
}
