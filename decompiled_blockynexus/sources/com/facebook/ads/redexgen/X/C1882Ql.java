package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1882Ql implements NC {
    public final /* synthetic */ C1880Qj A00;

    public C1882Ql(C1880Qj c1880Qj) {
        this.A00 = c1880Qj;
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAe(String str) {
        this.A00.A0I = false;
        this.A00.A0C.setProgress(100);
        LX.A0Q(this.A00.A0C, 8);
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAg(String str) {
        this.A00.A0I = true;
        LX.A0Q(this.A00.A0C, 0);
        this.A00.A0B.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AAw(int i) {
        if (this.A00.A0I) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NC
    public final void AB1(String str) {
        this.A00.A0B.setTitle(str);
    }
}
