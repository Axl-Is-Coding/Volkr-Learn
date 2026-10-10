package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class Order extends JSONObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19730a = "id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19731b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19732c = "name";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19733d = "unitPrice";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19734e = "count";
    public static final String keyCurrencyType = "keyCurrencyType";
    public static final String keyOrderDetail = "keyOrderDetail";
    public static final String keyOrderId = "keyOrderId";
    public static final String keyTotalPrice = "keyTotalPrice";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONArray f19735f = null;

    private Order(String str, int i, String str2) {
        try {
            put(keyOrderId, str);
            put(keyTotalPrice, i);
            put(keyCurrencyType, str2);
        } catch (JSONException unused) {
        }
    }

    public static Order createOrder(String str, int i, String str2) {
        try {
            m.iForDeveloper("createOrder called --> orderId: " + str + " ,totalPrice: " + i + " ,currencyType: " + str2);
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("createOrder: orderId could not be null or empty");
            }
            if (TextUtils.isEmpty(str2) || str2.trim().length() != 3) {
                m.eForDeveloper("createOrder: currencyType length must be 3 ,likes CNY");
            }
        } catch (Throwable unused) {
        }
        return new Order(str, i, str2);
    }

    public synchronized Order addItem(String str, String str2, int i, int i2) {
        try {
            if (this.f19735f == null) {
                this.f19735f = new JSONArray();
                put(keyOrderDetail, this.f19735f);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f19731b, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("name", str2);
            }
            jSONObject.put(f19733d, i);
            jSONObject.put(f19734e, i2);
            this.f19735f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }

    private Order() {
    }

    public synchronized Order addItem(String str, String str2, String str3, int i, int i2) {
        try {
            if (this.f19735f == null) {
                this.f19735f = new JSONArray();
                put(keyOrderDetail, this.f19735f);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("id", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f19731b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("name", str3);
            }
            jSONObject.put(f19733d, i);
            jSONObject.put(f19734e, i2);
            this.f19735f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }
}
