package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f13226a;

    b(BottomSheetBehavior bottomSheetBehavior) {
        this.f13226a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.f13226a.i != null) {
            this.f13226a.i.c(fFloatValue);
        }
    }
}
