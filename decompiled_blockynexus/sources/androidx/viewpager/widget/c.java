package androidx.viewpager.widget;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: ViewPager.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Interpolator {
    c() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}
