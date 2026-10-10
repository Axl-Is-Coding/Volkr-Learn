package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cz extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19985a = "accounts";

    public void b() {
        a(f19985a, ae.d(ab.g));
    }

    public void c() {
        try {
            JSONObject jSONObject = (JSONObject) a_();
            if (jSONObject.has(f19985a)) {
                JSONArray jSONArray = jSONObject.getJSONArray(f19985a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if ("sim".equals(jSONArray.getJSONObject(i).getString("type"))) {
                        JSONArray jSONArrayA = bh.a().a("IMEI", dj.a().f20013a, dj.a().f20014b);
                        if (jSONArrayA != null) {
                            jSONArray.getJSONObject(i).put("extra", u.B(ab.g));
                            if (jSONArrayA.length() > 0) {
                                dj.a().a("IMEI", jSONArrayA);
                            }
                        } else {
                            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("extra");
                            if (jSONArray2 != null) {
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    a("imei", jSONArray2.getJSONObject(i2));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setUserAccount(ct ctVar) {
        if (ctVar == null || ctVar.a_() == null) {
            return;
        }
        if (this.f19979b.isNull(f19985a)) {
            new JSONArray().put(ctVar.a_());
            a(f19985a, ctVar.a_());
            return;
        }
        try {
            this.f19979b.getJSONArray(f19985a).put(ctVar.a_());
        } catch (JSONException e2) {
            bp.postSDKError(e2);
            e2.printStackTrace();
        }
    }
}
