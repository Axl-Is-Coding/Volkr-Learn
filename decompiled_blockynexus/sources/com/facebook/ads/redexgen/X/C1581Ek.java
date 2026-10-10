package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ek, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1581Ek extends AbstractC1898Rb {
    public C1534Cl A00;

    public C1581Ek(C1534Cl c1534Cl, C12741j c12741j) {
        super(c1534Cl, c12741j);
        this.A00 = c1534Cl;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0N() {
        if (super.A00 != null) {
            this.A00.A0A().A3o();
            this.A07.A0D(super.A00);
        } else {
            this.A00.A0A().A3p();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0Q(InterfaceC12510m interfaceC12510m, C14498q c14498q, C14478o c14478o, Map<String, Object> map) {
        this.A00.A0A().A3i();
        RA ra = (RA) interfaceC12510m;
        RW rw = new RW(this, map, ra);
        A0G().postDelayed(rw, c14498q.A05().A05());
        ra.A0D(this.A00, this.A09, this.A08.A06, new RX(this, rw), map);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0S(String str) {
        this.A00.A0A().A3n(str != null);
        super.A0S(str);
    }
}
