package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class L7 {
    public static byte[] A02;
    public long A00;
    public long A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{9, 46, 54, 33, 44, 41, 36, 96, 46, 53, 45, 34, 37, 50, 96, 47, 38, 96, 46, 33, 46, 47, 51, 37, 35, 47, 46, 36, 51, 96, 38, 47, 50, 96, 52, 40, 37, 96, 52, 41, 45, 37, 50, 122, 96, 101, 36};
    }

    public L7(long j) {
        if (j >= 0) {
            this.A00 = System.nanoTime() + j;
            this.A01 = j;
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(0, 47, 24), Long.valueOf(j)));
    }

    public final synchronized void A02() {
        this.A00 = System.nanoTime();
        notifyAll();
    }

    public final synchronized void A03() {
        this.A00 = System.nanoTime() + this.A01;
    }

    public final synchronized void A04() throws InterruptedException {
        while (!A05()) {
            long jMin = Math.min(this.A00 - System.nanoTime(), 1L);
            wait(jMin / 1000000000, (int) (jMin % 1000000000));
        }
    }

    public final synchronized boolean A05() {
        return System.nanoTime() >= this.A00;
    }
}
