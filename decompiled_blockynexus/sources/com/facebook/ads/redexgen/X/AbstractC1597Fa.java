package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1597Fa implements QN {
    public final QF A00;
    public final AnonymousClass47 A01;

    public AbstractC1597Fa(AnonymousClass47 anonymousClass47, QF qf) {
        this.A01 = anonymousClass47;
        this.A00 = qf;
    }

    @Override // com.facebook.ads.redexgen.X.QN
    public void A3P(Map<Q8, QS> map, Map<InterfaceC1604Fj, QF> map2) {
        map2.put(this.A01, this.A00);
    }
}
