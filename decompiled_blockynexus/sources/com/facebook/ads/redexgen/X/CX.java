package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CX {
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public boolean A04;
    public final byte[] A05 = new byte[10];

    public final void A00() {
        this.A04 = false;
    }

    public final void A01(CB cb, int i, int i2) throws InterruptedException, IOException {
        if (!this.A04) {
            cb.ABs(this.A05, 0, 10);
            cb.ACt();
            if (C1492Ai.A06(this.A05) == -1) {
                return;
            }
            this.A04 = true;
            this.A02 = 0;
        }
        if (this.A02 == 0) {
            this.A00 = i;
            this.A01 = 0;
        }
        this.A01 += i2;
    }

    public final void A02(CW cw) {
        if (this.A04 && this.A02 > 0) {
            cw.A0W.ACy(this.A03, this.A00, this.A01, 0, cw.A0V);
            this.A02 = 0;
        }
    }

    public final void A03(CW cw, long j) {
        if (!this.A04) {
            return;
        }
        int i = this.A02;
        this.A02 = i + 1;
        if (i == 0) {
            this.A03 = j;
        }
        if (this.A02 < 16) {
            return;
        }
        cw.A0W.ACy(this.A03, this.A00, this.A01, 0, cw.A0V);
        this.A02 = 0;
    }
}
