package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OB {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{69, 114, 114, 111, 114, 32, 116, 114, 97, 110, 115, 102, 111, 114, 109, 105, 110, 103, 32, 74, 83, 79, 78, 32, 105, 110, 32, 117, 112, 100, 97, 116, 101, 67, 97, 99, 104, 101, 100, 85, 114, 108, 115, 54, 52, 39, 58, 32, 38, 48, 57, 123, 102, 113, 126, 114, 118, 124, 64, 108, 123, 116, 64, 115, 126, 102, 122, 109, 64, 119, 107, 114, 115, 64, 106, 109, 115, 84, 95, 85, 110, 82, 80, 67, 85, 110, 88, 92, 80, 86, 84, 66, 39, 45, 33, 32, 2, 6, 10, 12, ci.l, 80, 87, 73, 107, 116, 121, 120, 114, 66, 104, 111, 113};
    }

    public static void A03() {
        A01 = new String[]{"xPMOoUfbkmQ5kvnU3jbgLL47OcFEjU7z", "1dodMLotzUEJucQn2MWgY64F", "Ei0kY7ZOP", "czo3jP2JN", "", "hHdeWCinA2EaAz86iaUgwk6OrkZVXmHI", "CkfkaUvdCRi5J5AIUl6JSr62iIVQ3RiE", "AT3hLPm3hPYjZ73rxoY4ER"};
    }

    public static JSONObject A01(C2026Wb c2026Wb, JSONObject iconObject, AnonymousClass77 anonymousClass77, JC jc, O3 o3) {
        String strA00 = A00(101, 3, 106);
        if (!anonymousClass77.A0Y(iconObject.optString(A00(51, 26, 80)))) {
            return iconObject;
        }
        jc.A03(JB.A0P, null);
        try {
            JSONObject jSONObjectOptJSONObject = iconObject.optJSONObject(A00(92, 4, 1));
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString(strA00) != null) {
                jSONObjectOptJSONObject.put(strA00, anonymousClass77.A0K(jSONObjectOptJSONObject.optString(strA00)));
            }
            JSONArray jSONArrayOptJSONArray = iconObject.optJSONArray(A00(77, 15, 126));
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    jSONArrayOptJSONArray.put(i, anonymousClass77.A0K(jSONArrayOptJSONArray.optString(i)));
                }
            }
            JSONArray jSONArrayOptJSONArray2 = iconObject.optJSONArray(A00(43, 8, 26));
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    A04(jSONArrayOptJSONArray2.optJSONObject(i2), anonymousClass77);
                }
            } else {
                A04(iconObject, anonymousClass77);
            }
        } catch (JSONException unused) {
            int i3 = C8Y.A0r;
            String strA002 = A00(0, 43, 79);
            if (A01[7].length() == 18) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "LxewRmCzOSDY9SAQbVbh0hKQ4ZXqC";
            strArr[7] = "LxewRmCzOSDY9SAQbVbh0hKQ4ZXqC";
            o3.A05(i3, strA002);
        }
        return iconObject;
    }

    public static void A04(JSONObject imageObject, AnonymousClass77 anonymousClass77) throws JSONException {
        JSONObject jSONObjectOptJSONObject = imageObject.optJSONObject(A00(96, 5, 36));
        if (jSONObjectOptJSONObject != null) {
            String strA00 = A00(101, 3, 106);
            if (jSONObjectOptJSONObject.optString(strA00) != null) {
                jSONObjectOptJSONObject.put(strA00, anonymousClass77.A0K(jSONObjectOptJSONObject.optString(strA00)));
            }
        }
        String strA002 = A00(104, 9, 82);
        if (!TextUtils.isEmpty(imageObject.optString(strA002))) {
            String strA0L = anonymousClass77.A0L(imageObject.optString(strA002));
            String[] strArr = A01;
            if (strArr[0].charAt(11) != strArr[6].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "hKzn1bJnFsf9yN7H5QHOi1sHDJIqnVRW";
            strArr2[5] = "hKzn1bJnFsf9yN7H5QHOi1sHDJIqnVRW";
            imageObject.put(strA002, strA0L);
        }
    }
}
