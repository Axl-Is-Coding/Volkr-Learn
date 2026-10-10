package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HR implements Runnable {
    public final HQ A00;

    public HR(HQ hq) {
        this.A00 = hq;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.AAN();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
