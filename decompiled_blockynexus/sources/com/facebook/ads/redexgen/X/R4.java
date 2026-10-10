package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.util.Log;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class R4 extends AbstractC12430e {
    public static byte[] A01;
    public static final String A02;
    public final Uri A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{88, 115, 123, 126, 119, 118, 50, -122, -127, 50, -127, -126, 119, -128, 50, 126, 123, -128, 125, 50, -121, -124, 126, 76, 50, -89, -102, -103, -98, -89, -102, -104, -87, -106, -104, -87, -98, -92, -93, -113, 117};
    }

    static {
        A01();
        A02 = R4.class.getSimpleName();
    }

    public R4(C2026Wb c2026Wb, J5 j5, String str, Uri uri) {
        super(c2026Wb, j5, str);
        this.A00 = uri;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12430e
    public final void A0D() {
        try {
            Log.w(A00(25, 16, 84), this.A00.toString());
            C1730Ko.A09(new C1730Ko(), super.A00, this.A00, this.A02);
        } catch (Exception unused) {
            String str = A00(0, 25, 17) + this.A00.toString();
        }
    }
}
