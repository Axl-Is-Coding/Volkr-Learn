package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1566Dt extends SU {
    public final /* synthetic */ AbstractC1931Sk A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1566Dt(AbstractC1931Sk abstractC1931Sk, Context context) {
        super(context);
        this.A00 = abstractC1931Sk;
    }

    @Override // com.facebook.ads.redexgen.X.SU, com.facebook.ads.redexgen.X.C4R
    public final void A0J(View view, C4T c4t, C4P c4p) {
        AbstractC1931Sk abstractC1931Sk = this.A00;
        int[] iArrA0J = abstractC1931Sk.A0J(abstractC1931Sk.A00.getLayoutManager(), view);
        int i = iArrA0J[0];
        int i2 = iArrA0J[1];
        int iA0N = A0N(Math.max(Math.abs(i), Math.abs(i2)));
        if (iA0N > 0) {
            c4p.A05(i, i2, iA0N, ((SU) this).A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final float A0K(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }
}
