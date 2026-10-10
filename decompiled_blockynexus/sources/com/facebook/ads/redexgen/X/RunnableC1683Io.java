package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1683Io implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ C1688It A01;

    public RunnableC1683Io(C1688It c1688It, Format format) {
        this.A01 = c1688It;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.ABc(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
