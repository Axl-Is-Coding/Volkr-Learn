package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class i implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2113a;

    i(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2113a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2113a;
        if (swipeRefreshLayout.mScale) {
            return;
        }
        swipeRefreshLayout.startScaleDownAnimation(null);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
