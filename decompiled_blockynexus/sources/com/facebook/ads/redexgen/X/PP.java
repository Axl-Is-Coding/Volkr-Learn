package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class PP implements Runnable {
    public final /* synthetic */ PS A00;

    public PP(PS ps) {
        this.A00 = ps;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A08();
            this.A00.A05.removeCallbacks(this);
            this.A00.A05.postDelayed(this, 250L);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
