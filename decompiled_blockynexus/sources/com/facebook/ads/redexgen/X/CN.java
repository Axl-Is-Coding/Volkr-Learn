package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CN implements Handler.Callback, InterfaceC2113Zn, H0, F7, InterfaceC14759r, AO {
    public static byte[] A0V;
    public static String[] A0W;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public A3 A04;
    public AE A05;
    public F8 A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public XZ[] A0C;
    public final long A0D;
    public final Handler A0E;
    public final HandlerThread A0F;
    public final XT A0G;
    public final XX A0H;
    public final A9 A0J;
    public final AX A0L;
    public final AY A0M;
    public final H1 A0N;
    public final H2 A0O;
    public final InterfaceC1665Hu A0P;
    public final I4 A0Q;
    public final ArrayList<A1> A0R;
    public final boolean A0S;
    public final XZ[] A0T;
    public final AS[] A0U;
    public final AC A0K = new AC();
    public AV A06 = AV.A03;
    public final A2 A0I = new A2();

    static {
        A0L();
        A0K();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0V, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0K() {
        A0V = new byte[]{40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 87, 37, 12, 3, 9, 1, 8, 31, 25, 55, 62, Utf8.REPLACEMENT_BYTE, 34, 57, 62, 55, 112, 61, 53, 35, 35, 49, 55, 53, 35, 112, 35, 53, 62, 36, 112, 49, 54, 36, 53, 34, 112, 34, 53, 60, 53, 49, 35, 53, 126, 71, 96, 122, 107, 124, 96, 111, 98, 46, 124, 123, 96, 122, 103, 99, 107, 46, 107, 124, 124, 97, 124, 32, 50, ci.l, 3, 27, 0, 3, 1, 9, 66, 7, ci.n, ci.n, ci.k, ci.n, 76, 102, 90, 64, 71, 86, 80, 21, 80, 71, 71, 90, 71, 27, 74, 109, 118, 105, 57, 127, 120, 112, 117, 124, 125, 55, 119, 124, 64, 124, 126, 118, 68, 124, 97, 120};
    }

    public static void A0L() {
        A0W = new String[]{"86glHvEVsTHsOarjgO3yrK", "TuAJpp7uzbfmMtpdLTRiZnKK78MiZtWb", "2J1ujHTPZohQZteX1j6kCS7zhajZ8mZI", "eCxkC7v7XtRVNueTNXvbthBaIEqCwNNl", "l3Yyub2xLFiYeWCCac", "TG0XkoHYQCfebcNj4J", "6SVWI1Jvh0Z3jrcRBB9hLc8AjjQAtTry", "lVbeqNrXIfO7zu9EZv7JtI"};
    }

    public CN(XZ[] xzArr, H1 h1, H2 h2, A9 a9, boolean z, int i, boolean z2, Handler handler, XX xx, InterfaceC1665Hu interfaceC1665Hu) {
        this.A0T = xzArr;
        this.A0N = h1;
        this.A0O = h2;
        this.A0J = a9;
        this.A08 = z;
        this.A02 = i;
        this.A0B = z2;
        this.A0E = handler;
        this.A0H = xx;
        this.A0P = interfaceC1665Hu;
        this.A0D = a9.A5Y();
        this.A0S = a9.ACv();
        this.A05 = new AE(AZ.A01, -9223372036854775807L, TrackGroupArray.A04, h2);
        this.A0U = new AS[xzArr.length];
        for (int i2 = 0; i2 < xzArr.length; i2++) {
            xzArr[i2].ADG(i2);
            this.A0U[i2] = xzArr[i2].A5j();
        }
        this.A0G = new XT(this, interfaceC1665Hu);
        this.A0R = new ArrayList<>();
        this.A0C = new XZ[0];
        this.A0M = new AY();
        this.A0L = new AX();
        h1.A00(this);
        this.A0F = new HandlerThread(A06(21, 29, 15), -16);
        this.A0F.start();
        this.A0Q = interfaceC1665Hu.A4I(this.A0F.getLooper(), this);
    }

    private int A00() {
        AZ az = this.A05.A03;
        if (az.A0F()) {
            return 0;
        }
        return az.A0C(az.A06(this.A0B), this.A0M).A00;
    }

    private int A01(int i, AZ az, AZ az2) {
        int maxIterations = i;
        int iA05 = -1;
        int iA01 = az.A01();
        for (int i2 = 0; i2 < iA01 && iA05 == -1; i2++) {
            maxIterations = az.A04(maxIterations, this.A0L, this.A0M, this.A02, this.A0B);
            if (maxIterations == -1) {
                break;
            }
            iA05 = az2.A05(az.A0B(maxIterations, this.A0L, true).A03);
        }
        return iA05;
    }

    private long A02(F6 f6, long j) throws C14789u {
        return A03(f6, j, this.A0K.A0H() != this.A0K.A0I());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A03(com.facebook.ads.redexgen.X.F6 r11, long r12, boolean r14) throws com.facebook.ads.redexgen.X.C14789u {
        /*
            r10 = this;
            r10.A0H()
            r5 = 0
            r10.A09 = r5
            r6 = 2
            r10.A0O(r6)
            com.facebook.ads.redexgen.X.AC r0 = r10.A0K
            com.facebook.ads.redexgen.X.AA r1 = r0.A0H()
            r3 = r1
        L11:
            if (r3 == 0) goto L1e
            boolean r0 = r10.A0u(r11, r12, r3)
            if (r0 == 0) goto Lbf
            com.facebook.ads.redexgen.X.AC r0 = r10.A0K
            r0.A0T(r3)
        L1e:
            if (r1 != r3) goto L22
            if (r14 == 0) goto L6f
        L22:
            com.facebook.ads.redexgen.X.XZ[] r9 = r10.A0C
            int r8 = r9.length
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.CN.A0W
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 18
            if (r1 == r0) goto L38
        L32:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L38:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "MfZ5b0v7S5HL"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "MfZ5b0v7S5HL"
            r0 = 4
            r2[r0] = r1
            r7 = 0
        L45:
            if (r7 >= r8) goto L6a
            r4 = r9[r7]
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.CN.A0W
            r0 = 6
            r1 = r1[r0]
            r0 = 23
            char r1 = r1.charAt(r0)
            r0 = 106(0x6a, float:1.49E-43)
            if (r1 == r0) goto L32
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "gre2iAEzIfwakAGQE6Y0w4gvRDGAgj"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "gre2iAEzIfwakAGQE6Y0w4gvRDGAgj"
            r0 = 4
            r2[r0] = r1
            r10.A0c(r4)
            int r7 = r7 + 1
            goto L45
        L6a:
            com.facebook.ads.redexgen.X.XZ[] r0 = new com.facebook.ads.redexgen.X.XZ[r5]
            r10.A0C = r0
            r1 = 0
        L6f:
            if (r3 == 0) goto Lb5
            r10.A0W(r1)
            boolean r4 = r3.A05
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            r0 = 1
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L32
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "xpv6IUpjcorvZnU437"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "xpv6IUpjcorvZnU437"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto La9
            com.facebook.ads.redexgen.X.Zo r0 = r3.A08
            long r12 = r0.AD6(r12)
            com.facebook.ads.redexgen.X.Zo r5 = r3.A08
            long r3 = r10.A0D
            long r1 = r12 - r3
            boolean r0 = r10.A0S
            r5.A4m(r1, r0)
        La9:
            r10.A0Q(r12)
            r10.A09()
        Laf:
            com.facebook.ads.redexgen.X.I4 r0 = r10.A0Q
            r0.AD8(r6)
            return r12
        Lb5:
            com.facebook.ads.redexgen.X.AC r1 = r10.A0K
            r0 = 1
            r1.A0P(r0)
            r10.A0Q(r12)
            goto Laf
        Lbf:
            com.facebook.ads.redexgen.X.AC r0 = r10.A0K
            com.facebook.ads.redexgen.X.AA r3 = r0.A0D()
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CN.A03(com.facebook.ads.redexgen.X.F6, long, boolean):long");
    }

    private Pair<Integer, Long> A04(A3 a3, boolean z) {
        int iA01;
        AZ az = this.A05.A03;
        AZ az2 = a3.A02;
        if (az.A0F()) {
            return null;
        }
        if (az2.A0F()) {
            az2 = az;
        }
        try {
            Pair<Integer, Long> pairA08 = az2.A08(this.A0M, this.A0L, a3.A00, a3.A01);
            if (az == az2) {
                return pairA08;
            }
            int iA05 = az.A05(az2.A0B(((Integer) pairA08.first).intValue(), this.A0L, true).A03);
            if (iA05 != -1) {
                Integer numValueOf = Integer.valueOf(iA05);
                Object obj = pairA08.second;
                if (A0W[5].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0W;
                strArr[4] = "NzmvKaw5D7qN";
                strArr[4] = "NzmvKaw5D7qN";
                return Pair.create(numValueOf, obj);
            }
            if (!z || (iA01 = A01(((Integer) pairA08.first).intValue(), az2, az)) == -1) {
                return null;
            }
            int i = az.A0A(iA01, this.A0L).A00;
            String[] strArr2 = A0W;
            if (strArr2[1].charAt(27) == strArr2[2].charAt(27)) {
                return A05(az, i, -9223372036854775807L);
            }
            String[] strArr3 = A0W;
            strArr3[4] = "Yw40DLhiFndXC7wfBusX4OUMnHZHVu";
            strArr3[4] = "Yw40DLhiFndXC7wfBusX4OUMnHZHVu";
            return A05(az, i, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new A8(az, a3.A00, a3.A01);
        }
    }

    private Pair<Integer, Long> A05(AZ az, int i, long j) {
        return az.A08(this.A0M, this.A0L, i, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0074, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07() throws com.facebook.ads.redexgen.X.C14789u, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CN.A07():void");
    }

    private void A08() {
        A0O(4);
        A0p(false, true, false);
    }

    private void A09() {
        AA aaA0G = this.A0K.A0G();
        long jA07 = aaA0G.A07();
        if (jA07 == Long.MIN_VALUE) {
            A0l(false);
            return;
        }
        long bufferedDurationUs = jA07 - aaA0G.A09(this.A03);
        boolean zADR = this.A0J.ADR(bufferedDurationUs, this.A0G.A6s().A01);
        A0l(zADR);
        if (zADR) {
            long nextLoadPositionUs = this.A03;
            aaA0G.A0G(nextLoadPositionUs);
        }
    }

    private void A0A() {
        int i;
        if (this.A0I.A06(this.A05)) {
            Handler handler = this.A0E;
            int i2 = this.A0I.A01;
            if (this.A0I.A03) {
                i = this.A0I.A00;
            } else {
                i = -1;
            }
            handler.obtainMessage(0, i2, i, this.A05).sendToTarget();
            this.A0I.A05(this.A05);
        }
    }

    private void A0B() throws IOException {
        AA aaA0G = this.A0K.A0G();
        AA aaA0I = this.A0K.A0I();
        if (aaA0G != null && !aaA0G.A06) {
            if (aaA0I != null) {
                AA readingPeriodHolder = aaA0I.A01;
                if (readingPeriodHolder != aaA0G) {
                    return;
                }
            }
            for (XZ renderer : this.A0C) {
                if (!renderer.A7R()) {
                    return;
                }
            }
            aaA0G.A08.A8m();
        }
    }

    private void A0C() throws IOException {
        this.A0K.A0N(this.A03);
        if (this.A0K.A0R()) {
            AB abA0J = this.A0K.A0J(this.A03, this.A05);
            if (abA0J == null) {
                this.A07.A8n();
                return;
            }
            this.A0K.A0L(this.A0U, this.A0N, this.A0J.A5T(), this.A07, this.A05.A03.A0B(abA0J.A04.A02, this.A0L, true).A03, abA0J).AC1(this, abA0J.A03);
            A0l(true);
        }
    }

    private void A0D() {
        A0p(true, true, true);
        this.A0J.AB2();
        A0O(1);
        this.A0F.quit();
        synchronized (this) {
            this.A0A = true;
            notifyAll();
        }
    }

    private void A0E() throws C14789u {
        if (!this.A0K.A0Q()) {
            return;
        }
        float f2 = this.A0G.A6s().A01;
        AA aaA0I = this.A0K.A0I();
        boolean z = true;
        for (AA aaA0H = this.A0K.A0H(); aaA0H != null; aaA0H = aaA0H.A01) {
            boolean selectionsChangedForReadPeriod = aaA0H.A06;
            if (!selectionsChangedForReadPeriod) {
                return;
            }
            if (!aaA0H.A0J(f2)) {
                if (aaA0H == aaA0I) {
                    z = false;
                }
            } else {
                if (z) {
                    AA aaA0H2 = this.A0K.A0H();
                    boolean zA0T = this.A0K.A0T(aaA0H2);
                    boolean[] zArr = new boolean[this.A0T.length];
                    long jA0C = aaA0H2.A0C(this.A05.A0A, zA0T, zArr);
                    A0j(aaA0H2.A03, aaA0H2.A04);
                    if (this.A05.A00 != 4 && jA0C != this.A05.A0A) {
                        AE ae = this.A05;
                        this.A05 = ae.A04(ae.A04, jA0C, this.A05.A01);
                        this.A0I.A04(4);
                        A0Q(jA0C);
                    }
                    int i = 0;
                    int enabledRendererCount = this.A0T.length;
                    boolean[] zArr2 = new boolean[enabledRendererCount];
                    int i2 = 0;
                    while (true) {
                        XZ[] xzArr = this.A0T;
                        if (i2 >= xzArr.length) {
                            this.A05 = this.A05.A05(aaA0H2.A03, aaA0H2.A04);
                            A0q(zArr2, i);
                            break;
                        }
                        XZ xz = xzArr[i2];
                        zArr2[i2] = xz.A77() != 0;
                        FT ft = aaA0H2.A0A[i2];
                        if (ft != null) {
                            i++;
                        }
                        if (zArr2[i2]) {
                            FT ftA7C = xz.A7C();
                            int i3 = A0W[4].length();
                            if (i3 == 29) {
                                throw new RuntimeException();
                            }
                            String[] strArr = A0W;
                            strArr[4] = "CIOLNyaJNw";
                            strArr[4] = "CIOLNyaJNw";
                            if (ft != ftA7C) {
                                A0c(xz);
                            } else if (zArr[i2]) {
                                xz.ACu(this.A03);
                            }
                        }
                        i2++;
                    }
                } else {
                    this.A0K.A0T(aaA0H);
                    if (aaA0H.A06) {
                        aaA0H.A0B(Math.max(aaA0H.A02.A03, aaA0H.A09(this.A03)), false);
                        A0j(aaA0H.A03, aaA0H.A04);
                    }
                }
                if (this.A05.A00 != 4) {
                    A09();
                    A0J();
                    this.A0Q.AD8(2);
                    return;
                }
                return;
            }
        }
    }

    private void A0F() {
        for (int size = this.A0R.size() - 1; size >= 0; size--) {
            if (!A0s(this.A0R.get(size))) {
                this.A0R.get(size).A03.A0A(false);
                this.A0R.remove(size);
            }
        }
        Collections.sort(this.A0R);
    }

    private void A0G() throws C14789u {
        this.A09 = false;
        this.A0G.A05();
        for (XZ xz : this.A0C) {
            xz.start();
        }
    }

    private void A0H() throws C14789u {
        this.A0G.A06();
        for (XZ xz : this.A0C) {
            A0d(xz);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f1, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f9, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ff, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0200, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0122, code lost:
    
        r8 = r4.A04;
        r7 = r1.A0K.A0E();
        r6 = r7.A04;
        r9 = r7.A08.ACK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0144, code lost:
    
        if (com.facebook.ads.redexgen.X.CN.A0W[4].length() == 29) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0146, code lost:
    
        r3 = com.facebook.ads.redexgen.X.CN.A0W;
        r3[6] = "vjt4oSs9hMr9NwWN4mwojUjVUYrN8cQ6";
        r3[6] = "vjt4oSs9hMr9NwWN4mwojUjVUYrN8cQ6";
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0152, code lost:
    
        if (r9 == (-9223372036854775807L)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0154, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0155, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0156, code lost:
    
        r2 = r1.A0T;
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0159, code lost:
    
        if (r5 >= r0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015b, code lost:
    
        r4 = r2[r5];
        r0 = r8.A00(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0161, code lost:
    
        if (r0 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
    
        r5 = r5 + 1;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0167, code lost:
    
        if (r13 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0169, code lost:
    
        r4.ADE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0171, code lost:
    
        if (r4.A7k() != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0173, code lost:
    
        r12 = r6.A01.A01(r5);
        r11 = r6.A00(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0186, code lost:
    
        if (r1.A0U[r5].A7H() != 5) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0188, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0189, code lost:
    
        r3 = r8.A03[r5];
        r9 = r6.A03;
        r2 = com.facebook.ads.redexgen.X.CN.A0W;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a1, code lost:
    
        if (r2[1].charAt(27) == r2[2].charAt(27)) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a3, code lost:
    
        r2 = com.facebook.ads.redexgen.X.CN.A0W;
        r2[5] = "Ap10Ra2l8gLZ0YRne2";
        r2[5] = "Ap10Ra2l8gLZ0YRne2";
        r0 = r9[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b1, code lost:
    
        if (r11 == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b7, code lost:
    
        if (r0.equals(r3) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b9, code lost:
    
        if (r10 != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01bb, code lost:
    
        r3 = A0w(r12);
        r9 = r7.A0A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01cd, code lost:
    
        if (com.facebook.ads.redexgen.X.CN.A0W[3].charAt(0) == 'c') goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01cf, code lost:
    
        r2 = com.facebook.ads.redexgen.X.CN.A0W;
        r2[5] = "P6QWonkpaKbLAx4pgk";
        r2[5] = "P6QWonkpaKbLAx4pgk";
        r4.ACl(r3, r9[r5], r7.A08());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e6, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e8, code lost:
    
        r4.ADE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ed, code lost:
    
        if (r9 == (-9223372036854775807L)) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0I() throws com.facebook.ads.redexgen.X.C14789u, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CN.A0I():void");
    }

    private void A0J() throws C14789u {
        long jA0D;
        if (!this.A0K.A0Q()) {
            return;
        }
        AA aaA0H = this.A0K.A0H();
        long jACK = aaA0H.A08.ACK();
        if (jACK != -9223372036854775807L) {
            A0Q(jACK);
            long periodPositionUs = this.A05.A0A;
            if (jACK != periodPositionUs) {
                AE ae = this.A05;
                this.A05 = ae.A04(ae.A04, jACK, this.A05.A01);
                this.A0I.A04(4);
            }
        } else {
            this.A03 = this.A0G.A04();
            long jA09 = aaA0H.A09(this.A03);
            A0R(this.A05.A0A, jA09);
            this.A05.A0A = jA09;
        }
        AE ae2 = this.A05;
        if (this.A0C.length == 0) {
            jA0D = aaA0H.A02.A01;
        } else {
            jA0D = aaA0H.A0D(true);
        }
        ae2.A09 = jA0D;
    }

    private void A0M(float f2) {
        for (AA aaA0F = this.A0K.A0F(); aaA0F != null; aaA0F = aaA0F.A01) {
            if (aaA0F.A04 != null) {
                for (InterfaceC1643Gy trackSelection : aaA0F.A04.A01.A02()) {
                    if (trackSelection != null) {
                        trackSelection.AAn(f2);
                    }
                }
            }
        }
    }

    private void A0N(int i) throws C14789u {
        this.A02 = i;
        if (!this.A0K.A0S(i)) {
            A0k(true);
        }
    }

    private void A0O(int i) {
        if (this.A05.A00 != i) {
            this.A05 = this.A05.A02(i);
        }
    }

    private void A0P(int i, boolean z, int i2) throws C14789u {
        AA aaA0H = this.A0K.A0H();
        XZ xz = this.A0T[i];
        this.A0C[i2] = xz;
        if (xz.A77() == 0) {
            AT at = aaA0H.A04.A03[i];
            Format[] formatArrA0w = A0w(aaA0H.A04.A01.A01(i));
            boolean z2 = this.A08 && this.A05.A00 == 3;
            xz.A51(at, formatArrA0w, aaA0H.A0A[i], this.A03, !z && z2, aaA0H.A08());
            this.A0G.A09(xz);
            if (z2) {
                xz.start();
            }
        }
    }

    private void A0Q(long j) throws C14789u {
        if (this.A0K.A0Q()) {
            AA aaA0H = this.A0K.A0H();
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[0] = "3Dp2X759xi1gKy2gc8ykMJ";
            strArr[7] = "GcHSrS1OF4oxjH6XmPjhKR";
            j = aaA0H.A0A(j);
        }
        this.A03 = j;
        this.A0G.A07(this.A03);
        for (XZ xz : this.A0C) {
            xz.ACu(this.A03);
        }
    }

    private void A0R(long j, long j2) throws C14789u {
        A1 a1;
        if (this.A0R.isEmpty() || this.A05.A04.A02()) {
            return;
        }
        if (this.A05.A02 == j) {
            j--;
        }
        int i = this.A05.A04.A02;
        int i2 = this.A00;
        A1 a12 = i2 > 0 ? this.A0R.get(i2 - 1) : null;
        while (a12 != null) {
            if (a12.A00 <= i) {
                int i3 = a12.A00;
                if (A0W[3].charAt(0) == 'c') {
                    throw new RuntimeException();
                }
                String[] strArr = A0W;
                strArr[0] = "ZbbXGQ7fBHqOH9bFx5EieA";
                strArr[7] = "wqQaVgv9yDX8FIaCovLxd4";
                if (i3 != i || a12.A01 <= j) {
                    break;
                }
            }
            this.A00--;
            int i4 = this.A00;
            a12 = i4 > 0 ? this.A0R.get(i4 - 1) : null;
        }
        if (this.A00 < this.A0R.size()) {
            a1 = this.A0R.get(this.A00);
        } else {
            a1 = null;
        }
        while (a1 != null && a1.A02 != null && (a1.A00 < i || (a1.A00 == i && a1.A01 <= j))) {
            this.A00++;
            if (this.A00 < this.A0R.size()) {
                a1 = this.A0R.get(this.A00);
            } else {
                a1 = null;
            }
        }
        while (a1 != null && a1.A02 != null && a1.A00 == i && a1.A01 > j && a1.A01 <= j2) {
            A0a(a1.A03);
            if (a1.A03.A0B() || a1.A03.A0D()) {
                this.A0R.remove(this.A00);
            } else {
                this.A00++;
            }
            if (this.A00 < this.A0R.size()) {
                a1 = this.A0R.get(this.A00);
            } else {
                a1 = null;
            }
        }
    }

    private void A0S(long j, long j2) {
        this.A0Q.ACg(2);
        this.A0Q.AD9(2, j + j2);
    }

    private void A0T(A0 a0) throws C14789u {
        Object playingPeriodUid;
        if (a0.A01 != this.A07) {
            return;
        }
        AZ az = this.A05.A03;
        AZ az2 = a0.A00;
        Object manifest = a0.A02;
        this.A0K.A0O(az2);
        this.A05 = this.A05.A03(az2, manifest);
        A0F();
        int i = this.A01;
        if (i > 0) {
            this.A0I.A03(i);
            this.A01 = 0;
            A3 a3 = this.A04;
            if (a3 != null) {
                Pair<Integer, Long> pairA04 = A04(a3, true);
                this.A04 = null;
                if (pairA04 == null) {
                    A08();
                    return;
                }
                int iIntValue = ((Integer) pairA04.first).intValue();
                long jLongValue = ((Long) pairA04.second).longValue();
                F6 f6A0M = this.A0K.A0M(iIntValue, jLongValue);
                this.A05 = this.A05.A04(f6A0M, f6A0M.A02() ? 0L : jLongValue, jLongValue);
                return;
            }
            if (this.A05.A02 != -9223372036854775807L) {
                return;
            }
            boolean zA0F = az2.A0F();
            String[] strArr = A0W;
            if (strArr[1].charAt(27) == strArr[2].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[4] = "lH2oXw2RUPBHBuRA0";
            strArr2[4] = "lH2oXw2RUPBHBuRA0";
            if (zA0F) {
                A08();
                return;
            }
            Pair<Integer, Long> pairA05 = A05(az2, az2.A06(this.A0B), -9223372036854775807L);
            int iIntValue2 = ((Integer) pairA05.first).intValue();
            long jLongValue2 = ((Long) pairA05.second).longValue();
            F6 f6A0M2 = this.A0K.A0M(iIntValue2, jLongValue2);
            this.A05 = this.A05.A04(f6A0M2, f6A0M2.A02() ? 0L : jLongValue2, jLongValue2);
            return;
        }
        int i2 = this.A05.A04.A02;
        long j = this.A05.A01;
        if (az.A0F()) {
            if (!az2.A0F()) {
                F6 f6A0M3 = this.A0K.A0M(i2, j);
                this.A05 = this.A05.A04(f6A0M3, f6A0M3.A02() ? 0L : j, j);
                return;
            }
            return;
        }
        AA aaA0F = this.A0K.A0F();
        if (aaA0F == null) {
            AX ax = this.A0L;
            if (A0W[3].charAt(0) != 'c') {
                String[] strArr3 = A0W;
                strArr3[0] = "AIgzGczszMkheYOO0l2WDA";
                strArr3[7] = "AQm6fITMTu1q9a2hy8bL0W";
                playingPeriodUid = az.A0B(i2, ax, true).A03;
            } else {
                String[] strArr4 = A0W;
                strArr4[6] = "kxPd1uECtZJZCmNWUxsBgkB7loYAAl3C";
                strArr4[6] = "kxPd1uECtZJZCmNWUxsBgkB7loYAAl3C";
                playingPeriodUid = az.A0B(i2, ax, true).A03;
            }
        } else {
            playingPeriodUid = aaA0F.A09;
        }
        int iA05 = az2.A05(playingPeriodUid);
        if (iA05 == -1) {
            int iA01 = A01(i2, az, az2);
            if (iA01 == -1) {
                A08();
                return;
            }
            Pair<Integer, Long> pairA052 = A05(az2, az2.A0A(iA01, this.A0L).A00, -9223372036854775807L);
            int iIntValue3 = ((Integer) pairA052.first).intValue();
            long jLongValue3 = ((Long) pairA052.second).longValue();
            F6 f6A0M4 = this.A0K.A0M(iIntValue3, jLongValue3);
            az2.A0B(iIntValue3, this.A0L, true);
            if (aaA0F != null) {
                Object obj = this.A0L.A03;
                aaA0F.A02 = aaA0F.A02.A00(-1);
                while (aaA0F.A01 != null) {
                    aaA0F = aaA0F.A01;
                    if (aaA0F.A09.equals(obj)) {
                        aaA0F.A02 = this.A0K.A0K(aaA0F.A02, iIntValue3);
                    } else {
                        aaA0F.A02 = aaA0F.A02.A00(-1);
                    }
                }
            }
            this.A05 = this.A05.A04(f6A0M4, A02(f6A0M4, f6A0M4.A02() ? 0L : jLongValue3), jLongValue3);
            return;
        }
        if (iA05 != i2) {
            AE aeA01 = this.A05.A01(iA05);
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr5 = A0W;
            strArr5[4] = "bxSLNYRWzgoGTszax8Z4I";
            strArr5[4] = "bxSLNYRWzgoGTszax8Z4I";
            this.A05 = aeA01;
        }
        F6 f6 = this.A05.A04;
        if (f6.A02()) {
            F6 f6A0M5 = this.A0K.A0M(iA05, j);
            if (!f6A0M5.equals(f6)) {
                this.A05 = this.A05.A04(f6A0M5, A02(f6A0M5, f6A0M5.A02() ? 0L : j), j);
                return;
            }
        }
        if (!this.A0K.A0V(f6, this.A03)) {
            A0k(false);
        }
    }

    private void A0U(A3 a3) throws Throwable {
        long jLongValue;
        F6 f6A0M;
        long jLongValue2;
        boolean z;
        this.A0I.A03(1);
        Pair<Integer, Long> pairA04 = A04(a3, true);
        try {
            try {
                if (pairA04 == null) {
                    f6A0M = new F6(A00());
                    jLongValue2 = -9223372036854775807L;
                    jLongValue = -9223372036854775807L;
                    z = true;
                } else {
                    int iIntValue = ((Integer) pairA04.first).intValue();
                    jLongValue = ((Long) pairA04.second).longValue();
                    f6A0M = this.A0K.A0M(iIntValue, jLongValue);
                    if (f6A0M.A02()) {
                        jLongValue2 = 0;
                        String[] strArr = A0W;
                        if (strArr[0].length() == strArr[7].length()) {
                            String[] strArr2 = A0W;
                            strArr2[3] = "i2wx9svvSsraq7xK4Hb6P8jzWPWvECua";
                            strArr2[3] = "i2wx9svvSsraq7xK4Hb6P8jzWPWvECua";
                            z = true;
                        }
                        throw new RuntimeException();
                    }
                    jLongValue2 = ((Long) pairA04.second).longValue();
                    z = a3.A01 == -9223372036854775807L;
                }
                if (this.A07 != null && this.A01 <= 0) {
                    try {
                        if (jLongValue2 != -9223372036854775807L) {
                            long jA5Q = jLongValue2;
                            if (f6A0M.equals(this.A05.A04)) {
                                AA aaA0H = this.A0K.A0H();
                                String[] strArr3 = A0W;
                                if (strArr3[0].length() == strArr3[7].length()) {
                                    String[] strArr4 = A0W;
                                    strArr4[3] = "hQgZLd0P1yiuMRtM5yatEhywmfTa4Rur";
                                    strArr4[3] = "hQgZLd0P1yiuMRtM5yatEhywmfTa4Rur";
                                    if (aaA0H != null && jA5Q != 0) {
                                        jA5Q = aaA0H.A08.A5Q(jA5Q, this.A06);
                                    }
                                    if (C14729o.A01(jA5Q) == C14729o.A01(this.A05.A0A)) {
                                        this.A05 = this.A05.A04(f6A0M, this.A05.A0A, jLongValue);
                                        if (z) {
                                            this.A0I.A04(2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                throw new RuntimeException();
                            }
                            long jA02 = A02(f6A0M, jA5Q);
                            z |= jLongValue2 != jA02;
                            jLongValue2 = jA02;
                        } else {
                            A0O(4);
                            A0p(false, true, false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.A05 = this.A05.A04(f6A0M, jLongValue2, jLongValue);
                        if (z) {
                            this.A0I.A04(2);
                        }
                        throw th;
                    }
                } else {
                    this.A04 = a3;
                }
                this.A05 = this.A05.A04(f6A0M, jLongValue2, jLongValue);
                if (z) {
                    this.A0I.A04(2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void A0W(@Nullable AA aa) throws C14789u {
        AA aaA0H = this.A0K.A0H();
        if (aaA0H == null || aa == aaA0H) {
            return;
        }
        int i = 0;
        boolean[] zArr = new boolean[this.A0T.length];
        int i2 = 0;
        while (true) {
            XZ[] xzArr = this.A0T;
            if (i2 >= xzArr.length) {
                break;
            }
            XZ xz = xzArr[i2];
            zArr[i2] = xz.A77() != 0;
            if (aaA0H.A04.A00(i2)) {
                i++;
            }
            if (zArr[i2] && (!aaA0H.A04.A00(i2) || (xz.A7k() && xz.A7C() == aa.A0A[i2]))) {
                A0c(xz);
            }
            i2++;
        }
        AE ae = this.A05;
        if (A0W[6].charAt(23) == 'j') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[0] = "YeyTuc4hJN2cviDoFTSuVw";
        strArr[7] = "y3cCzPpceybwtUTWhAu8hu";
        this.A05 = ae.A05(aaA0H.A03, aaA0H.A04);
        A0q(zArr, i);
    }

    private void A0X(AF af) {
        this.A0G.ADM(af);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Y(AQ aq) throws C14789u {
        if (aq.A0D()) {
            return;
        }
        try {
            aq.A04().A7O(aq.A00(), aq.A09());
        } finally {
            aq.A0A(true);
        }
    }

    private void A0Z(AQ aq) throws C14789u {
        if (aq.A02() == -9223372036854775807L) {
            A0a(aq);
            return;
        }
        if (this.A07 == null || this.A01 > 0) {
            this.A0R.add(new A1(aq));
            return;
        }
        A1 a1 = new A1(aq);
        if (A0s(a1)) {
            ArrayList<A1> arrayList = this.A0R;
            String[] strArr = A0W;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[6] = "bdowkwDe22b4JBVUMCxt2Emm6YTTpUJh";
            strArr2[6] = "bdowkwDe22b4JBVUMCxt2Emm6YTTpUJh";
            arrayList.add(a1);
            Collections.sort(this.A0R);
            return;
        }
        aq.A0A(false);
    }

    private void A0a(AQ aq) throws C14789u {
        if (aq.A03().getLooper() == this.A0Q.A6b()) {
            A0Y(aq);
            if (this.A05.A00 == 3 || this.A05.A00 == 2) {
                this.A0Q.AD8(2);
                return;
            }
            return;
        }
        this.A0Q.A8v(15, aq).sendToTarget();
    }

    private void A0b(final AQ aq) {
        aq.A03().post(new Runnable() { // from class: com.facebook.ads.redexgen.X.9z
            public static byte[] A02;

            static {
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 119);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{-20, 31, 22, -9, 19, 8, 32, 12, 25, -16, 20, 23, 19, -16, 21, 27, 12, 25, 21, 8, 19, -30, -5, -14, 5, -3, -14, -16, 1, -14, -15, -83, -14, -1, -1, -4, -1, -83, -15, -14, -7, -10, 3, -14, -1, -10, -5, -12, -83, -6, -14, 0, 0, -18, -12, -14, -83, -4, -5, -83, -14, 5, 1, -14, -1, -5, -18, -7, -83, 1, -11, -1, -14, -18, -15, -69};
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    try {
                        this.A00.A0Y(aq);
                    } catch (C14789u e2) {
                        Log.e(A00(0, 21, 48), A00(21, 55, 22), e2);
                        throw new RuntimeException(e2);
                    }
                } catch (Throwable e3) {
                    KL.A00(e3, this);
                }
            }
        });
    }

    private void A0c(XZ xz) throws C14789u {
        this.A0G.A08(xz);
        A0d(xz);
        xz.A4k();
    }

    private void A0d(XZ xz) throws C14789u {
        if (xz.A77() == 2) {
            xz.stop();
        }
    }

    private void A0e(AV av) {
        this.A06 = av;
    }

    private void A0f(InterfaceC2114Zo interfaceC2114Zo) {
        if (!this.A0K.A0U(interfaceC2114Zo)) {
            return;
        }
        this.A0K.A0N(this.A03);
        A09();
    }

    private void A0g(InterfaceC2114Zo interfaceC2114Zo) throws C14789u {
        if (!this.A0K.A0U(interfaceC2114Zo)) {
            return;
        }
        AA aaA0G = this.A0K.A0G();
        aaA0G.A0F(this.A0G.A6s().A01);
        A0j(aaA0G.A03, aaA0G.A04);
        if (!this.A0K.A0Q()) {
            A0Q(this.A0K.A0D().A02.A03);
            A0W(null);
        }
        A09();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.FU
    /* JADX INFO: renamed from: A0h, reason: merged with bridge method [inline-methods] */
    public final void A9X(InterfaceC2114Zo interfaceC2114Zo) {
        this.A0Q.A8v(10, interfaceC2114Zo).sendToTarget();
    }

    private void A0i(F8 f8, boolean z, boolean z2) {
        this.A01++;
        A0p(true, z, z2);
        this.A0J.onPrepared();
        this.A07 = f8;
        A0O(2);
        f8.AC4(this.A0H, true, this);
        this.A0Q.AD8(2);
    }

    private void A0j(TrackGroupArray trackGroupArray, H2 h2) {
        this.A0J.ABR(this.A0T, trackGroupArray, h2.A01);
    }

    private void A0k(boolean z) throws C14789u {
        F6 f6 = this.A0K.A0H().A02.A04;
        long jA03 = A03(f6, this.A05.A0A, true);
        long newPositionUs = this.A05.A0A;
        if (jA03 != newPositionUs) {
            AE ae = this.A05;
            this.A05 = ae.A04(f6, jA03, ae.A01);
            if (z) {
                this.A0I.A04(4);
            }
        }
    }

    private void A0l(boolean z) {
        if (this.A05.A08 != z) {
            this.A05 = this.A05.A06(z);
        }
    }

    private void A0m(boolean z) throws C14789u {
        this.A09 = false;
        this.A08 = z;
        if (!z) {
            A0H();
            A0J();
            return;
        }
        if (this.A05.A00 == 3) {
            A0G();
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[6] = "X2QfJ1e23pCpGilE5nvaFXYxLnWx3Vax";
            strArr[6] = "X2QfJ1e23pCpGilE5nvaFXYxLnWx3Vax";
            this.A0Q.AD8(2);
            return;
        }
        if (this.A05.A00 != 2) {
            return;
        }
        this.A0Q.AD8(2);
    }

    private void A0n(boolean z) throws C14789u {
        this.A0B = z;
        if (!this.A0K.A0W(z)) {
            A0k(true);
        }
    }

    private void A0o(boolean z, boolean z2) {
        A0p(true, z, z);
        this.A0I.A03(this.A01 + (z2 ? 1 : 0));
        this.A01 = 0;
        this.A0J.ABL();
        A0O(1);
    }

    private void A0p(boolean z, boolean z2, boolean z3) {
        Object obj;
        long j;
        TrackGroupArray trackGroupArray;
        H2 h2;
        F8 f8;
        this.A0Q.ACg(2);
        this.A09 = false;
        this.A0G.A06();
        this.A03 = 0L;
        for (XZ renderer : this.A0C) {
            try {
                A0c(renderer);
            } catch (C14789u | RuntimeException e2) {
                Log.e(A06(0, 21, 15), A06(138, 12, 123), e2);
            }
        }
        this.A0C = new XZ[0];
        AC ac = this.A0K;
        String[] strArr = A0W;
        if (strArr[1].charAt(27) == strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0W;
        strArr2[0] = "2WNzaDjkqcOaPFAy0QOPwI";
        strArr2[7] = "unAKX8spYNQMyMddShLfR5";
        ac.A0P(!z2);
        A0l(false);
        if (z2) {
            this.A04 = null;
        }
        if (z3) {
            this.A0K.A0O(AZ.A01);
            for (A1 a1 : this.A0R) {
                if (A0W[5].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0W;
                strArr3[6] = "oYGfQB8mGDj6jmVX6XAe4nZE0DoRm7Og";
                strArr3[6] = "oYGfQB8mGDj6jmVX6XAe4nZE0DoRm7Og";
                a1.A03.A0A(false);
            }
            this.A0R.clear();
            this.A00 = 0;
        }
        AZ az = z3 ? AZ.A01 : this.A05.A03;
        if (z3) {
            obj = null;
        } else {
            obj = this.A05.A07;
        }
        F6 f6 = z2 ? new F6(A00()) : this.A05.A04;
        long j2 = -9223372036854775807L;
        if (z2) {
            j = -9223372036854775807L;
        } else {
            j = this.A05.A0A;
        }
        if (!z2) {
            j2 = this.A05.A01;
        }
        int i = this.A05.A00;
        if (z3) {
            trackGroupArray = TrackGroupArray.A04;
        } else {
            AE ae = this.A05;
            if (A0W[5].length() != 18) {
                trackGroupArray = ae.A05;
            } else {
                String[] strArr4 = A0W;
                strArr4[1] = "udHBd6VluCWpjwypGpbQkm44C5lEXr7W";
                strArr4[2] = "ikIjUWR3chEMULYYaopllYxVSgtPleKx";
                trackGroupArray = ae.A05;
            }
        }
        if (z3) {
            h2 = this.A0O;
        } else {
            h2 = this.A05.A06;
        }
        this.A05 = new AE(az, obj, f6, j, j2, i, false, trackGroupArray, h2);
        if (z && (f8 = this.A07) != null) {
            f8.ACd(this);
            this.A07 = null;
        }
    }

    private void A0q(boolean[] zArr, int i) throws C14789u {
        this.A0C = new XZ[i];
        int enabledRendererCount = 0;
        AA aaA0H = this.A0K.A0H();
        for (int i2 = 0; i2 < this.A0T.length; i2++) {
            if (aaA0H.A04.A00(i2)) {
                A0P(i2, zArr[i2], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A0r() {
        AA aaA0H = this.A0K.A0H();
        long j = aaA0H.A02.A01;
        return j == -9223372036854775807L || this.A05.A0A < j || (aaA0H.A01 != null && (aaA0H.A01.A06 || aaA0H.A01.A02.A04.A02()));
    }

    private boolean A0s(A1 a1) {
        if (a1.A02 == null) {
            Pair<Integer, Long> pairA04 = A04(new A3(a1.A03.A08(), a1.A03.A01(), C14729o.A00(a1.A03.A02())), false);
            if (pairA04 == null) {
                return false;
            }
            a1.A01(((Integer) pairA04.first).intValue(), ((Long) pairA04.second).longValue(), this.A05.A03.A0B(((Integer) pairA04.first).intValue(), this.A0L, true).A03);
        } else {
            int iA05 = this.A05.A03.A05(a1.A02);
            if (iA05 == -1) {
                return false;
            }
            a1.A00 = iA05;
        }
        return true;
    }

    private boolean A0t(XZ xz) {
        AA aaA0I = this.A0K.A0I();
        return aaA0I.A01 != null && aaA0I.A01.A06 && xz.A7R();
    }

    private boolean A0u(F6 f6, long j, AA aa) {
        if (f6.equals(aa.A02.A04) && aa.A06) {
            this.A05.A03.A0A(aa.A02.A04.A02, this.A0L);
            int iA04 = this.A0L.A04(j);
            if (iA04 == -1 || this.A0L.A09(iA04) == aa.A02.A02) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[PHI: r3
      0x006f: PHI (r3v2 long) = (r3v1 long), (r3v4 long) binds: [B:25:0x00a3, B:19:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0v(boolean r8) {
        /*
            r7 = this;
            com.facebook.ads.redexgen.X.XZ[] r0 = r7.A0C
            int r0 = r0.length
            if (r0 != 0) goto La
            boolean r0 = r7.A0r()
            return r0
        La:
            r6 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            r0 = 0
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L23
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L23:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "XitCw2lYTMNoWfZ3MNfhmS"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "pjSmPGutCkFid20LDJR8Tk"
            r0 = 7
            r2[r0] = r1
            if (r8 != 0) goto L32
            return r6
        L32:
            com.facebook.ads.redexgen.X.AE r0 = r7.A05
            boolean r0 = r0.A08
            r3 = 1
            if (r0 != 0) goto L3a
            return r3
        L3a:
            com.facebook.ads.redexgen.X.AC r0 = r7.A0K
            com.facebook.ads.redexgen.X.AA r5 = r0.A0G()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            r0 = 1
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L8a
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "c9QtbAseiMx42ehTAZ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "c9QtbAseiMx42ehTAZ"
            r0 = 5
            r2[r0] = r1
            com.facebook.ads.redexgen.X.AB r0 = r5.A02
            boolean r0 = r0.A05
            r0 = r0 ^ r3
            long r3 = r5.A0D(r0)
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L88
        L6f:
            com.facebook.ads.redexgen.X.A9 r2 = r7.A0J
            long r0 = r7.A03
            long r0 = r5.A09(r0)
            long r3 = r3 - r0
            com.facebook.ads.redexgen.X.XT r0 = r7.A0G
            com.facebook.ads.redexgen.X.AF r0 = r0.A6s()
            float r1 = r0.A01
            boolean r0 = r7.A09
            boolean r0 = r2.ADU(r3, r1, r0)
            if (r0 == 0) goto L89
        L88:
            r6 = 1
        L89:
            return r6
        L8a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CN.A0W
            java.lang.String r1 = "5BPuibQqZ5NKjWZyuTION1z1lHkA3o6b"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "lue4BzZmQF8ChJf2GK4Pk4NwU097v1o6"
            r0 = 2
            r2[r0] = r1
            com.facebook.ads.redexgen.X.AB r0 = r5.A02
            boolean r0 = r0.A05
            r0 = r0 ^ r3
            long r3 = r5.A0D(r0)
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L88
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CN.A0v(boolean):boolean");
    }

    @NonNull
    public static Format[] A0w(InterfaceC1643Gy interfaceC1643Gy) {
        int length = interfaceC1643Gy != null ? interfaceC1643Gy.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = interfaceC1643Gy.A6Q(i);
            if (A0W[3].charAt(0) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[1] = "cHoAaTwhCyKnC5gIlgOheFkD17ImOLE4";
            strArr[2] = "NdVO49IoL7wvUQC4on3mokgCd3AJvc50";
        }
        return formatArr;
    }

    public final Looper A0x() {
        return this.A0F.getLooper();
    }

    public final synchronized void A0y() {
        if (this.A0A) {
            return;
        }
        this.A0Q.AD8(7);
        boolean z = false;
        while (!this.A0A) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        if (A0W[3].charAt(0) == 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[5] = "ci8xVCbgf6WZorAiSg";
        strArr[5] = "ci8xVCbgf6WZorAiSg";
    }

    public final void A0z(AZ az, int i, long j) {
        this.A0Q.A8v(3, new A3(az, i, j)).sendToTarget();
    }

    public final void A10(F8 f8, boolean z, boolean z2) {
        this.A0Q.A8u(0, z ? 1 : 0, z2 ? 1 : 0, f8).sendToTarget();
    }

    public final void A11(boolean z) {
        this.A0Q.A8t(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void A12(boolean z) {
        this.A0Q.A8t(6, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14759r
    public final void AAm(AF af) {
        this.A0E.obtainMessage(1, af).sendToTarget();
        A0M(af.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2113Zn
    public final void AAu(InterfaceC2114Zo interfaceC2114Zo) {
        this.A0Q.A8v(9, interfaceC2114Zo).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.F7
    public final void ABG(F8 f8, AZ az, Object obj) {
        this.A0Q.A8v(8, new A0(f8, az, obj)).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.AO
    public final synchronized void ADA(AQ aq) {
        if (this.A0A) {
            Log.w(A06(0, 21, 15), A06(50, 37, 50));
            aq.A0A(false);
        } else {
            this.A0Q.A8v(14, aq).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA06 = A06(0, 21, 15);
        try {
            switch (message.what) {
                case 0:
                    A0i((F8) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    A0m(message.arg1 != 0);
                    break;
                case 2:
                    A07();
                    break;
                case 3:
                    A0U((A3) message.obj);
                    break;
                case 4:
                    A0X((AF) message.obj);
                    break;
                case 5:
                    A0e((AV) message.obj);
                    break;
                case 6:
                    A0o(message.arg1 != 0, true);
                    break;
                case 7:
                    A0D();
                    return true;
                case 8:
                    A0T((A0) message.obj);
                    break;
                case 9:
                    A0g((InterfaceC2114Zo) message.obj);
                    break;
                case 10:
                    A0f((InterfaceC2114Zo) message.obj);
                    break;
                case 11:
                    A0E();
                    break;
                case 12:
                    A0N(message.arg1);
                    break;
                case 13:
                    A0n(message.arg1 != 0);
                    break;
                case 14:
                    A0Z((AQ) message.obj);
                    break;
                case 15:
                    A0b((AQ) message.obj);
                    break;
                default:
                    return false;
            }
            A0A();
        } catch (C14789u e2) {
            Log.e(strA06, A06(110, 15, 0), e2);
            A0o(false, false);
            this.A0E.obtainMessage(2, e2).sendToTarget();
            A0A();
        } catch (IOException e3) {
            Log.e(strA06, A06(125, 13, 87), e3);
            A0o(false, false);
            this.A0E.obtainMessage(2, C14789u.A00(e3)).sendToTarget();
            A0A();
        } catch (RuntimeException e4) {
            Log.e(strA06, A06(87, 23, 108), e4);
            A0o(false, false);
            this.A0E.obtainMessage(2, C14789u.A02(e4)).sendToTarget();
            if (A0W[6].charAt(23) == 'j') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[5] = "BLVAUEtDSJNWXrvjpr";
            strArr[5] = "BLVAUEtDSJNWXrvjpr";
            A0A();
        }
        return true;
    }
}
