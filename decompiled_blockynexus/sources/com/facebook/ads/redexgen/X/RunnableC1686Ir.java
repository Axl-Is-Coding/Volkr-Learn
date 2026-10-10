package com.facebook.ads.redexgen.X;

import android.view.Surface;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1686Ir implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ C1688It A01;

    public RunnableC1686Ir(C1688It c1688It, Surface surface) {
        this.A01 = c1688It;
        this.A00 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.AB3(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
