package com.google.android.material.appbar;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: CollapsingToolbarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollapsingToolbarLayout f13131a;

    f(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f13131a = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13131a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
