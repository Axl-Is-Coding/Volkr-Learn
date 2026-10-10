package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X1 implements InterfaceC1852Ph {
    public static byte[] A01;
    public final C2027Wc A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, -45, -20, -24, -45, -10, 21, 21, 18, -45, -8, 21, 27, 26, ci.m, 20, ci.k, -45, -6, 21, 17, 11, 20, 102, 100, 86, 99, 30, 82, 88, 86, 95, 101};
    }

    public X1(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1852Ph
    public final Map<String, String> A5J(boolean z) {
        HashMap map = new HashMap();
        if (!C5V.A00().A04()) {
            map.put(A00(0, 23, 39), AnonymousClass92.A00().A01(this.A00, true).A79());
        }
        map.put(A00(23, 10, 114), AnonymousClass96.A06(new C14418i(this.A00), this.A00, z));
        return map;
    }
}
