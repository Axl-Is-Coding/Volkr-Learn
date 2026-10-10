package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FH implements Runnable {
    public final /* synthetic */ FJ A00;
    public final /* synthetic */ FL A01;
    public final /* synthetic */ FM A02;

    public FH(FJ fj, FM fm, FL fl) {
        this.A00 = fj;
        this.A02 = fm;
        this.A01 = fl;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.A9g(this.A00.A00, this.A00.A01, this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
