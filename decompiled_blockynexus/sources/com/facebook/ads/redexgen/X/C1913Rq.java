package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1913Rq extends AbstractC12520n {
    public final /* synthetic */ C1915Rs A00;

    public C1913Rq(C1915Rs c1915Rs) {
        this.A00 = c1915Rs;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A00() {
        this.A00.A02 = false;
        this.A00.A05.onInterstitialActivityDestroyed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A02() {
        this.A00.A02 = false;
        if (this.A00.A01 != null) {
            this.A00.A01.A0R(new C1912Rp(this));
            this.A00.A01.A0L();
            this.A00.A01 = null;
        }
        this.A00.A05.onInterstitialDismissed(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A04() {
        this.A00.A05.onInterstitialDisplayed(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A05() {
        this.A00.A05.onRewardedAdServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A06() {
        this.A00.A05.onRewardedAdServerSucceeded();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A07() {
        this.A00.A05.onRewardedAdCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0B() {
        this.A00.A04.A0A().A2Y();
        this.A00.A05.onAdClicked(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0C() {
        this.A00.A05.onLoggingImpression(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0D(View view) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0E(InterfaceC12510m interfaceC12510m) {
        this.A00.A03 = true;
        this.A00.A05.onAdLoaded(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0F(C1697Jd c1697Jd) {
        this.A00.A04.A0A().A2d(LP.A01(this.A00.A00), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
        this.A00.A05.onError(this.A00.A06.A01(), C1697Jd.A00(c1697Jd));
    }
}
