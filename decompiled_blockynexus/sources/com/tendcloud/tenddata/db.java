package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class db extends cx {
    public db() {
        a("tid", o.a(ab.g));
    }

    public void b() {
        a("serialNo", q.c(ab.g));
        JSONArray jSONArrayA = bh.a().a("AdID");
        if (jSONArrayA != null) {
            a("adId", q.b(ab.g));
            if (jSONArrayA.length() > 0) {
                dj.a().a("AdID", jSONArrayA);
            }
        } else {
            a("adId", this.f19979b);
        }
        JSONArray jSONArrayA2 = bh.a().a("IMEI", dj.a().f20013a, dj.a().f20014b);
        if (jSONArrayA2 != null) {
            try {
                JSONArray jSONArrayB = u.B(ab.g);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                if (jSONArrayB != null && jSONArrayB.length() > 0) {
                    JSONObject jSONObject = jSONArrayB.getJSONObject(0);
                    if (jSONObject.has("imei")) {
                        jSONArray.put(jSONObject.get("imei"));
                    }
                    if (jSONObject.has("meid")) {
                        jSONArray2.put(jSONObject.get("meid"));
                    }
                    if (jSONArrayB.length() == 2) {
                        JSONObject jSONObject2 = jSONArrayB.getJSONObject(1);
                        if (jSONObject2.has("imei")) {
                            jSONArray.put(jSONObject2.get("imei"));
                        }
                        if (jSONObject2.has("meid")) {
                            jSONArray2.put(jSONObject2.get("meid"));
                        }
                    }
                }
                a("imeis", jSONArray);
                a("meids", jSONArray2);
            } catch (Exception unused) {
            }
            if (jSONArrayA2.length() > 0) {
                dj.a().a("IMEI", jSONArrayA2);
            }
        } else {
            a("imeis", this.f19979b);
        }
        JSONArray jSONArrayA3 = bh.a().a("MacAddress");
        if (jSONArrayA3 != null) {
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(q.d(ab.g));
            a("wifiMacs", jSONArray3);
            if (jSONArrayA3.length() > 0) {
                dj.a().a("MacAddress", jSONArrayA3);
            }
        } else {
            a("wifiMacs", this.f19979b);
        }
        JSONArray jSONArrayA4 = bh.a().a("AndroidId");
        if (jSONArrayA4 != null) {
            a("androidId", q.a("androidId"));
            if (jSONArrayA4.length() > 0) {
                dj.a().a("AndroidId", jSONArrayA4);
            }
        } else {
            a("androidId", this.f19979b);
        }
        a("msaIds", de.b().a_());
    }
}
