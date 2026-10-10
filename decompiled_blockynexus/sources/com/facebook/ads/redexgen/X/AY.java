package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AY {
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;

    @Nullable
    public Object A07;
    public boolean A08;
    public boolean A09;

    public final long A00() {
        return C14729o.A01(this.A02);
    }

    public final long A01() {
        return this.A02;
    }

    public final long A02() {
        return C14729o.A01(this.A03);
    }

    public final long A03() {
        return this.A04;
    }

    public final AY A04(@Nullable Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
        this.A07 = obj;
        this.A05 = j;
        this.A06 = j2;
        this.A09 = z;
        this.A08 = z2;
        this.A02 = j3;
        this.A03 = j4;
        this.A00 = i;
        this.A01 = i2;
        this.A04 = j5;
        return this;
    }
}
