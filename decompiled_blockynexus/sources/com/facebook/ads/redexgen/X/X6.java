package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class X6 implements C8B {
    public final /* synthetic */ AnonymousClass87 A00;
    public final /* synthetic */ XA A01;

    public X6(XA xa, AnonymousClass87 anonymousClass87) {
        this.A01 = xa;
        this.A00 = anonymousClass87;
    }

    @Override // com.facebook.ads.redexgen.X.C8B
    public final String A6O() {
        return KA.A04(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C8B
    public final boolean A7l() {
        return BuildConfigApi.isDebug();
    }
}
