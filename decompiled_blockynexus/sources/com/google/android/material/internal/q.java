package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: compiled from: TextScale.java */
/* JADX INFO: loaded from: classes2.dex */
class q implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f13481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f13482b;

    q(r rVar, TextView textView) {
        this.f13482b = rVar;
        this.f13481a = textView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f13481a.setScaleX(fFloatValue);
        this.f13481a.setScaleY(fFloatValue);
    }
}
