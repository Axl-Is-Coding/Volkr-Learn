package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
class pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LayoutTransition f2277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f2280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f2281e;

    static void a(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (f2277a == null) {
            f2277a = new oa();
            f2277a.setAnimator(2, null);
            f2277a.setAnimator(0, null);
            f2277a.setAnimator(1, null);
            f2277a.setAnimator(3, null);
            f2277a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f2277a) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f2277a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f2279c) {
            try {
                f2278b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f2278b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f2279c = true;
        }
        Field field = f2278b;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f2278b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f2281e) {
            try {
                f2280d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2280d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f2281e = true;
        }
        Method method = f2280d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
