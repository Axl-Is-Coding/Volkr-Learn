package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M9 {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(18) != strArr[4].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "NODd4hgwoPsa2k2MnOsaUDtymSUydbAu";
            strArr2[3] = "NODd4hgwoPsa2k2MnOsaUDtymSUydbAu";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{61, 57, 58, ci.l, 31, 18, 30, 21, 24, 30, 53, 30, ci.m, 12, 20, 9, ci.n, 9, 46, 38, 35, 111, 59, 32, 111, 61, 42, 33, 43, 42, 61, 111, 1, 46, 59, 38, 57, 42, 111, 59, 42, 34, Utf8.REPLACEMENT_BYTE, 35, 46, 59, 42, 97, 111, 10, 34, Utf8.REPLACEMENT_BYTE, 59, 54, 111, ci.l, 33, 43, 61, 32, 38, 43, 111, 25, 38, 42, 56, 111, 56, 38, 35, 35, 111, 45, 42, 111, 61, 42, 59, 58, 61, 33, 42, 43, 97, 52, 59, 46, 51, 44, Utf8.REPLACEMENT_BYTE, 5, 46, Utf8.REPLACEMENT_BYTE, 55, 42, 54, 59, 46, Utf8.REPLACEMENT_BYTE};
    }

    public static void A03() {
        A01 = new String[]{"Ja1bzDC4XO6MJovALms6", "IsGiV6tW8eEZvxsgDHoXbhWPQfEYRFJe", "F2wXUvOdg1ErZ5Wo6Cgjufn4T4zC8kyY", "0BOYk9mrV7ZAWg7WZWP8YYSS1bLPwSw8", "ohe2pYr3qvUc9pGZYOoHj0caDSEXBlEt", "i3VOTigCB6pNI1", "51BdPbZeK1jUSv1wKhHS", "aZfUmaE3Xil8RoSsFIMTsgdGf"};
    }

    public static View A00(C2026Wb c2026Wb, Throwable th) {
        A04(c2026Wb, th);
        return new View(c2026Wb);
    }

    public static void A04(C2026Wb c2026Wb, Throwable th) {
        c2026Wb.A04().A8H(A01(85, 15, 44), C8Y.A1c, new C8Z(th));
        Log.e(A01(0, 17, 13), A01(17, 68, 57), th);
    }
}
