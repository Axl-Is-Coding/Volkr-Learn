package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSize;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FN extends R0<AdSize> {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{99, -95, -88, -97, -97};
    }

    public FN(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.R0
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C0W A06(AdSize adSize) {
        String strA01;
        if (adSize == null) {
            strA01 = A01(1, 4, 35);
        } else {
            strA01 = adSize.getWidth() + A01(0, 1, 25) + adSize.getHeight();
        }
        return new C0W(this, strA01);
    }
}
