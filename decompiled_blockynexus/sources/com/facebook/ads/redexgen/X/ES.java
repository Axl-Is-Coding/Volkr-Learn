package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ES implements Runnable {
    public final /* synthetic */ EV A00;

    public ES(EV ev) {
        this.A00 = ev;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0G(5, 3);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
