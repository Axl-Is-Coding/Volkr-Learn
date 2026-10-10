package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YZ implements CA, CJ {
    public static byte[] A0J;
    public static String[] A0K;
    public static final CD A0L;
    public static final int A0M;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public CC A09;
    public IG A0A;
    public boolean A0B;
    public C1539Cq[] A0C;
    public long[][] A0D;
    public final int A0E;
    public final IG A0F;
    public final IG A0G;
    public final IG A0H;
    public final ArrayDeque<YR> A0I;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0J = new byte[]{57, 12, 23, 21, 88, 11, 17, 2, 29, 88, 20, 29, 11, 11, 88, 12, ci.n, 25, 22, 88, ci.n, 29, 25, 28, 29, 10, 88, 20, 29, 22, 31, 12, ci.n, 88, 80, ci.k, 22, 11, ci.k, 8, 8, 23, 10, 12, 29, 28, 81, 86, 4, 1, 85, 85};
    }

    public static void A08() {
        A0K = new String[]{"0jSfxoXEMfCjtmnyDugkNcQJRjSOySMa", "bnCyjA5DcUmWUqivzOXdDI", "awYt8cnKxKdhDKIItvFTiUYUED9yM0q1", "Luabopmg5NHaS5SoCXeHIbwAQFsLRvJ0", "odfzLqPoxtdmNhQ8QVXSS2", "Wo8IxRBaFRXe4oQbEdt7BomqryNllMGC", "1wQy", "sEQm6Nsu4XqoPKwwi3EdYrJfunZcOKFC"};
    }

    static {
        A08();
        A07();
        A0L = new YY();
        A0M = IW.A08(A04(48, 4, 105));
    }

    public YZ() {
        this(0);
    }

    public YZ(int i) {
        this.A0E = i;
        this.A0F = new IG(16);
        this.A0I = new ArrayDeque<>();
        this.A0H = new IG(IC.A03);
        this.A0G = new IG(4);
        this.A06 = -1;
    }

    private int A00(long preferredSkipAmount) {
        long j = Long.MAX_VALUE;
        int i = 1;
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        int trackIndex = 1;
        int sampleIndex = -1;
        int i3 = 0;
        while (true) {
            C1539Cq[] c1539CqArr = this.A0C;
            if (i3 >= c1539CqArr.length) {
                break;
            }
            C1539Cq c1539Cq = c1539CqArr[i3];
            int i4 = c1539Cq.A00;
            if (i4 != c1539Cq.A03.A01) {
                long j4 = c1539Cq.A03.A06[i4];
                long j5 = this.A0D[i3][i4];
                long j6 = j4 - preferredSkipAmount;
                int i5 = (j6 < 0 || j6 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) ? 1 : 0;
                if ((i5 == 0 && i != 0) || (i5 == i && j6 < j)) {
                    i = i5;
                    j = j6;
                    i2 = i3;
                    j2 = j5;
                }
                if (j5 < j3) {
                    j3 = j5;
                    trackIndex = i5;
                    sampleIndex = i3;
                }
            }
            i3++;
        }
        if (A0K[5].charAt(28) != 'l') {
            throw new RuntimeException();
        }
        String[] strArr = A0K;
        strArr[7] = "2rf3IkD44HipF2iEZWYVpECLVHr0uALb";
        strArr[0] = "2zlrhAiZVnIklu1FhIrlCsqVaSaq97eM";
        if (j3 == Long.MAX_VALUE || trackIndex == 0) {
            return i2;
        }
        long sampleOffset = 10485760 + j3;
        if (j2 < sampleOffset) {
            return i2;
        }
        return sampleIndex;
    }

    private int A01(CB cb, CH ch) throws InterruptedException, IOException {
        int i;
        long jA6t = cb.A6t();
        if (this.A06 == -1) {
            this.A06 = A00(jA6t);
            if (this.A06 == -1) {
                return -1;
            }
        }
        C1539Cq c1539Cq = this.A0C[this.A06];
        CM cm = c1539Cq.A01;
        int i2 = c1539Cq.A00;
        long j = c1539Cq.A03.A06[i2];
        int i3 = c1539Cq.A03.A05[i2];
        long inputPosition = j - jA6t;
        long position = inputPosition + ((long) this.A04);
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            ch.A00 = j;
            return 1;
        }
        if (c1539Cq.A02.A02 == 1) {
            position += 8;
            i3 -= 8;
        }
        cb.ADZ((int) position);
        if (c1539Cq.A02.A01 != 0) {
            byte[] bArr = this.A0G.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = c1539Cq.A02.A01;
            int i5 = 4 - c1539Cq.A02.A01;
            while (this.A04 < i3) {
                int i6 = this.A05;
                if (i6 == 0) {
                    byte[] nalLengthData = this.A0G.A00;
                    cb.readFully(nalLengthData, i5, i4);
                    this.A0G.A0Z(0);
                    this.A05 = this.A0G.A0I();
                    this.A0H.A0Z(0);
                    cm.ACx(this.A0H, 4);
                    this.A04 += 4;
                    i3 += i5;
                } else {
                    int writtenBytes = cm.ACw(cb, i6, false);
                    this.A04 += writtenBytes;
                    this.A05 -= writtenBytes;
                }
            }
            i = 0;
        } else {
            while (true) {
                int i7 = this.A04;
                if (i7 >= i3) {
                    break;
                }
                int iACw = cm.ACw(cb, i3 - i7, false);
                int writtenBytes2 = this.A04;
                this.A04 = writtenBytes2 + iACw;
                int writtenBytes3 = this.A05;
                this.A05 = writtenBytes3 - iACw;
            }
            i = 0;
        }
        cm.ACy(c1539Cq.A03.A07[i2], c1539Cq.A03.A04[i2], i3, 0, null);
        c1539Cq.A00++;
        this.A06 = -1;
        this.A04 = i;
        this.A05 = i;
        return i;
    }

    public static int A02(C1548Cz c1548Cz, long j) {
        int iA00 = c1548Cz.A00(j);
        if (iA00 == -1) {
            return c1548Cz.A01(j);
        }
        return iA00;
    }

    public static long A03(C1548Cz c1548Cz, long j, long j2) {
        int iA02 = A02(c1548Cz, j);
        if (iA02 == -1) {
            return j2;
        }
        return Math.min(c1548Cz.A06[iA02], j2);
    }

    private ArrayList<C1548Cz> A05(YR yr, CE ce, boolean z) throws AD {
        C1545Cw c1545CwA0C;
        ArrayList<C1548Cz> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int size = yr.A01.size();
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "cCqXKTxpaVHnB5xhxhubewm2proDizNi";
            strArr2[0] = "XNMFZPcuybbaYtAFLaJvO7GLnY5oO3YZ";
            if (i < size) {
                YR yr2 = yr.A01.get(i);
                if (((AbstractC1524Cb) yr2).A00 == AbstractC1524Cb.A1L && (c1545CwA0C = C1529Cg.A0C(yr2, yr.A07(AbstractC1524Cb.A0n), -9223372036854775807L, null, z, this.A0B)) != null) {
                    C1548Cz c1548CzA0E = C1529Cg.A0E(c1545CwA0C, yr2.A06(AbstractC1524Cb.A0d).A06(AbstractC1524Cb.A0h).A06(AbstractC1524Cb.A16), ce);
                    if (c1548CzA0E.A01 != 0) {
                        arrayList.add(c1548CzA0E);
                    }
                }
                i++;
            } else {
                return arrayList;
            }
        }
    }

    private void A06() {
        this.A03 = 0;
        this.A00 = 0;
    }

    private void A09(long j) throws AD {
        while (!this.A0I.isEmpty() && this.A0I.peek().A00 == j) {
            YR yrPop = this.A0I.pop();
            if (((AbstractC1524Cb) yrPop).A00 == AbstractC1524Cb.A0j) {
                A0B(yrPop);
                this.A0I.clear();
                this.A03 = 2;
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A08(yrPop);
            }
        }
        if (this.A03 != 2) {
            A06();
        }
    }

    private void A0A(long j) {
        for (C1539Cq c1539Cq : this.A0C) {
            C1548Cz c1548Cz = c1539Cq.A03;
            int iA00 = c1548Cz.A00(j);
            if (iA00 == -1) {
                iA00 = c1548Cz.A01(j);
            }
            c1539Cq.A00 = iA00;
        }
    }

    private void A0B(YR yr) throws AD {
        ArrayList<C1548Cz> arrayListA05;
        int size = -1;
        long jMax = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        Metadata metadata = null;
        CE ce = new CE();
        YS ysA07 = yr.A07(AbstractC1524Cb.A1P);
        if (ysA07 != null && (metadata = C1529Cg.A0F(ysA07, this.A0B)) != null) {
            ce.A06(metadata);
        }
        boolean ignoreEditLists = (this.A0E & 1) != 0;
        try {
            arrayListA05 = A05(yr, ce, ignoreEditLists);
        } catch (YV unused) {
            ce = new CE();
            arrayListA05 = A05(yr, ce, true);
        }
        int size2 = arrayListA05.size();
        for (int i = 0; i < size2; i++) {
            C1548Cz c1548Cz = arrayListA05.get(i);
            C1545Cw c1545Cw = c1548Cz.A03;
            C1539Cq c1539Cq = new C1539Cq(c1545Cw, c1548Cz, this.A09.ADr(i, c1545Cw.A03));
            int trackCount = c1548Cz.A00 + 30;
            Format formatA0G = c1545Cw.A07.A0G(trackCount);
            if (c1545Cw.A03 == 1) {
                if (ce.A04()) {
                    formatA0G = formatA0G.A0H(ce.A00, ce.A01);
                }
                if (metadata != null) {
                    formatA0G = formatA0G.A0K(metadata);
                }
            }
            c1539Cq.A01.A5I(formatA0G);
            jMax = Math.max(jMax, c1545Cw.A04 != -9223372036854775807L ? c1545Cw.A04 : c1548Cz.A02);
            int maxInputSize = c1545Cw.A03;
            if (maxInputSize == 2 && size == -1) {
                size = arrayList.size();
            }
            arrayList.add(c1539Cq);
        }
        this.A02 = size;
        this.A08 = jMax;
        this.A0C = (C1539Cq[]) arrayList.toArray(new C1539Cq[arrayList.size()]);
        this.A0D = A0H(this.A0C);
        this.A09.A54();
        this.A09.AD3(this);
    }

    public static boolean A0C(int i) {
        if (i != AbstractC1524Cb.A0j) {
            int i2 = AbstractC1524Cb.A1L;
            String[] strArr = A0K;
            if (strArr[4].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[2] = "xHWkCkmm9lwx55Xb6ilKRbCBaMi3tx91";
            strArr2[3] = "ufwmFaOIh4ETn2yFiF4b2v05oMaexVS8";
            if (i != i2 && i != AbstractC1524Cb.A0d && i != AbstractC1524Cb.A0h && i != AbstractC1524Cb.A16 && i != AbstractC1524Cb.A0N) {
                return false;
            }
        }
        return true;
    }

    public static boolean A0D(int i) {
        if (i != AbstractC1524Cb.A0c && i != AbstractC1524Cb.A0n && i != AbstractC1524Cb.A0V && i != AbstractC1524Cb.A1A && i != AbstractC1524Cb.A1D && i != AbstractC1524Cb.A1B) {
            int i2 = AbstractC1524Cb.A0C;
            if (A0K[1].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[1] = "WjfYMB7jPbcUwDvfNOpuH1";
            strArr[1] = "WjfYMB7jPbcUwDvfNOpuH1";
            if (i != i2 && i != AbstractC1524Cb.A0O && i != AbstractC1524Cb.A19 && i != AbstractC1524Cb.A1C && i != AbstractC1524Cb.A1E && i != AbstractC1524Cb.A17 && i != AbstractC1524Cb.A0B && i != AbstractC1524Cb.A1J && i != AbstractC1524Cb.A0U && i != AbstractC1524Cb.A1P) {
                return false;
            }
        }
        return true;
    }

    private boolean A0E(CB cb) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            if (!cb.ACL(this.A0F.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0F.A0Z(0);
            this.A07 = this.A0F.A0N();
            this.A01 = this.A0F.A09();
        }
        long j = this.A07;
        if (j == 1) {
            cb.readFully(this.A0F.A00, 8, 8);
            this.A00 += 8;
            this.A07 = this.A0F.A0O();
        } else if (j == 0) {
            long jA6a = cb.A6a();
            if (jA6a == -1 && !this.A0I.isEmpty()) {
                jA6a = this.A0I.peek().A00;
            }
            if (jA6a != -1) {
                this.A07 = (jA6a - cb.A6t()) + ((long) this.A00);
            }
        }
        if (this.A07 >= this.A00) {
            if (A0C(this.A01)) {
                long jA6t = (cb.A6t() + this.A07) - ((long) this.A00);
                this.A0I.push(new YR(this.A01, jA6t));
                if (this.A07 == this.A00) {
                    A09(jA6t);
                } else {
                    A06();
                }
            } else if (A0D(this.A01)) {
                C1662Hr.A04(this.A00 == 8);
                C1662Hr.A04(this.A07 <= 2147483647L);
                this.A0A = new IG((int) this.A07);
                System.arraycopy(this.A0F.A00, 0, this.A0A.A00, 0, 8);
                this.A03 = 1;
            } else {
                this.A0A = null;
                this.A03 = 1;
            }
            return true;
        }
        throw new AD(A04(0, 48, 100));
    }

    private boolean A0F(CB cb, CH ch) throws InterruptedException, IOException {
        long j = this.A07 - ((long) this.A00);
        long jA6t = cb.A6t() + j;
        boolean z = false;
        IG ig = this.A0A;
        if (ig != null) {
            cb.readFully(ig.A00, this.A00, (int) j);
            if (this.A01 == AbstractC1524Cb.A0U) {
                this.A0B = A0G(this.A0A);
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A09(new YS(this.A01, this.A0A));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            cb.ADZ((int) j);
        } else {
            ch.A00 = cb.A6t() + j;
            z = true;
        }
        A09(jA6t);
        return z && this.A03 != 2;
    }

    public static boolean A0G(IG ig) {
        ig.A0Z(8);
        if (ig.A09() == A0M) {
            return true;
        }
        ig.A0a(4);
        while (ig.A05() > 0) {
            if (ig.A09() == A0M) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0036 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long[][] A0H(com.facebook.ads.redexgen.X.C1539Cq[] r14) {
        /*
            int r0 = r14.length
            long[][] r6 = new long[r0][]
            int r0 = r14.length
            int[] r5 = new int[r0]
            int r0 = r14.length
            long[] r4 = new long[r0]
            int r0 = r14.length
            boolean[] r3 = new boolean[r0]
            r2 = 0
        Ld:
            int r0 = r14.length
            if (r2 >= r0) goto L28
            r0 = r14[r2]
            com.facebook.ads.redexgen.X.Cz r0 = r0.A03
            int r0 = r0.A01
            long[] r0 = new long[r0]
            r6[r2] = r0
            r0 = r14[r2]
            com.facebook.ads.redexgen.X.Cz r0 = r0.A03
            long[] r1 = r0.A07
            r0 = 0
            r0 = r1[r0]
            r4[r2] = r0
            int r2 = r2 + 1
            goto Ld
        L28:
            r12 = 0
            r2 = 0
        L2b:
            int r0 = r14.length
            if (r2 >= r0) goto L71
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = -1
            r1 = 0
        L35:
            int r0 = r14.length
            if (r1 >= r0) goto L48
            boolean r0 = r3[r1]
            if (r0 != 0) goto L45
            r7 = r4[r1]
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 > 0) goto L45
            r9 = r1
            r10 = r4[r1]
        L45:
            int r1 = r1 + 1
            goto L35
        L48:
            r7 = r5[r9]
            r0 = r6[r9]
            r0[r7] = r12
            r0 = r14[r9]
            com.facebook.ads.redexgen.X.Cz r0 = r0.A03
            int[] r0 = r0.A05
            r0 = r0[r7]
            long r0 = (long) r0
            long r12 = r12 + r0
            r1 = 1
            int r7 = r7 + r1
            r5[r9] = r7
            r0 = r6[r9]
            int r0 = r0.length
            if (r7 >= r0) goto L6c
            r0 = r14[r9]
            com.facebook.ads.redexgen.X.Cz r0 = r0.A03
            long[] r0 = r0.A07
            r0 = r0[r7]
            r4[r9] = r0
            goto L2b
        L6c:
            r3[r9] = r1
            int r2 = r2 + 1
            goto L2b
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YZ.A0H(com.facebook.ads.redexgen.X.Cq[]):long[][]");
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long secondTimeUs) {
        long j;
        long jA03;
        int iA01;
        C1539Cq[] c1539CqArr = this.A0C;
        if (c1539CqArr.length == 0) {
            return new CI(CK.A04);
        }
        long j2 = -9223372036854775807L;
        long jA032 = -1;
        int i = this.A02;
        if (i != -1) {
            C1548Cz c1548Cz = c1539CqArr[i].A03;
            int iA02 = A02(c1548Cz, secondTimeUs);
            if (iA02 == -1) {
                return new CI(CK.A04);
            }
            j = c1548Cz.A07[iA02];
            jA03 = c1548Cz.A06[iA02];
            if (j < secondTimeUs) {
                int i2 = c1548Cz.A01 - 1;
                if (A0K[5].charAt(28) == 'l') {
                    String[] strArr = A0K;
                    strArr[4] = "wZC6PUUkwbL39FGS7qgHi4";
                    strArr[6] = "ISWp";
                    if (iA02 < i2 && (iA01 = c1548Cz.A01(secondTimeUs)) != -1 && iA01 != iA02) {
                        j2 = c1548Cz.A07[iA01];
                        jA032 = c1548Cz.A06[iA01];
                    }
                }
            }
            throw new RuntimeException();
        }
        j = secondTimeUs;
        jA03 = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            C1539Cq[] c1539CqArr2 = this.A0C;
            if (A0K[5].charAt(28) != 'l') {
                break;
            }
            String[] strArr2 = A0K;
            strArr2[2] = "HuKpkwhwNffVsg1qOYm34WvQGcpzf7CA";
            strArr2[3] = "OpSxQ7AB5KpfVVm82hohcPrOWAs1xSas";
            if (i3 < c1539CqArr2.length) {
                if (i3 != this.A02) {
                    C1548Cz c1548Cz2 = c1539CqArr2[i3].A03;
                    jA03 = A03(c1548Cz2, j, jA03);
                    if (j2 != -9223372036854775807L) {
                        jA032 = A03(c1548Cz2, j2, jA032);
                    }
                }
                i3++;
            } else {
                CK ck = new CK(j, jA03);
                if (j2 == -9223372036854775807L) {
                    return new CI(ck);
                }
                return new CI(ck, new CK(j2, jA032));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A09 = cc;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        while (true) {
            int i = this.A03;
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "qJxbwGisfZf9YKIw0pjhTsx78598m8MK";
            strArr2[0] = "kX2rligkfJBBB9teOSCW5LaSmFhGBJWo";
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return A01(cb, ch);
                    }
                    throw new IllegalStateException();
                }
                if (A0F(cb, ch)) {
                    return 1;
                }
            } else if (!A0E(cb)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A0I.clear();
        this.A00 = 0;
        this.A06 = -1;
        this.A04 = 0;
        this.A05 = 0;
        if (j == 0) {
            A06();
        } else {
            if (this.A0C == null) {
                return;
            }
            A0A(j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        return C1543Cu.A05(cb);
    }
}
