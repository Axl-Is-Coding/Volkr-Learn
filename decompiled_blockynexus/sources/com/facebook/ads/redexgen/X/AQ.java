package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AQ {
    public int A00;
    public int A01;
    public Handler A03;
    public Object A04;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final AO A0A;
    public final AP A0B;
    public final AZ A0C;
    public long A02 = -9223372036854775807L;
    public boolean A05 = true;

    public AQ(AO ao, AP ap, AZ az, int i, Handler handler) {
        this.A0A = ao;
        this.A0B = ap;
        this.A0C = az;
        this.A03 = handler;
        this.A01 = i;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final Handler A03() {
        return this.A03;
    }

    public final AP A04() {
        return this.A0B;
    }

    public final AQ A05() {
        C1662Hr.A04(!this.A09);
        if (this.A02 == -9223372036854775807L) {
            C1662Hr.A03(this.A05);
        }
        this.A09 = true;
        this.A0A.ADA(this);
        return this;
    }

    public final AQ A06(int i) {
        C1662Hr.A04(!this.A09);
        this.A00 = i;
        return this;
    }

    public final AQ A07(@Nullable Object obj) {
        C1662Hr.A04(!this.A09);
        this.A04 = obj;
        return this;
    }

    public final AZ A08() {
        return this.A0C;
    }

    public final Object A09() {
        return this.A04;
    }

    public final synchronized void A0A(boolean z) {
        this.A07 |= z;
        this.A08 = true;
        notifyAll();
    }

    public final boolean A0B() {
        return this.A05;
    }

    public final synchronized boolean A0C() throws InterruptedException {
        C1662Hr.A04(this.A09);
        C1662Hr.A04(this.A03.getLooper().getThread() != Thread.currentThread());
        while (!this.A08) {
            wait();
        }
        return this.A07;
    }

    public final synchronized boolean A0D() {
        return this.A06;
    }
}
