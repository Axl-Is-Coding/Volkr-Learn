package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import c.t.m.g.qc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class X implements InterfaceC0425fa, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3039a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static X f3040b = new X();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public L f3041c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f3043e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3042d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, T> f3044f = new ConcurrentHashMap();
    private Runnable g = new RunnableC0413ba(this);
    private Runnable h = new RunnableC0419da(this);
    private Runnable i = new RunnableC0422ea(this);
    private Map<String, a> j = new HashMap();

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f3045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3046b;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private X() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(String str) {
        JSONObject jSONObjectOptJSONObject;
        byte b2 = 0;
        if (this.j.isEmpty()) {
            try {
                String strB = C0446ma.b("apnrecords", "");
                if (!strB.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(strB);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(next)) != null) {
                            a aVar = new a(b2);
                            aVar.f3046b = jSONObjectOptJSONObject.optInt("lastCode");
                            aVar.f3045a = jSONObjectOptJSONObject.optLong("lastReqTime");
                            this.j.put(next, aVar);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = this.j.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        a aVar3 = new a(b2);
        this.j.put(str, aVar3);
        return aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i) {
        return qc.a.a(i == 0 ? "http_platform_update_interval_succ" : (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail", 60000, 3600000, i == 0 ? com.tendcloud.tenddata.ab.P : (i == -4 || i == -3) ? 60000 : 300000);
    }

    public static X c() {
        return f3040b;
    }

    static /* synthetic */ int e() {
        f3039a = 2;
        return 2;
    }

    static /* synthetic */ void e(X x) {
        if (x.j.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, a> entry : x.j.entrySet()) {
            a value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("lastCode", value.f3046b);
                jSONObject2.put("lastReqTime", value.f3045a);
                jSONObject.put(entry.getKey(), jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        C0446ma.a("apnrecords", jSONObject.toString());
    }

    @Override // c.t.m.g.E
    public final void a() {
        this.f3044f.get("accessscheduler").a();
    }

    @Override // c.t.m.g.InterfaceC0425fa
    public final void a(L l) {
        this.f3041c = l;
        C0416ca c0416ca = new C0416ca();
        this.f3044f.put(c0416ca.c(), c0416ca);
        V v = new V();
        this.f3044f.put(v.c(), v);
        Y y = new Y();
        this.f3044f.put(y.c(), y);
    }

    @Override // c.t.m.g.E
    public final void b() {
        this.f3044f.get("settings").b();
    }

    @Override // c.t.m.g.InterfaceC0425fa
    public final void d() {
        this.f3043e = qc.a.a("HttpPlatformConnection");
        this.f3043e.post(this);
        this.f3041c.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (qc.a.a("http_platform_start_update_on", 0, 1, 0) == 1) {
            f3039a = 1;
            this.f3043e.post(this.i);
        }
    }

    @Override // c.t.m.g.E
    public final void a(int i) {
        if (i == 1 || i == 2) {
            this.f3043e.removeCallbacks(this.h);
            this.f3043e.post(this.h);
        } else if (i == 3 || i == 4) {
            C0430h.a().a(this.g, false, c(0) + (new Random().nextInt(qc.a.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60 * 1000));
        }
    }

    static /* synthetic */ void a(X x) {
        x.f3043e.removeCallbacks(x.h);
        x.f3043e.post(x.h);
    }
}
