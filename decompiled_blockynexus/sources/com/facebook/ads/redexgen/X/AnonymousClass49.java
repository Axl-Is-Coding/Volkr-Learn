package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.49, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass49 {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final AnonymousClass49 A00(C4W c4w, int i) {
        View view = c4w.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final AnonymousClass49 A01(C4W c4w) {
        return A00(c4w, 0);
    }
}
