package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f19203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f19204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f19205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19206d;

    p(SmartRefreshLayout smartRefreshLayout, float f2, int i, boolean z) {
        this.f19206d = smartRefreshLayout;
        this.f19203a = f2;
        this.f19204b = i;
        this.f19205c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SmartRefreshLayout smartRefreshLayout = this.f19206d;
        if (smartRefreshLayout.mViceState != RefreshState.Loading) {
            return;
        }
        ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f19206d.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
        this.f19206d.mKernel.a(RefreshState.PullUpToLoad);
        SmartRefreshLayout smartRefreshLayout2 = this.f19206d;
        smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, -((int) (smartRefreshLayout2.mFooterHeight * this.f19203a)));
        this.f19206d.reboundAnimator.setDuration(this.f19204b);
        this.f19206d.reboundAnimator.setInterpolator(new com.scwang.smartrefresh.layout.c.c(com.scwang.smartrefresh.layout.c.c.f19137a));
        this.f19206d.reboundAnimator.addUpdateListener(new n(this));
        this.f19206d.reboundAnimator.addListener(new o(this));
        this.f19206d.reboundAnimator.start();
    }
}
