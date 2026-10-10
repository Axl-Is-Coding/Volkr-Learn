package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2199bE implements JM {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ C2204bJ A01;

    public C2199bE(C2204bJ c2204bJ, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = c2204bJ;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADH() {
        this.A00.setVolume(1.0f);
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADK(NativeAd nativeAd) {
        this.A01.A0J(C2213bT.A0J(nativeAd.getInternalNativeAd()), new C2203bI(C2213bT.A0J(nativeAd.getInternalNativeAd())));
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void ADv() {
        this.A01.A0D();
    }
}
