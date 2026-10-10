package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: InternalContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f6327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile p<com.bytedance.sdk.openadsdk.c.a> f6328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.j.a f6329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.f.b.a f6330f;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context g;
    private static volatile com.bytedance.sdk.openadsdk.core.g.i h;
    private static volatile com.bytedance.sdk.openadsdk.core.g.h i;

    /* JADX INFO: compiled from: InternalContainer.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f6332a;

        static {
            try {
                Object objB = b();
                f6332a = (Application) objB.getClass().getMethod("getApplication", new Class[0]).invoke(objB, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.o.e("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return f6332a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static synchronized Context a() {
        if (g == null) {
            a(null);
        }
        return g;
    }

    public static void b() {
        f6325a = null;
        f6329e = null;
        f6330f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f6325a == null) {
            synchronized (o.class) {
                if (f6325a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6325a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f6325a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(g), f(), k(), b(g));
                    }
                }
            }
        }
        return f6325a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f6327c == null) {
            synchronized (o.class) {
                if (f6327c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6327c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f6327c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f6327c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f6326b == null) {
            synchronized (o.class) {
                if (f6326b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6326b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f6326b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f6326b;
    }

    public static p<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f6328d == null) {
            synchronized (o.class) {
                if (f6328d == null) {
                    f6328d = new q(g);
                }
            }
        }
        return f6328d;
    }

    public static com.bytedance.sdk.openadsdk.j.a g() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.j.b.d();
        }
        if (f6329e == null) {
            synchronized (com.bytedance.sdk.openadsdk.j.a.class) {
                if (f6329e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6329e = new com.bytedance.sdk.openadsdk.j.c();
                    } else {
                        f6329e = new com.bytedance.sdk.openadsdk.j.b(g, new com.bytedance.sdk.openadsdk.j.h(g));
                    }
                }
            }
        }
        return f6329e;
    }

    public static com.bytedance.sdk.openadsdk.core.g.i h() {
        if (h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.g.i.class) {
                if (h == null) {
                    h = new com.bytedance.sdk.openadsdk.core.g.i();
                }
            }
        }
        return h;
    }

    public static com.bytedance.sdk.openadsdk.core.g.h i() {
        if (i == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.g.i.class) {
                if (i == null) {
                    i = new com.bytedance.sdk.openadsdk.core.g.h();
                    i.b();
                }
            }
        }
        return i;
    }

    public static com.bytedance.sdk.openadsdk.f.b.a j() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.f.b.c.c();
        }
        if (f6330f == null) {
            synchronized (com.bytedance.sdk.openadsdk.f.b.c.class) {
                if (f6330f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6330f = new com.bytedance.sdk.openadsdk.f.b.d();
                    } else {
                        f6330f = new com.bytedance.sdk.openadsdk.f.b.c();
                    }
                }
            }
        }
        return f6330f;
    }

    private static g.b k() {
        return g.b.a();
    }

    public static synchronized void a(Context context) {
        if (g == null) {
            if (a.a() != null) {
                try {
                    g = a.a();
                    if (g != null) {
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            if (context != null) {
                g = context.getApplicationContext();
            }
        }
    }

    private static g.a b(final Context context) {
        return new g.a() { // from class: com.bytedance.sdk.openadsdk.core.o.1
            @Override // com.bytedance.sdk.openadsdk.c.g.a
            public boolean a() {
                Context contextA = context;
                if (contextA == null) {
                    contextA = o.a();
                }
                return com.bytedance.sdk.openadsdk.utils.q.a(contextA);
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
        g.b bVarB;
        com.bytedance.sdk.openadsdk.c.e lVar;
        if (z) {
            lVar = new com.bytedance.sdk.openadsdk.c.n(g);
            bVarB = g.b.a();
        } else {
            bVarB = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(g);
        }
        g.a aVarB = b(g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, bVarB, aVarB, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, bVarB, aVarB));
    }
}
