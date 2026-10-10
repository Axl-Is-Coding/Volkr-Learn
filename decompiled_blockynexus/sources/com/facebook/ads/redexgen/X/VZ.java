package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VZ implements C6Y {
    public final /* synthetic */ C2003Ve A00;

    public VZ(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A01 != null) {
            C2003Ve c2003Ve = this.A00;
            return c2003Ve.A09(c2003Ve.A01.packageName);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
