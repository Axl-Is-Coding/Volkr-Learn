package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YK implements CS {
    public static byte[] A07;
    public int A00;
    public int A01;
    public long A02;
    public CU A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<CR> A05 = new ArrayDeque<>();
    public final CZ A04 = new CZ();

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{101, -118, -110, 125, -120, -123, -128, 60, -127, -120, -127, -119, -127, -118, -112, 60, -112, -107, -116, -127, 60, -73, -36, -28, -49, -38, -41, -46, -114, -44, -38, -35, -49, -30, -114, -31, -41, -24, -45, -88, -114, -95, -58, -50, -71, -60, -63, -68, 120, -63, -58, -52, -67, -65, -67, -54, 120, -53, -63, -46, -67, -110, 120, -64, -31, -33, -42, -37, -44, -115, -46, -39, -46, -38, -46, -37, -31, -115, -32, -42, -25, -46, -89, -115};
    }

    private double A00(CB cb, int i) throws InterruptedException, IOException {
        long jA02 = A02(cb, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) jA02);
        }
        return Double.longBitsToDouble(jA02);
    }

    private long A01(CB cb) throws InterruptedException, IOException {
        cb.ACt();
        while (true) {
            cb.ABs(this.A06, 0, 4);
            int iA00 = CZ.A00(this.A06[0]);
            if (iA00 != -1 && iA00 <= 4) {
                int iA01 = (int) CZ.A01(this.A06, iA00, false);
                if (this.A03.A7s(iA01)) {
                    cb.ADZ(iA00);
                    return iA01;
                }
            }
            cb.ADZ(1);
        }
    }

    private long A02(CB cb, int i) throws InterruptedException, IOException {
        cb.readFully(this.A06, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.A06[i2] & 255));
        }
        return j;
    }

    private String A04(CB cb, int trimmedLength) throws InterruptedException, IOException {
        if (trimmedLength == 0) {
            return A03(0, 0, 34);
        }
        byte[] bArr = new byte[trimmedLength];
        cb.readFully(bArr, 0, trimmedLength);
        while (trimmedLength > 0 && bArr[trimmedLength - 1] == 0) {
            trimmedLength--;
        }
        return new String(bArr, 0, trimmedLength);
    }

    @Override // com.facebook.ads.redexgen.X.CS
    public final void A7f(CU cu) {
        this.A03 = cu;
    }

    @Override // com.facebook.ads.redexgen.X.CS
    public final boolean ACI(CB cb) throws InterruptedException, IOException {
        C1662Hr.A04(this.A03 != null);
        while (true) {
            if (!this.A05.isEmpty() && cb.A6t() >= this.A05.peek().A01) {
                this.A03.A53(this.A05.pop().A00);
                return true;
            }
            if (this.A01 == 0) {
                long jA05 = this.A04.A05(cb, true, false, 4);
                if (jA05 == -2) {
                    jA05 = A01(cb);
                }
                if (jA05 == -1) {
                    return false;
                }
                this.A00 = (int) jA05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(cb, false, true, 8);
                this.A01 = 2;
            }
            int iA6D = this.A03.A6D(this.A00);
            if (iA6D != 0) {
                if (iA6D == 1) {
                    long jA6t = cb.A6t();
                    this.A05.push(new CR(this.A00, jA6t + this.A02));
                    this.A03.ADd(this.A00, jA6t, this.A02);
                    this.A01 = 0;
                    return true;
                }
                if (iA6D == 2) {
                    long j = this.A02;
                    if (j <= 8) {
                        this.A03.A7h(this.A00, A02(cb, (int) j));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AD(A03(41, 22, 60) + this.A02);
                }
                if (iA6D == 3) {
                    long j2 = this.A02;
                    if (j2 <= 2147483647L) {
                        this.A03.ADk(this.A00, A04(cb, (int) j2));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AD(A03(63, 21, 81) + this.A02);
                }
                if (iA6D == 4) {
                    this.A03.A3r(this.A00, (int) this.A02, cb);
                    this.A01 = 0;
                    return true;
                }
                if (iA6D == 5) {
                    long j3 = this.A02;
                    if (j3 == 4 || j3 == 8) {
                        this.A03.A5G(this.A00, A00(cb, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AD(A03(21, 20, 82) + this.A02);
                }
                throw new AD(A03(0, 21, 0) + iA6D);
            }
            cb.ADZ((int) this.A02);
            this.A01 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.CS
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
