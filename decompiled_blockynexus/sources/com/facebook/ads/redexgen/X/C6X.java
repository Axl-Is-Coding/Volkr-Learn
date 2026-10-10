package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6X<T> {
    public final int A00;
    public final int A01;
    public final T A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6X != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public C6X(T bundledSignalMetadataKey, int i, int i2) {
        this.A02 = bundledSignalMetadataKey;
        this.A00 = i;
        this.A01 = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6X != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    private boolean A00() {
        int i;
        int i2 = this.A00;
        return i2 > 0 && i2 < 9999 && (i = this.A01) > 0 && i < 10000 && i2 < i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6X != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public final T A01() {
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6X != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public final boolean A02() {
        return A00() && Build.VERSION.SDK_INT >= this.A00 && Build.VERSION.SDK_INT < this.A01;
    }
}
