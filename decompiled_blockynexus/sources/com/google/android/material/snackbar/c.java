package com.google.android.material.snackbar;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13590a;

    c(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13590a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13590a.g.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
