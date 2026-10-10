package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
class za extends ya {
    private static boolean k = true;

    za() {
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i);
        } else if (k) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }
}
