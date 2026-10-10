package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TT extends C6L {
    public final List<C6V> A00;

    public TT(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = new ArrayList();
    }

    public final List<C6V> A03() {
        return Collections.unmodifiableList(this.A00);
    }

    public final void A04(C6V c6v) {
        if (c6v.A03().contains(EnumC13936c.A0B)) {
            this.A00.add(c6v);
        }
    }

    public final void A05(C6Z c6z) {
        A02(c6z, this.A00);
    }
}
