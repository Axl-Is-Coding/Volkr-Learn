package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FR {

    @Nullable
    public FR A00;

    @Nullable
    public H3 A01;
    public boolean A02;
    public final long A03;
    public final long A04;

    public FR(long j, int i) {
        this.A04 = j;
        this.A03 = ((long) i) + j;
    }

    public final int A00(long j) {
        return ((int) (j - this.A04)) + this.A01.A00;
    }

    public final FR A01() {
        this.A01 = null;
        FR fr = this.A00;
        this.A00 = null;
        return fr;
    }

    public final void A02(H3 h3, FR fr) {
        this.A01 = h3;
        this.A00 = fr;
        this.A02 = true;
    }
}
