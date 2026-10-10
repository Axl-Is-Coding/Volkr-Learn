package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RF implements InterfaceC12460h {
    public static byte[] A07;
    public static String[] A08;
    public final EnumC12450g A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final Collection<String> A05;
    public final Map<String, String> A06;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{9, 11, 28, 1, 30, 9, 28, 1, 7, 6, 55, 11, 7, 5, 5, 9, 6, 12, 4, 19, 59, 58, 43, 58, 60, 43, 54, 48, 49, 0, 44, 43, 45, 54, 49, 56, 44, 83, 84, 76, 91, 86, 83, 94, 91, 78, 83, 85, 84, 101, 88, 95, 82, 91, 76, 83, 85, 72, 49, 61, 46, 55, 41, 44, 42, 34, 51, 38, 35, 38, 51, 38, 117, 98, 118, 114, 98, 116, 115, 88, 110, 99};
    }

    public static void A03() {
        A08 = new String[]{"a8CS69kVNecuN9Nm4E1lChlBM", "ag8ss2YsLKCBvL1N8ZsAQ7i2G", "9IBuBVemd2S2dbE3BWmY83r4APvNrK7d", "ZoqrROBX", "uf7sNUy4ZjnbrmNcJuZuOOSXLwo6bRiZ", "LuNKGusWtlIWkNNSsxJCgMD8UDEcDleP", "s1ncMgVhGbgxvH35X0QQBiYqSsxlrK3j", "2ghFrXKxVbUZFk6auJt6qCgV8pKBUCZ9"};
    }

    public RF(String str, String str2, EnumC12450g enumC12450g, Collection<String> mDetectionStrings, Map<String, String> mMetadata, String str3, String str4) {
        this.A03 = str;
        this.A01 = str2;
        this.A00 = enumC12450g;
        this.A05 = mDetectionStrings;
        this.A06 = mMetadata;
        this.A04 = str3;
        this.A02 = str4;
    }

    public static RF A00(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(A01(58, 6, 57));
        String mMarkup = A01(0, 18, 13);
        String mRequestId = jSONObject.optString(mMarkup);
        String mActivationCommand = A01(72, 10, 98);
        String strOptString2 = jSONObject.optString(mActivationCommand);
        String mActivationCommand2 = A01(18, 2, 2);
        String strA02 = L6.A02(jSONObject, mActivationCommand2);
        String mActivationCommand3 = A01(37, 21, 95);
        EnumC12450g enumC12450gA00 = EnumC12450g.A00(jSONObject.optString(mActivationCommand3));
        try {
            jSONArray = new JSONArray(jSONObject.optString(A01(20, 17, 58)));
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        Collection<String> collectionA01 = C12470i.A01(jSONArray);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(64, 8, 34));
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (true) {
                boolean zHasNext = itKeys.hasNext();
                if (A08[4].charAt(10) == 'n') {
                    String[] strArr = A08;
                    strArr[3] = "3Uh3uJOo";
                    strArr[1] = "LYOYANb7jIXToaEoAzTea1MWV";
                    if (!zHasNext) {
                        break;
                    }
                    String next = itKeys.next();
                    map.put(next, jSONObjectOptJSONObject.optString(next));
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return new RF(strOptString, mRequestId, enumC12450gA00, collectionA01, map, strOptString2, strA02);
    }

    public final String A04() {
        return this.A01;
    }

    public final String A05() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h, com.facebook.ads.redexgen.X.InterfaceC12510m
    public final String A5q() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h
    public final Collection<String> A68() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h
    public final EnumC12450g A6X() {
        return this.A00;
    }
}
