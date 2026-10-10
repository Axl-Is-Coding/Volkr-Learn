package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1506Ax implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ B0 A03;

    public RunnableC1506Ax(B0 b0, int i, long j, long j2) {
        this.A03 = b0;
        this.A00 = i;
        this.A01 = j;
        this.A02 = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.A01.A9G(this.A00, this.A01, this.A02);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
