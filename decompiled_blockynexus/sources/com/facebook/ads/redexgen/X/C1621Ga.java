package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1621Ga {
    public static byte[] A02;
    public static String[] A03;
    public static final Pattern A04;
    public final IG A00 = new IG();
    public final StringBuilder A01 = new StringBuilder();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[3].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "WbeGi2EdgzwyYonzf4wPzmwNCcWtg9MW";
            strArr[6] = "HcL7UN1N9oazqVf2QAldqbU1hHC9CZ0b";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            byte b2 = bArrCopyOfRange[i4];
            String[] strArr2 = A03;
            if (strArr2[7].length() != strArr2[0].length()) {
                String[] strArr3 = A03;
                strArr3[4] = "JF2Fp1R2vbvas833wDrB0";
                strArr3[5] = "";
                bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 66);
                i4 += 0;
            } else {
                String[] strArr4 = A03;
                strArr4[1] = "nmNaQjGJyPE7mmPpZpQG0xjHlUJrvUW4";
                strArr4[6] = "jsP66PUWr33y4hLthtnL6xZSYxJtrhjf";
                bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 86);
                i4++;
            }
        }
    }

    public static void A07() {
        A02 = new byte[]{-10, -76, -18, -81, -81, -40, -22, -38, -9, 12, -34, -38, -39, -12, -19, -25, -31, -29, -69, -96, -90, -39, -36, -96, -37, -88, -89, -96, -38, -37, ci.k, 12, ci.l, 22, 18, 29, 26, 32, 25, ci.m, -40, ci.l, 26, 23, 26, 29, -72, -59, -62, -70, 53, 65, 62, 65, 68, 33, 42, 41, 47, -24, 33, 28, 40, 36, 39, 52, -36, -27, -28, -22, -93, -23, -22, -17, -30, -37, -31, -22, -23, -17, -88, -14, -32, -28, -30, -29, -17, -15, -4, -23, -12, -15, -21, -5, -20, -1, -5, -76, -21, -20, -22, -10, -7, -24, -5, -16, -10, -11, 58, 51, 41, 42, 55, 49, 46, 51, 42, -34, -17};
    }

    public static void A08() {
        A03 = new String[]{"5moU6oTWlMaw1sDVAQ0KQ9vMfu", "p49r3ReMaXkyq3mZFz3vXo8SK9LaCwKA", "zB3eTtV", "qmKjW68jdxdUPQHo", "qXdLPSjDEI4OIDX4GQuIV", "", "iFy7tRn7HMov4f4CYUKnyhY2lj6xewaE", "7WU313Gqg3541KnskWJgurkNM7"};
    }

    static {
        A08();
        A07();
        A04 = Pattern.compile(A01(11, 19, 40));
    }

    public static char A00(IG ig, int i) {
        return (char) ig.A00[i];
    }

    public static String A02(IG ig) {
        int limit = ig.A07();
        int iA08 = ig.A08();
        int position = 0;
        while (limit < iA08 && position == 0) {
            int i = limit + 1;
            int position2 = ig.A00[limit];
            int limit2 = (char) position2;
            position = limit2 == 41 ? 1 : 0;
            limit = i;
        }
        return ig.A0T((limit - 1) - ig.A07()).trim();
    }

    public static String A03(IG ig, StringBuilder sb) {
        sb.setLength(0);
        int iA07 = ig.A07();
        int iA08 = ig.A08();
        boolean z = false;
        while (iA07 < iA08 && !z) {
            char c2 = (char) ig.A00[iA07];
            if ((c2 >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || ((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                iA07++;
                sb.append(c2);
            } else {
                z = true;
            }
        }
        ig.A0a(iA07 - ig.A07());
        return sb.toString();
    }

    public static String A04(IG ig, StringBuilder sb) {
        A0B(ig);
        if (ig.A05() == 0) {
            return null;
        }
        String strA03 = A03(ig, sb);
        String strA01 = A01(0, 0, 21);
        if (!strA01.equals(strA03)) {
            return strA03;
        }
        return strA01 + ((char) ig.A0F());
    }

    public static String A05(IG ig, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iA07 = ig.A07();
            String strA04 = A04(ig, sb);
            if (strA04 == null) {
                return null;
            }
            if (A01(118, 1, 28).equals(strA04) || A01(8, 1, 102).equals(strA04)) {
                ig.A0Z(iA07);
                z = true;
            } else {
                sb2.append(strA04);
            }
        }
        String string = sb2.toString();
        String[] strArr = A03;
        if (strArr[7].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "Zajsfk5";
        strArr2[2] = "Zajsfk5";
        return string;
    }

    public static String A06(IG ig, StringBuilder sb) {
        A0B(ig);
        if (ig.A05() < 5) {
            return null;
        }
        if (!A01(3, 5, 31).equals(ig.A0T(5))) {
            return null;
        }
        int iA07 = ig.A07();
        String strA04 = A04(ig, sb);
        if (strA04 == null) {
            return null;
        }
        String token = A01(117, 1, 13);
        if (token.equals(strA04)) {
            ig.A0Z(iA07);
            String token2 = A01(0, 0, 21);
            return token2;
        }
        String strA02 = null;
        String token3 = A01(0, 1, 120);
        if (token3.equals(strA04)) {
            strA02 = A02(ig);
        }
        String strA042 = A04(ig, sb);
        String token4 = A01(1, 1, 53);
        if (!token4.equals(strA042) || strA042 == null) {
            return null;
        }
        return strA02;
    }

    private void A09(C1625Ge c1625Ge, String str) {
        if (A01(0, 0, 21).equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Pattern pattern = A04;
            String[] strArr = A03;
            if (strArr[4].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "I8JZnIR9egwAM0HwkjEQFl8l1n";
            strArr2[0] = "OMVURqNL7mUYh9I5H6Apgp30fA";
            Matcher matcher = pattern.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                c1625Ge.A0L(matcher.group(1));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrA0m = IW.A0m(str, A01(9, 2, 90));
        String str2 = strArrA0m[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            c1625Ge.A0K(str2.substring(0, iIndexOf2));
            int idPrefixIndex = iIndexOf2 + 1;
            c1625Ge.A0J(str2.substring(idPrefixIndex));
        } else {
            c1625Ge.A0K(str2);
        }
        int idPrefixIndex2 = strArrA0m.length;
        if (idPrefixIndex2 > 1) {
            int idPrefixIndex3 = strArrA0m.length;
            c1625Ge.A0M((String[]) Arrays.copyOfRange(strArrA0m, 1, idPrefixIndex3));
        }
    }

    public static void A0A(IG ig) {
        while (!TextUtils.isEmpty(ig.A0Q())) {
        }
    }

    public static void A0B(IG ig) {
        boolean z = true;
        while (ig.A05() > 0 && z) {
            if (!A0E(ig)) {
                boolean zA0D = A0D(ig);
                String[] strArr = A03;
                if (strArr[4].length() == strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[7] = "hJK3qjOtPloIxgY8vJytqI0HGH";
                strArr2[0] = "GkPADoSnbvIPHM1na4c3lEMD25";
                if (!zA0D) {
                    z = false;
                }
            }
            z = true;
        }
    }

    public static void A0C(IG ig, C1625Ge c1625Ge, StringBuilder sb) {
        A0B(ig);
        String token = A03(ig, sb);
        String strA01 = A01(0, 0, 21);
        if (strA01.equals(token)) {
            return;
        }
        if (!A01(2, 1, 94).equals(A04(ig, sb))) {
            return;
        }
        A0B(ig);
        String strA05 = A05(ig, sb);
        if (strA05 == null || strA01.equals(strA05)) {
            return;
        }
        int iA07 = ig.A07();
        String strA04 = A04(ig, sb);
        if (!A01(8, 1, 102).equals(strA04)) {
            if (A01(118, 1, 28).equals(strA04)) {
                ig.A0Z(iA07);
            } else {
                return;
            }
        }
        if (A01(50, 5, 124).equals(token)) {
            c1625Ge.A0D(C1667Hw.A02(strA05));
            return;
        }
        if (A01(30, 16, 85).equals(token)) {
            c1625Ge.A0C(C1667Hw.A02(strA05));
            return;
        }
        if (A01(93, 15, 49).equals(token)) {
            if (!A01(108, 9, 111).equals(strA05)) {
                return;
            }
            c1625Ge.A0H(true);
        } else {
            if (A01(55, 11, 101).equals(token)) {
                c1625Ge.A0E(strA05);
                return;
            }
            if (A01(76, 11, 37).equals(token)) {
                if (!A01(46, 4, 0).equals(strA05)) {
                    return;
                }
                c1625Ge.A0F(true);
            } else {
                if (!A01(66, 10, 32).equals(token) || !A01(87, 6, 50).equals(strA05)) {
                    return;
                }
                c1625Ge.A0G(true);
            }
        }
    }

    public static boolean A0D(IG ig) {
        int limit = ig.A07();
        int iA08 = ig.A08();
        byte[] bArr = ig.A00;
        if (limit + 2 > iA08) {
            return false;
        }
        int i = limit + 1;
        if (bArr[limit] != 47) {
            return false;
        }
        int limit2 = i + 1;
        if (bArr[i] == 42) {
            while (limit2 + 1 < iA08) {
                int i2 = limit2 + 1;
                if (((char) bArr[limit2]) == '*' && ((char) bArr[i2]) == '/') {
                    iA08 = i2 + 1;
                    String[] strArr = A03;
                    if (strArr[4].length() == strArr[5].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A03;
                    strArr2[3] = "JvQuY0ttidF2MFD";
                    strArr2[3] = "JvQuY0ttidF2MFD";
                    limit2 = iA08;
                } else {
                    limit2 = i2;
                }
            }
            ig.A0a(iA08 - ig.A07());
            return true;
        }
        return false;
    }

    public static boolean A0E(IG ig) {
        char cA00 = A00(ig, ig.A07());
        if (cA00 != '\t' && cA00 != '\n' && cA00 != '\f' && cA00 != '\r') {
            String[] strArr = A03;
            if (strArr[1].charAt(8) == strArr[6].charAt(8)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[2] = "XdMJqir";
            strArr2[2] = "XdMJqir";
            if (cA00 != ' ') {
                return false;
            }
        }
        ig.A0a(1);
        String[] strArr3 = A03;
        if (strArr3[1].charAt(8) == strArr3[6].charAt(8)) {
            String[] strArr4 = A03;
            strArr4[3] = "JQij4b";
            strArr4[3] = "JQij4b";
            return true;
        }
        String[] strArr5 = A03;
        strArr5[7] = "YUo1DIFuEN1uIrNP3uzwlzTLm0";
        strArr5[0] = "TeHQYLZm1GheElXx48zfUEG6q3";
        return true;
    }

    public final C1625Ge A0F(IG ig) {
        this.A01.setLength(0);
        int iA07 = ig.A07();
        A0A(ig);
        this.A00.A0c(ig.A00, ig.A07());
        this.A00.A0Z(iA07);
        String strA06 = A06(this.A00, this.A01);
        if (strA06 != null) {
            if (A01(117, 1, 13).equals(A04(this.A00, this.A01))) {
                C1625Ge c1625Ge = new C1625Ge();
                A09(c1625Ge, strA06);
                String strA04 = null;
                boolean z = false;
                while (true) {
                    String strA01 = A01(118, 1, 28);
                    if (!z) {
                        IG ig2 = this.A00;
                        if (A03[2].length() != 7) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[7] = "P2Yqf81YsUpWwfjUTZqElTDCCY";
                        strArr[0] = "xGmVLGcPrtNhIWRwMqh3QWIima";
                        int iA072 = ig2.A07();
                        strA04 = A04(this.A00, this.A01);
                        z = strA04 == null || strA01.equals(strA04);
                        if (!z) {
                            this.A00.A0Z(iA072);
                            A0C(this.A00, c1625Ge, this.A01);
                        }
                    } else {
                        if (strA01.equals(strA04)) {
                            return c1625Ge;
                        }
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
