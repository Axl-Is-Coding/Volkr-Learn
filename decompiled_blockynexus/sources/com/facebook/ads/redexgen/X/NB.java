package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NB extends C1795Nc {
    public final ImageView A00;
    public final C2026Wb A01;

    public NB(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A01 = c2026Wb;
        this.A00 = new ImageView(c2026Wb);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC2037Wm asyncTaskC2037Wm = new AsyncTaskC2037Wm(this.A00, this.A01);
        asyncTaskC2037Wm.A05();
        asyncTaskC2037Wm.A08(str);
    }
}
