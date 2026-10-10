package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2177ar implements HB {
    public final int A00;
    public final H9 A01;
    public final HB A02;
    public final HB A03;
    public final InterfaceC1646Hb A04;
    public final InterfaceC1648Hd A05;

    public C2177ar(InterfaceC1646Hb interfaceC1646Hb, HB hb, HB hb2, H9 h9, int i, InterfaceC1648Hd interfaceC1648Hd) {
        this.A04 = interfaceC1646Hb;
        this.A03 = hb;
        this.A02 = hb2;
        this.A01 = h9;
        this.A00 = i;
        this.A05 = interfaceC1648Hd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HB
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C2176aq A4D() {
        InterfaceC1646Hb interfaceC1646Hb = this.A04;
        HC hcA4D = this.A03.A4D();
        HC hcA4D2 = this.A02.A4D();
        H9 h9 = this.A01;
        return new C2176aq(interfaceC1646Hb, hcA4D, hcA4D2, h9 != null ? h9.createDataSink() : null, this.A00, this.A05);
    }
}
