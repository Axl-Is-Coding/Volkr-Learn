package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class BW extends Thread {
    public final /* synthetic */ AbstractC2069Xs A00;

    public BW(AbstractC2069Xs abstractC2069Xs) {
        this.A00 = abstractC2069Xs;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0N();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
