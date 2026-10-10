package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: GhostViewPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class D implements B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f2153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f2155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f2157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2158f;
    private final View g;

    private D(View view) {
        this.g = view;
    }

    static B a(View view, ViewGroup viewGroup, Matrix matrix) {
        a();
        Method method = f2155c;
        if (method != null) {
            try {
                return new D((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void b() {
        if (f2154b) {
            return;
        }
        try {
            f2153a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f2154b = true;
    }

    private static void c() {
        if (f2158f) {
            return;
        }
        try {
            b();
            f2157e = f2153a.getDeclaredMethod("removeGhost", View.class);
            f2157e.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f2158f = true;
    }

    @Override // androidx.transition.B
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.B
    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }

    static void a(View view) {
        c();
        Method method = f2157e;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void a() {
        if (f2156d) {
            return;
        }
        try {
            b();
            f2155c = f2153a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f2155c.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        f2156d = true;
    }
}
