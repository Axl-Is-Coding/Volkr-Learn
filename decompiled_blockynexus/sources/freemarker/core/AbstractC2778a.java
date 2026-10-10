package freemarker.core;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: freemarker.core.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArithmeticEngine.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2778a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0192a f21507a = new C0192a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f21508b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21512f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    protected int k = 12;
    protected int l = 12;
    protected int m = 4;

    /* JADX INFO: renamed from: freemarker.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArithmeticEngine.java */
    public static class C0192a extends AbstractC2778a {
    }

    /* JADX INFO: renamed from: freemarker.core.a$b */
    /* JADX INFO: compiled from: ArithmeticEngine.java */
    public static class b extends AbstractC2778a {
        private static final Map n = a();

        private static Map a() throws Throwable {
            HashMap map = new HashMap(17);
            Integer num = new Integer(0);
            Class clsA = AbstractC2778a.f21509c;
            if (clsA == null) {
                clsA = AbstractC2778a.a("java.lang.Byte");
                AbstractC2778a.f21509c = clsA;
            }
            map.put(clsA, num);
            Class clsA2 = AbstractC2778a.f21510d;
            if (clsA2 == null) {
                clsA2 = AbstractC2778a.a("java.lang.Short");
                AbstractC2778a.f21510d = clsA2;
            }
            map.put(clsA2, num);
            Class clsA3 = AbstractC2778a.f21511e;
            if (clsA3 == null) {
                clsA3 = AbstractC2778a.a("java.lang.Integer");
                AbstractC2778a.f21511e = clsA3;
            }
            map.put(clsA3, num);
            Class clsA4 = AbstractC2778a.f21512f;
            if (clsA4 == null) {
                clsA4 = AbstractC2778a.a("java.lang.Long");
                AbstractC2778a.f21512f = clsA4;
            }
            map.put(clsA4, new Integer(1));
            Class clsA5 = AbstractC2778a.g;
            if (clsA5 == null) {
                clsA5 = AbstractC2778a.a("java.lang.Float");
                AbstractC2778a.g = clsA5;
            }
            map.put(clsA5, new Integer(2));
            Class clsA6 = AbstractC2778a.h;
            if (clsA6 == null) {
                clsA6 = AbstractC2778a.a("java.lang.Double");
                AbstractC2778a.h = clsA6;
            }
            map.put(clsA6, new Integer(3));
            Class clsA7 = AbstractC2778a.i;
            if (clsA7 == null) {
                clsA7 = AbstractC2778a.a("java.math.BigInteger");
                AbstractC2778a.i = clsA7;
            }
            map.put(clsA7, new Integer(4));
            Class clsA8 = AbstractC2778a.j;
            if (clsA8 == null) {
                clsA8 = AbstractC2778a.a("java.math.BigDecimal");
                AbstractC2778a.j = clsA8;
            }
            map.put(clsA8, new Integer(5));
            return map;
        }
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
