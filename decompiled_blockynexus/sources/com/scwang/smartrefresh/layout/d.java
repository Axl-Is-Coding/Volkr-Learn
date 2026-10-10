package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19155a;

    d(SmartRefreshLayout smartRefreshLayout) {
        this.f19155a = smartRefreshLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        RefreshState refreshState;
        RefreshState refreshState2;
        SmartRefreshLayout smartRefreshLayout = this.f19155a;
        smartRefreshLayout.reboundAnimator = null;
        if (smartRefreshLayout.mSpinner == 0 && (refreshState = smartRefreshLayout.mState) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
            smartRefreshLayout.notifyStateChanged(refreshState2);
            return;
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f19155a;
        RefreshState refreshState3 = smartRefreshLayout2.mState;
        if (refreshState3 != smartRefreshLayout2.mViceState) {
            smartRefreshLayout2.setViceState(refreshState3);
        }
    }
}
