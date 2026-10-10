package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YQ implements CA {
    public static byte[] A0E;
    public static String[] A0F;
    public static final CD A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public CC A04;
    public CM A05;
    public YP A06;
    public Metadata A07;
    public final int A08;
    public final long A09;
    public final CE A0A;
    public final CF A0B;
    public final CG A0C;
    public final IG A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{117, 82, 90, 83, 97, 87, 83, 64, 81, 90, 87, 86, 18, 70, 93, 93, 18, 95, 83, 92, 75, 18, 80, 75, 70, 87, 65, 28, 0, 20, 4, 31, 11, 58, 61, 52};
    }

    public static void A06() {
        A0F = new String[]{"ydp2W5xsf3wxxmCItZRtLRLpaCcQN61V", "ZzeQ67WJ6", "MfxT7BiZm", "QAZkmCdKFAHfN7ilsO4NsWCm7AIOdsAB", "uXA2W", "sq6CLgUZZ", "GhmTF3RrY3ydpwpSZCJZy8aIHeXkOr61", "710SvX7FP4z"};
    }

    static {
        A06();
        A05();
        A0G = new YO();
        A0J = IW.A08(A04(32, 4, 79));
        A0H = IW.A08(A04(0, 4, 32));
        A0I = IW.A08(A04(28, 4, 74));
    }

    public YQ() {
        this(0);
    }

    public YQ(int i) {
        this(i, -9223372036854775807L);
    }

    public YQ(int i, long j) {
        this.A08 = i;
        this.A09 = j;
        this.A0D = new IG(10);
        this.A0C = new CG();
        this.A0A = new CE();
        this.A02 = -9223372036854775807L;
        this.A0B = new CF();
    }

    private int A00(CB cb) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            cb.ACt();
            String[] strArr = A0F;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[0] = "k6Z5PTGWNQqxWVGEWp2g14fMjsllqw2H";
            strArr2[6] = "hJNgcdrxKvM79jF48EqDHnrsGOClnbxU";
            if (!cb.ABt(this.A0D.A00, 0, 4, true)) {
                return -1;
            }
            this.A0D.A0Z(0);
            int iA09 = this.A0D.A09();
            if (!A07(iA09, this.A01) || CG.A00(iA09) == -1) {
                cb.ADZ(1);
                this.A01 = 0;
                return 0;
            }
            CG.A05(iA09, this.A0C);
            if (this.A02 == -9223372036854775807L) {
                this.A02 = this.A06.A7D(cb.A6t());
                if (this.A09 != -9223372036854775807L) {
                    this.A02 += this.A09 - this.A06.A7D(0L);
                }
            }
            this.A00 = this.A0C.A02;
        }
        int iACw = this.A05.ACw(cb, this.A00, true);
        if (iACw == -1) {
            return -1;
        }
        this.A00 -= iACw;
        if (this.A00 > 0) {
            return 0;
        }
        this.A05.ACy(this.A02 + ((this.A03 * 1000000) / ((long) this.A0C.A03)), 1, this.A0C.A02, 0, null);
        this.A03 += (long) this.A0C.A04;
        this.A00 = 0;
        return 0;
    }

    public static int A01(IG ig, int i) {
        if (ig.A08() >= i + 4) {
            ig.A0Z(i);
            int iA09 = ig.A09();
            if (iA09 == A0J || iA09 == A0H) {
                return iA09;
            }
        }
        if (ig.A08() >= 40) {
            ig.A0Z(36);
            int iA092 = ig.A09();
            int i2 = A0I;
            if (iA092 == i2) {
                return i2;
            }
            return 0;
        }
        return 0;
    }

    private YP A02(CB cb) throws InterruptedException, IOException {
        cb.ABs(this.A0D.A00, 0, 4);
        this.A0D.A0Z(0);
        CG.A05(this.A0D.A09(), this.A0C);
        return new C7(cb.A6a(), cb.A6t(), this.A0C);
    }

    private YP A03(CB cb) throws InterruptedException, IOException {
        IG ig = new IG(this.A0C.A02);
        cb.ABs(ig.A00, 0, this.A0C.A02);
        int i = 21;
        if ((this.A0C.A05 & 1) != 0) {
            if (this.A0C.A01 != 1) {
                i = 36;
            }
        } else {
            int seekHeader = this.A0C.A01;
            if (seekHeader == 1) {
                i = 13;
            }
        }
        int iA01 = A01(ig, i);
        int seekHeader2 = A0J;
        if (iA01 != seekHeader2) {
            int seekHeader3 = A0H;
            if (iA01 != seekHeader3) {
                int seekHeader4 = A0I;
                if (iA01 == seekHeader4) {
                    C6 c6A00 = C6.A00(cb.A6a(), cb.A6t(), this.A0C, ig);
                    int seekHeader5 = this.A0C.A02;
                    cb.ADZ(seekHeader5);
                    return c6A00;
                }
                cb.ACt();
                return null;
            }
        }
        C3 c3A01 = C3.A01(cb.A6a(), cb.A6t(), this.A0C, ig);
        if (c3A01 != null && !this.A0A.A04()) {
            cb.ACt();
            int seekHeader6 = i + 141;
            cb.A3M(seekHeader6);
            cb.ABs(this.A0D.A00, 0, 3);
            this.A0D.A0Z(0);
            CE ce = this.A0A;
            int seekHeader7 = this.A0D.A0H();
            ce.A05(seekHeader7);
        }
        int seekHeader8 = this.A0C.A02;
        cb.ADZ(seekHeader8);
        if (c3A01 == null || c3A01.A80()) {
            return c3A01;
        }
        int seekHeader9 = A0H;
        if (iA01 == seekHeader9) {
            return A02(cb);
        }
        return c3A01;
    }

    public static boolean A07(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A08(com.facebook.ads.redexgen.X.CB r14, boolean r15) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YQ.A08(com.facebook.ads.redexgen.X.CB, boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A04 = cc;
        this.A05 = this.A04.ADr(0, 1);
        this.A04.A54();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        if (this.A01 == 0) {
            try {
                A08(cb, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A06 == null) {
            this.A06 = A03(cb);
            YP yp = this.A06;
            if (yp == null || (!yp.A80() && (this.A08 & 1) != 0)) {
                YP ypA02 = A02(cb);
                String[] strArr = A0F;
                if (strArr[2].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[3] = "vRoDRHRtSRtNnEEJ64K4r5ogXxosELXw";
                strArr2[3] = "vRoDRHRtSRtNnEEJ64K4r5ogXxosELXw";
                this.A06 = ypA02;
            }
            this.A04.AD3(this.A06);
            this.A05.A5I(Format.A05(null, this.A0C.A06, null, -1, 4096, this.A0C.A01, this.A0C.A03, -1, this.A0A.A00, this.A0A.A01, null, null, 0, null, (this.A08 & 2) != 0 ? null : this.A07));
        }
        return A00(cb);
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A01 = 0;
        this.A02 = -9223372036854775807L;
        this.A03 = 0L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        return A08(cb, true);
    }
}
