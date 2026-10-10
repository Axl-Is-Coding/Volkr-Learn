package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19156a;

    e(SmartRefreshLayout smartRefreshLayout) {
        this.f19156a = smartRefreshLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19156a.mKernel.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
    }
}
