package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class FZ implements QN {
    public final C1605Fk A00;
    public final QS A01;

    public FZ(C1605Fk c1605Fk, QS qs) {
        this.A00 = c1605Fk;
        this.A01 = qs;
    }

    @Override // com.facebook.ads.redexgen.X.QN
    public void A3P(Map<Q8, QS> map, Map<InterfaceC1604Fj, QF> map2) {
        map.put(this.A00, this.A01);
    }
}
