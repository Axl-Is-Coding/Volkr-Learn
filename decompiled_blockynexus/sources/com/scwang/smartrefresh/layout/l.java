package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f19196a;

    l(m mVar) {
        this.f19196a = mVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SmartRefreshLayout smartRefreshLayout = this.f19196a.f19200d;
        if (smartRefreshLayout.reboundAnimator != null) {
            smartRefreshLayout.reboundAnimator = null;
            RefreshState refreshState = smartRefreshLayout.mState;
            RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
            if (refreshState != refreshState2) {
                smartRefreshLayout.mKernel.a(refreshState2);
            }
            this.f19196a.f19200d.setStateRefreshing(!r3.f19199c);
        }
    }
}
