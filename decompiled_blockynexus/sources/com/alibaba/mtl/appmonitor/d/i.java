package com.alibaba.mtl.appmonitor.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorPointSampling.java */
/* JADX INFO: loaded from: classes.dex */
class i extends a<JSONObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<c> f3589e;
    private String p;

    public i(String str, int i) {
        super(i);
        this.p = str;
    }

    public boolean a(int i, Map<String, String> map) {
        List<c> list = this.f3589e;
        if (list != null && map != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                Boolean boolA = it.next().a(i, map);
                if (boolA != null) {
                    return boolA.booleanValue();
                }
            }
        }
        return a(i);
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extra");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    c cVar = new c(this.n);
                    if (this.f3589e == null) {
                        this.f3589e = new ArrayList();
                    }
                    this.f3589e.add(cVar);
                    cVar.b(jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
