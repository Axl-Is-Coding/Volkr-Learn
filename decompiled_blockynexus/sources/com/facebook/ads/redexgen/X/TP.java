package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TP implements C5z {
    public static byte[] A01;
    public static final String A02;
    public final C2027Wc A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{73, 116, 111, 105, 124, 120, 101, 99, 98, 44, 110, 121, 101, 96, 104, 101, 98, 107, 44, 74, 77, 66, 44, 96, 99, 107, 107, 101, 98, 107, 44, 70, 95, 67, 66, 69, 87, 77, 64, 71, 65, 122, 65, 68, 81, 68, 122, 73, 74, 66, 66, 76, 75, 66, 72, 67, 78, 121, 110, 65, 71, 32, 54, 39, 9, ci.n, 30};
    }

    static {
        A01();
        A02 = TP.class.getSimpleName();
    }

    public TP(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.C5z
    public final void A8Z(String str, String str2, int i, int i2, int i3, JSONObject jSONObject, EnumC13946d enumC13946d) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(A00(35, 4, 20), str);
            jSONObject2.put(A00(54, 3, 26), str2);
            jSONObject2.put(A00(57, 2, 42), i);
            jSONObject2.put(A00(59, 2, 3), i2);
            jSONObject2.put(A00(61, 3, 99), i3);
            jSONObject2.put(A00(64, 3, 74), C14116u.A01(jSONObject.toString(), str2));
            C8Z c8z = new C8Z(jSONObject2.toString());
            c8z.A03(1);
            this.A00.A04().A8I(A00(39, 15, 21), 3201, c8z);
        } catch (JSONException e2) {
            Log.e(A02, A00(0, 35, 60), e2);
        }
    }
}
