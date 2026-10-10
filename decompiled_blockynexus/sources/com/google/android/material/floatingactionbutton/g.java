package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: ExtendedFloatingActionButton.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f13403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton.c f13404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton f13405d;

    g(ExtendedFloatingActionButton extendedFloatingActionButton, q qVar, ExtendedFloatingActionButton.c cVar) {
        this.f13405d = extendedFloatingActionButton;
        this.f13403b = qVar;
        this.f13404c = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f13402a = true;
        this.f13403b.d();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13403b.onAnimationEnd();
        if (this.f13402a) {
            return;
        }
        this.f13403b.a(this.f13404c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13403b.onAnimationStart(animator);
        this.f13402a = false;
    }
}
