package com.google.common.base;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: Throwables.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f13771a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f13772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f13773c;

    static {
        f13772b = f13771a == null ? null : a();
        f13773c = f13771a != null ? c() : null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public static <X extends Throwable> void a(Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void b(Throwable th) throws Throwable {
        a(th, Error.class);
        a(th, RuntimeException.class);
    }

    private static Method c() {
        return a("getStackTraceDepth", (Class<?>[]) new Class[]{Throwable.class});
    }

    public static RuntimeException a(Throwable th) throws Throwable {
        m.a(th);
        b(th);
        throw new RuntimeException(th);
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a() {
        return a("getStackTraceElement", (Class<?>[]) new Class[]{Throwable.class, Integer.TYPE});
    }

    private static Method a(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }
}
