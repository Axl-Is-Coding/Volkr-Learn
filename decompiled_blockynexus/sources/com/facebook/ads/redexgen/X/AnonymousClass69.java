package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.69, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass69 {
    public final C13815p A00;
    public final Map<Integer, C6V> A01;
    public final AtomicBoolean A02 = new AtomicBoolean();

    public AnonymousClass69(C13815p c13815p, Map<Integer, C6V> map) {
        this.A00 = c13815p;
        this.A01 = map;
        this.A02.compareAndSet(false, true);
    }

    private int A00(int i) {
        if (this.A00.A0e(i) != null) {
            return this.A00.A0e(i).intValue();
        }
        return this.A00.A0R();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5u != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A01(AbstractC14046n abstractC14046n, C6V c6v) {
        int iA00 = c6v.A00();
        Map<Integer, C13865u<AbstractC14046n>> mapA03 = C13916a.A01().A03();
        if (mapA03.containsKey(Integer.valueOf(iA00))) {
            C13865u<AbstractC14046n> c13865u = mapA03.get(Integer.valueOf(iA00));
            AbstractC14046n abstractC14046nA03 = c13865u != null ? c13865u.A03() : null;
            if (c13865u == null) {
                c13865u = new C13865u<>(A00(iA00));
            }
            if (!abstractC14046n.A0C(abstractC14046nA03, c6v.A03())) {
                c13865u.A05(abstractC14046n);
                C13916a.A01().A04(iA00, c13865u, abstractC14046n.A06());
            }
        } else {
            C13865u<AbstractC14046n> c13865u2 = new C13865u<>(A00(iA00));
            c13865u2.A05(abstractC14046n);
            C13916a.A01().A04(iA00, c13865u2, abstractC14046n.A06());
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A02(AbstractC14046n abstractC14046n, AnonymousClass68 anonymousClass68) {
        if (!this.A02.get()) {
            return;
        }
        try {
            switch (anonymousClass68) {
                case A0E:
                    C6V c6v = this.A01.get(10800);
                    if (abstractC14046n == null || c6v == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v);
                    }
                    break;
                case A03:
                    C6V c6v2 = this.A01.get(10810);
                    if (abstractC14046n == null || c6v2 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v2);
                    }
                    break;
                case A09:
                    C6V c6v3 = this.A01.get(10812);
                    if (abstractC14046n == null || c6v3 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v3);
                    }
                    break;
                case A06:
                    C6V c6v4 = this.A01.get(10813);
                    if (abstractC14046n == null || c6v4 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v4);
                    }
                    break;
                case A0A:
                    C6V c6v5 = this.A01.get(10814);
                    if (abstractC14046n == null || c6v5 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v5);
                    }
                    break;
                case A0B:
                    C6V c6v6 = this.A01.get(10815);
                    if (abstractC14046n == null || c6v6 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v6);
                    }
                    break;
                case A0D:
                    C6V c6v7 = this.A01.get(10816);
                    if (abstractC14046n == null || c6v7 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v7);
                    }
                    break;
                case A08:
                    C6V c6v8 = this.A01.get(10817);
                    if (abstractC14046n == null || c6v8 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v8);
                    }
                    break;
                case A05:
                    C6V c6v9 = this.A01.get(10818);
                    if (abstractC14046n == null || c6v9 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v9);
                    }
                    break;
                case A04:
                    C6V c6v10 = this.A01.get(10819);
                    if (abstractC14046n == null || c6v10 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v10);
                    }
                    break;
                case A0C:
                    C6V c6v11 = this.A01.get(10820);
                    if (abstractC14046n == null || c6v11 == null) {
                        return;
                    } else {
                        A01(abstractC14046n, c6v11);
                    }
                    break;
            }
        } catch (Throwable th) {
            AnonymousClass61.A04(th);
        }
    }
}
