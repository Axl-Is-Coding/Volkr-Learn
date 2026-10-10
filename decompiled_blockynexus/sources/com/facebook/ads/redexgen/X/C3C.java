package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3C {
    public static final C3B A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new EZ();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A00 = new SI();
        } else {
            A00 = new C3B();
        }
    }

    public static int A00(AccessibilityEvent accessibilityEvent) {
        return A00.A00(accessibilityEvent);
    }

    public static void A01(AccessibilityEvent accessibilityEvent, int i) {
        A00.A01(accessibilityEvent, i);
    }
}
