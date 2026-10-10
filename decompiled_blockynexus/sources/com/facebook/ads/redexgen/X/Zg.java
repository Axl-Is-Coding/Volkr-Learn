package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Zg implements InterfaceC13584s {
    public final /* synthetic */ C2106Zd A00;

    public Zg(C2106Zd c2106Zd) {
        this.A00 = c2106Zd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13584s
    public final boolean A7i() {
        if (this.A00.A0B.canGoBack()) {
            this.A00.A0B.goBack();
            return true;
        }
        return false;
    }
}
