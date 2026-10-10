package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2108Zf implements NC {
    public final /* synthetic */ C2106Zd A00;

    public C2108Zf(C2106Zd c2106Zd) {
        this.A00 = c2106Zd;
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAe(String str) {
        this.A00.A0A.setProgress(100);
        this.A00.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAg(String str) {
        this.A00.A05 = true;
        this.A00.A09.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAw(int i) {
        if (this.A00.A05) {
            this.A00.A0A.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AB1(String str) {
        this.A00.A09.setTitle(str);
    }
}
