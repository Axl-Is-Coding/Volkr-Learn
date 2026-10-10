package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f19134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19135b;

    c(SmartRefreshLayout smartRefreshLayout, boolean z) {
        this.f19135b = smartRefreshLayout;
        this.f19134a = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f19135b.mLastOpenTime = System.currentTimeMillis();
        this.f19135b.notifyStateChanged(RefreshState.Refreshing);
        SmartRefreshLayout smartRefreshLayout = this.f19135b;
        com.scwang.smartrefresh.layout.b.d dVar = smartRefreshLayout.mRefreshListener;
        if (dVar != null) {
            if (this.f19134a) {
                dVar.b(smartRefreshLayout);
            }
        } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
            smartRefreshLayout.finishRefresh(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f19135b;
        com.scwang.smartrefresh.layout.a.h hVar = smartRefreshLayout2.mRefreshHeader;
        if (hVar != null) {
            int i = smartRefreshLayout2.mHeaderHeight;
            hVar.onStartAnimator(smartRefreshLayout2, i, (int) (smartRefreshLayout2.mHeaderMaxDragRate * i));
        }
        SmartRefreshLayout smartRefreshLayout3 = this.f19135b;
        com.scwang.smartrefresh.layout.b.c cVar = smartRefreshLayout3.mOnMultiPurposeListener;
        if (cVar == null || !(smartRefreshLayout3.mRefreshHeader instanceof com.scwang.smartrefresh.layout.a.g)) {
            return;
        }
        if (this.f19134a) {
            cVar.b(smartRefreshLayout3);
        }
        SmartRefreshLayout smartRefreshLayout4 = this.f19135b;
        com.scwang.smartrefresh.layout.b.c cVar2 = smartRefreshLayout4.mOnMultiPurposeListener;
        com.scwang.smartrefresh.layout.a.g gVar = (com.scwang.smartrefresh.layout.a.g) smartRefreshLayout4.mRefreshHeader;
        int i2 = smartRefreshLayout4.mHeaderHeight;
        cVar2.b(gVar, i2, (int) (smartRefreshLayout4.mHeaderMaxDragRate * i2));
    }
}
