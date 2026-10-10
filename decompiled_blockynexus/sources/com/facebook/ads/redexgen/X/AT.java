package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AT {
    public static final AT A01 = new AT(0);
    public final int A00;

    public AT(int i) {
        this.A00 = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.A00 == ((AT) obj).A00;
    }

    public final int hashCode() {
        return this.A00;
    }
}
