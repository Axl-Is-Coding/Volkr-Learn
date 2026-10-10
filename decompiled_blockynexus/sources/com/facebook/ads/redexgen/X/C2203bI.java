package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2203bI implements JK {
    public WeakReference<C2213bT> A00;

    public C2203bI(C2213bT c2213bT) {
        this.A00 = new WeakReference<>(c2213bT);
    }

    @Override // com.facebook.ads.redexgen.X.JK
    public final void AAi(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1U(z, false);
        }
    }
}
