package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NU implements DialogInterface.OnClickListener {
    public static byte[] A04;
    public final /* synthetic */ NX A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ Map A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{27, 37, 17, 38, 41, 33, 17, 37, 38, 23, 34, 42, 40, 43, 27};
    }

    public NU(NX nx, Map map, String str, String str2) {
        this.A00 = nx;
        this.A03 = map;
        this.A01 = str;
        this.A02 = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.A03.put(A00(0, 11, 89), A00(11, 4, 93));
        this.A00.A06(this.A01, this.A02, this.A03);
    }
}
