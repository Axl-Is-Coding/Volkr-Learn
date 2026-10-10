package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.NativeAdRatingApi;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JR implements NativeAdRatingApi {
    public static byte[] A02;
    public static String[] A03;
    public final double A00;
    public final double A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[3].charAt(20) == strArr[0].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "2hoOF1EBiwOhqbt1DT56iNDNNWb8yQHz";
            strArr2[2] = "W6hI53UtRDHSRmbx8lgXTECIFUbvBxjr";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 92);
            i4++;
        }
    }

    public static void A02() {
        A02 = new byte[]{113, 97, 99, 110, 103, 100, 115, 126, 103, 119};
    }

    public static void A03() {
        A03 = new String[]{"toY9r3GQ2V7oewvjptOzxrS3bXTXc0RA", "sNtoNgmSnc6mPwk", "sqn4euFoJMrOy6w1WzpNZbp0V46mSpuW", "EIfja0hemr4BNawwCcQfaPCPd3YJxnrU", "sMAw2w80fDiQYhU2W3UNXvphSzhcHd9d", "R2iCm9V8pMi0V4JYCgbimpTTwdawvKsh", "0MIfAaRYFlqcluCsT0Dbw6pT1oX0sCn1", "WyAiIZ6R26Fzk5qwkokaejcEGkdnjEqF"};
    }

    public JR(double d2, double d3) {
        this.A01 = d2;
        this.A00 = d3;
    }

    @Nullable
    public static JR A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (A03[1].length() == 15) {
            String[] strArr = A03;
            strArr[5] = "RjFVMQXNPaplscouVMfMFZlHjMQAuEdy";
            strArr[5] = "RjFVMQXNPaplscouVMfMFZlHjMQAuEdy";
            double dOptDouble = jSONObject.optDouble(A01(5, 5, 78), 0.0d);
            double dOptDouble2 = jSONObject.optDouble(A01(0, 5, 94), 0.0d);
            if (dOptDouble != 0.0d) {
                if (A03[5].charAt(0) == 'R') {
                    String[] strArr2 = A03;
                    strArr2[6] = "dPMTjBEXFaKbbBBBm4MCfcS4F7X28Hbr";
                    strArr2[2] = "0dli5ldtNE7riKXsyOdCpznATSfs344b";
                    if (dOptDouble2 != 0.0d) {
                        return new JR(dOptDouble, dOptDouble2);
                    }
                }
            }
            return null;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getScale() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getValue() {
        return this.A01;
    }
}
