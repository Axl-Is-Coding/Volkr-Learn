package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.39, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass39 {
    public static final AnonymousClass38 A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new C1573Ea();
        } else if (Build.VERSION.SDK_INT >= 19) {
            A00 = new SH();
        } else {
            A00 = new AnonymousClass38();
        }
    }

    public static void A00(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof SB) {
            throw null;
        }
        if (i == 0) {
            A00.A03(viewParent, view);
        }
    }

    public static void A01(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof SB) {
            throw null;
        }
        if (i5 == 0) {
            A00.A04(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void A02(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof SB) {
            throw null;
        }
        if (i3 == 0) {
            A00.A05(viewParent, view, i, i2, iArr);
        }
    }

    public static void A03(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof SB) {
            throw null;
        }
        if (i2 == 0) {
            A00.A06(viewParent, view, view2, i);
        }
    }

    public static boolean A04(ViewParent viewParent, View view, float f2, float f3) {
        return A00.A07(viewParent, view, f2, f3);
    }

    public static boolean A05(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        return A00.A08(viewParent, view, f2, f3, z);
    }

    public static boolean A06(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof SB) {
            return ((SB) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 == 0) {
            return A00.A09(viewParent, view, view2, i);
        }
        return false;
    }
}
