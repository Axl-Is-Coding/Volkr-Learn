package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(16)
public class C1574Eb extends SC {
    @Override // com.facebook.ads.redexgen.X.C13092s
    public final int A04(View view) {
        return view.getImportantForAccessibility();
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final int A06(View view) {
        return view.getMinimumHeight();
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final int A07(View view) {
        return view.getMinimumWidth();
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final void A0B(View view) {
        view.postInvalidateOnAnimation();
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public void A0D(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final void A0G(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final void A0H(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final boolean A0I(View view) {
        return view.hasTransientState();
    }
}
