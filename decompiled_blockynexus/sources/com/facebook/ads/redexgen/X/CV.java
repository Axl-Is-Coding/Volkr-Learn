package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CV implements XE {
    public static byte[] A02;
    public static String[] A03;
    public final C2027Wc A00;
    public final C8E A01;

    static {
        A05();
        A04();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        String[] strArr = A03;
        if (strArr[7].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "GUa5RhIL61d4FW3HWW0RBx9i";
        strArr2[1] = "4nKtohmUbY7tHai9z2t8ojCMJbrZv";
        A02 = new byte[]{62, 28, 19, 90, 9, 93, 25, 24, 17, 24, 9, 24, 93, 28, 9, 9, 24, ci.n, ci.k, 9, ci.l, 93, 24, 5, 30, 24, 24, 25, 24, 25, 93, 24, 11, 24, 19, 9, ci.l, 83, ci.n, 21, 7, 24, 21, 46, 59, 59, 42, 34, Utf8.REPLACEMENT_BYTE, 59, 127, 122, 111, 122, ci.n, 29, 50, 36, 50, 50, 40, 46, 47, 30, 40, 37, 32, 54, 32, 32, 58, 60, 61, 12, 39, 58, 62, 54, 76, 81, 85, 93, 20, ci.m, 11, 5, ci.l, Utf8.REPLACEMENT_BYTE, 9, 4, 127, 114, 123, 110};
    }

    public static void A05() {
        A03 = new String[]{"zSqnO64p11LQVC3SPrHTwk7q", "RQQcRArwNRw7pCFobI7zm4AECBhyO", "uX7W3VjoXSZ8mIic8tH9fb17VHeYN2EI", "VdQ4q", "h", "roUcO9bhLUMzgbi0", "6tdL5l5B64y16QievzXwm2hdxMIwTdT2", "M1EyYsdVjnJYnVOvo"};
    }

    public CV(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
        this.A01 = new C8E(c2027Wc);
    }

    private JSONArray A01(Cursor cursor) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(A00(54, 2, 44), cursor.getString(C2032Wh.A04.A00));
            jSONObject2.put(A00(82, 8, 53), cursor.getString(C2032Wh.A09.A00));
            jSONObject2.put(A00(90, 4, 94), cursor.getString(C2032Wh.A0A.A00));
            jSONObject2.put(A00(78, 4, 109), LP.A02(cursor.getDouble(C2032Wh.A08.A00)));
            jSONObject2.put(A00(66, 12, 6), LP.A02(cursor.getDouble(C2032Wh.A07.A00)));
            jSONObject2.put(A00(56, 10, 20), cursor.getString(C2032Wh.A06.A00));
            String string = cursor.getString(C2032Wh.A03.A00);
            if (string != null) {
                jSONObject = new JSONObject(string);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject2.put(A00(50, 4, 78), jSONObject);
            jSONObject2.put(A00(43, 7, 26), cursor.getString(C2032Wh.A02.A00));
            jSONObject2.put(A00(38, 5, 36), this.A00.A02().A6Z());
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    private JSONArray A02(Cursor cursor) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(A00(54, 2, 44), cursor.getString(2));
            jSONObject2.put(A00(82, 8, 53), cursor.getString(0));
            jSONObject2.put(A00(90, 4, 94), cursor.getString(4));
            jSONObject2.put(A00(78, 4, 109), LP.A02(cursor.getDouble(5)));
            jSONObject2.put(A00(66, 12, 6), LP.A02(cursor.getDouble(6)));
            jSONObject2.put(A00(56, 10, 20), cursor.getString(7));
            String string = cursor.getString(8);
            if (string != null) {
                jSONObject = new JSONObject(string);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject2.put(A00(50, 4, 78), jSONObject);
            jSONObject2.put(A00(43, 7, 26), cursor.getString(9));
            jSONObject2.put(A00(38, 5, 36), this.A00.A02().A6Z());
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    public static JSONObject A03(Cursor cursor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            String string = cursor.getString(C2034Wj.A02.A00);
            String string2 = cursor.getString(C2034Wj.A01.A00);
            String[] strArr = A03;
            if (strArr[6].charAt(14) != strArr[2].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "IfQdYzKY6vCyBSxPg";
            strArr2[5] = "fxZpsWnZoPKbT5Dt";
            jSONObject.put(string, string2);
        }
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    @SuppressLint({"CatchGeneralException"})
    public final int A3z(int i) {
        int iA09 = 0;
        if (i > -1) {
            try {
                iA09 = this.A01.A09(i);
            } catch (Exception e2) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(XE.A00, A00(0, 38, 40), e2);
                }
            }
        }
        this.A01.A0J();
        this.A01.A0K();
        return iA09;
    }

    @Override // com.facebook.ads.redexgen.X.C9E
    public final void A40() {
        this.A01.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    public final boolean A4g(String str) {
        return this.A01.A0L(str);
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    @Nullable
    public final JSONArray A5R() {
        Cursor cursorA0B = null;
        try {
            cursorA0B = this.A01.A0B();
            JSONArray jSONArrayA01 = null;
            if (cursorA0B.getCount() > 0) {
                jSONArrayA01 = A01(cursorA0B);
            }
            cursorA0B.close();
            return jSONArrayA01;
        } catch (JSONException unused) {
            if (cursorA0B != null) {
                cursorA0B.close();
            }
            return null;
        } catch (Throwable th) {
            if (cursorA0B != null) {
                cursorA0B.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    @Nullable
    public final JSONObject A5S() {
        Cursor cursorA0C = null;
        try {
            cursorA0C = this.A01.A0C();
            JSONObject jSONObjectA03 = null;
            if (cursorA0C.getCount() > 0) {
                jSONObjectA03 = A03(cursorA0C);
            }
            cursorA0C.close();
            return jSONObjectA03;
        } catch (JSONException unused) {
            String[] strArr = A03;
            if (strArr[3].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "fQ4GsEetTW4Q8M7eeZgpps0V";
            strArr2[1] = "7a4bIAh8lhheYJZGYQIYoy5madi9z";
            if (cursorA0C != null) {
                cursorA0C.close();
            }
            return null;
        } catch (Throwable th) {
            if (cursorA0C != null) {
                cursorA0C.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    public final int A6K() {
        Cursor cursorA0A = null;
        try {
            cursorA0A = this.A01.A0A();
            int i = cursorA0A.moveToFirst() ? cursorA0A.getInt(0) : 0;
            cursorA0A.close();
            return i;
        } catch (Throwable th) {
            if (cursorA0A != null) {
                cursorA0A.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    @Nullable
    public final String A6N(String str) {
        String string = null;
        Cursor cursorA0E = this.A01.A0E(str);
        if (cursorA0E != null) {
            if (cursorA0E.moveToNext() && cursorA0E.getCount() > 0) {
                C8C c8c = C2032Wh.A0A;
                String[] strArr = A03;
                if (strArr[7].length() == strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[3] = "VgiME";
                strArr2[4] = VipSubscribeStatus.SUBSCRIPTION_PURCHASED;
                string = cursorA0E.getString(cursorA0E.getColumnIndex(c8c.A01));
            }
            cursorA0E.close();
        }
        return string;
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    public final Pair<JSONObject, JSONArray> A7E(int i) {
        Cursor cursorA0D = null;
        try {
            try {
                cursorA0D = this.A01.A0D(i);
                JSONArray jSONArrayA02 = null;
                JSONObject jSONObjectA03 = null;
                if (cursorA0D.getCount() > 0) {
                    jSONObjectA03 = A03(cursorA0D);
                    jSONArrayA02 = A02(cursorA0D);
                }
                Pair<JSONObject, JSONArray> pair = new Pair<>(jSONObjectA03, jSONArrayA02);
                cursorA0D.close();
                return pair;
            } catch (JSONException unused) {
                Pair<JSONObject, JSONArray> pair2 = new Pair<>(null, null);
                if (cursorA0D != null) {
                    cursorA0D.close();
                }
                return pair2;
            }
        } catch (Throwable th) {
            if (cursorA0D != null) {
                cursorA0D.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C9D
    public final boolean A7c(String str) {
        return this.A01.A0M(str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.C9E
    public final void AEE(J2 j2, C9B<String> c9b) {
        this.A01.A0H(j2.A09(), j2.A06().A00, j2.A07().toString(), j2.A05(), j2.A04(), j2.A08(), j2.A0A(), c9b);
    }
}
