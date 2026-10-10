package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Process;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UR extends C6P {
    public static byte[] A01;

    @Nullable
    public final BluetoothAdapter A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{-4, 9, -1, ci.k, 10, 4, -1, -55, 11, 0, ci.k, 8, 4, ci.l, ci.l, 4, 10, 9, -55, -35, -25, -16, -32, -17, -22, -22, -17, -29};
    }

    public UR(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = A04(context) ? BluetoothAdapter.getDefaultAdapter() : null;
    }

    public static boolean A04(Context context) {
        return context.checkPermission(A02(0, 28, 49), Process.myPid(), Process.myUid()) == 0;
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final C6Y A0H() {
        return new UN(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final C6Y A0I() {
        return new UO(this);
    }

    @SuppressLint({"MissingPermission"})
    public final C6Y A0J() {
        return new UP(this);
    }
}
