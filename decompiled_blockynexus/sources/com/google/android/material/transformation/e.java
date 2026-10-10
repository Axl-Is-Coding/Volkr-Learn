package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.material.circularreveal.e f13721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Drawable f13722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f13723c;

    e(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.e eVar, Drawable drawable) {
        this.f13723c = fabTransformationBehavior;
        this.f13721a = eVar;
        this.f13722b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13721a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13721a.setCircularRevealOverlayDrawable(this.f13722b);
    }
}
