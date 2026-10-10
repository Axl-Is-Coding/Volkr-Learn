package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: FabTransformationScrimBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f13726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f13727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FabTransformationScrimBehavior f13728c;

    g(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
        this.f13728c = fabTransformationScrimBehavior;
        this.f13726a = z;
        this.f13727b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f13726a) {
            return;
        }
        this.f13727b.setVisibility(4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.f13726a) {
            this.f13727b.setVisibility(0);
        }
    }
}
