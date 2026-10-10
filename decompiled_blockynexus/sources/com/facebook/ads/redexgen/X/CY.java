package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CY {
    public static String[] A02;
    public int A00;
    public final IG A01 = new IG(8);

    static {
        A01();
    }

    public static void A01() {
        A02 = new String[]{"6bTYjI7xiahg1uqAV8eewLZrNfj9ZPj", "ngeXPKLRRDCcDwFHaGe0eDwdNk9MsKP0", "GKtDxJ6", "TMKYymqQa", "6hy2FBj", "omQP2HfChml3facH7odpRvVYds2Y", "0Yg", "2mziQBXjxxZN6M5afK2REUi5LMQCqiEi"};
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x001b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A00(com.facebook.ads.redexgen.X.CB r8) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r7 = this;
            com.facebook.ads.redexgen.X.IG r0 = r7.A01
            byte[] r0 = r0.A00
            r1 = 0
            r5 = 1
            r8.ABs(r0, r1, r5)
            com.facebook.ads.redexgen.X.IG r0 = r7.A01
            byte[] r0 = r0.A00
            r0 = r0[r1]
            r3 = r0 & 255(0xff, float:3.57E-43)
            if (r3 != 0) goto L16
            r0 = -9223372036854775808
            return r0
        L16:
            r6 = 128(0x80, float:1.8E-43)
            r4 = 0
        L19:
            r0 = r3 & r6
            if (r0 != 0) goto L41
            int r6 = r6 >> 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.CY.A02
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 30
            if (r1 == r0) goto L3b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CY.A02
            java.lang.String r1 = "eov1UmgRTS2J9JWiL8HKDN2YxzkNqP4T"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "eov1UmgRTS2J9JWiL8HKDN2YxzkNqP4T"
            r0 = 1
            r2[r0] = r1
            int r4 = r4 + 1
            goto L19
        L3b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L41:
            r0 = r6 ^ (-1)
            r3 = r3 & r0
            com.facebook.ads.redexgen.X.IG r0 = r7.A01
            byte[] r0 = r0.A00
            r8.ABs(r0, r5, r4)
            r5 = 0
        L4c:
            if (r5 >= r4) goto L7f
            int r3 = r3 << 8
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.CY.A02
            r0 = 7
            r1 = r1[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            r0 = 71
            if (r1 == r0) goto L79
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CY.A02
            java.lang.String r1 = "09Vxb0YRh5GFDnmrENphsjvB8xYQhkFk"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "09Vxb0YRh5GFDnmrENphsjvB8xYQhkFk"
            r0 = 1
            r2[r0] = r1
            com.facebook.ads.redexgen.X.IG r0 = r7.A01
            byte[] r1 = r0.A00
            int r0 = r5 + 1
            r0 = r1[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r0
            int r5 = r5 + 1
            goto L4c
        L79:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L7f:
            int r1 = r7.A00
            int r0 = r4 + 1
            int r1 = r1 + r0
            r7.A00 = r1
            long r0 = (long) r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CY.A00(com.facebook.ads.redexgen.X.CB):long");
    }

    public final boolean A02(CB cb) throws InterruptedException, IOException {
        long jA6a = cb.A6a();
        long j = 1024;
        if (jA6a != -1 && jA6a <= 1024) {
            j = jA6a;
        }
        int i = (int) j;
        boolean z = false;
        cb.ABs(this.A01.A00, 0, 4);
        long jA0N = this.A01.A0N();
        this.A00 = 4;
        while (jA0N != 440786851) {
            int i2 = this.A00 + 1;
            this.A00 = i2;
            if (i2 == i) {
                return false;
            }
            cb.ABs(this.A01.A00, 0, 1);
            long tag = this.A01.A00[0] & 255;
            jA0N = ((jA0N << 8) & (-256)) | tag;
        }
        long jA00 = A00(cb);
        long j2 = this.A00;
        if (jA00 == Long.MIN_VALUE) {
            return false;
        }
        if (jA6a != -1 && j2 + jA00 >= jA6a) {
            return false;
        }
        while (true) {
            int i3 = this.A00;
            if (i3 >= j2 + jA00) {
                return ((long) i3) == j2 + jA00;
            }
            if (A00(cb) == Long.MIN_VALUE) {
                return z;
            }
            long jA002 = A00(cb);
            if (jA002 < 0 || jA002 > 2147483647L) {
                return false;
            }
            if (jA002 != 0) {
                int i4 = (int) jA002;
                cb.A3M(i4);
                this.A00 += i4;
            }
            z = false;
        }
    }
}
