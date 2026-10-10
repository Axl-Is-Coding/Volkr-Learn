package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2126a1 implements LE {
    public int A00;
    public final LE A01;

    public C2126a1(LE le, int i) {
        this.A01 = le;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void AC5(String str) {
        if (this.A00 > 0) {
            this.A01.AC5(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void flush() {
        this.A01.flush();
    }
}
