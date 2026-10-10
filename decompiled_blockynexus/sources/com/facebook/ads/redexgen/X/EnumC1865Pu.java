package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1865Pu {
    A05(true, false),
    A06(true, true);

    public static byte[] A02;
    public static String[] A03;
    public boolean A00;
    public boolean A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 69);
            if (A03[6].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "x5tPmx47tzICoGkmwmxxU8TFYjneGYu3";
            strArr[1] = "x5tPmx47tzICoGkmwmxxU8TFYjneGYu3";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{4, 2, 17, -56, -57, -53, -52};
    }

    public static void A02() {
        A03 = new String[]{"O", "EV50HHvcjD7YLIyebT4WEIV5yebebm0n", "F", "5eKOX", "rITyk", "abzOrFl3CNxf2rC8XtUXLAElYVzjlriN", "oaymDZ7pAEcbNFhv7Y0pKv8En2RbSAw", "1P4e8Svw6pgZkfS1AU7Ku11MIWhAZ0aY"};
    }

    static {
        A02();
        A01();
    }

    EnumC1865Pu(boolean z, boolean z2) {
        this.A00 = z;
        this.A01 = z2;
    }

    public final String A03() {
        return toString();
    }

    public final boolean A04() {
        return this.A00;
    }

    public final boolean A05() {
        return this.A01;
    }
}
