package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class C1559Dk {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {102, 106, 105, 106, 119, 40, 119, 100, 107, 98, 96, ci.k, 1, 2, 1, 28, 67, 29, 26, ci.m, 0, 10, ci.m, 28, 10, 99, 111, 108, 111, 114, 45, 116, 114, 97, 110, 115, 102, 101, 114, 0, ci.n, 7, 78, 92, 80, 70, 25, 71, 64, 85, 64, 93, 87, 25, 93, 90, 82, 91};
        String[] strArr = A01;
        if (strArr[6].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "x3p0Kh6wVb2g5jx4t";
        strArr2[4] = "ATUwahLadetLCyEQ4";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"Dbr5x2VsG4nNJUzZeTNPRzqkDjV0oi2y", "sqWbbRPXNyW0qNg4n4LbnWr7GpqemFLg", "VW0orVwJIwlFBZUuevBwAx8XihB6GJeh", "sngGG6Fmd4EPEmkegOhqiaCkbznw5fIQ", "fBp67RXxdXXhweTtV", "xhkPbV6ALkx1WmbrpVNjFTeHYiqbNWEs", "xdguQhXu79c53EOEv", "iU2QkTKnw06iORL4QIBjMVUBldIJ1Brw"};
    }

    public static void A03(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            A05(mediaFormat, A00(25, 14, 61), colorInfo.A03);
            A05(mediaFormat, A00(11, 14, 83), colorInfo.A02);
            A05(mediaFormat, A00(0, 11, 56), colorInfo.A01);
            A06(mediaFormat, A00(43, 15, 9), colorInfo.A04);
        }
    }

    public static void A04(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    public static void A05(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void A06(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void A07(MediaFormat mediaFormat, List<byte[]> list) {
        int i = 0;
        while (true) {
            int size = list.size();
            String[] strArr = A01;
            if (strArr[3].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "lAJS3mBUvkodW4hvC";
            strArr2[4] = "VpgNqhxD27ukGqVl1";
            if (i < size) {
                mediaFormat.setByteBuffer(A00(39, 4, 94) + i, ByteBuffer.wrap(list.get(i)));
                i++;
            } else {
                return;
            }
        }
    }
}
