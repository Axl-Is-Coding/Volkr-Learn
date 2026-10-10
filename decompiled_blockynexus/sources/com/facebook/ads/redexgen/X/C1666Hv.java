package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.just.agentweb.WebIndicator;
import com.uc.crashsdk.export.LogType;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1666Hv {
    public static byte[] A00;
    public static String[] A01;
    public static final byte[] A02;
    public static final int[] A03;
    public static final int[] A04;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{5, 62, 35, 37, 32, 32, Utf8.REPLACEMENT_BYTE, 34, 36, 53, 52, 112, 49, 37, 52, 57, Utf8.REPLACEMENT_BYTE, 112, Utf8.REPLACEMENT_BYTE, 50, 58, 53, 51, 36, 112, 36, 41, 32, 53, 106, 112, 116, 79, 82, 84, 81, 81, 78, 83, 85, 68, 69, 1, 68, 81, 98, 78, 79, 71, 72, 70, 27, 1};
    }

    public static void A06() {
        A01 = new String[]{"7xLJJJjcPic97znxr7jYyKVhMaeA1j2E", "qlBokwmGez00tGn8Zoa7EPfSBX4wK2nd", "lNuywCj9LEYUa8avgu1fHofmnBtqXXwP", "QFj1OU4oR8zs4ROIl6ex9DnIWth", "MldRCxmPSCf85WqtCY5KHjt0bBRgqPbR", "RjpHJdGRFnKrV", "xTxTizoIhxSZQJal7HagUNUTtmhMrgov", "oiVBLQsg82rzAXMmQswhUJYEb9MEhzaa"};
    }

    static {
        A06();
        A05();
        A02 = new byte[]{0, 0, 0, 1};
        A04 = new int[]{96000, 88200, 64000, 48000, 44100, LogType.UNEXP_KNOWN_REASON, 24000, 22050, 16000, 12000, 11025, WebIndicator.MAX_UNIFORM_SPEED_DURATION, 7350};
        A03 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static int A00(IF r2) {
        int iA05 = r2.A05(5);
        if (iA05 == 31) {
            return r2.A05(6) + 32;
        }
        return iA05;
    }

    public static int A01(IF r5) {
        int iA05 = r5.A05(4);
        if (iA05 == 15) {
            int samplingFrequency = r5.A05(24);
            return samplingFrequency;
        }
        if (A01[3].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "Rl706moC1hxTN";
        strArr[5] = "Rl706moC1hxTN";
        C1662Hr.A03(iA05 < 13);
        int samplingFrequency2 = A04[iA05];
        return samplingFrequency2;
    }

    public static Pair<Integer, Integer> A02(IF r9, boolean z) throws AD {
        int iA00 = A00(r9);
        int channelConfiguration = A01(r9);
        int iA05 = r9.A05(4);
        if (iA00 == 5 || iA00 == 29) {
            channelConfiguration = A01(r9);
            iA00 = A00(r9);
            if (iA00 == 22) {
                iA05 = r9.A05(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (iA00 != 1 && iA00 != 2 && iA00 != 3 && iA00 != 4 && iA00 != 6 && iA00 != 7 && iA00 != 17) {
                switch (iA00) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new AD(A04(0, 31, 122) + iA00);
                }
            }
            A07(r9, iA00, iA05);
            if (A01[4].charAt(0) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "vV2yfuq3D8MlByvyd0FSsWmE07MYRaiH";
            strArr[7] = "vV2yfuq3D8MlByvyd0FSsWmE07MYRaiH";
            switch (iA00) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int channelCount = r9.A05(2);
                    if (channelCount == 2 || channelCount == 3) {
                        throw new AD(A04(31, 22, 11) + channelCount);
                    }
                    break;
            }
        }
        int i = A03[iA05];
        if (i == -1) {
            z2 = false;
        }
        C1662Hr.A03(z2);
        return Pair.create(Integer.valueOf(channelConfiguration), Integer.valueOf(i));
    }

    public static Pair<Integer, Integer> A03(byte[] bArr) throws AD {
        return A02(new IF(bArr), false);
    }

    public static void A07(IF r5, int i, int i2) {
        r5.A09(1);
        if (r5.A0G()) {
            if (A01[5].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "9ZbgWIK1Tjah9N2o7wCOkUZOiekVuClG";
            strArr[6] = "9ZbgWIK1Tjah9N2o7wCOkUZOiekVuClG";
            r5.A09(14);
        }
        boolean zA0G = r5.A0G();
        if (i2 != 0) {
            if (i == 6 || i == 20) {
                r5.A09(3);
            }
            if (zA0G) {
                if (i == 22) {
                    r5.A09(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    r5.A09(3);
                }
                r5.A09(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[] A08(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] A09(byte[] bArr, int i, int i2) {
        byte[] bArr2 = A02;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, A02.length, i2);
        return bArr3;
    }
}
