package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.u;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final v f23007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f23008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final u f23009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final G f23010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map<Class<?>, Object> f23011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile C2942g f23012f;

    C(a aVar) {
        this.f23007a = aVar.f23013a;
        this.f23008b = aVar.f23014b;
        this.f23009c = aVar.f23015c.a();
        this.f23010d = aVar.f23016d;
        this.f23011e = okhttp3.a.e.a(aVar.f23017e);
    }

    public String a(String str) {
        return this.f23009c.b(str);
    }

    public List<String> b(String str) {
        return this.f23009c.c(str);
    }

    public u c() {
        return this.f23009c;
    }

    public boolean d() {
        return this.f23007a.h();
    }

    public String e() {
        return this.f23008b;
    }

    public a f() {
        return new a(this);
    }

    public v g() {
        return this.f23007a;
    }

    public String toString() {
        return "Request{method=" + this.f23008b + ", url=" + this.f23007a + ", tags=" + this.f23011e + '}';
    }

    /* JADX INFO: compiled from: Request.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        v f23013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f23014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        u.a f23015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        G f23016d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Map<Class<?>, Object> f23017e;

        public a() {
            this.f23017e = Collections.emptyMap();
            this.f23014b = "GET";
            this.f23015c = new u.a();
        }

        public a a(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f23013a = vVar;
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            a(v.b(str));
            return this;
        }

        public a a(String str, String str2) {
            this.f23015c.a(str, str2);
            return this;
        }

        public a a(String str) {
            this.f23015c.c(str);
            return this;
        }

        a(C c2) {
            Map<Class<?>, Object> linkedHashMap;
            this.f23017e = Collections.emptyMap();
            this.f23013a = c2.f23007a;
            this.f23014b = c2.f23008b;
            this.f23016d = c2.f23010d;
            if (c2.f23011e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c2.f23011e);
            }
            this.f23017e = linkedHashMap;
            this.f23015c = c2.f23009c.a();
        }

        public a a(u uVar) {
            this.f23015c = uVar.a();
            return this;
        }

        public a a(C2942g c2942g) {
            String string = c2942g.toString();
            if (string.isEmpty()) {
                a("Cache-Control");
                return this;
            }
            b("Cache-Control", string);
            return this;
        }

        public a b(String str, String str2) {
            this.f23015c.c(str, str2);
            return this;
        }

        public a a(String str, G g) {
            if (str != null) {
                if (str.length() != 0) {
                    if (g != null && !okhttp3.internal.http.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (g == null && okhttp3.internal.http.f.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.f23014b = str;
                    this.f23016d = g;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public <T> a a(Class<? super T> cls, T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.f23017e.remove(cls);
            } else {
                if (this.f23017e.isEmpty()) {
                    this.f23017e = new LinkedHashMap();
                }
                this.f23017e.put(cls, cls.cast(t));
            }
            return this;
        }

        public C a() {
            if (this.f23013a != null) {
                return new C(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public G a() {
        return this.f23010d;
    }

    public C2942g b() {
        C2942g c2942g = this.f23012f;
        if (c2942g != null) {
            return c2942g;
        }
        C2942g c2942gA = C2942g.a(this.f23009c);
        this.f23012f = c2942gA;
        return c2942gA;
    }

    public <T> T a(Class<? extends T> cls) {
        return cls.cast(this.f23011e.get(cls));
    }
}
