package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: ExpandableTransformationBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExpandableTransformationBehavior f13714a;

    b(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.f13714a = expandableTransformationBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13714a.f13701b = null;
    }
}
