package com.google.android.material.snackbar;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13591a;

    d(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13591a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f13591a.g.setScaleX(fFloatValue);
        this.f13591a.g.setScaleY(fFloatValue);
    }
}
