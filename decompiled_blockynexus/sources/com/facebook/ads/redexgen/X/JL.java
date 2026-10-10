package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum JL {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);

    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 75, 75, 34, 35, 34, 41};
    }

    static {
        A02();
    }

    JL(long j, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j;
        this.A01 = mediaCacheFlag;
    }

    public static JL A00(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        for (JL jl : values()) {
            if (jl.A01 == mediaCacheFlag) {
                return jl;
            }
        }
        return null;
    }
}
