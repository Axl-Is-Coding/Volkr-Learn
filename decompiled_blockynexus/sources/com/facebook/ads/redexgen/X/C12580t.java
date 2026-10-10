package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12580t {
    public static C12570s A00;
    public static AnonymousClass87 A01;

    @Nullable
    public static String A02;
    public static CountDownLatch A03;
    public static CountDownLatch A04;
    public static boolean A05;
    public static byte[] A06;
    public static String[] A07;
    public static final String A08;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        byte[] bArr = {114, 115, 97, 10, 31, 123, 125, 3, 6, 17, 33, 3, 18, 18, 11, 12, 5, 43, 12, 4, ci.k, 76, 22, 26, 22, 32, 34, 51, 51, 38, 39, 2, 39, 48, 109, 55, 59, 55, ci.k, 25, ci.l, 26, 30, ci.l, 5, 8, 18, 52, 8, 10, 27, 27, 2, 5, 12};
        if (A07[0].charAt(25) == 's') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
        strArr[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
        A06 = bArr;
    }

    public static void A05() {
        A07 = new String[]{"TOlR5WIHpQxnCrBDCJGIvboS5c1GP2eb", "1A072KPTjzB", "BhIKZU0mEosMUOfZes2VT64q11XJ2Uhn", "3eQHzZddeWPmYl0bNsvnb2WjxREMTE8a", "x", "3ukMDhdDleVgfGP2GHVzNRiRwZbG92ZS", "tXOxwX9vQ8QECIpzr41AiGeD6LbiHgO3", "feL0RS1gsJrC9VyxtC"};
    }

    static {
        A05();
        A04();
        A08 = C12580t.class.getSimpleName();
        A03 = new CountDownLatch(1);
        A04 = new CountDownLatch(1);
    }

    public static String A00() {
        C12570s c12570s = A00;
        return c12570s != null ? c12570s.A03() : A01(5, 2, 101);
    }

    public static String A02(String str) {
        String strA01 = A01(38, 17, 46);
        File file = new File(A01.getFilesDir(), str);
        String strA012 = A01(0, 0, 103);
        if (file.exists() && file.length() > 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                return new String(bArr, A01(0, 5, 98));
            } catch (FileNotFoundException e2) {
                A01.A04().A8H(strA01, C8Y.A0t, new C8Z(e2));
                return strA012;
            } catch (IOException e3) {
                A01.A04().A8H(strA01, C8Y.A0u, new C8Z(e3));
                return strA012;
            }
        }
        return strA012;
    }

    public static void A03() {
        if (!A0I() || A02 == null) {
            return;
        }
        ExecutorC1744Lc.A06.execute(new R8(A02));
    }

    public static synchronized void A08() {
        A0F(A01(7, 18, 39));
        A0F(A01(25, 13, 6));
    }

    public static synchronized void A09() {
        try {
            A00.A08(A02(A01(25, 13, 6)));
            A00.A06(A02(A01(7, 18, 39)));
        } catch (JSONException e2) {
            A08();
            A01.A04().A8H(A01(38, 17, 46), C8Y.A0v, new C8Z(e2));
        }
    }

    public static synchronized void A0A() {
        A0G(A01(25, 13, 6), A00().getBytes());
        A0G(A01(7, 18, 39), A00.A04().toString().getBytes());
    }

    public static synchronized void A0C(C1J c1j, String str, boolean z) {
        c1j.A08(z);
        if (c1j.A09() || c1j.A0A()) {
            A00.A07(str);
        } else {
            A00.A09(str);
        }
    }

    public static synchronized void A0D(AnonymousClass87 anonymousClass87) {
        A01 = anonymousClass87;
        A02 = null;
        ExecutorC1744Lc.A06.execute(new R5());
    }

    public static void A0E(String str) {
        if (!A0I()) {
            return;
        }
        A02 = str;
        ExecutorC1744Lc.A06.execute(new R7(str));
    }

    public static void A0F(String str) {
        File file = new File(A01.getFilesDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static synchronized void A0G(String str, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(A01.getFilesDir(), str));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            A01.A04().A8H(A01(38, 17, 46), C8Y.A0t, new C8Z(e2));
        } catch (IOException e3) {
            A01.A04().A8H(A01(38, 17, 46), C8Y.A0u, new C8Z(e3));
        }
    }

    public static void A0H(JSONObject jSONObject) {
        A05 = C1693Iy.A0s(A01);
        if (!A05) {
            return;
        }
        ExecutorC1744Lc.A06.execute(new R6(jSONObject));
    }

    public static boolean A0I() {
        return A05;
    }

    public static boolean A0J(String str) {
        boolean z = false;
        try {
            z = A00.A04().get(str) instanceof C1J;
            return z;
        } catch (JSONException e2) {
            A01.A04().A8H(A01(38, 17, 46), C8Y.A0v, new C8Z(e2));
            return z;
        }
    }
}
