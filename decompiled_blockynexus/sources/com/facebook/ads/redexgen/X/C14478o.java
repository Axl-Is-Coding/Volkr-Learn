package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14478o {
    public static byte[] A04;
    public static String[] A05;
    public final String A00;
    public final String A01;
    public final Map<EnumC14518s, List<String>> A02 = new HashMap();
    public final JSONObject A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23, -18, -27, -38, -69, -72, -78};
        String[] strArr = A05;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[4] = "sekG1ort6wl";
        strArr2[7] = "5zf1LSqUL7z";
        A04 = bArr;
    }

    public static void A02() {
        A05 = new String[]{"MRuBx", "tnrUNtkj", "pjyIxrC6Yt5E7Bc8e3CsDS5x0xMg", "2xISKY0hJDtdJSu4Q6JXzE3xpGdbyGij", "ditV1dZQcpc", "LaRPF5Qegj7e827D6k5bX2o3j9w5", "b", "ieJW9hY3GIu"};
    }

    public C14478o(String str, String str2, JSONObject jSONObject, @Nullable JSONArray jSONArray) {
        this.A00 = str;
        this.A01 = str2;
        this.A03 = jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (EnumC14518s enumC14518s : EnumC14518s.values()) {
            this.A02.put(enumC14518s, new LinkedList());
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString(A00(0, 4, 108));
                String string2 = jSONObject2.getString(A00(4, 3, 61));
                EnumC14518s enumC14518sValueOf = EnumC14518s.valueOf(string.toUpperCase(Locale.US));
                if (enumC14518sValueOf != null && !TextUtils.isEmpty(string2)) {
                    this.A02.get(enumC14518sValueOf).add(string2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final List<String> A05(EnumC14518s enumC14518s) {
        return this.A02.get(enumC14518s);
    }

    public final JSONObject A06() {
        return this.A03;
    }
}
