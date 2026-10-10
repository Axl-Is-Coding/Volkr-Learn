package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2107a;

    e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2107a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout.b bVar;
        SwipeRefreshLayout swipeRefreshLayout = this.f2107a;
        if (!swipeRefreshLayout.mRefreshing) {
            swipeRefreshLayout.reset();
            return;
        }
        swipeRefreshLayout.mProgress.setAlpha(255);
        this.f2107a.mProgress.start();
        SwipeRefreshLayout swipeRefreshLayout2 = this.f2107a;
        if (swipeRefreshLayout2.mNotify && (bVar = swipeRefreshLayout2.mListener) != null) {
            bVar.onRefresh();
        }
        SwipeRefreshLayout swipeRefreshLayout3 = this.f2107a;
        swipeRefreshLayout3.mCurrentTargetOffsetTop = swipeRefreshLayout3.mCircleView.getTop();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
