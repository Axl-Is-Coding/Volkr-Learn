package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1716Jx extends RelativeLayout implements InterfaceC1835Oq {

    @Nullable
    public LU A00;

    public AbstractC1716Jx(C2026Wb c2026Wb) {
        super(c2026Wb);
    }

    public AbstractC1716Jx(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void A86(LU lu) {
        this.A00 = lu;
        A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void ADt(LU lu) {
        A08();
        this.A00 = null;
    }

    @Nullable
    public LU getVideoView() {
        return this.A00;
    }
}
