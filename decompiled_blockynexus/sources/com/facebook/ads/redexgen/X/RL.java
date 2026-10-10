package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RL implements NP {
    public final /* synthetic */ int A00;
    public final /* synthetic */ RM A01;
    public final /* synthetic */ C2213bT A02;

    public RL(RM rm, int i, C2213bT c2213bT) {
        this.A01 = rm;
        this.A00 = i;
        this.A02 = c2213bT;
    }

    @Override // com.facebook.ads.redexgen.X.NP
    public final void A9z(boolean z) {
        if (this.A00 == 0) {
            this.A02.A1R(this.A01.A04);
        }
        this.A02.A1U(z, true);
    }
}
