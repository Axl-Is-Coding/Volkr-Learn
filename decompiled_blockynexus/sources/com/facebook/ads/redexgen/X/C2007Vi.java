package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2007Vi extends C6P {
    public static byte[] A01;
    public final PowerManager A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{101, 122, 98, 112, 103};
    }

    public C2007Vi(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = (PowerManager) context.getSystemService(A02(0, 5, 27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DeprecatedMethod"})
    public boolean A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            this.A00.isInteractive();
        }
        return this.A00.isScreenOn();
    }

    public final C6Y A0H() {
        return new C2005Vg(this);
    }

    @TargetApi(20)
    public final C6Y A0I() {
        return new C2004Vf(this);
    }

    public final C6Y A0J() {
        return new C2006Vh(this);
    }
}
