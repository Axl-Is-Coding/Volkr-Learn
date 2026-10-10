package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1515Bh {
    public final CopyOnWriteArrayList<C1514Bg> A00 = new CopyOnWriteArrayList<>();

    public final void A00() {
        for (C1514Bg handlerAndListener : this.A00) {
            handlerAndListener.A00.post(new RunnableC1510Bc(this, handlerAndListener.A01));
        }
    }

    public final void A01() {
        for (C1514Bg handlerAndListener : this.A00) {
            handlerAndListener.A00.post(new RunnableC1513Bf(this, handlerAndListener.A01));
        }
    }

    public final void A02() {
        for (C1514Bg handlerAndListener : this.A00) {
            handlerAndListener.A00.post(new RunnableC1512Be(this, handlerAndListener.A01));
        }
    }

    public final void A03(Handler handler, Bi bi) {
        C1662Hr.A03((handler == null || bi == null) ? false : true);
        this.A00.add(new C1514Bg(handler, bi));
    }

    public final void A04(Exception exc) {
        for (C1514Bg c1514Bg : this.A00) {
            c1514Bg.A00.post(new RunnableC1511Bd(this, c1514Bg.A01, exc));
        }
    }
}
