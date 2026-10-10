package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi29.java */
/* JADX INFO: loaded from: classes.dex */
class Aa extends za {
    Aa() {
    }

    @Override // androidx.transition.wa, androidx.transition.Ba
    public void a(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // androidx.transition.wa, androidx.transition.Ba
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.xa, androidx.transition.Ba
    public void c(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // androidx.transition.za, androidx.transition.Ba
    public void a(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // androidx.transition.xa, androidx.transition.Ba
    public void b(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ya, androidx.transition.Ba
    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // androidx.transition.xa, androidx.transition.Ba
    public void a(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }
}
