package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZV implements InterfaceC1737Kv {
    public final /* synthetic */ int A00;
    public final /* synthetic */ ZU A01;

    public ZV(ZU zu, int i) {
        this.A01 = zu;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void A9V() {
        this.A01.A03 = false;
        this.A01.A0P();
        this.A01.A0C.setToolbarActionMode(this.A01.getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void AAv(float f2) {
        this.A01.A0C.setProgress(100.0f * (1.0f - (f2 / this.A00)));
    }
}
