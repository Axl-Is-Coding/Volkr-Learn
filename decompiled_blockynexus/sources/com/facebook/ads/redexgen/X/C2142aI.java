package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2142aI implements InterfaceC1642Gx {
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final H7 A06;
    public final InterfaceC1665Hu A07;

    public C2142aI(H7 h7) {
        this(h7, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, InterfaceC1665Hu.A00);
    }

    public C2142aI(H7 h7, int i, int i2, int i3, float f2, float f3, long j, InterfaceC1665Hu interfaceC1665Hu) {
        this.A06 = h7;
        this.A03 = i;
        this.A02 = i2;
        this.A04 = i3;
        this.A00 = f2;
        this.A01 = f3;
        this.A05 = j;
        this.A07 = interfaceC1665Hu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1642Gx
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final AJ A4T(TrackGroup trackGroup, int... iArr) {
        return new AJ(trackGroup, iArr, this.A06, this.A03, this.A02, this.A04, this.A00, this.A01, this.A05, this.A07);
    }
}
