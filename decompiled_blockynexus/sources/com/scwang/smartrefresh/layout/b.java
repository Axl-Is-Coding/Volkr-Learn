package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f19132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19133b;

    b(SmartRefreshLayout smartRefreshLayout, boolean z) {
        this.f19133b = smartRefreshLayout;
        this.f19132a = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f19133b.setStateDirectLoading(this.f19132a);
    }
}
