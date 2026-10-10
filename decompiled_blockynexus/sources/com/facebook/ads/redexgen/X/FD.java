package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FD implements Runnable {
    public final /* synthetic */ FJ A00;
    public final /* synthetic */ FK A01;
    public final /* synthetic */ FL A02;
    public final /* synthetic */ FM A03;

    public FD(FJ fj, FM fm, FK fk, FL fl) {
        this.A00 = fj;
        this.A03 = fm;
        this.A01 = fk;
        this.A02 = fl;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.AAF(this.A00.A00, this.A00.A01, this.A01, this.A02);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
