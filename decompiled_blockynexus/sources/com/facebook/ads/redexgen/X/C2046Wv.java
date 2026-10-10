package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2046Wv extends KT {
    public final WeakReference<C1849Pe> A00;

    public C2046Wv(C1849Pe c1849Pe) {
        this.A00 = new WeakReference<>(c1849Pe);
    }

    public C2046Wv(WeakReference<C1849Pe> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        C1849Pe c1849Pe = this.A00.get();
        if (c1849Pe != null) {
            c1849Pe.A0W();
        }
    }
}
