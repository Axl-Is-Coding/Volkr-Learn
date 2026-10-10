package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13173a;

    a(BottomAppBar bottomAppBar) {
        this.f13173a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        BottomAppBar bottomAppBar = this.f13173a;
        bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, this.f13173a.fabAttached);
    }
}
