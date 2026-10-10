package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class UO implements C6Y {
    public final /* synthetic */ UR A00;

    public UO(UR ur) {
        this.A00 = ur;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 != null) {
            UR ur = this.A00;
            return ur.A09(ur.A00.getName());
        }
        return this.A00.A08(EnumC14006j.A06);
    }
}
