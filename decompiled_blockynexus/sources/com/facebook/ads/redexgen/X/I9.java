package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class I9 {
    public static byte[] A00;
    public static String[] A01;
    public static final ArrayList<I8> A02;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
            String[] strArr = A01;
            if (strArr[0].charAt(29) == strArr[5].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "6kBQdFqqCH2elqWgy3DcQfzShaIb6UIi";
            strArr2[1] = "zTGMXzpPBZsgXyab5gRaVPvK6angpM9I";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{ci.l, 41, 49, 38, 43, 46, 35, 103, 42, 46, 42, 34, 103, 51, 62, 55, 34, 125, 103, 8, 10, 68, 90, 31, ci.l, ci.l, 18, 23, 29, 31, 10, 23, 17, ci.n, 81, 29, 27, 31, 83, 72, 78, 70, 96, 113, 113, 109, 104, 98, 96, 117, 104, 110, 111, 46, 98, 100, 96, 44, 54, 49, 57, 76, 93, 93, 65, 68, 78, 76, 89, 68, 66, 67, 2, 73, 91, 79, 94, 88, 79, 94, 89, 72, 72, 84, 81, 91, 89, 76, 81, 87, 86, 23, 81, 92, 11, 116, 101, 101, 121, 124, 118, 116, 97, 124, 122, 123, 58, 101, 114, 102, 100, 117, 117, 105, 108, 102, 100, 113, 108, 106, 107, 42, 113, 113, 104, 105, 46, 125, 104, 105, 73, 88, 88, 68, 65, 75, 73, 92, 65, 71, 70, 7, 94, 71, 74, 91, 93, 74, 100, 117, 117, 105, 108, 102, 100, 113, 108, 106, 107, 42, 125, 40, 102, 100, 104, 96, 119, 100, 40, 104, 106, 113, 108, 106, 107, 17, 0, 0, 28, 25, 19, 17, 4, 25, 31, 30, 95, 8, 93, 21, 29, 3, 23, 39, 54, 54, 42, 47, 37, 39, 50, 47, 41, 40, 105, 62, 107, 43, 54, 114, 107, 37, 35, 39, 107, 112, 118, 126, 32, 49, 49, 45, 40, 34, 32, 53, 40, 46, 47, 110, 57, 108, 44, 49, 117, 108, 55, 53, 53, 79, 94, 94, 66, 71, 77, 79, 90, 71, 65, 64, 1, 86, 3, 95, 91, 71, 77, 69, 90, 71, 67, 75, 3, 90, 86, 29, 73, 70, 87, 87, 75, 78, 68, 70, 83, 78, 72, 73, 8, 95, 10, 85, 70, 80, 68, 68, 41, 56, 56, 36, 33, 43, 41, 60, 33, 39, 38, 103, 48, 101, 59, 43, 60, 45, 123, 125, 5, 20, 20, 8, ci.k, 7, 5, ci.n, ci.k, 11, 10, 75, 28, 73, 23, 17, 6, 22, ci.k, 20, 109, 121, 104, 101, 99, ci.m, 27, 10, 7, 1, 65, ci.m, ci.k, 93, 34, 54, 39, 42, 44, 108, 38, 34, 32, 112, 79, 91, 74, 71, 65, 1, 75, 79, 77, 29, 3, 68, 65, 77, 54, 34, 51, 62, 56, 120, 58, 39, 99, 54, 122, 59, 54, 35, 58, 52, 32, 49, 60, 58, 122, 56, 37, 48, 50, 125, 105, 120, 117, 115, 51, 115, 108, 105, 111, 93, 73, 88, 85, 83, 19, 72, 78, 73, 89, 17, 84, 88, 116, 96, 113, 124, 122, 58, 99, 123, 113, 59, 113, 97, 102, 106, 126, 111, 98, 100, 36, 125, 101, 111, 37, 111, 127, 120, 37, 99, 111, 58, 46, Utf8.REPLACEMENT_BYTE, 50, 52, 116, 45, 52, 41, 57, 50, 40, 116, 99, 118, 36, 31, 8, 29, 77, 127, 122, 120, 40, 100, 101, 99, 51, 72, 88, 95, 79, 95, 79, 72, 94, 35, 51, 52, 47, 113, 97, 102, 121, 110, 104, 32, 56, 113, 119, 57, 39, 109, 96, 115, 52, 48, 46, 59, 105, 35, 62, 122, 47, 29, 0, 68, 17, 94, 5, 26, 31, 25, 110, 127, 98, 110, 73, 86, 91, 90, 80, 102, 121, 116, 117, 127, Utf8.REPLACEMENT_BYTE, 113, 102, 115, 94, 65, 76, 77, 71, 7, 64, 77, 94, 75, 58, 37, 40, 41, 35, 99, 33, 60, 120, 58, 97, 41, Utf8.REPLACEMENT_BYTE, 117, 106, 103, 102, 108, 44, 110, 115, 102, 100, 124, 99, 110, 111, 101, 37, 103, 122, 111, 109, 56, 94, 65, 76, 77, 71, 7, 95, 94, 75, 25, 74, 85, 88, 89, 83, 19, 68, 17, 74, 82, 88, 18, 83, 82, ci.l, 18, 74, 76, 4, 119, 104, 101, 100, 110, 46, 121, 44, 119, 111, 101, 47, 110, 111, 51, 47, 119, 113, 56, 57, 32, 61, 45, 38, 60, 74, 76, 12, 4, 95, 89, 25, ci.n, 24, 30, 86, 97, 103, 46};
    }

    public static void A09() {
        A01 = new String[]{"lBCeuhX9hNfcmu4hXiaB0UIfsko1beot", "ra13xGj8RSB6BkwatJnpBptPaaCfoBcx", "P21", "Bri2Verx5lE2lvMoTNthHk7hdJI5vErz", "EDlB2oyjjzMvSj7LU0PhrIFki3Wbmzj0", "c0tnGg1pU0xQOSl8MzV3k5KzHYaf6B4M", "ToIyleuLgVqT12ZHnDYontQlJBt8XJPF", "oHW1wN4pMWLo5Y0khnI8b0OqqaKma6BZ"};
    }

    static {
        A09();
        A08();
        A02 = new ArrayList<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I9.A00(java.lang.String):int");
    }

    public static int A01(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (A0A(str)) {
            return 1;
        }
        if (A0C(str)) {
            if (A01[2].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "Tbf";
            strArr[2] = "Tbf";
            return 2;
        }
        if (A0B(str) || A04(23, 19, 49).equals(str) || A04(42, 19, 78).equals(str) || A04(193, 25, 9).equals(str) || A04(306, 20, 43).equals(str) || A04(110, 20, 74).equals(str) || A04(239, 28, 97).equals(str) || A04(218, 21, 14).equals(str) || A04(267, 19, 104).equals(str) || A04(130, 18, 103).equals(str) || A04(95, 15, 90).equals(str) || A04(61, 19, 98).equals(str)) {
            return 3;
        }
        if (A04(80, 15, 119).equals(str) || A04(175, 18, 63).equals(str) || A04(286, 20, 7).equals(str) || A04(148, 27, 74).equals(str)) {
            return 4;
        }
        return A02(str);
    }

    public static int A02(String str) {
        int size = A02.size();
        for (int i = 0; i < size; i++) {
            I8 i8 = A02.get(i);
            if (str.equals(i8.A02)) {
                int i2 = i8.A00;
                if (A01[3].charAt(8) != '5') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[7] = "YSWVz5r88Frt8fEbwFjXVMBNOaem5rQH";
                strArr[1] = "pHXVZv2iqxHVHPkGMSFE5ZZmXa81zybh";
                return i2;
            }
        }
        return -1;
    }

    @Nullable
    public static String A03(int i) {
        if (i == 32) {
            return A04(542, 13, 3);
        }
        if (i == 33) {
            return A04(523, 9, 95);
        }
        String[] strArr = A01;
        if (strArr[7].charAt(25) != strArr[1].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "xwToz2hGyzeZlJau4s70LCfyGGvyNjlM";
        strArr2[4] = "z90Y73QdABRO9FFteloeaI1S2h3IuM4k";
        if (i == 35) {
            String[] strArr3 = A01;
            if (strArr3[7].charAt(25) != strArr3[1].charAt(25)) {
                return A04(532, 10, 103);
            }
            String[] strArr4 = A01;
            strArr4[6] = "P8Y4RDrDcLRp9FcHeOWRUzIMEfiRWdjY";
            strArr4[4] = "CxyRoddQ3h3V8143CrsBrhzN8eEi9nxs";
            return A04(532, 10, 103);
        }
        if (i != 64) {
            if (i == 163) {
                String[] strArr5 = A01;
                if (strArr5[7].charAt(25) != strArr5[1].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr6 = A01;
                strArr6[0] = "pE8eczaUY1qYPJUnjn6leqRwAOZhXoVo";
                strArr6[5] = "UHIpG1ZmHJnhYYsnmXPa5Mhqnk81Hhhu";
                return A04(576, 10, 103);
            }
            if (i == 177) {
                return A04(605, 19, 78);
            }
            if (i == 165) {
                return A04(331, 9, 33);
            }
            if (i != 166) {
                switch (i) {
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                        return A04(565, 11, 69);
                    case 102:
                    case 103:
                    case 104:
                        break;
                    case 105:
                    case 107:
                        if (A01[3].charAt(8) != '5') {
                            return A04(379, 10, 26);
                        }
                        String[] strArr7 = A01;
                        strArr7[3] = "3bsHpIyd5cpBijoTJ4OMmefdCTR5gTxx";
                        strArr7[3] = "3bsHpIyd5cpBijoTJ4OMmefdCTR5gTxx";
                        return A04(379, 10, 26);
                    case 106:
                        return A04(555, 10, 76);
                    default:
                        switch (i) {
                            case 169:
                            case 172:
                                return A04(412, 13, 90);
                            case 170:
                            case 171:
                                return A04(425, 16, 68);
                            case 173:
                                return A04(389, 10, 83);
                            default:
                                return null;
                        }
                }
            } else {
                return A04(340, 10, 12);
            }
        }
        return A04(364, 15, 24);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01d3  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(@androidx.annotation.Nullable java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I9.A05(java.lang.String):java.lang.String");
    }

    @Nullable
    public static String A06(String str) {
        int size = A02.size();
        for (int i = 0; i < size; i++) {
            I8 i8 = A02.get(i);
            if (str.startsWith(i8.A01)) {
                return i8.A02;
            }
        }
        if (A01[2].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "uqMFW3SzqAJLI4ch9TDXcfdjcmNi1dfZ";
        strArr[4] = "vnqPuSQM6Pv1MUHSLr8O6PKTPzGiY5hV";
        return null;
    }

    @Nullable
    public static String A07(@Nullable String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            return str.substring(0, iIndexOf);
        }
        throw new IllegalArgumentException(A04(0, 19, 8) + str);
    }

    public static boolean A0A(String str) {
        return A04(326, 5, 67).equals(A07(str));
    }

    public static boolean A0B(String str) {
        return A04(514, 4, 85).equals(A07(str));
    }

    public static boolean A0C(String str) {
        return A04(518, 5, 112).equals(A07(str));
    }
}
