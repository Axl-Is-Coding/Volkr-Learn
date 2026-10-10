package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1687Is implements Runnable {
    public final /* synthetic */ BU A00;
    public final /* synthetic */ C1688It A01;

    public RunnableC1687Is(C1688It c1688It, BU bu) {
        this.A01 = c1688It;
        this.A00 = bu;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A00();
            this.A01.A01.ABZ(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
