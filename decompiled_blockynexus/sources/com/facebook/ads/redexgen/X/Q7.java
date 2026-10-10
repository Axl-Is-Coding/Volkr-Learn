package com.facebook.ads.redexgen.X;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q7 {
    public static boolean A00(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Q6 q6A00 = Q6.A00(jSONArray, i);
            Q6 t2 = Q6.A00(jSONArray2, i);
            if (q6A00 != t2 || !q6A00.A06(jSONArray, jSONArray2, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean A02(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                return false;
            }
            Q6 q6A01 = Q6.A01(jSONObject, next);
            Q6 type1 = Q6.A01(jSONObject2, next);
            if (q6A01 != type1 || !q6A01.A08(jSONObject, jSONObject2, next)) {
                return false;
            }
        }
        return true;
    }
}
