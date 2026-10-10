package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1510Bc implements Runnable {
    public final /* synthetic */ C1515Bh A00;
    public final /* synthetic */ Bi A01;

    public RunnableC1510Bc(C1515Bh c1515Bh, Bi bi) {
        this.A00 = c1515Bh;
        this.A01 = bi;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A9h();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
