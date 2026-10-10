package b.f.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdInstance.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f2646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b.f.d.g.d f2647f;
    private boolean g = false;

    b(String str, String str2, boolean z, boolean z2, Map<String, String> map, b.f.d.g.d dVar) {
        this.f2642a = str;
        this.f2643b = str2;
        this.f2644c = z;
        this.f2645d = z2;
        this.f2646e = map;
        this.f2647f = dVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final b.f.d.g.d b() {
        return this.f2647f;
    }

    public String c() {
        return this.f2642a;
    }

    public String d() {
        return this.f2643b;
    }

    public boolean e() {
        return this.f2645d;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.f2644c;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("instanceId", this.f2642a);
        map.put("instanceName", this.f2643b);
        map.put("rewarded", Boolean.toString(this.f2644c));
        map.put("inAppBidding", Boolean.toString(this.f2645d));
        map.put("apiVersion", String.valueOf(2));
        Map<String, String> map2 = this.f2646e;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}
