package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class I3 {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;

    public I3(byte[] bArr, int i) {
        IF r2 = new IF(bArr);
        r2.A08(i * 8);
        this.A04 = r2.A05(16);
        this.A02 = r2.A05(16);
        this.A05 = r2.A05(24);
        this.A03 = r2.A05(24);
        this.A06 = r2.A05(20);
        this.A01 = r2.A05(3) + 1;
        this.A00 = r2.A05(5) + 1;
        this.A07 = ((((long) r2.A05(4)) & 15) << 32) | (((long) r2.A05(32)) & 4294967295L);
    }

    public final int A00() {
        return this.A00 * this.A06;
    }

    public final long A01() {
        return (this.A07 * 1000000) / ((long) this.A06);
    }
}
