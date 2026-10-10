package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TC implements C5K {
    public static byte[] A02;
    public static final String A03;
    public final C5N A00;
    public final AnonymousClass77 A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{50, 84, 71, 78, 81, 67, 70, 75, 80, 73, 2, 7, 70, 2, 67, 85, 85, 71, 86, 85, 58, 92, 79, 86, 89, 75, 78, 83, 88, 81, 10, 83, 87, 75, 81, 79, 36, 10, ci.m, 93, 35, 69, 56, Utf8.REPLACEMENT_BYTE, 66, 52, 55, 60, 65, 58, -13, 64, 52, 69, 62, 72, 67, ci.k, -13, -8, 70, 25, 59, 46, 53, 56, 42, 45, 50, 55, 48, -23, Utf8.REPLACEMENT_BYTE, 50, 45, 46, 56, 3, -23, -18, 60, -33, -82, -31, -31, -79, -78, -81, -81, -88, -35, -77, -82, -83, -88, -84, -84, -32, -76, -88, -36, -83, -36, -82, -88, -83, -36, -83, -36, -32, -83, -33, -35, -34, -34, -32, -81, 58, 60, 47, 48, 47, 62, 45, 50, 19, 12, 9, 12, ci.k, 21, 12};
    }

    static {
        A02();
        A03 = TC.class.getSimpleName();
    }

    public TC(C5N c5n, C2027Wc c2027Wc) {
        this.A00 = c5n;
        this.A00.A3G(new TA(this));
        this.A01 = new AnonymousClass77(c2027Wc);
        A01();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(0, 20, 114), Integer.valueOf(this.A00.A5V().size()));
        }
        for (C5Q c5q : this.A00.A5V()) {
            int i = C5M.A00[c5q.A7I().ordinal()];
            if (i == 1) {
                A04(c5q.getUrl());
            } else if (i == 2) {
                A06(c5q.getUrl());
            } else if (i == 3) {
                A05(c5q.getUrl());
            }
        }
        this.A01.A0Q(new TB(this), new AnonymousClass70(A00(81, 36, 11), A00(125, 7, 46)));
    }

    private void A04(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(20, 20, 122), str);
        }
        AnonymousClass74 anonymousClass74 = new AnonymousClass74(str, -1, -1, A00(81, 36, 11), A00(125, 7, 46));
        anonymousClass74.A01 = A00(117, 8, 90);
        this.A01.A0R(anonymousClass74);
    }

    private void A05(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(40, 21, 99), str);
        }
        AnonymousClass76 anonymousClass76 = new AnonymousClass76(str, A00(81, 36, 11), A00(125, 7, 46));
        anonymousClass76.A04 = true;
        anonymousClass76.A02 = A00(117, 8, 90);
        this.A01.A0T(anonymousClass76);
    }

    private void A06(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(61, 20, 89), str);
        }
        AnonymousClass76 anonymousClass76 = new AnonymousClass76(str, A00(81, 36, 11), A00(125, 7, 46));
        anonymousClass76.A04 = false;
        anonymousClass76.A02 = A00(117, 8, 90);
        this.A01.A0W(anonymousClass76);
    }
}
