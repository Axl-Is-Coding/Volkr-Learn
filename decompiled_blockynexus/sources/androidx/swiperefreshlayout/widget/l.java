package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class l extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2116a;

    l(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2116a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2116a;
        float f3 = swipeRefreshLayout.mStartingScale;
        swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
        this.f2116a.moveToStart(f2);
    }
}
