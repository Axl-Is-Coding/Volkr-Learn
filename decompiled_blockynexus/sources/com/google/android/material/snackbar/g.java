package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13597b;

    g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f13597b = baseTransientBottomBar;
        this.f13596a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13597b.c(this.f13596a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13597b.h.animateContentOut(0, 180);
    }
}
