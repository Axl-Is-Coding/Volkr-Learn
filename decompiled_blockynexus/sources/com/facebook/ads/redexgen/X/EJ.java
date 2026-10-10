package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EJ extends AbstractC1931Sk {
    public static String[] A02;

    @Nullable
    public AbstractC13383y A00;

    @Nullable
    public AbstractC13383y A01;

    static {
        A05();
    }

    public static void A05() {
        A02 = new String[]{"C44Ajl3kvJruV1G0pt7gVRuztfjSJyFq", "J5x5lFquh7whloqA7FngbvBzLsCb", "NWBvU5bW0Pue", "3", "BTAVkHunqM91yRRN2KcoYuZCergWfboL", "2NY5ANPTvwBPWrnTgdotgLNYCmp8", "bg7eF9CjngMlwdFplTojabi", "lLeEucKPPYu6Z0yxrpg2o1MG4v3W39r2"};
    }

    private int A00(@NonNull C4E c4e, @NonNull View view, AbstractC13383y abstractC13383y) {
        int iA06;
        int iA0F = abstractC13383y.A0F(view) + (abstractC13383y.A0D(view) / 2);
        if (c4e.A1Y()) {
            iA06 = abstractC13383y.A0A() + (abstractC13383y.A0B() / 2);
        } else {
            iA06 = abstractC13383y.A06() / 2;
        }
        return iA0F - iA06;
    }

    @Nullable
    private View A01(C4E c4e, AbstractC13383y abstractC13383y) {
        int iA06;
        int absClosest = c4e.A0X();
        if (absClosest == 0) {
            return null;
        }
        View child = null;
        if (c4e.A1Y()) {
            int iA0A = abstractC13383y.A0A();
            int iA0B = abstractC13383y.A0B();
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "QSrTWOl4jyYASaYHeqwJw7nAVlZS9nVf";
            strArr[4] = "QSrTWOl4jyYASaYHeqwJw7nAVlZS9nVf";
            iA06 = iA0A + (iA0B / 2);
        } else {
            iA06 = abstractC13383y.A06() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < absClosest; i2++) {
            View viewA0u = c4e.A0u(i2);
            int iA0F = abstractC13383y.A0F(viewA0u);
            int i3 = abstractC13383y.A0D(viewA0u);
            int childCenter = Math.abs((iA0F + (i3 / 2)) - iA06);
            if (childCenter < i) {
                i = childCenter;
                child = viewA0u;
            }
        }
        return child;
    }

    @Nullable
    private View A02(C4E c4e, AbstractC13383y abstractC13383y) {
        int i = c4e.A0X();
        if (i == 0) {
            return null;
        }
        View view = null;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < i; i3++) {
            View viewA0u = c4e.A0u(i3);
            int iA0F = abstractC13383y.A0F(viewA0u);
            if (iA0F < i2) {
                i2 = iA0F;
                int childStart = A02[3].length();
                if (childStart != 1) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[3] = "0";
                strArr[3] = "0";
                view = viewA0u;
            }
        }
        return view;
    }

    @NonNull
    private AbstractC13383y A03(@NonNull C4E c4e) {
        AbstractC13383y abstractC13383y = this.A00;
        if (abstractC13383y == null || abstractC13383y.A02 != c4e) {
            this.A00 = AbstractC13383y.A00(c4e);
        }
        return this.A00;
    }

    @NonNull
    private AbstractC13383y A04(@NonNull C4E c4e) {
        AbstractC13383y abstractC13383y = this.A01;
        if (abstractC13383y == null || abstractC13383y.A02 != c4e) {
            this.A01 = AbstractC13383y.A01(c4e);
        }
        return this.A01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    @Override // com.facebook.ads.redexgen.X.AbstractC1931Sk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0E(com.facebook.ads.redexgen.X.C4E r10, int r11, int r12) {
        /*
            r9 = this;
            int r8 = r10.A0a()
            r4 = -1
            if (r8 != 0) goto L8
            return r4
        L8:
            r1 = 0
            boolean r0 = r10.A26()
            if (r0 == 0) goto L1a
            com.facebook.ads.redexgen.X.3y r0 = r9.A04(r10)
            android.view.View r1 = r9.A02(r10, r0)
        L17:
            if (r1 != 0) goto L47
            return r4
        L1a:
            boolean r0 = r10.A25()
            if (r0 == 0) goto L17
            com.facebook.ads.redexgen.X.3y r3 = r9.A03(r10)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EJ.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 1
            if (r1 == r0) goto L36
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L36:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EJ.A02
            java.lang.String r1 = "gb7KateBwDTMhlVKT6fWGE4qrSBelOuo"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "gb7KateBwDTMhlVKT6fWGE4qrSBelOuo"
            r0 = 4
            r2[r0] = r1
            android.view.View r1 = r9.A02(r10, r3)
            goto L17
        L47:
            int r3 = r10.A0q(r1)
            if (r3 != r4) goto L4e
            return r4
        L4e:
            boolean r0 = r10.A25()
            r7 = 0
            if (r0 == 0) goto Lab
            if (r11 <= 0) goto La9
            r6 = 1
        L58:
            r5 = 0
            boolean r0 = r10 instanceof com.facebook.ads.redexgen.X.C4Q
            if (r0 == 0) goto L8e
            com.facebook.ads.redexgen.X.4Q r10 = (com.facebook.ads.redexgen.X.C4Q) r10
            int r0 = r8 + (-1)
            android.graphics.PointF r4 = r10.A45(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EJ.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 1
            if (r1 == r0) goto L9a
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EJ.A02
            java.lang.String r1 = "yuw4mNpzW34AqVSRehlxNeo"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "wkUUhZpWZ02e"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L8e
        L7f:
            float r0 = r4.x
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L8c
            float r0 = r4.y
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L8d
        L8c:
            r7 = 1
        L8d:
            r5 = r7
        L8e:
            if (r5 == 0) goto L95
            if (r6 == 0) goto L94
            int r3 = r3 + (-1)
        L94:
            return r3
        L95:
            if (r6 == 0) goto L94
            int r3 = r3 + 1
            goto L94
        L9a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EJ.A02
            java.lang.String r1 = "mSLQWLSJnMsLfeZB8hd0gvJZQvTgwPgU"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "mSLQWLSJnMsLfeZB8hd0gvJZQvTgwPgU"
            r0 = 0
            r2[r0] = r1
            if (r4 == 0) goto L8e
            goto L7f
        La9:
            r6 = 0
            goto L58
        Lab:
            if (r12 <= 0) goto Laf
            r6 = 1
            goto L58
        Laf:
            r6 = 0
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EJ.A0E(com.facebook.ads.redexgen.X.4E, int, int):int");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1931Sk
    @Nullable
    public final View A0F(C4E c4e) {
        if (c4e.A26()) {
            return A01(c4e, A04(c4e));
        }
        if (c4e.A25()) {
            return A01(c4e, A03(c4e));
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1931Sk
    public final SU A0G(C4E c4e) {
        if (!(c4e instanceof C4Q)) {
            return null;
        }
        return new EK(this, super.A00.getContext());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1931Sk
    @Nullable
    public final int[] A0J(@NonNull C4E c4e, @NonNull View view) {
        int[] iArr = new int[2];
        if (c4e.A25()) {
            iArr[0] = A00(c4e, view, A03(c4e));
        } else {
            iArr[0] = 0;
        }
        boolean zA26 = c4e.A26();
        String[] strArr = A02;
        if (strArr[1].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "E62MX6H1I4NpqQbgkpQnwXfK7jhgOp7C";
        strArr2[0] = "E62MX6H1I4NpqQbgkpQnwXfK7jhgOp7C";
        if (zA26) {
            iArr[1] = A00(c4e, view, A04(c4e));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
