package com.ironsource.mediationsdk.b;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronbeastEventsFormatter.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends a {
    private final String j = "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    private final String k = "super.dwh.mediation_events";
    private final String l = "table";
    private final String m = "data";

    i(int i) {
        this.h = i;
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String a() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String a(ArrayList<b.f.b.b> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            this.g = new JSONObject();
        } else {
            this.g = jSONObject;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<b.f.b.b> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectA = a(it.next());
                    if (jSONObjectA != null) {
                        jSONArray.put(jSONObjectA);
                    }
                }
            }
            jSONObject2.put("table", "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject2.toString();
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String c() {
        return "ironbeast";
    }
}
