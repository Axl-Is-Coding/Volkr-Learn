package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2159aZ implements HB {
    public final HX<? super C2158aY> A00;

    public C2159aZ() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.FileDataSource> */
    public C2159aZ(HX<? super C2158aY> hx) {
        this.A00 = hx;
    }

    @Override // com.facebook.ads.redexgen.X.HB
    public final HC A4D() {
        return new C2158aY(this.A00);
    }
}
