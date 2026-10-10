package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC13946d {
    A04(0),
    A05(100);

    public static byte[] A01;
    public static final Map<Integer, EnumC13946d> A02;
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-98, -97, -96, -101, -81, -90, -82, -104, -103, -105, -104};
    }

    static {
        A02();
        A02 = new HashMap();
        for (EnumC13946d enumC13946d : values()) {
            A02.put(Integer.valueOf(enumC13946d.A00), enumC13946d);
        }
    }

    EnumC13946d(int i) {
        this.A00 = i;
    }

    public static EnumC13946d A00(int i) {
        EnumC13946d enumC13946d = A02.get(Integer.valueOf(i));
        return enumC13946d == null ? A04 : enumC13946d;
    }
}
