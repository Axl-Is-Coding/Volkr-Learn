package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class H2 {
    public final int A00;
    public final C1644Gz A01;
    public final Object A02;
    public final AT[] A03;

    public H2(AT[] atArr, InterfaceC1643Gy[] interfaceC1643GyArr, Object obj) {
        this.A03 = atArr;
        this.A01 = new C1644Gz(interfaceC1643GyArr);
        this.A02 = obj;
        this.A00 = atArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(H2 h2) {
        if (h2 == null || h2.A01.A01 != this.A01.A01) {
            return false;
        }
        for (int i = 0; i < this.A01.A01; i++) {
            if (!A02(h2, i)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A02(H2 h2, int i) {
        return h2 != null && IW.A0h(this.A03[i], h2.A03[i]) && IW.A0h(this.A01.A01(i), h2.A01.A01(i));
    }
}
