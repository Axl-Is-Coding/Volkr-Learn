package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M5 extends AdNativeComponentView {
    public static final int A01 = (int) (LX.A01 * 1.0f);
    public final ImageView A00;

    public M5(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = new MK(c2026Wb);
        this.A00.setScaleType(ImageView.ScaleType.CENTER_CROP);
        L5.A04(this.A00, L5.A0A);
        addView(this.A00, new ViewGroup.LayoutParams(-1, -1));
        LX.A0P(this.A00, -2130706433);
        int i = A01;
        setPadding(i, i, i, i);
    }

    @Override // com.facebook.ads.internal.api.AdNativeComponentView
    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
