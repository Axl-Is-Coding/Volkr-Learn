package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.It, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1688It {

    @Nullable
    public final Handler A00;

    @Nullable
    public final InterfaceC1689Iu A01;

    public C1688It(@Nullable Handler handler, @Nullable InterfaceC1689Iu interfaceC1689Iu) {
        this.A00 = interfaceC1689Iu != null ? (Handler) C1662Hr.A01(handler) : null;
        this.A01 = interfaceC1689Iu;
    }

    public final void A01(int i, int i2, int i3, float f2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1685Iq(this, i, i2, i3, f2));
        }
    }

    public final void A02(int i, long j) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1684Ip(this, i, j));
        }
    }

    public final void A03(Surface surface) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1686Ir(this, surface));
        }
    }

    public final void A04(Format format) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1683Io(this, format));
        }
    }

    public final void A05(BU bu) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1687Is(this, bu));
        }
    }

    public final void A06(BU bu) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1681Im(this, bu));
        }
    }

    public final void A07(String str, long j, long j2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1682In(this, str, j, j2));
        }
    }
}
