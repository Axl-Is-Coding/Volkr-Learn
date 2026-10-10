package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1508Az implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ B0 A01;

    public RunnableC1508Az(B0 b0, int i) {
        this.A01 = b0;
        this.A00 = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.A9F(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
