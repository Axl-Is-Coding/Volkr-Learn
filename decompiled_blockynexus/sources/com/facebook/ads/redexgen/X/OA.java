package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OA {
    public static byte[] A05;
    public final O3 A00;
    public final String A01;
    public final String A02;
    public final WeakReference<J5> A03;
    public final WeakReference<C1872Qb> A04;

    static {
        A09();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A05 = new byte[]{-52, -8, -2, -11, -19, -87, -9, -8, -3, -87, -7, -22, -5, -4, -18, -87, -4, -18, -5, -1, -18, -5, -87, -10, -18, -4, -4, -22, -16, -18, ci.l, 59, 59, 56, 59, -23, 57, 42, 59, 60, 50, 55, 48, -23, 19, 28, 24, 23, -23, 50, 55, -23, 57, 56, 60, 61, 22, 46, 60, 60, 42, 48, 46, -23, 7, 27, 26, ci.l, -15, 11, 31, 62, 74, 72, 72, 60, 73, Utf8.REPLACEMENT_BYTE, -30, -11, -15, -17, -34, -36, -31, -34, -15, -34, 12, 27, 20, 20, 11, 18, 5, 9, 21, 10, 11, -37, -22, -29, -29, -38, -31, -44, -30, -38, -24, -24, -42, -36, -38, -28, -13, -20, -20, -29, -22, -35, -14, -9, -18, -29, 57, 62, 53, 42};
    }

    public OA(C1872Qb c1872Qb, J5 j5, O3 o3, String str, String str2) {
        this.A04 = new WeakReference<>(c1872Qb);
        this.A03 = new WeakReference<>(j5);
        this.A00 = o3;
        this.A01 = str;
        this.A02 = str2;
    }

    @Nullable
    private C2026Wb A00() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb != null) {
            return c1872Qb.getAdContextWrapper();
        }
        return null;
    }

    public static Map<String, String> A02(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.optString(next));
        }
        return map;
    }

    private void A03() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0O();
    }

    private void A04() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0P();
    }

    private void A05() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0Q();
    }

    private void A06() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0S();
    }

    private void A07() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0T();
    }

    private void A08() {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0U();
    }

    private void A0A(O9 o9, String str) throws JSONException {
        switch (O8.A00[o9.ordinal()]) {
            case 1:
                A0B(new JSONObject(str));
                return;
            case 2:
                A07();
                return;
            case 3:
                A03();
                return;
            case 4:
                A05();
                return;
            case 5:
                A04();
                return;
            case 6:
                A08();
                return;
            case 7:
                A0C(new JSONObject(str));
                return;
            case 8:
                A0D(new JSONObject(str));
                return;
            case 9:
                A0E(new JSONObject(str));
                return;
            case 10:
                if (BuildConfigApi.isDebug()) {
                }
                return;
            case 11:
                A06();
                break;
            case 12:
                break;
            default:
                return;
        }
        C2026Wb c2026WbA00 = A00();
        if (c2026WbA00 == null) {
            return;
        }
        c2026WbA00.A0A().A4y(str);
    }

    private void A0B(JSONObject jSONObject) {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        String strOptString = jSONObject.optString(A01(71, 7, 103));
        if (TextUtils.isEmpty(strOptString)) {
            c1872Qb.A0R();
        } else {
            c1872Qb.A0V(strOptString);
        }
    }

    private void A0C(JSONObject jSONObject) {
        C1872Qb c1872Qb = this.A04.get();
        if (c1872Qb == null) {
            return;
        }
        c1872Qb.A0W(A02(jSONObject));
    }

    private void A0D(JSONObject jSONObject) {
        J5 j5 = this.A03.get();
        if (j5 == null) {
            return;
        }
        String strOptString = jSONObject.optString(A01(113, 11, 10));
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        new JC(this.A02, j5).A04(strOptString, A02(jSONObject));
    }

    private void A0E(JSONObject jSONObject) {
        int iOptInt;
        C2026Wb c2026WbA00 = A00();
        if (c2026WbA00 == null || (iOptInt = jSONObject.optInt(A01(88, 11, 50), -1)) == -1) {
            return;
        }
        String strOptString = jSONObject.optString(A01(99, 14, 1));
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        c2026WbA00.A0A().A8F(iOptInt, strOptString);
    }

    @JavascriptInterface
    public void postMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!this.A01.equals(jSONObject.optString(A01(64, 7, 50)))) {
                this.A00.A05(C8Y.A0p, A01(0, 30, 21));
            } else {
                A0A(O9.A00(jSONObject.optString(A01(124, 4, 81))), jSONObject.optString(A01(78, 10, 9)));
            }
        } catch (JSONException e2) {
            this.A00.A05(C8Y.A0r, A01(30, 34, 85) + e2.getMessage());
        }
    }
}
