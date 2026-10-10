package com.facebook.ads.redexgen.X;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class GC {
    public static String[] A08;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public final List<GB> A06 = new ArrayList();
    public final List<SpannableString> A07 = new ArrayList();
    public final StringBuilder A05 = new StringBuilder();

    static {
        A01();
    }

    public static void A01() {
        A08 = new String[]{"cHi9U0Pg", "VGea8qk0EPS8OqQ4obSD5aeRlTRdn39K", "J", "J", "UkvFMUtno93mVTdlP0lNSPxeQZ", "4fCjFf2htdfAP", "I6h5KAyxQwYPDLtwjcMWBd", "QYcuKDWzo7FBs229Db5R79YAEK36tHpY"};
    }

    public GC(int i, int i2) {
        A0A(i);
        A0B(i2);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0019 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.text.SpannableString A00() {
        /*
            r15 = this;
            r10 = r15
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            java.lang.StringBuilder r0 = r10.A05
            r8.<init>(r0)
            int r9 = r8.length()
            r7 = -1
            r6 = -1
            r5 = 0
            r4 = -1
            r14 = 0
            r11 = -1
            r3 = 0
        L13:
            java.util.List<com.facebook.ads.redexgen.X.GB> r0 = r10.A06
            int r0 = r0.size()
            if (r3 >= r0) goto La5
            java.util.List<com.facebook.ads.redexgen.X.GB> r0 = r10.A06
            java.lang.Object r12 = r0.get(r3)
            com.facebook.ads.redexgen.X.GB r12 = (com.facebook.ads.redexgen.X.GB) r12
            boolean r1 = r12.A02
            int r2 = r12.A01
            r0 = 8
            if (r2 == r0) goto L31
            r0 = 7
            if (r2 != r0) goto L9d
            r14 = 1
        L2f:
            if (r2 != r0) goto L96
        L31:
            int r2 = r12.A00
            int r12 = r3 + 1
            java.util.List<com.facebook.ads.redexgen.X.GB> r0 = r10.A06
            int r0 = r0.size()
            if (r12 >= r0) goto L94
            java.util.List<com.facebook.ads.redexgen.X.GB> r12 = r10.A06
            int r0 = r3 + 1
            java.lang.Object r0 = r12.get(r0)
            com.facebook.ads.redexgen.X.GB r0 = (com.facebook.ads.redexgen.X.GB) r0
            int r0 = r0.A00
        L49:
            if (r2 != r0) goto L4e
        L4b:
            int r3 = r3 + 1
            goto L13
        L4e:
            r0 = -1
            if (r7 == r0) goto L8d
            if (r1 != 0) goto L8d
            A03(r8, r7, r2)
            r7 = -1
        L57:
            r13 = -1
            java.lang.String[] r12 = com.facebook.ads.redexgen.X.GC.A08
            r0 = 4
            r1 = r12[r0]
            r0 = 5
            r0 = r12[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L9f
            java.lang.String[] r12 = com.facebook.ads.redexgen.X.GC.A08
            java.lang.String r1 = "lr4TMFgGLuEdpqEBom9kPNzU6S"
            r0 = 4
            r12[r0] = r1
            java.lang.String r1 = "0zdhGbgYXkwlZ"
            r0 = 5
            r12[r0] = r1
            if (r6 == r13) goto L86
            if (r14 != 0) goto L86
            A02(r8, r6, r2)
            r6 = -1
        L7e:
            if (r11 == r4) goto L4b
            A04(r8, r5, r2, r4)
            r4 = r11
            r5 = r2
            goto L4b
        L86:
            r0 = -1
            if (r6 != r0) goto L7e
            if (r14 == 0) goto L7e
            r6 = r2
            goto L7e
        L8d:
            r0 = -1
            if (r7 != r0) goto L57
            if (r1 == 0) goto L57
            r7 = r2
            goto L57
        L94:
            r0 = r9
            goto L49
        L96:
            int[] r0 = com.facebook.ads.redexgen.X.C13072q.A0K()
            r11 = r0[r2]
            goto L31
        L9d:
            r14 = 0
            goto L2f
        L9f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        La5:
            r0 = -1
            if (r7 == r0) goto Lad
            if (r7 == r9) goto Lad
            A03(r8, r7, r9)
        Lad:
            if (r6 == r0) goto Lb4
            if (r6 == r9) goto Lb4
            A02(r8, r6, r9)
        Lb4:
            if (r5 == r9) goto Lb9
            A04(r8, r5, r9, r4)
        Lb9:
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GC.A00():android.text.SpannableString");
    }

    public static void A02(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
    }

    public static void A03(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
    }

    public static void A04(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
        if (i3 == -1) {
            return;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
    }

    public final int A05() {
        return this.A03;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.G5 A06() {
        /*
            r16 = this;
            r3 = r16
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>()
            r4 = 0
        L8:
            java.util.List<android.text.SpannableString> r0 = r3.A07
            int r0 = r0.size()
            if (r4 >= r0) goto L49
            java.util.List<android.text.SpannableString> r0 = r3.A07
            java.lang.Object r5 = r0.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.GC.A08
            r0 = 7
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L32
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L32:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.GC.A08
            java.lang.String r1 = "JfGeCXNtH9OkzyiNPcVTkTkkVF"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "U8fcuMPJKIItC"
            r0 = 5
            r2[r0] = r1
            r8.append(r5)
            r0 = 10
            r8.append(r0)
            int r4 = r4 + 1
            goto L8
        L49:
            android.text.SpannableString r0 = r16.A00()
            r8.append(r0)
            int r0 = r8.length()
            if (r0 != 0) goto L58
            r0 = 0
            return r0
        L58:
            int r7 = r3.A02
            int r0 = r3.A04
            int r7 = r7 + r0
            int r6 = 32 - r7
            int r0 = r8.length()
            int r6 = r6 - r0
            int r5 = r7 - r6
            int r0 = r3.A00
            r4 = 2
            if (r0 != r4) goto L97
            int r1 = java.lang.Math.abs(r5)
            r0 = 3
            if (r1 < r0) goto L74
            if (r6 >= 0) goto L97
        L74:
            r13 = 1056964608(0x3f000000, float:0.5)
            r14 = 1
        L77:
            int r1 = r3.A00
            r0 = 1
            if (r1 == r0) goto L81
            int r1 = r3.A03
            r0 = 7
            if (r1 <= r0) goto L93
        L81:
            r12 = 2
            int r0 = r3.A03
            int r0 = r0 + (-15)
            int r0 = r0 + (-2)
        L88:
            com.facebook.ads.redexgen.X.G5 r7 = new com.facebook.ads.redexgen.X.G5
            android.text.Layout$Alignment r9 = android.text.Layout.Alignment.ALIGN_NORMAL
            float r10 = (float) r0
            r11 = 1
            r15 = 1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r7
        L93:
            r12 = 0
            int r0 = r3.A03
            goto L88
        L97:
            int r0 = r3.A00
            r2 = 1036831949(0x3dcccccd, float:0.1)
            r13 = 1061997773(0x3f4ccccd, float:0.8)
            r1 = 1107296256(0x42000000, float:32.0)
            if (r0 != r4) goto Lad
            if (r5 <= 0) goto Lad
            int r0 = 32 - r6
            float r0 = (float) r0
            float r0 = r0 / r1
            float r13 = r13 * r0
            float r13 = r13 + r2
            r14 = 2
            goto L77
        Lad:
            float r0 = (float) r7
            float r0 = r0 / r1
            float r13 = r13 * r0
            float r13 = r13 + r2
            r14 = 0
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GC.A06():com.facebook.ads.redexgen.X.G5");
    }

    public final void A07() {
        int length = this.A05.length();
        if (length > 0) {
            this.A05.delete(length - 1, length);
            for (int size = this.A06.size() - 1; size >= 0; size--) {
                List<GB> list = this.A06;
                String[] strArr = A08;
                String str = strArr[2];
                String str2 = strArr[3];
                int length2 = str.length();
                int i = str2.length();
                if (length2 != i) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[0] = "cQse4OX3";
                strArr2[6] = "MGHTHr2HMLcimDeu5sZkGF";
                GB gb = list.get(size);
                int i2 = gb.A00;
                if (i2 == length) {
                    int i3 = gb.A00;
                    gb.A00 = i3 - 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void A08() {
        this.A07.add(A00());
        this.A05.setLength(0);
        this.A06.clear();
        int iMin = Math.min(this.A01, this.A03);
        while (this.A07.size() >= iMin) {
            this.A07.remove(0);
        }
    }

    public final void A09(char c2) {
        this.A05.append(c2);
    }

    public final void A0A(int i) {
        this.A00 = i;
        this.A06.clear();
        this.A07.clear();
        this.A05.setLength(0);
        this.A03 = 15;
        this.A02 = 0;
        this.A04 = 0;
    }

    public final void A0B(int i) {
        this.A01 = i;
    }

    public final void A0C(int i) {
        this.A02 = i;
    }

    public final void A0D(int i) {
        this.A03 = i;
    }

    public final void A0E(int i) {
        this.A04 = i;
    }

    public final void A0F(int i, boolean z) {
        this.A06.add(new GB(i, z, this.A05.length()));
    }

    public final boolean A0G() {
        if (this.A06.isEmpty() && this.A07.isEmpty()) {
            StringBuilder sb = this.A05;
            String[] strArr = A08;
            if (strArr[0].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[7] = "ONSLHBaiVChTiCDyCbz7MeGvMb5ZJwv8";
            strArr2[1] = "WV9KVve3dIDV1UZxgbczLfOjx2KW4DPJ";
            if (sb.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return this.A05.toString();
    }
}
