package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class InterpolatorC0374y implements Interpolator {
    InterpolatorC0374y() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}
