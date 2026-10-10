package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class A1 implements Comparable<A1> {
    public int A00;
    public long A01;

    @Nullable
    public Object A02;
    public final AQ A03;

    public A1(AQ aq) {
        this.A03 = aq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull A1 a1) {
        if ((this.A02 == null) != (a1.A02 == null)) {
            return this.A02 != null ? -1 : 1;
        }
        if (this.A02 == null) {
            return 0;
        }
        int i = this.A00 - a1.A00;
        if (i != 0) {
            return i;
        }
        return IW.A07(this.A01, a1.A01);
    }

    public final void A01(int i, long j, Object obj) {
        this.A00 = i;
        this.A01 = j;
        this.A02 = obj;
    }
}
