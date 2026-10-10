package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoStartReason;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Op, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1834Op {
    A04(VideoStartReason.NOT_STARTED),
    A05(VideoStartReason.USER_STARTED),
    A03(VideoStartReason.AUTO_STARTED);

    public static byte[] A01;
    public final VideoStartReason A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{10, 30, 31, 4, 20, 24, 31, 10, 25, 31, ci.l, ci.m, 66, 67, 88, 83, 95, 88, 77, 94, 88, 73, 72, 18, 20, 2, 21, 24, 20, 19, 6, 21, 19, 2, 3};
    }

    static {
        A02();
    }

    EnumC1834Op(VideoStartReason videoStartReason) {
        this.A00 = videoStartReason;
    }

    public static EnumC1834Op A00(VideoStartReason videoStartReason) {
        for (EnumC1834Op enumC1834Op : values()) {
            if (enumC1834Op.A00 == videoStartReason) {
                return enumC1834Op;
            }
        }
        return A04;
    }
}
