package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: HideBottomViewOnScrollBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HideBottomViewOnScrollBehavior f13165a;

    a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f13165a = hideBottomViewOnScrollBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13165a.f13155d = null;
    }
}
