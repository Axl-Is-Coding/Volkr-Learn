package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1505Aw implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ B0 A01;

    public RunnableC1505Aw(B0 b0, Format format) {
        this.A01 = b0;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.A9E(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
