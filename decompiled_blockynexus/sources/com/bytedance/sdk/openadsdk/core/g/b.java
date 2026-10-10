package com.bytedance.sdk.openadsdk.core.g;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DnsInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    HashMap<String, c> f6191b = new HashMap<>();

    private b() {
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.a(jSONObject.optString("cip"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dns");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    c cVarA = c.a(jSONArrayOptJSONArray.getJSONObject(i));
                    bVar.b().put(cVarA.a(), cVarA);
                }
            } else {
                c cVarA2 = c.a(jSONObject);
                bVar.b().put(cVarA2.a(), cVarA2);
            }
            return bVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public HashMap<String, c> b() {
        return this.f6191b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cip", a());
            JSONArray jSONArray = new JSONArray();
            if (b() != null) {
                Iterator<Map.Entry<String, c>> it = b().entrySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().getValue().f());
                }
            }
            jSONObject.put("dns", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String a() {
        return this.f6190a;
    }

    public void a(String str) {
        this.f6190a = str;
    }
}
