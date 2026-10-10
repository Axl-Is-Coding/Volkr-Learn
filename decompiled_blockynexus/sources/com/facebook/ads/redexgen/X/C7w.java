package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7w, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C7w extends AbstractC1712Jt {
    public final /* synthetic */ C7v A00;

    public C7w(C7v c7v) {
        this.A00 = c7v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(C1713Ju c1713Ju) {
        new Handler(Looper.getMainLooper()).post(new OF(this));
    }
}
