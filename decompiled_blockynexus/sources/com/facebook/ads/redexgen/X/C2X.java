package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2X {
    public static final View.AccessibilityDelegate A01;
    public static final C2W A02;
    public final View.AccessibilityDelegate A00 = A02.A00(this);

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            A02 = new S9();
        } else {
            A02 = new C2W();
        }
        A01 = new View.AccessibilityDelegate();
    }

    public final View.AccessibilityDelegate A00() {
        return this.A00;
    }

    public final C3K A01(View view) {
        return A02.A01(A01, view);
    }

    public final void A02(View view, int i) {
        A01.sendAccessibilityEvent(view, i);
    }

    public final void A03(View view, AccessibilityEvent accessibilityEvent) {
        A01.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final void A04(View view, AccessibilityEvent accessibilityEvent) {
        A01.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public final boolean A05(View view, AccessibilityEvent accessibilityEvent) {
        return A01.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final boolean A06(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return A01.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void A07(View view, AccessibilityEvent accessibilityEvent) {
        A01.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void A08(View view, C3I c3i) {
        A01.onInitializeAccessibilityNodeInfo(view, c3i.A0N());
    }

    public boolean A09(View view, int i, Bundle bundle) {
        return A02.A02(A01, view, i, bundle);
    }
}
