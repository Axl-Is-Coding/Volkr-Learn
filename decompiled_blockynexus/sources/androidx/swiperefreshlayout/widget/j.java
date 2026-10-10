package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class j extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2114a;

    j(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2114a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2114a;
        int iAbs = !swipeRefreshLayout.mUsingCustomStart ? swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop) : swipeRefreshLayout.mSpinnerOffsetEnd;
        SwipeRefreshLayout swipeRefreshLayout2 = this.f2114a;
        this.f2114a.setTargetOffsetTopAndBottom((swipeRefreshLayout2.mFrom + ((int) ((iAbs - r1) * f2))) - swipeRefreshLayout2.mCircleView.getTop());
        this.f2114a.mProgress.a(1.0f - f2);
    }
}
