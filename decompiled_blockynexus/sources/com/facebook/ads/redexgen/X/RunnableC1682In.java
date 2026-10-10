package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.In, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1682In implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C1688It A02;
    public final /* synthetic */ String A03;

    public RunnableC1682In(C1688It c1688It, String str, long j, long j2) {
        this.A02 = c1688It;
        this.A03 = str;
        this.A01 = j;
        this.A00 = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.A01.ABY(this.A03, this.A01, this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
