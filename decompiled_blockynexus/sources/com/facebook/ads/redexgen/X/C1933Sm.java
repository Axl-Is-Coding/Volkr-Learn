package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1933Sm implements InterfaceC1767Lz {
    public static String[] A01;
    public final WeakReference<C13604u> A00;

    static {
        A01();
    }

    public static void A01() {
        A01 = new String[]{"JdxG2e87fiw1QxhKtyp6wy4hCZ34K54h", "5l6PiVFmWkFi4LSRmzN6ZIbVVY4PyA16", "qh41B7qjlQhNnOsbjTqj3JtjZfsrgLHf", "L6JKyztUTZrhaC2oSi2AGhNMneOalgfU", "mLvzPn8zSeH", "6Oneq6t5dYPlbDhRy7qxaYTJsizasisX", "J8", "lXMgpjBtmdYXVX4s4nwhe"};
    }

    public C1933Sm(C13604u c13604u) {
        this.A00 = new WeakReference<>(c13604u);
    }

    private void A02(C13604u c13604u) {
        OS os = c13604u.A0C;
        if (os != null) {
            c13604u.A06.bringChildToFront(os);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public final void A3K(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        C13604u c13604u = this.A00.get();
        if (c13604u != null) {
            c13604u.A06.addView(view, i, layoutParams);
            A02(c13604u);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public final void A3L(View view, RelativeLayout.LayoutParams layoutParams) {
        C13604u c13604u = this.A00.get();
        if (c13604u != null) {
            c13604u.A06.addView(view, layoutParams);
            A02(c13604u);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public void A3s(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0E(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public void A3t(String str, AnonymousClass98 anonymousClass98) {
        if (this.A00.get() != null) {
            this.A00.get().A0G(str, anonymousClass98);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public final void A81(String str, C1P c1p) {
        if (this.A00.get() != null) {
            C13604u c13604u = this.A00.get();
            String[] strArr = A01;
            if (strArr[0].charAt(19) != strArr[1].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "LaehfLm13EgRqqa58La6JsJDVjNkKsjm";
            strArr2[1] = "U7opStToMRhy5hKGwjx6Oh4Ofub1lgfJ";
            c13604u.A0F(str, c1p);
        }
    }
}
