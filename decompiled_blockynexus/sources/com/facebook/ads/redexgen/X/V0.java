package com.facebook.ads.redexgen.X;

import android.provider.Settings;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class V0 implements C6Y {
    public static byte[] A01;
    public final /* synthetic */ V1 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-77, -93, -78, -91, -91, -82, -97, -94, -78, -87, -89, -88, -76, -82, -91, -77, -77};
    }

    public V0(V1 v1) {
        this.A00 = v1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        return this.A00.A04(Settings.System.getInt(r4.A00, A00(0, 17, 62), -1) / 255.0f);
    }
}
