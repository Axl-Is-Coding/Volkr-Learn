package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2Q extends EI {
    public C2Q(C2026Wb c2026Wb) {
        super(c2026Wb);
        setCarouselLayoutManager(c2026Wb);
    }

    @Override // com.facebook.ads.redexgen.X.EI
    public ST getLayoutManager() {
        return (ST) super.getLayoutManager();
    }

    private void setCarouselLayoutManager(C2026Wb c2026Wb) {
        ST st = new ST(c2026Wb, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            st.A1W(true);
        }
        super.setLayoutManager(st);
    }

    @Override // com.facebook.ads.redexgen.X.EI
    public void setLayoutManager(C4E c4e) {
    }
}
