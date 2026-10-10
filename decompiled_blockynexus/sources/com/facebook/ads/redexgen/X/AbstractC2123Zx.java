package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2123Zx<T> extends KT {
    public final WeakReference<T> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Zx != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public AbstractC2123Zx(T t) {
        this.A00 = new WeakReference<>(t);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Zx != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public final T A08() {
        return this.A00.get();
    }
}
