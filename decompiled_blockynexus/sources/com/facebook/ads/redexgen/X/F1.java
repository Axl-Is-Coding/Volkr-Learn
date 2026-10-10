package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class F1 implements Runnable {
    public final /* synthetic */ C1499Ap A00;

    public F1(C1499Ap c1499Ap) {
        this.A00 = c1499Ap;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0G) {
                this.A00.A08.A9X(this.A00);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
