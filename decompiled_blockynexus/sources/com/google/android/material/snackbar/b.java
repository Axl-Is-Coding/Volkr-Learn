package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13589b;

    b(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f13589b = baseTransientBottomBar;
        this.f13588a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13589b.c(this.f13588a);
    }
}
