package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppBarLayout f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppBarLayout.BaseBehavior f13129c;

    c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f13129c = baseBehavior;
        this.f13127a = coordinatorLayout;
        this.f13128b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13129c.c(this.f13127a, this.f13128b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
