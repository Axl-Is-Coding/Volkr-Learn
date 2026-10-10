package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2040Wp extends KT {
    public final /* synthetic */ C2027Wc A00;

    public C2040Wp(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        for (C8T event : C8S.A02()) {
            C8S.A0B(this.A00, event.A02(), event.A00(), event.A01(), false);
        }
        C8S.A02().clear();
    }
}
