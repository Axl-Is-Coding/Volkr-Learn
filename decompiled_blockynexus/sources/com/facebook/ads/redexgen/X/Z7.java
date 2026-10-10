package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z7 implements CA {
    public static byte[] A0C;
    public static String[] A0D;
    public static final CD A0E;
    public static final long A0F;
    public static final long A0G;
    public static final long A0H;
    public int A00;
    public int A01;
    public CC A02;
    public DV A03;
    public boolean A04;
    public final int A05;
    public final SparseArray<DV> A06;
    public final SparseBooleanArray A07;
    public final SparseIntArray A08;
    public final DT A09;
    public final IG A0A;
    public final List<IS> A0B;

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0G() {
        A0C = new byte[]{-90, -88, -110, -104, -12, 18, 31, 31, 32, 37, -47, 23, 26, 31, 21, -47, 36, 42, 31, 20, -47, 19, 42, 37, 22, -33, -47, -2, 32, 36, 37, -47, 29, 26, 28, 22, 29, 42, -47, 31, 32, 37, -47, 18, -47, 5, 35, 18, 31, 36, 33, 32, 35, 37, -47, 4, 37, 35, 22, 18, 30, -33, -98, -102, -100, -116, -61, -64, -47, -66};
    }

    public static void A0H() {
        A0D = new String[]{"1wQJeguTcmzEzlcqQISF6uciTtBYCHEI", "1z5HoD8RnfRsH4NGqOJrgtDb3AvWKmRf", "OZb5z3fyn7DmUcX5PD2FSiUNDYO3SJGv", "xysXnf11fptxvGLEVlqKxNXP96VBbPb9", "B9gj7Y4phCIGiISa5KNqUW4wq7x20Uai", "0XWjmjuElj7dnGBGcTqheWJCaJtkSIxV", "xem2h", "3rpnxRNe64JCaC2IexlmS1y9p5GeiPOv"};
    }

    static {
        A0H();
        A0G();
        A0E = new Z4();
        A0F = IW.A08(A0D(0, 4, 26));
        A0G = IW.A08(A0D(62, 4, 14));
        A0H = IW.A08(A0D(66, 4, 48));
    }

    public Z7() {
        this(0);
    }

    public Z7(int i) {
        this(1, i);
    }

    public Z7(int i, int i2) {
        this(i, new IS(0L), new C2093Yq(i2));
    }

    public Z7(int i, IS is, DT dt) {
        this.A09 = (DT) C1662Hr.A01(dt);
        this.A05 = i;
        if (i == 1 || i == 2) {
            this.A0B = Collections.singletonList(is);
        } else {
            this.A0B = new ArrayList();
            this.A0B.add(is);
        }
        this.A0A = new IG(new byte[9400], 0);
        this.A07 = new SparseBooleanArray();
        this.A06 = new SparseArray<>();
        this.A08 = new SparseIntArray();
        A0F();
    }

    public static /* synthetic */ int A01(Z7 z7) {
        int i = z7.A01;
        z7.A01 = i + 1;
        return i;
    }

    private void A0F() {
        this.A07.clear();
        this.A06.clear();
        SparseArray<DV> sparseArrayA4J = this.A09.A4J();
        int size = sparseArrayA4J.size();
        for (int i = 0; i < size; i++) {
            this.A06.put(sparseArrayA4J.keyAt(i), sparseArrayA4J.valueAt(i));
        }
        this.A06.put(0, new Z2(new Z5(this)));
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A02 = cc;
        cc.AD3(new YB(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0117, code lost:
    
        if (r8 == r9) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0119, code lost:
    
        r13.A0A.A0Z(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011f, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0125, code lost:
    
        if (r8 == r9) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
    
        r0 = r8 + 1;
        r8 = r0 & 15;
        r1 = com.facebook.ads.redexgen.X.Z7.A0D[1].charAt(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0138, code lost:
    
        if (r1 == 72) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013f, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0140, code lost:
    
        r2 = com.facebook.ads.redexgen.X.Z7.A0D;
        r2[3] = "dSZ0cSzoMmmORQANAKDw4NsHeD3mI6Jb";
        r2[3] = "dSZ0cSzoMmmORQANAKDw4NsHeD3mI6Jb";
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r9 == r8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        r3.AD1();
     */
    @Override // com.facebook.ads.redexgen.X.CA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int ACG(com.facebook.ads.redexgen.X.CB r14, com.facebook.ads.redexgen.X.CH r15) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z7.ACG(com.facebook.ads.redexgen.X.CB, com.facebook.ads.redexgen.X.CH):int");
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        int size = this.A0B.size();
        for (int i = 0; i < size; i++) {
            this.A0B.get(i).A09();
        }
        this.A0A.A0W();
        this.A08.clear();
        A0F();
        this.A00 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        r3 = r3 + 1;
     */
    @Override // com.facebook.ads.redexgen.X.CA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean ADa(com.facebook.ads.redexgen.X.CB r8) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r7 = this;
            com.facebook.ads.redexgen.X.IG r0 = r7.A0A
            byte[] r5 = r0.A00
            r4 = 0
            r0 = 940(0x3ac, float:1.317E-42)
            r8.ABs(r5, r4, r0)
            r3 = 0
        Lb:
            r6 = 188(0xbc, float:2.63E-43)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.Z7.A0D
            r0 = 1
            r1 = r1[r0]
            r0 = 3
            char r1 = r1.charAt(r0)
            r0 = 72
            if (r1 == r0) goto L21
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L21:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Z7.A0D
            java.lang.String r1 = "vUfHgSsJvwNFwwToyev4j8iiTP0xmLzC"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "vUfHgSsJvwNFwwToyev4j8iiTP0xmLzC"
            r0 = 1
            r2[r0] = r1
            if (r3 >= r6) goto L47
            r2 = 0
        L30:
            r0 = 5
            if (r2 != r0) goto L38
            r8.ADZ(r3)
            r0 = 1
            return r0
        L38:
            int r0 = r2 * 188
            int r0 = r0 + r3
            r1 = r5[r0]
            r0 = 71
            if (r1 == r0) goto L44
            int r3 = r3 + 1
            goto Lb
        L44:
            int r2 = r2 + 1
            goto L30
        L47:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z7.ADa(com.facebook.ads.redexgen.X.CB):boolean");
    }
}
