package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1551Dc extends T0 {
    public InterfaceC1824Of A00;

    public final void A05(C2026Wb c2026Wb, NativeBannerAd nativeBannerAd, JS js, NativeAdLayout nativeAdLayout) {
        MediaView adIconView = new MediaView(nativeAdLayout.getContext());
        AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd, nativeAdLayout);
        js.A09(adOptionsView, 20);
        this.A00 = new MQ(c2026Wb, nativeBannerAd, js, C2213bT.A0J(nativeBannerAd.getInternalNativeAd()).A12(), adIconView, adOptionsView);
        LX.A0P(nativeAdLayout, js.A00());
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, adIconView, this.A00.getViewsForInteraction());
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
