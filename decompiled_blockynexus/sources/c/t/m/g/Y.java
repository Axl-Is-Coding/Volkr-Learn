package c.t.m.g;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0427g f3056a = new C0427g();

    public Y() {
        fc.j().post(new Z(this));
    }

    static String d() {
        fc.b();
        return "Halley_Cloud_Param_Content_" + fc.c() + "_for_SettingsHandler";
    }

    @Override // c.t.m.g.T
    public final void a(O o) {
        o.f2968a.put("confVersion", this.f3056a.c());
    }

    @Override // c.t.m.g.T, c.t.m.g.E
    public final void b() {
        fc.j().post(new RunnableC0410aa(this));
    }

    public final String c() {
        return "settings";
    }

    @Override // c.t.m.g.T
    public final void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("Setting");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("data");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.f3056a.a(strOptString);
                    fc.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", this.f3056a.a()).commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        } finally {
            fc.j().post(new RunnableC0410aa(this));
        }
    }
}
