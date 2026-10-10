package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2t, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2t {
    public static final C13092s A00;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            A00 = new C0O() { // from class: com.facebook.ads.redexgen.X.04
            };
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            A00 = new C0O();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            A00 = new C0Y();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new C12390a();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new AnonymousClass17();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            A00 = new AnonymousClass28();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            A00 = new C3V();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            A00 = new C1574Eb();
        } else if (Build.VERSION.SDK_INT >= 15) {
            A00 = new SC();
        } else {
            A00 = new C13092s();
        }
    }

    public static int A00(View view) {
        return A00.A04(view);
    }

    public static int A01(View view) {
        return A00.A05(view);
    }

    public static int A02(View view) {
        return A00.A06(view);
    }

    public static int A03(View view) {
        return A00.A07(view);
    }

    public static Display A04(@NonNull View view) {
        return A00.A08(view);
    }

    public static C3A A05(View view, C3A c3a) {
        return A00.A09(view, c3a);
    }

    public static C3A A06(View view, C3A c3a) {
        return A00.A0A(view, c3a);
    }

    public static void A07(View view) {
        A00.A0B(view);
    }

    public static void A08(@NonNull View view) {
        A00.A0C(view);
    }

    public static void A09(View view, int i) {
        A00.A0D(view, i);
    }

    public static void A0A(View view, C2X c2x) {
        A00.A0E(view, c2x);
    }

    public static void A0B(View view, InterfaceC12942d interfaceC12942d) {
        A00.A0F(view, interfaceC12942d);
    }

    public static void A0C(View view, Runnable runnable) {
        A00.A0G(view, runnable);
    }

    public static void A0D(View view, Runnable runnable, long j) {
        A00.A0H(view, runnable, j);
    }

    public static boolean A0E(View view) {
        return A00.A0K(view);
    }

    public static boolean A0F(View view) {
        return A00.A0I(view);
    }
}
