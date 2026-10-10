package b.f.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventData.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f2606c;

    public b(int i, long j, JSONObject jSONObject) {
        this.f2604a = -1;
        this.f2605b = -1L;
        this.f2604a = i;
        this.f2605b = j;
        if (jSONObject == null) {
            this.f2606c = new JSONObject();
        } else {
            this.f2606c = jSONObject;
        }
    }

    public String a() {
        return this.f2606c.toString();
    }

    public JSONObject b() {
        return this.f2606c;
    }

    public int c() {
        return this.f2604a;
    }

    public long d() {
        return this.f2605b;
    }

    public void a(int i) {
        this.f2604a = i;
    }

    public void a(String str, Object obj) {
        try {
            this.f2606c.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public b(int i, JSONObject jSONObject) {
        this.f2604a = -1;
        this.f2605b = -1L;
        this.f2604a = i;
        this.f2605b = System.currentTimeMillis();
        if (jSONObject == null) {
            this.f2606c = new JSONObject();
        } else {
            this.f2606c = jSONObject;
        }
    }
}
