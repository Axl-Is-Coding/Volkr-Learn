package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class F0 implements Runnable {
    public final /* synthetic */ C1499Ap A00;

    public F0(C1499Ap c1499Ap) {
        this.A00 = c1499Ap;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A09();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
