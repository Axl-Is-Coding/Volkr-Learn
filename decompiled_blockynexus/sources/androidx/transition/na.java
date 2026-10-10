package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
class na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2273a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2275c;

    static ma a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new la(viewGroup) : ka.a(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void b(ViewGroup viewGroup, boolean z) {
        if (f2273a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f2273a = false;
            }
        }
    }

    static void a(ViewGroup viewGroup, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i >= 18) {
            b(viewGroup, z);
        } else {
            pa.a(viewGroup, z);
        }
    }

    static int a(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!f2275c) {
            try {
                f2274b = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                f2274b.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f2275c = true;
        }
        Method method = f2274b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }
}
