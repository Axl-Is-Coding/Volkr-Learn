package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4M {
    public static byte[] A09;
    public static String[] A0A;
    public C4L A01;
    public C4U A04;
    public final /* synthetic */ EI A08;
    public final ArrayList<C4W> A05 = new ArrayList<>();
    public ArrayList<C4W> A02 = null;
    public final ArrayList<C4W> A06 = new ArrayList<>();
    public final List<C4W> A07 = Collections.unmodifiableList(this.A05);
    public int A03 = 2;
    public int A00 = 2;

    static {
        A06();
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A09 = new byte[]{-91, -18, -8, -58, -7, -7, -26, -24, -19, -22, -23, -65, -59, -32, 39, 30, 30, 43, 29, 44, -14, -53, -48, -62, -21, 22, 7, ci.m, -62, 5, 17, 23, ci.n, 22, -36, -38, -33, 36, 37, 18, 37, 22, -21, -99, -69, -58, -58, -65, -66, 122, -51, -67, -52, -69, -54, 122, -48, -61, -65, -47, 122, -47, -61, -50, -62, 122, -69, -56, 122, -61, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -120, 122, -93, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -51, 122, -67, -69, -56, -56, -55, -50, 122, -68, -65, 122, -52, -65, -49, -51, -65, -66, 122, -64, -52, -55, -57, 122, -51, -67, -52, -69, -54, -122, 122, -50, -62, -65, -45, 122, -51, -62, -55, -49, -58, -66, 122, -52, -65, -68, -55, -49, -56, -66, 122, -64, -52, -55, -57, 122, -52, -65, -67, -45, -67, -58, -65, -52, 122, -54, -55, -55, -58, -120, -7, 30, 19, 31, 30, 35, 25, 35, 36, 21, 30, 19, 41, -48, 20, 21, 36, 21, 19, 36, 21, 20, -34, -48, -7, 30, 38, 17, 28, 25, 20, -48, 25, 36, 21, 29, -48, 32, 31, 35, 25, 36, 25, 31, 30, -48, -13, 24, ci.k, 25, 24, 29, 19, 29, 30, ci.m, 24, ci.k, 35, -54, ci.l, ci.m, 30, ci.m, ci.k, 30, ci.m, ci.l, -40, -54, -13, 24, 32, 11, 22, 19, ci.l, -54, 32, 19, ci.m, 33, -54, 18, 25, 22, ci.l, ci.m, 28, -54, 11, ci.l, 11, 26, 30, ci.m, 28, -54, 26, 25, 29, 19, 30, 19, 25, 24, -125, -88, -80, -101, -90, -93, -98, 90, -93, -82, -97, -89, 90, -86, -87, -83, -93, -82, -93, -87, -88, 90, -63, -47, -32, -49, -34, -34, -45, -46, -114, -35, -32, -114, -49, -30, -30, -49, -47, -42, -45, -46, -114, -28, -41, -45, -27, -31, -114, -37, -49, -25, -114, -36, -35, -30, -114, -48, -45, -114, -32, -45, -47, -25, -47, -38, -45, -46, -100, -114, -41, -31, -63, -47, -32, -49, -34, -88, -35, -10, -7, -87, -19, -18, -3, -22, -20, -15, -18, -19, -87, -1, -14, -18, 0, -87, -4, -15, -8, -2, -11, -19, -87, -21, -18, -87, -5, -18, -10, -8, -1, -18, -19, -87, -17, -5, -8, -10, -87, -37, -18, -20, 2, -20, -11, -18, -5, -33, -14, -18, 0, -87, -21, -18, -17, -8, -5, -18, -87, -14, -3, -87, -20, -22, -9, -87, -21, -18, -87, -5, -18, -20, 2, -20, -11, -18, -19, -61, -87, -102, -72, -65, -81, -76, -83, 102, -70, -75, 102, -72, -85, -87, -65, -87, -78, -85, 102, -89, -76, 102, -81, -83, -76, -75, -72, -85, -86, 102, -68, -81, -85, -67, 102, -82, -75, -78, -86, -85, -72, 116, 102, -97, -75, -69, 102, -71, -82, -75, -69, -78, -86, 102, -84, -81, -72, -71, -70, 102, -87, -89, -78, -78, 102, -71, -70, -75, -74, -113, -83, -76, -75, -72, -81, -76, -83, -100, -81, -85, -67, 110, -68, -81, -85, -67, 111, 102, -88, -85, -84, -75, -72, -85, 102, -87, -89, -78, -78, -81, -76, -83, 102, -72, -85, -87, -65, -87, -78, -85, 116, -19, -21, -6, -36, -17, -21, -3, -52, -11, -8, -42, -11, -7, -17, -6, -17, -11, -12, -57, -12, -22, -38, -1, -10, -21, -90, -8, -21, -6, -5, -8, -12, -21, -22, -90, -25, -90, -4, -17, -21, -3, -90, -6, -18, -25, -6, -90, -17, -7, -90, -17, -19, -12, -11, -8, -21, -22, -76, -90, -33, -11, -5, -90, -13, -5, -7, -6, -90, -23, -25, -14, -14, -90, -7, -6, -11, -10, -49, -19, -12, -11, -8, -17, -12, -19, -90, -24, -21, -20, -11, -8, -21, -90, -8, -21, -6, -5, -8, -12, -17, -12, -19, -90, -6, -18, -17, -7, -90, -4, -17, -21, -3, -76, -78, -80, -65, -95, -76, -80, -62, -111, -70, -67, -101, -70, -66, -76, -65, -76, -70, -71, -116, -71, -81, -97, -60, -69, -80, 107, -67, -80, -65, -64, -67, -71, -80, -81, 107, -84, 107, -63, -76, -80, -62, 107, -62, -77, -76, -82, -77, 107, -81, -70, -80, -66, 107, -71, -70, -65, 107, -77, -84, -63, -80, 107, -84, 107, -95, -76, -80, -62, -109, -70, -73, -81, -80, -67, -63, -74, -50, -60, -54, -55, 117, -66, -61, -71, -70, -51, 117, -56, -67, -60, -54, -63, -71, 117, -61, -60, -55, 117, -73, -70, 117, -126, -122, 117, -74, -69, -55, -70, -57, 117, -54, -61, -67, -66, -71, -66, -61, -68, 117, -74, 117, -53, -66, -70, -52, -113};
    }

    public static void A06() {
        A0A = new String[]{"ulA9tMpXJ0Fgz3L6", "kmBp6JcSqPlb9eogqvbvj6g5ppHVaWSS", "klPqAM4BpBJNr6xIOjiQhoS6UO4TrOHS", "7VyM9GgXJuu8YzSYQI3HrMroeBYRJajD", "jF2bnw6E6wYHKm8plX11kYiLrSAbSJmD", "6pBnRch9VxXRPJwtqH0gd323b09mKXXU", "Clk2oRExhn8z5HC1wWkAqM8aEwWEfAA8", "Myq33IQdIYqIzBMhSJhfspyke76FBM0c"};
    }

    public C4M(EI ei) {
        this.A08 = ei;
    }

    private final View A00(int i, boolean z) {
        return A0J(i, z, Long.MAX_VALUE).A0H;
    }

    private final C4W A01(int i) {
        int size;
        int iA0E;
        ArrayList<C4W> arrayList = this.A02;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            C4W c4w = this.A02.get(i2);
            if (!c4w.A0j() && c4w.A0J() == i) {
                c4w.A0U(32);
                return c4w;
            }
        }
        if (this.A08.A04.A0C() && (iA0E = this.A08.A00.A0E(i)) > 0 && iA0E < this.A08.A04.A0E()) {
            long jA05 = this.A08.A04.A05(iA0E);
            for (int i3 = 0; i3 < size; i3++) {
                C4W c4w2 = this.A02.get(i3);
                if (!c4w2.A0j() && c4w2.A0L() == jA05) {
                    c4w2.A0U(32);
                    return c4w2;
                }
            }
        }
        return null;
    }

    private final C4W A02(int cacheSize, boolean z) {
        View viewA09;
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            C4W c4w = this.A05.get(i);
            if (!c4w.A0j() && c4w.A0J() == cacheSize && !c4w.A0c() && (this.A08.A0s.A09 || !c4w.A0d())) {
                c4w.A0U(32);
                return c4w;
            }
        }
        if (!z && (viewA09 = this.A08.A01.A09(cacheSize)) != null) {
            C4W c4wA0G = EI.A0G(viewA09);
            this.A08.A01.A0H(viewA09);
            int iA08 = this.A08.A01.A08(viewA09);
            if (iA08 != -1) {
                this.A08.A01.A0D(iA08);
                A0X(viewA09);
                c4wA0G.A0U(8224);
                return c4wA0G;
            }
            throw new IllegalStateException(A04(727, 52, 27) + c4wA0G + this.A08.A1J());
        }
        int size2 = this.A06.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C4W c4w2 = this.A06.get(i2);
            if (!c4w2.A0c() && c4w2.A0J() == cacheSize) {
                if (!z) {
                    this.A06.remove(i2);
                }
                return c4w2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C4W A03(long r8, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4M.A03(long, int, boolean):com.facebook.ads.redexgen.X.4W");
    }

    private final void A07() {
        for (int i = this.A06.size() - 1; i >= 0; i--) {
            A08(i);
        }
        this.A06.clear();
        if (EI.A1E) {
            this.A08.A02.A03();
        }
    }

    private final void A08(int i) {
        A0e(this.A06.get(i), true);
        this.A06.remove(i);
    }

    private void A09(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                String[] strArr = A0A;
                if (strArr[7].charAt(8) == strArr[6].charAt(8)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0A;
                strArr2[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                strArr2[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                A09((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
        } else {
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }
    }

    private void A0A(C4W c4w) {
        if (this.A08.A1t()) {
            View view = c4w.A0H;
            if (C2t.A00(view) == 0) {
                C2t.A09(view, 1);
            }
            if (!C2t.A0E(view)) {
                c4w.A0U(16384);
                C2t.A0A(view, this.A08.A09.A0A());
            }
        }
    }

    private void A0B(C4W c4w) {
        if (c4w.A0H instanceof ViewGroup) {
            A09((ViewGroup) c4w.A0H, false);
        }
    }

    private final void A0C(C4W c4w) {
        if (this.A08.A07 != null) {
            throw null;
        }
        AnonymousClass42 anonymousClass42 = this.A08.A04;
        if (this.A08.A0s != null) {
            this.A08.A0t.A0C(c4w);
        }
    }

    private final boolean A0D(C4W c4w) {
        if (c4w.A0d()) {
            return this.A08.A0s.A07();
        }
        if (c4w.A03 >= 0 && c4w.A03 < this.A08.A04.A0E()) {
            if (this.A08.A0s.A07() || this.A08.A04.A04(c4w.A03) == c4w.A0I()) {
                return !this.A08.A04.A0C() || c4w.A0L() == this.A08.A04.A05(c4w.A03);
            }
            return false;
        }
        throw new IndexOutOfBoundsException(A04(211, 60, 112) + c4w + this.A08.A1J());
    }

    private boolean A0E(C4W c4w, int i, int i2, long j) {
        c4w.A08 = this.A08;
        int iA0I = c4w.A0I();
        long nanoTime = this.A08.getNanoTime();
        if (j != Long.MAX_VALUE) {
            C4L c4l = this.A01;
            String[] strArr = A0A;
            if (strArr[5].charAt(0) == strArr[3].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[0] = "We3abAYlnqMpJzTP";
            strArr2[0] = "We3abAYlnqMpJzTP";
            if (!c4l.A0B(iA0I, nanoTime, j)) {
                return false;
            }
        }
        this.A08.A04.A0B(c4w, i);
        this.A01.A06(c4w.A0I(), this.A08.getNanoTime() - nanoTime);
        A0A(c4w);
        if (this.A08.A0s.A07()) {
            c4w.A04 = i2;
            return true;
        }
        return true;
    }

    public final int A0F() {
        return this.A05.size();
    }

    public final View A0G(int i) {
        return this.A05.get(i).A0H;
    }

    public final View A0H(int i) {
        return A00(i, false);
    }

    public final C4L A0I() {
        if (this.A01 == null) {
            this.A01 = new C4L();
        }
        return this.A01;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0236  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C4W A0J(int r23, boolean r24, long r25) {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4M.A0J(int, boolean, long):com.facebook.ads.redexgen.X.4W");
    }

    public final List<C4W> A0K() {
        return this.A07;
    }

    public final void A0L() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            this.A06.get(i).A0N();
        }
        int i2 = this.A05.size();
        for (int i3 = 0; i3 < i2; i3++) {
            this.A05.get(i3).A0N();
        }
        ArrayList<C4W> arrayList = this.A02;
        String[] strArr = A0A;
        String str = strArr[2];
        String str2 = strArr[1];
        int iCharAt = str.charAt(0);
        int scrapCount = str2.charAt(0);
        if (iCharAt != scrapCount) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[7] = "w7WcMXH384MQxArKBWq9tfOfmOANhXYh";
        strArr2[6] = "ji6HgViVTGyvfONq8Vqt8Uaju4D1iJHU";
        if (arrayList != null) {
            int changedScrapCount = arrayList.size();
            for (int i4 = 0; i4 < changedScrapCount; i4++) {
                this.A02.get(i4).A0N();
            }
        }
    }

    public final void A0M() {
        this.A05.clear();
        ArrayList<C4W> arrayList = this.A02;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final void A0N() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            C4F c4f = (C4F) this.A06.get(i).A0H.getLayoutParams();
            if (c4f != null) {
                c4f.A01 = true;
            }
        }
    }

    public final void A0O() {
        if (this.A08.A04 != null && this.A08.A04.A0C()) {
            int size = this.A06.size();
            for (int i = 0; i < size; i++) {
                C4W c4w = this.A06.get(i);
                if (A0A[0].length() != 16) {
                    throw new RuntimeException();
                }
                String[] strArr = A0A;
                strArr[2] = "kx9etu5Uswf3mlSSd54JM5SDJxoMGNTv";
                strArr[1] = "kxxNK4Rys8aPJuu822sP3fs8sDM7v1G0";
                if (c4w != null) {
                    c4w.A0U(6);
                    c4w.A0Z(null);
                }
            }
            return;
        }
        A07();
    }

    public final void A0P() {
        int i;
        if (this.A08.A06 != null) {
            C4E c4e = this.A08.A06;
            if (A0A[0].length() == 16) {
                String[] strArr = A0A;
                strArr[2] = "kSelswvDf1EbxUzrii1mBr6dHJR0d4zj";
                strArr[1] = "kcuGN1lunmBh6z5P1vsNJWvgiUTpOK0Q";
                i = c4e.A00;
            }
            throw new RuntimeException();
        }
        i = 0;
        this.A00 = this.A03 + i;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            int size2 = this.A06.size();
            String[] strArr2 = A0A;
            String str = strArr2[2];
            String str2 = strArr2[1];
            int iCharAt = str.charAt(0);
            int i2 = str2.charAt(0);
            if (iCharAt != i2) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0A;
            strArr3[2] = "kpxxdOz3cEfo3MLV8RPQuR2Jasv2n6jF";
            strArr3[1] = "kgO1H2GjmHeLX2ZusVi9gFRUJKE1zGI0";
            int i3 = this.A00;
            if (size2 > i3) {
                A08(size);
            } else {
                return;
            }
        }
    }

    public final void A0Q() {
        this.A05.clear();
        A07();
    }

    public final void A0R(int i) {
        this.A03 = i;
        A0P();
    }

    public final void A0S(int i, int i2) {
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            C4W c4w = this.A06.get(i3);
            if (c4w != null && c4w.A03 >= i) {
                c4w.A0X(i2, true);
            }
        }
    }

    public final void A0T(int end, int inBetweenOffset) {
        int cachedCount;
        int i;
        int i2;
        if (end < inBetweenOffset) {
            cachedCount = end;
            i = inBetweenOffset;
            i2 = -1;
        } else {
            cachedCount = inBetweenOffset;
            i = end;
            i2 = 1;
        }
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            C4W c4w = this.A06.get(i3);
            if (c4w != null && c4w.A03 >= cachedCount && c4w.A03 <= i) {
                int i4 = c4w.A03;
                String[] strArr = A0A;
                if (strArr[5].charAt(0) == strArr[3].charAt(0)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0A;
                strArr2[2] = "kvvW4F2OCwdEIl1qwIuxYVFpmp0ugJY5";
                strArr2[1] = "kzcCp2wTfEGQm2KGuN32b5oIYABnQWPG";
                if (i4 == end) {
                    c4w.A0X(inBetweenOffset - end, false);
                } else {
                    c4w.A0X(i2, false);
                }
            }
        }
    }

    public final void A0U(int cachedCount, int i) {
        int pos;
        int i2 = cachedCount + i;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            C4W c4w = this.A06.get(size);
            if (c4w != null && (pos = c4w.A03) >= cachedCount && pos < i2) {
                c4w.A0U(2);
                A08(size);
            }
        }
    }

    public final void A0V(int cachedCount, int i, boolean z) {
        int i2 = cachedCount + i;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            C4W c4w = this.A06.get(size);
            if (c4w != null) {
                if (c4w.A03 >= i2) {
                    c4w.A0X(-i, z);
                } else if (c4w.A03 >= cachedCount) {
                    c4w.A0U(8);
                    A08(size);
                }
            }
        }
    }

    public final void A0W(View view) {
        C4W c4wA0G = EI.A0G(view);
        c4wA0G.A0F = null;
        c4wA0G.A0G = false;
        c4wA0G.A0P();
        A0c(c4wA0G);
    }

    public final void A0X(View view) {
        C4W c4wA0G = EI.A0G(view);
        if (c4wA0G.A0l(12) || !c4wA0G.A0g() || this.A08.A21(c4wA0G)) {
            boolean zA0c = c4wA0G.A0c();
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[5] = "cscHAR4ImnAFzAxZJ9yqjMNa91RcN8Vb";
            strArr[3] = "pspTzLDNU823NSI2ymIgIumCpfqVQlal";
            if (!zA0c || c4wA0G.A0d() || this.A08.A04.A0C()) {
                c4wA0G.A0Y(this, false);
                this.A05.add(c4wA0G);
                return;
            } else {
                throw new IllegalArgumentException(A04(43, 122, 32) + this.A08.A1J());
            }
        }
        if (this.A02 == null) {
            this.A02 = new ArrayList<>();
        }
        c4wA0G.A0Y(this, true);
        this.A02.add(c4wA0G);
    }

    public final void A0Y(View view) {
        C4W c4wA0G = EI.A0G(view);
        if (c4wA0G.A0f()) {
            this.A08.removeDetachedView(view, false);
        }
        if (c4wA0G.A0e()) {
            c4wA0G.A0T();
        } else if (c4wA0G.A0j()) {
            c4wA0G.A0P();
        }
        A0c(c4wA0G);
    }

    public final void A0Z(AnonymousClass42 anonymousClass42, AnonymousClass42 anonymousClass422, boolean z) {
        A0Q();
        A0I().A09(anonymousClass42, anonymousClass422, z);
    }

    public final void A0a(C4L c4l) {
        C4L c4l2 = this.A01;
        if (c4l2 != null) {
            c4l2.A05();
        }
        this.A01 = c4l;
        if (c4l != null) {
            this.A01.A08(this.A08.getAdapter());
        }
    }

    public final void A0b(C4U c4u) {
        this.A04 = c4u;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0c(com.facebook.ads.redexgen.X.C4W r10) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4M.A0c(com.facebook.ads.redexgen.X.4W):void");
    }

    public final void A0d(C4W c4w) {
        if (c4w.A0G) {
            this.A02.remove(c4w);
        } else {
            this.A05.remove(c4w);
        }
        c4w.A0F = null;
        c4w.A0G = false;
        c4w.A0P();
    }

    public final void A0e(C4W c4w, boolean z) {
        EI.A0u(c4w);
        if (c4w.A0l(16384)) {
            c4w.A0V(0, 16384);
            C2t.A0A(c4w.A0H, null);
        }
        if (z) {
            A0C(c4w);
        }
        c4w.A08 = null;
        A0I().A0A(c4w);
    }
}
