package freemarker.ext.beans;

import com.uc.crashsdk.export.LogType;

/* JADX INFO: compiled from: TypeFlags.java */
/* JADX INFO: loaded from: classes5.dex */
class sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static /* synthetic */ Class f21633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21638f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    static /* synthetic */ Class q;

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static int a(Class cls) throws Throwable {
        Class clsA = f21633a;
        if (clsA == null) {
            clsA = a("java.lang.Object");
            f21633a = clsA;
        }
        if (cls == clsA) {
            return 522240;
        }
        Class clsA2 = f21634b;
        if (clsA2 == null) {
            clsA2 = a("java.lang.String");
            f21634b = clsA2;
        }
        if (cls == clsA2) {
            return 8192;
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return 2064;
            }
            if (cls == Long.TYPE) {
                return 2080;
            }
            if (cls == Double.TYPE) {
                return 2176;
            }
            if (cls == Float.TYPE) {
                return 2112;
            }
            if (cls == Byte.TYPE) {
                return 2052;
            }
            if (cls == Short.TYPE) {
                return 2056;
            }
            if (cls == Character.TYPE) {
                return 524288;
            }
            return cls == Boolean.TYPE ? 16384 : 0;
        }
        Class clsA3 = f21635c;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Number");
            f21635c = clsA3;
        }
        if (!clsA3.isAssignableFrom(cls)) {
            if (cls.isArray()) {
                return 262144;
            }
            Class<?> clsA4 = f21634b;
            if (clsA4 == null) {
                clsA4 = a("java.lang.String");
                f21634b = clsA4;
            }
            int i2 = cls.isAssignableFrom(clsA4) ? 8192 : 0;
            Class<?> clsA5 = l;
            if (clsA5 == null) {
                clsA5 = a("java.util.Date");
                l = clsA5;
            }
            if (cls.isAssignableFrom(clsA5)) {
                i2 |= 4096;
            }
            Class<?> clsA6 = m;
            if (clsA6 == null) {
                clsA6 = a("java.lang.Boolean");
                m = clsA6;
            }
            if (cls.isAssignableFrom(clsA6)) {
                i2 |= 16384;
            }
            Class<?> clsA7 = n;
            if (clsA7 == null) {
                clsA7 = a("java.util.Map");
                n = clsA7;
            }
            if (cls.isAssignableFrom(clsA7)) {
                i2 |= 32768;
            }
            Class<?> clsA8 = o;
            if (clsA8 == null) {
                clsA8 = a("java.util.List");
                o = clsA8;
            }
            if (cls.isAssignableFrom(clsA8)) {
                i2 |= 65536;
            }
            Class<?> clsA9 = p;
            if (clsA9 == null) {
                clsA9 = a("java.util.Set");
                p = clsA9;
            }
            if (cls.isAssignableFrom(clsA9)) {
                i2 |= 131072;
            }
            Class clsA10 = q;
            if (clsA10 == null) {
                clsA10 = a("java.lang.Character");
                q = clsA10;
            }
            return cls == clsA10 ? i2 | 524288 : i2;
        }
        Class clsA11 = f21636d;
        if (clsA11 == null) {
            clsA11 = a("java.lang.Integer");
            f21636d = clsA11;
        }
        if (cls == clsA11) {
            return 2064;
        }
        Class clsA12 = f21637e;
        if (clsA12 == null) {
            clsA12 = a("java.lang.Long");
            f21637e = clsA12;
        }
        if (cls == clsA12) {
            return 2080;
        }
        Class clsA13 = f21638f;
        if (clsA13 == null) {
            clsA13 = a("java.lang.Double");
            f21638f = clsA13;
        }
        if (cls == clsA13) {
            return 2176;
        }
        Class clsA14 = g;
        if (clsA14 == null) {
            clsA14 = a("java.lang.Float");
            g = clsA14;
        }
        if (cls == clsA14) {
            return 2112;
        }
        Class clsA15 = h;
        if (clsA15 == null) {
            clsA15 = a("java.lang.Byte");
            h = clsA15;
        }
        if (cls == clsA15) {
            return 2052;
        }
        Class clsA16 = i;
        if (clsA16 == null) {
            clsA16 = a("java.lang.Short");
            i = clsA16;
        }
        if (cls == clsA16) {
            return 2056;
        }
        Class clsA17 = j;
        if (clsA17 == null) {
            clsA17 = a("java.math.BigDecimal");
            j = clsA17;
        }
        if (clsA17.isAssignableFrom(cls)) {
            return 2560;
        }
        Class clsA18 = k;
        if (clsA18 == null) {
            clsA18 = a("java.math.BigInteger");
            k = clsA18;
        }
        if (clsA18.isAssignableFrom(cls)) {
            return LogType.UNEXP_LOW_MEMORY;
        }
        return 3072;
    }
}
