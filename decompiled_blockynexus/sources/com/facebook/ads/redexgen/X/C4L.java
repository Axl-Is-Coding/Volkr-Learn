package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4L {
    public static String[] A02;
    public SparseArray<C4K> A00 = new SparseArray<>();
    public int A01 = 0;

    static {
        A02();
    }

    public static void A02() {
        A02 = new String[]{"hO0SXlIn7n5HXEBLx", "jESNVpuYnHPlnh4DZ", "CDLwN7DwmtArlNd144q1QIOvLDqs4yZF", "JntNhgZ58kYFXbwiJ6hzeVdvPNGn00kF", "yTsWpbzmHeCmcQEDkb0QkT5J3TV6CkfD", "Lh9pded4Clz2", "gnDNjs3GBImfOnnM5uEQWokXBd1c", "C4tnEN178k9sL9bIxtVolUttiI5dEdE5"};
    }

    private final long A00(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        long j3 = j / 4;
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        strArr2[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        return (j3 * 3) + (j2 / 4);
    }

    private C4K A01(int i) {
        C4K c4k = this.A00.get(i);
        if (c4k == null) {
            C4K c4k2 = new C4K();
            this.A00.put(i, c4k2);
            return c4k2;
        }
        return c4k;
    }

    private final void A03() {
        for (int i = 0; i < this.A00.size(); i++) {
            this.A00.valueAt(i).A03.clear();
        }
    }

    public final C4W A04(int i) {
        C4K c4k = this.A00.get(i);
        if (c4k != null && !c4k.A03.isEmpty()) {
            ArrayList<C4W> arrayList = c4k.A03;
            if (A02[4].charAt(1) != 'T') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[6] = "6zOEmNGiTAHU1v9SGa3";
            strArr[6] = "6zOEmNGiTAHU1v9SGa3";
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    public final void A05() {
        this.A01--;
    }

    public final void A06(int i, long j) {
        C4K c4kA01 = A01(i);
        c4kA01.A01 = A00(c4kA01.A01, j);
    }

    public final void A07(int i, long j) {
        C4K c4kA01 = A01(i);
        c4kA01.A02 = A00(c4kA01.A02, j);
    }

    public final void A08(AnonymousClass42 anonymousClass42) {
        this.A01++;
    }

    public final void A09(AnonymousClass42 anonymousClass42, AnonymousClass42 anonymousClass422, boolean z) {
        if (anonymousClass42 != null) {
            A05();
        }
        if (!z && this.A01 == 0) {
            A03();
        }
        if (anonymousClass422 != null) {
            A08(anonymousClass422);
        }
    }

    public final void A0A(C4W c4w) {
        int iA0I = c4w.A0I();
        ArrayList<C4W> arrayList = A01(iA0I).A03;
        if (this.A00.get(iA0I).A00 <= arrayList.size()) {
            return;
        }
        c4w.A0R();
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "TnDeXYrDbfmyODeGX";
        strArr2[5] = "ziritv0xfrad";
        arrayList.add(c4w);
    }

    public final boolean A0B(int i, long j, long j2) {
        long j3 = A01(i).A01;
        return j3 == 0 || j + j3 < j2;
    }

    public final boolean A0C(int i, long j, long j2) {
        long j3 = A01(i).A02;
        return j3 == 0 || j + j3 < j2;
    }
}
