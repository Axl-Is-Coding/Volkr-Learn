package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FF implements Runnable {
    public final /* synthetic */ FJ A00;
    public final /* synthetic */ FM A01;

    public FF(FJ fj, FM fm) {
        this.A00 = fj;
        this.A01 = fm;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.AB0(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
