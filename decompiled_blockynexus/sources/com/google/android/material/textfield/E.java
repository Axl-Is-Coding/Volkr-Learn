package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: TextInputLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class E implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f13655a;

    E(TextInputLayout textInputLayout) {
        this.f13655a = textInputLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13655a.collapsingTextHelper.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
