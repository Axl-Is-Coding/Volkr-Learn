package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ShoppingCart extends JSONArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19736a = "id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19737b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19738c = "name";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19739d = "unitPrice";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19740e = "count";

    private ShoppingCart() {
    }

    public static ShoppingCart createShoppingCart() {
        return new ShoppingCart();
    }

    public synchronized ShoppingCart addItem(String str, String str2, String str3, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("id", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f19737b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("name", str3);
            }
            jSONObject.put(f19739d, i);
            jSONObject.put(f19740e, i2);
            put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this;
    }
}
