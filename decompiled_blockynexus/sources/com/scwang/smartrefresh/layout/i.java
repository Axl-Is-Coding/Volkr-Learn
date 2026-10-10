package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f19170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f19171b;

    i(j jVar, int i) {
        this.f19171b = jVar;
        this.f19170a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ValueAnimator valueAnimatorA;
        SmartRefreshLayout smartRefreshLayout = this.f19171b.f19194e;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA = (!smartRefreshLayout.mEnableScrollContentWhenLoaded || this.f19170a >= 0) ? null : smartRefreshLayout.mRefreshContent.a(smartRefreshLayout.mSpinner);
        if (animatorUpdateListenerA != null) {
            animatorUpdateListenerA.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
        }
        h hVar = new h(this);
        j jVar = this.f19171b;
        SmartRefreshLayout smartRefreshLayout2 = jVar.f19194e;
        int i = smartRefreshLayout2.mSpinner;
        if (i > 0) {
            valueAnimatorA = smartRefreshLayout2.mKernel.a(0);
        } else {
            if (animatorUpdateListenerA != null || i == 0) {
                ValueAnimator valueAnimator = this.f19171b.f19194e.reboundAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f19171b.f19194e.reboundAnimator = null;
                }
                this.f19171b.f19194e.mKernel.a(0, false);
                this.f19171b.f19194e.mKernel.a(RefreshState.None);
            } else if (jVar.f19192c && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData) {
                int i2 = smartRefreshLayout2.mFooterHeight;
                if (i >= (-i2)) {
                    smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                } else {
                    valueAnimatorA = smartRefreshLayout2.mKernel.a(-i2);
                }
            } else {
                valueAnimatorA = this.f19171b.f19194e.mKernel.a(0);
            }
            valueAnimatorA = null;
        }
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(hVar);
        } else {
            hVar.onAnimationEnd(null);
        }
    }
}
