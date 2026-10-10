package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class KI extends C9A<C7l> {
    public final /* synthetic */ C7m A00;

    public KI(C7m c7m) {
        this.A00 = c7m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(C7l c7l) {
        int iA00 = c7l.A00();
        int iA01 = c7l.A01();
        if (this.A00.A00 > 0 && iA00 == iA01 && iA01 > this.A00.A00) {
            return;
        }
        if (iA01 < iA00 + 500) {
            if (iA01 == 0) {
                C7m c7m = this.A00;
                c7m.A0e(c7m.A00);
                return;
            } else {
                this.A00.A0e(iA01);
                return;
            }
        }
        this.A00.A0e(iA00);
    }

    @Override // com.facebook.ads.redexgen.X.C9A
    public final Class<C7l> A01() {
        return C7l.class;
    }
}
