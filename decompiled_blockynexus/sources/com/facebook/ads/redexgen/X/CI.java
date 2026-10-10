package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CI {
    public static byte[] A02;
    public final CK A00;
    public final CK A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-54, -66, 1, 22};
    }

    public CI(CK ck) {
        this(ck, ck);
    }

    public CI(CK ck, CK ck2) {
        this.A00 = (CK) C1662Hr.A01(ck);
        this.A01 = (CK) C1662Hr.A01(ck2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CI ci = (CI) obj;
        return this.A00.equals(ci.A00) && this.A01.equals(ci.A01);
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }

    public final String toString() {
        String strA00;
        StringBuilder sb = new StringBuilder();
        sb.append(A00(2, 1, 88));
        sb.append(this.A00);
        if (this.A00.equals(this.A01)) {
            strA00 = A00(0, 0, 98);
        } else {
            strA00 = A00(0, 2, 80) + this.A01;
        }
        sb.append(strA00);
        sb.append(A00(3, 1, 107));
        return sb.toString();
    }
}
