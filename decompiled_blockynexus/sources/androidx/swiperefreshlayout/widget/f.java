package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class f extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2108a;

    f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2108a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        this.f2108a.setAnimationProgress(f2);
    }
}
