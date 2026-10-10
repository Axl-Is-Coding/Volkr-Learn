package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12731i {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{69, 82, 64, 86, 69, 83, 82, 83, 104, 65, 94, 83, 82, 88};
    }

    public static void A02(AnonymousClass77 anonymousClass77, RO ro) {
        anonymousClass77.A0S(new AnonymousClass74(ro.A0O().A01(), OM.A04, OM.A04, ro.A0U(), A00(0, 14, 37)));
        anonymousClass77.A0W(new AnonymousClass76(ro.A0M().A0E().A08(), ro.A0U(), A00(0, 14, 37), ro.A0M().A0E().A05()));
        anonymousClass77.A0S(new AnonymousClass74(ro.A0M().A0E().A07(), C12681d.A00(ro.A0M().A0E()), C12681d.A01(ro.A0M().A0E()), ro.A0U(), A00(0, 14, 37)));
        Iterator<String> it = ro.A0M().A0H().A00().iterator();
        while (it.hasNext()) {
            anonymousClass77.A0S(new AnonymousClass74(it.next(), -1, -1, ro.A0U(), A00(0, 14, 37)));
        }
    }
}
