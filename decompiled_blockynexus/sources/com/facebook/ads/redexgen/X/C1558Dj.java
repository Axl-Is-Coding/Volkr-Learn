package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.sandboxol.center.web.http.HttpCode;
import com.umeng.analytics.pro.ci;
import io.grpc.internal.GrpcUtil;
import io.rong.common.dlog.DLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class C1558Dj {
    public static int A00;
    public static byte[] A01;
    public static String[] A02;
    public static final SparseIntArray A03;
    public static final SparseIntArray A04;
    public static final DY A05;
    public static final HashMap<C1555Dg, List<DY>> A06;
    public static final Map<String, Integer> A07;
    public static final Pattern A08;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{-73, -65, -87, -79, -17, -22, -14, -11, -18, -19, -87, -3, -8, -87, -6, -2, -18, -5, 2, -87, -20, -22, -7, -22, -21, -14, -11, -14, -3, -14, -18, -4, -78, -115, -59, -73, -40, 10, 10, 12, 4, 0, 5, -2, -47, -73, -40, 29, ci.m, ci.k, 31, 28, ci.m, -46, -83, -58, -62, -58, -27, -43, -67, -67, -65, -64, -31, -33, -21, -32, -31, -18, -22, -40, -36, -41, -37, -105, -123, -119, -124, -119, -10, -28, -23, -29, -25, -78, -96, -91, -97, -92, -18, -31, -31, -37, -35, -107, -120, -120, -126, -123, -11, -24, -24, -30, -24, -53, -66, -66, -71, -66, -75, -69, -62, -77, -77, -75, -74, -41, -43, -31, -42, -41, -28, -16, -10, -3, -18, -6, -1, -5, -17, -15, 18, ci.n, 28, 17, 18, 31, -80, -74, -67, -70, -67, -96, -79, -46, -48, -36, -47, -46, -33, -76, -70, -63, -57, -32, -29, -45, -38, -28, -75, -42, -44, -32, -43, -42, -29, -77, -50, -42, -39, -46, -47, -115, -31, -36, -115, -34, -30, -46, -33, -26, -115, -48, -36, -47, -46, -48, -115, -7, -30, -29, -31, -55, -78, -77, -76, -70, -93, -89, -94, -4, -27, -23, -25, -93, -116, -112, -111, 10, -13, -6, -14, -71, -94, -87, -92, -16, -39, -32, -34, -5, -26, -29, -10, -28, -34, -48, -66, -69, 18, 3, -6, -47, -62, -68, -86, -81, 11, 41, 48, 49, 52, 43, 48, 41, -30, 47, 35, 46, 40, 49, 52, 47, 39, 38, -30, 3, 24, 5, -30, 37, 49, 38, 39, 37, -30, 53, 54, 52, 43, 48, 41, -4, -30, -36, -6, 1, 2, 5, -4, 1, -6, -77, 0, -12, -1, -7, 2, 5, 0, -8, -9, -77, -37, -40, -23, -42, -77, -10, 2, -9, -8, -10, -77, 6, 7, 5, -4, 1, -6, -51, -77, -34, -61, -60, -62, -78, -105, -104, -103, -24, -51, -47, -52, -82, -109, -105, -107, -17, -44, -40, -39, -70, -97, -90, -98, -66, -93, -86, -91, -81, -108, -101, -103, -42, -67, -70, 4, -21, -18, 32, -93, -115, -121, -21, -43, -46, -37, -56, -65, -15, -34, -40, -62, -59, -88, -71, -38, -40, -28, -39, -38, -25, 7, 31, 30, 35, 27, -3, 41, 30, 31, 29, 6, 35, 45, 46, -38, -5, 10, 3, -38, 30, 35, 30, 40, -31, 46, -38, 38, 35, 45, 46, -38, 45, 31, 29, 47, 44, 31, -38, 30, 31, 29, 41, 30, 31, 44, -38, 32, 41, 44, -12, -38, -28, -4, -5, 0, -8, -38, 6, -5, -4, -6, -20, 11, 0, 3, -91, -68, -49, -52, -54, 119, -120, -121, -10, -21, -7, -10, -16, -21, -44, -1, -4, -38, -77, -79, -68, -110, -87, -36, -35, -46, -45, -41, -110, -91, -91, -89, -110, -88, -55, -57, -45, -56, -55, -42, 25, 23, 34, -8, ci.m, 66, 67, 56, 57, 61, -8, 11, 32, ci.k, -8, ci.l, 47, 45, 57, 46, 47, 60, 21, 19, 30, -12, 11, 62, Utf8.REPLACEMENT_BYTE, 52, 53, 57, -12, 7, 28, 9, -12, 10, 43, 41, 53, 42, 43, 56, -12, 57, 43, 41, 59, 56, 43, 3, 1, 12, -30, 1, 8, -1, -30, -11, 9, -8, -3, 3, -30, -8, -7, -9, 3, -8, -7, 6, -30, -11, -11, -9, -20, -22, -11, -53, -22, -15, -24, -53, -34, -14, -31, -26, -20, -53, -31, -30, -32, -20, -31, -30, -17, -53, -31, -16, -19, -34, -32, -48, -38, -40, -29, -71, -40, -33, -42, -71, -52, -32, -49, -44, -38, -71, -49, -48, -50, -38, -49, -48, -35, -71, -35, -52, -30, -23, -25, -14, -56, -19, -33, -35, -56, -25, -22, -51, -56, -34, -1, -3, 9, -2, -1, 12, -61, -63, -52, -94, -57, -71, -73, -94, -43, -43, -41, -94, -40, -39, -41, -89, -91, -80, -122, -85, -99, -101, -122, -50, -56, -112, -122, -68, -67, -69, -43, -45, -34, -76, -19, -11, -11, -19, -14, -21, -76, -8, -25, -3, -76, -22, -21, -23, -11, -22, -21, -8, 24, 22, 33, -9, 58, 44, 56, 54, -9, 42, 62, 45, 50, 56, -9, 45, 46, 44, 56, 45, 46, 59, -9, 42, 42, 44, -87, -89, -78, -120, -53, -67, -55, -57, -120, -69, -49, -66, -61, -55, -120, -66, -65, -67, -55, -66, -65, -52, -120, -57, -54, -115, -84, -86, -75, -117, -50, -64, -52, -54, -117, -45, -58, -63, -62, -52, -117, -63, -62, -64, -52, -63, -62, -49, -117, -45, -51, -107, -51, -67, -89, -86, -82, -63, -67, -83, -105, -102, -97, -79, 33, 17, 36, 1, -1, 5, 1, -33, -30, -28, -9, -21, 3, 1, 8, 8, 1, 6, -1, -72, -5, 7, -4, -3, -5, -72, -20, 5, 2, 5, 6, ci.l, 5, -73, -40, -19, -38, -73, 3, -4, ci.k, -4, 3, -47, -73, -78, -53, -56, -53, -52, -44, -53, 125, -98, -77, -96, 125, -51, -49, -52, -61, -58, -55, -62, -105, 125, 23, 48, 45, 48, 49, 57, 48, -30, 10, 7, 24, 5, -30, 46, 39, 56, 39, 46, -30, 53, 54, 52, 43, 48, 41, -4, -30, -30, -5, -8, -5, -4, 4, -5, -83, -43, -46, -29, -48, -83, -3, -1, -4, -13, -10, -7, -14, -83, 0, 1, -1, -10, -5, -12, -57, -83, -37, -20, -28, -14, -16, -20, -2, -48, -8, -10, -34, -39, -62, -10, -2, -59, -61, -66, 11, -31, -38, 34, 54, 37, 42, 48, -16, 38, 34, 36, -12, -56, -36, -53, -48, -42, -106, -52, -56, -54, -102, -108, -47, -42, -54, 38, 59, 40, -10, 9, 30, 11, -38, -15, -65, -32, -24, -12, -15, -4, -6, -6, -44, -47, -30, -99, -7, 7, -12, -62, 7, 3, 9, 17, 2, 25, ci.k, 30, 21, 26, 17, 24, 32, 17, ci.k, 32, 32, 52, 54, 51, 56, 51, 57, -30, -48, -36, -30, -28, -35, -42, -52, -70, -57, -51, -56, -52, ci.m, 1, ci.l, 
        ci.l, -3, 10, 11, 27, -41, -42, -55, -60, -59, -49, -113, -63, -42, -61, 25, 12, ci.m, ci.m, 8, 57, 44, 47, 47, 40, 38, -11, 7, -6, -3, -3, -10, 1, -3, 6, 4, -41, -62, -53, -55, -47, -62, 55, 34, 47, 44, 35, 41, 49, 34, 51, 30, 43, 40, 37, 45, 30};
    }

    public static void A0B() {
        A02 = new String[]{"PUk6Ycp3IyZuDM2vxEClNB7s", "Cor2Bf7UAjKBCW6KQ3kJAY2", "tBvhUMYEWbjuF5bg8fuW6r", com.umeng.analytics.pro.au.aw, "", "fIpZ4gAxwncTaI4Qx56KLzmZZ7uUPeai", "EGElOHn6uGhmkRxS9uXWLb9eFH9So4cV", "7k7mDGZCg"};
    }

    static {
        A0B();
        A0A();
        A05 = DY.A01(A07(657, 22, 55));
        A08 = Pattern.compile(A07(899, 10, 75));
        A06 = new HashMap<>();
        A00 = -1;
        A04 = new SparseIntArray();
        A04.put(66, 1);
        A04.put(77, 2);
        A04.put(88, 4);
        A04.put(100, 8);
        A03 = new SparseIntArray();
        A03.put(10, 1);
        A03.put(11, 4);
        A03.put(12, 8);
        A03.put(13, 16);
        A03.put(20, 32);
        A03.put(21, 64);
        A03.put(22, 128);
        A03.put(30, 256);
        A03.put(31, 512);
        A03.put(32, 1024);
        A03.put(40, DLog.CRS);
        A03.put(41, 4096);
        A03.put(42, 8192);
        A03.put(50, 16384);
        A03.put(51, 32768);
        A03.put(52, 65536);
        A07 = new HashMap();
        A07.put(A07(345, 3, 59), 1);
        A07.put(A07(352, 3, 8), 4);
        A07.put(A07(355, 3, 80), 16);
        A07.put(A07(358, 3, 64), 64);
        A07.put(A07(361, 3, 86), 256);
        A07.put(A07(313, 4, 67), 1024);
        A07.put(A07(317, 4, 23), 4096);
        A07.put(A07(321, 4, 77), 16384);
        A07.put(A07(325, 4, 19), 65536);
        A07.put(A07(329, 4, 84), 262144);
        A07.put(A07(333, 4, 31), 1048576);
        A07.put(A07(337, 4, 35), Integer.valueOf(GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE));
        A07.put(A07(341, 4, 20), 16777216);
        A07.put(A07(221, 3, 100), 2);
        A07.put(A07(224, 3, 95), 8);
        A07.put(A07(227, 3, 57), 32);
        A07.put(A07(230, 3, 123), 128);
        A07.put(A07(233, 3, 58), 512);
        A07.put(A07(189, 4, 98), Integer.valueOf(DLog.CRS));
        A07.put(A07(193, 4, 50), 8192);
        A07.put(A07(197, 4, 35), 32768);
        A07.put(A07(201, 4, 101), 131072);
        A07.put(A07(205, 4, 12), 524288);
        A07.put(A07(209, 4, 115), 2097152);
        A07.put(A07(213, 4, 34), 8388608);
        A07.put(A07(217, 4, 89), 33554432);
    }

    public static int A00() throws C1556Dh {
        if (A00 == -1) {
            int iMax = 0;
            DY dyA06 = A06(A07(HttpCode.PASSWORD_NOT_SET, 9, 17), false);
            if (dyA06 != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA0K = dyA06.A0K();
                String[] strArr = A02;
                String str = strArr[6];
                String str2 = strArr[5];
                int result = str.charAt(20);
                if (result != str2.charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "KZ3htwrCZaN4pnqbUvwqLO4F2z8ifUlK";
                strArr2[5] = "b2BkF0yBOqWKoYmDncjILGp6agQJiwPk";
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrA0K) {
                    iMax = Math.max(A01(codecProfileLevel.level), iMax);
                }
                iMax = Math.max(iMax, IW.A02 >= 21 ? 345600 : 172800);
            }
            A00 = iMax;
        }
        return A00;
    }

    public static int A01(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
                break;
            case 16:
                break;
            case 32:
                break;
            case 64:
                break;
            case 128:
                break;
            case 256:
                break;
            case 512:
                break;
            case 1024:
                break;
            case DLog.CRS /* 2048 */:
                break;
            case 4096:
                break;
            case 8192:
                break;
            case 16384:
                break;
            case 32768:
                break;
            case 65536:
                break;
        }
        return 101376;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A02(java.lang.String r10) {
        /*
            r9 = 0
            if (r10 != 0) goto L4
            return r9
        L4:
            r2 = 897(0x381, float:1.257E-42)
            r1 = 2
            r0 = 83
            java.lang.String r0 = A07(r2, r1, r0)
            java.lang.String[] r6 = r10.split(r0)
            r8 = 0
            r7 = r6[r8]
            int r0 = r7.hashCode()
            r5 = 3
            r4 = 2
            r3 = 1
            switch(r0) {
                case 3006243: goto L28;
                case 3006244: goto L57;
                case 3199032: goto L68;
                case 3214780: goto L78;
                default: goto L1e;
            }
        L1e:
            r8 = -1
        L1f:
            if (r8 == 0) goto L8e
            if (r8 == r3) goto L8e
            if (r8 == r4) goto L89
            if (r8 == r5) goto L89
            return r9
        L28:
            r2 = 936(0x3a8, float:1.312E-42)
            r1 = 4
            r0 = 118(0x76, float:1.65E-43)
            java.lang.String r8 = A07(r2, r1, r0)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1558Dj.A02
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L93
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1558Dj.A02
            java.lang.String r1 = "URe3HeFimxZDPUOt0d5oLD2A6pzKN2og"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "XxvGV8PZkl56DMpAUShQLpZcYfSVK56v"
            r0 = 5
            r2[r0] = r1
            boolean r0 = r7.equals(r8)
            if (r0 == 0) goto L1e
            r8 = 2
            goto L1f
        L57:
            r2 = 940(0x3ac, float:1.317E-42)
            r1 = 4
            r0 = 89
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L1e
            r8 = 3
            goto L1f
        L68:
            r2 = 953(0x3b9, float:1.335E-42)
            r1 = 4
            r0 = 29
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L1e
            goto L1f
        L78:
            r2 = 957(0x3bd, float:1.341E-42)
            r1 = 4
            r0 = 66
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L1e
            r8 = 1
            goto L1f
        L89:
            android.util.Pair r0 = A03(r10, r6)
            return r0
        L8e:
            android.util.Pair r0 = A04(r10, r6)
            return r0
        L93:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1558Dj.A02(java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00df, code lost:
    
        if (r0 == (-1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e1, code lost:
    
        android.util.Log.w(r4, A07(795, 19, 72) + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00fd, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0102, code lost:
    
        if (r0 == (-1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0112, code lost:
    
        return new android.util.Pair<>(java.lang.Integer.valueOf(r6), java.lang.Integer.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A03(java.lang.String r11, java.lang.String[] r12) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1558Dj.A03(java.lang.String, java.lang.String[]):android.util.Pair");
    }

    public static Pair<Integer, Integer> A04(String str, String[] strArr) {
        int i;
        int length = strArr.length;
        String strA07 = A07(275, 38, 68);
        String strA072 = A07(425, 14, 72);
        if (length < 4) {
            Log.w(strA072, strA07 + str);
            return null;
        }
        Matcher matcher = A08.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(strA072, strA07 + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (A07(53, 1, 82).equals(strGroup)) {
            i = 1;
        } else if (A07(54, 1, 44).equals(strGroup)) {
            i = 2;
        } else {
            Log.w(strA072, A07(862, 29, 62) + strGroup);
            return null;
        }
        Integer num = A07.get(strArr[3]);
        if (num == null) {
            Log.w(strA072, A07(835, 27, 115) + matcher.group(1));
            return null;
        }
        return new Pair<>(Integer.valueOf(i), num);
    }

    public static DY A05() {
        return A05;
    }

    @Nullable
    public static DY A06(String str, boolean z) throws C1556Dh {
        List<DY> listA09 = A09(str, z);
        if (listA09.isEmpty()) {
            return null;
        }
        return listA09.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e A[Catch: Exception -> 0x010f, TRY_ENTER, TryCatch #0 {Exception -> 0x010f, blocks: (B:6:0x0022, B:8:0x002a, B:10:0x0032, B:31:0x008e, B:34:0x009e, B:36:0x00a4, B:40:0x00d5, B:41:0x010b, B:37:0x00cc, B:38:0x00d0), top: B:48:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.facebook.ads.redexgen.X.DY> A08(com.facebook.ads.redexgen.X.C1555Dg r18, com.facebook.ads.redexgen.X.InterfaceC1557Di r19, java.lang.String r20) throws com.facebook.ads.redexgen.X.C1556Dh {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1558Dj.A08(com.facebook.ads.redexgen.X.Dg, com.facebook.ads.redexgen.X.Di, java.lang.String):java.util.ArrayList");
    }

    public static synchronized List<DY> A09(String str, boolean z) throws C1556Dh {
        C1555Dg c1555Dg = new C1555Dg(str, z);
        List<DY> list = A06.get(c1555Dg);
        if (list != null) {
            return list;
        }
        InterfaceC1557Di zd = IW.A02 >= 21 ? new ZD(z) : new ZC();
        ArrayList<DY> arrayListA08 = A08(c1555Dg, zd, str);
        if (z && arrayListA08.isEmpty() && 21 <= IW.A02 && IW.A02 <= 23) {
            zd = new ZC();
            arrayListA08 = A08(c1555Dg, zd, str);
            if (!arrayListA08.isEmpty()) {
                Log.w(A07(425, 14, 72), A07(374, 51, 107) + str + A07(34, 12, 72) + arrayListA08.get(0).A02);
            }
        }
        if (A07(922, 14, 24).equals(str)) {
            arrayListA08.addAll(A08(new C1555Dg(A07(912, 10, 114), c1555Dg.A01), zd, str));
        }
        A0C(arrayListA08);
        List<DY> listUnmodifiableList = Collections.unmodifiableList(arrayListA08);
        A06.put(c1555Dg, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static void A0C(List<DY> list) {
        if (IW.A02 < 26 && list.size() > 1) {
            if (A07(583, 25, 60).equals(list.get(0).A02)) {
                int i = 1;
                while (true) {
                    int size = list.size();
                    String[] strArr = A02;
                    String str = strArr[2];
                    String str2 = strArr[3];
                    int i2 = str.length();
                    if (i2 == str2.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[2] = "0x3TFANg8Ut6JiiOQttPnD";
                    strArr2[3] = com.umeng.analytics.pro.au.aw;
                    if (i < size) {
                        DY dy = list.get(i);
                        if (A07(657, 22, 55).equals(dy.A02)) {
                            list.remove(i);
                            list.add(0, dy);
                            return;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x036c, code lost:
    
        if (A07(769, 5, 127).equals(com.facebook.ads.redexgen.X.IW.A03) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:
    
        if (A07(364, 10, 38).equals(r8) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011e, code lost:
    
        if (r3 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012d, code lost:
    
        if (r3 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x022e, code lost:
    
        if (A07(774, 6, 99).equals(com.facebook.ads.redexgen.X.IW.A03) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028c, code lost:
    
        if (A07(85, 5, 32).equals(com.facebook.ads.redexgen.X.IW.A03) != false) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0D(android.media.MediaCodecInfo r7, java.lang.String r8, boolean r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 1106
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1558Dj.A0D(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0E(java.lang.String r4) {
        /*
            int r1 = com.facebook.ads.redexgen.X.IW.A02
            r0 = 22
            if (r1 > r0) goto L72
            java.lang.String r3 = com.facebook.ads.redexgen.X.IW.A06
            r2 = 447(0x1bf, float:6.26E-43)
            r1 = 10
            r0 = 88
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L50
            java.lang.String r3 = com.facebook.ads.redexgen.X.IW.A06
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1558Dj.A02
            r0 = 6
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 20
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L34
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1558Dj.A02
            java.lang.String r1 = "WIAIQszHPLNREe1YP7XBIT7"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = ""
            r0 = 4
            r2[r0] = r1
            r2 = 439(0x1b7, float:6.15E-43)
            r1 = 8
            r0 = 8
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L72
        L50:
            r2 = 479(0x1df, float:6.71E-43)
            r1 = 22
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L70
            r2 = 501(0x1f5, float:7.02E-43)
            r1 = 29
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L72
        L70:
            r0 = 1
            goto L73
        L72:
            r0 = 0
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1558Dj.A0E(java.lang.String):boolean");
    }
}
