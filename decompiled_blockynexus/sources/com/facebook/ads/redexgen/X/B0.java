package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B0 {

    @Nullable
    public final Handler A00;

    @Nullable
    public final B1 A01;

    public B0(@Nullable Handler handler, @Nullable B1 b1) {
        this.A00 = b1 != null ? (Handler) C1662Hr.A01(handler) : null;
        this.A01 = b1;
    }

    public final void A01(int i) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1508Az(this, i));
        }
    }

    public final void A02(int i, long j, long j2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1506Ax(this, i, j, j2));
        }
    }

    public final void A03(Format format) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1505Aw(this, format));
        }
    }

    public final void A04(BU bu) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1507Ay(this, bu));
        }
    }

    public final void A05(BU bu) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1503Au(this, bu));
        }
    }

    public final void A06(String str, long j, long j2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1504Av(this, str, j, j2));
        }
    }
}
