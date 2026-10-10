package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2125a0 implements LE {
    public final LD A00;
    public final LE A01;

    public C2125a0(LE le, int i, int i2) {
        this.A01 = le;
        this.A00 = new LD(i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void AC5(String str) {
        this.A00.A05(str);
        if (this.A00.A03() != null && LG.A08(this.A00)) {
            this.A01.AC5(this.A00.A03());
        }
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void flush() {
        this.A00.A04();
        while (this.A00.A03() != null) {
            if (LG.A08(this.A00)) {
                this.A01.AC5(this.A00.A03());
            }
            this.A00.A04();
        }
    }
}
