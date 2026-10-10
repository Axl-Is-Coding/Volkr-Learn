package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class DY {
    public static byte[] A07;
    public static String[] A08;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities A00;

    @Nullable
    public final String A01;
    public final String A02;
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;

    static {
        A05();
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = bArrCopyOfRange[i4];
            if (A08[1].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "Hp23aXlVeAE4";
            strArr[6] = "LOeA2GQTCHg8";
            bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{-49, 35, 30, -49, -42, -54, -108, -120, -61, -23, 27, 27, 29, 21, ci.k, 12, -11, 9, 32, -21, ci.n, 9, 22, 22, ci.k, 20, -23, 12, 18, 29, 27, 28, 21, ci.k, 22, 28, -30, -56, -55, -5, -5, -3, -11, -19, -20, -37, -3, -8, -8, -9, -6, -4, -88, -29, -41, -17, -18, -13, -21, -51, -7, -18, -17, -19, -45, -8, -16, -7, 1, 34, 6, 40, 35, 35, 34, 37, 39, -45, ci.l, -52, 29, -32, 27, 18, 21, 18, 33, 37, 26, 39, 22, -34, 33, 29, 18, 42, 19, 18, 20, 28, 22, 33, 30, 28, 35, -29, 24, 22, 37, 40, 1, 12, 9, 7, ci.l, -50, 22, -29, 1, ci.n, 19, -45, -25, -42, -37, -31, -95, -91, -39, -30, -30, -36, -16, -33, -28, -22, -86, -36, -34, -82, -10, 10, -7, -2, 4, -60, -10, 2, 7, -62, 12, -9, -22, -2, -19, -14, -8, -72, -18, -22, -20, -68, -31, -11, -28, -23, -17, -81, -26, -20, -31, -29, 38, 58, 41, 46, 52, -12, 44, -4, -10, -10, -14, 38, 49, 38, 60, -63, -43, -60, -55, -49, -113, -57, -105, -111, -111, -115, -51, -52, -63, -41, -20, 0, -17, -12, -6, -70, -14, -2, -8, 52, 72, 55, 60, 66, 2, 64, 67, 7, 52, 0, Utf8.REPLACEMENT_BYTE, 52, 71, 64, -44, -24, -41, -36, -30, -94, -32, -29, -40, -38, 43, Utf8.REPLACEMENT_BYTE, 46, 51, 57, -7, 57, 58, Utf8.REPLACEMENT_BYTE, 61, 51, 71, 54, 59, 65, 1, 68, 51, 73, -56, -36, -53, -48, -42, -106, -35, -42, -39, -55, -48, -38, -17, -12, -19, -6, -6, -15, -8, -49, -5, 1, -6, 0, -70, -19, -49, -19, -4, -1, -31, -26, -33, -20, -20, -29, -22, -63, -19, -13, -20, -14, -84, -31, -33, -18, -15, -55, -50, -57, -44, -44, -53, -46, -87, -43, -37, -44, -38, -108, -39, -37, -42, -42, -43, -40, -38, -110, -122, -45, -33, -44, -43, -45, -98, -35, -39, -35, -43, -112, 37, 49, 38, 39, 37, -16, 50, 52, 49, 40, 43, 46, 39, ci.l, 39, 56, 39, 46, -18, -30, 9, -9, 3, 6, 2, -5, -24, -9, 10, -5, -60, -9, -39, -9, 6, 9, 52, 34, 46, 49, 45, 38, 19, 34, 53, 38, -17, 36, 34, 49, 52, 11, -7, 5, 8, 4, -3, -22, -7, 12, -3, -58, 11, ci.k, 8, 8, 7, 10, 12, -60, -72, -42, -56, -58, -40, -43, -56, -112, -45, -49, -60, -36, -59, -60, -58, -50, 11, 1, 18, -3, -39, 6, -4, -22, -7, 12, -3, -58, -5, -7, 8, 11, -27, -37, -20, -41, -77, -32, -42, -60, -45, -26, -41, -96, -28, -31, -26, -45, -26, -41, -42, -98, -110, 61, 51, 68, 47, 11, 56, 46, 28, 43, 62, 47, -8, 61, Utf8.REPLACEMENT_BYTE, 58, 58, 57, 60, 62, -10, -22, 22, 12, 29, 8, -28, 17, 7, -11, 4, 23, 8, -47, 25, -26, 4, 19, 22, -44, -43, -50, -50, -59, -52, -59, -60, -115, -48, -52, -63, -39, -62, -63, -61, -53, -4};
    }

    public static void A05() {
        A08 = new String[]{"vBrv5NG59nS", "zkCPCHJFlDmcDIFZ", "dSCDMUmM7uXd", "gDMHkGze", "mPaDa0Yi", "mT3TArY2J5dLaa68x6KdY3", "l0NFbTIehup8", "m9spyvhxT2tneJJM7WnirVc4bphjINlc"};
    }

    public DY(String str, @Nullable String str2, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        this.A02 = (String) C1662Hr.A01(str);
        this.A01 = str2;
        this.A00 = codecCapabilities;
        this.A04 = z;
        boolean z4 = true;
        this.A03 = (z2 || codecCapabilities == null || !A08(codecCapabilities)) ? false : true;
        this.A06 = codecCapabilities != null && A0C(codecCapabilities);
        if (!z3 && (codecCapabilities == null || !A0A(codecCapabilities))) {
            z4 = false;
        }
        this.A05 = z4;
    }

    public static int A00(String str, String str2, int i) {
        int i2;
        if (i <= 1) {
            int i3 = IW.A02;
            String[] strArr = A08;
            if (strArr[3].length() == strArr[4].length()) {
                String[] strArr2 = A08;
                strArr2[2] = "gQEbThFjrPzX";
                strArr2[6] = "subEH4wbl0ZW";
                if ((i3 < 26 || i <= 0) && !A03(226, 10, 23).equals(str2) && !A03(121, 10, 22).equals(str2) && !A03(140, 12, 57).equals(str2) && !A03(211, 15, 119).equals(str2) && !A03(255, 12, 11).equals(str2) && !A03(236, 10, 110).equals(str2) && !A03(246, 9, 118).equals(str2)) {
                    String strA03 = A03(162, 10, 36);
                    String[] strArr3 = A08;
                    if (strArr3[0].length() != strArr3[5].length()) {
                        String[] strArr4 = A08;
                        strArr4[0] = "Y36qN525yNR";
                        strArr4[5] = "7bCUBG0iCXn5hjLUP8xpgf";
                        if (!strA03.equals(str2) && !A03(172, 15, 105).equals(str2) && !A03(187, 15, 4).equals(str2) && !A03(202, 9, 47).equals(str2)) {
                            if (A03(131, 9, 31).equals(str2)) {
                                i2 = 6;
                            } else if (A03(152, 10, 45).equals(str2)) {
                                i2 = 16;
                            } else {
                                i2 = 30;
                            }
                            Log.w(A03(54, 14, 46), A03(9, 29, 76) + str + A03(6, 3, 12) + i + A03(0, 4, 83) + i2 + A03(79, 1, 19));
                            return i2;
                        }
                    }
                }
                return i;
            }
            throw new RuntimeException();
        }
        return i;
    }

    public static DY A01(String str) {
        return new DY(str, null, null, true, false, false);
    }

    public static DY A02(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new DY(str, str2, codecCapabilities, false, z, z2);
    }

    private void A06(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(A03(38, 16, 44));
        sb.append(str);
        String strA03 = A03(80, 3, 100);
        sb.append(strA03);
        sb.append(this.A02);
        sb.append(A03(4, 2, 78));
        sb.append(this.A01);
        sb.append(strA03);
        sb.append(IW.A04);
        sb.append(A03(79, 1, 19));
        sb.toString();
    }

    private void A07(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(A03(68, 11, 87));
        sb.append(str);
        String strA03 = A03(80, 3, 100);
        sb.append(strA03);
        sb.append(this.A02);
        sb.append(A03(4, 2, 78));
        sb.append(this.A01);
        sb.append(strA03);
        sb.append(IW.A04);
        sb.append(A03(79, 1, 19));
        sb.toString();
    }

    public static boolean A08(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (IW.A02 >= 19) {
            boolean zA09 = A09(codecCapabilities);
            if (A08[7].charAt(21) == 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "8GEBbxYcZYS6";
            strArr[6] = "94exv35S6dP4";
            if (zA09) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(83, 17, 85));
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IW.A02 >= 21 && A0B(codecCapabilities);
    }

    @TargetApi(21)
    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(406, 15, 7));
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IW.A02 >= 21 && A0D(codecCapabilities);
    }

    @TargetApi(21)
    public static boolean A0D(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(496, 17, 4));
    }

    @TargetApi(21)
    public static boolean A0E(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 != -1.0d) {
            String[] strArr = A08;
            if (strArr[2].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "A2GQS1dflTwb";
            strArr2[6] = "0Zskb1WNhmLv";
            if (d2 > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
            }
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }

    @TargetApi(21)
    public final Point A0F(int widthAlignment, int heightAlignment) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            String strA03 = A03(100, 10, 89);
            String[] strArr = A08;
            if (strArr[3].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "Xxto7V1TqW7";
            strArr2[5] = "LHJkWoRn06pgJp8wJy9kTn";
            A07(strA03);
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            A07(A03(110, 11, 68));
            return null;
        }
        int widthAlignment2 = videoCapabilities.getWidthAlignment();
        int heightAlignment2 = videoCapabilities.getHeightAlignment();
        return new Point(IW.A04(widthAlignment, widthAlignment2) * widthAlignment2, IW.A04(heightAlignment, heightAlignment2) * heightAlignment2);
    }

    @TargetApi(21)
    public final boolean A0G(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A07(A03(285, 17, 34));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (A08[1].length() == 9) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[1] = "HvB";
        strArr[1] = "HvB";
        if (audioCapabilities == null) {
            A07(A03(267, 18, 48));
            return false;
        }
        int maxInputChannelCount = A00(this.A02, this.A01, audioCapabilities.getMaxInputChannelCount());
        if (maxInputChannelCount < i) {
            A07(A03(302, 22, 10) + i);
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public final boolean A0H(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A07(A03(371, 15, 101));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            A07(A03(355, 16, 58));
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            A07(A03(386, 20, 60) + i);
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public final boolean A0I(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A07(A03(421, 16, 60));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        String[] strArr = A08;
        if (strArr[2].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[1] = "lTAqBYuEDZ5pJgHk8tv0g8UZJ2SLdw";
        strArr2[1] = "lTAqBYuEDZ5pJgHk8tv0g8UZJ2SLdw";
        if (videoCapabilities == null) {
            A07(A03(479, 17, 71));
            return false;
        }
        if (!A0E(videoCapabilities, i, i2, d2)) {
            String strA03 = A03(513, 1, 40);
            if (i >= i2 || !A0E(videoCapabilities, i2, i, d2)) {
                A07(A03(458, 21, 110) + i + strA03 + i2 + strA03 + d2);
                return false;
            }
            A06(A03(437, 21, 22) + i + strA03 + i2 + strA03 + d2);
            return true;
        }
        return true;
    }

    public final boolean A0J(String codecMimeType) {
        String strA05;
        if (codecMimeType == null || this.A01 == null || (strA05 = I9.A05(codecMimeType)) == null) {
            return true;
        }
        boolean zEquals = this.A01.equals(strA05);
        String strA03 = A03(4, 2, 78);
        if (!zEquals) {
            A07(A03(324, 11, 20) + codecMimeType + strA03 + strA05);
            return false;
        }
        Pair<Integer, Integer> pairA02 = C1558Dj.A02(codecMimeType);
        if (pairA02 == null) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA0K = A0K();
        if (A08[7].charAt(21) == 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "mp3Z5Kb6";
        strArr[4] = "MqXhbdhM";
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrA0K) {
            if (codecProfileLevel.profile == ((Integer) pairA02.first).intValue() && codecProfileLevel.level >= ((Integer) pairA02.second).intValue()) {
                return true;
            }
        }
        A07(A03(335, 20, 102) + codecMimeType + strA03 + strA05);
        return false;
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0K() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.A00.profileLevels;
    }
}
