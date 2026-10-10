package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.86, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass86 {
    public static final AtomicReference<C2027Wc> A00 = new AtomicReference<>();

    @Nullable
    public static C2027Wc A00() {
        return A00.get();
    }

    public static void A01(C2027Wc c2027Wc) {
        if (c2027Wc == null) {
            return;
        }
        A00.compareAndSet(null, c2027Wc);
    }
}
