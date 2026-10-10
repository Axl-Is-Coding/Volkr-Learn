package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IC {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02;
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-4, ci.m, 26, 3, 28, 23, 34, 3, 34, 23, 26, -41, -16, -25, -6, -14, -25, -27, -10, -25, -26, -94, -29, -11, -14, -25, -27, -10, -31, -12, -29, -10, -21, -15, -31, -21, -26, -27, -94, -8, -29, -18, -9, -25, -68, -94, -9, -22, -27, -26, -16, -80, -30, -9, -28, 7, -6, -11, -10, 0, -64, -7, -10, 7, -12};
    }

    public static void A09() {
        A02 = new String[]{"Oi30oJFxUMFG0gOFP1qEoKnGUzBDTsvx", "3WD4gW2GQkEI5AwBfxSAXddooip3O", "Ouz028YKvSlJVOERB46zGmLFjnusBt99", "zuSd86snyfkH6Kt688AXpDWJmpjjYjYh", "jm5obH6VrXyDYReHZwz8l0mhz55kc4yf", "71eZjkBm8iWWJxdGvDt2NXp", "W8ZvrObejWqz7a9mktO8s2uWHHxOtI0w", "Nv5C13AVolnSAeqab8n4y7TwRlreXIzh"};
    }

    static {
        A09();
        A08();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int A02(byte[] bArr, int position) {
        int position2;
        synchronized (A05) {
            int iA03 = 0;
            int scratchEscapeCount = 0;
            while (iA03 < position) {
                iA03 = A03(bArr, iA03, position);
                if (iA03 < position) {
                    if (A01.length <= scratchEscapeCount) {
                        A01 = Arrays.copyOf(A01, A01.length * 2);
                    }
                    A01[scratchEscapeCount] = iA03;
                    iA03 += 3;
                    scratchEscapeCount++;
                }
            }
            position2 = position - scratchEscapeCount;
            String[] strArr = A02;
            if (strArr[0].charAt(3) != strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "ghc1n9RTDSO0Z4i69kgOEipuot9Zj";
            strArr2[1] = "ghc1n9RTDSO0Z4i69kgOEipuot9Zj";
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < scratchEscapeCount; i3++) {
                int unescapedPosition = A01[i3] - i;
                System.arraycopy(bArr, i, bArr, i2, unescapedPosition);
                int i4 = i2 + unescapedPosition;
                int copyLength = i4 + 1;
                bArr[i4] = 0;
                i2 = copyLength + 1;
                bArr[copyLength] = 0;
                i += unescapedPosition + 3;
            }
            int remainingLength = position2 - i2;
            System.arraycopy(bArr, i, bArr, i2, remainingLength);
        }
        return position2;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A04(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IC.A04(byte[], int, int, boolean[]):int");
    }

    public static IA A05(byte[] bArr, int i, int i2) {
        IH ih = new IH(bArr, i, i2);
        ih.A08(8);
        int picParameterSetId = ih.A05();
        int iA05 = ih.A05();
        ih.A07();
        boolean bottomFieldPicOrderInFramePresentFlag = ih.A0B();
        return new IA(picParameterSetId, iA05, bottomFieldPicOrderInFramePresentFlag);
    }

    public static IB A06(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        IH ih = new IH(bArr, i, i2);
        ih.A08(8);
        int iA06 = ih.A06(8);
        ih.A08(16);
        int iA05 = ih.A05();
        int iA052 = 1;
        boolean zA0B = false;
        if (iA06 == 100 || iA06 == 110 || iA06 == 122 || iA06 == 244 || iA06 == 44 || iA06 == 83 || iA06 == 86 || iA06 == 118 || iA06 == 128 || iA06 == 138) {
            iA052 = ih.A05();
            if (iA052 == 3) {
                zA0B = ih.A0B();
            }
            ih.A05();
            ih.A05();
            ih.A07();
            if (ih.A0B()) {
                int i5 = iA052 != 3 ? 8 : 12;
                int i6 = 0;
                while (i6 < i5) {
                    if (ih.A0B()) {
                        A0A(ih, i6 < 6 ? 16 : 64);
                    }
                    i6++;
                }
            }
        }
        int iA053 = ih.A05() + 4;
        int iA054 = ih.A05();
        int iA055 = 0;
        boolean zA0B2 = false;
        if (iA054 == 0) {
            iA055 = ih.A05() + 4;
        } else if (iA054 == 1) {
            zA0B2 = ih.A0B();
            ih.A04();
            ih.A04();
            long jA05 = ih.A05();
            for (int i7 = 0; i7 < jA05; i7++) {
                ih.A05();
            }
        } else {
            if (A02[1].length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[0] = "gg30aCps8xaKqlQpqNwqV8MpUTOLFqGh";
            strArr[2] = "6dq0Mx0u8Kgv53YJdcFQMlotDlRuazjf";
        }
        ih.A05();
        ih.A07();
        int iA056 = ih.A05() + 1;
        int iA057 = ih.A05() + 1;
        boolean zA0B3 = ih.A0B();
        int i8 = (2 - (zA0B3 ? 1 : 0)) * iA057;
        if (!zA0B3) {
            ih.A07();
        }
        ih.A07();
        int i9 = iA056 * 16;
        int i10 = i8 * 16;
        if (ih.A0B()) {
            int iA058 = ih.A05();
            int iA059 = ih.A05();
            int iA0510 = ih.A05();
            int iA0511 = ih.A05();
            if (iA052 == 0) {
                i3 = 1;
                i4 = 2 - (zA0B3 ? 1 : 0);
            } else {
                i3 = iA052 == 3 ? 1 : 2;
                i4 = (2 - (zA0B3 ? 1 : 0)) * (iA052 == 1 ? 2 : 1);
            }
            i9 -= (iA058 + iA059) * i3;
            i10 -= (iA0510 + iA0511) * i4;
        }
        float f2 = 1.0f;
        boolean zA0B4 = ih.A0B();
        String[] strArr2 = A02;
        if (strArr2[0].charAt(3) == strArr2[2].charAt(3)) {
            String[] strArr3 = A02;
            strArr3[6] = "jcRzMhbBY3Dw1JTLjGKCGc6YaVOjENSo";
            strArr3[3] = "o4pmI9swvtrYdLR0BRHjmVJPNciV1YNp";
            if (zA0B4) {
                boolean zA0B5 = ih.A0B();
                String[] strArr4 = A02;
                if (strArr4[0].charAt(3) == strArr4[2].charAt(3)) {
                    String[] strArr5 = A02;
                    strArr5[0] = "nxo01JuHYgIdSih3CNMvKr0vsuD4ByKM";
                    strArr5[2] = "Ktm0TZ4NHFdoOw88agihQWJn0ILc0Ki9";
                    if (zA0B5) {
                        int iA062 = ih.A06(8);
                        if (iA062 == 255) {
                            int iA063 = ih.A06(16);
                            int iA064 = ih.A06(16);
                            if (iA063 != 0 && iA064 != 0) {
                                f2 = iA063 / iA064;
                            }
                        } else {
                            float[] fArr = A04;
                            if (iA062 < fArr.length) {
                                f2 = fArr[iA062];
                            } else {
                                Log.w(A07(0, 11, 97), A07(11, 35, 53) + iA062);
                            }
                        }
                    }
                }
            }
            return new IB(iA05, i9, i10, f2, zA0B, zA0B3, iA053, iA054, iA055, zA0B2);
        }
        throw new RuntimeException();
    }

    public static void A0A(IH ih, int nextScale) {
        int i = 8;
        int deltaScale = 8;
        for (int i2 = 0; i2 < nextScale; i2++) {
            if (deltaScale != 0) {
                int deltaScale2 = ih.A04();
                deltaScale = ((deltaScale2 + i) + 256) % 256;
            }
            if (deltaScale != 0) {
                i = deltaScale;
            }
        }
    }

    public static void A0B(ByteBuffer byteBuffer) {
        int consecutiveZeros = byteBuffer.position();
        int offset = 0;
        for (int value = 0; value + 1 < consecutiveZeros; value++) {
            int i = byteBuffer.get(value) & 255;
            if (offset == 3) {
                if (i == 1 && (byteBuffer.get(value + 1) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(value - 3);
                    byteBufferDuplicate.limit(consecutiveZeros);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i == 0) {
                offset++;
            }
            if (i != 0) {
                offset = 0;
            }
        }
        byteBuffer.clear();
        if (A02[1].length() != 29) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "LhexrLoV7v0KAfJEyFTOZZKZaNSS1gs0";
        strArr[4] = "gpIVcqUVkpQz0S61taD9WNDesiV6owqm";
    }

    public static void A0C(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0D(String str, byte b2) {
        if (A07(46, 9, 52).equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return A07(55, 10, 68).equals(str) && ((b2 & 126) >> 1) == 39;
    }
}
