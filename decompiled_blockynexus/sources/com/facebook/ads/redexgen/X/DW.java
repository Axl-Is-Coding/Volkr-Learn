package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DW {
    public final int A00;
    public final long A01;

    public DW(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static DW A00(CB cb, IG ig) throws InterruptedException, IOException {
        cb.ABs(ig.A00, 0, 8);
        ig.A0Z(0);
        int id = ig.A09();
        return new DW(id, ig.A0L());
    }
}
