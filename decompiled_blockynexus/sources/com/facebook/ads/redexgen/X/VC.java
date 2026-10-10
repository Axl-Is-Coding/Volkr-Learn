package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VC extends C6P {
    public static byte[] A01;
    public final KeyguardManager A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{-57, -63, -43, -61, -47, -67, -50, -64};
    }

    public VC(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = (KeyguardManager) context.getSystemService(A02(0, 8, 85));
    }

    public final C6Y A0H() {
        return new V8(this);
    }

    public final C6Y A0I() {
        return new V9(this);
    }

    public final C6Y A0J() {
        return new VA(this);
    }

    public final C6Y A0K() {
        return new VB(this);
    }
}
