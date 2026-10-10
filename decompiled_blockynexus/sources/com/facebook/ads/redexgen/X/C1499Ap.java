package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1499Ap implements InterfaceC2114Zo, CC, HN<C2111Zj>, HQ, FS {
    public static byte[] A0c;
    public static String[] A0d;
    public int A00;
    public int A01;
    public int A02;
    public long A04;
    public CJ A07;

    @Nullable
    public InterfaceC2113Zn A08;
    public TrackGroupArray A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean[] A0L;
    public boolean[] A0M;
    public boolean[] A0N;
    public final int A0O;
    public final long A0P;
    public final Uri A0Q;
    public final F2 A0S;
    public final F3 A0T;
    public final FJ A0U;
    public final H4 A0V;
    public final HC A0W;

    @Nullable
    public final String A0b;
    public final C2165af A0X = new C2165af(A07(0, 27, 82));
    public final C1668Hx A0Y = new C1668Hx();
    public final Runnable A0Z = new F0(this);
    public final Runnable A0a = new F1(this);
    public final Handler A0R = new Handler();
    public int[] A0J = new int[0];
    public C2115Zp[] A0K = new C2115Zp[0];
    public long A06 = -9223372036854775807L;
    public long A05 = -1;
    public long A03 = -9223372036854775807L;

    static {
        A0C();
        A0B();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0c, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0d[7].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[2] = "Up";
            strArr[2] = "Up";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 120);
            i4++;
        }
    }

    public static void A0B() {
        A0c = new byte[]{102, 69, 75, 78, 79, 88, ci.n, 111, 82, 94, 88, 75, 73, 94, 69, 88, 103, 79, 78, 67, 75, 122, 79, 88, 67, 69, 78};
    }

    public static void A0C() {
        A0d = new String[]{"iI0ZOGUFhjVKOFZqbUjTJbzZriBk", "wCM5SpVnQk8vEGvx3xuFkFQnwN8gnHkn", "CC", "sZUrtXRAji2vfBWVwphN9cenOJ8FQWpp", "F506DqgxlNyYyNAR0eHuGAxqIBb0RwxX", "mj8nEZtHpBznvwUNQKJPsV2u1H4", "sYtV3FATfn8NsU7nH3", "hZDPske6mXbyt4vhVom9Ng"};
    }

    public C1499Ap(Uri uri, HC hc, CA[] caArr, int i, FJ fj, F3 f3, H4 h4, @Nullable String str, int i2) {
        this.A0Q = uri;
        this.A0W = hc;
        this.A0O = i;
        this.A0U = fj;
        this.A0T = f3;
        this.A0V = h4;
        this.A0b = str;
        this.A0P = i2;
        this.A0S = new F2(caArr, this);
        this.A00 = i == -1 ? 3 : i;
        fj.A04();
    }

    private int A00() {
        int iA0D = 0;
        for (C2115Zp c2115Zp : this.A0K) {
            String[] strArr = A0d;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[3] = "qSOUgbz3JlJaX9UdXA1gn9agrJ83m9Y6";
            strArr2[1] = "wkCF1xtIBevCyUX610AjJpYT598Om9ct";
            iA0D += c2115Zp.A0D();
        }
        return iA0D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HN
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int AAJ(C2111Zj c2111Zj, long j, long j2, IOException iOException) {
        boolean isErrorFatal = A0O(iOException);
        this.A0U.A0I(c2111Zj.A03, 1, -1, null, 0, null, c2111Zj.A02, this.A03, j, j2, c2111Zj.A00, iOException, isErrorFatal);
        A0F(c2111Zj);
        if (isErrorFatal) {
            return 3;
        }
        int iA00 = A00();
        boolean z = iA00 > this.A02;
        if (A0M(c2111Zj, iA00)) {
            return z ? 1 : 0;
        }
        return 2;
    }

    private long A02() {
        long jMax = Long.MIN_VALUE;
        for (C2115Zp c2115Zp : this.A0K) {
            if (A0d[6].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[6] = "ZyGj31aUIwj7oXhThZ";
            strArr[6] = "ZyGj31aUIwj7oXhThZ";
            jMax = Math.max(jMax, c2115Zp.A0G());
        }
        return jMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        if (this.A0G || this.A0F || this.A07 == null || !this.A0H) {
            return;
        }
        for (C2115Zp sampleQueue : this.A0K) {
            if (sampleQueue.A0H() == null) {
                return;
            }
        }
        this.A0Y.A02();
        int length = this.A0K.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        this.A0N = new boolean[length];
        this.A0L = new boolean[length];
        this.A0M = new boolean[length];
        this.A03 = this.A07.A6C();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                Format formatA0H = this.A0K[i].A0H();
                trackGroupArr[i] = new TrackGroup(formatA0H);
                String str = formatA0H.A0O;
                if (!I9.A0C(str)) {
                    boolean zA0A = I9.A0A(str);
                    if (A0d[7].length() != 22) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0d;
                    strArr[4] = "sORkCePcQUNrHwPTmIu9z8sBJIN6eDJt";
                    strArr[4] = "sORkCePcQUNrHwPTmIu9z8sBJIN6eDJt";
                    if (!zA0A) {
                        z = false;
                    }
                }
                this.A0N[i] = z;
                boolean isAudioVideo = this.A0A;
                this.A0A = isAudioVideo | z;
                i++;
            } else {
                this.A09 = new TrackGroupArray(trackGroupArr);
                if (this.A0O == -1 && this.A05 == -1 && this.A07.A6C() == -9223372036854775807L) {
                    this.A00 = 6;
                }
                this.A0F = true;
                this.A0T.ABF(this.A03, this.A07.A80());
                this.A08.AAu(this);
                return;
            }
        }
    }

    private void A0A() {
        C2111Zj c2111Zj = new C2111Zj(this, this.A0Q, this.A0W, this.A0S, this.A0Y);
        if (this.A0F) {
            C1662Hr.A04(A0J());
            long j = this.A03;
            if (j != -9223372036854775807L && this.A06 >= j) {
                this.A0B = true;
                this.A06 = -9223372036854775807L;
                return;
            } else {
                c2111Zj.A05(this.A07.A6z(this.A06).A00.A00, this.A06);
                this.A06 = -9223372036854775807L;
            }
        }
        this.A02 = A00();
        this.A0U.A0F(c2111Zj.A03, 1, -1, null, 0, null, c2111Zj.A02, this.A03, this.A0X.A05(c2111Zj, this, this.A00));
    }

    private void A0D(int i) {
        if (!this.A0M[i]) {
            Format formatA02 = this.A09.A02(i).A02(0);
            this.A0U.A07(I9.A01(formatA02.A0O), formatA02, 0, null, this.A04);
            this.A0M[i] = true;
        }
    }

    private void A0E(int i) {
        if (!this.A0E || !this.A0N[i] || this.A0K[i].A0N()) {
            return;
        }
        this.A06 = 0L;
        this.A0E = false;
        this.A0D = true;
        this.A04 = 0L;
        this.A02 = 0;
        for (C2115Zp sampleQueue : this.A0K) {
            sampleQueue.A0J();
        }
        this.A08.A9X(this);
    }

    private void A0F(C2111Zj c2111Zj) {
        if (this.A05 != -1) {
            return;
        }
        this.A05 = c2111Zj.A01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HN
    /* JADX INFO: renamed from: A0G, reason: merged with bridge method [inline-methods] */
    public final void AAI(C2111Zj c2111Zj, long j, long j2) {
        long largestQueuedTimestampUs;
        if (this.A03 == -9223372036854775807L) {
            long jA02 = A02();
            if (jA02 == Long.MIN_VALUE) {
                largestQueuedTimestampUs = 0;
            } else {
                largestQueuedTimestampUs = 10000 + jA02;
            }
            this.A03 = largestQueuedTimestampUs;
            this.A0T.ABF(this.A03, this.A07.A80());
        }
        this.A0U.A0H(c2111Zj.A03, 1, -1, null, 0, null, c2111Zj.A02, this.A03, j, j2, c2111Zj.A00);
        A0F(c2111Zj);
        this.A0B = true;
        this.A08.A9X(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HN
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final void AAG(C2111Zj c2111Zj, long j, long j2, boolean z) {
        this.A0U.A0G(c2111Zj.A03, 1, -1, null, 0, null, c2111Zj.A02, this.A03, j, j2, c2111Zj.A00);
        if (!z) {
            A0F(c2111Zj);
            for (C2115Zp c2115Zp : this.A0K) {
                c2115Zp.A0J();
            }
            if (this.A01 > 0) {
                this.A08.A9X(this);
            }
        }
    }

    private boolean A0J() {
        return this.A06 != -9223372036854775807L;
    }

    private boolean A0K() {
        if (!this.A0D) {
            boolean zA0J = A0J();
            if (A0d[4].charAt(6) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[7] = "wEe5Kid34hKwvsAXbAWEFW";
            strArr[7] = "wEe5Kid34hKwvsAXbAWEFW";
            if (!zA0J) {
                return false;
            }
        }
        return true;
    }

    private boolean A0L(long j) {
        int length = this.A0K.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            C2115Zp sampleQueue = this.A0K[i];
            sampleQueue.A0K();
            if (!(sampleQueue.A0E(j, true, false) != -1) && (this.A0N[i] || !this.A0A)) {
                break;
            }
            i++;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        if (r7 != (-9223372036854775807L)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0M(com.facebook.ads.redexgen.X.C2111Zj r10, int r11) {
        /*
            r9 = this;
            long r1 = r9.A05
            r6 = 1
            r3 = -1
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L38
            com.facebook.ads.redexgen.X.CJ r0 = r9.A07
            if (r0 == 0) goto L41
            long r7 = r0.A6C()
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1499Ap.A0d
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L3b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1499Ap.A0d
            java.lang.String r1 = "Q0rpoNhjqPePbxzXOOIqRvZr1JNrttpQ"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "Q0rpoNhjqPePbxzXOOIqRvZr1JNrttpQ"
            r0 = 4
            r2[r0] = r1
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 == 0) goto L41
        L38:
            r9.A02 = r11
            return r6
        L3b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L41:
            boolean r0 = r9.A0F
            r5 = 0
            if (r0 == 0) goto L6f
            boolean r0 = r9.A0K()
            if (r0 != 0) goto L6f
            r9.A0E = r6
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1499Ap.A0d
            r0 = 4
            r1 = r1[r0]
            r0 = 6
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L69
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1499Ap.A0d
            java.lang.String r1 = "yM"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "yM"
            r0 = 2
            r2[r0] = r1
            return r5
        L69:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L6f:
            boolean r0 = r9.A0F
            r9.A0D = r0
            r2 = 0
            r9.A04 = r2
            r9.A02 = r5
            com.facebook.ads.redexgen.X.Zp[] r4 = r9.A0K
            int r1 = r4.length
        L7c:
            if (r5 >= r1) goto L86
            r0 = r4[r5]
            r0.A0J()
            int r5 = r5 + 1
            goto L7c
        L86:
            r10.A05(r2, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1499Ap.A0M(com.facebook.ads.redexgen.X.Zj, int):boolean");
    }

    public static boolean A0O(IOException iOException) {
        return iOException instanceof C2121Zv;
    }

    public final int A0P(int skipCount, long j) {
        int iA0E;
        if (A0K()) {
            return 0;
        }
        C2115Zp c2115Zp = this.A0K[skipCount];
        if (this.A0B && j > c2115Zp.A0G()) {
            iA0E = c2115Zp.A0B();
        } else {
            iA0E = c2115Zp.A0E(j, true, true);
            if (iA0E == -1) {
                iA0E = 0;
            }
        }
        if (iA0E > 0) {
            A0D(skipCount);
        } else {
            A0E(skipCount);
        }
        return iA0E;
    }

    public final int A0Q(int i, A7 a7, C2067Xq c2067Xq, boolean z) {
        if (A0K()) {
            return -3;
        }
        C2115Zp c2115Zp = this.A0K[i];
        boolean z2 = this.A0B;
        long j = this.A04;
        if (A0d[6].length() != 18) {
            throw new RuntimeException();
        }
        String[] strArr = A0d;
        strArr[4] = "BZZhA5HnQ267vlJC28K7sY9wv6QGzHwf";
        strArr[4] = "BZZhA5HnQ267vlJC28K7sY9wv6QGzHwf";
        int iA0F = c2115Zp.A0F(a7, c2067Xq, z, z2, j);
        if (iA0F == -4) {
            A0D(i);
        } else if (iA0F == -3) {
            A0E(i);
        }
        return iA0F;
    }

    public final void A0R() throws IOException {
        this.A0X.A07(this.A00);
    }

    public final void A0S() {
        if (this.A0F) {
            for (C2115Zp c2115Zp : this.A0K) {
                c2115Zp.A0I();
            }
        }
        this.A0X.A08(this);
        this.A0R.removeCallbacksAndMessages(null);
        this.A08 = null;
        this.A0G = true;
        this.A0U.A05();
    }

    public final boolean A0T(int i) {
        return !A0K() && (this.A0B || this.A0K[i].A0N());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final boolean A4A(long j) {
        if (this.A0B || this.A0E) {
            return false;
        }
        if (this.A0F) {
            int i = this.A01;
            if (A0d[4].charAt(6) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[4] = "7rVHsGRdVZCry1KpVG9eopTEFKGRMHdR";
            strArr[4] = "7rVHsGRdVZCry1KpVG9eopTEFKGRMHdR";
            if (i == 0) {
                return false;
            }
        }
        boolean zA03 = this.A0Y.A03();
        if (!this.A0X.A09()) {
            A0A();
            String[] strArr2 = A0d;
            if (strArr2[5].length() != strArr2[0].length()) {
                String[] strArr3 = A0d;
                strArr3[4] = "GZZ8Yg3MT0LKLUTCQO9quz1OXrB3914Q";
                strArr3[4] = "GZZ8Yg3MT0LKLUTCQO9quz1OXrB3914Q";
                return true;
            }
            String[] strArr4 = A0d;
            strArr4[4] = "KAHjzw5ailzTQNPlHwAo2zZrrjfyTj4F";
            strArr4[4] = "KAHjzw5ailzTQNPlHwAo2zZrrjfyTj4F";
            return false;
        }
        return zA03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void A4m(long j, boolean z) {
        int length = this.A0K.length;
        for (int i = 0; i < length; i++) {
            this.A0K[i].A0L(j, z, this.A0L[i]);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CC
    public final void A54() {
        this.A0H = true;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A5Q(long j, AV av) {
        if (!this.A07.A80()) {
            return 0L;
        }
        CI ciA6z = this.A07.A6z(j);
        return IW.A0I(j, av, ciA6z.A00.A01, ciA6z.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A5f() {
        long jA02;
        if (this.A0B) {
            return Long.MIN_VALUE;
        }
        if (A0J()) {
            long j = this.A06;
            if (A0d[6].length() == 18) {
                String[] strArr = A0d;
                strArr[4] = "v1DtQTmxA3FTsqocwnKPSJWZapJDPMlv";
                strArr[4] = "v1DtQTmxA3FTsqocwnKPSJWZapJDPMlv";
                return j;
            }
        } else {
            if (this.A0A) {
                jA02 = Long.MAX_VALUE;
                if (A0d[6].length() == 18) {
                    String[] strArr2 = A0d;
                    strArr2[7] = "vaKypmx8P8ApWe5d9yUSyn";
                    strArr2[7] = "vaKypmx8P8ApWe5d9yUSyn";
                    int length = this.A0K.length;
                    for (int i = 0; i < length; i++) {
                        if (this.A0N[i]) {
                            C2115Zp c2115Zp = this.A0K[i];
                            String[] strArr3 = A0d;
                            if (strArr3[5].length() == strArr3[0].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr4 = A0d;
                            strArr4[7] = "ClOx81htkGLxdwhy5PY2qE";
                            strArr4[7] = "ClOx81htkGLxdwhy5PY2qE";
                            jA02 = Math.min(jA02, c2115Zp.A0G());
                        }
                    }
                }
            } else {
                jA02 = A02();
            }
            if (jA02 == Long.MIN_VALUE) {
                return this.A04;
            }
            return jA02;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A6g() {
        if (this.A01 == 0) {
            return Long.MIN_VALUE;
        }
        return A5f();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final TrackGroupArray A7G() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void A8m() throws IOException {
        A0R();
    }

    @Override // com.facebook.ads.redexgen.X.HQ
    public final void AAN() {
        for (C2115Zp c2115Zp : this.A0K) {
            c2115Zp.A0J();
        }
        this.A0S.A04();
    }

    @Override // com.facebook.ads.redexgen.X.FS
    public final void ABW(Format format) {
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void AC1(InterfaceC2113Zn interfaceC2113Zn, long j) {
        this.A08 = interfaceC2113Zn;
        this.A0Y.A03();
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long ACK() {
        if (!this.A0C) {
            this.A0U.A06();
            this.A0C = true;
        }
        if (this.A0D) {
            if (this.A0B || A00() > this.A02) {
                this.A0D = false;
                return this.A04;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void ACS(long j) {
    }

    @Override // com.facebook.ads.redexgen.X.CC
    public final void AD3(CJ cj) {
        this.A07 = cj;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long AD6(long j) {
        if (!this.A07.A80()) {
            j = 0;
        }
        this.A04 = j;
        this.A0D = false;
        if (!A0J() && A0L(j)) {
            return j;
        }
        this.A0E = false;
        this.A06 = j;
        this.A0B = false;
        if (this.A0X.A09()) {
            this.A0X.A06();
        } else {
            for (C2115Zp sampleQueue : this.A0K) {
                sampleQueue.A0J();
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0130  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long AD7(com.facebook.ads.redexgen.X.InterfaceC1643Gy[] r13, boolean[] r14, com.facebook.ads.redexgen.X.FT[] r15, boolean[] r16, long r17) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1499Ap.AD7(com.facebook.ads.redexgen.X.Gy[], boolean[], com.facebook.ads.redexgen.X.FT[], boolean[], long):long");
    }

    @Override // com.facebook.ads.redexgen.X.CC
    public final CM ADr(int i, int i2) {
        int length = this.A0K.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.A0J[i3] == i) {
                return this.A0K[i3];
            }
        }
        C2115Zp c2115Zp = new C2115Zp(this.A0V);
        c2115Zp.A0M(this);
        this.A0J = Arrays.copyOf(this.A0J, length + 1);
        this.A0J[length] = i;
        this.A0K = (C2115Zp[]) Arrays.copyOf(this.A0K, length + 1);
        this.A0K[length] = c2115Zp;
        return c2115Zp;
    }
}
