package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z9 implements CA {
    public static byte[] A05;
    public static String[] A06;
    public static final CD A07;
    public int A00;
    public int A01;
    public CC A02;
    public CM A03;
    public ZA A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 67, 17, 68, 95, 67, 84, 82, 94, 86, 95, 88, 75, 84, 85, 17, 70, 80, 71, 17, 89, 84, 80, 85, 84, 67, 31, 107, 127, 110, 99, 101, 37, 120, 107, 125};
    }

    public static void A02() {
        A06 = new String[]{"TnN98hFrpPh0PRtpc088aNdcZccscvrw", "5aRpZ2NNsZI5w0o7DGq1eAqNryB", "mEVhsrU6MzIr1qyqOlGiN", "yrEmV4s21h7BLFfB7siMTKTjJQry3", "EfBKzRp", "ss80CflBP4AmUjPde3BocO42m8Tqd1M1", "kqV6vinpOYrD", "3vWKjffhrtNYzin5lJ6IQFsZaR1xXQhq"};
    }

    static {
        A02();
        A01();
        A07 = new Z8();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A02 = cc;
        this.A03 = cc.ADr(0, 1);
        this.A04 = null;
        cc.A54();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b0 A[PHI: r5 r6
      0x00b0: PHI (r5v4 'size' int) = (r5v1 'size' int), (r5v5 'size' int) binds: [B:24:0x00e5, B:15:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r6v4 int) = (r6v2 int), (r6v5 int) binds: [B:24:0x00e5, B:15:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.facebook.ads.redexgen.X.CA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int ACG(com.facebook.ads.redexgen.X.CB r19, com.facebook.ads.redexgen.X.CH r20) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z9.ACG(com.facebook.ads.redexgen.X.CB, com.facebook.ads.redexgen.X.CH):int");
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        return DX.A00(cb) != null;
    }
}
