package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ie, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1673Ie {
    public static byte[] A02;
    public static String[] A03;
    public final int A00;
    public final List<byte[]> A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-22, 23, 23, 20, 23, -59, 21, 6, 23, 24, ci.l, 19, 12, -59, -19, -22, -5, -24, -59, 8, 20, 19, 11, ci.l, 12};
    }

    public static void A03() {
        A03 = new String[]{"bNwv9DTrsFpr", "zbhYB7daSjPcuvBmkTZuqaAPzZ9zn8h", "FRkSQOtD666PiwdWpMANCzaC3fIlZstE", "hSncHK0YMcK7Os9UUgTo3Hp6GRz3gib", "Da8z6HvdaVwrG586sIxSQ6hlHOkGiutI", "7Q5nL4gzRbsCGic6ITFl05T54duLJG5D", "soaxh0FZrqdNmpGhlM75NEwupCBAn2wQ", "H3bjs2QdHQpI"};
    }

    public C1673Ie(List<byte[]> initializationData, int i) {
        this.A01 = initializationData;
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
    
        r13.A0Z(r5);
        r7 = new byte[r9];
        r6 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r5 >= r10) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        r13.A0a(1);
        r4 = r13.A0J();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        if (r3 >= r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        r2 = r13.A0J();
        r11 = com.facebook.ads.redexgen.X.IC.A03;
        r0 = com.facebook.ads.redexgen.X.IC.A03.length;
        java.lang.System.arraycopy(r11, 0, r7, r6, r0);
        r0 = com.facebook.ads.redexgen.X.IC.A03.length;
        r6 = r6 + r0;
        r1 = r13.A00;
        r0 = r13.A07();
        java.lang.System.arraycopy(r1, r0, r7, r6, r2);
        r6 = r6 + r2;
        r13.A0a(r2);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        if (r9 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        r2 = java.util.Collections.singletonList(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
    
        return new com.facebook.ads.redexgen.X.C1673Ie(r2, r12 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1673Ie A00(com.facebook.ads.redexgen.X.IG r13) throws com.facebook.ads.redexgen.X.AD {
        /*
            r0 = 21
            r13.A0a(r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r13.A0F()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r12 = r0 & 3
            int r10 = r13.A0F()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r9 = 0
            int r5 = r13.A07()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r4 = 0
        L15:
            r8 = 1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1673Ie.A03
            r0 = 7
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1673Ie.A03
            java.lang.String r1 = "tNmJvjDEnkcZ"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "FarTxLmaqbLK"
            r0 = 0
            r2[r0] = r1
            if (r4 >= r10) goto L56
            r13.A0a(r8)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r3 = r13.A0J()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r2 = 0
        L44:
            if (r2 >= r3) goto L53
            int r1 = r13.A0J()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r1 + 4
            int r9 = r9 + r0
            r13.A0a(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r2 = r2 + 1
            goto L44
        L53:
            int r4 = r4 + 1
            goto L15
        L56:
            r13.A0Z(r5)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            byte[] r7 = new byte[r9]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r6 = 0
            r5 = 0
        L5d:
            if (r5 >= r10) goto L8d
            r13.A0a(r8)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r4 = r13.A0J()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r3 = 0
        L67:
            if (r3 >= r4) goto L8a
            int r2 = r13.A0J()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            byte[] r11 = com.facebook.ads.redexgen.X.IC.A03     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            r1 = 0
            byte[] r0 = com.facebook.ads.redexgen.X.IC.A03     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r0.length     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            java.lang.System.arraycopy(r11, r1, r7, r6, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            byte[] r0 = com.facebook.ads.redexgen.X.IC.A03     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r0.length     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r6 = r6 + r0
            byte[] r1 = r13.A00     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r13.A07()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            java.lang.System.arraycopy(r1, r0, r7, r6, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r6 = r6 + r2
            r13.A0a(r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r3 = r3 + 1
            goto L67
        L8a:
            int r5 = r5 + 1
            goto L5d
        L8d:
            if (r9 != 0) goto L91
            r2 = 0
            goto L95
        L91:
            java.util.List r2 = java.util.Collections.singletonList(r7)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
        L95:
            com.facebook.ads.redexgen.X.Ie r1 = new com.facebook.ads.redexgen.X.Ie     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            int r0 = r12 + 1
            r1.<init>(r2, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9d
            return r1
        L9d:
            r4 = move-exception
            com.facebook.ads.redexgen.X.AD r3 = new com.facebook.ads.redexgen.X.AD
            r2 = 0
            r1 = 25
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            r3.<init>(r0, r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1673Ie.A00(com.facebook.ads.redexgen.X.IG):com.facebook.ads.redexgen.X.Ie");
    }
}
