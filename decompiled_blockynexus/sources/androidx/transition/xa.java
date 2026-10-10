package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
class xa extends wa {
    private static boolean g = true;
    private static boolean h = true;
    private static boolean i = true;

    xa() {
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public void a(View view, Matrix matrix) {
        if (g) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public void b(View view, Matrix matrix) {
        if (h) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }

    @Override // androidx.transition.Ba
    @SuppressLint({"NewApi"})
    public void c(View view, Matrix matrix) {
        if (i) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }
}
