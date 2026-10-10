package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.umeng.analytics.pro.m;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ST extends C4E implements C4Q {
    public static byte[] A0F;
    public static String[] A0G;
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AbstractC13383y A04;
    public boolean A05;
    public int A06;
    public C13343t A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C13323r A0D;
    public final C13333s A0E;

    static {
        A0X();
        A0W();
    }

    public static String A0U(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0W() {
        A0F = new byte[]{30, 25, 1, 22, 27, 30, 19, 87, 24, 5, 30, 18, 25, 3, 22, 3, 30, 24, 25, 77};
    }

    public static void A0X() {
        A0G = new String[]{"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    }

    public ST(Context context) {
        this(context, 1, false);
    }

    public ST(Context context, int i, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C13323r(this);
        this.A0E = new C13333s();
        this.A06 = 2;
        A2F(i);
        A0j(z);
        A1W(true);
    }

    private final int A05(int scrolled, C4M c4m, C4T c4t) {
        if (A0X() == 0 || scrolled == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2E();
        int i = scrolled > 0 ? 1 : -1;
        int iAbs = Math.abs(scrolled);
        A0a(i, iAbs, true, c4t);
        int iA09 = this.A07.A07 + A09(c4m, this.A07, c4t, false);
        if (iA09 < 0) {
            return 0;
        }
        int i2 = iAbs > iA09 ? i * iA09 : scrolled;
        this.A04.A0J(-i2);
        this.A07.A04 = i2;
        return i2;
    }

    private int A06(int fixOffset, C4M c4m, C4T c4t, boolean z) {
        int iA07 = this.A04.A07() - fixOffset;
        if (iA07 > 0) {
            int i = -A05(-iA07, c4m, c4t);
            int fixOffset2 = fixOffset + i;
            if (z) {
                int iA072 = this.A04.A07();
                if (A0G[0].length() == 7) {
                    throw new RuntimeException();
                }
                String[] strArr = A0G;
                strArr[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                strArr[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                int i2 = iA072 - fixOffset2;
                if (i2 > 0) {
                    this.A04.A0J(i2);
                    return i2 + i;
                }
            }
            return i;
        }
        return 0;
    }

    private int A08(int fixOffset, C4M c4m, C4T c4t, boolean z) {
        int fixOffset2;
        int iA0A = fixOffset - this.A04.A0A();
        if (iA0A > 0) {
            int i = -A05(iA0A, c4m, c4t);
            int fixOffset3 = fixOffset + i;
            if (z && (fixOffset2 = fixOffset3 - this.A04.A0A()) > 0) {
                this.A04.A0J(-fixOffset2);
                return i - fixOffset2;
            }
            return i;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A09(com.facebook.ads.redexgen.X.C4M r10, com.facebook.ads.redexgen.X.C13343t r11, com.facebook.ads.redexgen.X.C4T r12, boolean r13) {
        /*
            r9 = this;
            int r7 = r11.A00
            int r0 = r11.A07
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r6) goto L16
            int r0 = r11.A00
            if (r0 >= 0) goto L13
            int r1 = r11.A07
            int r0 = r11.A00
            int r1 = r1 + r0
            r11.A07 = r1
        L13:
            r9.A0g(r10, r11)
        L16:
            int r5 = r11.A00
            int r0 = r11.A02
            int r5 = r5 + r0
            com.facebook.ads.redexgen.X.3s r4 = r9.A0E
        L1d:
            boolean r0 = r11.A09
            if (r0 != 0) goto L23
            if (r5 <= 0) goto L33
        L23:
            boolean r0 = r11.A05(r12)
            if (r0 == 0) goto L33
            r4.A00()
            r9.A2I(r10, r12, r11, r4)
            boolean r0 = r4.A01
            if (r0 == 0) goto L37
        L33:
            int r0 = r11.A00
            int r7 = r7 - r0
            return r7
        L37:
            int r2 = r11.A06
            int r1 = r4.A00
            int r0 = r11.A05
            int r1 = r1 * r0
            int r2 = r2 + r1
            r11.A06 = r2
            boolean r0 = r4.A03
            if (r0 == 0) goto L51
            com.facebook.ads.redexgen.X.3t r0 = r9.A07
            java.util.List<com.facebook.ads.redexgen.X.4W> r0 = r0.A08
            if (r0 != 0) goto L51
            boolean r0 = r12.A07()
            if (r0 != 0) goto L5b
        L51:
            int r1 = r11.A00
            int r0 = r4.A00
            int r1 = r1 - r0
            r11.A00 = r1
            int r0 = r4.A00
            int r5 = r5 - r0
        L5b:
            int r0 = r11.A07
            if (r0 == r6) goto L8c
            int r1 = r11.A07
            int r0 = r4.A00
            int r1 = r1 + r0
            r11.A07 = r1
            int r0 = r11.A00
            if (r0 >= 0) goto L89
            int r8 = r11.A07
            int r3 = r11.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.ST.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto Lab
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ST.A0G
            java.lang.String r1 = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf"
            r0 = 5
            r2[r0] = r1
            int r8 = r8 + r3
            r11.A07 = r8
        L89:
            r9.A0g(r10, r11)
        L8c:
            if (r13 == 0) goto L1d
            boolean r3 = r4.A02
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.ST.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto Lab
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ST.A0G
            java.lang.String r1 = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov"
            r0 = 1
            r2[r0] = r1
            if (r3 == 0) goto L1d
            goto L33
        Lab:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ST.A09(com.facebook.ads.redexgen.X.4M, com.facebook.ads.redexgen.X.3t, com.facebook.ads.redexgen.X.4T, boolean):int");
    }

    private int A0A(C4T c4t) {
        if (A0X() != 0) {
            A2E();
            return C4X.A00(c4t, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B);
        }
        if (A0G[5].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
        strArr[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
        return 0;
    }

    private int A0B(C4T c4t) {
        if (A0X() == 0) {
            return 0;
        }
        A2E();
        return C4X.A02(c4t, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0C(C4T c4t) {
        if (A0X() != 0) {
            A2E();
            return C4X.A01(c4t, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B);
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
        strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
        return 0;
    }

    private final int A0D(C4T c4t) {
        if (c4t.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0E() {
        return A0u(this.A05 ? 0 : A0X() - 1);
    }

    private View A0F() {
        return A0u(this.A05 ? A0X() - 1 : 0);
    }

    private final View A0G(int preferredBoundsFlag, int acceptableBoundsFlag) {
        byte b2;
        int i;
        int i2;
        A2E();
        if (acceptableBoundsFlag > preferredBoundsFlag) {
            b2 = 1;
        } else {
            b2 = acceptableBoundsFlag < preferredBoundsFlag ? (byte) -1 : (byte) 0;
        }
        if (b2 == 0) {
            View viewA0u = A0u(preferredBoundsFlag);
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            strArr2[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return viewA0u;
        }
        if (this.A04.A0F(A0u(preferredBoundsFlag)) < this.A04.A0A()) {
            i = 16644;
            i2 = 16388;
        } else {
            i = 4161;
            i2 = m.a.f20899a;
        }
        if (this.A00 == 0) {
            return super.A04.A00(preferredBoundsFlag, acceptableBoundsFlag, i, i2);
        }
        return super.A05.A00(preferredBoundsFlag, acceptableBoundsFlag, i, i2);
    }

    private final View A0H(int acceptableBoundsFlag, int i, boolean z, boolean z2) {
        int i2;
        A2E();
        int i3 = 0;
        if (z) {
            i2 = 24579;
        } else {
            i2 = 320;
        }
        if (z2) {
            i3 = 320;
        }
        int i4 = this.A00;
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        if (i4 == 0) {
            return super.A04.A00(acceptableBoundsFlag, i, i2, i3);
        }
        return super.A05.A00(acceptableBoundsFlag, i, i2, i3);
    }

    private View A0I(C4M c4m, C4T c4t) {
        return A0G(0, A0X());
    }

    private View A0K(C4M c4m, C4T c4t) {
        return A2D(c4m, c4t, 0, A0X(), c4t.A03());
    }

    private View A0L(C4M c4m, C4T c4t) {
        return A0G(A0X() - 1, -1);
    }

    private View A0M(C4M c4m, C4T c4t) {
        return A2D(c4m, c4t, A0X() - 1, -1, c4t.A03());
    }

    private View A0N(C4M c4m, C4T c4t) {
        return this.A05 ? A0I(c4m, c4t) : A0L(c4m, c4t);
    }

    private View A0O(C4M c4m, C4T c4t) {
        return this.A05 ? A0L(c4m, c4t) : A0I(c4m, c4t);
    }

    private View A0P(C4M c4m, C4T c4t) {
        return this.A05 ? A0K(c4m, c4t) : A0M(c4m, c4t);
    }

    private View A0Q(C4M c4m, C4T c4t) {
        return this.A05 ? A0M(c4m, c4t) : A0K(c4m, c4t);
    }

    private View A0R(boolean z, boolean z2) {
        if (this.A05) {
            return A0H(0, A0X(), z, z2);
        }
        return A0H(A0X() - 1, -1, z, z2);
    }

    private View A0S(boolean z, boolean z2) {
        if (this.A05) {
            return A0H(A0X() - 1, -1, z, z2);
        }
        return A0H(0, A0X(), z, z2);
    }

    private final C13343t A0T() {
        return new C13343t();
    }

    private void A0V() {
        if (this.A00 == 1 || !A2K()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[6] = "rvopS3hSB7itRsuyG";
        strArr2[7] = "9RTUShXs4ZXrU4n03";
        this.A05 = z;
    }

    private void A0Y(int i, int i2) {
        this.A07.A00 = this.A04.A07() - i2;
        this.A07.A03 = this.A05 ? -1 : 1;
        C13343t c13343t = this.A07;
        c13343t.A01 = i;
        c13343t.A05 = 1;
        c13343t.A06 = i2;
        c13343t.A07 = Integer.MIN_VALUE;
    }

    private void A0Z(int i, int i2) {
        this.A07.A00 = i2 - this.A04.A0A();
        C13343t c13343t = this.A07;
        c13343t.A01 = i;
        c13343t.A03 = this.A05 ? 1 : -1;
        C13343t c13343t2 = this.A07;
        c13343t2.A05 = -1;
        c13343t2.A06 = i2;
        c13343t2.A07 = Integer.MIN_VALUE;
    }

    private void A0a(int i, int i2, boolean z, C4T c4t) {
        int iA0A;
        this.A07.A09 = A0k();
        this.A07.A02 = A0D(c4t);
        C13343t c13343t = this.A07;
        c13343t.A05 = i;
        if (i == 1) {
            c13343t.A02 += this.A04.A08();
            View viewA0E = A0E();
            C13343t c13343t2 = this.A07;
            if (!this.A05) {
                i = 1;
            }
            c13343t2.A03 = i;
            this.A07.A01 = A0q(viewA0E) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(viewA0E);
            iA0A = this.A04.A0C(viewA0E) - this.A04.A07();
        } else {
            View viewA0F = A0F();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0q(viewA0F) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(viewA0F);
            iA0A = (-this.A04.A0F(viewA0F)) + this.A04.A0A();
        }
        C13343t c13343t3 = this.A07;
        c13343t3.A00 = i2;
        if (z) {
            c13343t3.A00 -= iA0A;
        }
        this.A07.A07 = iA0A;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
        strArr[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
    }

    private void A0b(C13323r c13323r) {
        A0Y(c13323r.A01, c13323r.A00);
    }

    private void A0c(C13323r c13323r) {
        A0Z(c13323r.A01, c13323r.A00);
    }

    private void A0d(C4M c4m, int i) {
        int iA0X = A0X();
        if (i < 0) {
            return;
        }
        int iA06 = this.A04.A06() - i;
        if (this.A05) {
            for (int i2 = 0; i2 < iA0X; i2++) {
                View viewA0u = A0u(i2);
                if (this.A04.A0F(viewA0u) < iA06 || this.A04.A0H(viewA0u) < iA06) {
                    A0f(c4m, 0, i2);
                    return;
                }
            }
            return;
        }
        for (int i3 = iA0X - 1; i3 >= 0; i3--) {
            View viewA0u2 = A0u(i3);
            if (this.A04.A0F(viewA0u2) < iA06 || this.A04.A0H(viewA0u2) < iA06) {
                A0f(c4m, iA0X - 1, i3);
                return;
            }
        }
    }

    private void A0e(C4M c4m, int i) {
        if (i < 0) {
            return;
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[0] = "66";
        strArr2[0] = "66";
        int iA0X = A0X();
        if (this.A05) {
            for (int i2 = iA0X - 1; i2 >= 0; i2--) {
                View viewA0u = A0u(i2);
                if (this.A04.A0C(viewA0u) <= i) {
                    AbstractC13383y abstractC13383y = this.A04;
                    String[] strArr3 = A0G;
                    if (strArr3[6].length() != strArr3[7].length()) {
                        if (abstractC13383y.A0G(viewA0u) <= i) {
                        }
                    } else {
                        String[] strArr4 = A0G;
                        strArr4[3] = "uDZbJl3GZvnd0";
                        strArr4[3] = "uDZbJl3GZvnd0";
                        if (abstractC13383y.A0G(viewA0u) <= i) {
                        }
                    }
                }
                A0f(c4m, iA0X - 1, i2);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < iA0X; i3++) {
            View viewA0u2 = A0u(i3);
            int iA0C = this.A04.A0C(viewA0u2);
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            String[] strArr5 = A0G;
            strArr5[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
            strArr5[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
            if (iA0C > i || this.A04.A0G(viewA0u2) > i) {
                A0f(c4m, 0, i3);
                return;
            }
        }
    }

    private void A0f(C4M c4m, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                A15(i3, c4m);
            }
            return;
        }
        while (i > i2) {
            A15(i, c4m);
            i--;
        }
    }

    private void A0g(C4M c4m, C13343t c13343t) {
        if (!c13343t.A0B || c13343t.A09) {
            return;
        }
        int i = c13343t.A05;
        String[] strArr = A0G;
        if (strArr[6].length() == strArr[7].length()) {
            String[] strArr2 = A0G;
            strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
            strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
            if (i == -1) {
                int i2 = c13343t.A07;
                if (A0G[1].charAt(30) == 'o') {
                    String[] strArr3 = A0G;
                    strArr3[3] = "CiNTyTfZO3PW6tP";
                    strArr3[3] = "CiNTyTfZO3PW6tP";
                    A0d(c4m, i2);
                    return;
                }
            } else {
                A0e(c4m, c13343t.A07);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0h(C4M c4m, C4T c4t, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!c4t.A08() || A0X() == 0 || c4t.A07() || !A27()) {
            return;
        }
        int direction = 0;
        int i = 0;
        List<C4W> listA0K = c4m.A0K();
        int size = listA0K.size();
        int iA0q = A0q(A0u(0));
        for (int i2 = 0; i2 < size; i2++) {
            C4W c4w = listA0K.get(i2);
            if (!c4w.A0d()) {
                int position = c4w.A0J();
                byte b2 = 1;
                if ((position < iA0q) != this.A05) {
                    b2 = -1;
                }
                if (b2 == -1) {
                    int position2 = this.A04.A0D(c4w.A0H);
                    direction += position2;
                } else {
                    int position3 = this.A04.A0D(c4w.A0H);
                    i += position3;
                }
            }
        }
        this.A07.A08 = listA0K;
        if (direction > 0) {
            View anchor = A0F();
            A0Z(A0q(anchor), scrapExtraEnd);
            C13343t c13343t = this.A07;
            c13343t.A02 = direction;
            c13343t.A00 = 0;
            c13343t.A04();
            A09(c4m, this.A07, c4t, false);
        }
        if (i > 0) {
            View anchor2 = A0E();
            A0Y(A0q(anchor2), scrapExtraEnd2);
            C13343t c13343t2 = this.A07;
            c13343t2.A02 = i;
            c13343t2.A00 = 0;
            c13343t2.A04();
            A09(c4m, this.A07, c4t, false);
        }
        this.A07.A08 = null;
    }

    private void A0i(C4M c4m, C4T c4t, C13323r c13323r) {
        if (A0m(c4t, c13323r)) {
            return;
        }
        boolean zA0l = A0l(c4m, c4t, c13323r);
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[3] = "XDJ2jDWhUW9a7iN";
        strArr2[3] = "XDJ2jDWhUW9a7iN";
        if (zA0l) {
            return;
        }
        c13323r.A02();
        c13323r.A01 = this.A0C ? c4t.A03() - 1 : 0;
    }

    private final void A0j(boolean z) {
        A23(null);
        if (z == this.A0A) {
            return;
        }
        this.A0A = z;
        A0z();
    }

    private final boolean A0k() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0l(C4M c4m, C4T c4t, C13323r c13323r) {
        View viewA0Q;
        int iA0A;
        if (A0X() == 0) {
            return false;
        }
        View viewA0t = A0t();
        if (viewA0t != null && c13323r.A06(viewA0t, c4t)) {
            c13323r.A05(viewA0t);
            return true;
        }
        if (this.A08 != this.A0C) {
            return false;
        }
        if (c13323r.A02) {
            viewA0Q = A0P(c4m, c4t);
        } else {
            viewA0Q = A0Q(c4m, c4t);
        }
        if (viewA0Q == null) {
            return false;
        }
        c13323r.A04(viewA0Q);
        if (!c4t.A07() && A27()) {
            if (this.A04.A0F(viewA0Q) >= this.A04.A07() || this.A04.A0C(viewA0Q) < this.A04.A0A()) {
                if (c13323r.A02) {
                    iA0A = this.A04.A07();
                } else {
                    iA0A = this.A04.A0A();
                }
                c13323r.A00 = iA0A;
            }
        }
        return true;
    }

    private boolean A0m(C4T c4t, C13323r c13323r) {
        int i;
        int iA0F;
        if (c4t.A07() || (i = this.A01) == -1) {
            return false;
        }
        if (i < 0 || i >= c4t.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c13323r.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            if (this.A02 == Integer.MIN_VALUE) {
                View viewA1r = A1r(this.A01);
                if (viewA1r != null) {
                    int iA0D = this.A04.A0D(viewA1r);
                    int childSize = this.A04.A0B();
                    if (iA0D > childSize) {
                        c13323r.A02();
                        return true;
                    }
                    int iA0F2 = this.A04.A0F(viewA1r);
                    int childSize2 = this.A04.A0A();
                    if (iA0F2 - childSize2 < 0) {
                        int childSize3 = this.A04.A0A();
                        c13323r.A00 = childSize3;
                        c13323r.A02 = false;
                        return true;
                    }
                    int iA07 = this.A04.A07();
                    int childSize4 = this.A04.A0C(viewA1r);
                    if (iA07 - childSize4 < 0) {
                        int childSize5 = this.A04.A07();
                        c13323r.A00 = childSize5;
                        c13323r.A02 = true;
                        return true;
                    }
                    if (c13323r.A02) {
                        int iA0C = this.A04.A0C(viewA1r);
                        AbstractC13383y abstractC13383y = this.A04;
                        String[] strArr = A0G;
                        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0G;
                        strArr2[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        strArr2[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        iA0F = iA0C + abstractC13383y.A05();
                    } else {
                        iA0F = this.A04.A0F(viewA1r);
                    }
                    c13323r.A00 = iA0F;
                } else {
                    int childSize6 = A0X();
                    if (childSize6 > 0) {
                        int iA0q = A0q(A0u(0));
                        int pos = this.A01;
                        boolean z = pos < iA0q;
                        boolean z2 = this.A05;
                        if (A0G[1].charAt(30) != 'o') {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A0G;
                        strArr3[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                        strArr3[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                        c13323r.A02 = z == z2;
                    }
                    c13323r.A02();
                }
                return true;
            }
            boolean z3 = this.A05;
            c13323r.A02 = z3;
            if (z3) {
                c13323r.A00 = this.A04.A07() - this.A02;
            } else {
                c13323r.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
        c13323r.A02 = this.A03.A02;
        if (c13323r.A02) {
            c13323r.A00 = this.A04.A07() - this.A03.A00;
        } else {
            c13323r.A00 = this.A04.A0A() + this.A03.A00;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public int A1i(int i, C4M c4m, C4T c4t) {
        if (this.A00 == 1) {
            return 0;
        }
        return A05(i, c4m, c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public int A1j(int i, C4M c4m, C4T c4t) {
        if (this.A00 == 0) {
            return 0;
        }
        int iA05 = A05(i, c4m, c4t);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[3] = "CDnF1shpb";
        strArr2[3] = "CDnF1shpb";
        return iA05;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1k(C4T c4t) {
        return A0A(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1l(C4T c4t) {
        return A0B(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1m(C4T c4t) {
        return A0C(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1n(C4T c4t) {
        return A0A(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1o(C4T c4t) {
        return A0B(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final int A1p(C4T c4t) {
        return A0C(c4t);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final Parcelable A1q() {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            return new LinearLayoutManager$SavedState(linearLayoutManager$SavedState);
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState2 = new LinearLayoutManager$SavedState();
        if (A0X() > 0) {
            A2E();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState2.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View viewA0E = A0E();
                linearLayoutManager$SavedState2.A00 = this.A04.A07() - this.A04.A0C(viewA0E);
                linearLayoutManager$SavedState2.A01 = A0q(viewA0E);
            } else {
                View viewA0F = A0F();
                linearLayoutManager$SavedState2.A01 = A0q(viewA0F);
                linearLayoutManager$SavedState2.A00 = this.A04.A0F(viewA0F) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState2.A00();
        }
        return linearLayoutManager$SavedState2;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    @Nullable
    public final View A1r(int firstChild) {
        int viewPosition = A0X();
        if (viewPosition == 0) {
            return null;
        }
        int iA0q = firstChild - A0q(A0u(0));
        if (iA0q >= 0 && iA0q < viewPosition) {
            View viewA0u = A0u(iA0q);
            if (A0q(viewA0u) == firstChild) {
                return viewA0u;
            }
        }
        View child = super.A1r(firstChild);
        return child;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public View A1s(View view, int i, C4M c4m, C4T c4t) {
        int iA2C;
        View viewA0N;
        View viewA0E;
        A0V();
        if (A0X() == 0 || (iA2C = A2C(i)) == Integer.MIN_VALUE) {
            return null;
        }
        A2E();
        A2E();
        A0a(iA2C, (int) (this.A04.A0B() * 0.33333334f), false, c4t);
        C13343t c13343t = this.A07;
        c13343t.A07 = Integer.MIN_VALUE;
        c13343t.A0B = false;
        A09(c4m, c13343t, c4t, true);
        if (iA2C == -1) {
            viewA0N = A0O(c4m, c4t);
        } else {
            viewA0N = A0N(c4m, c4t);
        }
        if (iA2C == -1) {
            viewA0E = A0F();
        } else {
            viewA0E = A0E();
        }
        boolean zHasFocusable = viewA0E.hasFocusable();
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
        strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
        if (zHasFocusable) {
            if (viewA0N == null) {
                return null;
            }
            return viewA0E;
        }
        return viewA0N;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public C4F A1t() {
        return new C4F(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public void A1u(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0z();
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final void A1v(int i, int i2, C4T c4t, C4C c4c) {
        if (this.A00 != 0) {
            i = i2;
        }
        if (A0X() == 0 || i == 0) {
            return;
        }
        A2E();
        A0a(i > 0 ? 1 : -1, Math.abs(i), true, c4t);
        A2J(c4t, this.A07, c4c);
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0019 */
    @Override // com.facebook.ads.redexgen.X.C4E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1w(int r8, com.facebook.ads.redexgen.X.C4C r9) {
        /*
            r7 = this;
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            r6 = 0
            r5 = -1
            if (r0 == 0) goto L28
            boolean r0 = r0.A01()
            if (r0 == 0) goto L28
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            boolean r4 = r0.A02
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            int r2 = r0.A01
        L14:
            if (r4 == 0) goto L26
        L16:
            r1 = 0
        L17:
            int r0 = r7.A06
            if (r1 >= r0) goto L5f
            if (r2 < 0) goto L5f
            if (r2 >= r8) goto L5f
            r9.A3J(r2, r6)
            int r2 = r2 + r5
            int r1 = r1 + 1
            goto L17
        L26:
            r5 = 1
            goto L16
        L28:
            r7.A0V()
            boolean r4 = r7.A05
            int r3 = r7.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ST.A0G
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L47
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L47:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ST.A0G
            java.lang.String r1 = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM"
            r0 = 1
            r2[r0] = r1
            if (r3 != r5) goto L5c
            if (r4 == 0) goto L5a
            int r2 = r8 + (-1)
            goto L14
        L5a:
            r2 = 0
            goto L14
        L5c:
            int r2 = r7.A01
            goto L14
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ST.A1w(int, com.facebook.ads.redexgen.X.4C):void");
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final void A1x(Parcelable parcelable) {
        if (parcelable instanceof LinearLayoutManager$SavedState) {
            this.A03 = (LinearLayoutManager$SavedState) parcelable;
            A0z();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final void A1y(AccessibilityEvent accessibilityEvent) {
        super.A1y(accessibilityEvent);
        if (A0X() > 0) {
            accessibilityEvent.setFromIndex(A29());
            int iA2A = A2A();
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[3] = "9E5bhv9RVKulu";
            strArr[3] = "9E5bhv9RVKulu";
            accessibilityEvent.setToIndex(iA2A);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0261  */
    @Override // com.facebook.ads.redexgen.X.C4E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1z(com.facebook.ads.redexgen.X.C4M r10, com.facebook.ads.redexgen.X.C4T r11) {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ST.A1z(com.facebook.ads.redexgen.X.4M, com.facebook.ads.redexgen.X.4T):void");
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public void A20(C4T c4t) {
        super.A20(c4t);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final void A21(EI ei, C4M c4m) {
        super.A21(ei, c4m);
        if (this.A09) {
            A1J(c4m);
            c4m.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public void A22(EI ei, C4T c4t, int i) {
        SU su = new SU(ei.getContext());
        su.A0B(i);
        A1M(su);
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final void A23(String str) {
        if (this.A03 == null) {
            super.A23(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final boolean A24() {
        if (A0Z() != 1073741824 && A0j() != 1073741824) {
            boolean zA1X = A1X();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[0] = "ZYU5Lu8KJdo1W8";
            strArr[0] = "ZYU5Lu8KJdo1W8";
            if (zA1X) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final boolean A25() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public final boolean A26() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.X.C4E
    public boolean A27() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A28() {
        View viewA0H = A0H(0, A0X(), true, false);
        if (viewA0H == null) {
            return -1;
        }
        return A0q(viewA0H);
    }

    public final int A29() {
        View viewA0H = A0H(0, A0X(), false, true);
        if (viewA0H == null) {
            return -1;
        }
        return A0q(viewA0H);
    }

    public final int A2A() {
        View viewA0H = A0H(A0X() - 1, -1, false, true);
        if (viewA0H == null) {
            return -1;
        }
        return A0q(viewA0H);
    }

    public final int A2B() {
        return this.A00;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A2C(int r8) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ST.A2C(int):int");
    }

    public View A2D(C4M c4m, C4T c4t, int boundsEnd, int i, int i2) {
        A2E();
        View view = null;
        View view2 = null;
        int iA0A = this.A04.A0A();
        int iA07 = this.A04.A07();
        int i3 = i > boundsEnd ? 1 : -1;
        while (boundsEnd != i) {
            View viewA0u = A0u(boundsEnd);
            int iA0q = A0q(viewA0u);
            if (iA0q >= 0 && iA0q < i2) {
                if (((C4F) viewA0u.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = viewA0u;
                    }
                } else if (this.A04.A0F(viewA0u) >= iA07 || this.A04.A0C(viewA0u) < iA0A) {
                    if (view2 == null) {
                        view2 = viewA0u;
                    }
                } else {
                    return viewA0u;
                }
            }
            boundsEnd += i3;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2E() {
        if (this.A07 == null) {
            this.A07 = A0T();
        }
        if (this.A04 == null) {
            this.A04 = AbstractC13383y.A02(this, this.A00);
        }
    }

    public final void A2F(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(A0U(0, 20, 1) + i);
        }
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
        strArr[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
        A23(null);
        if (i == this.A00) {
            return;
        }
        this.A00 = i;
        this.A04 = null;
        A0z();
    }

    public final void A2G(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0z();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[3] = "tDl3kZGUKMTs";
        strArr[3] = "tDl3kZGUKMTs";
    }

    public void A2H(C4M c4m, C4T c4t, C13323r c13323r, int i) {
    }

    public void A2I(C4M c4m, C4T c4t, C13343t c13343t, C13333s c13333s) {
        int iA0h;
        int iA0E;
        int iA0f;
        int iA0E2;
        View viewA03 = c13343t.A03(c4m);
        if (viewA03 == null) {
            c13333s.A01 = true;
            return;
        }
        C4F c4f = (C4F) viewA03.getLayoutParams();
        if (c13343t.A08 == null) {
            if (this.A05 == (c13343t.A05 == -1)) {
                A18(viewA03);
            } else {
                A1A(viewA03, 0);
            }
        } else {
            boolean z = this.A05;
            int top = c13343t.A05;
            if (z == (top == -1)) {
                A17(viewA03);
            } else {
                A19(viewA03, 0);
            }
        }
        A1B(viewA03, 0, 0);
        c13333s.A00 = this.A04.A0D(viewA03);
        if (this.A00 == 1) {
            if (A2K()) {
                iA0E2 = A0i() - A0g();
                iA0f = iA0E2 - this.A04.A0E(viewA03);
            } else {
                iA0f = A0f();
                iA0E2 = this.A04.A0E(viewA03) + iA0f;
            }
            if (c13343t.A05 == -1) {
                iA0E = c13343t.A06;
                iA0h = c13343t.A06 - c13333s.A00;
            } else {
                iA0h = c13343t.A06;
                int i = c13343t.A06;
                int top2 = c13333s.A00;
                iA0E = i + top2;
            }
        } else {
            iA0h = A0h();
            iA0E = this.A04.A0E(viewA03) + iA0h;
            int top3 = c13343t.A05;
            if (top3 == -1) {
                iA0E2 = c13343t.A06;
                int i2 = c13343t.A06;
                int top4 = c13333s.A00;
                iA0f = i2 - top4;
            } else {
                iA0f = c13343t.A06;
                int i3 = c13343t.A06;
                int top5 = c13333s.A00;
                iA0E2 = i3 + top5;
            }
        }
        A1C(viewA03, iA0f, iA0h, iA0E2, iA0E);
        if (c4f.A02() || c4f.A01()) {
            c13333s.A03 = true;
        }
        c13333s.A02 = viewA03.hasFocusable();
    }

    public void A2J(C4T c4t, C13343t c13343t, C4C c4c) {
        int i = c13343t.A01;
        if (i >= 0 && i < c4t.A03()) {
            c4c.A3J(i, Math.max(0, c13343t.A07));
        }
    }

    public final boolean A2K() {
        return A0b() == 1;
    }

    @Override // com.facebook.ads.redexgen.X.C4Q
    public final PointF A45(int firstChildPos) {
        if (A0X() == 0) {
            return null;
        }
        int i = (firstChildPos < A0q(A0u(0))) != this.A05 ? -1 : 1;
        int i2 = this.A00;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
        strArr[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
        if (i2 == 0) {
            return new PointF(i, WheelView.DividerConfig.FILL);
        }
        return new PointF(WheelView.DividerConfig.FILL, i);
    }
}
