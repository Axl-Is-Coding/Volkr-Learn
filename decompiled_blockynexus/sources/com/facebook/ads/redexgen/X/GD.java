package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GD {
    public static byte[] A0M;
    public static String[] A0N;
    public static final int A0O;
    public static final int A0P;
    public static final int A0Q;
    public static final int[] A0R;
    public static final int[] A0S;
    public static final int[] A0T;
    public static final int[] A0U;
    public static final int[] A0V;
    public static final int[] A0W;
    public static final int[] A0X;
    public static final boolean[] A0Y;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final List<SpannableString> A0L = new ArrayList();
    public final SpannableStringBuilder A0K = new SpannableStringBuilder();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 47;
            String[] strArr = A0N;
            if (strArr[1].charAt(25) != strArr[0].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[7] = "EGk9np7aMhyDNRiub589ymbWmiZaYsnv";
            strArr2[5] = "MoHjhkGHxknM09OundQuhqQ3IVB6xBhn";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0M = new byte[]{87, 108, 103, 122, 114, 103, 97, 118, 103, 102, 34, 104, 119, 113, 118, 107, 100, 107, 97, 99, 118, 107, 109, 108, 34, 116, 99, 110, 119, 103, 56, 34};
    }

    public static void A05() {
        A0N = new String[]{"GlVHckn51Vanl7Vih5Esv8zIqIMxBgkG", "Gu0mdIpKDUd91D8731Vgkf2rQInnPX0q", "LYxm1SmSDrFGckkqyRDu581qL7t4zqdr", "wLzi90m5JnQ3vlsc62fZXtuMGM726oCo", "LMTGU1aow53O5naV", "g0ywSDs0rh9PJAouvJPa5HkBHtmUXg07", "15rANKJrnjVxjOAN", "gGGCjWA2OtQnSQFuntVJeMpfRqk0w0Oj"};
    }

    static {
        A05();
        A04();
        A0P = A01(2, 2, 2, 0);
        A0O = A01(0, 0, 0, 0);
        A0Q = A01(0, 0, 0, 3);
        A0V = new int[]{0, 0, 0, 0, 0, 2, 0};
        A0W = new int[]{0, 0, 0, 0, 0, 0, 2};
        A0X = new int[]{3, 3, 3, 3, 3, 3, 1};
        A0Y = new boolean[]{false, false, false, true, true, true, false};
        int i = A0O;
        int i2 = A0Q;
        A0U = new int[]{i, i2, i, i, i2, i, i};
        A0T = new int[]{0, 1, 2, 3, 4, 3, 4};
        A0S = new int[]{0, 0, 0, 0, 0, 3, 3};
        A0R = new int[]{i, i, i, i, i, i2, i2};
    }

    public GD() {
        A09();
    }

    public static int A00(int i, int i2, int i3) {
        return A01(i, i2, i3, 0);
    }

    public static int A01(int i, int i2, int alpha, int i3) {
        int i4;
        C1662Hr.A00(i, 0, 4);
        C1662Hr.A00(i2, 0, 4);
        C1662Hr.A00(alpha, 0, 4);
        C1662Hr.A00(i3, 0, 4);
        if (i3 == 0 || i3 == 1) {
            i4 = 255;
        } else if (i3 == 2) {
            i4 = 127;
        } else if (i3 != 3) {
            i4 = 255;
        } else {
            i4 = 0;
        }
        return Color.argb(i4, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, alpha > 1 ? 255 : 0);
    }

    private final SpannableString A02() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A0K);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.A06 != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.A06, length, 33);
            }
            if (this.A0C != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.A0C, length, 33);
            }
            if (this.A04 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.A03), this.A04, length, 33);
            }
            if (this.A02 != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.A01), this.A02, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x0016 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C2131a7 A06() {
        /*
            r17 = this;
            r3 = r17
            boolean r0 = r17.A0I()
            if (r0 == 0) goto La
            r0 = 0
            return r0
        La:
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder
            r6.<init>()
            r1 = 0
        L10:
            java.util.List<android.text.SpannableString> r0 = r3.A0L
            int r0 = r0.size()
            if (r1 >= r0) goto L2b
            java.util.List<android.text.SpannableString> r0 = r3.A0L
            java.lang.Object r0 = r0.get(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            r0 = 10
            r6.append(r0)
            int r1 = r1 + 1
            goto L10
        L2b:
            android.text.SpannableString r0 = r17.A02()
            r6.append(r0)
            int r1 = r3.A07
            r4 = 3
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L9c
            r0 = 2
            if (r1 == r0) goto L99
            if (r1 != r4) goto L9f
        L3f:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_NORMAL
        L41:
            boolean r0 = r3.A0H
            if (r0 == 0) goto L8c
            int r0 = r3.A05
            float r11 = (float) r0
            r5 = 1120272384(0x42c60000, float:99.0)
            float r11 = r11 / r5
            int r0 = r3.A0D
            float r1 = (float) r0
            float r1 = r1 / r5
        L4f:
            r8 = 1063675494(0x3f666666, float:0.9)
            float r11 = r11 * r8
            r0 = 1028443341(0x3d4ccccd, float:0.05)
            float r11 = r11 + r0
            float r8 = r8 * r1
            float r8 = r8 + r0
            int r1 = r3.A00
            int r0 = r1 % 3
            if (r0 != 0) goto L85
            r10 = 0
        L60:
            int r1 = r3.A00
            int r0 = r1 / 3
            if (r0 != 0) goto L7e
            r12 = 0
        L67:
            int r1 = r3.A0E
            int r0 = com.facebook.ads.redexgen.X.GD.A0O
            if (r1 == r0) goto L7c
            r14 = 1
        L6e:
            com.facebook.ads.redexgen.X.a7 r5 = new com.facebook.ads.redexgen.X.a7
            r9 = 0
            r13 = 1
            int r15 = r3.A0E
            int r0 = r3.A09
            r16 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r5
        L7c:
            r14 = 0
            goto L6e
        L7e:
            int r1 = r1 / r4
            if (r1 != r2) goto L83
            r12 = 1
            goto L67
        L83:
            r12 = 2
            goto L67
        L85:
            int r1 = r1 % r4
            if (r1 != r2) goto L8a
            r10 = 1
            goto L60
        L8a:
            r10 = 2
            goto L60
        L8c:
            int r0 = r3.A05
            float r11 = (float) r0
            r0 = 1129381888(0x43510000, float:209.0)
            float r11 = r11 / r0
            int r0 = r3.A0D
            float r1 = (float) r0
            r0 = 1116995584(0x42940000, float:74.0)
            float r1 = r1 / r0
            goto L4f
        L99:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L41
        L9c:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L41
        L9f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = 0
            r1 = 32
            r0 = 45
            java.lang.String r0 = A03(r2, r1, r0)
            r4.append(r0)
            int r0 = r3.A07
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GD.A06():com.facebook.ads.redexgen.X.a7");
    }

    public final void A07() {
        int length = this.A0K.length();
        if (length > 0) {
            this.A0K.delete(length - 1, length);
        }
    }

    public final void A08() {
        this.A0L.clear();
        this.A0K.clear();
        this.A06 = -1;
        this.A0C = -1;
        this.A04 = -1;
        this.A02 = -1;
        this.A0A = 0;
    }

    public final void A09() {
        A08();
        this.A0G = false;
        this.A0J = false;
        this.A09 = 4;
        this.A0H = false;
        this.A0D = 0;
        this.A05 = 0;
        this.A00 = 0;
        this.A0B = 15;
        this.A0I = true;
        this.A07 = 0;
        this.A0F = 0;
        this.A08 = 0;
        int i = A0O;
        this.A0E = i;
        this.A03 = A0P;
        this.A01 = i;
    }

    public final void A0A(char c2) {
        if (c2 == '\n') {
            this.A0L.add(A02());
            this.A0K.clear();
            if (this.A06 != -1) {
                this.A06 = 0;
            }
            if (this.A0C != -1) {
                this.A0C = 0;
            }
            if (this.A04 != -1) {
                this.A04 = 0;
            }
            if (this.A02 != -1) {
                this.A02 = 0;
            }
            while (true) {
                boolean z = this.A0I;
                if (A0N[3].charAt(24) == '0') {
                    throw new RuntimeException();
                }
                String[] strArr = A0N;
                strArr[7] = "aB8IqMkBKAtMJJQueiQkJXGZRWNVG1wc";
                strArr[5] = "HNBMfcg7Bwld4TPuQ9QkuhinF76Nerqg";
                if ((z && this.A0L.size() >= this.A0B) || this.A0L.size() >= 15) {
                    this.A0L.remove(0);
                } else {
                    return;
                }
            }
        } else {
            this.A0K.append(c2);
        }
    }

    public final void A0B(int i, int i2) {
        if (this.A0A != i) {
            A0A('\n');
        }
        this.A0A = i;
    }

    public final void A0C(int i, int i2, int i3) {
        int i4;
        int i5;
        if (this.A04 != -1 && (i5 = this.A03) != i) {
            this.A0K.setSpan(new ForegroundColorSpan(i5), this.A04, this.A0K.length(), 33);
        }
        if (i != A0P) {
            this.A04 = this.A0K.length();
            this.A03 = i;
        }
        if (this.A02 != -1 && (i4 = this.A01) != i2) {
            this.A0K.setSpan(new BackgroundColorSpan(i4), this.A02, this.A0K.length(), 33);
        }
        if (i2 != A0O) {
            this.A02 = this.A0K.length();
            String[] strArr = A0N;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[6] = "OSAarCZoTwMbWIGA";
            strArr2[4] = "WpQvoscifbPqGooX";
            this.A01 = i2;
        }
    }

    public final void A0D(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
        if (this.A06 != -1) {
            if (!z) {
                this.A0K.setSpan(new StyleSpan(2), this.A06, this.A0K.length(), 33);
                this.A06 = -1;
            }
        } else if (z) {
            this.A06 = this.A0K.length();
        }
        if (this.A0C != -1) {
            if (!z2) {
                this.A0K.setSpan(new UnderlineSpan(), this.A0C, this.A0K.length(), 33);
                this.A0C = -1;
                return;
            }
            return;
        }
        if (!z2) {
            return;
        }
        this.A0C = this.A0K.length();
    }

    public final void A0E(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        this.A0E = i;
        this.A07 = i6;
    }

    public final void A0F(boolean z) {
        this.A0J = z;
    }

    public final void A0G(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.A0G = true;
        this.A0J = z;
        this.A0I = z2;
        this.A09 = i;
        this.A0H = z4;
        this.A0D = i2;
        this.A05 = i3;
        this.A00 = i6;
        if (this.A0B != i4 + 1) {
            this.A0B = i4 + 1;
            while (true) {
                if (z2) {
                    int size = this.A0L.size();
                    String[] strArr = A0N;
                    if (strArr[7].charAt(15) != strArr[5].charAt(15)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0N;
                    strArr2[7] = "EXpWdjiBi1mKPV7ugtu9QNhbKu2j8WKd";
                    strArr2[5] = "slA42LvVtkzyGudujTr9E5uQpxev7D1e";
                    if (size >= this.A0B) {
                        continue;
                    }
                    this.A0L.remove(0);
                }
                if (this.A0L.size() < 15) {
                    break;
                } else {
                    this.A0L.remove(0);
                }
            }
        }
        if (i7 != 0 && this.A0F != i7) {
            this.A0F = i7;
            int windowStyleIdIndex = i7 - 1;
            A0E(A0U[windowStyleIdIndex], A0Q, A0Y[windowStyleIdIndex], 0, A0W[windowStyleIdIndex], A0X[windowStyleIdIndex], A0V[windowStyleIdIndex]);
        }
        if (i8 != 0 && this.A08 != i8) {
            this.A08 = i8;
            int penStyleIdIndex = i8 - 1;
            A0D(0, 1, 1, false, false, A0S[penStyleIdIndex], A0T[penStyleIdIndex]);
            A0C(A0P, A0R[penStyleIdIndex], A0O);
        }
    }

    public final boolean A0H() {
        return this.A0G;
    }

    public final boolean A0I() {
        return !A0H() || (this.A0L.isEmpty() && this.A0K.length() == 0);
    }

    public final boolean A0J() {
        return this.A0J;
    }
}
