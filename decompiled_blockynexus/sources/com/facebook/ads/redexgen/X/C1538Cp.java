package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1538Cp extends T0 {
    public InterfaceC1824Of A00;

    public final void A05(NativeAdLayout nativeAdLayout, C2026Wb c2026Wb, NativeAd nativeAd, JS js) {
        C1794Nb c1794Nb = new C1794Nb(c2026Wb);
        MediaView mediaView = new MediaView(c2026Wb);
        AdOptionsView adOptionsView = new AdOptionsView(c2026Wb, nativeAd, nativeAdLayout);
        js.A09(adOptionsView, 28);
        this.A00 = new MI(c2026Wb, nativeAd, js, C2213bT.A0J(nativeAd.getInternalNativeAd()).A12(), c1794Nb, mediaView, adOptionsView);
        LX.A0P(nativeAdLayout, js.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1794Nb, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
