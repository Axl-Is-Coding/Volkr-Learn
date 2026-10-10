package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HostConfigMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f3611a = new d();
    private String W;
    private Map<String, c> u = Collections.synchronizedMap(new HashMap());

    public static d a() {
        return f3611a;
    }

    public void b(String str) {
        JSONObject jSONObject;
        i.a("HostConfigMgr", "host config:" + str);
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("hosts")) != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null) {
                            c cVar = new c();
                            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                            if (jSONObject4 != null) {
                                cVar.V = next.substring(1);
                                cVar.U = jSONObject4.getString("host");
                                JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                if (jSONArray != null) {
                                    cVar.f3610a = new ArrayList<>();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        cVar.f3610a.add(jSONArray.getString(i));
                                    }
                                }
                            }
                            this.u.put(cVar.V + "", cVar);
                        }
                    }
                }
                this.W = jSONObject2.getString("timestamp");
            } catch (Throwable unused) {
            }
        }
    }

    public Map<String, c> b() {
        return this.u;
    }
}
