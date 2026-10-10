package c.t.m.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class G extends F implements pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    U f2905a = new U("HttpSchedulerClient");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    nc f2906b;

    @Override // c.t.m.g.F, c.t.m.g.L
    public final void a(String str, byte[] bArr, String str2) {
        this.f2905a.a(str, bArr);
        fc.j().post(new H(this));
    }

    public final String b() {
        return "accessscheduler";
    }

    @Override // c.t.m.g.F, c.t.m.g.L
    public final void c() {
        C0434ia.d().a();
    }

    @Override // c.t.m.g.pc
    public final List<oc> a() {
        nc ncVar = this.f2906b;
        if (ncVar == null || !ncVar.f3318a.equals(qc.b())) {
            fc.j().post(new H(this));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, oc>> it = this.f2906b.f3319b.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    static void a(nc ncVar, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("domains");
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("resultlist");
                String strOptString = jSONObject.optString("schedulecode");
                String strOptString2 = jSONObject.optString("httpsport");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        oc ocVar = new oc(jSONArrayOptJSONArray.getString(i2), strOptString);
                        try {
                            ocVar.f3336d = Integer.parseInt(strOptString2);
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                String string = jSONArrayOptJSONArray2.getString(i3);
                                gc gcVar = new gc();
                                if (gcVar.a(string)) {
                                    ocVar.f3335c.add(gcVar);
                                }
                            }
                            ncVar.f3319b.put(ocVar.f3333a, ocVar);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
