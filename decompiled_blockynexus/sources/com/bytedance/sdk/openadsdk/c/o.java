package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatsEventThread.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends g<c.a> {
    private com.bytedance.sdk.openadsdk.core.p<a> l;

    public o(String str, String str2, e eVar, com.bytedance.sdk.openadsdk.core.p pVar, g.b bVar, g.a aVar) {
        super(str, str2, eVar, pVar, bVar, aVar);
        this.l = com.bytedance.sdk.openadsdk.core.o.f();
    }

    @Override // com.bytedance.sdk.openadsdk.c.g
    public h a(List<c.a> list) {
        if (this.l == null) {
            this.l = com.bytedance.sdk.openadsdk.core.o.f();
        }
        if (list == null || list.size() == 0 || !com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<c.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().f6755b);
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception unused) {
        }
        return this.l.b(jSONObject);
    }
}
