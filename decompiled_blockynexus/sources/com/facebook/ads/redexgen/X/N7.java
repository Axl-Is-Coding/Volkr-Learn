package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class N7 {
    public final String A07;
    public long A01 = -1;
    public long A03 = -1;
    public long A04 = -1;
    public long A00 = -1;
    public long A05 = -1;
    public long A02 = -1;
    public long A06 = -1;

    public N7(String str) {
        this.A07 = str;
    }

    public final N7 A00(long j) {
        this.A00 = j;
        return this;
    }

    public final N7 A01(long j) {
        this.A01 = j;
        return this;
    }

    public final N7 A02(long j) {
        this.A02 = j;
        return this;
    }

    public final N7 A03(long j) {
        this.A03 = j;
        return this;
    }

    public final N7 A04(long j) {
        this.A04 = j;
        return this;
    }

    public final N7 A05(long j) {
        this.A05 = j;
        return this;
    }

    public final N7 A06(long j) {
        this.A06 = j;
        return this;
    }

    public final N8 A07() {
        return new N8(this.A07, this.A01, this.A03, this.A04, this.A00, this.A05, this.A02, this.A06);
    }
}
