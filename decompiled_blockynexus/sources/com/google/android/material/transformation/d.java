package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f13719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f13720b;

    d(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f13720b = fabTransformationBehavior;
        this.f13719a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13719a.invalidate();
    }
}
