package com.alibaba.mtl.appmonitor.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlarmEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3557f = 0;
    public int g = 0;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public Map<String, String> f39g;
    public Map<String, Integer> h;

    public synchronized void a(String str, String str2) {
        if (com.alibaba.mtl.appmonitor.f.b.d(str)) {
            return;
        }
        if (this.f39g == null) {
            this.f39g = new HashMap();
        }
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (com.alibaba.mtl.appmonitor.f.b.c(str2)) {
            int length = 100;
            if (str2.length() <= 100) {
                length = str2.length();
            }
            this.f39g.put(str, str2.substring(0, length));
        }
        if (this.h.containsKey(str)) {
            this.h.put(str, Integer.valueOf(this.h.get(str).intValue() + 1));
        } else {
            this.h.put(str, 1);
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public synchronized void clean() {
        super.clean();
        this.f3557f = 0;
        this.g = 0;
        if (this.f39g != null) {
            this.f39g.clear();
        }
        if (this.h != null) {
            this.h.clear();
        }
    }

    public synchronized void e() {
        this.f3557f++;
    }

    public synchronized void f() {
        this.g++;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        try {
            jSONObjectA.put("successCount", this.f3557f);
            jSONObjectA.put("failCount", this.g);
            if (this.h != null) {
                JSONArray jSONArray = (JSONArray) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                for (Map.Entry<String, Integer> entry : this.h.entrySet()) {
                    JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
                    String key = entry.getKey();
                    jSONObject.put("errorCode", key);
                    jSONObject.put("errorCount", entry.getValue());
                    if (this.f39g.containsKey(key)) {
                        jSONObject.put("errorMsg", this.f39g.get(key));
                    }
                    jSONArray.put(jSONObject);
                }
                jSONObjectA.put("errors", jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObjectA;
    }
}
