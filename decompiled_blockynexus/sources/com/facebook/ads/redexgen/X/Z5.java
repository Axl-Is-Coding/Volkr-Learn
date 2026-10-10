package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z5 implements DO {
    public final IF A00 = new IF(new byte[4]);
    public final /* synthetic */ Z7 A01;

    public Z5(Z7 z7) {
        this.A01 = z7;
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A48(IG ig) {
        if (ig.A0F() != 0) {
            return;
        }
        ig.A0a(7);
        int iA05 = ig.A05() / 4;
        for (int i = 0; i < iA05; i++) {
            ig.A0b(this.A00, 4);
            int iA052 = this.A00.A05(16);
            this.A00.A09(3);
            if (iA052 == 0) {
                this.A00.A09(13);
            } else {
                int iA053 = this.A00.A05(13);
                this.A01.A06.put(iA053, new Z2(new Z6(this.A01, iA053)));
                Z7.A01(this.A01);
            }
        }
        if (this.A01.A05 == 2) {
            return;
        }
        this.A01.A06.remove(0);
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A7g(IS is, CC cc, DU du) {
    }
}
