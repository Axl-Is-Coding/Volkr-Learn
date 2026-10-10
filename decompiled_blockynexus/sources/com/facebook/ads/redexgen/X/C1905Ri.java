package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ri, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1905Ri extends KT {
    public final /* synthetic */ C1584En A00;
    public final /* synthetic */ Eg A01;
    public final /* synthetic */ Map A02;

    public C1905Ri(Eg eg, Map map, C1584En c1584En) {
        this.A01 = eg;
        this.A02 = map;
        this.A00 = c1584En;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        this.A01.A0V(this.A02);
        this.A01.A0P(this.A00);
        this.A01.A01 = null;
        AdErrorType adErrorType = AdErrorType.RV_AD_TIMEOUT;
        this.A01.A0C.A0A().A4Y(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A01.A07.A0F(new C1697Jd(adErrorType, ""));
    }
}
