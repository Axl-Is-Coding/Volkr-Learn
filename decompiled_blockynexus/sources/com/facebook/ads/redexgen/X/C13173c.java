package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13173c {
    public static byte[] A03;
    public static String[] A04;
    public final InterfaceC13163b A01;
    public final C13153a A00 = new C13153a();
    public final List<View> A02 = new ArrayList();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        strArr[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        A03 = new byte[]{-81, -93, -21, -20, -25, -25, -24, -15, -93, -17, -20, -10, -9, -67, -23, -25, -18, -34, -29, -36, -107, -23, -28, -107, -22, -29, -35, -34, -39, -38, -107, -42, -107, -21, -34, -38, -20, -107, -23, -35, -42, -23, -107, -20, -42, -24, -107, -29, -28, -23, -107, -35, -34, -39, -39, -38, -29, -35, -48, -52, -34, -121, -48, -38, -121, -43, -42, -37, -121, -56, -121, -54, -49, -48, -45, -53, -109, -121, -54, -56, -43, -43, -42, -37, -121, -49, -48, -53, -52, -121};
    }

    public static void A03() {
        A04 = new String[]{"QoGKHhEqLDc7cPbroRD", "LQzzwNJ4o6QHlfYkxXGOUA5ejYw8qpDj", "6ipC3ASGLl4rMOedI", "OPBJh0aCf", "l4bQelOwEyQeTpTSi", "DWBJmVB67PV4ItRyT2e9caL16z1NK91I", "0G1mJvoVA", "nRnK55wdJbrp31Rh0MWe0TNMbF4aeg8Y"};
    }

    public C13173c(InterfaceC13163b interfaceC13163b) {
        this.A01 = interfaceC13163b;
    }

    private int A00(int limit) {
        if (limit < 0) {
            return -1;
        }
        int iA5l = this.A01.A5l();
        int i = limit;
        while (i < iA5l) {
            int removedBefore = limit - (i - this.A00.A04(i));
            if (removedBefore == 0) {
                while (this.A00.A09(i)) {
                    i++;
                }
                return i;
            }
            i += removedBefore;
        }
        return -1;
    }

    private void A04(View view) {
        this.A02.add(view);
        this.A01.A9n(view);
    }

    private boolean A05(View view) {
        if (this.A02.remove(view)) {
            this.A01.AAE(view);
            return true;
        }
        return false;
    }

    public final int A06() {
        return this.A01.A5l() - this.A02.size();
    }

    public final int A07() {
        return this.A01.A5l();
    }

    public final int A08(View view) {
        int iA7d = this.A01.A7d(view);
        if (iA7d == -1 || this.A00.A09(iA7d)) {
            return -1;
        }
        return iA7d - this.A00.A04(iA7d);
    }

    public final View A09(int i) {
        int size = this.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.A02.get(i2);
            C4W c4wA5o = this.A01.A5o(view);
            if (c4wA5o.A0J() == i && !c4wA5o.A0c() && !c4wA5o.A0d()) {
                return view;
            }
        }
        return null;
    }

    public final View A0A(int i) {
        return this.A01.A5k(A00(i));
    }

    public final View A0B(int i) {
        return this.A01.A5k(i);
    }

    public final void A0C() {
        this.A00.A05();
        for (int size = this.A02.size() - 1; size >= 0; size--) {
            this.A01.AAE(this.A02.get(size));
            this.A02.remove(size);
        }
        this.A01.ACe();
    }

    public final void A0D(int i) {
        int iA00 = A00(i);
        this.A00.A0A(iA00);
        this.A01.A4j(iA00);
    }

    public final void A0E(int i) {
        int iA00 = A00(i);
        View viewA5k = this.A01.A5k(iA00);
        if (viewA5k == null) {
            return;
        }
        if (this.A00.A0A(iA00)) {
            A05(viewA5k);
        }
        this.A01.ACi(iA00);
        if (A04[4].length() == 16) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
        strArr[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
    }

    public final void A0F(View view) {
        int iA7d = this.A01.A7d(view);
        if (iA7d >= 0) {
            this.A00.A07(iA7d);
            A04(view);
        } else {
            throw new IllegalArgumentException(A01(57, 33, 25) + view);
        }
    }

    public final void A0G(View view) {
        int iA7d = this.A01.A7d(view);
        if (iA7d < 0) {
            return;
        }
        if (this.A00.A0A(iA7d)) {
            A05(view);
        }
        this.A01.ACi(iA7d);
    }

    public final void A0H(View view) {
        int iA7d = this.A01.A7d(view);
        if (iA7d >= 0) {
            if (this.A00.A09(iA7d)) {
                this.A00.A06(iA7d);
                A05(view);
                return;
            } else {
                throw new RuntimeException(A01(14, 43, 39) + view);
            }
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0I(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iA00;
        if (i < 0) {
            iA00 = this.A01.A5l();
        } else {
            iA00 = A00(i);
        }
        C13153a c13153a = this.A00;
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        strArr[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        c13153a.A08(iA00, z);
        if (z) {
            A04(view);
        }
        this.A01.A3U(view, iA00, layoutParams);
    }

    public final void A0J(View view, int i, boolean z) {
        int iA00;
        if (i < 0) {
            iA00 = this.A01.A5l();
        } else {
            iA00 = A00(i);
        }
        this.A00.A08(iA00, z);
        if (z) {
            A04(view);
        }
        this.A01.addView(view, iA00);
    }

    public final void A0K(View view, boolean z) {
        A0J(view, -1, z);
    }

    public final boolean A0L(View view) {
        return this.A02.contains(view);
    }

    public final boolean A0M(View view) {
        int iA7d = this.A01.A7d(view);
        if (iA7d == -1) {
            A05(view);
            if (A04[5].charAt(2) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "HipCYWSrBpzIS13Odtj";
            strArr[0] = "HipCYWSrBpzIS13Odtj";
            return true;
        }
        if (this.A00.A09(iA7d)) {
            this.A00.A0A(iA7d);
            A05(view);
            this.A01.ACi(iA7d);
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 53) + this.A02.size();
    }
}
