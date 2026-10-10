package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f178e;

    ImmLeaksCleaner(Activity activity) {
        this.f178e = activity;
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f174a == 0) {
            a();
        }
        if (f174a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f178e.getSystemService("input_method");
            try {
                Object obj = f175b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f176c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f177d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    private static void a() {
        try {
            f174a = 2;
            f176c = InputMethodManager.class.getDeclaredField("mServedView");
            f176c.setAccessible(true);
            f177d = InputMethodManager.class.getDeclaredField("mNextServedView");
            f177d.setAccessible(true);
            f175b = InputMethodManager.class.getDeclaredField("mH");
            f175b.setAccessible(true);
            f174a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
