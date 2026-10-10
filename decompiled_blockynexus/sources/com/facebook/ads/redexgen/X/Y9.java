package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y9 implements CM {
    @Override // com.facebook.ads.redexgen.X.CM
    public final void A5I(Format format) {
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final int ACw(CB cb, int i, boolean z) throws InterruptedException, IOException {
        int iADW = cb.ADW(i);
        if (iADW == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return iADW;
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void ACx(IG ig, int i) {
        ig.A0a(i);
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void ACy(long j, int i, int i2, int i3, CL cl) {
    }
}
