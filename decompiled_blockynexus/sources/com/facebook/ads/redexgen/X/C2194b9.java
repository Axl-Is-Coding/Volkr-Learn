package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
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
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2194b9 implements J3 {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04;
    public C2027Wc A00;
    public XE A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "6iaNxoAqzoeupDn53l2Cm";
            strArr2[6] = "N7vye13Dqewush4C3JTfsv4";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ed, code lost:
    
        if (r19 <= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ef, code lost:
    
        if (r4 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
    
        r7.put(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
    
        if (r3 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f7, code lost:
    
        r7.put(r3);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray A02(org.json.JSONArray r17, org.json.JSONArray r18, int r19) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2194b9.A02(org.json.JSONArray, org.json.JSONArray, int):org.json.JSONArray");
    }

    public static void A05() {
        A02 = new byte[]{21, 83, 90, 71, 21, 80, 67, 80, 91, 65, 124, 81, 21, 60, 111, 105, 127, 127, 121, 111, 111, 122, 105, 112, 112, 101, 50, 110, 101, 68, 77, 68, 85, 68, 69, 1, 68, 87, 68, 79, 85, 82, 1, 68, 89, 66, 68, 68, 69, 68, 69, 1, 83, 68, 85, 83, 88, 1, 77, 72, 76, 72, 85, ci.m, 1, 98, 78, 84, 79, 85, 27, 1, 72, 123, 104, 99, 121, 45, 121, 116, 125, 104, 45, 125, 127, 98, 110, 104, 126, 126, 104, 105, 45, 111, 116, 45, 121, 101, 104, 45, 126, 104, 127, 123, 104, 127, 55, 45, 84, 115, 123, 126, 119, 118, 50, 102, 125, 50, 98, 115, 96, 97, 119, 50, 115, 124, 50, 119, 100, 119, 124, 102, 50, 123, 124, 50, 119, 100, 119, 124, 102, 97, 50, 115, 96, 96, 115, 107, 50, 116, 125, 96, 50, 118, 123, 97, 98, 115, 102, 113, 122, 50, 116, 115, 123, 126, 103, 96, 119, 60, 65, 119, 96, 100, 119, 96, 50, 98, 96, 125, 113, 119, 97, 97, 119, 118, 50, 119, 100, 119, 124, 102, 91, 118, 50, 50, 4, 19, 23, 4, 19, 65, 19, 4, 21, 20, 19, ci.m, 4, 5, 65, ci.m, ci.l, ci.m, 76, 19, 4, 21, 19, 24, 0, 3, ci.k, 4, 65, 4, 19, 19, ci.l, 19, 65, 2, ci.l, 5, 4, 65, 42, 28, 11, ci.m, 28, 11, 89, 11, 28, ci.k, 12, 11, 23, 28, 29, 89, 11, 28, ci.k, 11, 0, 24, 27, 21, 28, 89, 28, 11, 11, 22, 11, 89, 26, 22, 29, 28, 89, 86, 109, 98, 97, 111, 102, 35, 119, 108, 35, 115, 98, 113, 112, 102, 35, 103, 102, 97, 118, 100, 79, 108, 100, 70, 117, 102, 109, 119, 35, 98, 119, 35, 6, 61, 50, 49, Utf8.REPLACEMENT_BYTE, 54, 115, 39, 60, 115, 35, 50, 33, 32, 54, 115, 54, 37, 54, 61, 39, 115, 50, 39, 115, 111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 73, 95, 72, 76, 95, 72, 26, 72, 95, 73, 74, 85, 84, 73, 95, 26, 91, 78, 26, 74, 85, 73, 83, 78, 83, 85, 84, 26, 80, 92, 87, 86, 104, 109, 120, 109, 110, 109, 127, 105, 17, 2, 17, 26, 0, 7, 6, 5, 1, 20, 21, 18, 5, 77, 3, ci.m, ci.l, 6, 9, 7, 77, 5, 22, 5, ci.l, 20, 77, ci.k, 1, 7, 9, 3, 33, 34, 38, 51, 50, 53, 34, 24, 36, 40, 41, 33, 46, 32, 44, 33, 71, 90, 94, 86, 60, 39, 35, 45, 38, 59};
    }

    public static void A06() {
        A03 = new String[]{"4VJF", "NMiFc9mQHDdEdTYDts8ebbMyjIljV2c0", "gJxI4lQggzgG7l1t48TOLBAVsZm4smpW", "RC", "7emK", "VnvWTQ3PSRLSSOUq71E5D", "jZ42e8scbVg896gjqaujwC7", "gj"};
    }

    static {
        A06();
        A05();
        A04 = C2194b9.class.getSimpleName();
    }

    public C2194b9(C2027Wc c2027Wc, XE xe) {
        this.A00 = c2027Wc;
        this.A01 = xe;
    }

    public static JSONArray A01(JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray != null ? 0 + jSONArray.length() : 0;
        if (jSONArray2 != null) {
            length += jSONArray2.length();
        }
        return A02(jSONArray, jSONArray2, length);
    }

    private JSONObject A03() {
        JSONArray jSONArrayA03;
        JSONObject payload = this.A01.A5S();
        JSONArray jSONArrayA5R = this.A01.A5R();
        if (J0.A0Q(this.A00) && (jSONArrayA03 = C14338a.A03(this.A00)) != null && jSONArrayA03.length() > 0) {
            jSONArrayA5R = A01(jSONArrayA03, jSONArrayA5R);
        }
        JSONObject jSONObject = null;
        if (jSONArrayA5R != null) {
            try {
                jSONObject = new JSONObject();
                if (payload != null) {
                    jSONObject.put(A00(439, 6, 32), payload);
                }
                jSONObject.put(A00(387, 6, 28), jSONArrayA5R);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject;
    }

    private JSONObject A04(int i) {
        int iA08;
        JSONArray jSONArrayA04;
        Pair<JSONObject, JSONArray> pairA7E = this.A01.A7E(i);
        JSONObject jSONObject = (JSONObject) pairA7E.first;
        JSONArray jSONArrayA02 = (JSONArray) pairA7E.second;
        if (J0.A0Q(this.A00) && (jSONArrayA04 = C14338a.A04(this.A00, (iA08 = J0.A08(this.A00)))) != null) {
            int debugEventLimit = jSONArrayA04.length();
            if (debugEventLimit > 0) {
                jSONArrayA02 = A02(jSONArrayA04, jSONArrayA02, i + iA08);
            }
        }
        JSONObject jSONObject2 = null;
        if (jSONArrayA02 != null) {
            try {
                jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    jSONObject2.put(A00(439, 6, 32), jSONObject);
                }
                jSONObject2.put(A00(387, 6, 28), jSONArrayA02);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject2;
    }

    private void A07(String str) {
        if (C14338a.A0J(str)) {
            C14338a.A0E(str);
        } else {
            this.A01.A7c(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final JSONObject A4G() {
        int iA0F = J0.A0F(this.A00);
        return iA0F > 0 ? A04(iA0F) : A03();
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final boolean A7u() {
        int iA0F = J0.A0F(this.A00);
        return iA0F >= 1 && this.A01.A6K() + C14338a.A00(this.A00) > iA0F;
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final void A97() {
        int iA3z = this.A01.A3z(J0.A0G(this.A00));
        if (iA3z > 0) {
            this.A00.A04().A8H(A00(379, 8, 100), C8Y.A0o, new C8Z(A00(28, 44, 73) + iA3z));
        }
        C2027Wc c2027Wc = this.A00;
        String[] strArr = A03;
        String str = strArr[5];
        String str2 = strArr[6];
        int length = str.length();
        int attemptsExceededEventsCount = str2.length();
        if (length == attemptsExceededEventsCount) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[5] = "bzDkK7DGlCk2AgYUikBmx";
        strArr2[6] = "oAHu9PBino36rPxONmBwiLk";
        C14338a.A0G(c2027Wc);
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final void A9b(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                A07(jSONArray.getJSONObject(i).getString(A00(433, 2, 45)));
            } catch (JSONException e2) {
                if (BuildConfigApi.isDebug()) {
                    String str = A04;
                    String[] strArr = A03;
                    if (strArr[5].length() == strArr[6].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A03;
                    strArr2[1] = "UiT9WvgcUGvh4UJIWCcVV8uUv9KhPAuj";
                    strArr2[2] = "iCLGRVxWINjUDSHIa5c9b6YKh720uR79";
                    Log.e(str, A00(108, 62, 122), e2);
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final boolean A9d(JSONArray jSONArray) {
        String eventId = A00(27, 1, 40);
        boolean z = true;
        boolean zA0Q = J0.A0Q(this.A00);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(A00(433, 2, 45));
                if (A00(393, 26, 8).equals(string)) {
                    C1693Iy.A0M(this.A00).A1p(jSONObject.getString(A00(419, 14, 47)));
                    DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
                } else {
                    int i2 = jSONObject.getInt(A00(375, 4, 91));
                    if (i2 == 1) {
                        if (BuildConfigApi.isDebug()) {
                            String str = A00(170, 25, 122) + string + A00(13, 14, 116);
                            String strA6N = this.A01.A6N(string);
                            if (strA6N != null) {
                                StringBuilder sb = new StringBuilder();
                                String eventType = A00(72, 36, 101);
                                sb.append(eventType);
                                sb.append(strA6N);
                                sb.toString();
                            }
                        }
                        if (!this.A01.A4g(string) && zA0Q) {
                            C14338a.A0D(string);
                        }
                    } else {
                        String strA00 = A00(0, 13, 93);
                        if (i2 >= 1000 && i2 < 2000) {
                            if (BuildConfigApi.isDebug()) {
                                Log.e(A04, A00(236, 37, 17) + i2 + strA00 + string + eventId);
                            }
                            A07(string);
                            z = false;
                        } else if (i2 >= 2000 && i2 < 3000) {
                            if (BuildConfigApi.isDebug()) {
                                Log.e(A04, A00(195, 41, 9) + i2 + strA00 + string + eventId);
                            }
                            if (!this.A01.A4g(string) && zA0Q) {
                                C14338a.A0D(string);
                            }
                        }
                    }
                    this.A00.A01().A8B(this.A00, jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(A04, A00(331, 44, 82) + i + eventId, e2);
                }
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.ads.redexgen.X.J3
    public final void AAz() {
        this.A01.A40();
        C14338a.A08(this.A00);
    }
}
