package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f19164a;

    h(i iVar) {
        this.f19164a = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        j jVar = this.f19164a.f19171b;
        SmartRefreshLayout smartRefreshLayout = jVar.f19194e;
        smartRefreshLayout.mFooterLocked = false;
        if (jVar.f19192c) {
            smartRefreshLayout.setNoMoreData(true);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f19164a.f19171b.f19194e;
        if (smartRefreshLayout2.mState == RefreshState.LoadFinish) {
            smartRefreshLayout2.notifyStateChanged(RefreshState.None);
        }
    }
}
