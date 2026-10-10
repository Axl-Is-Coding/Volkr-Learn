package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class X0 implements KZ {
    public static byte[] A01;
    public final /* synthetic */ C2027Wc A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{68, 64, 67, 119, 102, 107, 103, 108, 97, 103, 76, 103, 118, 117, 109, 112, 105, ci.m, 52, Utf8.REPLACEMENT_BYTE, 34, 42, Utf8.REPLACEMENT_BYTE, 57, 46, Utf8.REPLACEMENT_BYTE, 62, 122, Utf8.REPLACEMENT_BYTE, 40, 40, 53, 40, 116, 121, 104, 123, 105, 114, 69, 105, 114, 115, 127, 118, 126};
    }

    public X0(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.KZ
    public final void A87(int i, Throwable th) {
        Log.e(A00(0, 17, 13), A00(17, 17, 85), th);
        this.A00.A04().A8H(A00(34, 12, 21), i, new C8Z(th));
    }
}
