package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class N2 implements View.OnClickListener {
    public static byte[] A02;
    public final /* synthetic */ C2026Wb A00;
    public final /* synthetic */ N4 A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 20, 33, 23, 37, 34, 28, 23, -31, 28, 33, 39, 24, 33, 39, -31, 20, 22, 39, 28, 34, 33, -31, 9, -4, -8, 10};
    }

    public N2(N4 n4, C2026Wb c2026Wb) {
        this.A01 = n4;
        this.A00 = c2026Wb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.A01.A06) && !A00(0, 11, 35).equals(this.A01.A06)) {
                Intent intent = new Intent(A00(11, 26, 113), Uri.parse(this.A01.A06));
                intent.addFlags(268435456);
                this.A00.A0A().A7W();
                C1725Kh.A0C(this.A00, intent);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
