package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1801Ni {
    public static final int A01 = C2F.A01(-16777216, 115);
    public static final int A00 = C2F.A01(-1, 0);

    public static void A00(C2026Wb c2026Wb, ViewGroup viewGroup, String str) {
        new AsyncTaskC2037Wm(viewGroup, c2026Wb).A08(str);
        View view = new View(c2026Wb);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LX.A0V(view, c2026Wb);
        viewGroup.addView(view, 0);
    }
}
