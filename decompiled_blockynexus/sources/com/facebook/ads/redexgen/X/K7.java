package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K7 {
    public static K7 A00;
    public static byte[] A01;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 113, 74, 103, 112, 101, 122, 103, 97, 124, 123, 114, 74, 118, 122, 123, 115, 124, 114, 49, 52, 49, 32, 36, 53, 34, 47, 42, 61, 23, 24, 41, 0, 23, 26, 31, 18, 23, 2, 31, 25, 24, 41, 3, 3, 31, 18, 96, 108, 103, 102, ci.n, 21, 0, 21, 103, 98, 119, 98, 92, 110, 108, 103, 102, 111, 92, 119, 122, 115, 102, 65, 64, 67, 76, 75, 76, 81, 76, 74, 75, 45, 58, 58, 39, 58, 70, 69, 65, 84, 85, 82, 69, 127, 67, 79, 78, 70, 73, 71, 92, 84, 66, 66, 80, 86, 84, 95, 67, 78, 76, 74, 66, 74, 65, 91, 92, 17, 23, 4, 6, ci.l, 0, 23, 22, 22, 27, 18, 7};
    }

    static {
        A05();
        A00 = new K7();
    }

    public static synchronized K7 A00() {
        return A00;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x005d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.C2166ag A01(com.facebook.ads.redexgen.X.C2026Wb r11, org.json.JSONObject r12, long r13, @androidx.annotation.Nullable java.lang.String r15) throws org.json.JSONException {
        /*
            r10 = this;
            r2 = 106(0x6a, float:1.49E-43)
            r1 = 10
            r0 = 88
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONArray r1 = r12.getJSONArray(r0)
            r0 = 0
            org.json.JSONObject r5 = r1.getJSONObject(r0)
            r2 = 70
            r1 = 10
            r0 = 82
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONObject r0 = r5.getJSONObject(r0)
            com.facebook.ads.redexgen.X.8r r6 = com.facebook.ads.redexgen.X.C14508r.A00(r0)
            r2 = 85
            r1 = 14
            r0 = 87
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r3 = r5.optString(r0)
            r2 = 0
            r1 = 19
            r0 = 98
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r0 = r5.optString(r0)
            com.facebook.ads.redexgen.X.8q r4 = new com.facebook.ads.redexgen.X.8q
            r4.<init>(r6, r3, r0)
            r2 = 26
            r1 = 3
            r0 = 57
            java.lang.String r1 = A04(r2, r1, r0)
            boolean r0 = r5.has(r1)
            if (r0 == 0) goto La6
            org.json.JSONArray r8 = r5.getJSONArray(r1)
            r7 = 0
        L59:
            int r0 = r8.length()
            if (r7 >= r0) goto La6
            org.json.JSONObject r9 = r8.getJSONObject(r7)
            com.facebook.ads.redexgen.X.JE.A06(r11, r9, r13, r15)
            r2 = 19
            r1 = 7
            r0 = 39
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r6 = r9.optString(r0)
            r2 = 55
            r1 = 15
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r5 = r9.optString(r0)
            r2 = 51
            r1 = 4
            r0 = 3
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONObject r3 = r9.optJSONObject(r0)
            r2 = 116(0x74, float:1.63E-43)
            r1 = 8
            r0 = 18
            java.lang.String r0 = A04(r2, r1, r0)
            org.json.JSONArray r1 = r9.optJSONArray(r0)
            com.facebook.ads.redexgen.X.8o r0 = new com.facebook.ads.redexgen.X.8o
            r0.<init>(r6, r5, r3, r1)
            r4.A09(r0)
            int r7 = r7 + 1
            goto L59
        La6:
            r2 = 29
            r1 = 18
            r0 = 1
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r1 = r12.optString(r0)
            com.facebook.ads.redexgen.X.ag r0 = new com.facebook.ads.redexgen.X.ag
            r0.<init>(r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K7.A01(com.facebook.ads.redexgen.X.Wb, org.json.JSONObject, long, java.lang.String):com.facebook.ads.redexgen.X.ag");
    }

    private C2149aP A02(JSONObject jSONObject) {
        return new C2149aP(jSONObject.optString(A04(99, 7, 70), A04(0, 0, 87)), jSONObject.optInt(A04(47, 4, 116), 0), null);
    }

    private C2149aP A03(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray(A04(106, 10, 88)).getJSONObject(0);
            C14508r c14508rA00 = C14508r.A00(jSONObject2.getJSONObject(A04(70, 10, 82)));
            String strOptString = jSONObject2.optString(A04(85, 14, 87));
            String featureConfig = A04(0, 19, 98);
            String strOptString2 = jSONObject2.optString(featureConfig);
            String strA04 = A04(99, 7, 70);
            String adReportingConfig = A04(0, 0, 87);
            String strOptString3 = jSONObject.optString(strA04, adReportingConfig);
            String adReportingConfig2 = A04(47, 4, 116);
            return new C2149aP(strOptString3, jSONObject.optInt(adReportingConfig2, 0), new C14498q(c14508rA00, strOptString, strOptString2));
        } catch (JSONException unused) {
            return A02(jSONObject);
        }
    }

    public final K9 A06(C2026Wb c2026Wb, String str, long j, @Nullable String str2) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(A04(124, 4, 21));
            byte b2 = -1;
            int iHashCode = strOptString.hashCode();
            String strA04 = A04(80, 5, 63);
            if (iHashCode != 96432) {
                if (iHashCode == 96784904 && strOptString.equals(strA04)) {
                    b2 = 1;
                }
            } else if (strOptString.equals(A04(26, 3, 57))) {
                b2 = 0;
            }
            if (b2 == 0) {
                return A01(c2026Wb, jSONObject, j, str2);
            }
            if (b2 != 1) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strA04);
                if (jSONObjectOptJSONObject != null) {
                    return A02(jSONObjectOptJSONObject);
                }
            } else {
                return A03(jSONObject);
            }
        }
        return new K9(K8.A04);
    }
}
