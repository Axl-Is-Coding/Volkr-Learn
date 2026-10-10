package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DnsItem.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    JSONArray f6194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    List<String> f6195d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f6196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f6197f;

    private c() {
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(jSONObject.optString("host"));
            cVar.a(jSONObject.optInt("ttl", 60));
            cVar.a(jSONObject.optJSONArray("ips"));
            cVar.a(jSONObject.optBoolean(" statsdnstime", false));
            long jOptLong = jSONObject.optLong("starttime", 0L);
            if (jOptLong > 0) {
                cVar.a(jOptLong);
            } else {
                cVar.a(System.currentTimeMillis());
            }
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b() {
        return this.f6193b;
    }

    public JSONArray c() {
        return this.f6194c;
    }

    public long d() {
        return this.f6196e;
    }

    public boolean e() {
        return this.f6197f;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", a());
            jSONObject.put("ttl", b());
            jSONObject.put("ips", c());
            jSONObject.put("starttime", d());
            jSONObject.put("statsdnstime", e());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String a() {
        return this.f6192a;
    }

    public void a(String str) {
        this.f6192a = str;
    }

    public void a(int i) {
        this.f6193b = i;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f6194c = jSONArray;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.get(i).toString();
                if (ab.l(string)) {
                    this.f6195d.add(string);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(long j) {
        this.f6196e = j;
    }

    public void a(boolean z) {
        this.f6197f = z;
    }
}
