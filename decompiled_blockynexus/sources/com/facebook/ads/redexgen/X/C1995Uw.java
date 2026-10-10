package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1995Uw implements C6Y {
    public final /* synthetic */ V1 A00;

    public C1995Uw(V1 v1) {
        this.A00 = v1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        return this.A00.A0D(new HashMap<String, Integer>() { // from class: com.facebook.ads.redexgen.X.6R
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{123, -13};
            }

            {
                put(A00(1, 1, 109), Integer.valueOf(this.A00.A00.A01.widthPixels));
                put(A00(0, 1, 4), Integer.valueOf(this.A00.A00.A01.heightPixels));
            }
        });
    }
}
