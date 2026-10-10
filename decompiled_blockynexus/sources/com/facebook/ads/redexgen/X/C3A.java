package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.WindowInsets;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3A {
    public static String[] A01;
    public final Object A00;

    static {
        A02();
    }

    public static void A02() {
        A01 = new String[]{"el7YtyQobuGYp8qUnEWwGAo9eb5IMR8f", "BjlmtcQqBka41jhChDLZKaESgBphWA9m", "aKAY7r1GVGPP18xn5ioe", "SajdHZC8", "nRs3vifuwuv", "vQYmc1GWKj3CI1v3wMvKFH0VmcpB3A8S", "tuFyi1rHy9z46G0g3HP9J8Pe4WgIo7s9", "jDUjvWDGqsgivCcWfJbzlnhujFfNRoy6"};
    }

    public C3A(Object obj) {
        this.A00 = obj;
    }

    public static C3A A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C3A(obj);
    }

    public static Object A01(C3A c3a) {
        if (c3a == null) {
            return null;
        }
        return c3a.A00;
    }

    public final int A03() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final int A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int A05() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int A06() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final C3A A07(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C3A(((WindowInsets) this.A00).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public final boolean A08() {
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = this.A00;
            if (A01[7].charAt(25) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
            strArr[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
            return ((WindowInsets) obj).isConsumed();
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3A c3a = (C3A) obj;
        Object obj2 = this.A00;
        return obj2 == null ? c3a.A00 == null : obj2.equals(c3a.A00);
    }

    public final int hashCode() {
        Object obj = this.A00;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
