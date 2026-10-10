package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f19195a;

    k(m mVar) {
        this.f19195a = mVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        SmartRefreshLayout smartRefreshLayout = this.f19195a.f19200d;
        if (smartRefreshLayout.reboundAnimator != null) {
            smartRefreshLayout.mKernel.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }
}
