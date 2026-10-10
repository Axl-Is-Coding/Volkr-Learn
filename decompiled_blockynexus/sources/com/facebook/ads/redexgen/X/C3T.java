package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3T {
    public static final C3S A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new SO();
        } else {
            A00 = new C3S();
        }
    }

    public static void A00(EdgeEffect edgeEffect, float f2, float f3) {
        A00.A00(edgeEffect, f2, f3);
    }
}
