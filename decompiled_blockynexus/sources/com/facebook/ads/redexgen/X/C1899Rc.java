package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1899Rc extends KT {
    public final /* synthetic */ RB A00;
    public final /* synthetic */ C1580Ej A01;
    public final /* synthetic */ Map A02;

    public C1899Rc(C1580Ej c1580Ej, Map map, RB rb) {
        this.A01 = c1580Ej;
        this.A02 = map;
        this.A00 = rb;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        this.A01.A0V(this.A02);
        this.A01.A0P(this.A00);
        if (C1693Iy.A0k(this.A01.A0C)) {
            this.A01.A01 = null;
            C1697Jd c1697Jd = new C1697Jd(AdErrorType.INTERSTITIAL_AD_TIMEOUT, "");
            this.A01.A0C.A0A().A4Y(c1697Jd.A04().getErrorCode(), c1697Jd.A05());
            this.A01.A07.A0F(c1697Jd);
            return;
        }
        this.A01.A0O();
    }
}
