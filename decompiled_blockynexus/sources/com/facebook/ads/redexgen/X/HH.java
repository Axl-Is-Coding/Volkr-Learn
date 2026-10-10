package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class HH implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ C2153aT A03;

    public HH(C2153aT c2153aT, int i, long j, long j2) {
        this.A03 = c2153aT;
        this.A00 = i;
        this.A02 = j;
        this.A01 = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.A07.A9I(this.A00, this.A02, this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
