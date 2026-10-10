package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YR extends AbstractC1524Cb {
    public static byte[] A03;
    public final long A00;
    public final List<YR> A01;
    public final List<YS> A02;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{0, 67, 79, 78, 84, 65, 73, 78, 69, 82, 83, 26, 0, -110, -34, -41, -45, -24, -41, -27, -84, -110};
    }

    public YR(int i, long j) {
        super(i);
        this.A00 = j;
        this.A02 = new ArrayList();
        this.A01 = new ArrayList();
    }

    public final YR A06(int i) {
        int size = this.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            YR yr = this.A01.get(i2);
            if (((AbstractC1524Cb) yr).A00 == i) {
                return yr;
            }
        }
        return null;
    }

    public final YS A07(int i) {
        int size = this.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            YS ys = this.A02.get(i2);
            if (((AbstractC1524Cb) ys).A00 == i) {
                return ys;
            }
        }
        return null;
    }

    public final void A08(YR yr) {
        this.A01.add(yr);
    }

    public final void A09(YS ys) {
        this.A02.add(ys);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1524Cb
    public final String toString() {
        return AbstractC1524Cb.A02(super.A00) + A04(13, 9, 15) + Arrays.toString(this.A02.toArray()) + A04(0, 13, 125) + Arrays.toString(this.A01.toArray());
    }
}
