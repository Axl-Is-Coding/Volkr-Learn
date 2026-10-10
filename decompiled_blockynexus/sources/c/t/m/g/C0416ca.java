package c.t.m.g;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: c.t.m.g.ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0416ca extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3101a;

    @Override // c.t.m.g.T
    public final void a(O o) {
        S s = new S();
        Q q = new Q();
        P p = new P();
        try {
            if (C0455pa.a(q.f2990b) || !f3101a) {
                o.f2968a.put("needUpdateState", 1);
                f3101a = true;
            } else {
                o.f2968a.put("needUpdateState", 0);
            }
            if (C0455pa.a(q.f2990b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", s.f3003a);
                jSONObject.put("osVersion", s.f3004b);
                jSONObject.put("imei", s.f3005c);
                jSONObject.put("imsi", s.f3006d);
                jSONObject.put("pseudoId", s.f3007e);
                o.f2968a.put("RegistDeviceInfo", jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", (int) q.f2989a);
            jSONObject2.put("deviceId", q.f2990b);
            jSONObject2.put("sdkVersion", q.f2991c);
            o.f2968a.put("BindDeviceInfo", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("bundle", p.f2980a);
            jSONObject3.put("verCode", p.f2981b);
            jSONObject3.put("verName", p.f2982c);
            jSONObject3.put("appId", p.f2984e);
            jSONObject3.put("uuid", p.f2983d);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            o.f2968a.put("AppState", jSONArray);
            o.f2968a.put("netType", C0446ma.a(qc.g()));
            o.f2968a.put("oper", N.a(qc.j().intValue()));
        } catch (Exception unused) {
        }
    }

    @Override // c.t.m.g.T
    public final void a(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    if (Integer.parseInt(strOptString) == 1002) {
                        C0446ma.a("");
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            String strOptString2 = jSONObject.optString("deviceId");
            if (TextUtils.isEmpty(strOptString2)) {
                C0446ma.a("");
            } else {
                String strA = C0446ma.a();
                if (!TextUtils.isEmpty(strOptString2) && !strOptString2.equals(strA)) {
                    C0446ma.a(strOptString2);
                }
            }
            String strOptString3 = jSONObject.optString("oper");
            if (TextUtils.isEmpty(strOptString3)) {
                return;
            }
            N.a().a(qc.b(), strOptString3);
        } catch (Throwable unused2) {
        }
    }

    public final String c() {
        return ServerProtocol.DIALOG_PARAM_STATE;
    }
}
