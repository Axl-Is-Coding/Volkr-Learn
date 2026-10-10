package com.facebook.ads.redexgen.X;

import java.util.EnumSet;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6V {
    public final int A00;
    public final C6Y A01;
    public final EnumSet<EnumC13936c> A02;

    public C6V(int i, EnumSet<EnumC13936c> enumSet, C6Y c6y) {
        this.A00 = i;
        this.A02 = enumSet;
        this.A01 = c6y;
    }

    public final int A00() {
        return this.A00;
    }

    @Nullable
    public final C6Y A01() {
        if (this.A02.contains(EnumC13936c.A07)) {
            return this.A01;
        }
        return null;
    }

    @Nullable
    public final C6Y A02(C6Z c6z) {
        if (A04(c6z)) {
            return this.A01;
        }
        return null;
    }

    public final EnumSet<EnumC13936c> A03() {
        return this.A02;
    }

    public final boolean A04(C6Z c6z) {
        return C14136w.A0F(c6z) && this.A02.contains(EnumC13936c.A00(c6z.A03()));
    }
}
