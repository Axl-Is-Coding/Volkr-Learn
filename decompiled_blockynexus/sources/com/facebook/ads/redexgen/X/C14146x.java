package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14146x {
    public Handler A00;

    public C14146x(Looper looper) {
        this.A00 = new Handler(looper);
    }

    public final void A00(RunnableC14156y runnableC14156y) {
        this.A00.post(runnableC14156y);
    }

    public final void A01(RunnableC14156y runnableC14156y) {
        this.A00.removeCallbacks(runnableC14156y);
    }

    public final boolean A02(RunnableC14156y runnableC14156y, long j) {
        return this.A00.postDelayed(runnableC14156y, j);
    }
}
