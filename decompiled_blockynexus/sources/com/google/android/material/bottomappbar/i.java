package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13186a;

    i(BottomAppBar bottomAppBar) {
        this.f13186a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13186a.fabAnimationListener.onAnimationStart(animator);
        FloatingActionButton floatingActionButtonFindDependentFab = this.f13186a.findDependentFab();
        if (floatingActionButtonFindDependentFab != null) {
            floatingActionButtonFindDependentFab.setTranslationX(this.f13186a.getFabTranslationX());
        }
    }
}
