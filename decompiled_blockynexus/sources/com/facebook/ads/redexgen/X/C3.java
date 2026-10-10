package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3 implements YP {
    public static byte[] A05;
    public static String[] A06;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long[] A04;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[0].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "xDmrh2CysME7FGpg0OVAAWQWrb1b5rm7";
            strArr2[5] = "xDmrh2CysME7FGpg0OVAAWQWrb1b5rm7";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 106);
            i4++;
        }
    }

    public static void A03() {
        String[] strArr = A06;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[5] = "O7i6ampyP1fRYbe4QOmd9JyFrRUTDP0J";
        strArr2[5] = "O7i6ampyP1fRYbe4QOmd9JyFrRUTDP0J";
        A05 = new byte[]{87, 91, 99, 114, 117, 124, 27, 95, 90, 79, 90, 27, 72, 82, 65, 94, 27, 86, 82, 72, 86, 90, 79, 88, 83, 1, 27, 82, 99, 100, 109, 89, 111, 111, 97, 111, 120};
    }

    public static void A04() {
        A06 = new String[]{"BIb1Y700RDmcL7JF9Fn", "lk1IRtv8jtyAOasrQbC6YrAcVcFJ9", "71nm4ncPUlnpG5PegzVfukIlQIS7yUOP", "GCiVubWGa77lALd1Rb0", "chLweuz0mMl4FbXf4CPkrAmx2V", "NRv5J71Oqm94bOZTTnySoFkmq1d86Acc", "fJm6FHaelFV0WMwBghon3E9Gns2th", "ObA7Byd4NJEP2M9ay6ZCFLfldVonyLqe"};
    }

    public C3(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    public C3(long j, int i, long j2, long j3, long[] jArr) {
        this.A02 = j;
        this.A00 = i;
        this.A03 = j2;
        this.A01 = j3;
        this.A04 = jArr;
    }

    private long A00(int i) {
        return (this.A03 * ((long) i)) / 100;
    }

    public static C3 A01(long j, long j2, CG cg, IG ig) {
        int flags;
        int i = cg.A04;
        int i2 = cg.A03;
        int iA09 = ig.A09();
        int samplesPerFrame = iA09 & 1;
        if (samplesPerFrame != 1 || (flags = ig.A0I()) == 0) {
            return null;
        }
        long dataSize = IW.A0F(flags, ((long) i) * 1000000, i2);
        int samplesPerFrame2 = iA09 & 6;
        if (samplesPerFrame2 != 6) {
            return new C3(j2, cg.A02, dataSize);
        }
        long jA0I = ig.A0I();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            long durationUs = ig.A0F();
            jArr[i3] = durationUs;
        }
        if (j != -1 && j != j2 + jA0I) {
            StringBuilder sb = new StringBuilder();
            sb.append(A02(2, 25, 81));
            sb.append(j);
            sb.append(A02(0, 2, 17));
            long durationUs2 = j2 + jA0I;
            sb.append(durationUs2);
            Log.w(A02(27, 10, 96), sb.toString());
        }
        return new C3(j2, cg.A02, dataSize, jA0I, jArr);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        double d2;
        if (!A80()) {
            return new CI(new CK(0L, this.A02 + ((long) this.A00)));
        }
        long jA0E = IW.A0E(j, 0L, this.A03);
        long timeUs = this.A03;
        double d3 = (jA0E * 100.0d) / timeUs;
        if (d3 <= 0.0d) {
            d2 = 0.0d;
        } else if (d3 >= 100.0d) {
            d2 = 256.0d;
        } else {
            int i = (int) d3;
            double prevScaledPosition = this.A04[i];
            if (A06[4].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[4] = "";
            strArr[4] = "";
            double nextScaledPosition = i;
            d2 = prevScaledPosition + (((i == 99 ? 256.0d : r9[i + 1]) - prevScaledPosition) * (d3 - nextScaledPosition));
        }
        long positionOffset = Math.round((d2 / 256.0d) * this.A01);
        return new CI(new CK(jA0E, this.A02 + IW.A0E(positionOffset, this.A00, this.A01 - 1)));
    }

    @Override // com.facebook.ads.redexgen.X.YP
    public final long A7D(long j) {
        double d2;
        long positionOffset = j - this.A02;
        if (A80()) {
            long j2 = this.A00;
            if (A06[4].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[5] = "XBnVl7Vf2qRXlKywSNR3LOgq8shxQKKO";
            strArr[5] = "XBnVl7Vf2qRXlKywSNR3LOgq8shxQKKO";
            if (positionOffset > j2) {
                double d3 = (positionOffset * 256.0d) / this.A01;
                int iA0B = IW.A0B(this.A04, (long) d3, true, true);
                long jA00 = A00(iA0B);
                long j3 = this.A04[iA0B];
                long jA002 = A00(iA0B + 1);
                if (j3 == (iA0B == 99 ? 256L : this.A04[iA0B + 1])) {
                    d2 = 0.0d;
                } else {
                    d2 = (d3 - j3) / (r8 - j3);
                }
                long nextScaledPosition = Math.round((jA002 - jA00) * d2);
                return nextScaledPosition + jA00;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return this.A04 != null;
    }
}
