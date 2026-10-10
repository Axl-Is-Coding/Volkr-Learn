package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class a6 implements LE {
    public int A00;
    public final LE A01;
    public final LE A02;

    public a6(LE le, int i, LE le2) {
        this.A01 = le;
        this.A00 = i;
        this.A02 = le2;
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void AC5(String str) {
        if (this.A00 > 0) {
            this.A01.AC5(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AC5(str);
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void flush() {
        this.A02.flush();
    }
}
