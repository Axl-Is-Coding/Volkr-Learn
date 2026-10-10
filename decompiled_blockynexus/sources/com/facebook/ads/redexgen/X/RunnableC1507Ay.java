package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ay, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1507Ay implements Runnable {
    public final /* synthetic */ B0 A00;
    public final /* synthetic */ BU A01;

    public RunnableC1507Ay(B0 b0, BU bu) {
        this.A00 = b0;
        this.A01 = bu;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A00();
            this.A00.A01.A9C(this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
