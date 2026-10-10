package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6 implements YP {
    public static byte[] A03;
    public static String[] A04;
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A04[1].charAt(18) != 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "IGRalwhGPANuEueVyyNisaHhdEkfW4kv";
        strArr[1] = "IGRalwhGPANuEueVyyNisaHhdEkfW4kv";
        A03 = new byte[]{-117, 127, -52, -72, -56, -65, -106, -38, -41, -22, -41, -106, -23, -33, -16, -37, -106, -29, -33, -23, -29, -41, -22, -39, -34, -80, -106, -74, -62, -46, -55, -77, -59, -59, -53, -59, -46};
    }

    public static void A03() {
        A04 = new String[]{"hwqziZW7AZPod2dXLouvGwTTrlxQftu5", "HWTvO3PtXP9N2f8hjjNBE5ELyu96O7C2", "XZiXxIUms072zxq0eptbFHl9id1xfsii", "R678H1T6QVa3UEsgGNCZuIT3k3f5TJMX", "R3CvDfTCre2oGIfhbqMtFAzPo9CSve3e", "yCxuKEdtUnEmK00296URo1FADbxWErUf", "IeIjE9tQRhU2QKWiPhSO822TtqgvRx0R", "yf6PTLZVRmp8JK3c15ye5co8mawgp7Wk"};
    }

    public C6(long[] jArr, long[] jArr2, long j) {
        this.A02 = jArr;
        this.A01 = jArr2;
        this.A00 = j;
    }

    public static C6 A00(long durationUs, long j, CG cg, IG ig) {
        int iA0F;
        long position = j;
        ig.A0a(10);
        int iA09 = ig.A09();
        if (iA09 <= 0) {
            return null;
        }
        int i = cg.A03;
        long jA0F = IW.A0F(iA09, 1000000 * ((long) (i >= 32000 ? 1152 : 576)), i);
        int iA0J = ig.A0J();
        int iA0J2 = ig.A0J();
        int iA0J3 = ig.A0J();
        ig.A0a(2);
        int scale = cg.A02;
        long j2 = position + ((long) scale);
        long[] jArr = new long[iA0J];
        long[] jArr2 = new long[iA0J];
        for (int i2 = 0; i2 < iA0J; i2++) {
            jArr[i2] = (((long) i2) * jA0F) / ((long) iA0J);
            jArr2[i2] = Math.max(position, j2);
            if (iA0J3 == 1) {
                iA0F = ig.A0F();
            } else if (iA0J3 == 2) {
                iA0F = ig.A0J();
            } else if (iA0J3 == 3) {
                iA0F = ig.A0H();
            } else {
                if (iA0J3 != 4) {
                    return null;
                }
                iA0F = ig.A0I();
            }
            position += (long) (iA0F * iA0J2);
            int segmentSize = A04[7].charAt(10);
            if (segmentSize == 80) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[5] = "SApHUsB0TeciBaZ8FVEH7XQ0HhkRahgp";
            strArr[4] = "ro1Cj1bOUorcqHsrq9aZZzvMMKgEvTZf";
        }
        if (durationUs != -1 && durationUs != position) {
            Log.w(A01(27, 10, 57), A01(2, 25, 79) + durationUs + A01(0, 2, 56) + position);
        }
        return new C6(jArr, jArr2, jA0F);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        int iA0B = IW.A0B(this.A02, j, true, true);
        CK ck = new CK(this.A02[iA0B], this.A01[iA0B]);
        if (ck.A01 < j) {
            long[] jArr = this.A02;
            if (iA0B != jArr.length - 1) {
                return new CI(ck, new CK(jArr[iA0B + 1], this.A01[iA0B + 1]));
            }
        }
        return new CI(ck);
    }

    @Override // com.facebook.ads.redexgen.X.YP
    public final long A7D(long j) {
        return this.A02[IW.A0B(this.A01, j, true, true)];
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return true;
    }
}
