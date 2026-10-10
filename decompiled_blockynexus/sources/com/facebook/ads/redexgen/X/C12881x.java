package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;
import com.facebook.ads.internal.exoplayer2.video.DummySurface;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class C12881x extends C3R {
    public static boolean A0b;
    public static boolean A0c;
    public static byte[] A0d;
    public static String[] A0e;
    public static final int[] A0f;
    public C1676Ih A00;
    public float A01;
    public float A02;
    public float A03;
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
    public int A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public Surface A0N;
    public Surface A0O;
    public C1675Ig A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final int A0T;
    public final long A0U;
    public final Context A0V;
    public final C1679Ik A0W;
    public final C1688It A0X;
    public final boolean A0Y;
    public final long[] A0Z;
    public final long[] A0a;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0e;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[6] = "1g9G5auDmi6BFhp1SUFflSJn2zbmW8bI";
            strArr2[4] = "EQg736KY9Bh9QzgWqQs064uwRmk9hBcX";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 46);
            i4++;
        }
    }

    public static void A0D() {
        A0d = new byte[]{64, 71, 65, 64, 64, 70, 64, 66, 71, 65, 71, 66, 122, 10, 11, 22, 12, 11, 125, 55, 71, 64, 70, 71, 42, 89, 91, 90, 93, 10, 95, 91, Utf8.REPLACEMENT_BYTE, 73, 78, 78, 78, 83, 31, 17, 103, 96, 96, 96, 32, 60, 37, 35, 118, 0, 7, 6, 7, 86, 3, ci.m, 73, Utf8.REPLACEMENT_BYTE, 56, 58, 56, 105, 60, 48, 40, 47, 61, 40, 2, 5, 23, ci.k, 0, 7, 21, 18, 39, 11, 7, 28, 9, 8, 11, 59, Utf8.REPLACEMENT_BYTE, 43, 26, 37, 61, 47, 56, 7, 90, 110, 105, 122, 68, 85, 116, 111, 126, 68, 41, 55, 57, 52, 54, 62, 88, 68, 45, 4, 20, 7, ci.n, ci.m, 7, 102, 114, ci.k, 102, 116, 118, 119, 115, 39, 55, 36, 51, 44, 36, 58, 36, 49, 51, 87, 3, 113, 7, 20, 124, 114, 115, 114, 27, ci.k, 116, 118, 90, 73, 81, 40, 47, 41, 32, 12, 31, 22, 119, 124, ci.n, 6, 127, 127, 106, 70, 77, 76, 74, 9, 68, 72, 81, 9, 91, 76, 90, 70, 69, 92, 93, 64, 70, 71, 9, 72, 77, 67, 92, 90, 93, 76, 77, 9, 93, 70, 19, 9, 108, 64, 66, 70, 64, 124, 30, 19, 99, 96, 98, 101, 94, 87, 78, 92, 90, 68, 90, 40, 68, 75, 105, 116, 46, 39, 62, 44, 42, 52, 37, 4, 31, ci.l, 5, 12, 21, 7, 1, 31, ci.n, 50, 41, 45, 24, 17, 8, 26, 28, 2, ci.m, 60, 36, 2, 5, 69, 118, 101, 114, 83, 116, 97, 114, 95, 83, 127, 10, 8, 8, 8, 72, 61, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 61, 102, 19, 17, 17, 22, 68, 49, 48, 51, 51, 24, 109, 108, 111, 109, 84, 33, 32, 35, 39, 39, 82, 82, 80, 80, 94, 121, 116, 107, 125, 91, 112, 125, 123, 115, 56, 67, 116, 125, 127, 121, 123, 97, 94, 106, 121, 117, 125, 75, 113, 98, 125, 52, 56, 41, 39, 33, 32, 43, 43, 49, 41, 44, 34, 89, 93, 88, 94, 8, 6, 0, 1, 10, 10, ci.n, 28, 24, 24, 126, 121, 127, 118, ci.m, 1, 7, 6, ci.k, ci.k, 23, 27, 31, 31, 121, 126, 122, 127, 65, 79, 73, 72, 67, 67, 89, 85, 81, 81, 55, 48, 53, 55, 1, ci.m, 9, 8, 3, 3, 25, 17, 4, 10, 115, 113, 118, 126, 40, 38, 32, 33, 42, 42, 48, 56, 45, 35, 88, 92, 89, 90, 59, 53, 51, 50, 57, 57, 35, 43, 62, 48, 75, 73, 77, 69, 40, 6, 32, 33, 42, 42, 48, 44, 45, 35, 88, 90, 94, 92, 30, 48, 22, 23, 28, 28, 6, 30, 27, 21, 110, 106, 104, 96, 64, 95, 74, 68, 70, 37, 64, 91, 68, 80, 82, 94, 62, 91, 66, 93, 92, 68, 89, 39, 66, 74, 109, 101, 106, 109, 106, 123, 46, 91, 54, 52, 49, 70, 75, 86, 21, 107, 110, Utf8.REPLACEMENT_BYTE, 106, 110, ci.k, 0, 21, 9, 17, ci.m, 70, 89, 39, Utf8.REPLACEMENT_BYTE, 58, 59, 61, 67, 59, 109, 87, 95, 83, 64, 79, 69, 87, 47, 27, ci.l, 96, 116, 92, 93, 80, 88, 122, 86, 93, 92, 90, 111, 80, 93, 92, 86, 107, 92, 87, 93, 92, 75, 92, 75, 26, 2, 29, ci.n, 29, 21, 95, 73, 36, 37, 32, 91, 45, 59, 86, 84, 80, 41, 28, 30, 11, 125, 52, 60, 60, 52, Utf8.REPLACEMENT_BYTE, 54, 89, 120, 115, 70, 122, 99, 101, 35, 66, 84, 50, 60, 53, 55, 95, 82, 64, 82, 34, 61, 38, 39, 32, 93, 71, 80, 89, 34, 37, 47, 17, 6, ci.m, 119, 112, 113, 96, 119, 126, 6, 1, 1, 31, 3, 10, 46, 44, 49, 73, 45, ci.l, 54, Utf8.REPLACEMENT_BYTE, 48, 42, 49, 51, 104, 4, 61, 44, 61, 96, 121, 99, 11, 103, 19, 77, 116, 101, 116, 40, 48, 44, 45, 66, 41, 90, 8, 106, 108, 105, 120, 29, 27, 31, 25, 33, 68, 66, 71, 109, 8, ci.m, ci.k, 12, 98, 6, 6, 26, 102, 97, ci.m, 18, 8, 2, 125, 116, 29, 121, 78, 88, 68, 71, 94, 95, 66, 68, 69, 88, 11, 94, 69, 64, 69, 68, 92, 69, 5, 11, 104, 68, 79, 78, 72, 11, 70, 74, 83, 11, 89, 78, 88, 68, 71, 94, 95, 66, 68, 69, 17, 11, 109, 104, 110, 19, 122, 106, 104, ci.m, 11, 118, 73, 68, 81, 64, 122, 117, 87, 74, 35, 53, 68, 90, 64, 68, 71, 49, 100, 114, 3, 29, 7, 3, 0, 104, 61, 43, 90, 68, 81, 92, 89, 47, 102, 112, 1, 31, 10, 7, 2, 127, ci.n, 43, 43, 100, 41, 37, 42, 61, 100, 55, 48, 54, 33, 37, 41, 100, 39, 44, 37, 42, 35, 33, 55, 104, 100, 55, 43, 100, 32, 54, 43, 52, 52, 45, 42, 35, 100, 43, 34, 34, 55, 33, 48, 126, 100, 73, 46, 7, 99, 98, 22, 19, 108, ci.m, 31, 116, 24, ci.m, 12, ci.k, ci.n, 103, ci.k, ci.m, 3, 102, 97, 97, 100, 19, 120, 123, 22, 25, 27, 6, 43, 73, 65, 104, 18, 111, 20, ci.n, 4, 21, 24, 30, 92, 2, 20, 2, 2, 24, 30, 31, 92, 24, 21, 12, 24, 25, 2, 64, 11, 31, ci.l, 75, 90, 71, 88, 5, 74, 71, 92, 92, 71, 69, 9, 24, 5, 26, 71, 6, ci.m, 12, 30, 17, 0, 29, 2, 95, 0, 27, 21, 26, 6, 28, ci.k, ci.n, ci.m, 82, 11, ci.n, ci.m, 54, 35, 100, 124, 105, 44, 81, 80, 87, 3, 21, 8, 23, 49, ci.l, 3, 2, 8, 37, 18, 1, 1, 2, 21, 99, 105, 106, 76, 69, 89, 94, 79, 88, 48, 36, 55, 59, 51, 123, 36, 55, 34, 51, 24, ci.k, 22, 25, 25, 22, 17, 39, 42, 38, 40, 39, 59, 99, 127, 104, 84, 110, 62, 61, 102, 103, 84, 111, 127, 126, 103, 42, 53, 3, ci.l, 7, 111, 10, 96, 107, 
        104, 101, 101, 49, 62, 58, 60, 86, 48, 49, 57, Utf8.REPLACEMENT_BYTE, 119, 108, 119, 109, 40, 46, 114, 111, 126, 119, 68, 72, 47, 42, 47, 119, 61, 41, 49, 32, 44, 43, 54, 47, 38, 28, 59, 117, 100, 104, 103, 103, 96, 103, 110, 118, 122, 105, 114, 117, 116, 68, 125, 12, 0, 25, 76, 9, 4, 8, 6, 9, 21, ci.l, 2, 27, 78, 10, ci.k, 19, 22, 23, 78, ci.n, 10, 25, 6, 83, 95, 70, 19, 73, 87, 90, 74, 86, ci.n, 21, 68, 64, 77, 70, 127, 123, 127, 119, 89, 86, 90, 86, 67, 95, 107, 108, 102, 110, 105, 100, 112, 118, 90, 99, 119, 53, 54, 53, 72, 89, 86, 93, 84, 84, 103, 92, 48, 33, 46, 37, 44, 44, 31, 36, 44, 101, 116, 123, 112, 121, 121, 74, 113, 102, 96, 113, 126, 117, 124, 124, 79, 116, 100, 78, 76, 87, 81, 76, 87, 74, 71, 107, 124, 117, 124, 120, 106, 124, 86, 108, 109, 105, 108, 109, 91, 108, 127, 127, 124, 107, 17, 12, 23, 2, 23, 10, 12, ci.k, 78, 7, 6, 4, 17, 6, 6, ci.n, 94, 20, 29, 24, 85, 29, 28, 21, 123, 105, 102, 124, 103, 102, 97, 68, 92, 94, 71, 97, 94, 83, 82, 88, 117, 66, 81, 81, 82, 69, 5, ci.n, 24, 21, 30, 46, 3, 30, 6, 32, 55, 56, 11, 49, 33, 54, 55, 44, 44, 39, 46, 39, 38, 111, 50, 46, 35, 59, 32, 35, 33, 41, 82, 65, 86, 74, 65, 65, 123, 105, 17, 116, 107, 102, 103, 109, 45, 49, 101, 114, 114, 117, 106, 103, 102, 108, 44, 98, 117, 96, 97, 126, 115, 114, 120, 56, 127, 114, 97, 116, 102, 121, 116, 117, 127, Utf8.REPLACEMENT_BYTE, 125, 96, 36, 102, 61, 117, 99, 5, 26, 23, 22, 28, 92, 11, 94, 5, 29, 23, 93, 28, 29, 65, 93, 5, 3, 75, 111, 112, 125, 124, 118, 54, 97, 52, 111, 119, 125, 55, 118, 119, 43, 55, 111, 105, 32, 9, 31, 10, ci.k, 17, ci.n, 79, 80, 65, 74, 93, 92, Utf8.REPLACEMENT_BYTE, 33, 44, 60, 32, 106, 114, 114, 121, 110, 66, 123, 115, 107, 107, 96, 119, 91, 98, 106, 23};
    }

    public static void A0E() {
        A0e = new String[]{"NS8r3iU3bE12Q5c28wyOjILRdJ0J08uI", "UbzRKZURs", "SU7Qb1ICkxq5LQRUjQdAnOKVl0Elt9iK", "HdySUumBIxpTjI6XDfJ50FoXA9Aqq3VK", "W2XidxNDZL2wdlIqJNQqrIQcb8erTCLJ", "pQl30wQXruMBF7LsTdQVlnJoVdVvITHL", "EldsxOw3j9Ew0275hEYEpNzApywAkDlk", "GsoHFPwBx"};
    }

    static {
        A0E();
        A0D();
        A0f = new int[]{1920, 1600, 1440, LogType.UNEXP_ANR, 960, 854, 640, 540, 480};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C12881x(Context context, InterfaceC1553De interfaceC1553De, long j, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, boolean z, @Nullable Handler handler, @Nullable InterfaceC1689Iu interfaceC1689Iu, int i) {
        super(2, interfaceC1553De, interfaceC1521Bu, z);
        this.A0U = j;
        this.A0T = i;
        this.A0V = context.getApplicationContext();
        this.A0W = new C1679Ik(this.A0V);
        this.A0X = new C1688It(handler, interfaceC1689Iu);
        this.A0Y = A0N();
        this.A0Z = new long[10];
        this.A0a = new long[10];
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0J = -9223372036854775807L;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0F = 1;
        A07();
    }

    public static int A00(DY dy, Format format) {
        if (format.A09 != -1) {
            int totalInitializationDataSize = 0;
            int size = format.A0P.size();
            for (int i = 0; i < size; i++) {
                totalInitializationDataSize += format.A0P.get(i).length;
            }
            int i2 = format.A09 + totalInitializationDataSize;
            if (A0e[5].charAt(17) != 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[6] = "hUEdDcZTQNKRArh2wdU5F4NdxnsUaLHW";
            strArr[4] = "JKTUnCqsCUQLCGuZWmxU63uBYWjDtVyB";
            return i2;
        }
        return A01(dy, format.A0O, format.A0F, format.A08);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014d, code lost:
    
        if (r4 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015c, code lost:
    
        if (r4 != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(com.facebook.ads.redexgen.X.DY r11, java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12881x.A01(com.facebook.ads.redexgen.X.DY, java.lang.String, int, int):int");
    }

    public static Point A02(DY dy, Format format) throws C1556Dh {
        int longEdgePx = 0;
        boolean z = format.A08 > format.A0F;
        int i = z ? format.A08 : format.A0F;
        int i2 = z ? format.A0F : format.A08;
        float f2 = i2 / i;
        int[] iArr = A0f;
        int length = iArr.length;
        while (longEdgePx < length) {
            int i3 = iArr[longEdgePx];
            if (A0e[3].charAt(18) == 'r') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[5] = "1BVaGfMRJiqdWLUq8dv8R9mVKG0R6nhL";
            strArr[5] = "1BVaGfMRJiqdWLUq8dv8R9mVKG0R6nhL";
            int i4 = (int) (i3 * f2);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (IW.A02 >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point pointA0F = dy.A0F(i5, i3);
                if (dy.A0I(pointA0F.x, pointA0F.y, format.A01)) {
                    return pointA0F;
                }
            } else {
                int iA04 = IW.A04(i3, 16) * 16;
                int iA042 = IW.A04(i4, 16) * 16;
                int i6 = iA04 * iA042;
                int shortEdgePx = C1558Dj.A00();
                if (i6 <= shortEdgePx) {
                    int shortEdgePx2 = z ? iA042 : iA04;
                    if (!z) {
                        iA04 = iA042;
                    }
                    return new Point(shortEdgePx2, iA04);
                }
            }
            longEdgePx++;
            if (A0e[3].charAt(18) != 'r') {
                String[] strArr2 = A0e;
                strArr2[7] = "qOOBmdqjU";
                strArr2[1] = "w7Tn3xd7M";
            } else {
                String[] strArr3 = A0e;
                strArr3[2] = "KAf95qDJkDfWOijmfxtuynNssocKmC3g";
                strArr3[0] = "h6cBxdrGRvPICzB6Kk67A24HS1YQyhML";
            }
        }
        return null;
    }

    @SuppressLint({"InlinedApi"})
    private final MediaFormat A03(Format format, C1675Ig c1675Ig, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A05(1094, 4, 60), format.A0O);
        mediaFormat.setInteger(A05(1359, 5, 102), format.A0F);
        mediaFormat.setInteger(A05(971, 6, 97), format.A08);
        C1559Dk.A07(mediaFormat, format.A0P);
        C1559Dk.A04(mediaFormat, A05(954, 10, 120), format.A01);
        C1559Dk.A05(mediaFormat, A05(1180, 16, 77), format.A0B);
        C1559Dk.A03(mediaFormat, format.A0J);
        mediaFormat.setInteger(A05(1079, 9, 16), c1675Ig.A02);
        mediaFormat.setInteger(A05(1055, 10, 79), c1675Ig.A00);
        C1559Dk.A05(mediaFormat, A05(1065, 14, 77), c1675Ig.A01);
        if (IW.A02 >= 23) {
            mediaFormat.setInteger(A05(1153, 8, 16), 0);
        }
        if (z) {
            mediaFormat.setInteger(A05(875, 8, 67), 0);
        }
        if (i != 0) {
            A0L(mediaFormat, i);
        }
        return mediaFormat;
    }

    private final C1675Ig A04(DY dy, Format format, Format[] formatArr) throws C1556Dh {
        int iMax = format.A0F;
        int iMax2 = format.A08;
        int iA00 = A00(dy, format);
        if (formatArr.length == 1) {
            return new C1675Ig(iMax, iMax2, iA00);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (A0W(dy.A03, format, format2)) {
                z |= format2.A0F == -1 || format2.A08 == -1;
                iMax = Math.max(iMax, format2.A0F);
                iMax2 = Math.max(iMax2, format2.A08);
                iA00 = Math.max(iA00, A00(dy, format2));
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(A05(683, 43, 5));
            sb.append(iMax);
            String strA05 = A05(1379, 1, 65);
            sb.append(strA05);
            sb.append(iMax2);
            String string = sb.toString();
            String strA052 = A05(522, 23, 23);
            Log.w(strA052, string);
            Point pointA02 = A02(dy, format);
            if (pointA02 != null) {
                iMax = Math.max(iMax, pointA02.x);
                iMax2 = Math.max(iMax2, pointA02.y);
                iA00 = Math.max(iA00, A01(dy, format.A0O, iMax, iMax2));
                Log.w(strA052, A05(164, 34, 7) + iMax + strA05 + iMax2);
            }
        }
        return new C1675Ig(iMax, iMax2, iA00);
    }

    private void A06() {
        MediaCodec mediaCodecA1E;
        this.A0R = false;
        if (IW.A02 >= 23 && this.A0S && (mediaCodecA1E = A1E()) != null) {
            this.A00 = new C1676Ih(this, mediaCodecA1E);
        }
    }

    private void A07() {
        this.A0E = -1;
        this.A0C = -1;
        this.A03 = -1.0f;
        this.A0D = -1;
    }

    private void A08() {
        if (this.A09 > 0) {
            long elapsedMs = SystemClock.elapsedRealtime();
            this.A0X.A02(this.A09, elapsedMs - this.A0H);
            this.A09 = 0;
            this.A0H = elapsedMs;
        }
    }

    private void A09() {
        if (this.A08 == -1 && this.A06 == -1) {
            return;
        }
        if (this.A0E != this.A08 || this.A0C != this.A06 || this.A0D != this.A07 || this.A03 != this.A01) {
            C1688It c1688It = this.A0X;
            String[] strArr = A0e;
            if (strArr[6].charAt(27) == strArr[4].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[2] = "RTvZ5FDjzwdLT6J2ljezTJit2l4QBCCR";
            strArr2[0] = "8XoC7GroR317PXdtPjLLz1J1MgtvBrxC";
            c1688It.A01(this.A08, this.A06, this.A07, this.A01);
            this.A0E = this.A08;
            this.A0C = this.A06;
            this.A0D = this.A07;
            this.A03 = this.A01;
        }
    }

    private void A0A() {
        if (this.A0R) {
            this.A0X.A03(this.A0O);
        }
    }

    private void A0B() {
        if (this.A0E != -1 || this.A0C != -1) {
            this.A0X.A01(this.A0E, this.A0C, this.A0D, this.A03);
        }
    }

    private void A0C() {
        long jElapsedRealtime;
        if (this.A0U > 0) {
            jElapsedRealtime = SystemClock.elapsedRealtime() + this.A0U;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.A0J = jElapsedRealtime;
    }

    private final void A0F(int i) {
        super.A0U.A02 += i;
        this.A09 += i;
        this.A05 += i;
        super.A0U.A05 = Math.max(this.A05, super.A0U.A05);
        if (this.A09 >= this.A0T) {
            A08();
        }
    }

    private final void A0G(MediaCodec mediaCodec, int i, long j) {
        IT.A02(A05(930, 15, 73));
        mediaCodec.releaseOutputBuffer(i, false);
        IT.A00();
        A0F(1);
    }

    private final void A0H(MediaCodec mediaCodec, int i, long j) {
        A09();
        IT.A02(A05(1161, 19, 55));
        mediaCodec.releaseOutputBuffer(i, true);
        IT.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1T();
    }

    private final void A0I(MediaCodec mediaCodec, int i, long j) {
        IT.A02(A05(1211, 15, 25));
        mediaCodec.releaseOutputBuffer(i, false);
        IT.A00();
        super.A0U.A08++;
    }

    @TargetApi(21)
    private final void A0J(MediaCodec mediaCodec, int i, long j, long j2) {
        A09();
        IT.A02(A05(1161, 19, 55));
        mediaCodec.releaseOutputBuffer(i, j2);
        IT.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1T();
    }

    @TargetApi(23)
    public static void A0K(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    public static void A0L(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(A05(1241, 17, 108), true);
        mediaFormat.setInteger(A05(859, 16, 95), i);
    }

    private void A0M(Surface surface) throws C14789u {
        if (surface == null) {
            if (this.A0N != null) {
                surface = this.A0N;
            } else {
                DY dyA1F = A1F();
                if (dyA1F != null && A0U(dyA1F)) {
                    this.A0N = DummySurface.A01(this.A0V, dyA1F.A05);
                    surface = this.A0N;
                }
            }
        }
        if (this.A0O != surface) {
            this.A0O = surface;
            int iA77 = A77();
            if (iA77 == 1 || iA77 == 2) {
                MediaCodec mediaCodecA1E = A1E();
                if (IW.A02 >= 23 && mediaCodecA1E != null && surface != null && !this.A0Q) {
                    A0K(mediaCodecA1E, surface);
                } else {
                    A1I();
                    A1K();
                }
            }
            if (surface != null && surface != this.A0N) {
                A0B();
                A06();
                if (iA77 == 2) {
                    A0C();
                    return;
                }
                return;
            }
            A07();
            String[] strArr = A0e;
            if (strArr[2].charAt(13) == strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[3] = "3kfdRjkwPvYxx8JzUoiB9hf8dQ33bpul";
            strArr2[3] = "3kfdRjkwPvYxx8JzUoiB9hf8dQ33bpul";
            A06();
            return;
        }
        if (surface == null || surface == this.A0N) {
            return;
        }
        A0B();
        A0A();
    }

    public static boolean A0N() {
        if (IW.A02 <= 22) {
            if (A05(948, 6, 4).equals(IW.A03)) {
                if (A05(545, 6, 122).equals(IW.A05)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A0O(long j) {
        return j < -30000;
    }

    public static boolean A0P(long j) {
        return j < -500000;
    }

    private final boolean A0Q(long j, long j2) {
        return A0P(j);
    }

    private final boolean A0R(long j, long j2) {
        return A0O(j);
    }

    private final boolean A0S(long j, long j2) {
        return A0O(j) && j2 > 100000;
    }

    private final boolean A0T(MediaCodec mediaCodec, int i, long j, long j2) throws C14789u {
        int iA11 = A11(j2);
        if (iA11 == 0) {
            return false;
        }
        super.A0U.A03++;
        A0F(this.A04 + iA11);
        A1H();
        return true;
    }

    private boolean A0U(DY dy) {
        if (IW.A02 >= 23 && !this.A0S) {
            String str = dy.A02;
            if (A0e[5].charAt(17) != 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[6] = "kyWyTgTuit8kBu9eYgHiJLOeDtaawSzk";
            strArr[4] = "zep7axp9udbgCrK2JAqRjKsc1O8PK6En";
            if (!A0V(str) && (!dy.A05 || DummySurface.A05(this.A0V))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:368:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x096e A[Catch: all -> 0x0995, TRY_ENTER, TryCatch #0 {, blocks: (B:9:0x001b, B:11:0x001f, B:12:0x0026, B:370:0x090b, B:373:0x0911, B:393:0x0970, B:392:0x096e, B:384:0x0947, B:387:0x0958, B:372:0x090f, B:14:0x002b, B:17:0x003f, B:20:0x0053, B:23:0x0067, B:26:0x007a, B:29:0x008e, B:32:0x00a1, B:35:0x00b4, B:38:0x00c7, B:41:0x00da, B:44:0x00ed, B:47:0x0101, B:50:0x0114, B:53:0x0126, B:56:0x013a, B:59:0x014e, B:62:0x0162, B:65:0x0176, B:68:0x018a, B:71:0x019e, B:74:0x01b2, B:77:0x01c5, B:80:0x01d9, B:83:0x01ec, B:86:0x01fe, B:89:0x0211, B:92:0x0225, B:95:0x0238, B:98:0x024c, B:101:0x025e, B:104:0x0272, B:107:0x0285, B:110:0x0298, B:113:0x02ac, B:116:0x02c0, B:119:0x02d4, B:122:0x02e8, B:125:0x02fc, B:128:0x0310, B:131:0x0323, B:134:0x0337, B:137:0x034b, B:140:0x035e, B:143:0x0371, B:146:0x0384, B:149:0x0397, B:152:0x03aa, B:155:0x03bd, B:158:0x03d0, B:161:0x03e3, B:164:0x03f6, B:167:0x0409, B:170:0x041b, B:173:0x042e, B:176:0x0441, B:179:0x0454, B:182:0x0467, B:185:0x047a, B:188:0x048b, B:191:0x049c, B:194:0x04ae, B:197:0x04c1, B:200:0x04d4, B:203:0x04e7, B:206:0x04fa, B:209:0x050c, B:212:0x051f, B:215:0x0533, B:218:0x0547, B:221:0x0559, B:224:0x056c, B:227:0x057f, B:230:0x0592, B:233:0x05a5, B:236:0x05b8, B:239:0x05cb, B:242:0x05de, B:245:0x05f1, B:248:0x0604, B:251:0x0616, B:254:0x0629, B:257:0x063c, B:260:0x064f, B:263:0x0662, B:266:0x0675, B:269:0x0689, B:272:0x069d, B:275:0x06b0, B:278:0x06c4, B:281:0x06d8, B:284:0x06ec, B:287:0x0700, B:290:0x0714, B:293:0x0728, B:296:0x073c, B:299:0x0750, B:302:0x0764, B:305:0x0778, B:308:0x078c, B:311:0x079f, B:314:0x07b2, B:317:0x07c6, B:320:0x07da, B:323:0x07ed, B:326:0x0801, B:329:0x0814, B:332:0x0826, B:335:0x083a, B:338:0x084d, B:341:0x0860, B:344:0x0874, B:347:0x0887, B:350:0x089a, B:353:0x08ad, B:356:0x08bf, B:359:0x08d1, B:362:0x08e4, B:365:0x08f7, B:394:0x0972), top: B:403:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0V(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 3170
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12881x.A0V(java.lang.String):boolean");
    }

    public static boolean A0W(boolean z, Format format, Format format2) {
        if (format.A0O.equals(format2.A0O) && format.A0B == format2.A0B && (z || (format.A0F == format2.A0F && format.A08 == format2.A08))) {
            ColorInfo colorInfo = format.A0J;
            ColorInfo colorInfo2 = format2.A0J;
            String[] strArr = A0e;
            if (strArr[2].charAt(13) == strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[5] = "SCavqIZfy9E7QicA0dHTliXfXCWB3KSN";
            strArr2[5] = "SCavqIZfy9E7QicA0dHTliXfXCWB3KSN";
            if (IW.A0h(colorInfo, colorInfo2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A14() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0A = 0;
        A07();
        A06();
        this.A0W.A09();
        this.A00 = null;
        this.A0S = false;
        try {
            super.A14();
        } finally {
            super.A0U.A00();
            this.A0X.A05(super.A0U);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A15() {
        super.A15();
        this.A09 = 0;
        this.A0H = SystemClock.elapsedRealtime();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A16() {
        this.A0J = -9223372036854775807L;
        A08();
        super.A16();
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A17(long j, boolean z) throws C14789u {
        super.A17(j, z);
        A06();
        this.A0I = -9223372036854775807L;
        this.A05 = 0;
        this.A0K = -9223372036854775807L;
        int i = this.A0A;
        if (i != 0) {
            long[] jArr = this.A0Z;
            String[] strArr = A0e;
            if (strArr[6].charAt(27) == strArr[4].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[7] = "7MW3dnHmZ";
            strArr2[1] = "zsetFM6ej";
            this.A0M = jArr[i - 1];
            this.A0A = 0;
        }
        if (z) {
            A0C();
        } else {
            this.A0J = -9223372036854775807L;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A18(boolean z) throws C14789u {
        super.A18(z);
        this.A0G = A13().A00;
        this.A0S = this.A0G != 0;
        this.A0X.A06(super.A0U);
        this.A0W.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A19(Format[] formatArr, long j) throws C14789u {
        if (this.A0M == -9223372036854775807L) {
            this.A0M = j;
        } else {
            int i = this.A0A;
            String[] strArr = A0e;
            if (strArr[6].charAt(27) == strArr[4].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[2] = "hJEWxkqVwddaEGRwsPF9GJysu0azMoJ9";
            strArr2[0] = "zdhmDyX7lfpv7BLRFINwBKdWRGj92JIy";
            if (i == this.A0Z.length) {
                Log.w(A05(522, 23, 23), A05(776, 45, 106) + this.A0Z[this.A0A - 1]);
            } else {
                this.A0A = i + 1;
            }
            long[] jArr = this.A0Z;
            int i2 = this.A0A;
            jArr[i2 - 1] = j;
            this.A0a[i2 - 1] = this.A0K;
        }
        super.A19(formatArr, j);
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final int A1C(MediaCodec mediaCodec, DY dy, Format format, Format format2) {
        if (A0W(dy.A03, format, format2) && format2.A0F <= this.A0P.A02 && format2.A08 <= this.A0P.A00 && A00(dy, format2) <= this.A0P.A01) {
            if (format.A0L(format2)) {
                return 1;
            }
            return 3;
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    @Override // com.facebook.ads.redexgen.X.C3R
    public final int A1D(InterfaceC1553De interfaceC1553De, InterfaceC1521Bu<Y1> interfaceC1521Bu, Format format) throws C1556Dh {
        String str = format.A0O;
        if (!I9.A0C(str)) {
            return 0;
        }
        boolean z = false;
        DrmInitData drmInitData = format.A0H;
        if (drmInitData != null) {
            for (int i = 0; i < drmInitData.A01; i++) {
                z |= drmInitData.A02(i).A03;
            }
        }
        DY dyA67 = interfaceC1553De.A67(str, z);
        String[] strArr = A0e;
        if (strArr[2].charAt(13) == strArr[0].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "kTnRYby1s";
        strArr2[1] = "UL9g0IqkI";
        if (dyA67 == null) {
            return (!z || interfaceC1553De.A67(str, false) == null) ? 1 : 2;
        }
        if (!CT.A0z(interfaceC1521Bu, drmInitData)) {
            return 2;
        }
        boolean zA0J = dyA67.A0J(format.A0K);
        if (zA0J && format.A0F > 0 && format.A08 > 0) {
            if (IW.A02 >= 21) {
                int i2 = format.A0F;
                int i3 = format.A08;
                if (A0e[3].charAt(18) == 'r') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0e;
                strArr3[6] = "jeBed4IeUvhTWXlMCWkd0HFF16tIjLHF";
                strArr3[4] = "0qAO2CVMQ14qnLtRtzyjuYZeLu4NiNP0";
                zA0J = dyA67.A0I(i2, i3, format.A01);
            } else {
                zA0J = format.A0F * format.A08 <= C1558Dj.A00();
                if (!zA0J) {
                    String str2 = A05(298, 29, 54) + format.A0F + A05(1379, 1, 65) + format.A08 + A05(856, 3, 97) + IW.A04 + A05(855, 1, 27);
                }
            }
        }
        boolean decoderCapable = dyA67.A03;
        int i4 = decoderCapable ? 16 : 8;
        boolean decoderCapable2 = dyA67.A06;
        int adaptiveSupport = decoderCapable2 ? 32 : 0;
        return i4 | adaptiveSupport | (zA0J ? 4 : 3);
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    @CallSuper
    public final void A1H() throws C14789u {
        super.A1H();
        this.A04 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    @CallSuper
    public final void A1I() {
        try {
            super.A1I();
        } finally {
            this.A04 = 0;
            Surface surface = this.A0N;
            if (surface != null) {
                if (this.A0O == surface) {
                    this.A0O = null;
                }
                this.A0N.release();
                this.A0N = null;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    @CallSuper
    public final void A1L(long j) {
        this.A04--;
        while (true) {
            int i = this.A0A;
            if (i != 0 && j >= this.A0a[0]) {
                long[] jArr = this.A0Z;
                this.A0M = jArr[0];
                this.A0A = i - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.A0A);
                long[] jArr2 = this.A0a;
                System.arraycopy(jArr2, 1, jArr2, 0, this.A0A);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    @Override // com.facebook.ads.redexgen.X.C3R
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1M(android.media.MediaCodec r10, android.media.MediaFormat r11) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12881x.A1M(android.media.MediaCodec, android.media.MediaFormat):void");
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1N(Format format) throws C14789u {
        super.A1N(format);
        this.A0X.A04(format);
        this.A02 = format.A02;
        this.A0B = format.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    @CallSuper
    public final void A1O(C2067Xq c2067Xq) {
        this.A04++;
        this.A0K = Math.max(c2067Xq.A00, this.A0K);
        if (IW.A02 < 23 && this.A0S) {
            A1T();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1P(DY dy, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws C1556Dh {
        this.A0P = A04(dy, format, A1B());
        MediaFormat mediaFormatA03 = A03(format, this.A0P, this.A0Y, this.A0G);
        if (this.A0O == null) {
            C1662Hr.A04(A0U(dy));
            Surface surface = this.A0N;
            String[] strArr = A0e;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[6] = "HUdK6ej9G5uy2eoW8HL148MSYBaQJURn";
            strArr2[4] = "oyZJZuVgjRVeIXKioVrHS7OTGib3SAbN";
            if (surface == null) {
                this.A0N = DummySurface.A01(this.A0V, dy.A05);
            }
            this.A0O = this.A0N;
        }
        mediaCodec.configure(mediaFormatA03, this.A0O, mediaCrypto, 0);
        if (IW.A02 >= 23 && this.A0S) {
            this.A00 = new C1676Ih(this, mediaCodec);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1Q(String str, long j, long j2) {
        this.A0X.A07(str, j, j2);
        this.A0Q = A0V(str);
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final boolean A1R(long unadjustedFrameReleaseTimeNs, long j, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long unadjustedFrameReleaseTimeNs2, boolean z) throws C14789u {
        if (this.A0I == -9223372036854775807L) {
            this.A0I = unadjustedFrameReleaseTimeNs;
        }
        long earlyUs = unadjustedFrameReleaseTimeNs2 - this.A0M;
        if (z) {
            A0I(mediaCodec, i, earlyUs);
            return true;
        }
        long j2 = unadjustedFrameReleaseTimeNs2 - unadjustedFrameReleaseTimeNs;
        Surface surface = this.A0O;
        Surface surface2 = this.A0N;
        String[] strArr = A0e;
        if (strArr[2].charAt(13) == strArr[0].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[2] = "tTKgXyDwmZTS9W3DU5UkyT40ENaKbHyT";
        strArr2[0] = "ymAWKg2GShyJej9UBV5xPoPh0gH7RDQq";
        if (surface == surface2) {
            if (!A0O(j2)) {
                return false;
            }
            A0I(mediaCodec, i, earlyUs);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String[] strArr3 = A0e;
        if (strArr3[2].charAt(13) == strArr3[0].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0e;
        strArr4[6] = "Tj6uZUYZuPZ7pCoRyZtHZtCub82IEIjs";
        strArr4[4] = "wN6Cz1ZftXTKk8PfKKvkhZq0bAWp3Laf";
        long j3 = jElapsedRealtime * 1000;
        boolean z2 = A77() == 2;
        if (!this.A0R || (z2 && A0S(j2, j3 - this.A0L))) {
            if (IW.A02 >= 21) {
                long jNanoTime = System.nanoTime();
                String[] strArr5 = A0e;
                if (strArr5[6].charAt(27) != strArr5[4].charAt(27)) {
                    String[] strArr6 = A0e;
                    strArr6[6] = "oWL9SRYwVyvR2JEBKybOkKnbuF7SsiRC";
                    strArr6[4] = "NzhSZMUYEy5Cfuxee7W6IeInRPwNjtL0";
                    A0J(mediaCodec, i, earlyUs, jNanoTime);
                    return true;
                }
                String[] strArr7 = A0e;
                strArr7[3] = "41VA6FIKazuT7AmZNA03mPvHgUe4JG9W";
                strArr7[3] = "41VA6FIKazuT7AmZNA03mPvHgUe4JG9W";
                A0J(mediaCodec, i, earlyUs, jNanoTime);
                return true;
            }
            A0H(mediaCodec, i, earlyUs);
            return true;
        }
        if (!z2 || unadjustedFrameReleaseTimeNs == this.A0I) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long jA08 = this.A0W.A08(unadjustedFrameReleaseTimeNs2, jNanoTime2 + ((j2 - (j3 - j)) * 1000));
        long adjustedReleaseTimeNs = (jA08 - jNanoTime2) / 1000;
        if (A0Q(adjustedReleaseTimeNs, j) && A0T(mediaCodec, i, earlyUs, unadjustedFrameReleaseTimeNs)) {
            return false;
        }
        if (A0R(adjustedReleaseTimeNs, j)) {
            A0G(mediaCodec, i, earlyUs);
            return true;
        }
        if (IW.A02 >= 21) {
            if (adjustedReleaseTimeNs < 50000) {
                A0J(mediaCodec, i, earlyUs, jA08);
                return true;
            }
        } else if (adjustedReleaseTimeNs < com.tendcloud.tenddata.ab.R) {
            if (adjustedReleaseTimeNs > 11000) {
                try {
                    Thread.sleep((adjustedReleaseTimeNs - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            A0H(mediaCodec, i, earlyUs);
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final boolean A1S(DY dy) {
        return this.A0O != null || A0U(dy);
    }

    public final void A1T() {
        if (!this.A0R) {
            this.A0R = true;
            this.A0X.A03(this.A0O);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT, com.facebook.ads.redexgen.X.AP
    public final void A7O(int i, Object obj) throws C14789u {
        if (i == 1) {
            String[] strArr = A0e;
            if (strArr[2].charAt(13) == strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[3] = "M4hKmbj6QiDhWM6pD0tSNqk85KgZRxnW";
            strArr2[3] = "M4hKmbj6QiDhWM6pD0tSNqk85KgZRxnW";
            A0M((Surface) obj);
            return;
        }
        if (i == 4) {
            this.A0F = ((Integer) obj).intValue();
            MediaCodec mediaCodecA1E = A1E();
            if (mediaCodecA1E == null) {
                return;
            }
            mediaCodecA1E.setVideoScalingMode(this.A0F);
            return;
        }
        super.A7O(i, obj);
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.XZ
    public final boolean A7w() {
        Surface surface;
        if (!super.A7w() || (!this.A0R && (((surface = this.A0N) == null || this.A0O != surface) && A1E() != null && !this.A0S))) {
            if (this.A0J == -9223372036854775807L) {
                return false;
            }
            if (SystemClock.elapsedRealtime() < this.A0J) {
                return true;
            }
            this.A0J = -9223372036854775807L;
            return false;
        }
        this.A0J = -9223372036854775807L;
        if (A0e[5].charAt(17) != 'd') {
            throw new RuntimeException();
        }
        String[] strArr = A0e;
        strArr[7] = "3PsRT4XFV";
        strArr[1] = "WWSFTmL3V";
        return true;
    }
}
