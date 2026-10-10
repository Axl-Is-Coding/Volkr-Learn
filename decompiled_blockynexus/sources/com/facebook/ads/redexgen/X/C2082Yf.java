package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2082Yf implements CA {
    public static byte[] A03;
    public static final CD A04;
    public CC A00;
    public D6 A01;
    public boolean A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{95, 120, 112, 117, 124, 125, 57, 109, 118, 57, 125, 124, 109, 124, 107, 116, 112, 119, 124, 57, 123, 112, 109, 106, 109, 107, 124, 120, 116, 57, 109, 96, 105, 124};
    }

    static {
        A02();
        A04 = new C2081Ye();
    }

    public static IG A00(IG ig) {
        ig.A0Z(0);
        return ig;
    }

    private boolean A03(CB cb) throws InterruptedException, IOException {
        D2 d2 = new D2();
        if (!d2.A04(cb, true) || (d2.A04 & 2) != 2) {
            return false;
        }
        int length = Math.min(d2.A00, 8);
        IG ig = new IG(length);
        cb.ABs(ig.A00, 0, length);
        IG scratch = A00(ig);
        if (C2080Yd.A05(scratch)) {
            this.A01 = new C2080Yd();
        } else {
            IG scratch2 = A00(ig);
            if (C2085Yi.A07(scratch2)) {
                this.A01 = new C2085Yi();
            } else {
                IG scratch3 = A00(ig);
                if (!C2083Yg.A05(scratch3)) {
                    return false;
                }
                this.A01 = new C2083Yg();
            }
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A00 = cc;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        if (this.A01 == null) {
            if (A03(cb)) {
                cb.ACt();
            } else {
                throw new AD(A01(0, 34, 107));
            }
        }
        if (!this.A02) {
            CM cmADr = this.A00.ADr(0, 1);
            this.A00.A54();
            this.A01.A07(this.A00, cmADr);
            this.A02 = true;
        }
        return this.A01.A03(cb, ch);
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        D6 d6 = this.A01;
        if (d6 != null) {
            d6.A06(j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        try {
            return A03(cb);
        } catch (AD unused) {
            return false;
        }
    }
}
