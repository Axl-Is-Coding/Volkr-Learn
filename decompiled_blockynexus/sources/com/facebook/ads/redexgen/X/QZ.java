package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class QZ implements InterfaceC1737Kv {
    public final /* synthetic */ int A00;
    public final /* synthetic */ KT A01;
    public final /* synthetic */ QW A02;

    public QZ(QW qw, int i, KT kt) {
        this.A02 = qw;
        this.A00 = i;
        this.A01 = kt;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void A9V() throws Throwable {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void AAv(float f2) {
        this.A02.A07.setProgress(100.0f * (1.0f - (f2 / this.A00)));
    }
}
