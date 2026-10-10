package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ba f2300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property<View, Float> f2301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property<View, Rect> f2302c;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f2300a = new Aa();
        } else if (i >= 23) {
            f2300a = new za();
        } else if (i >= 22) {
            f2300a = new ya();
        } else if (i >= 21) {
            f2300a = new xa();
        } else if (i >= 19) {
            f2300a = new wa();
        } else {
            f2300a = new Ba();
        }
        f2301b = new ta(Float.class, "translationAlpha");
        f2302c = new ua(Rect.class, "clipBounds");
    }

    static void a(View view, float f2) {
        f2300a.a(view, f2);
    }

    static sa b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ra(view) : qa.c(view);
    }

    static float c(View view) {
        return f2300a.b(view);
    }

    static Ga d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new Fa(view) : new Ea(view.getWindowToken());
    }

    static void e(View view) {
        f2300a.c(view);
    }

    static void a(View view) {
        f2300a.a(view);
    }

    static void c(View view, Matrix matrix) {
        f2300a.c(view, matrix);
    }

    static void a(View view, int i) {
        f2300a.a(view, i);
    }

    static void a(View view, Matrix matrix) {
        f2300a.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        f2300a.b(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        f2300a.a(view, i, i2, i3, i4);
    }
}
