package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y7 implements CB {
    public int A00;
    public int A01;
    public long A02;
    public final long A04;
    public final HC A05;
    public byte[] A03 = new byte[65536];
    public final byte[] A06 = new byte[4096];

    public Y7(HC hc, long j, long j2) {
        this.A05 = hc;
        this.A02 = j;
        this.A04 = j2;
    }

    private int A00(int i) {
        int iMin = Math.min(this.A00, i);
        A05(iMin);
        return iMin;
    }

    private int A01(byte[] bArr, int i, int i2) {
        int i3 = this.A00;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.A03, 0, bArr, i, iMin);
        A05(iMin);
        return iMin;
    }

    private int A02(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int i4 = this.A05.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                if (i3 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i3 + i4;
        }
        throw new InterruptedException();
    }

    private void A03(int i) {
        if (i != -1) {
            this.A02 += (long) i;
        }
    }

    private void A04(int i) {
        int i2 = this.A01 + i;
        byte[] bArr = this.A03;
        if (i2 > bArr.length) {
            this.A03 = Arrays.copyOf(this.A03, IW.A06(bArr.length * 2, 65536 + i2, 524288 + i2));
        }
    }

    private void A05(int i) {
        this.A00 -= i;
        this.A01 = 0;
        byte[] bArr = this.A03;
        int i2 = this.A00;
        if (i2 < this.A03.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.A03, i, bArr, 0, this.A00);
        this.A03 = bArr;
    }

    public final boolean A06(int i, boolean z) throws InterruptedException, IOException {
        A04(i);
        int iMin = Math.min(this.A00 - this.A01, i);
        while (iMin < i) {
            iMin = A02(this.A03, this.A01, i, iMin, z);
            if (iMin == -1) {
                return false;
            }
        }
        this.A01 += i;
        this.A00 = Math.max(this.A00, this.A01);
        return true;
    }

    public final boolean A07(int i, boolean z) throws InterruptedException, IOException {
        int iA00 = A00(i);
        while (iA00 < i && iA00 != -1) {
            iA00 = A02(this.A06, -iA00, Math.min(i, this.A06.length + iA00), iA00, z);
        }
        A03(iA00);
        return iA00 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final void A3M(int i) throws InterruptedException, IOException {
        A06(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final long A6a() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final long A6o() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final long A6t() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final void ABs(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        ABt(bArr, i, i2, false);
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final boolean ABt(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException {
        if (!A06(i2, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i2, bArr, i, i2);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final boolean ACL(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException {
        int iA01 = A01(bArr, i, i2);
        while (iA01 < i2 && iA01 != -1) {
            iA01 = A02(bArr, i, i2, iA01, z);
        }
        A03(iA01);
        return iA01 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final void ACt() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final int ADW(int i) throws InterruptedException, IOException {
        int iA00 = A00(i);
        if (iA00 == 0) {
            byte[] bArr = this.A06;
            iA00 = A02(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        A03(iA00);
        return iA00;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final void ADZ(int i) throws InterruptedException, IOException {
        A07(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int iA01 = A01(bArr, i, i2);
        if (iA01 == 0) {
            iA01 = A02(bArr, i, i2, 0, true);
        }
        A03(iA01);
        return iA01;
    }

    @Override // com.facebook.ads.redexgen.X.CB
    public final void readFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        ACL(bArr, i, i2, false);
    }
}
