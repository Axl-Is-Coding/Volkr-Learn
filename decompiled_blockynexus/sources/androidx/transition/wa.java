package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
class wa extends Ba {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2305f = true;

    wa() {
    }

    @Override // androidx.transition.Ba
    public void a(View view) {
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public void a(View view, float f2) {
        if (f2305f) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f2305f = false;
            }
        }
        view.setAlpha(f2);
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f2305f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2305f = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.Ba
    public void c(View view) {
    }
}
