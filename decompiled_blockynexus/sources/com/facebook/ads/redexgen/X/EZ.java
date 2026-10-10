package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(19)
public class EZ extends SI {
    @Override // com.facebook.ads.redexgen.X.C3B
    public final int A00(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    @Override // com.facebook.ads.redexgen.X.C3B
    public final void A01(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}
