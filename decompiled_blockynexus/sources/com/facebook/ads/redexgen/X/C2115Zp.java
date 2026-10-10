package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2115Zp implements CM {
    public static String[] A0F;
    public long A00;
    public long A01;
    public Format A02;
    public Format A03;
    public FR A04;
    public FR A05;
    public FR A06;
    public FS A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final H4 A0D;
    public final FQ A0C = new FQ();
    public final FP A0B = new FP();
    public final IG A0E = new IG(32);

    static {
        A02();
    }

    public static void A02() {
        A0F = new String[]{"I0oQBEUbvXwmLkE4WWtRMgz", "xnniIxRr7DxSpuMWabRYn3WDpy4qBN9b", "Y7uRaXgz80uNyvcPATB9r3b0PwOkuM1V", "hSCUvOutOZqOqVGgCzlnUKxaNOAoeOWK", "Xz3O4WRIuCzLKbQHyaIDpuywePn7", "cSGy8Fn9cMgpPa", "oA7ibzMCvoxqvUcH1m6Eely4XW9nrCN1", "6CG0cGfKidBjxaDlKmMoUzgrmHvkLCHY"};
    }

    public C2115Zp(H4 h4) {
        this.A0D = h4;
        this.A0A = h4.A6W();
        this.A04 = new FR(0L, this.A0A);
        FR fr = this.A04;
        this.A05 = fr;
        this.A06 = fr;
    }

    private int A00(int i) {
        if (!this.A06.A02) {
            this.A06.A02(this.A0D.A3N(), new FR(this.A06.A03, this.A0A));
        }
        return Math.min(i, (int) (this.A06.A03 - this.A01));
    }

    public static Format A01(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.A0G != Long.MAX_VALUE) {
            return format.A0I(format.A0G + j);
        }
        return format;
    }

    private void A03(int i) {
        this.A01 += (long) i;
        if (this.A01 == this.A06.A03) {
            this.A06 = this.A06.A00;
        }
    }

    private void A04(long j) {
        while (j >= this.A05.A03) {
            this.A05 = this.A05.A00;
        }
    }

    private void A05(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.A04.A03) {
            H4 h4 = this.A0D;
            H3 h3 = this.A04.A01;
            if (A0F[7].charAt(20) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[3] = "uyKFH8oWQ0ou8mdxvkWufQ8fbIwtl6Z0";
            strArr[1] = "5GODjm0a5UxNqoFNrNo0AvXndV19DDx4";
            h4.ACX(h3);
            this.A04 = this.A04.A01();
        }
        if (this.A05.A04 < this.A04.A04) {
            this.A05 = this.A04;
        }
    }

    private void A06(long j, ByteBuffer byteBuffer, int i) {
        A04(j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.A05.A03 - j));
            byteBuffer.put(this.A05.A01.A01, this.A05.A00(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A07(long j, byte[] bArr, int i) {
        A04(j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.A05.A03 - j));
            System.arraycopy(this.A05.A01.A01, this.A05.A00(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(com.facebook.ads.redexgen.X.C2067Xq r20, com.facebook.ads.redexgen.X.FP r21) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2115Zp.A08(com.facebook.ads.redexgen.X.Xq, com.facebook.ads.redexgen.X.FP):void");
    }

    private void A09(FR fr) {
        if (!fr.A02) {
            return;
        }
        boolean z = this.A06.A02;
        H3[] h3Arr = new H3[(z ? 1 : 0) + (((int) (this.A06.A04 - fr.A04)) / this.A0A)];
        for (int i = 0; i < h3Arr.length; i++) {
            h3Arr[i] = fr.A01;
            fr = fr.A01();
        }
        this.A0D.ACY(h3Arr);
    }

    private final void A0A(boolean z) {
        this.A0C.A0I(z);
        A09(this.A04);
        this.A04 = new FR(0L, this.A0A);
        FR fr = this.A04;
        this.A05 = fr;
        this.A06 = fr;
        this.A01 = 0L;
        this.A0D.ADs();
    }

    public final int A0B() {
        return this.A0C.A08();
    }

    public final int A0C() {
        return this.A0C.A06();
    }

    public final int A0D() {
        return this.A0C.A07();
    }

    public final int A0E(long j, boolean z, boolean z2) {
        return this.A0C.A09(j, z, z2);
    }

    public final int A0F(A7 a7, C2067Xq c2067Xq, boolean z, boolean z2, long j) {
        int iA0A = this.A0C.A0A(a7, c2067Xq, z, z2, this.A02, this.A0B);
        if (iA0A == -5) {
            this.A02 = a7.A00;
            return -5;
        }
        if (iA0A != -4) {
            if (iA0A == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!c2067Xq.A04()) {
            long j2 = c2067Xq.A00;
            if (A0F[7].charAt(20) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[2] = "VD6eroQucXdNz3MsoKHIT4kATW1JDfRN";
            strArr[2] = "VD6eroQucXdNz3MsoKHIT4kATW1JDfRN";
            if (j2 < j) {
                c2067Xq.A00(Integer.MIN_VALUE);
            }
            if (c2067Xq.A0A()) {
                A08(c2067Xq, this.A0B);
            }
            c2067Xq.A09(this.A0B.A00);
            A06(this.A0B.A01, c2067Xq.A01, this.A0B.A00);
        }
        return -4;
    }

    public final long A0G() {
        return this.A0C.A0C();
    }

    public final Format A0H() {
        return this.A0C.A0F();
    }

    public final void A0I() {
        A05(this.A0C.A0B());
    }

    public final void A0J() {
        A0A(false);
    }

    public final void A0K() {
        this.A0C.A0G();
        this.A05 = this.A04;
    }

    public final void A0L(long j, boolean z, boolean z2) {
        A05(this.A0C.A0E(j, z, z2));
    }

    public final void A0M(FS fs) {
        this.A07 = fs;
    }

    public final boolean A0N() {
        return this.A0C.A0J();
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void A5I(Format format) {
        Format formatA01 = A01(format, this.A00);
        boolean zA0L = this.A0C.A0L(formatA01);
        this.A03 = format;
        this.A08 = false;
        FS fs = this.A07;
        if (fs != null && zA0L) {
            fs.ABW(formatA01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final int ACw(CB cb, int i, boolean z) throws InterruptedException, IOException {
        int i2 = cb.read(this.A06.A01.A01, this.A06.A00(this.A01), A00(i));
        if (i2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        A03(i2);
        if (A0F[4].length() == 13) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[0] = "gj56WjutkODHGuBsULoCjgk";
        strArr[5] = "cXoHIYif5j6YkS";
        return i2;
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void ACx(IG ig, int i) {
        while (i > 0) {
            int iA00 = A00(i);
            ig.A0d(this.A06.A01.A01, this.A06.A00(this.A01), iA00);
            i -= iA00;
            A03(iA00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void ACy(long j, int i, int i2, int i3, CL cl) {
        if (this.A08) {
            A5I(this.A03);
        }
        if (this.A09) {
            if ((i & 1) != 0) {
                FQ fq = this.A0C;
                if (A0F[4].length() == 13) {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[3] = "x9Xeu0fQ5laTPGHIgNPQILpO6czCAzIw";
                strArr[1] = "ozcoxAULLkb5oe9KcRf5sNeK93qRoKsz";
                if (!fq.A0K(j)) {
                    return;
                }
                String[] strArr2 = A0F;
                if (strArr2[0].length() == strArr2[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0F;
                strArr3[7] = "2aF6Rrv8pvM6dW2iEnwFUFag8sTvrLLb";
                strArr3[7] = "2aF6Rrv8pvM6dW2iEnwFUFag8sTvrLLb";
                this.A09 = false;
            } else {
                return;
            }
        }
        long timeUs = j + this.A00;
        this.A0C.A0H(timeUs, i, (this.A01 - ((long) i2)) - ((long) i3), i2, cl);
    }
}
