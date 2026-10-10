package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1881Qk extends KT {
    public final /* synthetic */ C1880Qj A00;
    public final /* synthetic */ boolean A01;

    public C1881Qk(C1880Qj c1880Qj, boolean z) {
        this.A00 = c1880Qj;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        AbstractC1762Lu abstractC1762LuA08 = this.A00.A0E.A08();
        if (abstractC1762LuA08 == null) {
            return;
        }
        abstractC1762LuA08.setPageDetailsVisible((this.A01 || abstractC1762LuA08.A07()) ? false : true);
        abstractC1762LuA08.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
