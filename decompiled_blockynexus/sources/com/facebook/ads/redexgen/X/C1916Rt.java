package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1916Rt extends AbstractC12520n {
    public final /* synthetic */ C1918Rv A00;

    public C1916Rt(C1918Rv c1918Rv) {
        this.A00 = c1918Rv;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A05() {
        this.A00.A05.onRewardServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A06() {
        this.A00.A05.onRewardServerSuccess();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A07() {
        this.A00.A05.onRewardedVideoCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A08() {
        this.A00.A05.onRewardedVideoActivityDestroyed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A09() {
        this.A00.A05.onRewardedVideoClosed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0B() {
        this.A00.A05.onAdClicked(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0C() {
        this.A00.A05.onLoggingImpression(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0E(InterfaceC12510m interfaceC12510m) {
        C1918Rv c1918Rv = this.A00;
        c1918Rv.A03 = c1918Rv.A02.A0I();
        RJ rj = (RJ) interfaceC12510m;
        if (this.A00.A06.A03 != null) {
            rj.A01(this.A00.A06.A03);
        }
        this.A00.A06.A00 = rj.A0B();
        this.A00.A04 = true;
        this.A00.A05.onAdLoaded(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0F(C1697Jd c1697Jd) {
        this.A00.A0A(true);
        this.A00.A06.A0B.A0A().A2d(LP.A01(this.A00.A01), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
        this.A00.A05.onError(this.A00.A06.A01(), C1697Jd.A00(c1697Jd));
    }
}
