package freemarker.core;

import freemarker.template.utility.UndeclaredThrowableException;
import java.lang.reflect.Constructor;
import java.util.Map;

/* JADX INFO: compiled from: _ConcurrentMapFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class f21513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f21514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f21515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f21516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21517e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.reflect.Constructor] */
    static {
        Class clsB;
        Class clsB2;
        ?? r0;
        try {
            clsB = freemarker.template.utility.a.b("java.util.concurrent.ConcurrentMap");
        } catch (ClassNotFoundException unused) {
            clsB = null;
        }
        f21513a = clsB;
        ?? constructor = 1;
        constructor = 1;
        constructor = 1;
        int i = 3;
        try {
            clsB2 = freemarker.template.utility.a.b("java.util.concurrent.ConcurrentHashMap");
            try {
                constructor = clsB2.getConstructor(Integer.TYPE, Float.TYPE, Integer.TYPE);
                r0 = constructor;
            } catch (Exception e2) {
                throw new RuntimeException("Failed to get ConcurrentHashMap constructor", e2);
            }
        } catch (ClassNotFoundException unused2) {
            Class clsA = f21517e;
            if (clsA == null) {
                clsA = a("java.util.HashMap");
                f21517e = clsA;
            }
            clsB2 = clsA;
            try {
                Class<?>[] clsArr = new Class[2];
                clsArr[0] = Integer.TYPE;
                clsArr[constructor] = Float.TYPE;
                Constructor constructor2 = clsB2.getConstructor(clsArr);
                i = 2;
                r0 = constructor2;
            } catch (Exception e3) {
                throw new RuntimeException("Failed to get HashMap constructor", e3);
            }
        }
        f21514b = clsB2;
        f21515c = r0;
        f21516d = i;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static Map a() {
        try {
            return (Map) f21514b.newInstance();
        } catch (Exception e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    public static Map a(int i, float f2, int i2) {
        try {
            if (f21516d == 3) {
                return (Map) f21515c.newInstance(new Integer(i), new Float(f2), new Integer(i2));
            }
            if (f21516d == 2) {
                return (Map) f21515c.newInstance(new Integer(i), new Float(f2));
            }
            throw new BugException();
        } catch (Exception e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    public static boolean a(Map map) {
        Class cls = f21513a;
        return cls != null && cls.isInstance(map);
    }
}
