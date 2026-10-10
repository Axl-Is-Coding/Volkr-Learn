package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC13303p implements Runnable {
    public static Comparator<C13293o> A04;
    public static byte[] A05;
    public static String[] A06;
    public static final ThreadLocal<RunnableC13303p> A07;
    public long A00;
    public long A01;
    public ArrayList<EI> A02 = new ArrayList<>();
    public ArrayList<C13293o> A03 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{97, 101, 47, 93, 116, -126, -125, 116, 115, 47, 95, -127, 116, 117, 116, -125, 114, 119, 92, 96, 42, 90, 124, 111, 112, 111, 126, 109, 114};
    }

    public static void A04() {
        A06 = new String[]{"C", "g", "thIgEQWd9nx", "UJ", "nKFIv9xSQBz", "WKzZJ6F0j2u08DpGCnjDR9E", "2Nt4JwZoKXCf4OpJNcF1oxTto7W5gJbD", "RW"};
    }

    static {
        A04();
        A03();
        A07 = new ThreadLocal<>();
        A04 = new Comparator<C13293o>() { // from class: com.facebook.ads.redexgen.X.3n
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C13293o c13293o, C13293o c13293o2) {
                if ((c13293o.A03 == null) != (c13293o2.A03 == null)) {
                    return c13293o.A03 == null ? 1 : -1;
                }
                if (c13293o.A04 != c13293o2.A04) {
                    return c13293o.A04 ? -1 : 1;
                }
                int i = c13293o2.A02 - c13293o.A02;
                if (i != 0) {
                    return i;
                }
                int i2 = c13293o.A00 - c13293o2.A00;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            }
        };
    }

    private C4W A00(EI ei, int i, long j) {
        if (A09(ei, i)) {
            return null;
        }
        C4M c4m = ei.A0r;
        try {
            ei.A1M();
            C4W c4wA0J = c4m.A0J(i, false, j);
            if (c4wA0J != null) {
                if (c4wA0J.A0b() && !c4wA0J.A0c()) {
                    c4m.A0Y(c4wA0J.A0H);
                } else {
                    c4m.A0e(c4wA0J, false);
                }
            }
            return c4wA0J;
        } finally {
            ei.A1r(false);
        }
    }

    private void A02() {
        C13293o task;
        int i = this.A02.size();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            EI ei = this.A02.get(i3);
            int totalTaskCount = ei.getWindowVisibility();
            if (totalTaskCount == 0) {
                ei.A02.A05(ei, false);
                int totalTaskCount2 = ei.A02.A00;
                i2 += totalTaskCount2;
            }
        }
        this.A03.ensureCapacity(i2);
        int i4 = 0;
        String[] strArr = A06;
        String str = strArr[3];
        String str2 = strArr[7];
        int length = str.length();
        int totalTaskCount3 = str2.length();
        if (length != totalTaskCount3) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[3] = "OH";
        strArr2[7] = "7S";
        for (int i5 = 0; i5 < i; i5++) {
            EI ei2 = this.A02.get(i5);
            int totalTaskCount4 = ei2.getWindowVisibility();
            if (totalTaskCount4 == 0) {
                SQ sq = ei2.A02;
                int iAbs = Math.abs(sq.A01) + Math.abs(sq.A02);
                for (int i6 = 0; i6 < sq.A00 * 2; i6 += 2) {
                    if (i4 >= this.A03.size()) {
                        task = new C13293o();
                        this.A03.add(task);
                    } else {
                        task = this.A03.get(i4);
                    }
                    int j = i6 + 1;
                    int i7 = sq.A03[j];
                    task.A04 = i7 <= iAbs;
                    task.A02 = iAbs;
                    task.A00 = i7;
                    task.A03 = ei2;
                    int j2 = sq.A03[i6];
                    task.A01 = j2;
                    i4++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    private void A05(long j) {
        for (int i = 0; i < this.A03.size(); i++) {
            C13293o c13293o = this.A03.get(i);
            if (c13293o.A03 == null) {
                return;
            }
            A07(c13293o, j);
            c13293o.A00();
        }
    }

    private final void A06(long j) {
        A02();
        A05(j);
    }

    private void A07(C13293o c13293o, long j) {
        C4W c4wA00 = A00(c13293o.A03, c13293o.A01, c13293o.A04 ? Long.MAX_VALUE : j);
        if (c4wA00 != null && c4wA00.A09 != null && c4wA00.A0b() && !c4wA00.A0c()) {
            A08(c4wA00.A09.get(), j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(@androidx.annotation.Nullable com.facebook.ads.redexgen.X.EI r7, long r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L3
            return
        L3:
            boolean r0 = r7.A0C
            if (r0 == 0) goto L2b
            com.facebook.ads.redexgen.X.3c r3 = r7.A01
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.RunnableC13303p.A06
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 17
            if (r1 == r0) goto L7c
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.RunnableC13303p.A06
            java.lang.String r1 = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW"
            r0 = 6
            r2[r0] = r1
            int r0 = r3.A07()
            if (r0 == 0) goto L2b
            r7.A1P()
        L2b:
            com.facebook.ads.redexgen.X.SQ r4 = r7.A02
            r0 = 1
            r4.A05(r7, r0)
            int r0 = r4.A00
            if (r0 == 0) goto L7b
            r2 = 0
            r1 = 18
            r0 = 7
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L73
            com.facebook.ads.redexgen.X.C2G.A01(r0)     // Catch: java.lang.Throwable -> L73
            com.facebook.ads.redexgen.X.4T r1 = r7.A0s     // Catch: java.lang.Throwable -> L73
            com.facebook.ads.redexgen.X.42 r0 = r7.A04     // Catch: java.lang.Throwable -> L73
            r1.A05(r0)     // Catch: java.lang.Throwable -> L73
            r3 = 0
        L48:
            int r0 = r4.A00     // Catch: java.lang.Throwable -> L73
            int r5 = r0 * 2
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.RunnableC13303p.A06
            r0 = 6
            r1 = r1[r0]
            r0 = 8
            char r1 = r1.charAt(r0)
            r0 = 73
            if (r1 == r0) goto L7c
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.RunnableC13303p.A06
            java.lang.String r1 = "nG"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "TD"
            r0 = 7
            r2[r0] = r1
            if (r3 >= r5) goto L78
            int[] r0 = r4.A03     // Catch: java.lang.Throwable -> L73
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L73
            r6.A00(r7, r0, r8)     // Catch: java.lang.Throwable -> L73
            int r3 = r3 + 2
            goto L48
        L73:
            r0 = move-exception
            com.facebook.ads.redexgen.X.C2G.A00()
            throw r0
        L78:
            com.facebook.ads.redexgen.X.C2G.A00()
        L7b:
            return
        L7c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC13303p.A08(com.facebook.ads.redexgen.X.EI, long):void");
    }

    public static boolean A09(EI ei, int i) {
        int iA07 = ei.A01.A07();
        for (int i2 = 0; i2 < iA07; i2++) {
            View attachedView = ei.A01.A0B(i2);
            C4W c4wA0G = EI.A0G(attachedView);
            if (c4wA0G.A03 == i && !c4wA0G.A0c()) {
                return true;
            }
        }
        return false;
    }

    public final void A0A(EI ei) {
        this.A02.add(ei);
    }

    public final void A0B(EI ei) {
        this.A02.remove(ei);
    }

    public final void A0C(EI ei, int i, int i2) {
        if (ei.isAttachedToWindow() && this.A01 == 0) {
            this.A01 = ei.getNanoTime();
            ei.post(this);
        }
        ei.A02.A04(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C2G.A01(A01(18, 11, 2));
            if (this.A02.isEmpty()) {
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                EI ei = this.A02.get(i);
                int i2 = ei.getWindowVisibility();
                if (i2 == 0) {
                    jMax = Math.max(ei.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.A01 = 0L;
                if (A06[5].length() == 17) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "H4nD1dOrFb1";
                strArr[5] = "H4nD1dOrFb1";
                C2G.A00();
                return;
            }
            long latestFrameVsyncMs = TimeUnit.MILLISECONDS.toNanos(jMax);
            A06(latestFrameVsyncMs + this.A00);
        } finally {
            this.A01 = 0L;
            C2G.A00();
        }
    }
}
