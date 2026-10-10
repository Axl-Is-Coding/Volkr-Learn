package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12570s {
    public static byte[] A03;
    public static String[] A04;
    public final LinkedHashSet<String> A02 = new LinkedHashSet<>();
    public JSONObject A01 = new JSONObject();
    public AtomicReference<String> A00 = new AtomicReference<>(A00(0, 2, 25));

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{ci.k, 11, 56, 58, 43, 74, 65, 76, 93, 86, 95, 91, 74, 75, 112, 70, 75, 86, 90, 67, 100, 88, 90, 75, 75, 94, 95, 100, 90, 73, 73, 90, 66, 100, 87, 94, 85, 92, 79, 83, 112, 124, 124, 106, 109, 109, 122, 113, 124, 122, 108, 19, 6, 17, 10, 12, 7, 22, 1, 27, 26, 49, 1, ci.k, ci.k, 27, 28, 28, 11, 0, ci.k, 11, 49, 29, 11, ci.k, 29, 97, 118, 108, 109, 70, 105, 124, 107, 112, 118, 125};
    }

    public static void A02() {
        A04 = new String[]{"Nqgg", "8wGIqWp", "y92csH8tMmRGnIZZsga62xjDucPy6znH", "NuhdC57WslsG6uEsDnOxbiezpeKaNBmF", "EG4F575TP", "HLT5liagTN6y0JvSt92F6CLrVRU5nCH8", "PjujBbxPTNTRaLXrj7yD38jvaiKi7YAc", "GRbHVCF"};
    }

    public final String A03() {
        String str = this.A00.get();
        return str == null ? A00(0, 2, 25) : str;
    }

    public final JSONObject A04() {
        return this.A01;
    }

    public final synchronized void A05() {
        JSONArray jSONArray = new JSONArray();
        for (String encryptedAdId : this.A02) {
            jSONArray.put(encryptedAdId);
        }
        AtomicReference<String> atomicReference = this.A00;
        String encryptedAdId2 = jSONArray.toString();
        atomicReference.set(encryptedAdId2);
    }

    public final void A06(String str) throws JSONException {
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        this.A01 = new JSONObject(str);
        Iterator<String> itKeys = this.A01.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (this.A01.get(next) instanceof String) {
                A0A(new JSONObject((String) this.A01.get(next)));
            }
        }
    }

    public final synchronized void A07(String str) {
        if (this.A02.size() >= C1J.A00()) {
            Iterator<String> it = this.A02.iterator();
            if (it.hasNext()) {
                this.A02.remove(it.next());
            }
        }
        this.A02.add(str);
        C13765k.A03();
    }

    public final synchronized void A08(String str) throws JSONException {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length() && i < C1J.A00(); i++) {
                    this.A02.add(jSONArray.getString(i));
                }
            }
        }
    }

    public final synchronized void A09(String str) {
        this.A02.remove(str);
        C13765k.A03();
    }

    public final void A0A(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString(A00(5, 12, 96), null);
        int iOptInt = jSONObject.optInt(A00(51, 6, 44));
        int iOptInt2 = jSONObject.optInt(A00(77, 11, 86));
        int iOptInt3 = jSONObject.optInt(A00(17, 23, 116), 50);
        long jOptLong = jSONObject.optLong(A00(2, 3, 20));
        C1J c1j = new C1J(strOptString);
        if (strOptString != null && this.A01.has(strOptString) && (this.A01.get(strOptString) instanceof C1J)) {
            c1j = (C1J) this.A01.get(strOptString);
        }
        String strA00 = A00(40, 11, 80);
        if (jSONObject.has(strA00)) {
            c1j.A07((JSONArray) jSONObject.get(strA00));
        }
        String strA002 = A00(57, 20, 33);
        if (jSONObject.has(strA002)) {
            c1j.A05(jSONObject.optInt(strA002));
        }
        c1j.A06(iOptInt, iOptInt2, jOptLong, iOptInt3);
        String[] strArr = A04;
        String str = strArr[3];
        String str2 = strArr[2];
        int maxCappedArrayLength = str.charAt(11);
        if (maxCappedArrayLength != str2.charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "tpg9MOL30KnGen5hdACKzszPCJWxtgkM";
        strArr2[2] = "0kRc9hG2BxRGhE0oYKlFhIYiMAEEJmAF";
        this.A01.put(strOptString, c1j);
    }
}
