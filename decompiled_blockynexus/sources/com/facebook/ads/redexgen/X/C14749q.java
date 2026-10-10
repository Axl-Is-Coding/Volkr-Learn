package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14749q implements InterfaceC2214bU {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C14749q(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void A91() {
        KK.A00(new C2184ay(this));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void A94() {
        KK.A00(new C2185az(this));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void A9p(C1697Jd c1697Jd) {
        KK.A00(new C2215bV(this, c1697Jd));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void AAP() {
        KK.A00(new C2183ax(this));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2214bU
    public final void AAS() {
        KK.A00(new C2197bC(this));
    }
}
