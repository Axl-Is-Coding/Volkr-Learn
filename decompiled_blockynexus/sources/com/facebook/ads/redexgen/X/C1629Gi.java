package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1629Gi implements Comparable<C1629Gi> {
    public final int A00;
    public final C1625Ge A01;

    public C1629Gi(int i, C1625Ge c1625Ge) {
        this.A00 = i;
        this.A01 = c1625Ge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull C1629Gi c1629Gi) {
        return this.A00 - c1629Gi.A00;
    }
}
