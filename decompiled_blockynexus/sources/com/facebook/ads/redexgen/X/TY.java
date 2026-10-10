package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TY implements C6Y {
    public final /* synthetic */ C1953Tg A00;

    public TY(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 != null) {
            C1953Tg c1953Tg = this.A00;
            return c1953Tg.A09(c1953Tg.A00.getGlEsVersion());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
