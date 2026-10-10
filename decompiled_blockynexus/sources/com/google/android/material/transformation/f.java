package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.e;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.material.circularreveal.e f13724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f13725b;

    f(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.e eVar) {
        this.f13725b = fabTransformationBehavior;
        this.f13724a = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e.d revealInfo = this.f13724a.getRevealInfo();
        revealInfo.f13272c = Float.MAX_VALUE;
        this.f13724a.setRevealInfo(revealInfo);
    }
}
