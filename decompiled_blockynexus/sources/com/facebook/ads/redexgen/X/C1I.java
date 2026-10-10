package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1I implements Serializable {
    public static final long serialVersionUID = -2102939945352398575L;
    public final List<String> A00;

    public C1I(List<String> screenshots) {
        this.A00 = screenshots;
    }

    public final List<String> A00() {
        return Collections.unmodifiableList(this.A00);
    }
}
