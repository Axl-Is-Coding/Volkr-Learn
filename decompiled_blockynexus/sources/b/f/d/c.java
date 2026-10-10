package b.f.d;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdInstanceBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2670b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2671c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f2672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.f.d.g.d f2673e;

    public c(String str, b.f.d.g.d dVar) throws NullPointerException {
        com.ironsource.sdk.utils.i.c(str, "Instance name can't be null");
        this.f2669a = str;
        com.ironsource.sdk.utils.i.a(dVar, "InterstitialListener name can't be null");
        this.f2673e = dVar;
    }

    public c a(Map<String, String> map) {
        this.f2672d = map;
        return this;
    }

    public c b() {
        this.f2671c = true;
        return this;
    }

    public c c() {
        this.f2670b = true;
        return this;
    }

    public b a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f2669a);
            jSONObject.put("rewarded", this.f2670b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new b(f.a(jSONObject), this.f2669a, this.f2670b, this.f2671c, this.f2672d, this.f2673e);
    }
}
