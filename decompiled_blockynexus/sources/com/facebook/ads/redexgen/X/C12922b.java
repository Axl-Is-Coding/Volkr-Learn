package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12922b {
    public static String[] A05;
    public ViewParent A00;
    public ViewParent A01;
    public boolean A02;
    public int[] A03;
    public final View A04;

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"efs8eZdEWHsCfUb6qOzicmMnQm4SneBY", "GPD1kjm6fR3i7blABsL8PkfqVt5tQ0ec", "1ZMAOqgxiysbgCK2QhJ8YR6mzQdOOVTU", "tADzoHnDRwqyF4JfOWpRm", "", "2dCxtsKJi8key4A0", "YZUwpVg0T4azRRaUQd2X9mlkfrI9cQeh", "C6BrW2LKkOXM7XSn"};
    }

    public C12922b(@NonNull View view) {
        this.A04 = view;
    }

    private ViewParent A00(int i) {
        if (i == 0) {
            return this.A01;
        }
        if (i != 1) {
            return null;
        }
        return this.A00;
    }

    private void A02(int i, ViewParent viewParent) {
        if (i == 0) {
            this.A01 = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.A00 = viewParent;
        }
    }

    public final void A03() {
        A04(0);
    }

    public final void A04(int i) {
        ViewParent viewParentA00 = A00(i);
        if (viewParentA00 != null) {
            AnonymousClass39.A00(viewParentA00, this.A04, i);
            A02(i, null);
        }
    }

    public final void A05(boolean z) {
        if (this.A02) {
            C2t.A08(this.A04);
        }
        this.A02 = z;
    }

    public final boolean A06() {
        return A0A(0);
    }

    public final boolean A07() {
        return this.A02;
    }

    public final boolean A08(float f2, float f3) {
        ViewParent viewParentA00;
        if (!A07() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AnonymousClass39.A04(viewParentA00, this.A04, f2, f3);
    }

    public final boolean A09(float f2, float f3, boolean z) {
        ViewParent viewParentA00;
        if (!A07() || (viewParentA00 = A00(0)) == null) {
            return false;
        }
        return AnonymousClass39.A05(viewParentA00, this.A04, f2, f3, z);
    }

    public final boolean A0A(int i) {
        return A00(i) != null;
    }

    public final boolean A0B(int i) {
        return A0C(i, 0);
    }

    public final boolean A0C(int i, int i2) {
        if (A0A(i2)) {
            return true;
        }
        if (A07()) {
            if (A05[0].charAt(13) == 't') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "WHooJguTbRSPJrOooyt3LEnarcCTCzBe";
            strArr[1] = "8Bjeqw0rr3DdKBFvYwfvH0FxnGa8049d";
            View view = this.A04;
            for (ViewParent parent = this.A04.getParent(); parent != null; parent = parent.getParent()) {
                if (AnonymousClass39.A06(parent, view, this.A04, i, i2)) {
                    A02(i2, parent);
                    AnonymousClass39.A03(parent, view, this.A04, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean A0D(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return A0E(i, i2, i3, i4, iArr, 0);
    }

    public final boolean A0E(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        ViewParent viewParentA00;
        if (!A07() || (viewParentA00 = A00(i5)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int startY = 0;
            int i6 = 0;
            if (iArr != null) {
                this.A04.getLocationInWindow(iArr);
                startY = iArr[0];
                i6 = iArr[1];
            }
            AnonymousClass39.A01(viewParentA00, this.A04, i, i2, i3, i4, i5);
            if (iArr != null) {
                this.A04.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - startY;
                iArr[1] = iArr[1] - i6;
            }
            return true;
        }
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return false;
    }

    public final boolean A0F(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return A0G(i, i2, iArr, iArr2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0G(int r17, int r18, @androidx.annotation.Nullable int[] r19, @androidx.annotation.Nullable int[] r20, int r21) {
        /*
            r16 = this;
            r14 = r19
            r1 = r16
            r4 = r1
            boolean r0 = r1.A07()
            r9 = 0
            if (r0 == 0) goto Lb1
            r15 = r21
            android.view.ViewParent r10 = r1.A00(r15)
            if (r10 != 0) goto L15
            return r9
        L15:
            r8 = 1
            r13 = r18
            r12 = r17
            r3 = r20
            if (r12 != 0) goto L20
            if (r13 == 0) goto Lab
        L20:
            r7 = 0
            r6 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C12922b.A05
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 9
            if (r1 == r0) goto La5
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C12922b.A05
            java.lang.String r1 = "3VbjZKhXDsexEmt2meqPVZABMNEQkFPW"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "3VbjZKhXDsexEmt2meqPVZABMNEQkFPW"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto L46
            android.view.View r0 = r4.A04
            r0.getLocationInWindow(r3)
            r7 = r3[r9]
            r6 = r3[r8]
        L46:
            if (r14 != 0) goto L71
            int[] r5 = r4.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C12922b.A05
            r0 = 5
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L96
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C12922b.A05
            java.lang.String r1 = ""
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = ""
            r0 = 4
            r2[r0] = r1
            if (r5 != 0) goto L6f
        L6a:
            r0 = 2
            int[] r0 = new int[r0]
            r4.A03 = r0
        L6f:
            int[] r14 = r4.A03
        L71:
            r14[r9] = r9
            r14[r8] = r9
            android.view.View r11 = r4.A04
            com.facebook.ads.redexgen.X.AnonymousClass39.A02(r10, r11, r12, r13, r14, r15)
            if (r3 == 0) goto L8b
            android.view.View r0 = r4.A04
            r0.getLocationInWindow(r3)
            r0 = r3[r9]
            int r0 = r0 - r7
            r3[r9] = r0
            r0 = r3[r8]
            int r0 = r0 - r6
            r3[r8] = r0
        L8b:
            r0 = r14[r9]
            if (r0 != 0) goto L93
            r0 = r14[r8]
            if (r0 == 0) goto L94
        L93:
            return r8
        L94:
            r8 = 0
            goto L93
        L96:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C12922b.A05
            java.lang.String r1 = "gHL5QaZEq3qu3ZW6"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "on2hgQBHubksAtN0"
            r0 = 7
            r2[r0] = r1
            if (r5 != 0) goto L6f
            goto L6a
        La5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Lab:
            if (r3 == 0) goto Lb1
            r3[r9] = r9
            r3[r8] = r9
        Lb1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12922b.A0G(int, int, int[], int[], int):boolean");
    }
}
