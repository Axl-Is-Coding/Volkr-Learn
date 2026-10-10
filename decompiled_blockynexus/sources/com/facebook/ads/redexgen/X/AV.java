package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AV {
    public final long A00;
    public final long A01;
    public static final AV A04 = new AV(0, 0);
    public static final AV A02 = new AV(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final AV A06 = new AV(Long.MAX_VALUE, 0);
    public static final AV A05 = new AV(0, Long.MAX_VALUE);
    public static final AV A03 = A04;

    public AV(long j, long j2) {
        C1662Hr.A03(j >= 0);
        C1662Hr.A03(j2 >= 0);
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AV av = (AV) obj;
        return this.A01 == av.A01 && this.A00 == av.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
