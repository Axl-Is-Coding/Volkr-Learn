package com.ironsource.mediationsdk.b;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OutcomeEventsFormatter.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends a {
    private final String j = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";

    j(int i) {
        this.h = i;
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String a() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String a(ArrayList<b.f.b.b> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.g = new JSONObject();
        } else {
            this.g = jSONObject;
        }
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
        return a(jSONArray);
    }

    @Override // com.ironsource.mediationsdk.b.a
    public String c() {
        return "outcome";
    }
}
