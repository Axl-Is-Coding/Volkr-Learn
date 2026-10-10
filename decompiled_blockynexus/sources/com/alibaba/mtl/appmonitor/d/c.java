package com.alibaba.mtl.appmonitor.d;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccurateSampling.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a<JSONObject> {
    private Map<String, b> p;

    public c(int i) {
        super(i);
        this.p = new HashMap();
    }

    public Boolean a(int i, Map<String, String> map) {
        Map<String, b> map2;
        if (map == null || (map2 = this.p) == null) {
            return null;
        }
        for (String str : map2.keySet()) {
            if (!this.p.get(str).b(map.get(str))) {
                return null;
            }
        }
        return Boolean.valueOf(a(i));
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
    }
}
