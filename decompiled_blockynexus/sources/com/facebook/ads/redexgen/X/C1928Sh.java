package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1928Sh extends C2X {
    public static String[] A02;
    public final C2X A00 = new C1927Sg(this);
    public final EI A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"kCJseLSqSIrXu4CFjUZgH7qP37OfZeHD", "xEAmwUG5TGVzyoKH1PTTnmgJSds6zi0t", "yfye5wiKddzXjwKpYSAHRZ10SdbOyGIS", "FmBYeFx3U0BhjOzbepjZtX", "pFd99JFbVQiCxR8NKRmLZvqZPwpJ8hMq", "9sA", "zOMSQIOQC2uzgyYA4i3GoXbtL5yC1N4Y", "6JUJmYz6"};
    }

    public C1928Sh(EI ei) {
        this.A01 = ei;
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(EI.class.getName());
        if ((view instanceof EI) && !A0B()) {
            EI ei = (EI) view;
            if (ei.getLayoutManager() != null) {
                ei.getLayoutManager().A1y(accessibilityEvent);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final void A08(View view, C3I c3i) {
        super.A08(view, c3i);
        c3i.A0P(EI.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1G(c3i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            String[] strArr = A02;
            if (strArr[2].charAt(11) != strArr[0].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "nByhcE3HAON4xHhAaRL71J2smf2uyoDS";
            strArr2[4] = "nByhcE3HAON4xHhAaRL71J2smf2uyoDS";
            return true;
        }
        if (!A0B() && this.A01.getLayoutManager() != null) {
            C4E layoutManager = this.A01.getLayoutManager();
            if (A02[5].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr3 = A02;
            strArr3[7] = "ZdbAAVtg";
            strArr3[3] = "rBKlzqXoYmUf6BYv0O8fT1";
            return layoutManager.A1a(i, bundle);
        }
        return false;
    }

    public final C2X A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1u();
    }
}
