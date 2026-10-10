package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f19201a;

    n(p pVar) {
        this.f19201a = pVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        SmartRefreshLayout smartRefreshLayout = this.f19201a.f19206d;
        if (smartRefreshLayout.reboundAnimator != null) {
            smartRefreshLayout.mKernel.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }
}
