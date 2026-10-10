package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2019Vu extends C6P {

    @Nullable
    public static Class A01;

    @Nullable
    public static Method A02;
    public static byte[] A03;
    public static String[] A04;
    public static final String A05;
    public final Context A00;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A03 = new byte[]{81, 102, 102, 123, 102, 52, 114, 113, 96, 119, 124, 125, 122, 115, 52, 71, 109, 103, 96, 113, 121, 52, 87, 120, 117, 103, 103, 109, 90, 90, 71, 90, 8, 78, 77, 92, 75, 64, 65, 70, 79, 8, 123, 81, 91, 92, 77, 69, 8, 101, 77, 92, 64, 71, 76, 54, 57, 51, 37, 56, 62, 51, 121, 56, 36, 121, 4, 46, 36, 35, 50, 58, 7, 37, 56, 39, 50, 37, 35, 62, 50, 36, 52, 54, 39};
    }

    public static void A09() {
        A04 = new String[]{"xTXDwnP", "m3mciujbx2dfIA", "OE7MuMg38emiZQLg98rjTkcMx4olKfMY", "goZdcnoJLHlC5XwgkHkMwQSnaoNWuJDR", "f3bA1NA8QYvQicC8fDBey3gVRJQFEJgU", "9Vn87dBsvW3P0a", "kKXiWp2Gy5boByJ8BFYnfmbiktlC7Ann", "A12rwgsTDNtSjGwwceoQgWf2GCS5lXG2"};
    }

    static {
        A09();
        A08();
        A05 = C2019Vu.class.getSimpleName();
    }

    public C2019Vu(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = context;
        A01 = A04(this.A00);
        A02 = A06();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A02(HashMap<String, C2018Vt> map) {
        return new WS(SystemClock.elapsedRealtime(), A01, map, EnumC14036m.A0C);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static Class A04(Context context) {
        try {
            return context.getClassLoader().loadClass(A05(55, 27, 35));
        } catch (ClassNotFoundException e2) {
            String str = A05;
            String[] strArr = A04;
            if (strArr[2].charAt(28) == strArr[6].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[7] = "FTL4wNiu3HGi8YEZOV1rCtrzX9Uy9DdR";
            strArr2[7] = "FTL4wNiu3HGi8YEZOV1rCtrzX9Uy9DdR";
            Log.e(str, A05(0, 27, 96), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static Method A06() {
        try {
            Class<?>[] clsArr = {String.class};
            if (A01 == null) {
                return null;
            }
            return A01.getMethod(A05(82, 3, 39), clsArr);
        } catch (NoSuchMethodException e2) {
            Log.e(A05, A05(27, 28, 92), e2);
            return null;
        }
    }

    public final C6Y A0H(List<C6X> list) {
        return new C2017Vs(this, list);
    }
}
