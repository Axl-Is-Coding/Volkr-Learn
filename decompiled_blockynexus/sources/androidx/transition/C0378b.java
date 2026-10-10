package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: androidx.transition.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CanvasUtils.java */
/* JADX INFO: loaded from: classes.dex */
class C0378b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2224c;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void a(Canvas canvas, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i >= 29) {
            if (z) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f2224c) {
            try {
                f2222a = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                f2222a.setAccessible(true);
                f2223b = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                f2223b.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f2224c = true;
        }
        if (z) {
            try {
                if (f2222a != null) {
                    f2222a.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        if (z || f2223b == null) {
            return;
        }
        f2223b.invoke(canvas, new Object[0]);
    }
}
