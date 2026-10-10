package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JE {
    public static byte[] A00;
    public static final Map<String, String> A01;
    public static final Map<String, List<String>> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 27);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-68, -51, -49, -52, -33, -52, -42, -27, -34, -34, -43, -36, -3, 0, -14, -11, -16, 5, -6, -2, -10, -16, -2, 4, -68, -81, -69, -65, -81, -67, -66, -87, -66, -77, -73, -81, -87, -73, -67, -111, -108, 123, -126, -111, -118, -118, -127, -120, 123, -120, -117, -125, -125, -123, -118, -125};
    }

    static {
        A03();
        A02 = new HashMap();
        A01 = new HashMap();
    }

    @Nullable
    public static String A01(String str) {
        return A01.get(str);
    }

    public static List<String> A02(C2026Wb c2026Wb, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getString(i));
            } catch (JSONException e2) {
                c2026Wb.A04().A8H(A00(39, 17, 1), C8Y.A0x, new C8Z(e2));
            }
        }
        return arrayList;
    }

    public static void A04(View view, JC jc, JB jb) {
        view.addOnAttachStateChangeListener(new JD(jc, jb));
    }

    public static void A05(C2026Wb c2026Wb, String str, long j) {
        JC jc = new JC(str, c2026Wb.A06());
        HashMap map = new HashMap();
        map.put(A00(24, 15, 47), LP.A06(j));
        map.put(A00(12, 12, 118), LP.A04(j));
        jc.A03(JB.A0D, map);
    }

    public static void A06(C2026Wb c2026Wb, JSONObject jSONObject, long j, @Nullable String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A00(2, 4, 80));
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(6, 6, 85));
        if (TextUtils.isEmpty(str) && jSONArrayOptJSONArray != null) {
            A07(c2026Wb, jSONObjectOptJSONObject, A02(c2026Wb, jSONArrayOptJSONArray), j, null);
        } else {
            if (TextUtils.isEmpty(str) || !A02.containsKey(str)) {
                return;
            }
            A07(c2026Wb, jSONObjectOptJSONObject, A02.get(str), j, str);
        }
    }

    public static void A07(C2026Wb c2026Wb, JSONObject jSONObject, List<String> list, long j, @Nullable String str) {
        String strA00 = A00(0, 2, 62);
        if (jSONObject.has(strA00)) {
            String strOptString = jSONObject.optString(strA00);
            A08(strOptString, str);
            A09(strOptString, list);
            A05(c2026Wb, strOptString, j);
        }
    }

    public static void A08(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A01.put(str, str2);
    }

    public static void A09(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        A02.put(str, list);
    }

    public static boolean A0A(String str, JB jb) {
        return A0B(str, jb.A03());
    }

    public static boolean A0B(String str, String str2) {
        return A02.containsKey(str) && A02.get(str).contains(str2);
    }
}
