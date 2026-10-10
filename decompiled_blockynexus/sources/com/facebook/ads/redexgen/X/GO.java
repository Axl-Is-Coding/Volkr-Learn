package com.facebook.ads.redexgen.X;

import android.util.SparseArray;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GO {
    public GI A00;
    public GK A01;
    public final int A02;
    public final int A03;
    public final SparseArray<GM> A08 = new SparseArray<>();
    public final SparseArray<GH> A06 = new SparseArray<>();
    public final SparseArray<GJ> A07 = new SparseArray<>();
    public final SparseArray<GH> A04 = new SparseArray<>();
    public final SparseArray<GJ> A05 = new SparseArray<>();

    public GO(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}
