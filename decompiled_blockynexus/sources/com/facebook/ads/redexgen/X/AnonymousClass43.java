package com.facebook.ads.redexgen.X;

import android.database.Observable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.43, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass43 extends Observable<AnonymousClass44> {
    public final void A00() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((AnonymousClass44) this.mObservers.get(size)).A00();
        }
    }
}
