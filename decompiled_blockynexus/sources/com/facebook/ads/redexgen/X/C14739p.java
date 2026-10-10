package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14739p extends SU {
    public final /* synthetic */ C14719n A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14739p(C14719n c14719n, C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = c14719n;
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final float A0K(DisplayMetrics displayMetrics) {
        return this.A00.A00 / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final int A0L() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final int A0P(View view, int left) {
        C4E c4eA09 = A09();
        if (!c4eA09.A25()) {
            return 0;
        }
        C4F c4f = (C4F) view.getLayoutParams();
        int start = c4eA09.A0l(view) - c4f.leftMargin;
        int end = c4eA09.A0o(view) + c4f.rightMargin;
        return A0O(start, end, c4eA09.A0f(), c4eA09.A0i() - c4eA09.A0g(), left) + this.A00.A02;
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final PointF A0Q(int i) {
        return this.A00.A45(i);
    }
}
