package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class QC implements Runnable {
    public final /* synthetic */ QD A00;

    public QC(QD qd) {
        this.A00 = qd;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A00();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
