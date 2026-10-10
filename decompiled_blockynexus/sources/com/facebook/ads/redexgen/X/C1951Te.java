package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Te, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1951Te implements C6Y {
    public final /* synthetic */ C1953Tg A00;

    public C1951Te(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A01 != null) {
            C1953Tg c1953Tg = this.A00;
            return c1953Tg.A09(c1953Tg.A01.processName);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
