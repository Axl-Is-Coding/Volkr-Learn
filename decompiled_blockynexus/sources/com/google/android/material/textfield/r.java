package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13679a;

    r(s sVar) {
        this.f13679a = sVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13679a.f13685c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
