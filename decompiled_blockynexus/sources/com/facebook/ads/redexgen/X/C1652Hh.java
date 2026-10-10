package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1652Hh {
    public static String[] A00;

    static {
        A03();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0088: INVOKE (r3 I:com.facebook.ads.redexgen.X.HC) STATIC call: com.facebook.ads.redexgen.X.IW.A0X(com.facebook.ads.redexgen.X.HC):void A[MD:(com.facebook.ads.redexgen.X.HC):void (m)], block:B:32:0x0088 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0092: INVOKE (r3 I:com.facebook.ads.redexgen.X.HC) STATIC call: com.facebook.ads.redexgen.X.IW.A0X(com.facebook.ads.redexgen.X.HC):void A[MD:(com.facebook.ads.redexgen.X.HC):void (m)], block:B:36:0x0092 */
    public static long A00(HG hg, long j, long j2, HC hc, byte[] bArr, IK ik, int i, C1651Hg c1651Hg) throws InterruptedException, IOException {
        HC hc2;
        while (true) {
            if (ik != null) {
                ik.A01(i);
            }
            try {
                break;
            } catch (IJ unused) {
            } finally {
                IW.A0X(hc2);
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        HG hg2 = new HG(hg.A04, hg.A06, j, (hg.A03 + j) - hg.A01, -1L, hg.A05, hg.A00 | 2);
        long jABi = hc2.ABi(hg2);
        if (c1651Hg.A01 == -1 && jABi != -1) {
            c1651Hg.A01 = hg2.A01 + jABi;
        }
        long j3 = 0;
        while (true) {
            if (j3 == j2) {
                break;
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i2 = hc2.read(bArr, 0, j2 != -1 ? (int) Math.min(bArr.length, j2 - j3) : bArr.length);
            if (i2 != -1) {
                j3 += (long) i2;
                c1651Hg.A02 += (long) i2;
            } else if (c1651Hg.A01 == -1) {
                c1651Hg.A01 = hg2.A01 + j3;
            }
        }
        return j3;
    }

    public static void A03() {
        A00 = new String[]{"v79OOCD3rFDrBH3Sw8ccat0nkfR9Jk8K", "zaqJSCMgPr8q8xIyOc2JWspWFv3JOD4h", "Sqp2xVCvxFHsc", "s8GBWRpegr", "t6Y6wcH7Q091ZQl7CdWm1Bgnnklpnco", "XVr0n", "MY0M4GS8ICKTpGygoaRzgsCYiOraPhWK", "Pkt85Yo8hwIimoTAGZdJTyJAkZ2fE06T"};
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(HG hg) {
        return hg.A05 != null ? hg.A05 : A01(hg.A04);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(com.facebook.ads.redexgen.X.HG r23, com.facebook.ads.redexgen.X.InterfaceC1646Hb r24, com.facebook.ads.redexgen.X.C2176aq r25, byte[] r26, com.facebook.ads.redexgen.X.IK r27, int r28, @androidx.annotation.Nullable com.facebook.ads.redexgen.X.C1651Hg r29, @androidx.annotation.Nullable java.util.concurrent.atomic.AtomicBoolean r30, boolean r31) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r4 = r29
            r19 = r25
            com.facebook.ads.redexgen.X.C1662Hr.A01(r19)
            r20 = r26
            com.facebook.ads.redexgen.X.C1662Hr.A01(r20)
            r6 = r24
            r14 = r23
            if (r4 == 0) goto Lb1
            A05(r14, r6, r4)
        L15:
            java.lang.String r5 = A02(r14)
            long r15 = r14.A01
            long r0 = r14.A02
            r12 = -1
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto Lab
            long r0 = r14.A02
        L25:
            r10 = 0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto Laa
            if (r30 == 0) goto L4b
            boolean r8 = r30.get()
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C1652Hh.A00
            r2 = 5
            r2 = r3[r2]
            int r3 = r2.length()
            r2 = 1
            if (r3 == r2) goto L81
            java.lang.String[] r7 = com.facebook.ads.redexgen.X.C1652Hh.A00
            java.lang.String r3 = "EAlW89nW7uOIImzUc5SW8CQaYz84C"
            r2 = 5
            r7[r2] = r3
            java.lang.String r3 = "EAlW89nW7uOIImzUc5SW8CQaYz84C"
            r2 = 5
            r7[r2] = r3
            if (r8 != 0) goto Lb8
        L4b:
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L68
            r25 = r0
        L51:
            r21 = r6
            r22 = r5
            r23 = r15
            long r2 = r21.A5h(r22, r23, r25)
            int r7 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r7 <= 0) goto L6e
        L5f:
            long r15 = r15 + r2
            int r7 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r7 != 0) goto L66
        L64:
            long r0 = r0 - r10
            goto L25
        L66:
            r10 = r2
            goto L64
        L68:
            r25 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L51
        L6e:
            long r7 = -r2
            java.lang.String[] r9 = com.facebook.ads.redexgen.X.C1652Hh.A00
            r2 = 6
            r3 = r9[r2]
            r2 = 1
            r2 = r9[r2]
            int r3 = r3.length()
            int r2 = r2.length()
            if (r3 == r2) goto L87
        L81:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L87:
            java.lang.String[] r9 = com.facebook.ads.redexgen.X.C1652Hh.A00
            java.lang.String r3 = "OFDha7Ysfl6kB"
            r2 = 2
            r9[r2] = r3
            java.lang.String r3 = "OFDha7Ysfl6kB"
            r2 = 2
            r9[r2] = r3
            r2 = r7
            r22 = r28
            r21 = r27
            r23 = r4
            r17 = r7
            long r8 = A00(r14, r15, r17, r19, r20, r21, r22, r23)
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 >= 0) goto L5f
            if (r31 == 0) goto Laa
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 != 0) goto Lbe
        Laa:
            return
        Lab:
            long r0 = r6.A5t(r5)
            goto L25
        Lb1:
            com.facebook.ads.redexgen.X.Hg r4 = new com.facebook.ads.redexgen.X.Hg
            r4.<init>()
            goto L15
        Lb8:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        Lbe:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1652Hh.A04(com.facebook.ads.redexgen.X.HG, com.facebook.ads.redexgen.X.Hb, com.facebook.ads.redexgen.X.aq, byte[], com.facebook.ads.redexgen.X.IK, int, com.facebook.ads.redexgen.X.Hg, java.util.concurrent.atomic.AtomicBoolean, boolean):void");
    }

    public static void A05(HG hg, InterfaceC1646Hb interfaceC1646Hb, C1651Hg c1651Hg) {
        long jA5t;
        String strA02 = A02(hg);
        long j = hg.A01;
        if (hg.A02 != -1) {
            jA5t = hg.A02;
        } else {
            jA5t = interfaceC1646Hb.A5t(strA02);
        }
        c1651Hg.A01 = jA5t;
        if (A00[5].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[4] = "nu";
        strArr[4] = "nu";
        c1651Hg.A00 = 0L;
        c1651Hg.A02 = 0L;
        while (jA5t != 0) {
            long start = interfaceC1646Hb.A5h(strA02, j, jA5t != -1 ? jA5t : Long.MAX_VALUE);
            if (start > 0) {
                c1651Hg.A00 += start;
            } else {
                start = -start;
                if (start == Long.MAX_VALUE) {
                    return;
                }
            }
            j += start;
            if (jA5t == -1) {
                start = 0;
            }
            jA5t -= start;
        }
    }

    public static void A06(InterfaceC1646Hb interfaceC1646Hb, String str) {
        for (C1650Hf c1650Hf : interfaceC1646Hb.A5i(str)) {
            if (A00[2].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[4] = "R4HmvLUlpWi57h";
            strArr[4] = "R4HmvLUlpWi57h";
            try {
                interfaceC1646Hb.ACh(c1650Hf);
            } catch (HZ unused) {
            }
        }
    }
}
