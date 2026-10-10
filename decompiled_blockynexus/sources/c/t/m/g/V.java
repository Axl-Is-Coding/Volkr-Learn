package c.t.m.g;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class V extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    U f3024a = new U("HttpSchedulerHandler");

    @Override // c.t.m.g.T, c.t.m.g.E
    public final void a() {
        fc.j().post(new W(this, null, null));
    }

    public final String c() {
        return "accessscheduler";
    }

    @Override // c.t.m.g.T
    public final void a(O o) {
        String string;
        JSONObject jSONObject;
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                U u = this.f3024a;
                qc.e();
                byte[] bArrA = u.a(qc.b());
                JSONObject jSONObject3 = !C0455pa.a(bArrA) ? new JSONObject(new String(bArrA)) : null;
                if (jSONObject3 != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("resultMap");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    JSONObject jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i);
                                    jSONObject4.put(jSONObject5.optString("unit"), jSONObject5.optString("schedulecode"));
                                }
                                jSONObject2.put(next, jSONObject4);
                            }
                        }
                        o.f2968a.put("directScheduleCodes", jSONObject2);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(fc.c());
                    string = sb.toString();
                    jSONObject = new JSONObject();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(fc.c());
                    string = sb2.toString();
                    jSONObject = new JSONObject();
                }
                jSONObject2.put(string, jSONObject);
                o.f2968a.put("directScheduleCodes", jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
            JSONObject jSONObject6 = new JSONObject();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(fc.c());
            jSONObject6.put(sb3.toString(), new JSONObject());
            o.f2968a.put("directScheduleCodes", jSONObject6);
        }
    }

    @Override // c.t.m.g.T
    public final void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (jSONObjectOptJSONObject != null) {
                String string = jSONObjectOptJSONObject.toString();
                if (C0455pa.a(string)) {
                    return;
                }
                byte[] bytes = string.getBytes();
                if (C0455pa.a(bytes)) {
                    return;
                }
                String strB = qc.b();
                this.f3024a.a(strB, bytes);
                fc.j().post(new W(this, strB, bytes));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
