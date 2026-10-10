package com.alibaba.mtl.appmonitor.d;

import com.umeng.analytics.pro.au;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTypeSampling.java */
/* JADX INFO: loaded from: classes.dex */
class g extends a<JSONObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.alibaba.mtl.appmonitor.a.f f3588e;
    protected int q;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    protected Map<String, h> f49q;

    public g(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(i);
        this.q = -1;
        this.f3588e = fVar;
        this.f49q = Collections.synchronizedMap(new HashMap());
    }

    public boolean a(int i, String str, String str2, Map<String, String> map) {
        h hVar;
        Map<String, h> map2 = this.f49q;
        return (map2 == null || (hVar = map2.get(str)) == null) ? i < this.n : hVar.a(i, str2, map);
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        this.f49q.clear();
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("metrics");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject2.optString(au.f20661d);
                    if (com.alibaba.mtl.appmonitor.f.b.c(strOptString)) {
                        h hVar = this.f49q.get(strOptString);
                        if (hVar == null) {
                            hVar = new h(strOptString, this.n);
                            this.f49q.put(strOptString, hVar);
                        }
                        hVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void c(JSONObject jSONObject) {
        com.alibaba.mtl.log.d.i.a("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("cacheCount");
            if (iOptInt <= 0 || this.f3588e == null) {
                return;
            }
            this.f3588e.b(iOptInt);
        } catch (Throwable th) {
            com.alibaba.mtl.log.d.i.a("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void setSampling(int i) {
        this.n = i;
    }
}
