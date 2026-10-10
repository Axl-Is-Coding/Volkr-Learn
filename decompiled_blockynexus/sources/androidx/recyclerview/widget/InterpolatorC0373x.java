package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class InterpolatorC0373x implements Interpolator {
    InterpolatorC0373x() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        return f2 * f2 * f2 * f2 * f2;
    }
}
