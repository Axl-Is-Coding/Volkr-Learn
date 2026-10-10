package c.t.m.g;

import android.content.SharedPreferences;
import c.t.m.g.Ya;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class Ha implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static volatile String f2918a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile String f2919b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static volatile String f2920c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f2921d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Ha f2922e = null;
    private volatile ConcurrentHashMap<String, String> g;
    volatile ConcurrentHashMap<String, List<Ya.a>> h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<Class<?>, Object> f2923f = new HashMap<>();
    private volatile boolean i = false;

    private Ha() {
        this.g = null;
        this.h = null;
        this.g = new ConcurrentHashMap<>(((f2921d.size() << 2) / 3) + 1);
        this.h = new ConcurrentHashMap<>(((f2921d.size() << 2) / 3) + 1);
        this.f2923f.put(String.class, "");
        this.f2923f.put(Integer.class, Integer.MIN_VALUE);
        this.f2923f.put(Float.class, Float.valueOf(Float.MIN_VALUE));
        this.f2923f.put(Double.class, Double.valueOf(Double.MIN_VALUE));
        this.f2923f.put(Long.class, Long.MIN_VALUE);
        this.f2923f.put(Boolean.class, Boolean.FALSE);
        c();
    }

    protected static void a(String str, String str2) {
        f2918a = str;
        f2920c = str2;
        b("app_version", str2);
    }

    private static void b(String str, String str2) throws IllegalStateException {
        f2921d.put(str, str2);
    }

    private void c() {
        try {
            d();
            b();
        } catch (Throwable th) {
            C0458qa.a(th.getMessage(), th);
        }
    }

    private static void d() {
        SharedPreferences sharedPreferencesB = Ja.a().b();
        if (sharedPreferencesB == null) {
            return;
        }
        String str = (String) _a.b(sharedPreferencesB, "app_version", "");
        if (f2920c.length() <= 0 || f2920c.equals(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder("clear sp > pre:");
        sb.append(str);
        sb.append(",now:");
        sb.append(f2920c);
        sharedPreferencesB.edit().clear().apply();
        _a.a(sharedPreferencesB, "app_version", f2920c);
    }

    private void f(String str) {
        if (f2921d.get(str) == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesB = Ja.a().b();
            if (sharedPreferencesB != null) {
                this.g.put(str, sharedPreferencesB.getString(str, g(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String g(String str) {
        if (f2921d.containsKey(str)) {
            return f2921d.get(str);
        }
        throw new NullPointerException("Not exists property name \"" + str + "\"");
    }

    public final String e(String str) {
        return (String) a(str, String.class);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str = obj == null ? null : (String) obj;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = "update [" + str + "] : " + this.g.get(str) + " --> ";
        f(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(this.g.get(str));
        List<Ya.a> list = this.h.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Ya.a> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    protected final void b() {
        if (Ja.a().b() == null) {
            return;
        }
        Iterator<String> it = f2921d.keySet().iterator();
        while (it.hasNext()) {
            f(it.next());
        }
        this.i = true;
        new StringBuilder("---> read xml:").append(this.g.toString());
    }

    protected static void a(HashMap<String, String> map) {
        b("cc_version", "-1");
        b("cc_req_interval", "10800000");
        b("last_pull_time", "0");
        for (String str : map.keySet()) {
            b(str, map.get(str));
        }
    }

    public final long c(String str) {
        return ((Long) a(str, Long.class)).longValue();
    }

    public final boolean d(String str) {
        return ((Boolean) a(str, Boolean.class)).booleanValue();
    }

    protected static void a(String str) {
        f2919b = str;
    }

    public final int b(String str) {
        return ((Integer) a(str, Integer.class)).intValue();
    }

    public static synchronized Ha a() {
        if (f2922e == null) {
            synchronized (Ha.class) {
                f2922e = new Ha();
            }
        }
        return f2922e;
    }

    private static Object b(String str, Class<?> cls) {
        if (cls == Integer.class) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (cls == Long.class) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (cls == Boolean.class) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (cls == Float.class) {
            return Float.valueOf(Float.parseFloat(str));
        }
        return cls == Double.class ? Double.valueOf(Double.parseDouble(str)) : str;
    }

    private final Object a(String str, Class<?> cls) {
        if (!this.i) {
            c();
        }
        if (this.f2923f.containsKey(cls)) {
            String str2 = this.g.get(str);
            if (str2 == null || str2.length() == 0) {
                str2 = f2921d.get(str);
            }
            if (str2 == null) {
                str2 = "";
            }
            try {
                try {
                    return b(str2, cls);
                } catch (Throwable unused) {
                    return this.f2923f.get(cls);
                }
            } catch (Throwable unused2) {
                return b(f2921d.get(str), cls);
            }
        }
        throw new IllegalStateException("The property \"" + str + "\" don't support class type \"" + cls.toString() + "\"");
    }
}
