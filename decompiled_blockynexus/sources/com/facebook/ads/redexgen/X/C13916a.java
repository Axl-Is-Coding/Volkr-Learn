package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13916a {
    public final Map<Integer, C13865u<AbstractC14046n>> A00;

    @Nullable
    public static C13916a A02 = null;
    public static long A01 = 0;

    public C13916a(Map<Integer, C13865u<AbstractC14046n>> map) {
        this.A00 = map;
    }

    public static synchronized long A00() {
        return A01;
    }

    @SuppressLint({"UseSparseArrays"})
    public static C13916a A01() {
        if (A02 == null) {
            A02 = new C13916a(Collections.synchronizedMap(new HashMap()));
        }
        return A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5u != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A02(C13865u<AbstractC14046n> c13865u, int i) {
        int iA06 = 0;
        boolean z = false;
        if (c13865u.A01() == 0) {
            z = true;
            iA06 = c13865u.A02().A06();
        }
        int updatedSize = i - iA06;
        A01 += (long) ((z ? 0 : 4) + updatedSize);
    }

    @SuppressLint({"PublicMethodReturnMutableCollection"})
    public final Map<Integer, C13865u<AbstractC14046n>> A03() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5u != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    public final synchronized void A04(int i, C13865u<AbstractC14046n> c13865u, int i2) {
        this.A00.put(Integer.valueOf(i), c13865u);
        A02(c13865u, i2);
    }
}
