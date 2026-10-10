package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewListener;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1945Sy implements M7 {
    public final /* synthetic */ MediaViewListener A00;
    public final /* synthetic */ C1946Sz A01;

    public C1945Sy(C1946Sz c1946Sz, MediaViewListener mediaViewListener) {
        this.A01 = c1946Sz;
        this.A00 = mediaViewListener;
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A9T() {
        this.A00.onComplete(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A9m() {
        this.A00.onEnterFullscreen(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A9s() {
        this.A00.onExitFullscreen(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A9w() {
        this.A00.onFullscreenBackground(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A9x() {
        this.A00.onFullscreenForeground(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAj() {
        this.A00.onPlay(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void ABh() {
        this.A00.onVolumeChange(this.A01.A02, this.A01.A04.getVolume());
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void onPause() {
        this.A00.onPause(this.A01.A02);
    }
}
