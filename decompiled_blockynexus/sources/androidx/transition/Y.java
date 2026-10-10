package androidx.transition;

import android.graphics.Path;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
class Y extends PathMotion {
    Y() {
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }
}
