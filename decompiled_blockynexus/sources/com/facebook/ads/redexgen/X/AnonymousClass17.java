package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.17, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(19)
public class AnonymousClass17 extends AnonymousClass28 {
    @Override // com.facebook.ads.redexgen.X.C1574Eb, com.facebook.ads.redexgen.X.C13092s
    public final void A0D(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final boolean A0J(View view) {
        return view.isAttachedToWindow();
    }
}
