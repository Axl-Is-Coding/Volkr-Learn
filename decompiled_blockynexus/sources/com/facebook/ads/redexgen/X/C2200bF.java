package com.facebook.ads.redexgen.X;

import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2200bF implements JM {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ C2204bJ A01;

    public C2200bF(C2204bJ c2204bJ, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = c2204bJ;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADH() {
        this.A00.setVolume(WheelView.DividerConfig.FILL);
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADK(NativeAd nativeAd) {
        this.A01.A0J(C2213bT.A0J(nativeAd.getInternalNativeAd()), null);
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADv() {
        this.A01.A0D();
    }
}
