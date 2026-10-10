package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class W1 implements C6Y {
    public final /* synthetic */ W8 A00;

    public W1(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 != null) {
            W8 w8 = this.A00;
            return w8.A05(w8.A00.getPhoneType());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
