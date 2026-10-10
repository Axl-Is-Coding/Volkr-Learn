package androidx.customview.b;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Interpolator {
    e() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}
