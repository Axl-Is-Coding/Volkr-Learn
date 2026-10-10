package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NH implements Runnable {
    public final /* synthetic */ NI A00;
    public final /* synthetic */ NJ A01;

    public NH(NI ni, NJ nj) {
        this.A00 = ni;
        this.A01 = nj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A9A();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
