package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ej, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1580Ej extends AbstractC1898Rb {
    public C1580Ej(C2026Wb c2026Wb, C12741j c12741j) {
        super(c2026Wb, c12741j);
    }

    private InterfaceC12610w A00(Runnable runnable) {
        return new C1900Rd(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0N() {
        ((RB) this.A02).A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0Q(InterfaceC12510m interfaceC12510m, C14498q c14498q, C14478o c14478o, Map<String, Object> map) {
        RB rb = (RB) interfaceC12510m;
        C1899Rc c1899Rc = new C1899Rc(this, map, rb);
        A0G().postDelayed(c1899Rc, c14498q.A05().A05());
        rb.A0A(this.A0C, A00(c1899Rc), map, this.A08.A09, this.A08.A03, this.A08.A04, this.A08.A01);
    }
}
