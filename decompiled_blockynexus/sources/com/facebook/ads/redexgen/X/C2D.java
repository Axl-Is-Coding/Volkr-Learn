package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2D, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2D {
    public static byte[] A04;
    public static String[] A05;
    public boolean A00;
    public boolean A01;
    public final BroadcastReceiver A02;
    public final IntentFilter A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{109, 9, 8, 12, 9, 97, 39, 40, 45, 53, 36, 51, 124, 127, 72, 78, 72, 68, 91, 72, 95, 86, 66};
    }

    public static void A02() {
        A05 = new String[]{"XC94AwcgSvjgVkKSrw6USa9yjPBs64Er", "sEOY3yVdzVjZYc5fCydQIWNRtoI3Ep8p", "tsp8L53mE941fUp", "tfJ", "WI5YCVlpnY9sS2vUV4hGrlGwgmIaf2Io", "oZjWXXS8g7ghKD4scwMqufEnh", "pMetx8l337qhdnOFVjsjKuwa37", "eWa41C8ZyjQQf2L"};
    }

    public C2D(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.A03 = intentFilter;
        this.A02 = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(A00(13, 9, 62));
        sb.append(this.A02);
        sb.append(A00(5, 8, 82));
        sb.append(this.A03);
        if (this.A01) {
            sb.append(A00(0, 5, 94));
        }
        String strA00 = A00(22, 1, 44);
        String[] strArr = A05;
        if (strArr[7].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[5] = "FUdb7WkfGlB";
        strArr2[5] = "FUdb7WkfGlB";
        sb.append(strA00);
        return sb.toString();
    }
}
