package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.50, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass50 {
    public static C0R A00(Context context, AnonymousClass89 anonymousClass89) {
        C2027Wc sdkContext = A07(context);
        C0U c0uA6R = anonymousClass89.A6R(sdkContext);
        if (c0uA6R != null) {
            return c0uA6R.A8i();
        }
        return new R1();
    }

    public static C2026Wb A01(Activity activity) {
        return new C2026Wb(activity, A08(), A00(activity, A08()));
    }

    public static C2026Wb A02(Context context) {
        return new C2026Wb(context, A08(), new R1());
    }

    public static C2026Wb A03(Context context) {
        return new C2026Wb(context, A08(), A00(context, A08()));
    }

    public static C2026Wb A04(Context context) {
        if (C1693Iy.A0m(context)) {
            return new C2026Wb(context, A08(), A00(context, A08()));
        }
        return A02(context);
    }

    public static C2026Wb A05(Context context) {
        return new C2026Wb(context, A08(), A00(context, A08()));
    }

    public static C1534Cl A06(Context context) {
        return new C1534Cl(context, A08(), A08().A6R(A07(context)));
    }

    public static C2027Wc A07(Context context) {
        return new C2027Wc(context, A08());
    }

    public static synchronized AnonymousClass89 A08() {
        return XA.A02();
    }
}
