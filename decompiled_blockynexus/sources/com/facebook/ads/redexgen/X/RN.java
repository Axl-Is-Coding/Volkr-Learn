package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RN extends AnonymousClass15 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{66, 64, 83, 78, 84, 82, 68, 77, 93, 90, 64, 81, 70, 71, 64, 93, 64, 93, 85, 88, 90, 75, 88, 89, 67, 68, 77, 66, 93, 80, 81, 91, 107, 65, 70, 88};
    }

    public RN(List<AnonymousClass18> list) {
        super(list);
    }

    public static RN A01(JSONObject jSONObject, C2026Wb c2026Wb) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A02(0, 8, 67));
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    JSONObject adJSON = jSONArrayOptJSONArray.getJSONObject(i);
                    if (i == 0) {
                        A04(c2026Wb, adJSON, jSONObject);
                    }
                    AnonymousClass18 adInfo = AnonymousClass18.A00(adJSON);
                    adInfo.A0I(adJSON);
                    arrayList.add(adInfo);
                } catch (JSONException e2) {
                    c2026Wb.A04().A8H(A02(20, 7, 72), C8Y.A1r, new C8Z(e2));
                }
            }
        } else {
            AnonymousClass18 adInfo2 = AnonymousClass18.A00(jSONObject);
            adInfo2.A0I(jSONObject);
            arrayList.add(adInfo2);
        }
        RN rn = new RN(arrayList);
        rn.A0e(jSONObject);
        rn.A0c(A02(8, 12, 86));
        return rn;
    }

    public static void A04(C2026Wb c2026Wb, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> it = jSONObject2.keys();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals(A02(27, 9, 86)) && !next.equals(A02(0, 8, 67)) && !jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass15
    public final int A0I() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass15
    public final int A0J() {
        return 0;
    }
}
