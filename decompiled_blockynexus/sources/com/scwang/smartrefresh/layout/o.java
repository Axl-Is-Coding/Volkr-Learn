package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f19202a;

    o(p pVar) {
        this.f19202a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SmartRefreshLayout smartRefreshLayout = this.f19202a.f19206d;
        if (smartRefreshLayout.reboundAnimator != null) {
            smartRefreshLayout.reboundAnimator = null;
            RefreshState refreshState = smartRefreshLayout.mState;
            RefreshState refreshState2 = RefreshState.ReleaseToLoad;
            if (refreshState != refreshState2) {
                smartRefreshLayout.mKernel.a(refreshState2);
            }
            this.f19202a.f19206d.setStateLoading(!r3.f19205c);
        }
    }
}
