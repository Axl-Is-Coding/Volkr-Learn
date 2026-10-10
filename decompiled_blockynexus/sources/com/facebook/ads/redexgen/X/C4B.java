package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4B {
    @Deprecated
    private final void A00(Rect rect, int i, EI ei) {
        rect.set(0, 0, 0, 0);
    }

    public final void A01(Rect rect, View view, EI ei, C4T c4t) {
        A00(rect, ((C4F) view.getLayoutParams()).A00(), ei);
    }
}
