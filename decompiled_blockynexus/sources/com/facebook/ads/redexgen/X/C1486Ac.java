package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1486Ac {
    public final int A00;
    public final F6 A01;

    public C1486Ac(int i, F6 f6) {
        this.A00 = i;
        this.A01 = f6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1486Ac c1486Ac = (C1486Ac) obj;
        return this.A00 == c1486Ac.A00 && this.A01.equals(c1486Ac.A01);
    }

    public final int hashCode() {
        return (this.A00 * 31) + this.A01.hashCode();
    }
}
