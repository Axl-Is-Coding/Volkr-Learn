package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f19197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f19198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f19199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19200d;

    m(SmartRefreshLayout smartRefreshLayout, float f2, int i, boolean z) {
        this.f19200d = smartRefreshLayout;
        this.f19197a = f2;
        this.f19198b = i;
        this.f19199c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SmartRefreshLayout smartRefreshLayout = this.f19200d;
        if (smartRefreshLayout.mViceState != RefreshState.Refreshing) {
            return;
        }
        ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f19200d.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
        this.f19200d.mKernel.a(RefreshState.PullDownToRefresh);
        SmartRefreshLayout smartRefreshLayout2 = this.f19200d;
        smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, (int) (smartRefreshLayout2.mHeaderHeight * this.f19197a));
        this.f19200d.reboundAnimator.setDuration(this.f19198b);
        this.f19200d.reboundAnimator.setInterpolator(new com.scwang.smartrefresh.layout.c.c(com.scwang.smartrefresh.layout.c.c.f19137a));
        this.f19200d.reboundAnimator.addUpdateListener(new k(this));
        this.f19200d.reboundAnimator.addListener(new l(this));
        this.f19200d.reboundAnimator.start();
    }
}
