package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewParent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.38, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass38 {
    public static String[] A00;

    static {
        A00();
    }

    public static void A00() {
        A00 = new String[]{"Xrw23x", "7zPMnydgs3TxzLPidxoXPZBjc3W6JcCM", "VSpvz3ms1TmmGNHPZhiUX8aR3VKIqH3F", "EaUoYVziD6tZiyhi6MmXXr0L0WyyrmGO", "9W1llKphA1b", "WQVWtmgxG", "pfsLxZCw3", "djLiMbltlOZxr4Y20a1py0MoB6XUOCsc"};
    }

    public void A03(ViewParent viewParent, View view) {
        if (viewParent instanceof InterfaceC12932c) {
            throw null;
        }
    }

    public void A04(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof InterfaceC12932c) {
            throw null;
        }
    }

    public void A05(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof InterfaceC12932c) {
            throw null;
        }
    }

    public void A06(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof InterfaceC12932c) {
            throw null;
        }
    }

    public boolean A07(ViewParent viewParent, View view, float f2, float f3) {
        if (viewParent instanceof InterfaceC12932c) {
            return ((InterfaceC12932c) viewParent).onNestedPreFling(view, f2, f3);
        }
        String[] strArr = A00;
        if (strArr[1].charAt(19) != strArr[3].charAt(19)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[2] = "2JlvdJxfzc676EJF51BR6DiplsSASM3N";
        strArr2[2] = "2JlvdJxfzc676EJF51BR6DiplsSASM3N";
        return false;
    }

    public boolean A08(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (viewParent instanceof InterfaceC12932c) {
            return ((InterfaceC12932c) viewParent).onNestedFling(view, f2, f3, z);
        }
        return false;
    }

    public boolean A09(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof InterfaceC12932c) {
            return ((InterfaceC12932c) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }
}
