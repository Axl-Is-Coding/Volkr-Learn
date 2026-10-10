package androidx.core.view;

import android.os.Build;
import android.view.WindowInsets;

/* JADX INFO: compiled from: WindowInsetsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1207a;

    J(Object obj) {
        this.f1207a = obj;
    }

    public J a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new J(((WindowInsets) this.f1207a).consumeSystemWindowInsets());
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1207a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1207a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1207a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1207a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof J) {
            return androidx.core.f.c.a(this.f1207a, ((J) obj).f1207a);
        }
        return false;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1207a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1207a).isConsumed();
        }
        return false;
    }

    public WindowInsets h() {
        return (WindowInsets) this.f1207a;
    }

    public int hashCode() {
        Object obj = this.f1207a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public J a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new J(((WindowInsets) this.f1207a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public static J a(WindowInsets windowInsets) {
        windowInsets.getClass();
        return new J(windowInsets);
    }
}
