package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.HandlerThread;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor", "BadMethodUse-java.lang.Thread.start"})
public final class C14106t {

    @Nullable
    public static C14106t A01;
    public static byte[] A02;
    public static String[] A03;
    public final HandlerThread A00 = new HandlerThread(A01(0, 17, 18), 10);

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{64, 70, 125, 74, 67, 76, 70, 78, 71, 80, 125, 86, 74, 80, 71, 67, 70};
        String[] strArr = A03;
        if (strArr[7].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "0nmMWQrUqPP9YK8fXSZAXpfkVfmXzLEd";
        strArr2[3] = "QQPULwNyBmE6z7ehguJldYqP934Toq3j";
    }

    public static void A03() {
        A03 = new String[]{"UJwQpjf1O", "S7UdxYvdt6eFqSzfuqfdhKkG5fTcE86n", "W78BPxXfK8rmPtex2UpgUOA4EPabdg1o", "Ih0sAmpXrxuJlQxxXXd37zEDxuSYzw7I", "Iygfnm9JTOPQLVxzgBxd3gVL6k52LPVL", "TprgYI", "hMidux", "2We8O"};
    }

    static {
        A03();
        A02();
        A01 = null;
    }

    public C14106t() {
        this.A00.start();
    }

    public static C14106t A00() {
        if (A01 == null) {
            A01 = new C14106t();
        }
        return A01;
    }

    public final HandlerThread A04() {
        return this.A00;
    }

    public final void A05() {
        this.A00.quit();
        A01 = null;
    }
}
