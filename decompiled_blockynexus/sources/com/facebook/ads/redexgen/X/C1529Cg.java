package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1529Cg {
    public static byte[] A00;
    public static String[] A01;
    public static final int A02;
    public static final int A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1545Cw A0C(YR yr, YS ys, long j, DrmInitData drmInitData, boolean z, boolean z2) throws AD {
        long j2 = j;
        YR yrA06 = yr.A06(AbstractC1524Cb.A0d);
        int iA02 = A02(yrA06.A07(AbstractC1524Cb.A0V).A00);
        if (iA02 == -1) {
            return null;
        }
        YS ysA07 = yr.A07(AbstractC1524Cb.A1J);
        if (A01[3].charAt(8) != 'p') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "QWUsjPBg";
        strArr[2] = "QWUsjPBg";
        C1528Cf c1528CfA0B = A0B(ysA07.A00);
        if (j2 == -9223372036854775807L) {
            j2 = c1528CfA0B.A02;
        }
        long jA04 = A04(ys.A00);
        long jA0F = j2 == -9223372036854775807L ? -9223372036854775807L : IW.A0F(j2, 1000000L, jA04);
        YR yrA062 = yrA06.A06(AbstractC1524Cb.A0h).A06(AbstractC1524Cb.A16);
        Pair<Long, String> pairA06 = A06(yrA06.A07(AbstractC1524Cb.A0c).A00);
        C1527Ce c1527CeA0A = A0A(yrA062.A07(AbstractC1524Cb.A1A).A00, c1528CfA0B.A00, c1528CfA0B.A01, (String) pairA06.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> pairA05 = A05(yr.A06(AbstractC1524Cb.A0N));
            jArr = (long[]) pairA05.first;
            jArr2 = (long[]) pairA05.second;
        }
        if (c1527CeA0A.A02 == null) {
            return null;
        }
        return new C1545Cw(c1528CfA0B.A00, iA02, ((Long) pairA06.first).longValue(), jA04, jA0F, c1527CeA0A.A02, c1527CeA0A.A01, c1527CeA0A.A03, c1527CeA0A.A00, jArr, jArr2);
    }

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A00 = new byte[]{49, 37, 119, 106, 114, 102, 110, 115, 110, 115, 108, 88, 102, 114, 117, 113, 106, 120, 70, 121, 89, 110, 114, 106, 120, 121, 102, 114, 117, 73, 106, 113, 121, 102, 37, -112, -124, -42, -55, -47, -59, -51, -46, -51, -46, -53, -73, -59, -47, -44, -48, -55, -41, -83, -46, -89, -52, -39, -46, -49, -124, 71, 59, -115, -128, -120, 124, -124, -119, -124, -119, -126, 111, -124, -120, -128, -114, -113, 124, -120, -117, 95, -128, -121, -113, 124, 94, -125, 124, -119, -126, -128, -114, 59, -110, 120, -54, -67, -59, -71, -63, -58, -63, -58, -65, -85, -47, -58, -69, -64, -54, -57, -58, -63, -46, -71, -52, -63, -57, -58, -85, -71, -59, -56, -60, -67, -53, 120, 100, -105, -110, -112, 115, -124, -107, -106, -120, -107, -106, -76, -46, -39, -38, -35, -44, -39, -46, -117, -48, -49, -44, -33, -117, -41, -44, -34, -33, -91, -117, -48, -49, -44, -33, -117, -49, -38, -48, -34, -117, -39, -38, -33, -117, -34, -33, -52, -35, -33, -117, -30, -44, -33, -45, -117, -52, -117, -34, -28, -39, -50, -117, -34, -52, -40, -37, -41, -48, -103, -110, -73, -84, -72, -73, -68, -78, -68, -67, -82, -73, -67, 105, -68, -67, -85, -75, 105, -85, -72, -63, 105, -81, -72, -69, 105, -67, -69, -86, -84, -76, 105, 117, -109, -126, -124, -116, 65, -119, -126, -108, 65, -113, -112, 65, -108, -126, -114, -111, -115, -122, 65, -107, -126, -125, -115, -122, 65, -108, -118, -101, -122, 65, -118, -113, -121, -112, -109, -114, -126, -107, -118, -112, -113, -120, -95, -90, -88, -93, -93, -94, -91, -89, -104, -105, 83, -96, -104, -105, -100, -108, 83, -91, -108, -89, -104, 97, -32, -17, -17, -21, -24, -30, -32, -13, -24, -18, -19, -82, -13, -13, -20, -21, -86, -9, -20, -21, -90, -75, -75, -79, -82, -88, -90, -71, -82, -76, -77, 116, -67, 114, -88, -90, -78, -86, -73, -90, 114, -78, -76, -71, -82, -76, -77, -78, -63, -63, -67, -70, -76, -78, -59, -70, -64, -65, -128, -55, 126, -66, -63, -123, 126, -76, -74, -78, 126, -121, -127, -119, -89, -74, -74, -78, -81, -87, -89, -70, -81, -75, -76, 117, -66, 115, -77, -74, 122, 115, -68, -70, -70, -101, -86, -86, -90, -93, -99, -101, -82, -93, -87, -88, 105, -78, 103, -85, -81, -93, -99, -91, -82, -93, -89, -97, 103, -82, -78, 109, -95, 124, -112, 127, -124, -118, 74, 78, -126, -117, -117, -126, -106, -123, -118, -112, 80, -126, -124, 84, -69, -49, -66, -61, -55, -119, -69, -58, -69, -67, -33, -13, -30, -25, -19, -83, -33, -21, -16, -85, -11, -32, 107, 127, 110, 115, 121, 57, 111, 107, 109, 61, -109, -89, -106, -101, -95, 97, -97, -94, 102, -109, 95, -98, -109, -90, -97, -65, -45, -62, -57, -51, -115, -53, -50, -61, -59, -68, -48, -65, -60, -54, -118, -51, -68, -46, -94, -74, -91, -86, -80, 112, -73, -81, -91, 111, -91, -75, -76, -87, -67, -84, -79, -73, 119, -66, -74, -84, 118, -84, -68, -69, 118, -80, -84, 109, -127, 112, 117, 123, 59, -126, 122, 112, 58, 112, -128, 127, 58, 116, 112, 71, 124, 126, 123, 114, 117, 120, 113, 73, 120, 110, 126, -119, -120, -119, 87, -32, -33, -32, -16, -124, -122, -113, -124, -43, -41, -32, -27, -110, -105, -104, -101, -109, 112, -93, -98, -100, -126, -104, -87, -108, 79, -94, -105, -98, -92, -101, -109, 79, -111, -108, 79, -97, -98, -94, -104, -93, -104, -91, -108, 101, 110, 101, 114, -119, -107, -112, -124, 67, -124, -105, -110, -112, 67, -116, -106, 67, -112, -124, -111, -121, -124, -105, -110, -107, -100, -50, -58, -43, -62, -100, -117, -99, -107, -99, -115, -110, -109, 74, -117, -98, -103, -105, 74, -109, -99, 74, -105, -117, -104, -114, -117, -98, -103, -100, -93, -51, -55, -49, -56, -108, -106, -125, -107, -59, -74, -65, -76, 113, -78, -59, -64, -66, 113, -70, -60, 113, -66, -78, -65, -75, -78, -59, -64, -61, -54, -48, -63, -44, -48, -39, -52, -57, -56, -77, -90, -95, -94, -84, 108, 112, -92, -83, -83, -52, -65, -70, -69, -59, -123, -73, -52, -71, -14, -27, -32, -31, -21, -85, -28, -31, -14, -33, -109, -122, -127, -126, -116, 76, -107, 74, -109, -117, -127, 75, -116, -117, 79, 75, -109, -115, 85, -86, -99, -104, -103, -93, 99, -84, 97, -86, -94, -104, 98, -93, -94, 102, 98, -86, -92, 109};
    }

    public static void A0K() {
        A01 = new String[]{"vNU1Clptty9spXV3rmNWKqfECA0GCDno", "yQl7wYGB6utTXxK398wXXYrAeYZNPLId", "BVcq1q5Q", "NihUY4HxpsM0GkJJgFchlTfxDOIJFYzw", "lx4TwpHGLs68", "XI1Xq2FkjwcQfgB5bw70GFmYpaxAyyjl", "uRZmXRdJsodI", "Cygx2J1H2ENb6XLRYlHXnR1vUW4XHHOP"};
    }

    static {
        A0K();
        A0J();
        A08 = IW.A08(A0I(696, 4, 97));
        A05 = IW.A08(A0I(662, 4, 88));
        A07 = IW.A08(A0I(692, 4, 90));
        A04 = IW.A08(A0I(636, 4, 39));
        A06 = IW.A08(A0I(666, 4, 31));
        A02 = IW.A08(A0I(606, 4, 0));
        A03 = IW.A08(A0I(632, 4, 95));
    }

    public static float A00(IG ig, int i) {
        ig.A0Z(i + 8);
        return ig.A0I() / ig.A0I();
    }

    public static int A01(IG ig) {
        int size = ig.A0F();
        int i = size & 127;
        while ((size & 128) == 128) {
            size = ig.A0F();
            i = (i << 7) | (size & 127);
        }
        return i;
    }

    public static int A02(IG ig) {
        ig.A0Z(16);
        int iA09 = ig.A09();
        if (iA09 == A05) {
            return 1;
        }
        int trackType = A08;
        if (A01[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[0] = "sACqbdB9h4ZaSOP8RBXRhKf5pkODD9Ze";
        strArr[5] = "nfjFHkgcUdXk9ZZxpn0R0spMdbOfBjgH";
        if (iA09 == trackType) {
            return 2;
        }
        if (iA09 != A07 && iA09 != A04 && iA09 != A06 && iA09 != A02) {
            if (iA09 == A03) {
                return 4;
            }
            return -1;
        }
        String[] strArr2 = A01;
        if (strArr2[4].length() != strArr2[6].length()) {
            return 3;
        }
        String[] strArr3 = A01;
        strArr3[0] = "HjSYihfmO4Fjwo0SJsN86rpcIq24412o";
        strArr3[5] = "nDlBCf5sAdyqWE5fn1qZlgrWKnIrwKiA";
        return 3;
    }

    public static int A03(IG ig, int i, int i2) {
        int iA07 = ig.A07();
        while (iA07 - i < i2) {
            ig.A0Z(iA07);
            int iA09 = ig.A09();
            C1662Hr.A05(iA09 > 0, A0I(574, 32, 45));
            if (ig.A09() == AbstractC1524Cb.A0S) {
                return iA07;
            }
            iA07 += iA09;
        }
        return -1;
    }

    public static long A04(IG ig) {
        int fullAtom = 8;
        ig.A0Z(8);
        int version = AbstractC1524Cb.A01(ig.A09());
        if (version != 0) {
            fullAtom = 16;
        }
        ig.A0a(fullAtom);
        return ig.A0N();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<long[], long[]> A05(com.facebook.ads.redexgen.X.YR r9) {
        /*
            if (r9 == 0) goto La
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0O
            com.facebook.ads.redexgen.X.YS r0 = r9.A07(r0)
            if (r0 != 0) goto L10
        La:
            r0 = 0
            android.util.Pair r0 = android.util.Pair.create(r0, r0)
            return r0
        L10:
            com.facebook.ads.redexgen.X.IG r7 = r0.A00
            r0 = 8
            r7.A0Z(r0)
            int r0 = r7.A09()
            int r6 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A01(r0)
            int r5 = r7.A0I()
            long[] r4 = new long[r5]
            long[] r3 = new long[r5]
            r2 = 0
        L28:
            if (r2 >= r5) goto L72
            r8 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1529Cg.A01
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 8
            if (r1 == r0) goto L3e
        L38:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            java.lang.String[] r9 = com.facebook.ads.redexgen.X.C1529Cg.A01
            java.lang.String r1 = "n2Qu2qSRpGNWmL1w1m0Jsgn90j2APzEn"
            r0 = 3
            r9[r0] = r1
            java.lang.String r1 = "n2Qu2qSRpGNWmL1w1m0Jsgn90j2APzEn"
            r0 = 3
            r9[r0] = r1
            if (r6 != r8) goto L6d
            long r0 = r7.A0O()
        L50:
            r4[r2] = r0
            if (r6 != r8) goto L67
            long r0 = r7.A0M()
        L58:
            r3[r2] = r0
            short r0 = r7.A0V()
            if (r0 != r8) goto L8b
            r0 = 2
            r7.A0a(r0)
            int r2 = r2 + 1
            goto L28
        L67:
            int r0 = r7.A09()
            long r0 = (long) r0
            goto L58
        L6d:
            long r0 = r7.A0N()
            goto L50
        L72:
            android.util.Pair r3 = android.util.Pair.create(r4, r3)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1529Cg.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L9b
            goto L38
        L8b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r2 = 272(0x110, float:3.81E-43)
            r1 = 23
            r0 = 49
            java.lang.String r0 = A0I(r2, r1, r0)
            r3.<init>(r0)
            throw r3
        L9b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1529Cg.A01
            java.lang.String r1 = "0OgbcJvER11tVuU6ktzS5zcploLwLpnU"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "Fpvfvil3v0kwqlJSCQAnqVBmdIeuMsHJ"
            r0 = 5
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1529Cg.A05(com.facebook.ads.redexgen.X.YR):android.util.Pair");
    }

    public static Pair<Long, String> A06(IG ig) {
        ig.A0Z(8);
        int iA01 = AbstractC1524Cb.A01(ig.A09());
        int version = iA01 == 0 ? 8 : 16;
        ig.A0a(version);
        long jA0N = ig.A0N();
        int fullAtom = iA01 == 0 ? 4 : 8;
        ig.A0a(fullAtom);
        int iA0J = ig.A0J();
        StringBuilder sb = new StringBuilder();
        sb.append(A0I(0, 0, 122));
        int version2 = iA0J >> 10;
        sb.append((char) ((version2 & 31) + 96));
        int version3 = iA0J >> 5;
        sb.append((char) ((version3 & 31) + 96));
        int version4 = iA0J & 31;
        sb.append((char) (version4 + 96));
        return Pair.create(Long.valueOf(jA0N), sb.toString());
    }

    public static Pair<String, byte[]> A07(IG ig, int i) {
        ig.A0Z(i + 8 + 4);
        ig.A0a(1);
        A01(ig);
        ig.A0a(2);
        int iA0F = ig.A0F();
        int flags = iA0F & 128;
        if (flags != 0) {
            ig.A0a(2);
        }
        int flags2 = iA0F & 64;
        if (flags2 != 0) {
            int flags3 = ig.A0J();
            ig.A0a(flags3);
        }
        int flags4 = iA0F & 32;
        if (flags4 != 0) {
            ig.A0a(2);
        }
        ig.A0a(1);
        A01(ig);
        int iA0F2 = ig.A0F();
        String[] strArr = A01;
        String str = strArr[0];
        String str2 = strArr[5];
        int iCharAt = str.charAt(2);
        int flags5 = str2.charAt(2);
        if (iCharAt == flags5) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "ipSJ7rerSzX8";
        strArr2[6] = "rVXKHnYgOQNY";
        String strA03 = I9.A03(iA0F2);
        String mimeType = A0I(482, 10, 92);
        if (!mimeType.equals(strA03)) {
            String mimeType2 = A0I(501, 13, 63);
            if (!mimeType2.equals(strA03)) {
                String mimeType3 = A0I(514, 16, 70);
                if (!mimeType3.equals(strA03)) {
                    ig.A0a(12);
                    ig.A0a(1);
                    int iA01 = A01(ig);
                    byte[] bArr = new byte[iA01];
                    ig.A0d(bArr, 0, iA01);
                    return Pair.create(strA03, bArr);
                }
            }
        }
        Pair<String, byte[]> pairCreate = Pair.create(strA03, null);
        if (A01[3].charAt(8) != 'p') {
            return pairCreate;
        }
        String[] strArr3 = A01;
        strArr3[1] = "09LVPMUcXpQFix5jag1XMCG3MLP6JHGE";
        strArr3[7] = "l6DCOVwnZaQMuPJJN9SXx5QHr45WFHuE";
        return pairCreate;
    }

    public static Pair<Integer, C1546Cx> A08(IG ig, int schemeInformationBoxPosition, int schemeInformationBoxSize) {
        int i = schemeInformationBoxPosition + 8;
        int i2 = -1;
        int childAtomSize = 0;
        String strA0T = null;
        Integer numValueOf = null;
        while (true) {
            int i3 = i - schemeInformationBoxPosition;
            if (A01[3].charAt(8) != 'p') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "AMwqROlZ";
            strArr[2] = "AMwqROlZ";
            if (i3 < schemeInformationBoxSize) {
                ig.A0Z(i);
                int iA09 = ig.A09();
                int iA092 = ig.A09();
                if (iA092 == AbstractC1524Cb.A0T) {
                    numValueOf = Integer.valueOf(ig.A09());
                } else if (iA092 == AbstractC1524Cb.A0z) {
                    ig.A0a(4);
                    strA0T = ig.A0T(4);
                } else if (iA092 == AbstractC1524Cb.A0y) {
                    i2 = i;
                    childAtomSize = iA09;
                }
                i += iA09;
            } else {
                if (A0I(566, 4, 31).equals(strA0T) || A0I(558, 4, 36).equals(strA0T) || A0I(570, 4, 112).equals(strA0T) || A0I(562, 4, 123).equals(strA0T)) {
                    boolean z = true;
                    C1662Hr.A05(numValueOf != null, A0I(610, 22, 33));
                    C1662Hr.A05(i2 != -1, A0I(640, 22, 40));
                    C1546Cx c1546CxA0D = A0D(ig, i2, childAtomSize, strA0T);
                    if (c1546CxA0D == null) {
                        z = false;
                    }
                    C1662Hr.A05(z, A0I(670, 22, 79));
                    return Pair.create(numValueOf, c1546CxA0D);
                }
                return null;
            }
        }
    }

    public static Pair<Integer, C1546Cx> A09(IG ig, int i, int i2) {
        Pair<Integer, C1546Cx> pairA08;
        int iA07 = ig.A07();
        while (iA07 - i < i2) {
            ig.A0Z(iA07);
            int iA09 = ig.A09();
            C1662Hr.A05(iA09 > 0, A0I(574, 32, 45));
            if (ig.A09() == AbstractC1524Cb.A13 && (pairA08 = A08(ig, iA07, iA09)) != null) {
                return pairA08;
            }
            iA07 += iA09;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1527Ce A0A(com.facebook.ads.redexgen.X.IG r24, int r25, int r26, java.lang.String r27, com.facebook.ads.internal.exoplayer2.drm.DrmInitData r28, boolean r29) throws com.facebook.ads.redexgen.X.AD {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1529Cg.A0A(com.facebook.ads.redexgen.X.IG, int, int, java.lang.String, com.facebook.ads.internal.exoplayer2.drm.DrmInitData, boolean):com.facebook.ads.redexgen.X.Ce");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1528Cf A0B(com.facebook.ads.redexgen.X.IG r11) {
        /*
            r9 = 8
            r11.A0Z(r9)
            int r0 = r11.A09()
            int r8 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A01(r0)
            r7 = 16
            if (r8 != 0) goto Lc0
            r0 = 8
        L13:
            r11.A0a(r0)
            int r5 = r11.A09()
            r6 = 4
            r11.A0a(r6)
            r4 = 1
            int r3 = r11.A07()
            if (r8 != 0) goto L26
            r9 = 4
        L26:
            r2 = 0
        L27:
            if (r2 >= r9) goto L33
            byte[] r1 = r11.A00
            int r0 = r3 + r2
            r1 = r1[r0]
            r0 = -1
            if (r1 == r0) goto Lbc
            r4 = 0
        L33:
            if (r4 == 0) goto La5
            r11.A0a(r9)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L3d:
            r11.A0a(r7)
            int r9 = r11.A09()
            int r8 = r11.A09()
            r11.A0a(r6)
            int r7 = r11.A09()
            int r6 = r11.A09()
            r10 = 65536(0x10000, float:9.1835E-41)
            if (r9 != 0) goto L66
            if (r8 != r10) goto L66
            int r0 = -r10
            if (r7 != r0) goto L66
            if (r6 != 0) goto L66
            r1 = 90
        L60:
            com.facebook.ads.redexgen.X.Cf r0 = new com.facebook.ads.redexgen.X.Cf
            r0.<init>(r5, r3, r1)
            return r0
        L66:
            if (r9 != 0) goto L96
            int r11 = -r10
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1529Cg.A01
            r0 = 4
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L81
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L81:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1529Cg.A01
            java.lang.String r1 = "i5DrkfhddIOc"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "TqiRE9mqRyND"
            r0 = 6
            r2[r0] = r1
            if (r8 != r11) goto L96
            if (r7 != r10) goto L96
            if (r6 != 0) goto L96
            r1 = 270(0x10e, float:3.78E-43)
            goto L60
        L96:
            int r0 = -r10
            if (r9 != r0) goto La3
            if (r8 != 0) goto La3
            if (r7 != 0) goto La3
            int r0 = -r10
            if (r6 != r0) goto La3
            r1 = 180(0xb4, float:2.52E-43)
            goto L60
        La3:
            r1 = 0
            goto L60
        La5:
            if (r8 != 0) goto Lb7
            long r3 = r11.A0N()
        Lab:
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L3d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L3d
        Lb7:
            long r3 = r11.A0O()
            goto Lab
        Lbc:
            int r2 = r2 + 1
            goto L27
        Lc0:
            r0 = 16
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1529Cg.A0B(com.facebook.ads.redexgen.X.IG):com.facebook.ads.redexgen.X.Cf");
    }

    public static C1546Cx A0D(IG ig, int childPosition, int i, String str) {
        int constantIvSize = childPosition + 8;
        while (constantIvSize - childPosition < i) {
            ig.A0Z(constantIvSize);
            int defaultCryptByteBlock = ig.A09();
            if (ig.A09() == AbstractC1524Cb.A1G) {
                int version = AbstractC1524Cb.A01(ig.A09());
                boolean z = true;
                ig.A0a(1);
                int i2 = 0;
                int i3 = 0;
                if (version == 0) {
                    ig.A0a(1);
                } else {
                    int defaultSkipByteBlock = ig.A0F();
                    int patternByte = defaultSkipByteBlock & 240;
                    i2 = patternByte >> 4;
                    i3 = defaultSkipByteBlock & 15;
                }
                int version2 = ig.A0F();
                if (version2 != 1) {
                    z = false;
                }
                int iA0F = ig.A0F();
                byte[] bArr = new byte[16];
                int defaultPerSampleIvSize = bArr.length;
                ig.A0d(bArr, 0, defaultPerSampleIvSize);
                byte[] bArr2 = null;
                if (z && iA0F == 0) {
                    int iA0F2 = ig.A0F();
                    bArr2 = new byte[iA0F2];
                    ig.A0d(bArr2, 0, iA0F2);
                    if (A01[2].length() != 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[2] = "N18HcU44";
                    strArr[2] = "N18HcU44";
                }
                return new C1546Cx(z, str, iA0F, bArr, i2, i3, bArr2);
            }
            constantIvSize += defaultCryptByteBlock;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127 A[PHI: r8 r11 r14
      0x0127: PHI (r8v1 'sampleCount' int) = (r8v0 'sampleCount' int), (r8v28 'sampleCount' int), (r8v28 'sampleCount' int) binds: [B:31:0x00de, B:40:0x0126, B:39:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0127: PHI (r11v2 com.facebook.ads.redexgen.X.IG) = (r11v1 com.facebook.ads.redexgen.X.IG), (r11v9 com.facebook.ads.redexgen.X.IG), (r11v1 com.facebook.ads.redexgen.X.IG) binds: [B:31:0x00de, B:40:0x0126, B:39:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0127: PHI (r14v1 int) = (r14v0 int), (r14v0 int), (r14v8 int) binds: [B:31:0x00de, B:40:0x0126, B:39:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1548Cz A0E(com.facebook.ads.redexgen.X.C1545Cw r42, com.facebook.ads.redexgen.X.YR r43, com.facebook.ads.redexgen.X.CE r44) throws com.facebook.ads.redexgen.X.AD {
        /*
            Method dump skipped, instruction units count: 1468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1529Cg.A0E(com.facebook.ads.redexgen.X.Cw, com.facebook.ads.redexgen.X.YR, com.facebook.ads.redexgen.X.CE):com.facebook.ads.redexgen.X.Cz");
    }

    public static Metadata A0F(YS ys, boolean z) {
        if (z) {
            return null;
        }
        IG ig = ys.A00;
        ig.A0Z(8);
        while (ig.A05() >= 8) {
            int iA07 = ig.A07();
            int iA09 = ig.A09();
            int iA092 = ig.A09();
            int atomType = AbstractC1524Cb.A0g;
            if (iA092 == atomType) {
                ig.A0Z(iA07);
                return A0H(ig, iA07 + iA09);
            }
            int atomType2 = iA09 - 8;
            ig.A0a(atomType2);
        }
        return null;
    }

    public static Metadata A0G(IG ig, int i) {
        ig.A0a(8);
        ArrayList arrayList = new ArrayList();
        while (ig.A07() < i) {
            Metadata.Entry entryA01 = C1537Co.A01(ig);
            if (entryA01 != null) {
                arrayList.add(entryA01);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Metadata A0H(IG ig, int i) {
        ig.A0a(12);
        while (ig.A07() < i) {
            int iA07 = ig.A07();
            int iA09 = ig.A09();
            int iA092 = ig.A09();
            int atomType = AbstractC1524Cb.A0Z;
            if (iA092 == atomType) {
                ig.A0Z(iA07);
                return A0G(ig, iA07 + iA09);
            }
            int atomType2 = iA09 - 8;
            ig.A0a(atomType2);
        }
        return null;
    }

    public static void A0L(IG ig, int i, int i2, int i3, int i4, int width, DrmInitData drmInitData, C1527Ce c1527Ce, int childPosition) throws AD {
        DrmInitData drmInitDataA03 = drmInitData;
        int stereoMode = i;
        ig.A0Z(i2 + 8 + 8);
        ig.A0a(16);
        int iA0J = ig.A0J();
        int iA0J2 = ig.A0J();
        boolean z = false;
        float fA00 = 1.0f;
        ig.A0a(50);
        int iA07 = ig.A07();
        int height = AbstractC1524Cb.A0R;
        if (stereoMode == height) {
            Pair<Integer, C1546Cx> pairA09 = A09(ig, i2, i3);
            if (pairA09 != null) {
                stereoMode = ((Integer) pairA09.first).intValue();
                if (drmInitDataA03 == null) {
                    drmInitDataA03 = null;
                } else {
                    drmInitDataA03 = drmInitDataA03.A03(((C1546Cx) pairA09.second).A02);
                }
                c1527Ce.A03[childPosition] = (C1546Cx) pairA09.second;
            }
            ig.A0Z(iA07);
        }
        List<byte[]> listSingletonList = null;
        String strA0I = null;
        byte[] bArrA0P = null;
        if (A01[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "nt1AbbZdLf7H";
        strArr[6] = "te59XVvfeUPr";
        int i5 = -1;
        while (iA07 - i2 < i3) {
            ig.A0Z(iA07);
            int iA072 = ig.A07();
            int iA09 = ig.A09();
            if (iA09 == 0 && ig.A07() - i2 == i3) {
                break;
            }
            C1662Hr.A05(iA09 > 0, A0I(574, 32, 45));
            int iA092 = ig.A09();
            if (iA092 == AbstractC1524Cb.A08) {
                C1662Hr.A04(strA0I == null);
                strA0I = A0I(710, 9, 84);
                ig.A0Z(iA072 + 8);
                IY iyA00 = IY.A00(ig);
                listSingletonList = iyA00.A04;
                c1527Ce.A00 = iyA00.A02;
                if (!z) {
                    fA00 = iyA00.A00;
                }
            } else if (iA092 == AbstractC1524Cb.A0Y) {
                C1662Hr.A04(strA0I == null);
                strA0I = A0I(719, 10, 122);
                ig.A0Z(iA072 + 8);
                C1673Ie c1673IeA00 = C1673Ie.A00(ig);
                listSingletonList = c1673IeA00.A01;
                c1527Ce.A00 = c1673IeA00.A00;
            } else if (iA092 == AbstractC1524Cb.A1U) {
                C1662Hr.A04(strA0I == null);
                strA0I = stereoMode == AbstractC1524Cb.A1S ? A0I(729, 19, 27) : A0I(748, 19, 50);
            } else if (iA092 == AbstractC1524Cb.A0D) {
                C1662Hr.A04(strA0I == null);
                if (A01[3].charAt(8) != 'p') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[4] = "qKPn33WXRD1J";
                strArr2[6] = "UtAkzKHIBavs";
                strA0I = A0I(700, 10, 59);
            } else if (iA092 == AbstractC1524Cb.A0S) {
                C1662Hr.A04(strA0I == null);
                Pair<String, byte[]> pairA07 = A07(ig, iA072);
                strA0I = (String) pairA07.first;
                listSingletonList = Collections.singletonList(pairA07.second);
            } else if (iA092 == AbstractC1524Cb.A0p) {
                fA00 = A00(ig, iA072);
                z = true;
            } else if (iA092 == AbstractC1524Cb.A1F) {
                bArrA0P = A0P(ig, iA072, iA09);
            } else if (iA092 == AbstractC1524Cb.A15) {
                int iA0F = ig.A0F();
                ig.A0a(3);
                if (iA0F == 0) {
                    int iA0F2 = ig.A0F();
                    if (iA0F2 == 0) {
                        i5 = 0;
                    } else if (iA0F2 == 1) {
                        i5 = 1;
                    } else if (iA0F2 != 2) {
                        if (iA0F2 == 3) {
                            i5 = 3;
                        }
                    } else {
                        i5 = 2;
                    }
                }
            }
            iA07 += iA09;
        }
        if (strA0I == null) {
            return;
        }
        c1527Ce.A02 = Format.A04(Integer.toString(i4), strA0I, null, -1, -1, iA0J, iA0J2, -1.0f, listSingletonList, width, fA00, bArrA0P, i5, null, drmInitDataA03);
    }

    public static void A0M(IG ig, int i, int i2, int i3, int i4, String str, C1527Ce c1527Ce) throws AD {
        String strA0I;
        ig.A0Z(i2 + 8 + 8);
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i == AbstractC1524Cb.A02) {
            strA0I = A0I(295, 20, 125);
        } else if (i == AbstractC1524Cb.A1O) {
            strA0I = A0I(388, 28, 56);
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            ig.A0d(bArr, 0, i5);
            listSingletonList = Collections.singletonList(bArr);
        } else if (i == AbstractC1524Cb.A1W) {
            strA0I = A0I(367, 21, 68);
        } else if (i == AbstractC1524Cb.A18) {
            strA0I = A0I(295, 20, 125);
            j = 0;
        } else if (i == AbstractC1524Cb.A09) {
            strA0I = A0I(342, 25, 79);
            c1527Ce.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c1527Ce.A02 = Format.A09(Integer.toString(i4), strA0I, null, -1, 0, str, -1, null, j, listSingletonList);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0N(com.facebook.ads.redexgen.X.IG r32, int r33, int r34, int r35, int r36, java.lang.String r37, boolean r38, com.facebook.ads.internal.exoplayer2.drm.DrmInitData r39, com.facebook.ads.redexgen.X.C1527Ce r40, int r41) throws com.facebook.ads.redexgen.X.AD {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1529Cg.A0N(com.facebook.ads.redexgen.X.IG, int, int, int, int, java.lang.String, boolean, com.facebook.ads.internal.exoplayer2.drm.DrmInitData, com.facebook.ads.redexgen.X.Ce, int):void");
    }

    public static boolean A0O(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int latestDelayIndex = IW.A06(3, 0, length);
        return jArr[0] <= j2 && j2 < jArr[latestDelayIndex] && jArr[IW.A06(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    public static byte[] A0P(IG ig, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            ig.A0Z(i3);
            int iA09 = ig.A09();
            if (ig.A09() == AbstractC1524Cb.A0q) {
                return Arrays.copyOfRange(ig.A00, i3, i3 + iA09);
            }
            i3 += iA09;
        }
        return null;
    }
}
